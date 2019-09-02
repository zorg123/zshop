package com.flyrui.quartz;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.CommonService;

@Component
@EnableScheduling
public class PoolDivideHandler {

	@Autowired
	public CommonService commonService;
	
	//2级分红池平分周末执行
	//@Scheduled(cron = "59 59 23 ? * SUN")
	//@Transactional
	//public void grade2(){
		//2级分红池
		//Map map = new HashMap();
		//map.put("in_grade", 2);
		//commonService.execProc(map);
	//}
	
	//3级分红池平分周末执行
	@Scheduled(cron = "59 59 23 ? * SUN")
	@Transactional
	public void grade3(){
		Map map = new HashMap();
		map.put("in_grade", 3);
		commonService.execProc(map);
	}
	
	//4级分红池平分周末执行
	@Scheduled(cron = "59 59 23 ? * SUN")
	@Transactional
	public void grade4(){
		Map map = new HashMap();
		map.put("in_grade", 4);
		commonService.execProc(map);
	}
	
	//5级分红池平分下月初执行
	@Scheduled(cron = "0 0 0 1 * ?")
	@Transactional
	public void grade5(){
		Map map = new HashMap();
		map.put("in_grade", 5);
		commonService.execProc(map);
	} 
	
	//6级分红池平分下月初执行
	@Scheduled(cron = "0 0 0 1 * ?")
	@Transactional
	public void grade6(){
		Map map = new HashMap();
		map.put("in_grade", 6);
		commonService.execProc(map);
	}
	
	//每天凌晨1点
	@Scheduled(cron = "0 0 1 * * ?")
	@Transactional
	public void shareoutQuaAll(){
		commonService.execProcShareout();
	}
}