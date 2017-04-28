package com.flyrui.goods.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.goods.pojo.GoodsRevAddr;
import com.flyrui.goods.service.GoodsRevAddrService;


@Service(value="goodsRevAddrService")
public class GoodsRevAddrServiceImpl extends BaseService<GoodsRevAddr> implements GoodsRevAddrService {	
	public GoodsRevAddrServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsRevAddrMapper");
	}
	
	@Transactional
	public int updateDefaultAddrByUserId(GoodsRevAddr goodsRevAddr){
		GoodsRevAddr goodsRevAddrTemp = new GoodsRevAddr();
    	goodsRevAddrTemp.setUser_id(goodsRevAddr.getUser_id());
    	goodsRevAddrTemp.setIs_default("0");
    	baseDao.update(getNameSpace()+".updateDefaultAddrByUserId", goodsRevAddrTemp);   
    	goodsRevAddrTemp.setAddr_id(goodsRevAddr.getAddr_id());
    	goodsRevAddrTemp.setIs_default("1");
		return super.update(goodsRevAddrTemp);
	}
}
