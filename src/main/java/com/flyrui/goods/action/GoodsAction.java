package com.flyrui.goods.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.DateUtil;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.service.CommonService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.goods.pojo.Goods;
import com.flyrui.goods.pojo.GoodsOrder;
import com.flyrui.goods.pojo.GoodsRevAddr;
import com.flyrui.goods.pojo.TbChinaArea;
import com.flyrui.goods.service.GoodsOrderService;
import com.flyrui.goods.service.GoodsRevAddrService;
import com.flyrui.goods.service.GoodsService;
import com.flyrui.goods.service.TbChinaAreaService;
import com.flyrui.sys.service.UserService;

@ParentPackage("frcms_default")
@Namespace("/Goods") //访问路径的包名
@Results({
		@Result(name="goodsList", location = "/wap/goods/goodsList.jsp"),
		@Result(name="goodsDetail", location = "/wap/goods/goodsDetail.jsp"),
		@Result(name="queryUserOrder", location = "/wap/goods/queryUserOrder.jsp"),	
		@Result(name="goodsRevAddrEdit", location = "/wap/goods/goodsRevAddrEdit.jsp"),
		@Result(name="goodsRevAddrList", location = "/wap/goods/goodsRevAddr.jsp"),
		@Result(name="modGoodsRevAddr", location = "/wap/goods/goodsRevMod.jsp"),
		@Result(name="goodsSends", location = "/wap/goods/goodsSends.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class GoodsAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GoodsAction.class);	
    	  
    public String operType;
    
    public Goods goods = new Goods(); 
    public GoodsOrder goodsOrder = new GoodsOrder();
    public GoodsRevAddr goodsRevAddr = new GoodsRevAddr();
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	public String url;
	
	public String goodsOrderSplitNumber;
	
	public String conditionType;
	
	@Autowired
	public GoodsService goodsService;	
	
	@Autowired
	AccoutInfoService accoutInfoService;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	GoodsRevAddrService goodsRevAddrService;
	
	@Autowired
	TbChinaAreaService tbChinaAreaService;
	
	@Autowired
	GoodsOrderService goodsOrderService;
	
	@Autowired
	UserService userService;
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Action(value="goodsList")
    public String goodsList() throws FRException{    	
		if(goods.getCatalog_id()==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		goods.setState("1");
		goods.setEff_date(new Date());
		goods.setExp_date(new Date());
		if(rows==0){
    		rows=6;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel retPage = goodsService.getPagerListByCon(goods, page, rows);
    	setResult(retPage);
    	return "goodsList";
    }
    
	public String formatDouble(double s){
	    DecimalFormat fmt = new DecimalFormat("###0.00");
	    return fmt.format(s);
	}
	

	@Action(value="goodsDetail")
    public String goodsDetail() throws FRException{    	
		if(goods.getGoods_id()==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		goods.setState("1");
		goods.setEff_date(new Date());
		goods.setExp_date(new Date());
		Goods g = new Goods();
		BeanUtils.copyProperties(goods, g);
		g.setGoods_amount(null);
    	List<Goods> goodsList = goodsService.getListByCon(g);
    	if(goodsList.size()==0){
    		throw new FRException(new FRError("GOODS_001"));
    	}
    	Integer goodsAmount = goods.getGoods_amount();
    	goods = goodsList.get(0);    	
    	goods.setGoods_amount(goodsAmount);  
    	
    	//获取默认收货地址
    	goodsRevAddr.setUser_id(getUserId());
    	goodsRevAddr.setIs_default("1");
    	List<GoodsRevAddr> retList = goodsRevAddrService.getListByCon(goodsRevAddr);
    	if(retList.size()>0){
    		goodsRevAddr = retList.get(0);
    	}
    	return "goodsDetail";
    }
	
	@Action("checkCoin")
	public String checkCoin() throws FRException{
		
		if(goods.getPay_type()==null && goods.getGoods_amount() == null && goods.getGoods_price()==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}	
		
		AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getUserId()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	String payType = goods.getPay_type();
    	String checkCoin = "0";
    	Double totalFee = goods.getGoods_amount()*goods.getGoods_price();
    	//查询用户的账户信息，提示用户的
    	int coin = 0;
    	//校验是否是未激活用户，未激活用户只能购买一件
    	User user = getLoginUserInfo();
    	if("0".equals(user.getState()) && goods.getGoods_amount()>1) {
    		checkCoin = "-1";
    	}else {    		
    		if(retAccoutInfoDto!=null){
        		Double electCoin = (Double)retAccoutInfoDto.getElect_coin();
        		Double reconsmpCoin = (Double)retAccoutInfoDto.getReconsmp_coin();
        		if("2".equals(payType)){//电子币
        			if(electCoin>=totalFee){
        				checkCoin = "1";
        			}
        			coin = electCoin.intValue();
        		}else if("3".equals(payType)){//重销币
        			if(reconsmpCoin>=totalFee){
        				checkCoin = "1";
        			}
        			coin = reconsmpCoin.intValue();
        		}
        	}
    	}    	
    	Map<String, String> retMap = new HashMap<String, String>();
    	retMap.put("check", checkCoin);
    	retMap.put("coin", coin+"");
    	setResult(retMap);
		return SUCCESS;
	}
	
	@Action("accept")
	public String accept() throws FRException{
		if(goodsOrder.getGoods_id()==null && goodsOrder.getGoods_amount()==null && goodsOrder.getPay_type()==null
				){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		if(!"2".equals(goodsOrder.getPay_type()) && !"3".equals(goodsOrder.getPay_type())){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		if(goodsOrder.getGoods_amount()<1){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		
		if(goodsOrder.getRev_people() == null || "".equals(goodsOrder.getRev_people().trim())){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		//商品是否存在
		Goods tGoods = new Goods();
		tGoods.setGoods_id(goodsOrder.getGoods_id());	
		tGoods.setState("1");
		List<Goods> goodsList = goodsService.getListByCon(tGoods);
		if(goodsList.size()<1) {
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		tGoods = goodsList.get(0);
		
		if("1".equals(tGoods.getCatalog_id())) {
			//获取当前用户,会员商品只能购买一单
			User u = new User();
			u.setUser_id(getUserId());
			u = userService.getListByCon(u).get(0);
			if("0".equals(u.getState()) && goodsOrder.getGoods_amount()>1) {
				throw new FRException(new FRError(ErrorConstants.SHOP_UNACTIVE_USER_1));
			} 
		}
		
		
		goods = new Goods();
		goods.setGoods_id(goodsOrder.getGoods_id());
		goods.setState("1");
		goods.setEff_date(new Date());
		goods.setExp_date(new Date());
		goods.setCatalog_id(tGoods.getCatalog_id());
		//orderCode的组成规则 YYYYMMDDHH+8位序列
		String goodsOrderCode = "00000000"+commonService.getSequence("seq_goods_order");
		goodsOrderCode = DateUtil.formatDate(new Date(), "yyyyMMddHH")+goodsOrderCode.substring(goodsOrderCode.length()-8);
		goodsOrder.setOrder_code(goodsOrderCode);
		goodsOrder.setOrder_id(UUIDHexGenerator.generator());
		goodsOrder.setUser_id(getUserId());
		goodsOrder.setUser_name(getLoginUserInfo().getName());
		goodsOrder.setCreate_date(new Date());
		goodsOrder.setOrd_ip(getIp());
		goodsOrder.setState("0");
    	goodsService.accept(goods, goodsOrder,getLoginUserInfo());//用于事务
    	GoodsOrder goodsOrderLocal = new GoodsOrder();
    	goodsOrderLocal.setOrder_code(goodsOrder.getOrder_code());
    	setResult(goodsOrderLocal);
		return SUCCESS;
	}
	
	@Action("goodsRevAddrList")
	public String goodsRevAddrList(){
		if(url==null){
			url="/Goods/goodsRevAddrList.do";
		}
		goodsRevAddr.setUser_id(getUserId());
		if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
		PageModel pageModel = goodsRevAddrService.getPagerListByCon(goodsRevAddr, page, rows);
		setResult(pageModel);
		return "goodsRevAddrList";
	}
	
	@Action("goodsRevAddrListForSel")
	public String goodsRevAddrListForSel(){
		url="/Goods/goodsRevAddrListForSel.do";
		return goodsRevAddrList();
	}
	
	@Action("goodsRevAddrEdit")
	public String goodsRevAddrEdit(){
		
		if(goodsRevAddr.getAddr_id()!=null){
			List<GoodsRevAddr> goodsRevAddrList = goodsRevAddrService.getListByCon(goodsRevAddr);
			if(goodsRevAddrList.size()>0){
				goodsRevAddr = goodsRevAddrList.get(0);
			}
		}
		Map<String,List<TbChinaArea>> areaMap = new HashMap<String,List<TbChinaArea>>();
		
		//查询全国的省区县配置信息
		TbChinaArea tbChinaArea = new TbChinaArea();
		tbChinaArea.setLevel(2);
		List<TbChinaArea> provList = tbChinaAreaService.getListByCon(tbChinaArea);
		areaMap.put("prov",provList);
		if(goodsRevAddr.getRev_provice()==null){
			goodsRevAddr.setRev_provice("河南省");
		}
		
		if(provList.size()>0){
			TbChinaArea provAare = null;
			for(TbChinaArea tProv : provList){
				if(tProv.getName().equals(goodsRevAddr.getRev_provice())){
					provAare = tProv;
					break;
				}
			}
			if(provAare==null){
				provAare = provList.get(0);
			}
			tbChinaArea.setPid(provAare.getId());
			tbChinaArea.setLevel(3);
			List<TbChinaArea> provList2 = tbChinaAreaService.getListByCon(tbChinaArea);
			areaMap.put("zone",provList2);
			if(provList2.size()>0){
				TbChinaArea zoneAare = null;
				for(TbChinaArea tProv : provList2){
					if(tProv.getName().equals(goodsRevAddr.getRev_city())){
						zoneAare = tProv;
						break;
					}
				}
				if(zoneAare==null){
					zoneAare = provList2.get(0);
				}
				tbChinaArea.setPid(zoneAare.getId());
				tbChinaArea.setLevel(4);
				List<TbChinaArea> provList3 = tbChinaAreaService.getListByCon(tbChinaArea);
				areaMap.put("xian",provList3);
			}
		}
		setResult(areaMap);
		return "goodsRevAddrEdit";
	}
	
	@Action("goodsRevAddrUpdate")
    public String goodsRevAddrUpdate(){
		if(goodsRevAddr.getAddr_id() !=null){
			goodsRevAddr.setUser_id(getUserId());			
			goodsRevAddrService.update(goodsRevAddr);
		}else{
			String addrId = commonService.getSequence("seq_goods_revaddr_id");
			goodsRevAddr.setUser_id(getUserId());
			goodsRevAddr.setAddr_id(Integer.parseInt(addrId));
			goodsRevAddr.setCreate_date(new Date());
			goodsRevAddr.setState("1");
			GoodsRevAddr goodsRevAddrTemp = new GoodsRevAddr();
			goodsRevAddrTemp.setUser_id(getUserId());
			//查询是否已有收货地址，如果没有，则设置第一个为默认地址
			List<GoodsRevAddr> retList = goodsRevAddrService.getListByCon(goodsRevAddrTemp);
			if(retList.size() == 0){
				goodsRevAddr.setIs_default("1");
			}else{
				goodsRevAddr.setIs_default("0");
			}
			goodsRevAddrService.insert(goodsRevAddr);
		}
		setCommonSuccessReturn();
    	return SUCCESS;
    }
	
	@Action("getNextLevelAddr")
    public String getNextLevelAddr() throws FRException{
		List<TbChinaArea> retList = new ArrayList<TbChinaArea>();
		if(ids !=null){
			Integer id = null;
			try{
				id = Integer.parseInt(ids);
			}catch(Exception ex){
				throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
			}
			TbChinaArea tbChinaArea = new TbChinaArea();
			tbChinaArea.setPid(id);
			retList = tbChinaAreaService.getListByCon(tbChinaArea);
		}else{
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		setResult(retList);
    	return SUCCESS;
    }
	
	@Action("queryUserOrder")
    public String queryUserOrder(){
		GoodsOrder  goodsOrder = new GoodsOrder();
		if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
    	goodsOrder.setUser_id(getUserId());
    	if("0".equals(conditionType) || "1".equals(conditionType)|| "2".equals(conditionType)) { //根据状态查询
    		goodsOrder.setState(conditionType);
    	}else if("4".equals(conditionType)) {
    		 Calendar c = Calendar.getInstance();
    		 c.setTime(new Date());
    	     c.add(Calendar.DATE, - 30);
    		 goodsOrder.setState_date_start(DateUtil.formatDate(new Date(c.getTimeInMillis()),DateUtil.DATE_FORMAT_1));
    	}
		PageModel pageModel = goodsOrderService.getPagerListByCon(goodsOrder, page, rows);
		setResult(pageModel);
    	return "queryUserOrder";
    }
    
	 @Action("delGoodsRevAddr")
    public String delGoodsRevAddr() throws FRException{
    	
    	if(ids==null){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}    	
    	String userId = getUserId();
    	String[] idStr = ids.split(";");
    	goodsRevAddr.setUser_id(userId);
    	goodsRevAddr.setAddr_id(Integer.parseInt(idStr[0]));    	
    	int cnt = goodsRevAddrService.delete(goodsRevAddr);
    	if(cnt==0){
    		throw new FRException(new FRError("SYS_ERR010"));
    	}else{
    		setCommonSuccessReturn();
    	}
    	return SUCCESS;
    }
	 
	 @Action("setDefaultRevAddr")
	 public String setDefaultRevAddr() throws FRException{	    	
	    	if(goodsRevAddr.getAddr_id() ==null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}   
	    	
	    	String userId = getUserId();	    	
	    	goodsRevAddr.setUser_id(userId);
	    	List<GoodsRevAddr> retList = goodsRevAddrService.getListByCon(goodsRevAddr);
	    	if(retList.size()==0){
	    		throw new FRException(new FRError(ErrorConstants.NO_DATA_FOUND));
	    	}
	    	int cnt = goodsRevAddrService.updateDefaultAddrByUserId(goodsRevAddr);
	    	if(cnt==0){
	    		throw new FRException(new FRError("SYS_ERR010"));
	    	}else{
	    		setCommonSuccessReturn();
	    	}
	    	return SUCCESS;
	 }
	 
	 @Action("modGoodsRevAddr")
	 public String modGoodsRevAddr() throws FRException{	    	
	    	if(goodsOrder.getOrder_id()==null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}	    	
	    	List<GoodsOrder> retList = goodsOrderService.getListByCon(goodsOrder);
	    	if(retList.size()==0){
	    		throw new FRException(new FRError(ErrorConstants.NO_DATA_FOUND));
	    	}	    	
	    	goodsOrder = retList.get(0); 
	    	//查询订单的收货人信息，如果没有，则查询默认的收货信息
	    	if(CommonUtils.isBlankStr(goodsOrder.getRev_people())){
	    		//查询默认地址
	    		//获取默认收货地址
	        	goodsRevAddr.setUser_id(getUserId());
	        	goodsRevAddr.setIs_default("1");
	        	List<GoodsRevAddr> addrRetList = goodsRevAddrService.getListByCon(goodsRevAddr);
	        	if(addrRetList.size()>0){
	        		goodsRevAddr = addrRetList.get(0);
	        	}
	    	}else{
	    		goodsRevAddr.setRev_addr(goodsOrder.getRev_addr());
	    		goodsRevAddr.setRev_link_phone(goodsOrder.getRev_link_phone());
	    		goodsRevAddr.setRev_people(goodsOrder.getRev_people());
	    		goodsRevAddr.setRev_provice(goodsOrder.getRev_area());
	    	}
	    	return "modGoodsRevAddr";
	 }
	 
	 @Action("goodsSends")
	 public String goodsSends() throws FRException{	    	
	    	if(goodsOrder.getOrder_id()==null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}	    	
	    	List<GoodsOrder> retList = goodsOrderService.getListByCon(goodsOrder);
	    	if(retList.size()==0){
	    		throw new FRException(new FRError(ErrorConstants.NO_DATA_FOUND));
	    	}	    	
	    	goodsOrder = retList.get(0); 
	    	//查询订单的收货人信息，如果没有，则查询默认的收货信息
	    	if(CommonUtils.isBlankStr(goodsOrder.getRev_people())){
	    		//查询默认地址
	    		//获取默认收货地址
	        	goodsRevAddr.setUser_id(getUserId());
	        	goodsRevAddr.setIs_default("1");
	        	List<GoodsRevAddr> addrRetList = goodsRevAddrService.getListByCon(goodsRevAddr);
	        	if(addrRetList.size()>0){
	        		goodsRevAddr = addrRetList.get(0);
	        	}
	    	}else{
	    		goodsRevAddr.setRev_addr(goodsOrder.getRev_addr());
	    		goodsRevAddr.setRev_link_phone(goodsOrder.getRev_link_phone());
	    		goodsRevAddr.setRev_people(goodsOrder.getRev_people());
	    		goodsRevAddr.setRev_provice(goodsOrder.getRev_area());
	    	}
	    	return "goodsSends";
	 }
	 @Action("modGoodsRev")
	 public String modGoodsRev() throws FRException{	    	
	    	if(goodsOrder.getOrder_id()==null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	if(goodsOrder.getRev_addr()==null || goodsOrder.getRev_people() == null || goodsOrder.getRev_link_phone()== null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	GoodsOrder newGoodsOrder =new GoodsOrder();
	    	newGoodsOrder.setOrder_id(goodsOrder.getOrder_id());
	    	newGoodsOrder.setRev_addr(goodsOrder.getRev_addr());
	    	newGoodsOrder.setRev_area(goodsOrder.getRev_area());
	    	newGoodsOrder.setRev_link_phone(goodsOrder.getRev_link_phone());
	    	newGoodsOrder.setRev_people(goodsOrder.getRev_people());
	    	newGoodsOrder.setUser_id(getUserId());
	    	int cnt = goodsOrderService.update(newGoodsOrder);
	    	if(cnt==0){
	    		throw new FRException(new FRError(ErrorConstants.NO_DATA_FOUND));
	    	}	    	
	    	setCommonSuccessReturn();
	    	return SUCCESS;
	 }
	 
	 @Action("goodsSendsAccept")
	 public String goodsSendsAccept() throws FRException{	    	
	    	if(goodsOrder.getOrder_id()==null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	if(goodsOrder.getRev_addr()==null || goodsOrder.getRev_people() == null || goodsOrder.getRev_link_phone()== null || goodsOrderSplitNumber == null){
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	int goodsOrderSplitNumberI = 0;
	    	try {
	    		goodsOrderSplitNumberI = Integer.parseInt(goodsOrderSplitNumber);
	    	}catch(Exception ex) {
	    		log.error("传入的数字错误",ex);
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	GoodsOrder newGoodsOrder =new GoodsOrder();
	    	newGoodsOrder.setOrder_id(goodsOrder.getOrder_id());
	    	List<GoodsOrder> goodsList = goodsOrderService.getListByCon(newGoodsOrder);
	    	if(goodsList.size()<1) {
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	
	    	newGoodsOrder = goodsList.get(0);
	    	if(newGoodsOrder.getGoods_amount()<goodsOrderSplitNumberI) {
	    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
	    	}
	    	goodsOrder.setGoods_amount(newGoodsOrder.getGoods_amount());
	    	goodsOrderService.goodsSend(goodsOrder,goodsOrderSplitNumberI);	    	
	    	setCommonSuccessReturn();
	    	return SUCCESS;
	 }
}
