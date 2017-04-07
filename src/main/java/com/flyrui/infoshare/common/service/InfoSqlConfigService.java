package com.flyrui.infoshare.common.service;

import java.util.List;
import java.util.Map;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.common.pojo.InfoSqlConfig;

public interface InfoSqlConfigService {
		
	
	public int insert(InfoSqlConfig infoSqlConfig);
	
	public int update(InfoSqlConfig infoSqlConfig);
	
	public int delete(InfoSqlConfig infoSqlConfig);
	
	public List<InfoSqlConfig> getListByCon(InfoSqlConfig infoSqlConfig);
	
	public PageModel getPagerListByCon(InfoSqlConfig infoSqlConfig,int pageNo,int pageSize);
	
	public List queryDynamicSql(Map param);
}
