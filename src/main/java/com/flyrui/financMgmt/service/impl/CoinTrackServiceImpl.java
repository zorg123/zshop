package com.flyrui.financMgmt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.CASMd5Utils;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbUser;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.BonusRecDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.pojo.UserRechargeDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.financMgmt.service.UserRechargeService;
import com.flyrui.sys.service.ContentService;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.UserService;

@Service(value="coinTrackService")
public class CoinTrackServiceImpl extends BaseService<CoinTrackDto> implements CoinTrackService {
	@Autowired
	public CoinTrackService coinTrackService;
	
	@Autowired
	public AccoutInfoService accoutInfoService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public FrconfigService frconfigService;
	
	@Autowired
	public UserRechargeService userRechargeService;
	
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
	
	//报表统计--账户流水分页查询
	public PageModel getPagerListByConAccountFlow(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectAccountFlow",pageNo,pageSize);
	}
	
	public PageModel getPagerListByConAccountFlowForWap(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,nameSpace+".selectAccountFlowForWap",pageNo,pageSize);
	}
	
	//报表统计--账户明细分页查询
	public PageModel getPagerListByConAccountInfo(CoinTrackDto coinTrackDto,int pageNo,int pageSize){
		return getPagerList(coinTrackDto,"com.flyrui.financMgmt.dao.mapper.AccoutInfoMapper"+".queryAccountInfo",pageNo,pageSize);
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
		user.setBus_state(1);
		if(null!=coinTrackDto.getUser_name() && coinTrackDto.getUser_name().length()>0){
			user.setName("%"+coinTrackDto.getUser_name()+"%");
		}
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
	@Override
	@Transactional
	public int insertCoinTrack(User loginUser,CoinTrackDto coinTrackDto){
		int order_id = 0;
		if(null==coinTrackDto.getUser_id()){
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
		}
		if(null==coinTrackDto.getOper_user_id()){
			coinTrackDto.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
		}
		if(null==coinTrackDto.getOrder_id()){
			//从序列中取
			order_id = Integer.valueOf(getSequence("coin_track_orderid"));
			coinTrackDto.setOrder_id(order_id);
		}else{
			order_id = coinTrackDto.getOrder_id();
		}
		baseDao.insert(this.getNameSpace()+".insert", coinTrackDto);
		//更新会员账户电子币金额
		AccoutInfoDto accoutInfoDto = new AccoutInfoDto();
		if(coinTrackDto.getCoin_type()==1){
			accoutInfoDto.setBonus_coin(coinTrackDto.getCoin_num());
			accoutInfoDto.setCash_coin(coinTrackDto.getCoin_num());
		}else if (coinTrackDto.getCoin_type()==2){
			accoutInfoDto.setElect_coin(coinTrackDto.getCoin_num());
		}else if (coinTrackDto.getCoin_type()==3){
			accoutInfoDto.setReconsmp_coin(coinTrackDto.getCoin_num());
		}
		accoutInfoDto.setUser_id(coinTrackDto.getUser_id());
		baseDao.update("com.flyrui.financMgmt.dao.mapper.AccoutInfoMapper"+".update", accoutInfoDto);
		//int test=0;
		//if(test==0){
		//	throw new RuntimeException("更新账户失败!");
		//}
		return order_id;
	}
	@Override
	@Transactional
	public int updateCoinTrack(User loginUser,CoinTrackDto coinTrackDto){
		coinTrackDto.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
		coinTrackDto.setOper_time(new Date());
		return baseDao.update(this.getNameSpace()+".update", coinTrackDto);
	}
	
	//会员充值查询
	public List<BonusRecDto> getListByConRec(CoinTrackDto coinTrackDto) {
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
	
	/*电子币充值*/
	@Override
	@Transactional
	public HashMap recharge(User loginUser,CoinTrackDto coinTrackDto){
		HashMap retMap = new HashMap();
		//获取充值编号
		String goods_order_id = coinTrackDto.getGoods_order_id();
		//获取收入的会员编号
		String user_code = coinTrackDto.getUser_code();
		//获取收入的会员名称
		String user_name = coinTrackDto.getUser_name();
		//获取充值的金额
		Double elect_coin = coinTrackDto.getCoin_num();
		//获取附件
		String file_info = coinTrackDto.getFile_info();
		//判断接收方用户是否存在
		CoinTrackDto recCoinTrackDto = new CoinTrackDto();
		recCoinTrackDto.setUser_code(user_code);
		recCoinTrackDto.setUser_name(user_name);
		HashMap recMap = coinTrackService.getUserByCode(recCoinTrackDto);
		String retCode = (String)recMap.get("retCode");
		if(!retCode.equals("1")){
			if(retCode.equals("-1")){
				retMap.put("retCode", "-1");
				retMap.put("retString", "输入的会员编号不存在");
			}else if(retCode.equals("0")){
				retMap.put("retCode", "0");
				retMap.put("retString", "输入的会员编号未激活");
			}
		}else{
			//更新用户充值的状态
			UserRechargeDto userRecharge = new UserRechargeDto();
			userRecharge.setRec_code(goods_order_id);
			userRecharge.setState(1);
			userRecharge.setCoin_num(elect_coin.toString());
			userRecharge.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
			userRechargeService.update(userRecharge);
			//接收方
    		CoinTrackDto paramCoinTrackDto = new CoinTrackDto();
    		paramCoinTrackDto.setGoods_order_id(goods_order_id);
    		paramCoinTrackDto.setUser_code(user_code);
			//1:奖金币 2:电子币 3:重消币
    		paramCoinTrackDto.setCoin_type(2);
			//1:广告费 2:辅导奖 3:提现 4:电子币充值 5:电子币互转 6:现金转电子币 7:电子币购物 8:重消 9:报单 10:重消购物
    		paramCoinTrackDto.setCreate_type(4);
    		paramCoinTrackDto.setCoin_num(elect_coin);
    		paramCoinTrackDto.setFile_info(file_info);
    		paramCoinTrackDto.setComments("管理员充值");
    		//查询要充值账号的电子币余额
    		AccoutInfoDto accoutInfo = new AccoutInfoDto();
	    	accoutInfo.setUser_code(user_code);
	    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
	    	String balance_comments = "电子账户余额:"+(retAccoutInfoDto.getElect_coin()+elect_coin);
	    	paramCoinTrackDto.setBalance_comments(balance_comments);
			coinTrackService.insertCoinTrack(loginUser, paramCoinTrackDto);
			retMap.put("retCode", "3");
			retMap.put("retString", "成功");
		}
		return retMap;
	}
	/*电子币互转*/
	@Override
	@Transactional
	public HashMap insertElectTrans(User loginUser,CoinTrackDto coinTrackDto){
		HashMap retMap = new HashMap();
		//获取接收方用户编码
		String rec_user_code = coinTrackDto.getUser_code();
		//获取转账电子币金额
		Double trans_elect_coin = coinTrackDto.getCoin_num();
		//获取当前用户的交易密码
		String trans_pwd = coinTrackDto.getComments();
		//判断接收方用户是否存在
		CoinTrackDto recCoinTrackDto = new CoinTrackDto();
		recCoinTrackDto.setUser_code(rec_user_code);
		recCoinTrackDto.setUser_name(coinTrackDto.getUser_name());
		HashMap recMap = coinTrackService.getUserByCode(recCoinTrackDto);
		String retCode = (String)recMap.get("retCode");
		if(!retCode.equals("1")){
			if(retCode.equals("-1")){
				retMap.put("retCode", "-1");
				retMap.put("retString", "输入的会员编号不存在");
			}else if(retCode.equals("0")){
				retMap.put("retCode", "0");
				retMap.put("retString", "输入的会员编号未激活");
			}
		}else{
			//查询当前用户的电子币
			AccoutInfoDto accoutInfo = new AccoutInfoDto();
	    	accoutInfo.setUser_id(Integer.valueOf(loginUser.getUser_id()));
	    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
	    	Double electCoin = (Double)retAccoutInfoDto.getElect_coin();
	    	if(electCoin<trans_elect_coin){
	    		retMap.put("retCode", "1");
				retMap.put("retString", "转入的电子币大于当前账户的电子币");
	    	}else{
	    		//判断当前用户的交易密码
	    		User queryUser = new User();
	    		queryUser.setUser_id(loginUser.getUser_id());
	    		List <User> userlist = userService.getListByCon(queryUser);
	    		User retUser = userlist.get(0);
	    		String userTransPwd = retUser.getTrans_pwd();
	    		trans_pwd = CASMd5Utils.getPwd(trans_pwd,retUser.getUser_code());
	    		if(!trans_pwd.equals(userTransPwd)){
	    			retMap.put("retCode", "2");
					retMap.put("retString", "输入的交易密码错误!");
	    		}else{
	    			//接收方
	    			//1:奖金币 2:电子币 3:重消币
	    			recCoinTrackDto.setCoin_type(2);
	    			//1:广告费 2:辅导奖 3:提现 4:充值 5:互转 6:转电子币 7:购物 8:重消 9:报单
	    			recCoinTrackDto.setCreate_type(5);
	    			recCoinTrackDto.setCoin_num(trans_elect_coin);
	    			recCoinTrackDto.setComments(loginUser.getUser_code()+"转入");
	    			//发送方用户id写入接收方oper_user_id中
	    			recCoinTrackDto.setOper_user_id(Integer.valueOf(loginUser.getUser_id()));
	    			//查询接收方电子币账户
	    			AccoutInfoDto recaccoutInfo = new AccoutInfoDto();
	    			recaccoutInfo.setUser_code(recCoinTrackDto.getUser_code());
	    	    	AccoutInfoDto recAccoutInfoDto = accoutInfoService.queryAccountInfo(recaccoutInfo);
	    	    	Double recelectCoin = recAccoutInfoDto.getElect_coin();
	    	    	String balance_comments = "电子账户余额:"+(recelectCoin+trans_elect_coin);
	    			recCoinTrackDto.setBalance_comments(balance_comments);
	    			coinTrackService.insertCoinTrack(loginUser, recCoinTrackDto);
	    			//发送方
	    			CoinTrackDto sendCoinTrackDto = new CoinTrackDto();
	    			sendCoinTrackDto.setCoin_type(2);
	    			sendCoinTrackDto.setCreate_type(5);
	    			sendCoinTrackDto.setCoin_num(trans_elect_coin*-1);
	    			sendCoinTrackDto.setComments("转入"+recCoinTrackDto.getUser_code());
	    			//接收方用户id写入发送方oper_user_id中
	    			recCoinTrackDto.setOper_user_id(Integer.valueOf((String)recMap.get("retUserId")));
	    			String sbalance_comments = "电子账户余额:"+(electCoin+trans_elect_coin*-1);
	    			sendCoinTrackDto.setBalance_comments(sbalance_comments);
	    			coinTrackService.insertCoinTrack(loginUser, sendCoinTrackDto);
	    			//int test=0;
	    			//if(test==0){
	    			//	throw new RuntimeException("更新账户失败!");
	    			//}
	    			retMap.put("retCode", "3");
					retMap.put("retString", "成功");
	    		}
	    	}
		}
		return retMap;
	}
	
	@Override
	@Transactional
	public HashMap bonusToElect(User loginUser,CoinTrackDto coinTrackDto){
		HashMap retMap = new HashMap();
		//获取转入的奖金币
		Double trans_bonus_coin = coinTrackDto.getCoin_num();
		//获取当前用户的交易密码
		String trans_pwd = coinTrackDto.getComments();
    	//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double electCoin = retAccoutInfoDto.getElect_coin();
    	Double cashCoin = retAccoutInfoDto.getCash_coin();
    	if(cashCoin<trans_bonus_coin){
    		retMap.put("retCode", "1");
			retMap.put("retString", "转入的现金大于当前账户的现金 ");
    	}else{
    		//判断当前用户的交易密码
    		User queryUser = new User();
    		queryUser.setUser_id(loginUser.getUser_id());
    		List <User> userlist = userService.getListByCon(queryUser);
    		User retUser = userlist.get(0);
    		String userTransPwd = retUser.getTrans_pwd();
    		trans_pwd = CASMd5Utils.getPwd(trans_pwd,retUser.getUser_code());
    		if(!trans_pwd.equals(userTransPwd)){
    			retMap.put("retCode", "2");
				retMap.put("retString", "输入的交易密码错误!");
    		}else{
    			//接收方
        		CoinTrackDto recCoinTrackDto = new CoinTrackDto();
    			//1:奖金币 2:电子币 3:重消币
    			recCoinTrackDto.setCoin_type(2);
    			//1:广告费 2:辅导奖 3:提现 4:充值 5:互转 6:转电子币 7:购物 8:重消 9:报单
    			recCoinTrackDto.setCreate_type(6);
    			recCoinTrackDto.setCoin_num(trans_bonus_coin);
    			String balance_comments = "电子账户余额:"+(electCoin+trans_bonus_coin);
    			recCoinTrackDto.setBalance_comments(balance_comments);
    			coinTrackService.insertCoinTrack(loginUser, recCoinTrackDto);
    			//发送方
    			CoinTrackDto sendCoinTrackDto = new CoinTrackDto();
    			sendCoinTrackDto.setCoin_type(1);
    			sendCoinTrackDto.setCreate_type(6);
    			sendCoinTrackDto.setCoin_num(trans_bonus_coin*-1);
    			String sbalance_comments = "现金账户余额:"+(cashCoin+trans_bonus_coin*-1);
    			sendCoinTrackDto.setBalance_comments(sbalance_comments);
    			coinTrackService.insertCoinTrack(loginUser, sendCoinTrackDto);
    			retMap.put("retCode", "3");
    			retMap.put("retString", "成功");
    		}
    	}
    	return retMap;
	}
	
	@Override
	@Transactional
	public HashMap insertExtract(User loginUser,CoinTrackDto coinTrackDto){
		HashMap retMap = new HashMap();
		//获取提现的奖金币
		Double extract_bonus_coin = coinTrackDto.getCoin_num();
		//获取当前用户的交易密码
		String trans_pwd = coinTrackDto.getComments();
		//手续费
		HashMap map = new HashMap();
		map.put("cf_id", "counterFee");
		List list = frconfigService.queryFrCfgList(map);
		HashMap confRetMap = (HashMap)list.get(0);
		String cf_value = (String)confRetMap.get("cf_value");
		Double counter_num = Double.valueOf(cf_value);
		//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	//Double bonusCoin = (Double)retAccoutInfoDto.getBonus_coin();
    	//Double reconsmpCoin = (Double)retAccoutInfoDto.getReconsmp_coin();
    	//Double able_coin_num = bonusCoin-reconsmpCoin;
    	Double cashCoin = retAccoutInfoDto.getCash_coin();
    	if(cashCoin<extract_bonus_coin){
    		retMap.put("retCode", "0");
			retMap.put("retString", "提现金额大于可提现额度 ");
    	}else{
    		//判断可提取的是否小于手续费
    		if(extract_bonus_coin<counter_num){
    			retMap.put("retCode", "1");
    			retMap.put("retString", "提现金额小于手续费 "+counter_num+"元");
    		}else{
    			//判断当前用户的交易密码
        		User queryUser = new User();
        		queryUser.setUser_id(loginUser.getUser_id());
        		List <User> userlist = userService.getListByCon(queryUser);
        		User retUser = userlist.get(0);
        		String userTransPwd = retUser.getTrans_pwd();
        		trans_pwd = CASMd5Utils.getPwd(trans_pwd,retUser.getUser_code());
        		if(!trans_pwd.equals(userTransPwd)){
        			retMap.put("retCode", "2");
    				retMap.put("retString", "输入的交易密码错误!");
        		}else{
        			//写一条提现记录
        			CoinTrackDto sendCoinTrackDto = new CoinTrackDto();
        			sendCoinTrackDto.setCoin_type(1);
        			sendCoinTrackDto.setCreate_type(3);
        			sendCoinTrackDto.setCoin_num(extract_bonus_coin*-1);
        			sendCoinTrackDto.setCounter_num(counter_num);
        			//实际打款
        			Double act_num = extract_bonus_coin-counter_num;
        			sendCoinTrackDto.setAct_num(act_num);
        			//状态
        			sendCoinTrackDto.setApply_state("0");
        			String balance_comments = "现金账户余额:"+(cashCoin+extract_bonus_coin*-1);
        			sendCoinTrackDto.setBalance_comments(balance_comments);
        			coinTrackService.insertCoinTrack(loginUser, sendCoinTrackDto);
        			retMap.put("retCode", "3");
        			retMap.put("retString", "成功");
        		}
    		}
    	}
    	return retMap;
	}
}
