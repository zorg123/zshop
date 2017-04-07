package com.flyrui.framework.annotation;
import java.lang.annotation.ElementType;   
import java.lang.annotation.Retention;   
import java.lang.annotation.RetentionPolicy;   
import java.lang.annotation.Target;  

@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.METHOD)   
public @interface SessionCheckAnnotation {   
    
	/**
	 * 	 
	 * 为false时不做校验
	 * 
	 * rover.lee
	 * Sep 20, 2014
	 */
    public String needCheckSession();   
} 
