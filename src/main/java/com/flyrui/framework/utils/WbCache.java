package com.flyrui.framework.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.SpringBeans;
import com.flyrui.common.service.CommonService;


public class WbCache {
	public final static String CACHE_CT_CONFIG="CT_CONFIG";
	
	public static Map cacheMap = new HashMap();	
	
	public CommonService commonService;
	
	public final static Logger log = Logger.getLogger(WbCache.class); 
	
	public CommonService getCommonService(){
		return (CommonService)SpringBeans.getBean("commonService");
	}
	
	public  static void initCache(String type){
		WbCache wbCache = new WbCache();
		if("0".equals(type)){
			wbCache.initCtConfig();
		}		
	}
	
	public  void initCtConfig(){
		try{
			List retList = getCommonService().queryFrCfgList();
			if(retList!=null){
				Map m = new HashMap();
				for(int i =0;i<retList.size();i++){
					Map mmm = (Map)retList.get(i);
					m.put(mmm.get("cf_id"), mmm.get("cf_value"));
				}
				cacheMap.put(CACHE_CT_CONFIG, m);			
			}
		}catch(Exception ex){
			log.error("加载配置缓存失败",ex);
		}
	}
	
	public static Object getCache(String cacheCatalog,String key){
		Object o = null;
		if(cacheCatalog != null){
			Map m = (Map)cacheMap.get(cacheCatalog);			
			if(m!=null){
				o = m.get(key);
			}
		}
		return o;
	}
}
