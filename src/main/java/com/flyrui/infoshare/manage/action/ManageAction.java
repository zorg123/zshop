package com.flyrui.infoshare.manage.action;

import java.util.ArrayList;
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

import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.infoshare.common.pojo.InfoServFile;
import com.flyrui.infoshare.common.service.InfoCommonService;
import com.flyrui.infoshare.common.service.InfoServFileService;
import com.flyrui.infoshare.manage.pojo.InfoManage;
import com.flyrui.infoshare.manage.service.InfoManageService;
import com.flyrui.infoshare.staff.pojo.CoreUser;

@ParentPackage("frcms_default")
@Namespace("/Manage") //访问路径的包名
@Results({
		@Result(name="manageEdit", location = "/manage/manageEdit.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class ManageAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ManageAction.class);	
    	  
    public String operType;
    
    public InfoManage infoManage = new InfoManage();   
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	public List<InfoServFile> infoServFileList = new ArrayList<InfoServFile>();
	
	public List<InfoManage> infoManageList ;
	
	@Autowired
	public InfoManageService infoManageService;
	
	@Autowired
	private InfoCommonService infoCommonService;
	
	@Autowired
	private InfoServFileService infoServFileService;
	
    
    public InfoManage getInfoManage() {
		return infoManage;
	}
	public void setInfoManage(InfoManage infoManage) {
		this.infoManage = infoManage;
	}
	
	public List<InfoServFile> getInfoServFileList() {
		return infoServFileList;
	}

	public void setInfoServFileList(List<InfoServFile> infoServFileList) {
		this.infoServFileList = infoServFileList;
	}
	
	@Action(value="queryManageList")
    public String queryManageList(){    	
		if(infoManage!=null){
			infoManage.setSeq(0);
		}
    	if(infoManage.getTitile()!=null ){
    		infoManage.setTitile("%"+infoManage.getTitile()+"%");
    	}
    	PageModel<CoreUser> pageModel = infoManageService.getPagerListByCon(infoManage, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    @Action(value="manageEdit")
    public String manageEdit() throws FRException{   
    	InfoServFile infoServFile = new InfoServFile();
    	infoServFile.setRela_id(infoManage.getManage_id());
    	infoServFileList = infoServFileService.queryServFileByRelaId(infoServFile);
    	if("2".equals(operType)){
    		List<InfoManage> infoManageTemp =  infoManageService.getListByCon(infoManage);    	
    		if(infoManageTemp!=null && infoManageTemp.size()>0){
    			infoManage = infoManageTemp.get(0);
    			infoManage.setInfoServFileList(infoServFileList);
    		}
    	}else{
    		infoManage = new InfoManage();
    	}
    	return "manageEdit";
    }
    
    @Action(value="insert")
    public String insert() throws FRException{
    	int cnt = infoManageService.insert(infoManage);
    	setResult(cnt);
    	return SUCCESS;
    }
    
    @Action(value="update")
    public String update() throws FRException{
    	Map m = getHttpRequestParam();
    	if(infoManage!=null){
    		infoManage.setInfoServFileList(infoServFileList);
    		int cnt= infoManageService.update(infoManage);
    		setResult(cnt);
    	}
    	return SUCCESS;
    }    
    
    @Action(value="deleteByIds")
    public String deleteByIds()  throws FRException{
    	int delCount = infoManageService.deleteByIds(ids);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }  
    
    private String checkDictValue(String sqlId,String value,String dictType){
    	String retValue = null;
    	try{
    		Map sqlParams = new HashMap();
    		sqlParams.put("sqlId", sqlId);
    		sqlParams.put("dictType", dictType);
    		List retList = infoCommonService.queryListBySqlId(sqlParams);
    		if(retList!=null && retList.size()>0){
    			for(int i=0;i<retList.size();i++){
    				Map m = (Map)retList.get(i);
    				if(value.equals(m.get("name"))){
    					retValue=(String)m.get("id");
    				}		
    			}
    		}
    	}catch(Exception ex){
    		
    	}
    	return retValue;
    }
   
}
