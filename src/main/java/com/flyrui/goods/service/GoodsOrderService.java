package com.flyrui.goods.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.goods.pojo.GoodsOrder;     		

public interface GoodsOrderService {
		
	
	public int insert(GoodsOrder goodsOrder);
	
	public int update(GoodsOrder goodsOrder);
	
	public int delete(GoodsOrder goodsOrder);
	
	public List<GoodsOrder> getListByCon(GoodsOrder goodsOrder);
	
	public PageModel getPagerListByCon(GoodsOrder goodsOrder,int pageNo,int pageSize);
	
	public List<GoodsOrder> getListByConGoodsOrder(GoodsOrder goodsOrder);
	
	public boolean goodsSend(GoodsOrder goodsOrder,int goodsNum);
}
