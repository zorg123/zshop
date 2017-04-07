package com.flyrui.infoshare.manage.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.manage.pojo.InfoManage;     		

public interface InfoManageService {
		
	
	public int insert(InfoManage infoManage);
	
	public int update(InfoManage infoManage);
	
	public int delete(InfoManage infoManage);
	
	public List<InfoManage> getListByCon(InfoManage infoManage);
	
	public PageModel getPagerListByCon(InfoManage infoManage,int pageNo,int pageSize);	
	
	public int deleteByIds(String ids);
}
