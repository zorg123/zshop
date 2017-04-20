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
import com.flyrui.financMgmt.pojo.CoinTrackDto;
import com.flyrui.financMgmt.service.CoinTrackService;
import com.flyrui.sys.dto.InfodictDto;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.InfodictService;
import com.flyrui.sys.service.NoticeService;
import com.flyrui.sys.service.UserService;

@ParentPackage("frcms_default")
@Namespace("/Infodict") //访问路径的包名
@Results({
	@Result(type="json", params={"root","result"})}) 
public class InfodictAction extends BaseAction {	
	
	private InfodictDto infodictDto;
	
    private static final Logger log = Logger.getLogger(NoticeAction.class);
    
    @Autowired
	public InfodictService infodictService;
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public CoinTrackService coinTrackService;
    
    @Action(value="queryInfoDictList")
	public String queryInfoDictList(){
    	List list = infodictService.queryInfoDictList(infodictDto);
		setResult(list);
    	return SUCCESS;
    }
    @Action(value="updateInfoDict")
	public String updateInfoDict(){
    	//根据传入的用户id更新用户星级
    	User paramUser = new User();
    	paramUser.setUser_id(infodictDto.getDict_id().toString());
    	paramUser.setUser_level(Integer.valueOf(infodictDto.getDict_value()));
    	userService.update(paramUser);
    	//根据掺入的入参更新InfoDict
    	int ret = infodictService.updateInfoDict(infodictDto);
		setResult(ret);
    	return SUCCESS;
    }
    
    @Action(value="insertInfoDict")
	public String insertInfoDict(){
    	HashMap retMap = new HashMap();
    	//根据掺入的用户编号查询用户id
    	//判断接收方用户是否存在
		CoinTrackDto recCoinTrackDto = new CoinTrackDto();
		recCoinTrackDto.setUser_code(infodictDto.getDict_code());
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
			String retUserId = (String)recMap.get("retUserId");
			//根据传入的用户id更新用户星级
	    	User paramUser = new User();
	    	paramUser.setUser_id(retUserId);
	    	paramUser.setUser_level(Integer.valueOf(infodictDto.getDict_value()));
	    	userService.update(paramUser);
	    	//新增一条
	    	infodictService.insertInfoDict(infodictDto);
	    	retMap.put("retCode", "3");
			retMap.put("retString", "成功");
			setResult(retMap);
	    	return SUCCESS;
		}
    }

	public InfodictDto getInfodictDto() {
		return infodictDto;
	}

	public void setInfodictDto(InfodictDto infodictDto) {
		this.infodictDto = infodictDto;
	}
    
}