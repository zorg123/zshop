package com.flyrui.channel.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrContent;
import com.flyrui.dao.pojo.channel.FrContentTxt;

public interface ContentService {
	
	public int insert(FrContent frContent,FrContentTxt contentTxt);
	
	public int update(FrContent frContent,FrContentTxt contentTxt);
	
	public int delete(FrContent frContent);
	
	public List<FrContent> getListByCon(FrContent frContent);
	
	public PageModel getPagerListByCon(FrContent frContent,int pageNo,int pageSize);
	
	public List<FrContent> queryContentInfoList(FrContent frContent) ;
}
