package com.flyrui.infoshare.train.action;

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
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.infoshare.common.service.InfoCommonService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.infoshare.train.pojo.InfoTrain;
import com.flyrui.infoshare.train.pojo.InfoTrainAudit;
import com.flyrui.infoshare.train.service.InfoTrainAuditService;
import com.flyrui.infoshare.train.service.InfoTrainService;

@ParentPackage("frcms_default")
@Namespace("/Train") //访问路径的包名
@Results({
		@Result(name="trainEdit", location = "/train/trainEdit.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class TrainAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(TrainAction.class);	
    	  
    public String operType;
    
    public InfoTrain infoTrain = new InfoTrain();   
    
    public InfoTrainAudit infoTrainAudit = new InfoTrainAudit(); 
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	public List<InfoTrain> infoTrainList ;
	
	@Autowired
	public InfoTrainService infoTrainService;
	
	@Autowired
	private InfoCommonService infoCommonService;  
	
	@Autowired
	private InfoTrainAuditService infoTrainAuditService;  
    
    public InfoTrain getInfoTrain() {
		return infoTrain;
	}
	public void setInfoTrain(InfoTrain infoTrain) {
		this.infoTrain = infoTrain;
	}
	
	@Action(value="queryTrainList")
    public String queryAssetList(){    	
		if(infoTrain!=null){
			infoTrain.setSeq(0);
		}
    	if(infoTrain.getTrain_name()!=null ){
    		infoTrain.setTrain_name("%"+infoTrain.getTrain_name()+"%");
    	}
    	PageModel<CoreUser> pageModel = infoTrainService.getPagerListByCon(infoTrain, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    @Action(value="trainEdit")
    public String trainEdit() throws FRException{   
    	if("2".equals(operType)){
    		List<InfoTrain> infoTrainTemp =  infoTrainService.getListByCon(infoTrain);    	
    		if(infoTrainTemp!=null && infoTrainTemp.size()>0){
    			infoTrain = infoTrainTemp.get(0);
    		}
    	}else{
    		infoTrain = new InfoTrain();
    	}
    	return "trainEdit";
    }
    
    @Action(value="insert")
    public String insert() throws FRException{
    	int cnt = infoTrainService.insert(infoTrain);
    	setResult(cnt);
    	return SUCCESS;
    }
    
    @Action(value="update")
    public String update() throws FRException{
    	if(infoTrain!=null){
    		int cnt= infoTrainService.update(infoTrain);
    		setResult(cnt);
    	}
    	return SUCCESS;
    }    
    
    @Action(value="deleteByIds")
    public String deleteByIds()  throws FRException{
    	int delCount = infoTrainService.deleteByIds(ids);
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
    
    
    
    @Action(value="audit")
    public String audit() throws Exception{
    	if(infoTrainAudit.getTrain_id()==null || "".equals(infoTrainAudit.getTrain_id())){
    		throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
    	}
    	infoTrainAudit.setCreate_date(new Date());
    	infoTrainAuditService.insert(infoTrainAudit);
    	infoTrain.setTrain_id(infoTrainAudit.getTrain_id());
    	if("1".equals(infoTrainAudit.getAudit_result())){
    		infoTrain.setState("1");
    	}else{
    		infoTrain.setState("3");
    	}
    	infoTrainService.update(infoTrain);
    	setResult(null);
    	return SUCCESS;
    }
}
