package com.flyrui.infoshare.staff.action;

import java.io.File;
import java.text.SimpleDateFormat;
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

import com.flyrui.common.BeanUtils;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ImportExcel;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.exception.FRException;
import com.flyrui.infoshare.common.service.InfoCommonService;
import com.flyrui.infoshare.staff.pojo.CoreUser;
import com.flyrui.infoshare.staff.pojo.InfoUserExt;
import com.flyrui.infoshare.staff.service.CoreUserService;
import com.flyrui.infoshare.staff.service.InfoUserExtService;
import com.flyrui.salary.dto.SalaryDto;
import com.flyrui.salary.service.SalaryService;

@ParentPackage("frcms_default")
@Namespace("/Staff") //访问路径的包名
@Results({
		@Result(name="staffDetail", location = "/staff/staffDetail.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class StaffAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(StaffAction.class);
	
    private String contentType;
    private File upload;
    private String fileName;
    private String caption;	  
    public String operType;
    
    public InfoUserExt infoUserExt = new InfoUserExt();    
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public List<InfoUserExt> infoUserExtList = new ArrayList<InfoUserExt>();
	
	@Autowired
	public CoreUserService coreUserService;
	
	@Autowired
	public InfoUserExtService infoUserExtService;
	
	@Autowired
	private InfoCommonService infoCommonService;    
    
    public InfoUserExt getInfoUserExt() {
		return infoUserExt;
	}
	public void setInfoUserExt(InfoUserExt infoUserExt) {
		this.infoUserExt = infoUserExt;
	}
	
	@Action(value="queryUserList")
    public String queryUserList(){    	
    	if(infoUserExt.getName()!=null){
    		infoUserExt.setName("%"+infoUserExt.getName()+"%");
    	}
    	PageModel<CoreUser> pageModel = coreUserService.getPagerListByCon(infoUserExt, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    @Action(value="queryUserDetail")
    public String queryUserDetail() throws FRException{
    	infoUserExt.setState("1");//只查询有效记录    	
    	List<InfoUserExt> infoUserListTemp =  infoUserExtService.getDetailInfoByCon(infoUserExt);    	
    	if(infoUserListTemp!=null && infoUserListTemp.size()>0){
    		infoUserExt = infoUserListTemp.get(0);
    	}
    	return "staffDetail";
    }
    
    @Action(value="insert")
    public String insert() throws FRException{
    	int cnt = infoUserExtService.insert(infoUserExt);
    	setResult(cnt);
    	return SUCCESS;
    }
    
    @Action(value="update")
    public String update() throws FRException{
    	if(infoUserExt!=null){
    		infoUserExt.setUser_id(infoUserExt.getId());
    		int cnt= infoUserExtService.update(infoUserExt);
    		setResult(cnt);
    	}
    	return SUCCESS;
    }    
    
    @Action(value="importStaff")
    public String importStaff() throws Exception{
    	
    	ImportExcel<InfoUserExt> importExcel = new ImportExcel(InfoUserExt.class);
    	
    	List<InfoUserExt> resultList = (ArrayList) importExcel.importExcel(upload,fileName,"yyyy.MM.dd");
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
    		for(InfoUserExt infoUserExtTemp : resultList){
    			count++;
    			if(infoUserExtTemp.getId_card()==null || "".equals(infoUserExtTemp.getId_card())){
    				importErrMsg.append("第"+count+"行入库失败，原因:没有身份证信息!<br/>");
    				importErrNum++;
    				continue;
    			}
    			infoUserExtTemp.setSeq(0);
    			infoUserExtTemp.setState("1");
    			infoUserExtTemp.setCreate_date(new Date());
    			//通过身份证查询用户是否存在
    			Map sqlParams = new HashMap();
    			sqlParams.put("sqlId", "4");
    			sqlParams.put("citizenId", infoUserExtTemp.getId_card());
    			List retList = infoCommonService.queryListBySqlId(sqlParams);
    			if(retList==null || retList.size()==0){
    				importErrMsg.append("第"+count+"行入库失败，原因:此身份证的用户信息不存在!<br/>");
    				importErrNum++;
    				continue;
    			}
    			Map m = (Map)retList.get(0);
    			infoUserExtTemp.setUser_id((String)m.get("id"));
    			
    			//数据是否存在
    			
    			sqlParams = new HashMap();
    			sqlParams.put("sqlId", "5");
    			sqlParams.put("userId", infoUserExtTemp.getUser_id());
    			retList = infoCommonService.queryListBySqlId(sqlParams);
    			if(retList !=null && retList.size()>0){
    				importErrMsg.append("第"+count+"行入库失败，原因:此用户的基本信息已经存在!<br/>");
    				importErrNum++;
    				continue;
    			}
    			//校验各个维表数据是否都存在
    			//性别
    			if(infoUserExtTemp.getSex()!=null && !infoUserExtTemp.getSex().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getSex(),"sex");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:性别的输入值  "+infoUserExtTemp.getSex()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setSex(idTemp);
    				}
    			}
    			
    			//政治面貌
    			if(infoUserExtTemp.getPolitical_status()!=null && !infoUserExtTemp.getPolitical_status().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getPolitical_status(),"zzmm");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:政治面貌的输入值  "+infoUserExtTemp.getPolitical_status()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setPolitical_status(idTemp);
    				}
    			}
    			
    			
    			//学历
    			if(infoUserExtTemp.getEducation()!=null && !infoUserExtTemp.getEducation().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getEducation(),"xl");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:学历的输入值  "+infoUserExtTemp.getEducation()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setEducation(idTemp);
    				}
    			}
    			
    			//学位
    			if(infoUserExtTemp.getDegree()!=null && !infoUserExtTemp.getDegree().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getDegree(),"xw");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:学位的输入值  "+infoUserExtTemp.getDegree()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setDegree(idTemp);
    				}
    			}
    			
    			//职务名称
    			if(infoUserExtTemp.getJob_title()!=null && !infoUserExtTemp.getJob_title().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getJob_title(),"zw");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:职务名称的输入值  "+infoUserExtTemp.getJob_title()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setJob_title(idTemp);
    				}
    			}
    			
    			//享受待遇级别
    			if(infoUserExtTemp.getJob_level()!=null && !infoUserExtTemp.getJob_level().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getJob_level(),"dyjb");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:享受待遇级别的输入值  "+infoUserExtTemp.getJob_level()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setJob_level(idTemp);
    				}
    			}
    			
    			//专业技术资格名称
    			if(infoUserExtTemp.getQualify_name()!=null && !infoUserExtTemp.getQualify_name().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getQualify_name(),"zyjszg");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:专业技术资格名称的输入值  "+infoUserExtTemp.getQualify_name()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setQualify_name(idTemp);
    				}
    			}
    			
    			//专业技术级别
    			if(infoUserExtTemp.getQualify_level()!=null && !infoUserExtTemp.getQualify_level().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getQualify_level(),"zyjsjb");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:专业技术级别的输入值  "+infoUserExtTemp.getQualify_level()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setQualify_level(idTemp);
    				}
    			}
    			
    			//聘任专业技术岗位等级
    			if(infoUserExtTemp.getAppoint_level()!=null && !infoUserExtTemp.getAppoint_level().equals("")){
    				String idTemp = checkDictValue("3",infoUserExtTemp.getAppoint_level(),"prjsgwdj");
    				if(idTemp==null){
    					importErrMsg.append("第"+count+"行入库失败，原因:聘任专业技术岗位等级的输入值  "+infoUserExtTemp.getAppoint_level()+" 不存在!<br/>");
        				importErrNum++;
        				continue;
    				}else{
    					infoUserExtTemp.setQualify_level(idTemp);
    				}
    			}    			
    		}

    		if(importErrNum==0){
	    		try{
	    			infoUserExtService.batchInsert(resultList);
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
