package com.flyrui.financMgmt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.service.CoinTrackService;

@Service(value="coinTrackService")
public class CoinTrackServiceImpl extends BaseService<CoinTrackDto> implements CoinTrackService {	
	public CoinTrackServiceImpl(){
		super.setNameSpace("com.flyrui.financMgmt.dao.mapper.CoinTrackMapper");
	}
}
