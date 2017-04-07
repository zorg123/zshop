package com.flyrui.channel.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrContentTxt;

public interface ContentTxtService {
	
	public int insert(FrContentTxt frContentTxt);
	
	public int update(FrContentTxt frContentTxt);
	
	public int delete(FrContentTxt frContentTxt);
	
	public List<FrContentTxt> selectList(FrContentTxt frContentTxt);
	
	public List<FrContentTxt> getListByCon(FrContentTxt frContentTxt);
	
	public PageModel getPagerListByCon(FrContentTxt frContentTxt,int pageNo,int pageSize);
	
}
