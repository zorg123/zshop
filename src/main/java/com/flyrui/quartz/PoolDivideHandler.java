package com.flyrui.quartz;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.flyrui.common.service.CommonService;

@Component
@EnableScheduling
public class PoolDivideHandler {

	@Autowired
	public CommonService commonService;
	
	//2级分红池平分周末执行
	@Scheduled(cron = "59 59 23 ? * SUN")
	public void grade2(){
		//2级分红池
		Map map = new HashMap();
		map.put("in_grade", 2);
		commonService.execProc(map);
	}
	
	//3级分红池平分周末执行
	@Scheduled(cron = "59 59 23 ? * SUN")
	public void grade3(){
		Map map = new HashMap();
		map.put("in_grade", 3);
		commonService.execProc(map);
	}
	
	//4级分红池平分周末执行
	@Scheduled(cron = "59 59 23 ? * SUN")
	public void grade4(){
		Map map = new HashMap();
		map.put("in_grade", 4);
		commonService.execProc(map);
	} 
	
	/*
	//5级分红池平分月末执行
	@Scheduled(cron = "59 59 23 L * ?")
	public void grade5(){
		Map map = new HashMap();
		map.put("in_grade", 4);
		commonService.execProc(map);
	} 
	
	//6级分红池平分月末执行
	@Scheduled(cron = "59 59 23 L * ?")
	public void grade6(){
		Map map = new HashMap();
		map.put("in_grade", 6);
		commonService.execProc(map);
	}*/
}