package com.flyrui.financMgmt.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;

public interface AccoutInfoService {
	
	public int insert(AccoutInfoDto accoutInfo);
	
	public int update(AccoutInfoDto accoutInfo);
	
	public int delete(AccoutInfoDto accoutInfo);
	
	public List<AccoutInfoDto> getListByCon(AccoutInfoDto accoutInfo);
	
	public PageModel getPagerListByCon(AccoutInfoDto accoutInfo,int pageNo,int pageSize);
	
	public AccoutInfoDto queryAccountInfo(AccoutInfoDto accoutInfo);
}
