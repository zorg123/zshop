package com.flyrui.framework.struts.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class ExceptionInterceptor extends AbstractInterceptor {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = -8046153573157978624L;
	private static Logger log = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String actionName = invocation.getInvocationContext().getName();
		String methodName = invocation.getProxy().getMethod();
		try{
			String result = invocation.invoke();
			return result;
		}catch(Exception ex){
			log.error(actionName+"/"+methodName+"发生异常",ex);
			ValueStack stack = invocation.getStack();
			Object o = stack.findValue("result");
			if(Map.class.isAssignableFrom(o.getClass())){
				Map result = (Map)o;
				if(ex instanceof FRException){
					FRException frEx = (FRException)ex;
					result.put("_code", frEx.getError().getErrorCode());
					result.put("_msg", frEx.getError().getErrorMessage());
				}else{
					result.put("_code", ErrorConstants.COMMON_SYSTEM_ERROR);
					result.put("_msg", ex.getMessage());
				}
			}
			return "error";
		}
	}
}
