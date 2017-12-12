package com.flyrui.framework.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)      
public @interface DynaimcDataSourceName {   
    
	/**
	 * 名字
	 * 
	 * @return
	 */
    public String name();   
} 
