package com.flyrui.salary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryBase;
import com.flyrui.dao.pojo.salary.BusSalaryExtend;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.salary.service.BusSalaryBaseService;
import com.flyrui.salary.service.BusSalaryExtendService;


@Service(value="busSalaryBaseServiceImpl")
public class BusSalaryBaseServiceImpl extends BaseService<BusSalaryBase> implements BusSalaryBaseService {	
	
	@Autowired
	BusSalaryExtendService busSalaryExtendService;
	
	public BusSalaryBaseServiceImpl(){
		super.setNameSpace("com.flyrui.dao.mapper.BusSalaryBaseMapper");
	}
	
	@Transactional
	public int batchInsert(List<BusSalaryBase> busSalaryList){
		int cnt = super.batchInsert(busSalaryList);
		List<BusSalaryExtend> batchBusSalaryExtendList = new ArrayList<BusSalaryExtend>();
		for(BusSalaryBase busSalaryBase : busSalaryList){  
			batchBusSalaryExtendList.addAll(busSalaryBase.getBusSalaryExtendList());
		}
		busSalaryExtendService.batchInsert(batchBusSalaryExtendList);
		return cnt;
	}
	
	@Transactional
	public int deleteByBatch(BusSalaryBase busSalaryBase){		
		int cnt = super.delete(busSalaryBase);
		BusSalaryExtend bse = new BusSalaryExtend();
		bse.setBatch_id(busSalaryBase.getBatch_id());
		busSalaryExtendService.delete(bse);
		return cnt;
	}
	
	@Transactional
	public int deleteByIds(String ids){
		int retV = 0;
		if(ids != null ){		
			String[] idArr = ids.split(",");
			if(idArr.length >0){
				BusSalaryBase b = null;
				for(String id : idArr){
					b= new BusSalaryBase();
					b.setSalary_id(id);
					super.delete(b);
					BusSalaryExtend bse = new BusSalaryExtend();
					bse.setSalary_id(b.getSalary_id());
					busSalaryExtendService.delete(bse);
					retV++;
				}
			}
		}
		return retV;		
	}
}
