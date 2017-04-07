package com.flyrui.salary.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalaryBase;     		

public interface BusSalaryBaseService {
		
	
	public int insert(BusSalaryBase busSalaryBase);
	
	public int update(BusSalaryBase busSalaryBase);
	
	public int delete(BusSalaryBase busSalaryBase);
	
	public List<BusSalaryBase> getListByCon(BusSalaryBase busSalaryBase);
	
	public PageModel<BusSalaryBase> getPagerListByCon(BusSalaryBase busSalaryBase,int pageNo,int pageSize);	
	
	public int batchInsert(List<BusSalaryBase> busSalaryBase);
	
	public int deleteByBatch(BusSalaryBase busSalaryBase);
	
	public int deleteByIds(String ids);
}
