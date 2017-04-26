package com.flyrui.goods.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.exception.FRException;
import com.flyrui.goods.pojo.Goods;
import com.flyrui.goods.pojo.GoodsOrder;

public interface GoodsService {
		
	
	public int insert(Goods goods);
	
	public int update(Goods goods);
	
	public int delete(Goods goods);
	
	public List<Goods> getListByCon(Goods goods);
	
	public PageModel getPagerListByCon(Goods goods,int pageNo,int pageSize);	
	
	public void accept(Goods goods,GoodsOrder goodsOrder) throws FRException;
}
