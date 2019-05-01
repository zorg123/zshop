package com.flyrui.framework.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {
		private static final Logger log = Logger.getLogger(ApplicationEventListener.class);	

	  @Override
	  public void onApplicationEvent(ApplicationEvent event) {
	    if (event instanceof ContextRefreshedEvent) {
	      ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
	      log.info("加载完毕");
	    }	   
	  }
	}
