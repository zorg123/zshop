package com.flyrui.common.action;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.flyrui.common.bean.ParamBean;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 111111111111111L;
	public Map result = new HashMap() ;
	public Object resultO ;
	public ParamBean paramBean;
	
	public InputStream inputStream;
	
	public String excelName;
	
	public String actionType;
	/**
	 * 公共参数
	 */
	public Map param;
	
	public HttpServletRequest getHttpReqeust(){		 
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getHttpResponse(){		 
		return ServletActionContext.getResponse();
	}
	
	public HttpSession getHttpSession(){		 
		return getHttpReqeust().getSession();
	}
	
	public Object getSessionAttribute(String name){		 
		return getHttpSession().getAttribute(name);
	}
	
	public String getParameterName(String parameterName){
		return getHttpReqeust().getParameter(parameterName);
	}
	
	/**
	 * 
	 * 获取当前请求session中的登录用户信息
	 * 
	 * @return User 当前用户的信息对象
	 * 
	 * rover.lee
	 * Aug 3, 2012
	 */
	public User getLoginUserInfo(){
		return (User)getSessionAttribute("user");
	}
	
	/**
	 * 
	 * 获取当前登录用户的角色
	 * 目前只取一个角色
	 * @return TbRole 角色对象
	 * 
	 * rover.lee
	 * Aug 3, 2012
	 */
	public List<TbRole> getUserRole(User user){		
		List<TbRole> retTbRole = null;
		if(user !=null ){
			List<TbRole> roleList = user.getRoleList();
			//if(roleList.size()>0){
			//	retTbRole = roleList.get(0);
			//}
			retTbRole = roleList;
		}
		return retTbRole;		
	}
	
	public void setResult(Object o){
		result.put("ret",o);
		setCommonSuccessReturn();
	}
	
	public Object getResult(){
		return result;
	}
	
	public void setParam(Map param){
		this.param = param;
	}
	public Map getParam(){
		return param;
	}
	
	
	/**
	 * 获取线程IP
	 * @return
	 */
	public  String getIp(){
		HttpServletRequest request = getHttpReqeust();
		return getRequestIp(request);
		
	}
	public  String getRequestIp(HttpServletRequest request) {
		// 取IP地址
		String vIP = request.getHeader("x-forwarded-for");
		if (vIP == null || vIP.length() == 0|| "unknown".equalsIgnoreCase(vIP)) {
			vIP = request.getHeader("X-Forwarded-For");
		}
		if (vIP == null || vIP.length() == 0|| "unknown".equalsIgnoreCase(vIP)) {
			vIP = request.getHeader("Proxy-Client-IP");
		}
		if (vIP == null || vIP.length() == 0|| "unknown".equalsIgnoreCase(vIP)) {
			vIP = request.getHeader("WL-Proxy-Client-IP");
		}
		if (vIP == null || vIP.length() == 0|| "unknown".equalsIgnoreCase(vIP)) {
			vIP = request.getRemoteAddr();
		}
		return vIP;
	}
	
	public void setCommonSuccessReturn(){
		Map retMap = new HashMap();
		retMap.put("_code", "0");
		retMap.put("_msg", "成功");
		result.putAll(retMap);
	}
	
	
	public String getUserId(){
		User user = getLoginUserInfo();
		String userId = "";
		if( user !=null ){
			userId = user.getUser_id();
		}		
		return userId;
	}
	//如果是子帐号，那么返回主帐号ID；如果是主帐号，返回主帐号ID
	public String getMainUserId(){
		User user = getLoginUserInfo();
		String userId = "";
		if( user !=null ){
			if(user.getUser_type().equals("child")){
				return user.getPid();
			}
			userId = user.getUser_id();
		}		
		return userId;
	}
	
	public String getUserCode(){
		User user = getLoginUserInfo();
		String userCode = "";
		if( user !=null ){
			if("BUS".equals(actionType)){
				user = (User)getSessionAttribute("sararyUser");
				userCode = user.getId_card();
			}else if("BANK".equals(actionType)){
				user = (User)getSessionAttribute("sararyUser");
				userCode = user.getBank_account();
			}else if("SALARY".equals(actionType)){
				User salaryUser = (User)getSessionAttribute("sararyUser");
				if(salaryUser!=null){
					user = salaryUser;
				}
				userCode = user.getUser_code();
			}else{
				userCode = user.getUser_code();
			}
		}
		if(userCode==null || "".equals(userCode)){
			userCode="XXXXXXXXXXXXXX";
		}
		return userCode;
	}
	
	public void setParamBean(ParamBean paramBean){
		this.paramBean = paramBean;
	}
	
	public ParamBean getParamBean(){
		return this.paramBean;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getExcelName() {
		try{
			excelName = new String(excelName.getBytes("GBK"), "ISO_8859_1");//ISO_8859_1
		}catch(Exception ex){
			
		}
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}
	
	public void setResult(String key,Object o){
		this.result.put(key, o);
	}
	
	public Map getHttpRequestParam(){		
		Map<String,String> retMap = new HashMap<String,String>();
		Map<String,String[]> param = getHttpReqeust().getParameterMap();
		Set<Entry<String, String[]>> set = param.entrySet();  
        Iterator<Entry<String, String[]>> it = set.iterator();  
        while (it.hasNext()) {  
            Entry<String, String[]> entry = it.next(); 
            for (String str : entry.getValue()) {  
                                 retMap.put(entry.getKey(), str);
            } 
        }
        return retMap;
	}
}
