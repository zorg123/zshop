package com.flyrui.financMgmt.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.sys.TbUser;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.service.CoinTrackService;

@Service(value="coinTrackService")
public class CoinTrackServiceImpl extends BaseService<CoinTrackDto> implements CoinTrackService {	
	public CoinTrackServiceImpl(){
		super.setNameSpace("com.flyrui.financMgmt.dao.mapper.CoinTrackMapper");
	}
	
	//根据用户编码查找用户
	public HashMap getUserByCode(CoinTrackDto coinTrackDto){
		HashMap map = new HashMap();
		String retCode = "";
        String retString = ""; 
		String user_code = coinTrackDto.getUser_code();
		TbUser user = new TbUser();
		user.setUser_code(user_code);
		TbUser retUser = (User)baseDao.selectOne("com.flyrui.dao.pojo.sys.tb_user"+".select", user);
		if(retUser!=null){
			String state = retUser.getState();
			if(state.equals("0")){
				retCode = "0";
				retString = "未激活";
			}else if(state.equals("1")){
				retCode = "1";
				retString = retUser.getUser_id();
			}
		}else{
			retCode = "-1";
			retString = "会员不存在";
		}
		map.put("retCode", retCode);
		map.put("retString", retString);
		return map;
	}
	
	public int insertCoinTrack(User loginUser,CoinTrackDto coinTrackDto){
		//根据user_code得到user_id
		String user_code = coinTrackDto.getUser_code();
		TbUser user = new TbUser();
		user.setUser_code(user_code);
		user.setState("1");
		TbUser retUser = (User)baseDao.selectOne("com.flyrui.dao.pojo.sys.tb_user"+".queryUserByCodeState", user);
		coinTrackDto.setUser_id(Integer.valueOf(retUser.getUser_id()));
		//2电子币
		coinTrackDto.setCoin_type(2);
		//金额
		//4充值
		coinTrackDto.setCreate_type(4);
		coinTrackDto.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
		//得到序列
		String coin_track_orderid = getSequence("coin_track_orderid");
		Integer order_id = Integer.valueOf(coin_track_orderid).intValue();
		coinTrackDto.setOrder_id(order_id);
		baseDao.insert(this.getNameSpace()+".insert", coinTrackDto);
		//更新会员账户电子币金额
		AccoutInfoDto accoutInfoDto = new AccoutInfoDto();
		accoutInfoDto.setElect_coin(coinTrackDto.getCoin_num());
		accoutInfoDto.setUser_id(coinTrackDto.getUser_id());
		return baseDao.update("com.flyrui.financMgmt.dao.mapper.AccoutInfoMapper"+".update", accoutInfoDto);
	}
	
}
