package com.flyrui.financMgmt.action;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

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
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.salary.service.SalaryService;

@ParentPackage("frcms_default")
@Namespace("/FinancMgmt") //访问路径的包名
@Results({
		@Result(name="manageEdit", location = "/manage/manageEdit.jsp"),
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
	
	@Action(value="getPagerListByCon")
	public String getPagerListByCon(){
    	PageModel<CoreUser> pageModel = coinTrackService.getPagerListByCon(coinTrackDto, page, rows);
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
	 
	@Action(value="insertCoinTrack")
	public String insertCoinTrack(){
		User loginUser = getLoginUserInfo();
		int ret = coinTrackService.insertCoinTrack(loginUser,coinTrackDto);
		setResult(ret);
    	return SUCCESS;
    }
	
	@Action(value="getUserByCode")
	public String getUserByCode(){
		HashMap retmap = coinTrackService.getUserByCode(coinTrackDto);
		setResult(retmap);
    	return SUCCESS;
    }
	
	@Action(value="eportCoinTrack")
	public  String eportCoinTrack() throws Exception{  
    	ExcelExport<CoinTrackDto> excelExport = new ExcelExport<CoinTrackDto>();    	
    	List<CoinTrackDto> retList = coinTrackService.getListByCon(coinTrackDto);
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel("会员充值", retList, os);
        byte[] content=os.toByteArray();
        setExcelName("会员充值");
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
	//提现确认导出
	@Action(value="eportExtConfCoinTrack")
	public  String eportExtConfCoinTrack() throws Exception{  
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
