package com.flyrui.salary.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ExcelSalaryBaseExport;
import com.flyrui.common.excel.ImportSalaryBaseExcel;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalaryBase;
import com.flyrui.dao.pojo.salary.BusSalaryExtend;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.salary.service.BusSalaryBaseService;
import com.flyrui.salary.service.BusSalaryExtendService;
import com.flyrui.sys.service.UserService;

/*
 * @Namespace("/SalaryBase")
@Results({@Result(name = "success", location = "/index.jsp"), 
          @Result(name = "error", location = "/hello.jsp") ,
          @Result(type="json",params = {"root","result"})
         }) 
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
**/
@DynaimcDataSourceName(name="dataSourceSalary")
public class SalaryBaseAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SalaryBaseAction.class);
	
    private String contentType;
    private File upload;
    private String fileName;
    private String caption;	
    
    public String q;
    
    public BusSalaryBase busSalary = new BusSalaryBase();    
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	public List<BusSalaryBase> busSalaryBaseList = new ArrayList<BusSalaryBase>();
    
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
    
    public BusSalaryBaseService getBusSalaryBaseService(){
    	return (BusSalaryBaseService)SpringBeans.getBean("busSalaryBaseServiceImpl");
    }
    
    public BusSalaryExtendService getBusSalaryExtendService(){
    	return (BusSalaryExtendService)SpringBeans.getBean("busSalaryExtendServiceImpl");
    }
    
    public String qrySalaryByMan(){
    	actionType = "BANK";
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService();    
    	BusSalaryExtendService busSalaryExtendService = getBusSalaryExtendService();
    	if(q==null){
    		busSalary.setBank_account(getUserCode());
    	}
    	PageModel<BusSalaryBase> pageModel = iBusSalaryBaseService.getPagerListByCon(busSalary, page, rows);  
    	List<BusSalaryBase> busSalaryList = pageModel.getRows();
    	if(busSalaryList!=null && busSalaryList.size()>0){
    		List<BusSalaryExtend> busSalaryExtendList = busSalaryExtendService.getListByBatchSalaryId(pageModel.getRows());
        	if(busSalaryExtendList!=null && busSalaryExtendList.size() >0){
        		for(BusSalaryExtend busSalaryExtendTemp : busSalaryExtendList){
        			for(BusSalaryBase busSalaryBaseTemp : busSalaryList){
            			if(busSalaryExtendTemp.getSalary_id().equals(busSalaryBaseTemp.getSalary_id())){
            				List<BusSalaryExtend> tt = busSalaryBaseTemp.getBusSalaryExtendList();
            				if(tt==null){
            					tt = new ArrayList<BusSalaryExtend>();
            					busSalaryBaseTemp.setBusSalaryExtendList(tt);
            				}
            				tt.add(busSalaryExtendTemp);
            				break;
            			}
            		}
        		}
        	}
        	
        	//转为字符创
        	for(BusSalaryBase busSalaryBaseTemp : busSalaryList){
    			
				List<BusSalaryExtend> tt = busSalaryBaseTemp.getBusSalaryExtendList();
				if(tt!=null){
					String html = "<table width='100%'>";
					String nameTr="<tr>";
					String valueTr="<tr>";
					for(BusSalaryExtend busSalaryExtendTemp : tt){
						nameTr+="<td style=\"text-align:center\">"+busSalaryExtendTemp.getExtend_name()+"</td>";
						valueTr+="<td style=\"text-align:center\">"+busSalaryExtendTemp.getExtend_value()+"</td>";
					}
					nameTr+="</tr>";
					valueTr+="</tr>";
					html+=nameTr;
					html+=valueTr;
					html+="</table>";
					busSalaryBaseTemp.setExtend_info(html);
				}
    		}
    	}
    	    	
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    public String importSalary() throws FRException{
    	UserService userService = (UserService)SpringBeans.getBean("userService");
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService();    
    	
    	
    	ImportSalaryBaseExcel<BusSalaryBase> importSalaryBaseExcel = new ImportSalaryBaseExcel<BusSalaryBase>(BusSalaryBase.class);
    	List<BusSalaryBase> resultList = importSalaryBaseExcel.importExcel(upload,fileName);
    	
    	log.info("共转化为List的行数为：" + resultList.size());
    	
    	Map retMap = new HashMap();
    	retMap.put("transformErrNum", importSalaryBaseExcel.getErrNum());
    	retMap.put("transformErrMsg", importSalaryBaseExcel.getErrMessage());
    	
    	int importErrNum=0;
    	int importSucNum=0;
    	StringBuffer importErrMsg = new StringBuffer();
    	String batchId ="";
    	
    	if(resultList!=null && resultList.size()>0 && importSalaryBaseExcel.getErrNum() == 0){    		 
    		
    		for(BusSalaryBase busSalaryBase : resultList){    			
    			busSalaryBase.setOper_user_id(getUserId());
    			batchId= busSalaryBase.getBatch_id();
    			User user = new User();
    			user.setBank_account(busSalaryBase.getBank_account());
    			List<User> userList = userService.getListByCon(user);
    			if(userList==null || userList.size() == 0){
    				importErrNum++;
    				importErrMsg.append("账号:"+busSalaryBase.getBank_account()+"在系统不存在!<br/>");
    			}else if(userList.size()>1){
    				importErrNum++;
    				importErrMsg.append("账号:"+busSalaryBase.getBank_account()+"在系统中存在多个!<br/>");
    			}else{
    				User u = userList.get(0);
    				//busSalaryBase.setUser_code(u.getUser_code());
    				busSalaryBase.setUser_id(Integer.parseInt(u.getUser_id()));
    			}
    		}
    		
    		//校验有错误，不再导入
    		if(importErrNum==0){
	    		try{
					iBusSalaryBaseService.batchInsert(resultList);
					importSucNum += resultList.size();
				}catch(Exception ex){
					importErrMsg.append("入库失败:"+ex.getMessage());
					importErrNum += resultList.size();
				}
    		}else{
    			importErrNum = resultList.size();
    		}
			
    		retMap.put("batchId", batchId);
    	}else{
    		importErrNum = importSalaryBaseExcel.getErrNum()+resultList.size();
    		importErrMsg.append(importSalaryBaseExcel.getErrMessage());
    	}
    	
    	retMap.put("importSucNum", importSucNum);
    	retMap.put("importErrNum", importErrNum);
    	retMap.put("importErrMsg", importErrMsg.toString());
    	
    	setResult(retMap);
    	return SUCCESS;    	
    }
    
    public String deleteByBatch() throws FRException{
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService(); 
    	if(busSalary.getBatch_id()==null || "".equals(busSalary.getBatch_id())){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	//查询是否存在此批次号
    	List<BusSalaryBase> list = iBusSalaryBaseService.getListByCon(busSalary);
    	if(list==null || list.size()==0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	
    	int delCount = iBusSalaryBaseService.deleteByBatch(busSalary);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    public String deleteByIds()  throws FRException{
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService();
    	//查询是否传ids
    	if(ids==null || "".equals(ids)){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	int delCount = iBusSalaryBaseService.deleteByIds(ids);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    public  String eportSarary() throws Exception{  
    	actionType = "BANK";
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService(); 
    	BusSalaryExtendService busSalaryExtendService = getBusSalaryExtendService();
    	
    	if(busSalary!=null){ 
    		if(busSalary.getOrg_name()!=null && !"".equals(busSalary.getOrg_name())){
    			busSalary.setOrg_name("%"+java.net.URLDecoder.decode(busSalary.getOrg_name(),"UTF-8")+"%");
    		}
    		if(busSalary.getUser_name()!=null && !"".equals(busSalary.getUser_name())){
    			busSalary.setUser_name("%"+java.net.URLDecoder.decode(busSalary.getUser_name(),"UTF-8")+"%");   
    		}
    	}
    	if(q==null){
    		busSalary.setBank_account(getUserCode());
    	}      	 	
    	ExcelSalaryBaseExport  excelExport = new ExcelSalaryBaseExport();    	
    	List<BusSalaryBase> retList = iBusSalaryBaseService.getListByCon(busSalary);
    	if(retList!=null && retList.size()>0){
    		List<BusSalaryExtend> busSalaryExtendList = busSalaryExtendService.getListByBatchSalaryId(retList);
    		if(busSalaryExtendList!=null && busSalaryExtendList.size() >0){
    			for(BusSalaryExtend busSalaryExtendTemp : busSalaryExtendList){
    				for(BusSalaryBase busSalaryBaseTemp : retList){
    					if(busSalaryExtendTemp.getSalary_id().equals(busSalaryBaseTemp.getSalary_id())){
    						List<BusSalaryExtend> tt = busSalaryBaseTemp.getBusSalaryExtendList();
    						if(tt==null){
    							tt = new ArrayList<BusSalaryExtend>();
    							busSalaryBaseTemp.setBusSalaryExtendList(tt);
    						}
    						tt.add(busSalaryExtendTemp);
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel("工资", retList, os);
        byte[] content=os.toByteArray();
        setExcelName("工资");
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
    
    public  String printSarary() throws Exception{  
    	actionType = "BUS";
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService(); 
    	BusSalaryExtendService busSalaryExtendService = getBusSalaryExtendService();
    	
    	//查询是否传ids
    	if(ids==null || "".equals(ids)){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	String[] idstrs = ids.split(",");
    	for(String id : idstrs){
    		busSalary.setSalary_id(id);
    		List<BusSalaryBase> retList = iBusSalaryBaseService.getListByCon(busSalary);
    		if(retList!=null && retList.size()>0){
        		List<BusSalaryExtend> busSalaryExtendList = busSalaryExtendService.getListByBatchSalaryId(retList);
        		if(busSalaryExtendList!=null && busSalaryExtendList.size() >0){
        			for(BusSalaryExtend busSalaryExtendTemp : busSalaryExtendList){
        				for(BusSalaryBase busSalaryBaseTemp : retList){
        					if(busSalaryExtendTemp.getSalary_id().equals(busSalaryBaseTemp.getSalary_id())){
        						List<BusSalaryExtend> tt = busSalaryBaseTemp.getBusSalaryExtendList();
        						if(tt==null){
        							tt = new ArrayList<BusSalaryExtend>();
        							busSalaryBaseTemp.setBusSalaryExtendList(tt);
        						}
        						tt.add(busSalaryExtendTemp);
        						break;
        					}
        				}
        			}
        		}
        	}
    		busSalaryBaseList.addAll(retList);
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
    	Map<String,String> otherParams = new HashMap<String,String>();
    	otherParams.put("curDate", sdf.format(new Date()));
    	setResult(otherParams);
        return "print";    	   	
    }
    
    public String pringSalaryByQuery(){
    	actionType = "BANK";
    	BusSalaryBaseService iBusSalaryBaseService = getBusSalaryBaseService();    
    	BusSalaryExtendService busSalaryExtendService = getBusSalaryExtendService();
    	if(q==null){
    		busSalary.setBank_account(getUserCode());
    	}
    	PageModel<BusSalaryBase> pageModel = iBusSalaryBaseService.getPagerListByCon(busSalary, page, rows);  
    	List<BusSalaryBase> busSalaryList = pageModel.getRows();
    	if(busSalaryList!=null && busSalaryList.size()>0){
    		List<BusSalaryExtend> busSalaryExtendList = busSalaryExtendService.getListByBatchSalaryId(pageModel.getRows());
        	if(busSalaryExtendList!=null && busSalaryExtendList.size() >0){
        		for(BusSalaryExtend busSalaryExtendTemp : busSalaryExtendList){
        			for(BusSalaryBase busSalaryBaseTemp : busSalaryList){
            			if(busSalaryExtendTemp.getSalary_id().equals(busSalaryBaseTemp.getSalary_id())){
            				List<BusSalaryExtend> tt = busSalaryBaseTemp.getBusSalaryExtendList();
            				if(tt==null){
            					tt = new ArrayList<BusSalaryExtend>();
            					busSalaryBaseTemp.setBusSalaryExtendList(tt);
            				}
            				tt.add(busSalaryExtendTemp);
            				break;
            			}
            		}
        		}
        	}        	
    	}
    	busSalaryBaseList.addAll(busSalaryList);
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
    	Map<String,String> otherParams = new HashMap<String,String>();
    	otherParams.put("curDate", sdf.format(new Date()));
    	setResult(otherParams);
        return "print";
    }
    
}
