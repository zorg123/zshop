package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.CASMd5Utils;
import com.flyrui.common.DateUtil;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.service.BaseService;
import com.flyrui.common.service.CommonService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbUser;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.goods.pojo.Goods;
import com.flyrui.goods.pojo.GoodsOrder;
import com.flyrui.goods.service.GoodsOrderService;
import com.flyrui.goods.service.GoodsService;
import com.flyrui.goods.service.impl.GoodsOrderServiceImpl;
import com.flyrui.quartz.dto.GoodsOrderAfter;
import com.flyrui.sys.dto.FrConfig;
import com.flyrui.sys.dto.UserChildDto;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.RoleService;
import com.flyrui.sys.service.UserService;

@Service(value="userService")
public class UserServiceImpl extends BaseService<User> implements UserService {
   private static final Logger log = Logger.getLogger(GoodsOrderServiceImpl.class);	
   @Autowired
   AccoutInfoService accoutInfoService;
   
   @Autowired
   RoleService roleService;
   
   @Autowired
   FrconfigService frconfigService;
   
   @Autowired
   CommonService commonService;
   
   @Autowired
   GoodsService goodsService;
   
   @Autowired
   GoodsOrderService goodsOrderService;
   
   public UserServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.pojo.sys.tb_user");
   }
   
   public int saveUserRole(String user_id,String role_id){
	   Map userRoleMap = new HashMap();
	   userRoleMap.put("user_id", user_id);
	   userRoleMap.put("role_id", role_id);
	   userRoleMap.put("create_date", new Date());
	   return baseDao.update(getNameSpace()+".saveUserRole", userRoleMap);
   }
   
   public int deleteUserRole(String user_id,String role_id){	
	   Map userRoleMap = new HashMap();
	   userRoleMap.put("user_id", user_id);
	   userRoleMap.put("role_id", role_id);
	   return baseDao.update(getNameSpace()+".deleteUserRole", userRoleMap);
   }
   public int deleteRolesByUser(String user_id){	
	   Map userRoleMap = new HashMap();
	   userRoleMap.put("user_id", user_id);
	   return baseDao.update(getNameSpace()+".deleteRolesByUser", userRoleMap);
   }
   
   public int modifyPwd(Map<String,String> param){
	   return baseDao.update(getNameSpace()+".modifyPwd", param);
   }
  
   //tbUser子帐号
   @Transactional
   public String[] activeUser2(TbUser tbUser,TbUser beActivedtbUser){
	   
	   log.info("激活子帐号:"+tbUser.getUser_id()+"被激活人: "+beActivedtbUser.getUser_id());
	   //查找订单 1、会员订单 2、未发货 3、最新一条
	   GoodsOrder newGoodsOrder = new GoodsOrder();
	   newGoodsOrder.setUser_id(tbUser.getUser_id());
	   newGoodsOrder.setState("0");
	   newGoodsOrder.setCatalog_id("1");
	   List<GoodsOrder> goodsOrderListForActive = goodsOrderService.selectCreateDateDesc(newGoodsOrder);
	   if(goodsOrderListForActive!=null && goodsOrderListForActive.size()>0){
		   GoodsOrder activeOrder = goodsOrderListForActive.get(0);
		   log.info("子帐号激活会员: 订单id :"+activeOrder.getOrder_id()+"  数量:"+activeOrder.getGoods_amount());
		   if(activeOrder.getGoods_amount() == 0){
			   return new String[]{"-1","会员订单中商品数量为0，不能激活"};
		   }
		   //只剩一条的话
		   if(activeOrder.getGoods_amount() == 1){
			   log.info("订单商品数量1，子帐号激活会员: 直接激活");
			   //插入新订单
			   genNewActiveOrder(activeOrder, tbUser, beActivedtbUser);
			   //调用存储过程
			   afterHandler(tbUser.getUser_id(),beActivedtbUser.getUser_id());
			   //更新原定订单，作废
			   GoodsOrder oldOrder = new GoodsOrder();
			   oldOrder.setOrder_id(activeOrder.getOrder_id());
			   oldOrder.setState("-1");
			   oldOrder.setComments("该订单转赠给用户[："+beActivedtbUser.getUser_code()+"]"+";"+oldOrder.getComments()==null?"":oldOrder.getComments());
			   goodsOrderService.update(oldOrder);
		   }else if(activeOrder.getGoods_amount() > 1){
			   log.info("主帐号商品数量"+activeOrder.getGoods_amount()+"，子帐号激活会员: 直接激活");
			   //插入新订单
			   genNewActiveOrder(activeOrder, tbUser, beActivedtbUser);
			   //调用存储过程
			   afterHandler(tbUser.getUser_id(),beActivedtbUser.getUser_id());
			   //更新原定订单，数量-1
			   GoodsOrder oldOrder = new GoodsOrder();
			   oldOrder.setOrder_id(activeOrder.getOrder_id());
			   oldOrder.setGoods_amount(activeOrder.getGoods_amount()-1);
			   oldOrder.setTotal_fee(activeOrder.getGoods_price()*oldOrder.getGoods_amount());
			   oldOrder.setComments("该订单转赠："+beActivedtbUser.getUser_code()+",转增数量1;"+oldOrder.getComments()==null?"":oldOrder.getComments());
			   goodsOrderService.update(oldOrder);
		   }
		   return new String[]{"0","成功"};
	   }else{
		   return new String[]{"-1","父账户没有可以用于激活的订单"};
	   }
   }
   private void genNewActiveOrder(GoodsOrder activeOrder,TbUser tbUser,TbUser beActivedtbUser){
	   GoodsOrder newOrder = new GoodsOrder();
	   String goodsOrderCode = "00000000"+commonService.getSequence("seq_goods_order");
	   goodsOrderCode = DateUtil.formatDate(new Date(), "yyyyMMddHH")+goodsOrderCode.substring(goodsOrderCode.length()-8);

	   newOrder.setOrigin_order_id(activeOrder.getOrder_id());
	   newOrder.setOrder_id(UUIDHexGenerator.generator());
	   newOrder.setOrder_code(goodsOrderCode);
	   newOrder.setComments("用户["+tbUser.getUser_code()+"]转赠订单");
	   newOrder.setGoods_id(activeOrder.getGoods_id());
	   newOrder.setGoods_name(activeOrder.getGoods_name());
	   newOrder.setGoods_amount(1);
	   newOrder.setTotal_fee(activeOrder.getGoods_price());
	   newOrder.setPay_type(activeOrder.getPay_type());
	   newOrder.setUser_id(beActivedtbUser.getUser_id());
	   newOrder.setUser_name(beActivedtbUser.getName());
	   newOrder.setCreate_date(new Date());
	   newOrder.setState_date(new Date());
	   newOrder.setState("0");
	   newOrder.setGoods_type(activeOrder.getGoods_type());
	   newOrder.setRefund_fee(0d);
	   newOrder.setGoods_price(activeOrder.getGoods_price());
	   newOrder.setCatalog_id(activeOrder.getCatalog_id());
	   goodsOrderService.insert(newOrder);
   }
   
   @Transactional
   @Override
   public int insertRegister(User user){	   
	   super.insert(user);
	   AccoutInfoDto accoutInfo = new AccoutInfoDto();
   	   accoutInfo.setUser_id(Integer.valueOf(user.getUser_id()));
   	   accoutInfo.setBonus_coin(0d);
   	   accoutInfo.setElect_coin(0d);
   	   accoutInfo.setReconsmp_coin(0d);
   	   this.saveUserRole(user.getUser_id(),"4");
   	   return accoutInfoService.insert(accoutInfo);
   }
   
   public List<User> selectUserNetTree(User user){
	   return baseDao.selectList(getNameSpace()+".selectUserNetTree",user);
   }

	@Override
	@Transactional
	public void activeUser(List<User> userList, User loginUser) throws FRException {
		for(User user : userList){
			Map param = new HashMap();
			param.put("in_id", user.getUser_id());
			param.put("login_userid", loginUser.getUser_id());
			baseDao.update(getNameSpace()+".activeUser",param);
			
			//用户激活完毕后，根据是否配置赠品id来确定是否生成赠品订单
			FrConfig frConfig = new FrConfig();
			frConfig.setCf_id("active_free_goods");
			List<FrConfig> retList = frconfigService.getListByCon(frConfig);
			if(retList.size()>0){
				String goodsId = retList.get(0).getCf_value();
				Goods goods = new Goods();
				goods.setGoods_id(goodsId);
				goods.setState("1");
				goods.setEff_date(new Date());
				goods.setExp_date(new Date());
				//orderCode的组成规则 YYYYMMDDHH+8位序列
				String goodsOrderCode = "00000000"+commonService.getSequence("seq_goods_order");
				goodsOrderCode = DateUtil.formatDate(new Date(), "yyyyMMddHH")+goodsOrderCode.substring(goodsOrderCode.length()-8);
				GoodsOrder goodsOrder = new GoodsOrder();
				goodsOrder.setOrder_code(goodsOrderCode);
				goodsOrder.setOrder_id(UUIDHexGenerator.generator());
				goodsOrder.setUser_id(user.getUser_id());
				goodsOrder.setUser_name(user.getName());
				goodsOrder.setCreate_date(new Date());
				goodsOrder.setGoods_id(goods.getGoods_id());
				goodsOrder.setOrd_ip("");
				goodsOrder.setState("0");
				goodsOrder.setGoods_amount(1);
		    	goodsService.accept(goods, goodsOrder,user);//用于事务
			}
		}	
	}
	
	@Override
	@Transactional
	public int delUnActiveUser(User user){		
		AccoutInfoDto accoutInfo = new AccoutInfoDto();
	   	accoutInfo.setUser_id(Integer.valueOf(user.getUser_id()));
		accoutInfoService.deleteByUserId(accoutInfo);
		deleteRolesByUser(user.getUser_id());
		return super.delete(user);
	}
	
	@Override
	@Transactional
	public void checkCurrentChild(User loginUser,User user) throws FRException{
		Map param = new HashMap();
		param.put("inid", loginUser.getUser_id());
		baseDao.selectOne(getNameSpace()+".getChildList",param);
		if(param.get("cid") ==null){
			throw new FRException(new FRError(ErrorConstants.MARKET_NO_USER)); 
		}
		Integer cid = (Integer)param.get("cid");
		UserChildDto userChildDto = new UserChildDto();
		userChildDto.setCid(cid);
		userChildDto.setId(Integer.parseInt(user.getUser_id()));
		List<UserChildDto> userChildList = baseDao.selectList(getNameSpace()+".queryChildByIdAndCid",userChildDto);
		if(userChildList ==null || userChildList.size()==0){
			throw new FRException(new FRError(ErrorConstants.MARKET_NO_USER)); 
		}
		userChildDto.setId(null);
		baseDao.update(getNameSpace()+".delUserChild",userChildDto);
   }
   public PageModel selectForWaitActiveUser(User user,int pageNo,int pageSize){
	   return getPagerList(user,nameSpace+".selectForWaitActiveUser",pageNo,pageSize);		
   }
	
	public List<Map> queryUserLevelShareout() {
		return baseDao.selectList(getNameSpace()+".queryUserLevelShareout");
	}
	
	public List<Map> queryUserMonthGoods(Map<String,String> param) {
		return baseDao.selectList(getNameSpace()+".queryUserMonthGoods",param);
	}
   
	private void afterHandler(String child_userId,String act_userId) {
		//如果是会员商品，调用存储过程
		Map param = new HashMap();
		param.put("child_userId", child_userId);
		param.put("act_userId", act_userId);
		
		
		baseDao.update("com.flyrui.dao.pojo.sys.tb_user.pro_zshop_act",param);
	}
	
	public List<Map> queryUserGoodsOrder(Map<String,String> param) {
		return baseDao.selectList(getNameSpace()+".queryUserGoodsOrder",param);
	}
	@Transactional
	public boolean genSubUser(User curcurrUser2,User currUser){
		curcurrUser2.setPid(currUser.getUser_id());
    	curcurrUser2.setUser_id(null);
    	curcurrUser2.setUser_code("z"+currUser.getUser_code());
    	curcurrUser2.setLogin_count(0);
    	curcurrUser2.setLast_login_time(null);
    	curcurrUser2.setLast_login_ip(null);
    	curcurrUser2.setAllchild_num(0);
    	curcurrUser2.setUser_type("child");
    	curcurrUser2.setAllorder_num(0);
    	curcurrUser2.setRegister_date(new Date());
    	curcurrUser2.setCreate_time(new Date());
    	curcurrUser2.setAct_time(null);
    	curcurrUser2.setState("1");
    	curcurrUser2.setUser_level(0);
    	curcurrUser2.setShareout_qua("-1");
    	curcurrUser2.setPassword(CASMd5Utils.getPwd("111111", curcurrUser2.getUser_code()));
    	curcurrUser2.setTrans_pwd(CASMd5Utils.getPwd("222222", curcurrUser2.getUser_code()));
    	
    	super.insert(curcurrUser2);
    	this.saveUserRole(curcurrUser2.getUser_id(), "4");
    	
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(curcurrUser2.getUser_id()));
    	accoutInfo.setBonus_coin(0d);
    	accoutInfo.setElect_coin(0d);
    	accoutInfo.setReconsmp_coin(0d);
    	accoutInfoService.insert(accoutInfo);
    	return true;
	}
}
