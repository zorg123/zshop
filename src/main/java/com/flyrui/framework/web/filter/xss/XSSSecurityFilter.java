package com.flyrui.framework.web.filter.xss;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * @author winnie
 * @date 
 * @describe 安全信息审核类
 */
public class XSSSecurityFilter implements Filter{

	private static Logger logger = Logger.getLogger(XSSSecurityFilter.class);
	private String ErrorJsp = "";
	/**
	 * 销毁操作
	 */
	public void destroy() {
		logger.info("XSSSecurityFilter destroy() begin");
		XSSSecurityManager.destroy();
		logger.info("XSSSecurityFilter destroy() end");
	}

	/**
	 * 安全审核
	 * 读取配置信息
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 判断是否使用HTTP
        checkRequestResponse(request, response);
        // 转型
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(!(httpRequest instanceof XSSHttpRequestWrapper)){
        	// http信息封装类
        	XSSHttpRequestWrapper xssRequest = new XSSHttpRequestWrapper(httpRequest);

        	// 对request信息进行封装并进行校验工作，若校验失败（含非法字符），根据配置信息进行日志记录和请求中断处理
        	if(xssRequest.validateParameter(httpResponse)){        		
        		if(XSSSecurityConfig.IS_CHAIN){
        			xssRequest.getRequestDispatcher(this.ErrorJsp).forward(xssRequest, httpResponse);
        			return;
        		}
        	}
        	chain.doFilter(xssRequest, response);
        }else{
        	chain.doFilter(httpRequest, response);
        }
        
	}

	/**
	 * 初始化操作
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		XSSSecurityManager.init(filterConfig);
		this.ErrorJsp = filterConfig.getInitParameter("errorJsp");
	}

	/**
     * 判断Request ,Response 类型
     * @param request
     *            ServletRequest
     * @param response
     *            ServletResponse
     * @throws ServletException 
     */
    private void checkRequestResponse(ServletRequest request,
            ServletResponse response) throws ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException("Can only process HttpServletRequest");

        }
        if (!(response instanceof HttpServletResponse)) {
            throw new ServletException("Can only process HttpServletResponse");
        }
    }
}
