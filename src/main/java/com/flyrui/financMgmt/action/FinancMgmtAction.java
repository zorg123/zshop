package com.flyrui.financMgmt.action;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ExcelExport;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.pojo.UserRechargeDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.financMgmt.service.UserRechargeService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.UserService;

@ParentPackage("frcms_default")
@Namespace("/FinancMgmt") //访问路径的包名
@Results({
		@Result(name="queryBonusAct", location = "/wap/financMgmt/bonusAct.jsp"),
		@Result(name="queryBonusInfo", location = "/wap/financMgmt/bonusInfo.jsp"),
		@Result(name="queryElectInfo", location = "/wap/financMgmt/electInfo.jsp"),
		@Result(name="initBonusToElect", location = "/wap/financMgmt/bonusToElect.jsp"),
		@Result(name="initExtract", location = "/wap/financMgmt/extract.jsp"),
		@Result(name="queryUserExtractInfo", location = "/wap/financMgmt/userExtractInfo.jsp"),
		@Result(name="queryAccoutFlowForWap", location = "/wap/financMgmt/accoutFlow.jsp"),
		@Result(name="accoutInfo", location = "/wap/user/accountInfo.jsp"),
		@Result(name="queryRecApply", location = "/wap/financMgmt/userRechargeApply.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class FinancMgmtAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(FinancMgmtAction.class);	
	
	private CoinTrackDto coinTrackDto;
	
	private AccoutInfoDto accoutInfo;
	
	private UserRechargeDto userRecharge;
	
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
	
	@Autowired
	public UserRechargeService userRechargeService;
	
	@Action("queryRecApply")    
    public String queryRecApply(){
		//从session中得到user_id
		User loginUser = getLoginUserInfo();
		if(null==userRecharge){
			userRecharge = new UserRechargeDto();
		}
		userRecharge.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel<CoreUser> pageModel = userRechargeService.getPagerListByCon(userRecharge, page, rows);
    	//返回值设置
    	result.put("ret",pageModel);
    	result.put("_code", "0");
    	result.put("_msg", "成功");
    	return "queryRecApply";
    }
	@Action(value="insertUserRec")
	public String insertUserRec(){
		User loginUser = getLoginUserInfo();
		int ret = userRechargeService.insert(loginUser,userRecharge);
		setResult(ret);
    	return SUCCESS;
    }
	
	//会员充值分页查询
	@Action(value="getPagerListByConRec")
	public String getPagerListByCon(){
    	//PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConRec(coinTrackDto, page, rows);
    	PageModel<CoreUser> pageModel = userRechargeService.getPagerListByConRec(userRecharge, page, rows);
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
	//报表统计--账户流水
	@Action(value="getPagerListByConAccountFlow")
	public String getPagerListByConAccountFlow(){
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConAccountFlow(coinTrackDto, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
	//报表统计--分红池明细
	@Action(value="getPagerListByConPoolShareout")
	public String getPagerListByConPoolShareout(){
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConPoolShareout(coinTrackDto, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
	//报表统计--账户明细
	@Action(value="getPagerListByConAccountInfo")
	public String getPagerListByConAccountInfo(){
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConAccountInfo(coinTrackDto, page, rows);
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
	//wap端账户流水
	@Action("queryAccoutFlowForWap")    
    public String queryAccoutFlowForWap(){
		//从session中得到user_id
		User loginUser = getLoginUserInfo();
		if(null==coinTrackDto){
			coinTrackDto = new CoinTrackDto();
		}
		coinTrackDto.setUser_id(Integer.valueOf(loginUser.getUser_id()));
    	if(rows==0){
    		rows=10;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConAccountFlowForWap(coinTrackDto, page, rows);
    	setResult(pageModel);
    	return "queryAccoutFlowForWap";
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
	
	//手机前台查询充值记录
	@Action("queryUserExtractInfo")    
    public String queryUserExtractInfo(){
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
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByConExtConf(coinTrackDto, page, rows);
    	//返回值设置
    	result.put("ret",pageModel);
    	result.put("_code", "0");
    	result.put("_msg", "成功");
    	return "queryUserExtractInfo";
    }
	 
	@Action(value="insertCoinTrack")
	public String insertCoinTrack(){
		User loginUser = getLoginUserInfo();
		int ret = coinTrackService.insertCoinTrack(loginUser,coinTrackDto);
		setResult(ret);
    	return SUCCESS;
    }
	//财务电子币充值
	@Action(value="recharge")
	public String recharge(){
		HashMap retMap = new HashMap();
		retMap = coinTrackService.recharge(getLoginUserInfo(), coinTrackDto);
		setResult(retMap);
    	return SUCCESS;
	}
	//电子币互转写表
	@Action(value="insertElectTrans")
	public String insertElectTrans(){
		HashMap retMap = new HashMap();
		retMap = coinTrackService.insertElectTrans(getLoginUserInfo(), coinTrackDto);
		setResult(retMap);
    	return SUCCESS;
    }
	
	//奖金币转电子币
	@Action(value="bonusToElect")
	public String bonusToElect(){
		HashMap retMap = new HashMap();
		retMap = coinTrackService.bonusToElect(getLoginUserInfo(), coinTrackDto);
		setResult(retMap);
    	return SUCCESS;
    }
	//查询当前可提现的金额=账户中奖金币-账户中重消币
	@Action(value="initBonusToElect")
	public String initBonusToElect(){
		//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	//Double able_coin_num = retAccoutInfoDto.getCash_coin();
    	Double able_coin_num = retAccoutInfoDto.getBonus_coin();
    	result.put("_code", "0");
    	result.put("_msg", "成功");
		result.put("able_coin_num", able_coin_num);
		return "initBonusToElect";
	}
	//查询当前可提现的金额=账户中奖金币
	@Action(value="initExtract")
	public String initExtract(){
		//查找账户奖金币总额
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	//Double able_coin_num = retAccoutInfoDto.getCash_coin();
    	Double able_coin_num = retAccoutInfoDto.getBonus_coin();
    	result.put("_code", "0");
    	result.put("_msg", "成功");
		result.put("able_coin_num", able_coin_num);
		String isHasAccountInfo ="1";
		if(StringUtils.isBlank(retAccoutInfoDto.getAccount_bank())) {
			isHasAccountInfo = "0";
		}
		result.put("isHasAccountInfo", isHasAccountInfo);
		return "initExtract";
	}
	//奖金币提现
	@Action(value="insertExtract")
	public String insertExtract() throws FRException{
		AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	if(retAccoutInfoDto==null || StringUtils.isBlank(retAccoutInfoDto.getAccount_bank())) {
    		throw new FRException(new FRError(ErrorConstants.USER_013));
    	}
		HashMap retMap = new HashMap();
		retMap = coinTrackService.insertExtract(getLoginUserInfo(), coinTrackDto);
		setResult(retMap);
    	return SUCCESS;
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
    	ExcelExport<UserRechargeDto> excelExport = new ExcelExport<UserRechargeDto>();    	
    	//List<BonusRecDto> retList = coinTrackService.getListByConRec(coinTrackDto);
    	List<UserRechargeDto> retList = userRechargeService.getListByConRec(userRecharge);
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
	
	@Action(value="getAccountInfo")
	public String getAccountInfo(){
		AccoutInfoDto ParamAccoutInfoDto = new AccoutInfoDto();
		ParamAccoutInfoDto.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
		accoutInfo = accoutInfoService.queryAccountInfo(ParamAccoutInfoDto);
		return "accoutInfo";
    }
	
	@Action(value="updateAccountInfo")
	public String updateAccountInfo(){
		accoutInfo.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
		int ret = accoutInfoService.update(accoutInfo);
		setResult(ret);
    	return SUCCESS;
    }
	
	@Action(value="deleteUserCharge")
	public String deleteUserCharge() throws FRException{
		if(userRecharge==null ||userRecharge.getRec_code() ==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));			
		}
		userRecharge.setUser_id(Integer.parseInt(getUserId()));
		int cnt = userRechargeService.deleteUserChargeByRecCode(userRecharge);
		if(cnt == 0){
			throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));	
		}
		setCommonSuccessReturn();
    	return SUCCESS;
    }
	
    public CoinTrackDto getCoinTrackDto() {
		return coinTrackDto;
	}

	public void setCoinTrackDto(CoinTrackDto coinTrackDto) {
		this.coinTrackDto = coinTrackDto;
	}
	public AccoutInfoDto getAccoutInfo() {
		return accoutInfo;
	}
	public void setAccoutInfo(AccoutInfoDto accoutInfo) {
		this.accoutInfo = accoutInfo;
	}

	public UserRechargeDto getUserRecharge() {
		return userRecharge;
	}

	public void setUserRecharge(UserRechargeDto userRecharge) {
		this.userRecharge = userRecharge;
	}
	
}
