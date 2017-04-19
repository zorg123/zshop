package com.flyrui.financMgmt.action;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyrui.bus.service.BusService;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ExcelExport;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.salary.service.SalaryService;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.UserService;

@ParentPackage("frcms_default")
@Namespace("/FinancMgmt") //访问路径的包名
@Results({
		@Result(name="queryBonusAct", location = "/wap/financMgmt/bonusAct.jsp"),
		@Result(name="queryBonusInfo", location = "/wap/financMgmt/bonusInfo.jsp"),
		@Result(name="queryElectInfo", location = "/wap/financMgmt/electInfo.jsp"),
		@Result(name="initExtract", location = "/wap/financMgmt/extract.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class FinancMgmtAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(FinancMgmtAction.class);	
	
	private CoinTrackDto coinTrackDto;
	
	public int rows; //每页大小
	
	public int page;//当前页号
	
	@Autowired
	public CoinTrackService coinTrackService;
	
	@Autowired
	public AccoutInfoService accoutInfoService;
	
	@Autowired
	public FrconfigService frconfigService;
	
	@Autowired
	public UserService userService;
	
	//会员充值分页查询
	@Action(value="getPagerListByConRec")
	public String getPagerListByCon(){
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConRec(coinTrackDto, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
	//提现确认分页查询
	@Action(value="getPagerListByConExtConf")
	public String getPagerListByConExtConf(){
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConExtConf(coinTrackDto, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
	
	//奖金实收分页查询
	@Action("queryBonusAct")    
    public String queryBonusAct(){
		//从session中得到user_id
		User loginUser = getLoginUserInfo();
		if(null==coinTrackDto){
			coinTrackDto = new CoinTrackDto();
		}
		coinTrackDto.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConBonusAct(coinTrackDto, page, rows);
    	//查找实收总额 (只包含正值)
    	HashMap bonusActMap = coinTrackService.getBonusActSum(coinTrackDto);
    	Double bonusActSum = (Double)bonusActMap.get("bonusActSum");
    	Double reconsmpActSum = (Double)bonusActMap.get("reconsmpActSum");
    	Double actSum = (Double)bonusActMap.get("actSum");
    	//返回值设置
    	result.put("ret",pageModel);
    	result.put("_code", "0");
    	result.put("_msg", "成功");
		result.put("bonusActSum", bonusActSum);
		result.put("reconsmpActSum", reconsmpActSum);
		result.put("actSum", actSum);
    	return "queryBonusAct";
    }
	
	//奖金币明细
	@Action("queryBonusInfo")    
    public String queryBonusInfo(){
		//从session中得到user_id
		User loginUser = getLoginUserInfo();
		if(null==coinTrackDto){
			coinTrackDto = new CoinTrackDto();
		}
		coinTrackDto.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConBonusInfo(coinTrackDto, page, rows);
    	//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double bonusCoin = (Double)retAccoutInfoDto.getBonus_coin();
    	//返回值设置
    	result.put("ret",pageModel);
    	result.put("_code", "0");
    	result.put("_msg", "成功");
		result.put("bonusCoin", bonusCoin);
    	return "queryBonusInfo";
    }
	
	//电子币明细
	@Action("queryElectInfo")    
    public String queryElectInfo(){
		//从session中得到user_id
		User loginUser = getLoginUserInfo();
		if(null==coinTrackDto){
			coinTrackDto = new CoinTrackDto();
		}
		coinTrackDto.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConElectInfo(coinTrackDto, page, rows);
    	//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double electCoin = (Double)retAccoutInfoDto.getElect_coin();
    	//返回值设置
    	result.put("ret",pageModel);
    	result.put("_code", "0");
    	result.put("_msg", "成功");
		result.put("electCoin", electCoin);
    	return "queryElectInfo";
    }
	 
	@Action(value="insertCoinTrack")
	public String insertCoinTrack(){
		User loginUser = getLoginUserInfo();
		int ret = coinTrackService.insertCoinTrack(loginUser,coinTrackDto);
		setResult(ret);
    	return SUCCESS;
    }
	//财务充值
	@Action(value="recharge")
	public String recharge(){
		HashMap retMap = new HashMap();
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
			setResult(retMap);
	    	return SUCCESS; 
		}else{
			//接收方
    		CoinTrackDto paramCoinTrackDto = new CoinTrackDto();
    		paramCoinTrackDto.setUser_code(user_code);
			//1:奖金币 2:电子币 3:重消币
    		paramCoinTrackDto.setCoin_type(2);
			//1:广告费 2:辅导奖 3:提现 4:充值 5:互转 6:转电子币 7:购物 8:重消 9:报单
    		paramCoinTrackDto.setCreate_type(4);
    		paramCoinTrackDto.setCoin_num(elect_coin);
    		paramCoinTrackDto.setFile_info(file_info);
			coinTrackService.insertCoinTrack(getLoginUserInfo(), paramCoinTrackDto);
			retMap.put("retCode", "3");
			retMap.put("retString", "成功");
			setResult(retMap);
	    	return SUCCESS;
		}
    }
	//电子币互转写表
	@Action(value="insertElectTrans")
	public String insertElectTrans(){
		HashMap retMap = new HashMap();
		//retCode:retString -1:输入的工号不存在 0:未激活 1:转入的电子币大于当前账户的电子币 2:输入的交易密码错误!3:成功
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
			setResult(retMap);
	    	return SUCCESS; 
		}else{
			//查询当前用户的电子币
			AccoutInfoDto accoutInfo = new AccoutInfoDto();
	    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
	    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
	    	Double electCoin = (Double)retAccoutInfoDto.getElect_coin();
	    	if(electCoin<trans_elect_coin){
	    		retMap.put("retCode", "1");
				retMap.put("retString", "转入的电子币大于当前账户的电子币");
				setResult(retMap);
		    	return SUCCESS; 
	    	}else{
	    		//判断当前用户的交易密码
	    		User queryUser = new User();
	    		queryUser.setUser_id(getLoginUserInfo().getUser_id());
	    		List <User> userlist = userService.getListByCon(queryUser);
	    		User retUser = userlist.get(0);
	    		String userTransPwd = retUser.getTrans_pwd();
	    		if(!trans_pwd.equals(userTransPwd)){
	    			retMap.put("retCode", "2");
					retMap.put("retString", "输入的交易密码错误!");
					setResult(retMap);
			    	return SUCCESS; 
	    		}else{
	    			//接收方
	    			//1:奖金币 2:电子币 3:重消币
	    			recCoinTrackDto.setCoin_type(2);
	    			//1:广告费 2:辅导奖 3:提现 4:充值 5:互转 6:转电子币 7:购物 8:重消 9:报单
	    			recCoinTrackDto.setCreate_type(5);
	    			recCoinTrackDto.setCoin_num(trans_elect_coin);
	    			recCoinTrackDto.setComments(getLoginUserInfo().getUser_code()+"转入");
	    			//发送方用户id写入接收方oper_user_id中
	    			recCoinTrackDto.setOper_user_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
	    			int order_id = coinTrackService.insertCoinTrack(getLoginUserInfo(), recCoinTrackDto);
	    			//发送方
	    			CoinTrackDto sendCoinTrackDto = new CoinTrackDto();
	    			sendCoinTrackDto.setCoin_type(2);
	    			sendCoinTrackDto.setCreate_type(5);
	    			sendCoinTrackDto.setCoin_num(trans_elect_coin*-1);
	    			sendCoinTrackDto.setOrder_id(order_id);
	    			sendCoinTrackDto.setComments("转入"+recCoinTrackDto.getUser_code());
	    			//接收方用户id写入发送方oper_user_id中
	    			recCoinTrackDto.setOper_user_id((Integer)recMap.get("retUserId"));
	    			coinTrackService.insertCoinTrack(getLoginUserInfo(), sendCoinTrackDto);
	    			retMap.put("retCode", "3");
					retMap.put("retString", "成功");
					setResult(retMap);
			    	return SUCCESS;
	    		}
	    	}
		}
    }
	
	//奖金币转电子币
	@Action(value="bonusToElect")
	public String bonusToElect(){
		//获取转入的奖金币
		Double trans_bonus_coin = coinTrackDto.getCoin_num();
		//获取当前用户的交易密码
		String trans_pwd = coinTrackDto.getComments();
		HashMap retMap = new HashMap();
		//retCode:retString -1:转入的奖金币大于当前账户的奖金币 3:成功
		//查询当前用户的奖金币
		AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double bonusCoin = (Double)retAccoutInfoDto.getBonus_coin();
    	if(bonusCoin<trans_bonus_coin){
    		retMap.put("retCode", "1");
			retMap.put("retString", "转入的奖金币大于当前账户的奖金币 ");
			setResult(retMap);
	    	return SUCCESS; 
    	}else{
    		//判断当前用户的交易密码
    		User queryUser = new User();
    		queryUser.setUser_id(getLoginUserInfo().getUser_id());
    		List <User> userlist = userService.getListByCon(queryUser);
    		User retUser = userlist.get(0);
    		String userTransPwd = retUser.getTrans_pwd();
    		if(!trans_pwd.equals(userTransPwd)){
    			retMap.put("retCode", "2");
				retMap.put("retString", "输入的交易密码错误!");
				setResult(retMap);
		    	return SUCCESS; 
    		}else{
    			//接收方
        		CoinTrackDto recCoinTrackDto = new CoinTrackDto();
    			//1:奖金币 2:电子币 3:重消币
    			recCoinTrackDto.setCoin_type(2);
    			//1:广告费 2:辅导奖 3:提现 4:充值 5:互转 6:转电子币 7:购物 8:重消 9:报单
    			recCoinTrackDto.setCreate_type(6);
    			recCoinTrackDto.setCoin_num(trans_bonus_coin);
    			int order_id = coinTrackService.insertCoinTrack(getLoginUserInfo(), recCoinTrackDto);
    			//发送方
    			CoinTrackDto sendCoinTrackDto = new CoinTrackDto();
    			sendCoinTrackDto.setCoin_type(1);
    			sendCoinTrackDto.setCreate_type(6);
    			sendCoinTrackDto.setCoin_num(trans_bonus_coin*-1);
    			sendCoinTrackDto.setOrder_id(order_id);
    			coinTrackService.insertCoinTrack(getLoginUserInfo(), sendCoinTrackDto);
    			retMap.put("retCode", "3");
    			retMap.put("retString", "成功");
    			setResult(retMap);
    	    	return SUCCESS;
    		}
    	}
    }
	//查询当前可提现的金额=账户中奖金币-账户中重消币
	@Action(value="initExtract")
	public String initExtract(){
		//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double bonusCoin = (Double)retAccoutInfoDto.getBonus_coin();
    	Double reconsmpCoin = (Double)retAccoutInfoDto.getReconsmp_coin();
    	Double able_coin_num = bonusCoin-reconsmpCoin;
    	result.put("_code", "0");
    	result.put("_msg", "成功");
		result.put("able_coin_num", able_coin_num);
		return "initExtract";
	}
	//写入
	@Action(value="insertExtract")
	public String insertExtract(){
		//获取提现的奖金币
		Double extract_bonus_coin = coinTrackDto.getCoin_num();
		//获取当前用户的交易密码
		String trans_pwd = coinTrackDto.getComments();
		HashMap retMap = new HashMap();
		//retCode:retString -1:转入的奖金币大于当前账户的奖金币 3:成功
		//手续费
		HashMap map = new HashMap();
		map.put("cf_id", "counterFee");
		List list = frconfigService.queryFrCfgList(map);
		HashMap confRetMap = (HashMap)list.get(0);
		String cf_value = (String)confRetMap.get("cf_value");
		Double counter_num = Double.valueOf(cf_value);
		//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double bonusCoin = (Double)retAccoutInfoDto.getBonus_coin();
    	Double reconsmpCoin = (Double)retAccoutInfoDto.getReconsmp_coin();
    	Double able_coin_num = bonusCoin-reconsmpCoin;
    	if(able_coin_num<extract_bonus_coin){
    		retMap.put("retCode", "0");
			retMap.put("retString", "提现金额大于可提现额度 ");
			setResult(retMap);
	    	return SUCCESS; 
    	}else{
    		//判断可提取的是否小于手续费
    		if(extract_bonus_coin<counter_num){
    			retMap.put("retCode", "1");
    			retMap.put("retString", "提现金额小于手续费 "+counter_num+"元");
    			setResult(retMap);
    	    	return SUCCESS; 
    		}else{
    			//判断当前用户的交易密码
        		User queryUser = new User();
        		queryUser.setUser_id(getLoginUserInfo().getUser_id());
        		List <User> userlist = userService.getListByCon(queryUser);
        		User retUser = userlist.get(0);
        		String userTransPwd = retUser.getTrans_pwd();
        		if(!trans_pwd.equals(userTransPwd)){
        			retMap.put("retCode", "2");
    				retMap.put("retString", "输入的交易密码错误!");
    				setResult(retMap);
    		    	return SUCCESS; 
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
        			coinTrackService.insertCoinTrack(getLoginUserInfo(), sendCoinTrackDto);
        			retMap.put("retCode", "3");
        			retMap.put("retString", "成功");
        			setResult(retMap);
        	    	return SUCCESS;
        		}
    		}
    	}
	}
	@Action(value="getUserByCode")
	public String getUserByCode(){
		HashMap retmap = coinTrackService.getUserByCode(coinTrackDto);
		setResult(retmap);
    	return SUCCESS;
    }
	//会员充值导出
	@Action(value="eportCoinTrackRec")
	public  String eportCoinTrackRec() throws Exception{  
    	ExcelExport<CoinTrackDto> excelExport = new ExcelExport<CoinTrackDto>();    	
    	List<CoinTrackDto> retList = coinTrackService.getListByConRec(coinTrackDto);
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel("会员充值", retList, os);
        byte[] content=os.toByteArray();
        setExcelName("会员充值");
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
	//提现确认导出
	@Action(value="eportCoinTrackExtConf")
	public  String eportCoinTrackExtConf() throws Exception{  
    	ExcelExport<CoinTrackDto> excelExport = new ExcelExport<CoinTrackDto>();    	
    	List<CoinTrackDto> retList = coinTrackService.getListByConExtConf(coinTrackDto);
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel("提现确认", retList, os);
        byte[] content=os.toByteArray();
        setExcelName("提现确认");
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
	
	@Action(value="updateCoinTrack")
	public String updateCoinTrack(){
		User loginUser = getLoginUserInfo();
		int ret = coinTrackService.updateCoinTrack(loginUser,coinTrackDto);
		setResult(ret);
    	return SUCCESS;
    }
	
    public CoinTrackDto getCoinTrackDto() {
		return coinTrackDto;
	}

	public void setCoinTrackDto(CoinTrackDto coinTrackDto) {
		this.coinTrackDto = coinTrackDto;
	}
}
