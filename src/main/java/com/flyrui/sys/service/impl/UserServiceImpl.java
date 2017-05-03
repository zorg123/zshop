package com.flyrui.sys.service.impl;

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
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.goods.pojo.Goods;
import com.flyrui.goods.pojo.GoodsOrder;
import com.flyrui.goods.service.GoodsService;
import com.flyrui.sys.dto.FrConfig;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.RoleService;
import com.flyrui.sys.service.UserService;

@Service(value="userService")
public class UserServiceImpl extends BaseService<User> implements UserService {
	
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
   
}
