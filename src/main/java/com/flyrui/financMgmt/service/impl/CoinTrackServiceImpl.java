package com.flyrui.financMgmt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
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
	
	//会员充值分页查询
	public PageModel getPagerListByConRec(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectRec",pageNo,pageSize);
	}
	
	//提现确认分页查询
	public PageModel getPagerListByConExtConf(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectExtConf",pageNo,pageSize);
	}
	
	//奖金实收分页查询
	public PageModel getPagerListByConBonusAct(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectBonusAct",pageNo,pageSize);
	}
	
	//奖金币明细分页查询
	public PageModel getPagerListByConBonusInfo(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectBonusInfo",pageNo,pageSize);
	}
	
	//电子币明细分页查询
	public PageModel getPagerListByConElectInfo(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectElectInfo",pageNo,pageSize);
	}
	
	//根据用户编码查找用户
	public HashMap getUserByCode(CoinTrackDto coinTrackDto){
		HashMap map = new HashMap();
		String retCode = "";
        String retString = "";
        String retUserId = "";
        String retUserName = "";
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
				retString = "已激活";
				retUserId = retUser.getUser_id();
				retUserName = retUser.getName();
			}
		}else{
			retCode = "-1";
			retString = "会员不存在";
		}
		map.put("retCode", retCode);
		map.put("retString", retString);
		map.put("retUserId", retUserId);
		map.put("retUserName", retUserName);
		return map;
	}
	
	public int insertCoinTrack(User loginUser,CoinTrackDto coinTrackDto){
		//如果user_code不为空，根据user_code查询user_id
		if(null!=coinTrackDto.getUser_code() && coinTrackDto.getUser_code().length()>0){
			TbUser queryUser = new TbUser();
			queryUser.setUser_code(coinTrackDto.getUser_code());
			TbUser retUser = (User)baseDao.selectOne("com.flyrui.dao.pojo.sys.tb_user"+".select", queryUser);
			coinTrackDto.setUser_id(Integer.valueOf(retUser.getUser_id()));
		}else{
			//从session中获取用户user_id
			coinTrackDto.setUser_id(Integer.valueOf(loginUser.getUser_id()));
		}
		coinTrackDto.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
		if(null==coinTrackDto.getOrder_id()){
			//从序列中取
			coinTrackDto.setOrder_id(Integer.valueOf(getSequence("coin_track_orderid")));
		}
		//电子币转账,接收方送user_code，发送方不送user_code
		if(null!=coinTrackDto.getCoin_type() && coinTrackDto.getCoin_type()==2 && null!=coinTrackDto.getCreate_type() && coinTrackDto.getCreate_type()==5){
			String comments = "转入";
			if(null!=coinTrackDto.getUser_code() && coinTrackDto.getUser_code().length()>0){
				comments=loginUser.getUser_code()+comments;
			}else{
				comments=comments+coinTrackDto.getUser_code();
			}
			coinTrackDto.setComments(comments);
		}
		baseDao.insert(this.getNameSpace()+".insert", coinTrackDto);
		//更新会员账户电子币金额
		AccoutInfoDto accoutInfoDto = new AccoutInfoDto();
		if(coinTrackDto.getCoin_type()==1){
			accoutInfoDto.setBonus_coin(coinTrackDto.getCoin_num());
		}else if (coinTrackDto.getCoin_type()==2){
			accoutInfoDto.setElect_coin(coinTrackDto.getCoin_num());
		}else if (coinTrackDto.getCoin_type()==3){
			accoutInfoDto.setReconsmp_coin(coinTrackDto.getCoin_num());
		}
		accoutInfoDto.setUser_id(coinTrackDto.getUser_id());
		return baseDao.update("com.flyrui.financMgmt.dao.mapper.AccoutInfoMapper"+".update", accoutInfoDto);
	}
	
	public int updateCoinTrack(User loginUser,CoinTrackDto coinTrackDto){
		coinTrackDto.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
		coinTrackDto.setOper_time(new Date());
		return baseDao.update(this.getNameSpace()+".update", coinTrackDto);
	}
	
	//会员充值查询
	public List<CoinTrackDto> getListByConRec(CoinTrackDto coinTrackDto) {
		return baseDao.selectList(nameSpace+".selectRec", coinTrackDto);		
	}
	
	//提现确认查询
	public List<CoinTrackDto> getListByConExtConf(CoinTrackDto coinTrackDto) {
		return baseDao.selectList(nameSpace+".selectExtConf", coinTrackDto);		
	}
	
	//得到实收奖金总额
	public HashMap getBonusActSum(CoinTrackDto coinTrackDto) {
		return (HashMap)baseDao.selectOne(nameSpace+".getBonusActSum", coinTrackDto);
	}
}
