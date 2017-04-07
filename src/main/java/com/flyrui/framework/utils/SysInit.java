package com.flyrui.framework.utils;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInit extends HttpServlet {		
	
	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 6550391789368957000L;

	public void init(ServletConfig config) throws ServletException {		
		WbCache.initCache("0");
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String type = request.getParameter("type");
		WbCache.initCache(type);
		PrintWriter pr = response.getWriter();
		pr.println("init success");
		pr.flush();
	}
}
