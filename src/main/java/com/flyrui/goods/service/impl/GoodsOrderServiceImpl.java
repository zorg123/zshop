package com.flyrui.goods.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyrui.common.DateUtil;
import com.flyrui.common.service.BaseService;
import com.flyrui.common.service.CommonService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.goods.pojo.GoodsOrder;
import com.flyrui.goods.service.GoodsOrderService;     		


@Service(value="goodsOrderService")
public class GoodsOrderServiceImpl extends BaseService<GoodsOrder> implements GoodsOrderService {	
	private static final Logger log = Logger.getLogger(GoodsOrderServiceImpl.class);	
	
	@Autowired
	private CommonService commonService;
	
	public GoodsOrderServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsOrderMapper");
	}
	
	public List<GoodsOrder> getListByConGoodsOrder(GoodsOrder goodsOrder) {
		return baseDao.selectList(nameSpace+".select", goodsOrder);		
	}
	
	public boolean goodsSend(GoodsOrder goodsOrder,int goodsNum) {
		log.info("订单发货: 订单id "+goodsOrder.getOrder_id()+" 收货人"+goodsOrder.getRev_people()+" 发货数量:"+goodsNum);
		if(goodsNum==goodsOrder.getGoods_amount()) { //不做拆分，只更新订单的状态
			GoodsOrder newGoodsOrder = new GoodsOrder();
			newGoodsOrder.setOrder_id(goodsOrder.getOrder_id());
			newGoodsOrder.setState("2");			
			newGoodsOrder.setRev_addr(goodsOrder.getRev_addr());
			newGoodsOrder.setRev_area(goodsOrder.getRev_area());
			newGoodsOrder.setRev_link_phone(goodsOrder.getRev_link_phone());
			newGoodsOrder.setRev_people(goodsOrder.getRev_people());
			super.update(newGoodsOrder);
		}else {
			//拆分订单 
			//查询订单，对数据库记录上锁，避免同时操作
			GoodsOrder newGoodsOrder = new GoodsOrder();
			newGoodsOrder.setOrder_id(goodsOrder.getOrder_id());
			List<GoodsOrder> goodsOrderList = baseDao.selectList(nameSpace+".selectOrderByIdForUpdate", goodsOrder);			
			newGoodsOrder = goodsOrderList.get(0);
			if(goodsOrder.getGoods_amount() != newGoodsOrder.getGoods_amount()) {
				log.info("订单发货: 订单id "+goodsOrder.getOrder_id()+" 原始数量："+ goodsOrder.getGoods_amount()+" 最新数量:"+ newGoodsOrder.getGoods_amount()+", 疑似重复提交订单，不处理!");
				return false;
			}
			
			Double totalFee = goodsNum * newGoodsOrder.getGoods_price();
			log.info("订单发货: 订单id "+goodsOrder.getOrder_id()+" goodsNum"+ goodsNum+" totalFee:"+ totalFee);
			newGoodsOrder.setRev_addr(goodsOrder.getRev_addr());
			newGoodsOrder.setRev_area(goodsOrder.getRev_area());
			newGoodsOrder.setRev_link_phone(goodsOrder.getRev_link_phone());
			newGoodsOrder.setRev_people(goodsOrder.getRev_people());
			newGoodsOrder.setGoods_amount(goodsNum);
			newGoodsOrder.setTotal_fee(totalFee);
			newGoodsOrder.setRefund_fee(0d);
			newGoodsOrder.setCreate_date(new Date());
			newGoodsOrder.setState_date(new Date());
			newGoodsOrder.setOrigin_order_id(newGoodsOrder.getOrder_id());
			String goodsOrderCode = "00000000"+commonService.getSequence("seq_goods_order");
			goodsOrderCode = DateUtil.formatDate(new Date(), "yyyyMMddHH")+goodsOrderCode.substring(goodsOrderCode.length()-8);
			newGoodsOrder.setOrder_code(goodsOrderCode);
			newGoodsOrder.setOrder_id(UUIDHexGenerator.generator());
			newGoodsOrder.setState("2");
			
			super.insert(newGoodsOrder);
			
			//更新原始订单
			GoodsOrder newGoodsOrder2 = new GoodsOrder();
			int leftNum = goodsOrder.getGoods_amount()-goodsNum;
			Double totalFeeLeft = leftNum * newGoodsOrder.getGoods_price();
			log.info("订单发货: 订单id "+goodsOrder.getOrder_id()+" leftNum"+ leftNum+" totalFeeLeft:"+ totalFeeLeft);
			newGoodsOrder2.setOrder_id(goodsOrder.getOrder_id());			
			newGoodsOrder2.setGoods_amount(leftNum);
			newGoodsOrder2.setTotal_fee(totalFeeLeft);
			super.update(newGoodsOrder2);
			
		}
		return true;
	}
	public List<GoodsOrder> selectCreateDateDesc(GoodsOrder goodsOrder) {
		return baseDao.selectList(nameSpace+".selectCreateDateDesc", goodsOrder);		
	}
}
