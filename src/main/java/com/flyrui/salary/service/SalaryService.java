package com.flyrui.salary.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryLevel;

public interface SalaryService {
	
	public int insert(BusSalary busSalary);
	
	public int update(BusSalary busSalary);
	
	public int delete(BusSalary busSalary);
	
	public List<BusSalary> getListByCon(BusSalary busSalary);
	
	public PageModel getPagerListByCon(BusSalary busSalary,int pageNo,int pageSize);	
	
	public int deleteByBatch(BusSalary busSalary);	
	
	public int deleteByids(String ids);	
	
	public List<BusSalary> getSumListByCon(BusSalary busSalary);
	
	public PageModel getLevelPagerListByCon(BusSalary busSalary,int pageNo,int pageSize);
	
	public List<BusSalaryLevel> getLevleListByCon(BusSalary busSalary);
	
}
