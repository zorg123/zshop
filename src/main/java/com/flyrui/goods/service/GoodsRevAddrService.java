package com.flyrui.goods.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.goods.pojo.GoodsRevAddr;     		

public interface GoodsRevAddrService {
		
	
	public int insert(GoodsRevAddr goodsRevAddr);
	
	public int update(GoodsRevAddr goodsRevAddr);
	
	public int delete(GoodsRevAddr goodsRevAddr);
	
	public List<GoodsRevAddr> getListByCon(GoodsRevAddr goodsRevAddr);
	
	public PageModel getPagerListByCon(GoodsRevAddr goodsRevAddr,int pageNo,int pageSize);	
}
