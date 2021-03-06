package com.flyrui.goods.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.DateUtil;
import com.flyrui.common.service.BaseService;
import com.flyrui.common.service.CommonService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
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
import com.flyrui.quartz.dto.GoodsOrderAfter;
import com.flyrui.quartz.service.GoodsOrderAfterService;
import com.flyrui.sys.dto.FrConfig;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.UserService;


@Service(value="goodsService")
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {	
	
	private static final Logger log = Logger.getLogger(GoodsOrderServiceImpl.class);
	
	@Autowired
	private AccoutInfoService accoutInfoService;
	
	@Autowired
	private CoinTrackService coinTrackService;
	
	@Autowired
	private GoodsOrderService goodsOrderService;
	
	@Autowired
	public GoodsOrderAfterService goodsOrderAfterService;
	
	@Autowired
	public FrconfigService frconfigService;
	
	@Autowired
	public GoodsService goodsService;
	
	@Autowired
	public CommonService commonService;
	
	@Autowired
	public UserService userService;
	
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
		
		FrConfig frconfig = new FrConfig();
		frconfig.setCf_id("gift_base_count");
		List<FrConfig> configList = frconfigService.getListByCon(frconfig);
		int giftGoodsBase = Integer.MAX_VALUE;
		if(configList!=null && configList.size()>0) {
			giftGoodsBase = Integer.parseInt(configList.get(0).getCf_value());
		}
		//查找主账户信息
		User uu = new User();
		uu.setUser_id(user.getPid());
		List<User> uuList = userService.getListByCon(uu);
		if(uuList!=null && uuList.size()>0) {
			uu = uuList.get(0);
		}
		//如果大于配置的数量,且账户级别大于2级 且为会员商品时，则插入赠品订单
		/*if(goodsOrder.getGoods_amount()>=giftGoodsBase && (uu.getUser_level()!=null && uu.getUser_level()>=2) && "1".equals(goods.getCatalog_id())) {
			int giftGoodsAmount = goodsOrder.getGoods_amount()/giftGoodsBase;
			//查询赠品信息
			Goods gGoods = new Goods();
			gGoods.setGoods_type("1");
			List<Goods> gGoodsList = goodsService.getListByCon(gGoods);
			if(gGoodsList!=null && gGoodsList.size()>0) {
				gGoods = gGoodsList.get(0);
				GoodsOrder gGoodsOrder = new GoodsOrder();
				String goodsOrderCode = "00000000"+commonService.getSequence("seq_goods_order");
				goodsOrderCode = DateUtil.formatDate(new Date(), "yyyyMMddHH")+goodsOrderCode.substring(goodsOrderCode.length()-8);
				gGoodsOrder.setOrder_code(goodsOrderCode);
				gGoodsOrder.setOrder_id(UUIDHexGenerator.generator());
				gGoodsOrder.setUser_id(goodsOrder.getUser_id());
				gGoodsOrder.setUser_name(goodsOrder.getUser_name());
				gGoodsOrder.setCreate_date(new Date());
				gGoodsOrder.setOrd_ip(goodsOrder.getOrd_ip());
				gGoodsOrder.setState(goodsOrder.getState());
				gGoodsOrder.setTotal_fee(0d);
				gGoodsOrder.setGoods_name(gGoods.getGoods_name());
				gGoodsOrder.setGoods_type(gGoods.getGoods_type());
				gGoodsOrder.setCatalog_id(gGoods.getCatalog_id());
				gGoodsOrder.setGoods_price(gGoods.getGoods_price());
				gGoodsOrder.setOrigin_order_id(goodsOrder.getOrder_id());
				gGoodsOrder.setGoods_amount(giftGoodsAmount);
				gGoodsOrder.setGoods_id(gGoods.getGoods_id());
				gGoodsOrder.setPay_type(goodsOrder.getPay_type());
				gGoodsOrder.setSend_immediate(goodsOrder.getSend_immediate());
				gGoodsOrder.setRev_addr(goodsOrder.getRev_addr());
				gGoodsOrder.setRev_area(goodsOrder.getRev_area());
				gGoodsOrder.setRev_desc(goodsOrder.getRev_desc());
				gGoodsOrder.setRev_invoice(goodsOrder.getRev_invoice());
				gGoodsOrder.setRev_people(goodsOrder.getRev_people());
				gGoodsOrder.setRev_invoice_name(goodsOrder.getRev_invoice_name());
				gGoodsOrder.setRev_link_phone(goodsOrder.getRev_link_phone());
				gGoodsOrder.setState_date(goodsOrder.getState_date());
				goodsOrderService.insert(gGoodsOrder);
			}else {
				log.info("未找到赠品信息");
			}
		}*/
		goodsOrder.setTotal_fee(totalFee);
		goodsOrder.setGoods_name(goods.getGoods_name());
		goodsOrder.setGoods_type(goods.getGoods_type());
		goodsOrder.setCatalog_id(goods.getCatalog_id());
		goodsOrder.setGoods_price(goods.getGoods_price());
		goodsOrder.setGoods_type(goods.getGoods_type());
		Goods newGoods = new Goods();
		newGoods.setGoods_amount(goods.getGoods_amount() - goodsOrder.getGoods_amount());
		newGoods.setGoods_id(goods.getGoods_id());
		super.update(newGoods);
		
		goodsOrderService.insert(goodsOrder);
		
		//插入后处理
		if("1".equals(goods.getCatalog_id())) {
			try {
				GoodsOrderAfter goodsOrderAfter = new GoodsOrderAfter();
				goodsOrderAfter.setGoods_order_id(goodsOrder.getOrder_id());
				goodsOrderAfter.setBuy_amount(goodsOrder.getGoods_amount());
				goodsOrderAfter.setUser_id(user.getUser_id());
				goodsOrderAfter.setCreate_date(new Date());
				goodsOrderAfter.setAfter_type("shop");
				goodsOrderAfter.setError_num(0);
				goodsOrderAfter.setState(1);
				goodsOrderAfterService.insert(goodsOrderAfter);
				/*Map param = new HashMap();
				param.put("in_id", goodsOrder.getUser_id());
				param.put("goods_amount", goodsOrder.getGoods_amount());
				baseDao.update("com.flyrui.goods.dao.mapper.GoodsMapper.pro_zshop_buy",param);*/
			}catch(Exception ex) {
				log.error("插入后处理任务出错，不管",ex);
			}
		}		
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
	
	@Override
	public int goodsChange(String orderId,Goods goods){		
		GoodsOrder  goodsOrder = new GoodsOrder();
		goodsOrder.setOrder_id(orderId);
		goodsOrder.setGoods_name(goods.getGoods_name());
		goodsOrder.setGoods_id(goods.getGoods_id());
		goodsOrder.setState_date(new Date());
		return goodsOrderService.update(goodsOrder);
	}
	
	@Override
	public PageModel<Goods> selectByChangeGoods(Goods goods,int pageNo,int pageSize){
		return  getPagerList(goods,getNameSpace()+".selectByChangeGoods",pageNo,pageSize);
	}
}
