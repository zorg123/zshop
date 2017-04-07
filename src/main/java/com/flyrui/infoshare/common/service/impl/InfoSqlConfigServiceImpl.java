package com.flyrui.infoshare.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.common.pojo.InfoSqlConfig;     		
import com.flyrui.infoshare.common.service.InfoSqlConfigService;     		


@Service(value="infoSqlConfigService")
public class InfoSqlConfigServiceImpl extends BaseService<InfoSqlConfig> implements InfoSqlConfigService {	
	public InfoSqlConfigServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.common.dao.mapper.InfoSqlConfigMapper");
	}
	public List queryDynamicSql(Map param){
		return super.queryById("queryDynamicSql", param);
	}
}
