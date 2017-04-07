package com.flyrui.channel.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrContentExt;

public interface ContentExtService {
	
	public int insert(FrContentExt frContentExt);
	
	public int update(FrContentExt frContentExt);
	
	public int delete(FrContentExt frContentExt);
	
	public List<FrContentExt> getListByCon(FrContentExt frContentExt);
	
	public PageModel getPagerListByCon(FrContentExt frContentExt,int pageNo,int pageSize);
	
}
