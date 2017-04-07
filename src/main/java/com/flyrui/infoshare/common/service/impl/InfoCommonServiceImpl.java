package com.flyrui.infoshare.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.common.pojo.InfoSqlConfig;
import com.flyrui.infoshare.common.service.InfoCommonService;
import com.flyrui.infoshare.common.service.InfoSqlConfigService;

@Service(value="infoCommonService")
public class InfoCommonServiceImpl extends BaseService<Map> implements InfoCommonService {
	
	private static Logger logger = Logger.getLogger(InfoCommonServiceImpl.class);
	public InfoCommonServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.common.dao.mapper.InfoSqlConfigMapper");
	}
	
	@Autowired
	InfoSqlConfigService infoSqlConfigService;	
	
	@Autowired
	InfoSqlConfig infoSqlConfig; 
	
	public List queryListBySqlId(Map param) throws Exception{
		List retList = new ArrayList();
		String sqlId = (String)param.get("sqlId");
		infoSqlConfig.setSql_id(Integer.parseInt(sqlId));
		List<InfoSqlConfig> infoSqlConfigList = infoSqlConfigService.getListByCon(infoSqlConfig);
		if(infoSqlConfigList!=null && infoSqlConfigList.size()>0){
			InfoSqlConfig infoSqlConfigTemp = infoSqlConfigList.get(0);
			String sqlBody = infoSqlConfigTemp.getSql_body_content();
			StringBuffer sb =new StringBuffer();
			sb.append(sqlBody);
			
			String sqlWhere = infoSqlConfigTemp.getSql_where();
			String sqlParam = infoSqlConfigTemp.getSql_param();
			List<String> paramList = new ArrayList<String>();
			if(sqlParam!=null&&!"".equals(sqlParam)){
				String[] sqlParams = sqlParam.split(",");
				for(String para : sqlParams){
					paramList.add(para);
				}
			}
			if(sqlWhere!=null){				
				String[] sqlWheres = sqlWhere.split("/");
				boolean isFirst = true;
				for(String sqlWhereInner : sqlWheres){				
					String[] params = getParamName(sqlWhereInner);
					for(String para : params){
						String paramValue = (String)param.get(para);
						if(paramValue!=null && !"".equals(paramValue) && !"null".equals(paramValue)){							
							sqlWhereInner = sqlWhereInner.replace("{"+para+"}", "?");	
							paramList.add(paramValue);
						}
					}					
					
					if(isFirst){
						sb.append(sqlWhereInner);
					}else{
						sb.append("and "+ sqlWhereInner);
					}
					isFirst = false;
					
				}
				
			}else{
				if(sqlWhere !=null){
					sb.append(sqlWhere);
				}
				
			}
			String[] params = new String[paramList.size()];
			params = paramList.toArray(params);
			logger.info("dynamic sql is "+sb.toString());
			logger.info("params is "+paramList);
			retList = super.selectByDynamicSql(sb.toString(),params);
		}
		return retList;
	}
	
	private String[] getParamName(String where){
		List<String> paramList = new ArrayList<String>();
		int cPost=0;
		for(int i=0;i<where.length();i++){
			char c = where.charAt(i);
			if(c=='{'){
				cPost = i;
			}else if(c=='}'){
				paramList.add(where.substring(cPost+1,i));				
			}
		}
		String[] params = new String[paramList.size()];
		return paramList.toArray(params);
	}
	public Map queryMapBySqlId(Map param) throws Exception{
		Map retMap = null;
		List retList = queryListBySqlId(param);
		if(retList.size()>0){
			retMap = (Map)retList.get(0);
		}
		return retMap;
	}
}
