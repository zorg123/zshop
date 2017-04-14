package com.flyrui.sys.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.pojo.sys.Notice;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.NoticeService;

@ParentPackage("frcms_default")
@Namespace("/Frconfig") //访问路径的包名
@Results({
	@Result(type="json", params={"root","result"})}) 
public class FrconfigAction extends BaseAction {	
	
	private String cf_id;
	private String cf_module;
	private String cf_value;
    private static final Logger log = Logger.getLogger(NoticeAction.class);
    
    @Autowired
	public FrconfigService frconfigService;
    
    @Action(value="updateFrConfig")
	public String updateFrConfig(){
    	HashMap map = new HashMap();
    	map.put("cf_id", this.getCf_id());
    	map.put("cf_value", this.getCf_value());
		int ret = frconfigService.updateFrConfig(map);
		setResult(ret);
    	return SUCCESS;
    }
    
    @Action(value="queryFrCfgList")
	public String queryFrCfgList(){
    	HashMap map = new HashMap();
    	map.put("cf_module", this.getCf_module());
    	map.put("cf_id", this.getCf_id());
		List list = frconfigService.queryFrCfgList(map);
		setResult(list);
    	return SUCCESS;
    }

	public String getCf_id() {
		return cf_id;
	}

	public void setCf_id(String cf_id) {
		this.cf_id = cf_id;
	}

	public String getCf_module() {
		return cf_module;
	}

	public void setCf_module(String cf_module) {
		this.cf_module = cf_module;
	}

	public String getCf_value() {
		return cf_value;
	}

	public void setCf_value(String cf_value) {
		this.cf_value = cf_value;
	}
    
}