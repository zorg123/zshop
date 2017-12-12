package com.flyrui.salary.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.BeanUtils;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ExcelAnnotation;
import com.flyrui.common.excel.ExcelExport;
import com.flyrui.common.excel.ImportExcel;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryLevel;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.salary.dto.SalaryDto;
import com.flyrui.salary.service.SalaryService;

@DynaimcDataSourceName(name="dataSourceSalary")
public class SalaryAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SalaryAction.class);
	
    private String contentType;
    private File upload;
    private String fileName;
    private String caption;	
    
    public String q;
    
    public BusSalary busSalary = new BusSalary();    
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
    
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
    
    public SalaryService getSalaryService(){
    	return (SalaryService)SpringBeans.getBean("salaryService");
    }
    
    public String qrySalaryByMan(){
    	SalaryService salaryService = getSalaryService();
    	PageModel pageModel = salaryService.getPagerListByCon(busSalary, page, rows);  
    	if(pageModel.getRows()!=null && pageModel.getRows().size()>0){
    		List sumList = salaryService.getSumListByCon(busSalary);
    		pageModel.getRows().addAll(sumList);
    	} 	
    	setResult(pageModel);
    	return SUCCESS;
    }
    public String qrySalaryByEmployee() throws Exception{
    	actionType="SALARY";
    	SalaryService salaryService = getSalaryService();
    	if(q==null){
    		busSalary.setUser_code(getUserCode());
    	}    	
    	PageModel pageModel = salaryService.getPagerListByCon(busSalary, page, rows);
    	if(pageModel.getRows()!=null && pageModel.getRows().size()>0){
    		List sumList = salaryService.getSumListByCon(busSalary);
    		pageModel.getRows().addAll(sumList);
    	}
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    public String qrySalaryByLevelEmployee(){
    	actionType="SALARY";
    	SalaryService salaryService = getSalaryService();
    	if(q==null){
    		busSalary.setUser_code(getUserCode());
    	}    	
    	PageModel pageModel = salaryService.getLevelPagerListByCon(busSalary, page, rows);
    	if(pageModel.getRows()!=null && pageModel.getRows().size()>0){
    		List<BusSalary> sumList = salaryService.getSumListByCon(busSalary);
    		pageModel.getRows().addAll(sumList);
    	}
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    public String insertSalary(){
    	SalaryService salaryService = getSalaryService();
    	setResult(salaryService.insert(busSalary));
    	return SUCCESS;
    }
    
    public String importSalary(){
    	SalaryService salaryService = getSalaryService();    	
    	ImportExcel<SalaryDto> importExcel = new ImportExcel(
    			SalaryDto.class);
    	List<SalaryDto> resultList = (ArrayList) importExcel.importExcel(upload,fileName);
    	System.out.println("共转化为List的行数为：" + resultList.size());
    	Map retMap = new HashMap();
    	retMap.put("transformErrNum", importExcel.getErrNum());
    	retMap.put("transformErrMsg", importExcel.getErrMessage());
    	int importErrNum=0;
    	int importSucNum=0;
    	StringBuffer importErrMsg = new StringBuffer();
    	
    	if(resultList!=null && resultList.size()>0){
    		BusSalary busSalary = null;
    		String batchId = UUIDHexGenerator.generator();
    		for(SalaryDto salaryDto : resultList){
    			busSalary = new BusSalary();
    			try{
    				BeanUtils.copyProperties(busSalary, salaryDto);
    			}catch(Exception ex){
    				importErrMsg.append("工号"+salaryDto.getUser_code()+"入库失败:"+ex.getMessage());
    				importErrNum++;
    				continue;
    			}    		
    			//处理下中文日期
    			String sDate = busSalary.getSalary_schedule();
    			if(sDate!=null){	    			
	    			if(sDate.length()==7 || sDate.length()==8){
	    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
	    				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
	    		    	try{
	    		    		sDate = sdf1.format(sdf.parse(sDate));
	    		    	}catch(Exception ex){
	    		    		importErrMsg.append("工号"+salaryDto.getUser_code()+"入库失败:日期格式不对:yyyy年MM月");
	        				importErrNum++;
	        				continue;
	    		    	}
	    			}else if(sDate.length()==9 || sDate.length()==10 || sDate.length()==11 || sDate.length()==12){
	    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	    				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	    		    	try{
	    		    		sDate = sdf1.format(sdf.parse(sDate));
	    		    	}catch(Exception ex){
	    		    		importErrMsg.append("工号"+salaryDto.getUser_code()+"入库失败:日期格式不对:yyyy年MM月dd日");
	        				importErrNum++;
	        				continue;
	    		    	}
	    			}
	    			busSalary.setSalary_schedule(sDate);
    			}
    			busSalary.setSalary_id(UUIDHexGenerator.generator());
    			busSalary.setCreate_date(new Date());
    			busSalary.setOper_user_id(getUserId());
    			busSalary.setBatch_id(batchId);
    			try{
    				salaryService.insert(busSalary);
    			}catch(Exception ex){
    				importErrMsg.append("工号"+salaryDto.getUser_code()+"入库失败:"+ex.getMessage());
    				importErrNum++;
    				continue;
    			}
    			importSucNum++;
    		}
    		retMap.put("batchId", batchId);
    	}
    	
    	retMap.put("importSucNum", importSucNum);
    	retMap.put("importErrNum", importErrNum);
    	retMap.put("importErrMsg", importErrMsg.toString());
    	
    	setResult(retMap);
    	return SUCCESS;    	
    }
    
    public String deleteByBatch() throws FRException{
    	SalaryService salaryService = getSalaryService();
    	int delCount = salaryService.deleteByBatch(busSalary);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    public String deleteByIds()  throws FRException{
    	SalaryService salaryService = getSalaryService();
    	int delCount = salaryService.deleteByids(ids);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    public  String eportSarary() throws Exception{  
    	actionType="SALARY";
    	SalaryService salaryService = getSalaryService(); 
    	
    	if(busSalary!=null){ 
    		if(busSalary.getOrg_name()!=null && !"".equals(busSalary.getOrg_name())){
    			busSalary.setOrg_name("%"+java.net.URLDecoder.decode(busSalary.getOrg_name(),"UTF-8")+"%");
    		}
    		if(busSalary.getUser_name()!=null && !"".equals(busSalary.getUser_name())){
    			busSalary.setUser_name("%"+java.net.URLDecoder.decode(busSalary.getUser_name(),"UTF-8")+"%");   
    		}
    	}
    	if(q==null){
    		busSalary.setUser_code(getUserCode());
    	}      	 	
    	ExcelExport<BusSalary> excelExport = new ExcelExport<BusSalary>();    	
    	List<BusSalary> retList = salaryService.getListByCon(busSalary);
    	if(retList!=null && retList.size()>0){
    		List sumList = salaryService.getSumListByCon(busSalary);
    		retList.addAll(sumList);
    	}
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel("工资", retList, os);
        byte[] content=os.toByteArray();
        setExcelName("工资");
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
    
    public  String eportLevelSarary() throws Exception{    	
    	SalaryService salaryService = getSalaryService(); 
    	
    	if(busSalary!=null){ 
    		if(busSalary.getOrg_name()!=null && !"".equals(busSalary.getOrg_name())){
    			busSalary.setOrg_name("%"+java.net.URLDecoder.decode(busSalary.getOrg_name(),"UTF-8")+"%");
    		}
    		if(busSalary.getUser_name()!=null && !"".equals(busSalary.getUser_name())){
    			busSalary.setUser_name("%"+java.net.URLDecoder.decode(busSalary.getUser_name(),"UTF-8")+"%");   
    		}
    	}
    	if(q==null){
    		busSalary.setUser_code(getUserCode());
    	}      	 	
    	ExcelExport<BusSalaryLevel> excelExport = new ExcelExport<BusSalaryLevel>();    	
    	List<BusSalaryLevel> retList = salaryService.getLevleListByCon(busSalary);
    	if(retList!=null && retList.size()>0){
    		List<BusSalary> sumList = salaryService.getSumListByCon(busSalary);
    		List newList = new ArrayList();
    		for(BusSalary bus : sumList){
    			BusSalaryLevel bsl = new BusSalaryLevel();
    			Field[] fields = bus.getClass().getDeclaredFields();
    			for(Field field :fields){    				
    				String fieldname = field.getName();
    				ExcelAnnotation exa = field.getAnnotation(ExcelAnnotation.class);
    				// 如果设置了annottion
    				if (exa != null) {
    					String getMethodName = "get"
    						+ fieldname.substring(0, 1).toUpperCase()
    						+ fieldname.substring(1);
    					String setMethodName = "set"
    						+ fieldname.substring(0, 1).toUpperCase()
    						+ fieldname.substring(1);

    					Method getMethod = bus.getClass().getMethod(getMethodName,
    							new Class[] {});

    					Method setMethod = bsl.getClass().getMethod(setMethodName,
    							new Class[] {field.getType()});
    					Object o = getMethod.invoke(bus, new Object[]{});
    					//Type[] ts = setMethod.getGenericParameterTypes();
    					// 只要一个参数
    					//String xclass = ts[0].toString();
    					//Type type = ts[0];
    					//type.
    					//field.getType().newInstance().
    					if(o instanceof String){
    						setMethod.invoke(bsl, (String)o);
    					}else if (o instanceof Float){
    						setMethod.invoke(bsl, new Float(o.toString()));
    					}else if (o instanceof Date){
    						setMethod.invoke(bsl, (Date)o);
    					}
    					
    				}
    			}
    			//BeanUtils.copyProperties(bsl, bus);
    			newList.add(bsl);
    		}
    		retList.addAll(newList);
    	}
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel("工资", retList, os);
        byte[] content=os.toByteArray();
        setExcelName("工资");
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
    
    
}
