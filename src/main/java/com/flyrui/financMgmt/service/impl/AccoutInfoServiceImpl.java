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
}
