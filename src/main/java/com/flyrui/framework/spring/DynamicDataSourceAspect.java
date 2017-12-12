package com.flyrui.framework.spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.flyrui.framework.annotation.DynaimcDataSourceName;
  

public class DynamicDataSourceAspect {  
	private static final Logger log = Logger.getLogger(CustomContextHolder.class);
	
    //@Pointcut("execution (public * com.flyrui..*.*impl..*(..))")
	//@Pointcut(value = "execution(public * com.flyrui.*.service.impl.*impl.*(..))")
	@Pointcut(value = "execution (public * com.flyrui..*.*(..))&&@target(com.flyrui.framework.annotation.DynaimcDataSourceName)")
    public void serviceExecution(){}  
      
    @Before("serviceExecution()")  
    public void setDynamicDataSource(JoinPoint jp) {
    	//在类上找
    	DynaimcDataSourceName dynaimcDataSourceName = jp.getTarget().getClass().getAnnotation(DynaimcDataSourceName.class);
    	if (dynaimcDataSourceName == null) {
    		//在方法上找
    		String methodName = jp.getSignature().getName();
    		try {
    			dynaimcDataSourceName = jp.getTarget().getClass().getMethod(methodName).getAnnotation(DynaimcDataSourceName.class);
			} catch (NoSuchMethodException e) {
				log.error("切片查询方法出错",e);
			} catch (SecurityException e) {
				log.error("切片查询方法出错",e);
			}
    	}
    	if (dynaimcDataSourceName != null) {
    		//如果检测到需要切换，则进行处理
    		CustomContextHolder.setCustomType(dynaimcDataSourceName.name());
    	}    	
    }  
}
