package com.flyrui.financMgmt.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.pojo.UserRechargeDto;

public interface UserRechargeService {
	
	public int insert(User loginUser,UserRechargeDto userRecharge);
	
	public int update(UserRechargeDto userRecharge);
	
	public int delete(UserRechargeDto userRecharge);
	
	public List<UserRechargeDto> getListByCon(UserRechargeDto userRecharge);
	
	public PageModel getPagerListByCon(UserRechargeDto userRecharge,int pageNo,int pageSize);
	
	public PageModel getPagerListByConRec(UserRechargeDto userRecharge,int pageNo,int pageSize);
	
	public List<UserRechargeDto> getListByConRec(UserRechargeDto userRecharge);
	
	public int deleteUserChargeByRecCode(UserRechargeDto userRecharge) ;
}
