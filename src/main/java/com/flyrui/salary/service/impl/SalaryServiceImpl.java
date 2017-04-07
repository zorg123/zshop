package com.flyrui.salary.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryCriteria;
import com.flyrui.dao.pojo.salary.BusSalaryLevel;
import com.flyrui.dao.pojo.salary.BusSalaryCriteria.Criteria;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.salary.service.SalaryService;

@Service(value="salaryService")
public class SalaryServiceImpl extends BaseService<BusSalary> implements SalaryService {	
   public SalaryServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.BusSalary");
   }
     
   public int deleteByBatch(BusSalary busSalary){
	   BusSalaryCriteria busSalaryCriteria = new BusSalaryCriteria();
	   Criteria criteria = busSalaryCriteria.createCriteria();
	   criteria.andBatch_idEqualTo(busSalary.getBatch_id());
	   return baseDao.delete(nameSpace+".deleteByCriteria", busSalaryCriteria);
   }

   public List<BusSalary> getSumListByCon(BusSalary busSalary){
	   return baseDao.selectList(getNameSpace()+".selectSum",busSalary);
   }
   public int deleteByids(String ids) {
	   int retV = 0;
		if(ids != null ){		
			String[] idArr = ids.split(",");
			if(idArr.length >0){
				BusSalary b = null;
				for(String id : idArr){
					b= new BusSalary();
					b.setSalary_id(id);
					delete(b);
					retV++;
				}
			}
		}
		return retV;
   }
   public PageModel getLevelPagerListByCon(BusSalary busSalary,int pageNo,int pageSize){
	   return getPagerList(busSalary,getNameSpace()+".selectSumLevel",pageNo,pageSize);
   }
   public List<BusSalaryLevel> getLevleListByCon(BusSalary busSalary){
	   return baseDao.selectList(getNameSpace()+".selectSumLevel", busSalary);	
   }	
}
