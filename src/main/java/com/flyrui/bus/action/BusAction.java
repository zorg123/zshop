package com.flyrui.bus.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.bus.excel.ExcelExport;
import com.flyrui.bus.excel.ImportExcel;
import com.flyrui.bus.service.BusService;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.bus.BusData;
import com.flyrui.dao.pojo.bus.BusInfo;
import com.flyrui.dao.pojo.bus.BusTemplateItem;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.DynaimcDataSourceName;
import com.flyrui.salary.dto.SalaryDto;

@DynaimcDataSourceName(name="dataSourceSalary")
public class BusAction extends BaseAction {	
		
    /**
	 * 注释内容 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(BusAction.class);
	
    private String contentType;
    private File upload;
    private String fileName;
    private String caption;	
    
    /**
     * 要展现的业务Id
     */
    public Integer busId ; 
    
    public String q;
    
    public BusData busData = new BusData();    
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	public String encodeFields;
    
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
    
    public BusService getBusService(){
    	return (BusService)SpringBeans.getBean("busService");
    }
    
    public String getQ(){
    	return q;
    }
    
    public String qryBusByMan(){
    	actionType="BUS";
    	BusService busService = getBusService();
    	if(!"1".equals(q)){
    		busData.setUser_code(getUserCode());
    	}
    	PageModel pageModel = busService.getPagerListByCon(busData, page, rows);  
    	if(pageModel.getRows()!=null && pageModel.getRows().size()>0){
    		//List sumList = busService.getSumListByCon(busData);
    		//pageModel.getRows().addAll(sumList);
    	} 	
    	setResult(pageModel);
    	return SUCCESS;
    }
    public String qrySalaryByEmployee(){
    	actionType="BUS";
    	BusService busService = getBusService();
    	if(!"1".equals(q)){
    		busData.setUser_code(getUserCode());
    	}    	
    	PageModel pageModel = busService.getPagerListByCon(busData, page, rows);
    	if(pageModel.getRows()!=null && pageModel.getRows().size()>0){
    		//List sumList = salaryService.getSumListByCon(busSalary);
    		//pageModel.getRows().addAll(sumList);
    	}
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    public String qrySalaryByLevelEmployee(){
    	actionType="BUS";
    	BusService busService = getBusService();
    	if(!"1".equals(q)){
    		busData.setUser_code(getUserCode());
    	}    	
    	PageModel pageModel = busService.getPagerListByCon(busData, page, rows);
    	if(pageModel.getRows()!=null && pageModel.getRows().size()>0){
    		//List<BusSalary> sumList = salaryService.getSumListByCon(busSalary);
    		//pageModel.getRows().addAll(sumList);
    	}
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    public String insertSalary(){
    	BusService busService = getBusService();
    	setResult(busService.insert(busData));
    	return SUCCESS;
    }
    
    public String importBus() throws Exception{
    	BusService busService = getBusService();
    	BusInfo busInfo = new BusInfo();
    	busInfo.setBus_id(busId);
    	List<BusInfo> busInfoList = busService.queryBusInfo(busInfo);
    	if(busInfoList!=null && busInfoList.size()>0){
    		busInfo = busInfoList.get(0);
    	}else{
    		throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
    	}
    	
    	//初始化导入类
    	ImportExcel<SalaryDto> importExcel = new ImportExcel(BusData.class,busInfo.getImp_tmp());
    	Map<String,String> param = new HashMap();
    	String batchId = UUIDHexGenerator.generator();
    	param.put("bus_id", busId+"");
    	param.put("batch_id",batchId );
    	
    	List<BusData> resultList = (ArrayList) importExcel.importExcel(upload,param);
    	
    	System.out.println("共转化为List的行数为：" + resultList.size());
    	
    	Map retMap = new HashMap();
    	retMap.put("transformErrNum", importExcel.getErrNum());
    	retMap.put("transformErrMsg", importExcel.getErrMessage());
    	
    	int importErrNum=0;
    	int importSucNum=0;
    	StringBuffer importErrMsg = new StringBuffer();
    	
    	if(resultList!=null && resultList.size()>0){    		
    		for(BusData busData : resultList){    			
    			busData.setData_id(UUIDHexGenerator.generator());
    			busData.setCreate_date(new Date());
    			busData.setOper_user_id(getUserId());
    			try{
    				busService.insert(busData);
    			}catch(Exception ex){
    				importErrMsg.append("记录:"+busData.getUser_code()+"入库失败:"+ex.getMessage());
    				importErrNum++;
    				continue;
    			}
    			importSucNum++;
    		}    		
    	}
    	
    	retMap.put("batchId", batchId);
    	retMap.put("importSucNum", importSucNum);
    	retMap.put("importErrNum", importErrNum);
    	retMap.put("importErrMsg", importErrMsg.toString());
    	
    	setResult(retMap);
    	return SUCCESS;    	
    }
    
    public String deleteByBatch() throws FRException{
    	BusService busService = getBusService();
    	int delCount = busService.deleteByBatch(busData);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    public String deleteByIds()  throws FRException{
    	BusService busService = getBusService();
    	int delCount = busService.deleteByids(ids);
    	if(delCount == 0){
    		throw new FRException(new FRError(ErrorConstants.SYS_NO_DELETE_DATA));
    	}
    	setResult(delCount);
    	return SUCCESS;
    }
    
    public  String eportBus() throws Exception{   
    	actionType="BUS";
    	BusService busService = getBusService();
    	
    	if(busData!=null && encodeFields!=null&& !"".equals(encodeFields)){
    		
    		//反射设置需要后台修改的值
    		String[] encodeFieldArr = encodeFields.split(";");
    		Class clazz = busData.getClass();
    		Field[] field = clazz.getDeclaredFields();
    		for(String encodeField : encodeFieldArr ){
    			
    			//循环读取所有字段
    			for (int i = 0; i < field.length; i++) {
    				Field f = field[i];
    				
    				String fieldname = f.getName();
    				if(fieldname.equals(encodeField)){
    					String setMethodName = "set"
    						+ fieldname.substring(0, 1).toUpperCase()
    						+ fieldname.substring(1);
    					String getMethodName = "get"
    						+ fieldname.substring(0, 1).toUpperCase()
    						+ fieldname.substring(1);
    					//构造调用的method，
    					Method setMethod = clazz.getMethod(setMethodName,
    						new Class[] { f.getType() });
    					
    					Method getMethod = clazz.getMethod(getMethodName);
    					String value = (String)getMethod.invoke(busData);
    					String newValue = java.net.URLDecoder.decode(value,"UTF-8");    					
    					setMethod.invoke(busData, newValue);
    					break;
    				}    				
    			}
    		}
    	}
    	
    	if(!"1".equals(q)){
    		busData.setUser_code(getUserCode());
    	}      
    	BusInfo busInfo = new BusInfo();
    	busInfo.setBus_id(Integer.valueOf(busData.getBus_id()));
    	List<BusInfo> busInfoList = busService.queryBusInfo(busInfo);
    	if(busInfoList!=null && busInfoList.size()>0){
    		busInfo = busInfoList.get(0);
    	}else{
    		throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
    	}
    	
    	ExcelExport<BusData> excelExport = new ExcelExport<BusData>(busInfo.getExp_tmp());    	
    	List<BusData> retList = busService.getListByCon(busData);
    	if(retList!=null && retList.size()>0){
    		//List sumList = salaryService.getSumListByCon(busSalary);
    		//retList.addAll(sumList);
    	}
    	ByteArrayOutputStream os=new ByteArrayOutputStream();
    	excelExport.exportExcel(busInfo.getBus_name(), retList, os);
        byte[] content=os.toByteArray();
        setExcelName(busInfo.getBus_name());
        inputStream =new ByteArrayInputStream(content);
        return "excel";    	   	
    }
    /*
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
    */
    
    
    public String busMain() throws Exception{ 
    	
    	BusService busService = getBusService();
    	BusInfo busInfo = new BusInfo();
    	busInfo.setBus_id(busId);
    	List<BusInfo> busInfoList = busService.queryBusInfo(busInfo);
    	if(busInfoList!=null && busInfoList.size()>0){
    		busInfo = busInfoList.get(0);
    	}else{
    		throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
    	}
    	
    	BusTemplateItem busTemplateItem = new BusTemplateItem();
		busTemplateItem.setTemplate_id(busInfo.getImp_tmp());
		List<BusTemplateItem> busTemplateItemList = busService.queryBusTemplateItem(busTemplateItem);    	
    	setResult("busTemplateItemList",busTemplateItemList);
    	
    	return "busMain";
   } 
}
