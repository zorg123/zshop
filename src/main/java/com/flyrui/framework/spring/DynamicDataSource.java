package com.flyrui.framework.spring;


import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{  
	private static final Logger log = Logger.getLogger(DynamicDataSource.class);
    @Override  
    protected Object determineCurrentLookupKey() { 
    	String dataSource = CustomContextHolder.getCustomType();
    	if(dataSource==null){
        	log.info("当前使用默认数据源");
    	}else{
    		log.info("当前使用的数据源是:"+dataSource); 
    	}
        return dataSource;  
    }
}  