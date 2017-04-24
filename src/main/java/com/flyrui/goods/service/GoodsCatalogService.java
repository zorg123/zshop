package com.flyrui.goods.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.goods.pojo.GoodsCatalog;     		

public interface GoodsCatalogService {
		
	
	public int insert(GoodsCatalog goodsCatalog);
	
	public int update(GoodsCatalog goodsCatalog);
	
	public int delete(GoodsCatalog goodsCatalog);
	
	public List<GoodsCatalog> getListByCon(GoodsCatalog goodsCatalog);
	
	public PageModel getPagerListByCon(GoodsCatalog goodsCatalog,int pageNo,int pageSize);	
}
