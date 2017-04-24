package com.flyrui.goods.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.goods.pojo.Goods;     		

public interface GoodsService {
		
	
	public int insert(Goods goods);
	
	public int update(Goods goods);
	
	public int delete(Goods goods);
	
	public List<Goods> getListByCon(Goods goods);
	
	public PageModel getPagerListByCon(Goods goods,int pageNo,int pageSize);	
}
