package com.flyrui.framework.spring;

import org.apache.log4j.Logger;

public class CustomContextHolder {  
	  
	private static final Logger log = Logger.getLogger(CustomContextHolder.class);
      
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
      
    public static void setCustomType(String customType) {  
        contextHolder.set(customType);  
    }  
      
    public static String getCustomType() {
        return contextHolder.get();  
    }  
      
    public static void clearCustomType() {  
        contextHolder.remove();  
    }  
}  
