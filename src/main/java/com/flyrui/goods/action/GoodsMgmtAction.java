package com.flyrui.goods.action;


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
import com.flyrui.goods.pojo.GoodsOrder;
import com.flyrui.goods.service.GoodsOrderService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.salary.service.SalaryService;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.UserService;

@ParentPackage("frcms_default")
@Namespace("/GoodsMgmt") //访问路径的包名
@Results({
		@Result(type="json", params={"root","result"})}) 
public class GoodsMgmtAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GoodsMgmtAction.class);	
	
	private GoodsOrder goodsOrder;
	
	public int rows; //每页大小
	
	public int page;//当前页号
	
	@Autowired
	public GoodsOrderService goodsOrderService;
	
	//会员充值分页查询
	@Action(value="getPagerListByCon")
	public String getPagerListByCon(){
    	PageModel<CoreUser> pageModel = goodsOrderService.getPagerListByCon(goodsOrder, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }

	public GoodsOrder getGoodsOrder() {
		return goodsOrder;
	}

	public void setGoodsOrder(GoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	
}
