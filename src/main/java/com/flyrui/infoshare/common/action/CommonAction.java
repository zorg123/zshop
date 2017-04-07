package com.flyrui.infoshare.common.action;

import java.io.File;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;

import com.flyrui.bus.excel.ImportExcel;
import com.flyrui.bus.service.BusService;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.pojo.bus.BusData;
import com.flyrui.dao.pojo.bus.BusInfo;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.infoshare.common.service.InfoCommonService;
import com.flyrui.salary.dto.SalaryDto;

@ParentPackage("frcms_default")
@Namespace("/InfoCommon")
@Results({ 
		@Result(type="json", params={"root","resultO"})})
public class CommonAction extends BaseAction {
	
	private static final Logger log = Logger.getLogger(CommonAction.class);
	
	@Autowired
	private InfoCommonService infoCommonService;
		
	@Action(value="queryById")
	public String queryBySqlId() throws Exception{
		Map param = getHttpRequestParam();
		resultO = infoCommonService.queryListBySqlId(param);
		return SUCCESS;
	}	
}
