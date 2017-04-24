package com.flyrui.goods.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.goods.pojo.GoodsCatalog;     		
import com.flyrui.goods.service.GoodsCatalogService;     		


@Service(value="goodsCatalogService")
public class GoodsCatalogServiceImpl extends BaseService<GoodsCatalog> implements GoodsCatalogService {	
	public GoodsCatalogServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsCatalogMapper");
	}
}
