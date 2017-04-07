package com.flyrui.salary.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.salary.BusSalaryBase;
import com.flyrui.dao.pojo.salary.BusSalaryExtend;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.salary.service.BusSalaryExtendService;


@Service(value="busSalaryExtendServiceImpl")
public class BusSalaryExtendServiceImpl extends BaseService<BusSalaryExtend> implements BusSalaryExtendService {	
	public BusSalaryExtendServiceImpl(){
		super.setNameSpace("com.flyrui.dao.mapper.BusSalaryExtendMapper");
	}
	public List<BusSalaryExtend> getListByBatchSalaryId(List<BusSalaryBase> busSalaryBaseList){
		return super.queryById("querySalaryExtendByIds", busSalaryBaseList);
	}
}
