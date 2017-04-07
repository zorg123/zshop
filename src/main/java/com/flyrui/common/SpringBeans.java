package com.flyrui.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeans implements ApplicationContextAware{
	public static ApplicationContext ctx;
	
	/**
	 * spring 自动注册该方法，获取到spring的context
	 * @param context
	 */
	public void setApplicationContext(ApplicationContext context){
		SpringBeans.ctx = context;
	}
	
	public ApplicationContext getApplicationContext(){
		return SpringBeans.ctx;
	}
	
	/**
	 * 
	 * 获取spring中配置的bean
	 * 
	 * @param beanName
	 * @return [返回类型说明]
	 * 
	 * rover lee
	 * Jul 8, 2012
	 */	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		return (T)ctx.getBean(beanName);
	}
}
