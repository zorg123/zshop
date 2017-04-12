package com.flyrui.financMgmt.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.financMgmt.pojo.CoinTrackDto;

public interface CoinTrackService {
		
	
	public int insert(CoinTrackDto coinTrackDto);
	
	public int update(CoinTrackDto coinTrackDto);
	
	public int delete(CoinTrackDto coinTrackDto);
	
	public List<CoinTrackDto> getListByCon(CoinTrackDto coinTrackDto);
	
	public PageModel getPagerListByCon(CoinTrackDto coinTrackDto,int pageNo,int pageSize);	
}
