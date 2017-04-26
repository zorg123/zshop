package com.flyrui.goods.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.goods.pojo.GoodsOrder;     		
import com.flyrui.goods.service.GoodsOrderService;     		


@Service(value="goodsOrderService")
public class GoodsOrderServiceImpl extends BaseService<GoodsOrder> implements GoodsOrderService {	
	public GoodsOrderServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsOrderMapper");
	}
	
	public List<GoodsOrder> getListByConGoodsOrder(GoodsOrder goodsOrder) {
		return baseDao.selectList(nameSpace+".select", goodsOrder);		
	}
}
