package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.sys.service.FrconfigService;

@Service(value="frconfigService")
public class FrconfigServiceImpl extends BaseService implements FrconfigService {
	
	public FrconfigServiceImpl(){
		   super.setNameSpace("com.flyrui.dao.mapper.common");
	}
	
	public int updateFrConfig(HashMap map){
		return baseDao.update(this.nameSpace+".updateFrConfig", map);
	}
	
	public List<HashMap> queryFrCfgList(HashMap map){
		return baseDao.selectList(this.nameSpace+".queryFrCfgList", map);
	}
	
}
