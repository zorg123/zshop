package com.flyrui.goods.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.goods.pojo.Goods;     		
import com.flyrui.goods.service.GoodsService;     		


@Service(value="goodsService")
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {	
	public GoodsServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsMapper");
	}
}
