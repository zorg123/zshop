package com.flyrui.goods.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.DateUtil;
import com.flyrui.common.service.BaseService;
import com.flyrui.common.service.CommonService;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.goods.pojo.Goods;
import com.flyrui.goods.pojo.GoodsOrder;
import com.flyrui.goods.service.GoodsOrderService;
import com.flyrui.goods.service.GoodsService;


@Service(value="goodsService")
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {	
	
	@Autowired
	private AccoutInfoService accoutInfoService;
	
	@Autowired
	private CoinTrackService coinTrackService;
	
	@Autowired
	private GoodsOrderService goodsOrderService;
	
	public GoodsServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.GoodsMapper");
	}

	@Override
	@Transactional
	public void accept(Goods goods, GoodsOrder goodsOrder,User user) throws FRException{
		
		List<Goods> goodsList = selectGoodsByIdForUpdate(goods);
    	if(goodsList.size()==0){
    		throw new FRException(new FRError("GOODS_001"));
    	}
    	goods = goodsList.get(0); 
    	//校验商品数量
		if(goods.getGoods_amount()<goodsOrder.getGoods_amount()){
			throw new FRException(new FRError("GOODS_002"));
		}
		Double totalFee = goodsOrder.getGoods_amount() * goods.getGoods_price();
		//if(!"1".equals(goods.getGoods_type())){ //这个是赠品订单，不会扣费，不做账户校验
		//校验账户余额
		AccoutInfoDto accoutInfoDto = new AccoutInfoDto();
		accoutInfoDto.setUser_id(Integer.parseInt(goodsOrder.getUser_id()));
		List<AccoutInfoDto> AccoutInfoDtoList = accoutInfoService.selectByUserIdForUpdate(accoutInfoDto);
		if(AccoutInfoDtoList.size()==0){
    		throw new FRException(new FRError("GOODS_003"));
    	}
		accoutInfoDto = AccoutInfoDtoList.get(0);
		
		CoinTrackDto coinTrackDto = new CoinTrackDto();
		if("2".equals(goodsOrder.getPay_type())){ //电子币
			if(totalFee>accoutInfoDto.getElect_coin()){
				throw new FRException(new FRError("GOODS_003"));
			}			
			coinTrackDto.setUser_id(Integer.parseInt(goodsOrder.getUser_id()));
			coinTrackDto.setLog_type("coin");
			coinTrackDto.setCoin_type(2);
			coinTrackDto.setSub_logType("elect");
			coinTrackDto.setCoin_num(-totalFee);
			coinTrackDto.setCreate_type("toShopC");
			coinTrackDto.setOper_user_id(Integer.parseInt(goodsOrder.getUser_id()));
			coinTrackDto.setGoods_order_id(goodsOrder.getOrder_id());
			coinTrackDto.setComments(goods.getGoods_name());			
			coinTrackDto.setBalance_comments("电子账户余额:"+(accoutInfoDto.getElect_coin()-totalFee));
			
		}else if("3".equals(goodsOrder.getPay_type())){//重消币
			if(totalFee>accoutInfoDto.getReconsmp_coin()){
				throw new FRException(new FRError("GOODS_003"));
			}
			coinTrackDto.setUser_id(Integer.parseInt(goodsOrder.getUser_id()));
			coinTrackDto.setCoin_type(3);
			coinTrackDto.setLog_type("coin");
			coinTrackDto.setSub_logType("reconsmp");
			coinTrackDto.setCoin_num(-totalFee);
			coinTrackDto.setCreate_type("toShopRe");
			coinTrackDto.setOper_user_id(Integer.parseInt(goodsOrder.getUser_id()));
			coinTrackDto.setGoods_order_id(goodsOrder.getOrder_id());
			coinTrackDto.setComments(goods.getGoods_name());			
			coinTrackDto.setBalance_comments("重消账户余额:"+(accoutInfoDto.getReconsmp_coin()-totalFee));
		}
		coinTrackService.insertCoinTrack(user,coinTrackDto);
		//如果是会员商品，调用存储过程
		Map param = new HashMap();
		param.put("in_id", user.getUser_id());
		param.put("goods_amount", goodsOrder.getGoods_amount());
		param.put("type", "1");
		baseDao.update(getNameSpace()+".activeUser",param);
		
		
		goodsOrder.setTotal_fee(totalFee);
		goodsOrder.setGoods_name(goods.getGoods_name());
		goodsOrder.setGoods_type(goods.getGoods_type());
		goodsOrder.setCatalog_id(goods.getCatalog_id());
		goodsOrder.setGoods_price(goods.getGoods_price());
		Goods newGoods = new Goods();
		newGoods.setGoods_amount(goods.getGoods_amount() - goodsOrder.getGoods_amount());
		newGoods.setGoods_id(goods.getGoods_id());
		super.update(newGoods);
		
		goodsOrderService.insert(goodsOrder);
	}
	
	@Override
	public List<Goods> selectGoodsByIdForUpdate(Goods goods){
		return baseDao.selectList(getNameSpace()+".selectGoodsByIdForUpdate", goods);
	}
	
	@Override
	public int insert(Goods goods){
		String goodsId = "00000000"+getSequence("seq_goods_id");
		goodsId = DateUtil.formatDate(new Date(), "yyyyMMddHH")+goodsId.substring(goodsId.length()-8);
		goods.setGoods_id(goodsId);
		return baseDao.insert(getNameSpace()+".insert", goods);
	}
}
