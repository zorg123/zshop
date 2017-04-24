package com.flyrui.goods.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.goods.pojo.GoodsRevAddr;     		
import com.flyrui.goods.service.GoodsRevAddrService;     		


@Service(value="goodsRevAddrService")
public class GoodsRevAddrServiceImpl extends BaseService<GoodsRevAddr> implements GoodsRevAddrService {	
	public GoodsRevAddrServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsRevAddrMapper");
	}
}
