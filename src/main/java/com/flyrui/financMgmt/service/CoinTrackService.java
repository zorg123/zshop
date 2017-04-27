package com.flyrui.financMgmt.service;

import java.util.HashMap;
import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.BonusRecDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;

public interface CoinTrackService {
		
	
	public int insert(CoinTrackDto coinTrackDto);
	
	public int update(CoinTrackDto coinTrackDto);
	
	public int delete(CoinTrackDto coinTrackDto);
	
	public List<BonusRecDto> getListByConRec(CoinTrackDto coinTrackDto);
	
	public List<CoinTrackDto> getListByConExtConf(CoinTrackDto coinTrackDto);
	
	public PageModel getPagerListByConRec(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConExtConf(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConAccountFlow(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConAccountFlowForWap(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConAccountInfo(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConBonusAct(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConBonusInfo(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public PageModel getPagerListByConElectInfo(CoinTrackDto coinTrackDto,int pageNo,int pageSize);
	
	public int insertCoinTrack(User loginUser,CoinTrackDto coinTrackDto);
	
	public int updateCoinTrack(User loginUser,CoinTrackDto coinTrackDto);
	
	public HashMap getUserByCode(CoinTrackDto coinTrackDto);
	
	public HashMap getBonusActSum(CoinTrackDto coinTrackDto);
	
	public HashMap recharge(User loginUser,CoinTrackDto coinTrackDto);
	
	public HashMap insertElectTrans(User loginUser,CoinTrackDto coinTrackDto);
	
	public HashMap bonusToElect(User loginUser,CoinTrackDto coinTrackDto);
	
	public HashMap insertExtract(User loginUser,CoinTrackDto coinTrackDto);
	
	
}
