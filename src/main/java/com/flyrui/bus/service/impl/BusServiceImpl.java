package com.flyrui.bus.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.bus.service.BusService;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.bus.BusData;
import com.flyrui.dao.pojo.bus.BusInfo;
import com.flyrui.dao.pojo.bus.BusRule;
import com.flyrui.dao.pojo.bus.BusTemplate;
import com.flyrui.dao.pojo.bus.BusTemplateItem;

@Service(value="busService")
public class BusServiceImpl extends BaseService<BusData> implements BusService {	
	public BusServiceImpl(){
		super.setNameSpace("com.flyrui.dao.mapper.BusDataMapper");
	}

	public int deleteByBatch(BusData busData){		  
		   return baseDao.delete(nameSpace+".delete", busData);
	}
	
	public int deleteByids(String ids) {
		   int retV = 0;
			if(ids != null ){		
				String[] idArr = ids.split(",");
				if(idArr.length >0){
					BusData b = null;
					for(String id : idArr){
						b= new BusData();
						b.setData_id(id);
						delete(b);
						retV++;
					}
				}
			}
			return retV;
	}
	
	public List<BusTemplateItem> queryBusTemplateItem(BusTemplateItem busTemplateItem) {		
		return baseDao.selectList(getNameSpace()+".queryBusTemplateItem", busTemplateItem);
	}

	public List<BusInfo> queryBusInfo(BusInfo busInfo) {
		return baseDao.selectList(getNameSpace()+".queryBusInfo", busInfo);
	}

	public List<BusRule> queryBusRule(BusRule busRule) {
		return baseDao.selectList(getNameSpace()+".queryBusRule", busRule);
	}

	public List<BusTemplate> queryBusTemplate(BusTemplate busTemplate) {
		return baseDao.selectList(getNameSpace()+".queryBusTemplate", busTemplate);
	}
	
	

}
