package com.flyrui.framework.web.filter.xss;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;



/**
 * @describe request信息封装类，用于判断、处理request请求中特殊字符
 */
public class XSSHttpRequestWrapper extends HttpServletRequestWrapper {
	
	private Map<Pattern, String> replaceMap = new HashMap<Pattern, String>();
	
	/**
	 * 封装http请求
	 * @param request
	 */
	public XSSHttpRequestWrapper(HttpServletRequest request) {
		super(request);
		replaceMap.put(Pattern.compile("\""), "&quot;");
		replaceMap.put(Pattern.compile("\'"), "&#39;");	
		replaceMap.put(Pattern.compile("<"), "&lt;");
		replaceMap.put(Pattern.compile(">"), "&gt;");
		replaceMap.put(Pattern.compile("(\r\n|\r|\n|\n\r)"), "");
	}
	
	public String getHeader(String name) {
		String value = super.getHeader(name);
		// 若开启特殊字符替换，对特殊字符进行替换
		if(value !=null){
			value = repalceParameterValue(value);	
		}
		return value;
	}

	public String getParameter(String name) {
		String value = super.getParameter(name);
		// 若开启特殊字符替换，对特殊字符进行替换
		if(value !=null){
			value = repalceParameterValue(value);	
		}
		return value;
	}
	
	public String[] getParameterValues(String name) {   
		String[] v = super.getParameterValues(name);   
		if(v==null){   
			return null;   
		}
		String[] retV = v.clone();
		for( int i = 0 ; i <retV.length ; i++ ){
			String submitValue = retV[i] ;
			if(submitValue !=null){					
				retV[i]=repalceParameterValue(submitValue);
			}
		}
		return retV;
	} 

	/**
	 * 没有违规的数据，就返回false;
	 * 
	 * @return
	 */
	private boolean checkHeader(){
		Enumeration headerParams = this.getHeaderNames();
		while(headerParams.hasMoreElements()){
			String headerName =(String) headerParams.nextElement();
			String headerValue = this.getHeader(headerName);
			if(XSSSecurityManager.matches(headerValue)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 没有违规的数据，就返回false;
	 * 
	 * @return
	 */
	private boolean checkParameter(){
		Map submitParams = this.getParameterMap();
		Set submitNames = submitParams.keySet();
		for(Iterator it = submitNames.iterator() ; it.hasNext() ;){
			 String submitName  =(String) it.next() ;
			Object submitValues = submitParams.get(submitName);
			if(XSSSecurityManager.matches(submitName)){
				return true;
			}
			if(submitValues instanceof String){
				if(XSSSecurityManager.matches((String)submitValues)){
					return true;
				}
			}else if(submitValues instanceof String[]){
				String[] tempValues = (String[])submitValues ;
				for( int i = 0 ; i <tempValues.length ; i++ ){
					 String submitValue = tempValues[ i] ;
					if(XSSSecurityManager.matches((String)submitValue)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
   
    /**
     * 没有违规的数据，就返回false;
     * 若存在违规数据，根据配置信息判断是否跳转到错误页面
     * @param response
     * @return
     * @throws IOException 
     * @throws ServletException 
     */
    public boolean validateParameter(HttpServletResponse response) throws ServletException, IOException{
    	// 开始header校验，对header信息进行校验
    	if(XSSSecurityConfig.IS_CHECK_HEADER){
	    	if(this.checkHeader()){
	    		return true;
	    	}
    	}
    	// 开始parameter校验，对parameter信息进行校验
    	if(XSSSecurityConfig.IS_CHECK_PARAMETER){
	    	if(this.checkParameter()){
	    		return true;
	    	}
    	}
    	return false;
    }
    
	public boolean checkRequestStream(Map map) {
		// Look for parameters to this method
        for (Iterator it = map.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            String data = (String) entry.getValue();
            if (XSSSecurityManager.matches(key) || XSSSecurityManager.matches(data)) {
				return true;
			}
            
        }
		return false;
		
	}
	
	
	/**
	 * 
	 * 按表达式替换
	 * 
	 * @param paramValue
	 * @return [返回类型说明]
	 * 
	 * rover.lee
	 * Nov 26, 2014
	 */
	private String repalceParameterValue(String paramValue){
	    	Iterator iter = replaceMap.keySet().iterator();
	    	String newValue = paramValue;
	    	while(iter.hasNext()){
	    		Pattern p = (Pattern)iter.next();
	    		Matcher m = p.matcher(newValue);
	    		if(m.find()){
	    			newValue = m.replaceAll((String)replaceMap.get(p));
	    		}
	    	}
	    	return newValue;
	    }
	
}

