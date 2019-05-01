package com.flyrui.quartz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.quartz.dto.GoodsOrderAfter;     		
import com.flyrui.quartz.service.GoodsOrderAfterService;     		


@Service(value="goodsOrderAfterService")
public class GoodsOrderAfterServiceImpl extends BaseService<GoodsOrderAfter> implements GoodsOrderAfterService {	
	public GoodsOrderAfterServiceImpl(){
		super.setNameSpace("com.flyrui.quartz.dao.mapper.GoodsOrderAfterMapper");
	}
	
	@Transactional
	public void afterHandler(GoodsOrderAfter goodsOrderAfter) {
		//如果是会员商品，调用存储过程
		Map param = new HashMap();
		param.put("in_id", goodsOrderAfter.getUser_id());
		param.put("goods_amount", goodsOrderAfter.getBuy_amount());
		baseDao.update("com.flyrui.goods.dao.mapper.GoodsMapper.pro_zshop_buy",param);
	}
}
