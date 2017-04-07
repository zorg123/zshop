package com.flyrui.bus.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.bus.BusData;
import com.flyrui.dao.pojo.bus.BusInfo;
import com.flyrui.dao.pojo.bus.BusRule;
import com.flyrui.dao.pojo.bus.BusTemplate;
import com.flyrui.dao.pojo.bus.BusTemplateItem;
import com.flyrui.dao.pojo.salary.BusSalary;

public interface BusService {
	
	public List<BusTemplateItem> queryBusTemplateItem(BusTemplateItem busTemplateItem);
	
	public List<BusRule> queryBusRule(BusRule busRule);
	
	public List<BusInfo> queryBusInfo(BusInfo busInfo);
	
	public List<BusTemplate> queryBusTemplate(BusTemplate busTemplate);
	
	public int insert(BusData busData);
	
	public int update(BusData busData);
	
	public int delete(BusData busData);
	
	public List<BusData> getListByCon(BusData busData);
	
	public PageModel getPagerListByCon(BusData busData,int pageNo,int pageSize);		
	
	public int deleteByBatch(BusData busData);	
	
	public int deleteByids(String ids);	
}
