package com.flyrui.infoshare.asset.action;

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

import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ImportExcel;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.infoshare.asset.pojo.InfoAsset;
import com.flyrui.infoshare.asset.service.InfoAssetService;
import com.flyrui.infoshare.common.service.InfoCommonService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.infoshare.staff.pojo.InfoUserExt;
import com.flyrui.infoshare.staff.service.InfoUserExtService;
import com.flyrui.salary.service.SalaryService;

@ParentPackage("frcms_default")
@Namespace("/Asset") //访问路径的包名
@Results({
		@Result(name="assetEdit", location = "/asset/assetEdit.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class AssetAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(AssetAction.class);
	
    private String contentType;
    private File upload;
    private String fileName;
    private String caption;	  
    public String operType;
    
    public InfoAsset infoAsset = new InfoAsset();    
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	public List<InfoAsset> infoAssetList ;
	
	@Autowired
	public InfoAssetService infoAssetService;
	
	@Autowired
	private InfoCommonService infoCommonService;    
    
    public InfoAsset getInfoAsset() {
		return infoAsset;
	}
	public void setInfoAsset(InfoAsset infoAsset) {
		this.infoAsset = infoAsset;
	}
	
	@Action(value="queryAssetList")
    public String queryAssetList(){    	
		if(infoAsset!=null){
			infoAsset.setUse_state("1");
			infoAsset.setSeq(0);
		}
    	if(infoAsset.getAsset_name()!=null ){
    		infoAsset.setAsset_name("%"+infoAsset.getAsset_name()+"%");
    	}
    	PageModel<CoreUser> pageModel = infoAssetService.getPagerListByCon(infoAsset, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    @Action(value="assetEdit")
    public String assetEdit() throws FRException{   
    	if("2".equals(operType)){
    		List<InfoAsset> infoAssetTemp =  infoAssetService.getListByCon(infoAsset);    	
    		if(infoAssetTemp!=null && infoAssetTemp.size()>0){
    			infoAsset = infoAssetTemp.get(0);
    		}
    	}else{
    		infoAsset = new InfoAsset();
    	}
    	return "assetEdit";
    }
    
    @Action(value="insert")
    public String insert() throws FRException{
    	int cnt = infoAssetService.insert(infoAsset);
    	setResult(cnt);
    	return SUCCESS;
    }
    
    @Action(value="update")
    public String update() throws FRException{
    	if(infoAsset!=null){
    		int cnt= infoAssetService.update(infoAsset);
    		setResult(cnt);
    	}
    	return SUCCESS;
    }    
    
    @Action(value="deleteByIds")
    public String deleteByIds()  throws FRException{
    	int delCount = infoAssetService.deleteByIds(ids);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    @Action(value="importAsset")
    public String importAsset() throws Exception{
    	
    	ImportExcel<InfoAsset> importExcel = new ImportExcel(InfoAsset.class);
    	
    	List<InfoAsset> resultList = (ArrayList) importExcel.importExcel(upload,fileName,"yyyy-MM-dd");
    	log.info("共转化为List的行数为：" + resultList.size());
    	Map retMap = new HashMap();
    	retMap.put("transformErrNum", importExcel.getErrNum());
    	retMap.put("transformErrMsg", importExcel.getErrMessage());
    	int importErrNum=0;
    	int importSucNum=0;
    	StringBuffer importErrMsg = new StringBuffer();
    	
    	if(resultList!=null && resultList.size()>0 && importExcel.getErrNum() == 0){
    		int count=0;
    		String batchId = UUIDHexGenerator.generator();
    		for(InfoAsset infoAssetTemp : resultList){
    			count++;
    			infoAssetTemp.setAsset_id(UUIDHexGenerator.generator());
    			infoAssetTemp.setSeq(0);
    			if(infoAssetTemp.getAsset_code()==null || "".equals(infoAssetTemp.getAsset_code())){
    				importErrMsg.append("第"+count+"行入库失败，原因:此资产编号不能为空!<br/>");
    				importErrNum++;
    				continue;
    			}
    			
    			//通过资产编号查询此资产是否存在
    			InfoAsset infoAssetN = new InfoAsset();
    			infoAssetN.setAsset_code(infoAssetTemp.getAsset_code());
    			
    			List<InfoAsset> retList = infoAssetService.getListByCon(infoAssetN);
    			if(retList!=null && retList.size()>0){
    				importErrMsg.append("第"+count+"行入库失败，原因:资产编号"+infoAssetTemp.getAsset_code()+"已存在!<br/>");
    				importErrNum++;
    				continue;
    			}
    			
    			//检查字典数据是否存在    			
    			//资产分类
    			if(infoAssetTemp.getAsset_class()!=null && !infoAssetTemp.getAsset_class().equals("")){
    				String idTemp = checkDictValue("3",infoAssetTemp.getAsset_class(),"assetClass");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:资产分类的输入值  "+infoAssetTemp.getAsset_class()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoAssetTemp.setAsset_class(idTemp);
    				}
    			}
    			
    			//取得方式
    			if(infoAssetTemp.getGet_method()!=null && !infoAssetTemp.getGet_method().equals("")){
    				String idTemp = checkDictValue("3",infoAssetTemp.getGet_method(),"assetGetMethod");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:取得方式的输入值  "+infoAssetTemp.getGet_method()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoAssetTemp.setGet_method(idTemp);
    				}
    			}
    			
    			
    			//使用状况
    			if(infoAssetTemp.getUse_state()!=null && !infoAssetTemp.getUse_state().equals("")){
    				String idTemp = checkDictValue("3",infoAssetTemp.getUse_state(),"assetUseState");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:使用状况的输入值  "+infoAssetTemp.getUse_state()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoAssetTemp.setUse_state(idTemp);
    				}
    			}
    			
    			//部门
    			if(infoAssetTemp.getUse_department()!=null && !infoAssetTemp.getUse_department().equals("")){
    				Map sqlParams = new HashMap();
        			sqlParams.put("sqlId", "6");
        			sqlParams.put("departmentName", infoAssetTemp.getUse_department());
        			retList = infoCommonService.queryListBySqlId(sqlParams);
        			if(retList==null || retList.size()==0){
        				importErrMsg.append("第"+count+"行入库失败，原因:使用部门 "+infoAssetTemp.getUse_department()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
        			}else{
            			Map m = (Map)retList.get(0);
            			infoAssetTemp.setUse_department((String)m.get("id"));            			
        			}
    			}
    			
    			   			
    		}

    		if(importErrNum==0){
	    		try{
	    			infoAssetService.batchInsert(resultList);
					importSucNum += resultList.size();
				}catch(Exception ex){
					importErrMsg.append("入库失败:"+ex.getMessage());
					importErrNum += resultList.size();
				}
    		}else{
    			importErrNum = resultList.size();
    		}
    	}else{
    		importErrNum = importExcel.getErrNum()+resultList.size();
    		importErrMsg.append(importExcel.getErrMessage());
    	}
    	
    	retMap.put("importSucNum", importSucNum);
    	retMap.put("importErrNum", importErrNum);
    	retMap.put("importErrMsg", importErrMsg.toString());
    	
    	setResult(retMap);
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
    public String getUploadFileName() {
        return fileName;
    }
    public void setUploadFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadContentType() {
        return contentType;
    }
    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
}
