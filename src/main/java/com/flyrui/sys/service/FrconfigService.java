package com.flyrui.sys.service;

import java.util.HashMap;
import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.sys.dto.FrConfig;

public interface FrconfigService {
		
	
	public int insert(FrConfig frConfig);
	
	public int update(FrConfig frConfig);
	
	public int delete(FrConfig frConfig);
	
	public List<FrConfig> getListByCon(FrConfig frConfig);
	
	public PageModel getPagerListByCon(FrConfig frConfig,int pageNo,int pageSize);	
	
	public int updateFrConfig(HashMap map) ;
	
	public List<HashMap> queryFrCfgList(HashMap map);	
}
