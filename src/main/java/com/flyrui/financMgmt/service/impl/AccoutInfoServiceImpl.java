package com.flyrui.financMgmt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.service.AccoutInfoService;


@Service(value="accoutInfoService")
public class AccoutInfoServiceImpl extends BaseService<AccoutInfoDto> implements AccoutInfoService {	
	public AccoutInfoServiceImpl(){
		super.setNameSpace("com.flyrui.financMgmt.dao.mapper.AccoutInfoMapper");
	}
	
	public AccoutInfoDto queryAccountInfo(AccoutInfoDto accoutInfo){
		return baseDao.selectOne(this.nameSpace+".queryAccountInfo", accoutInfo);
	}

	@Override
	public int deleteByUserId(AccoutInfoDto accoutInfo) {
		return baseDao.delete(this.nameSpace+".deleteByUserId", accoutInfo);
	}
	
	public List<AccoutInfoDto> selectByUserIdForUpdate(AccoutInfoDto accoutInfo){
		return baseDao.selectList(this.nameSpace+".selectByUserIdForUpdate", accoutInfo);
	}
}
