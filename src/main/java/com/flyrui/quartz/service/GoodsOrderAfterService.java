package com.flyrui.quartz.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.quartz.dto.GoodsOrderAfter;     		

public interface GoodsOrderAfterService {
		
	
	public int insert(GoodsOrderAfter goodsOrderAfter);
	
	public int update(GoodsOrderAfter goodsOrderAfter);
	
	public int delete(GoodsOrderAfter goodsOrderAfter);
	
	public List<GoodsOrderAfter> getListByCon(GoodsOrderAfter goodsOrderAfter);
	
	public PageModel getPagerListByCon(GoodsOrderAfter goodsOrderAfter,int pageNo,int pageSize);	
	
	public void afterHandler(GoodsOrderAfter goodsOrderAfter);
}
