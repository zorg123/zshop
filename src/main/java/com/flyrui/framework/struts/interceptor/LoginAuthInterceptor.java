package com.flyrui.framework.struts.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;

import com.flyrui.common.SpringBeans;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.framework.annotation.SessionCheckAnnotation;
import com.flyrui.framework.spring.CustomContextHolder;
import com.flyrui.sys.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginAuthInterceptor extends AbstractInterceptor {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = -8046153573157978624L;
	private static Logger log = Logger.getLogger(LoginAuthInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();		
		String method = invocation.getProxy().getMethod();
		Method m = invocation.getAction().getClass().getDeclaredMethod(method);
		Action action = (Action)invocation.getAction();
		//检查方法是否需要判断session登陆
		boolean isNeed = true;//默认要校验
		//for(Method m : ms){
			if(m.getName().equals(method)){
				SessionCheckAnnotation sessionCheck = m.getAnnotation(SessionCheckAnnotation.class);
				if(sessionCheck!=null){
					if("false".equals(sessionCheck.needCheckSession())){
						isNeed = false;
					}
				}
			}
		//}
		
		//设置多个数据源的dataSource
		DynaimcDataSourceName dynaimcDataSourceName = invocation.getAction().getClass().getAnnotation(DynaimcDataSourceName.class);
		if(dynaimcDataSourceName!=null){
			if(dynaimcDataSourceName.name()!=null && !"".equals(dynaimcDataSourceName.name())){
				CustomContextHolder.setCustomType(dynaimcDataSourceName.name());
			}
		}
		
		String actionName = ctx.getName();
		Map<String,Object> session = ctx.getSession();
		Object user = session.get("user");
		if(user == null){
			HttpSession s = ServletActionContext.getRequest().getSession();
			Assertion assertion = (Assertion) s.getAttribute("_const_cas_assertion_");
			//从单点过来的用户，直接
			if(assertion!=null){
				AttributePrincipal principal =assertion.getPrincipal();
				String name = principal.getName();
				Map<String, Object> attributes = principal.getAttributes();
				String account = (String)attributes.get("account");
				if(account==null || "".equals(account)){
					account = name;
				}
				String userId = (String)attributes.get("id");
				String bankAccount = (String)attributes.get("bank_account");
				User tUser = new User();
				tUser.setUser_id(userId);
				tUser.setUser_code(account);
				tUser.setBank_account(bankAccount);
				s.setAttribute("user", tUser);
				user = tUser;
			}
			
		}
		
		Object sararyUser = session.get("sararyUser");
		if(sararyUser == null){
			HttpSession s = ServletActionContext.getRequest().getSession();
			Assertion assertion = (Assertion) s.getAttribute("_const_cas_assertion_");
			//从单点过来的用户，直接
			if(assertion!=null){
				AttributePrincipal principal =assertion.getPrincipal();
				Map<String, Object> attributes = principal.getAttributes();
				String name = principal.getName();
				String account = (String)attributes.get("account");	
				if(account==null || "".equals(account)){
					account = name;
				}
				if(action instanceof com.flyrui.salary.action.SalaryAction || action instanceof com.flyrui.bus.action.BusAction || action instanceof com.flyrui.salary.action.SalaryBaseAction){
					LoginService loginService = (LoginService)SpringBeans.getBean("loginService");
					Map param = new HashMap();
					param.put("cas_account",account);
					User salaryUser = loginService.queryUserByCasAccount(param);
					s.setAttribute("sararyUser", salaryUser);
				}				
			}			
		}
		
		//validateLogin
		if(user!=null || !isNeed|| "validateLogin".equals(method) || "loginOut".equals(method)){
			String retunStr ="";
			try{
				retunStr = invocation.invoke();
			}finally{
				CustomContextHolder.clearCustomType();
			}
			return retunStr;
		}else{
			throw new FRException(new FRError(ErrorConstants.SYS_USER_NO_LOGIN));
		}		
	}
}
