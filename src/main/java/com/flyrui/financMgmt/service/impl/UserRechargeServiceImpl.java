package com.flyrui.financMgmt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.DateUtil;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.pojo.UserRechargeDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.financMgmt.service.UserRechargeService;


@Service(value="userRechargeService")
public class UserRechargeServiceImpl extends BaseService<UserRechargeDto> implements UserRechargeService {	
	public UserRechargeServiceImpl(){
		super.setNameSpace("com.flyrui.financMgmt.dao.mapper.UserRechargeMapper");
	}
	
	public int insert(User loginUser,UserRechargeDto userRecharge){
		String rec_code = "00000000"+getSequence("seq_user_recharge_id");
		rec_code = DateUtil.formatDate(new Date(), "yyyyMMddHH")+rec_code.substring(rec_code.length()-8);
		userRecharge.setRec_code(rec_code);
		userRecharge.setUser_id(Integer.valueOf(loginUser.getUser_id()));
		userRecharge.setUser_code(loginUser.getUser_code());
		userRecharge.setUser_name(loginUser.getName());
		return baseDao.insert(getNameSpace()+".insert", userRecharge);
	}
	
	//会员充值分页查询
	public PageModel getPagerListByConRec(UserRechargeDto userRecharge,int pageNo,int pageSize){
		return getPagerList(userRecharge,nameSpace+".selectRec",pageNo,pageSize);
	}
	
	//会员充值查询
	public List<UserRechargeDto> getListByConRec(UserRechargeDto userRecharge) {
		return baseDao.selectList(nameSpace+".selectRec", userRecharge);		
	}
}
