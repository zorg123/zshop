package com.flyrui.common;

import javax.servlet.http.HttpServletRequest;

/**
 *  从dwr的上下文中取得当前的request信息
 *  
 * @author  Lee
 * @version  [版本号, May 3, 2012]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ContextHelper {
	
	public static String getRequestIp(HttpServletRequest request) {
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
}
