package com.flyrui.salary.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalaryBase;
import com.flyrui.dao.pojo.salary.BusSalaryExtend;

public interface BusSalaryExtendService {
		
	
	public int insert(BusSalaryExtend busSalaryExtend);
	
	public int update(BusSalaryExtend busSalaryExtend);
	
	public int delete(BusSalaryExtend busSalaryExtend);
	
	public List<BusSalaryExtend> getListByCon(BusSalaryExtend busSalaryExtend);
	
	public PageModel<BusSalaryExtend> getPagerListByCon(BusSalaryExtend busSalaryExtend,int pageNo,int pageSize);
	
	public List<BusSalaryExtend> getListByBatchSalaryId(List<BusSalaryBase> busSalaryBaseList);
	
	public int batchInsert(List<BusSalaryExtend> BusSalaryExtend);
}
