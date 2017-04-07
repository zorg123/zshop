package com.flyrui.infoshare.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.flyrui.bus.service.BusService;
import com.flyrui.common.SpringBeans;
import com.flyrui.dao.pojo.bus.BusTemplate;
import com.flyrui.dao.pojo.bus.BusTemplateItem;


/**
 * 按照模板T中声明的字段解析Excel文件内容 仅解析声明的字段 支持解析多sheet的Excel
 * 
 * @param <T>
 */
public class ImportExcel<T> {
	private static final Log log =  LogFactory.getLog(ImportExcel.class);

	// 错误信息
	private String errMessage="";
	// 转化失败数据数量
	private int errNum;
	
	Class<T> clazz;
	private String templateId;//导入数据配置的模板

	public ImportExcel(Class<T> clazz,String templateId) {
		this.clazz = clazz;
		this.templateId = templateId;
	}

	public String getErrMessage() {
		return errMessage;
	}
	public int getErrNum() {
		return errNum;
	}
	
	public Collection<T> importExcel(File file, Map<String,String> param) {
		Collection<T> dist = new ArrayList();
		try {
			/**
			 * 类反射得到调用方法
			 */
			// 得到目标目标类的所有的字段列表
			Field filed[] = clazz.getDeclaredFields();
			// 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
			
			//查询数据库模板配置的导入字段
			BusService busService = (BusService)SpringBeans.getBean("busService");
			BusTemplateItem busTemplateItem = new BusTemplateItem();
			busTemplateItem.setTemplate_id(templateId);
			List<BusTemplateItem> busTemplateItemList = busService.queryBusTemplateItem(busTemplateItem);
			
			//查询模板信息，是否是按列号还是字段名称
			BusTemplate busTemplate = new BusTemplate();
			busTemplate.setTemplate_id(templateId);
			List<BusTemplate> busTemplateList = busService.queryBusTemplate(busTemplate);
			if(busTemplateList!=null && busTemplateList.size()>0){
				busTemplate = busTemplateList.get(0);
			}
			String dataType = busTemplate.getData_type();
			
			Map<String,Method> fieldmap = new LinkedHashMap<String,Method>();
			Map<String,BusTemplateItem> fieldTemplateItemMap = new LinkedHashMap<String,BusTemplateItem>();
			Map<String,Method> commonFieldmap = new LinkedHashMap<String,Method>();
			
			//循环读取所有字段
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				
				String fieldname = f.getName();
				busTemplateItem = checkExist(fieldname,busTemplateItemList);
				
			
				if(busTemplateItem!=null&& busTemplateItem.getCol_index()!=-1){
					
					String setMethodName = "set"
						+ fieldname.substring(0, 1).toUpperCase()
						+ fieldname.substring(1);
					
					//构造调用的method，
					Method setMethod = clazz.getMethod(setMethodName,
						new Class[] { f.getType() });
					
					if("0".equals(dataType)){
						fieldmap.put(busTemplateItem.getCol_index()+"", setMethod);
						fieldTemplateItemMap.put(busTemplateItem.getCol_index()+"", busTemplateItem);
					}else{
						fieldmap.put(busTemplateItem.getItem_name(), setMethod);
						fieldTemplateItemMap.put(busTemplateItem.getItem_name(), busTemplateItem);
					}
					
				}
				
				//设置公共参数
				if(param!=null && param.containsKey(fieldname)){
					String setMethodName = "set"
						+ fieldname.substring(0, 1).toUpperCase()
						+ fieldname.substring(1);
					
					//构造调用的method，
					Method setMethod = clazz.getMethod(setMethodName,
						new Class[] { f.getType() });
					
					commonFieldmap.put(fieldname, setMethod);
				}
				
				
			}
			/**
			 * excel的解析开始
			 */
			// 默认是03版Excel
			boolean isExcel2003 = true;
			if (file.getName().matches("^.+\\.(?i)(xlsx)$")) {// 07版Excel
				isExcel2003 = false;
			}
			// 将传入的File构造为FileInputStream;
			FileInputStream in = new FileInputStream(file);
			// // 得到工作表
			Workbook book = isExcel2003 ? new HSSFWorkbook(in): new XSSFWorkbook(in);
			
			//公式评估
			FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
			
			// 获取sheet数量
			int numOfSheet = book.getNumberOfSheets();
			int sheetNumber = busTemplate.getSheet_number();
			
			if(sheetNumber>numOfSheet-1){
				this.errMessage+="模板配置错误，未找到要读取的sheet页数"+sheetNumber+"<br/>";
				return dist;
			}
			
				Sheet sheet = book.getSheetAt(sheetNumber);
				Iterator<Row> row = sheet.rowIterator();
				// 判断sheet是否为空
				if (sheet.getLastRowNum() < 1) {
					this.errMessage+="要读取的sheet页"+sheetNumber+"中数据为空<br/>";
					return dist;
				}
				
				int startRow = busTemplate.getStart_row();
				
				//如果不是从第一行开始读取，则循环跳出
				if(startRow>0){
					while(startRow>0){
						row.next();
						startRow--;
					}
				}
				
				//将标题的文字内容放入到一个map中
				Map titlemap = new HashMap();
				String tmpContent = "";
				if(!"0".equals(dataType)){
					/**
					 * 标题解析
					 */
					//得到第一行，也就是标题行
					Row title = (Row) row.next();
					// 得到第一行的所有列
					Iterator<Cell> cellTitle = title.cellIterator();					
					
					// 从标题第一列开始
					int i = 0;
					// 循环标题所有的列
					while (cellTitle.hasNext()) {
						Cell cell = (Cell) cellTitle.next();
						String value = cell.getStringCellValue();
						titlemap.put(i, value);
						i = i + 1;
					}
				}
				
				/**
				 * 解析内容行
				 */
				// 用来格式化日期的DateFormat
				
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(param!=null && param.get("DATE_FORMAT")!=null){
					sf = new SimpleDateFormat(param.get("DATE_FORMAT"));
				}
				
				while (row.hasNext()) {
					Row rown = (Row) row.next();
					try {
						// 标题下的第一行
						
						Cell cell = rown.getCell((short) 0);
						
						T tObject = clazz.newInstance();
						int k = 0;
						// 遍历一行的列
						boolean flag = false;
						// while (cellbody.hasNext()) {
						for (int j = 0; j < rown.getLastCellNum() + 1; j++) {
							cell = rown.getCell((short) j);
							String titleString = (String) titlemap.get(k);
							
							//按行来获取
							if("0".equals(dataType)){
								titleString = j+"";
							}
							// 这里得到此列的对应的标题
							
							
							// 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
							if (fieldmap.containsKey(titleString)&& cell != null) {
								
								Method setMethod = (Method) fieldmap.get(titleString);
								BusTemplateItem tempBusTemplateItem = fieldTemplateItemMap.get(titleString);
								
								// 得到setter方法的参数
								Type[] ts = setMethod.getGenericParameterTypes();
								// 只要一个参数
								String xclass = ts[0].toString();
								// 判断参数类型
								
								if (cell!=null&&cell.toString() != null&& !"".equals(cell.toString().trim())) {
									flag = true;
								} else {
									k = k + 1;
									continue;
								}
							
 								if (xclass.equals("class java.lang.String")) {
 									if("DAT".equals(tempBusTemplateItem.getItem_type())){
 										// 时间转换
 										if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
 									      {
 										      if(DateUtil.isCellDateFormatted(cell))
 										      {
 										    	  double d=cell.getNumericCellValue();
 										    	  Date date = DateUtil.getJavaDate(d);
 										    	  setMethod.invoke(tObject,sf.format(date));
 										      }
 									      }else if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
 											  setMethod.invoke(tObject, cell.toString());
 									      }
 									}else{
 										if (evaluator.evaluateInCell(cell).getCellType() == Cell.CELL_TYPE_NUMERIC) {
 											if (cell.toString().endsWith(".0")) {
 												tmpContent = cell.toString().substring(0,cell.toString().indexOf(".0"));
 											} else {
 												if (null != cell.toString()&& cell.toString().indexOf(".") != -1&& cell.toString().indexOf("E") != -1) {
 													DecimalFormat df = new DecimalFormat();
 													tmpContent = df.parse(cell.toString()).toString();
 												}else {
 													String v = cell.toString();
 													if(v.indexOf(".")!=-1){
 														String dotValue = v.substring(v.indexOf("."));
 														if(dotValue.length()>3){
 															v=v.substring(0,v.indexOf("."))+dotValue.substring(0,3);
 														}
 													}
 													tmpContent=v;
 												} 
 											}
 										} else {
 											tmpContent = cell.toString();
 										}
 										setMethod.invoke(tObject, tmpContent);
 									}

								} else if (xclass.equals("class java.util.Date")) {
									
									// 时间转换
									if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
								      {
									      if(DateUtil.isCellDateFormatted(cell))
									      {
									    	  double d=cell.getNumericCellValue();
									    	  setMethod.invoke(tObject,DateUtil.getJavaDate(d));
									      }
								      }else if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
										  setMethod.invoke(tObject, sf.parse(cell.toString()));
								      }  


								} else if (xclass.equals("class java.lang.Boolean")) {
									Boolean boolname = true;
									if (cell.toString().equals("否")) {
										boolname = false;
									}
									setMethod.invoke(tObject, boolname);
								} else if (xclass.equals("class java.lang.Integer")) {
									setMethod.invoke(tObject, new Integer(cell.toString()));
								}

								else if (xclass.equals("class java.lang.Long")) {
									if (cell.toString().endsWith(".0")) {
										setMethod.invoke(tObject,new Long(cell.toString().substring(0,cell.toString().indexOf(".0"))));
									} else {
										setMethod.invoke(tObject, new Long(cell.toString()));
									}

								}

							}
							// 下一列
							k = k + 1;
						}
						
						//设置公共信息
						setCommonInfo(tObject,commonFieldmap,param);
						
						if (flag) {
							dist.add(tObject);
						}
					} catch (Exception e) {
						e.printStackTrace();
 						this.errMessage+="第"+(rown.getRowNum()+1)+"行数据错误，错误信息："+e.getMessage().toString()+"<br/>";
						this.errNum++;
					}
				}
			
		} catch (Exception e) {
			this.errMessage+=e.getMessage().toString()+"<br/>";
			return dist;
		}
		return dist;
	}
	
	public BusTemplateItem checkExist(String colName ,List<BusTemplateItem> busTemplateItemList){
		BusTemplateItem retBusTemplateItem = null;
		for(BusTemplateItem busTemplateItem: busTemplateItemList){
			if(colName.equals(busTemplateItem.getData_col())){
				retBusTemplateItem = busTemplateItem;
				break;
			}
		}
		return retBusTemplateItem;
	}
	
	public void setCommonInfo(T t,Map<String,Method> commonFieldmap,Map<String,String> param){
		Iterator<String> iterator = commonFieldmap.keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			Method method = commonFieldmap.get(key);
			Type[] ts = method.getGenericParameterTypes();
			// 只要一个参数
			String xclass = ts[0].toString();
			String value = param.get(key);
			try {
				if (xclass.equals("class java.lang.Integer")) {
					method.invoke(t, new Integer(value));
				}else{
					method.invoke(t, value);
				}
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}