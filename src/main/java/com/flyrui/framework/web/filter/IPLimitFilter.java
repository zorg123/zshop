package com.flyrui.framework.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.flyrui.common.ContextHelper;
import com.flyrui.exception.FRException;
import com.flyrui.framework.utils.WbCache;
import com.flyrui.framework.web.filter.vo.PageLogVO;
/**
 * @author Reason.Yea
 * @version Created Jul 6, 2012
 */
/*
	--insert service
	INSERT INTO fr_config (cf_id, cf_desc, cf_value, create_time) VALUES 
	('IP_BLACKLIST', '网站访问黑名单', '', '2014-12-19 00:25:55');
	
	<filter>
		<filter-name>IPLimitFilter</filter-name>
		<filter-class>com.flyrui.framework.web.filter.IPLimitFilter</filter-class>	
		<init-param>
			<param-name>forwardPage</param-name>
			<param-value>
				/public/48.jsp
			</param-value>
		</init-param>	
	</filter>	
	<filter-mapping>
		<filter-name>IPLimitFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
 */
public class IPLimitFilter implements Filter {	
	private FilterConfig filterConfig;
	private Logger logger = Logger.getLogger(IPLimitFilter.class);
	private static String [] ipBlackArr ;
	private String errorJsp;
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String ipBlackListStr = (String)WbCache.getCache(WbCache.CACHE_CT_CONFIG, "IP_BLACKLIST");;
    	if(ipBlackListStr !=null &&!"".equals(ipBlackListStr)){
    		ipBlackArr=ipBlackListStr.split(",");
    	}
    	
    	String vistUrl= request.getRequestURI();
		if(ipBlackArr!=null && ipBlackArr.length >0 && !vistUrl.equals(this.errorJsp) && !vistUrl.equals("/SysInit")){
			try{
				String ip =  getRequestIp(request);
				if(checkBlackList(ip)){
					request.getRequestDispatcher(this.errorJsp).forward(request, response);
				}else{
					chain.doFilter(request, response);
				}				
			}catch (Exception e) {
				logger.error("判断IP黑名单出错", e);
				chain.doFilter(request, response);
			}
			
		}else{
			chain.doFilter(request, response);
		}
	}
	
	public void init(FilterConfig arg0) throws ServletException {	
		this.filterConfig = arg0;
		String forwardPage = this.filterConfig.getInitParameter("forwardPage");
    	if(!forwardPage.equals("")){
    		this.errorJsp=forwardPage;
    	}		
	}
	
	/**
	 * 
	 * 检查是否在黑名单中
	 * 
	 * @param ip
	 * @return [返回类型说明]
	 * 
	 * rover.lee
	 * Dec 19, 2014
	 */
	private boolean checkBlackList(String ip){
		boolean checkFlag = false;
		for(String bIp :ipBlackArr){
			if(bIp.equals(ip)){
				checkFlag = true;
				break;
			}
		}
		
		return checkFlag;
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
	
	public void destroy() {
		
	}
}
