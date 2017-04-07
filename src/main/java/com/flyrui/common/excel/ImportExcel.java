package com.flyrui.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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

	public ImportExcel(Class<T> clazz) {
		this.clazz = clazz;
	}

	public String getErrMessage() {
		return errMessage;
	}
	public int getErrNum() {
		return errNum;
	}
	
	public Collection<T> importExcel(File file, String... pattern) {
		Collection<T> dist = new ArrayList();
		try {
			/**
			 * 类反射得到调用方法
			 */
			// 得到目标目标类的所有的字段列表
			Field filed[] = clazz.getDeclaredFields();
			// 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
			Map fieldmap = new HashMap();
			// 循环读取所有字段
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				// 得到单个字段上的Annotation
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// 如果标识了Annotationd的话
				if (exa != null) {
					// 构造设置了Annotation的字段的Setter方法
					String fieldname = f.getName();
					String setMethodName = "set"
							+ fieldname.substring(0, 1).toUpperCase()
							+ fieldname.substring(1);
					// 构造调用的method，
					Method setMethod = clazz.getMethod(setMethodName,
							new Class[] { f.getType() });
					// 将这个method以Annotaion的名字为key来存入。
					fieldmap.put(exa.exportName(), setMethod);
				}
			}
			/**
			 * excel的解析开始
			 */
			// 默认是03版Excel
			boolean isExcel2003 = true;
			String fileName =file.getName();
			if(pattern.length>0){
				fileName = pattern[0];
			}
			if (fileName.matches("^.+\\.(?i)(xlsx)$")) {// 07版Excel
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
			// 循环获取sheet中的数据
			for (int n = 0; n < numOfSheet; n++) {
				Sheet sheet = book.getSheetAt(n);
				Iterator<Row> row = sheet.rowIterator();
				// 判断sheet是否为空
				if (sheet.getLastRowNum() < 1) {
					continue;
				}
				/**
				 * 标题解析
				 */
				// 得到第一行，也就是标题行
				Row title = (Row) row.next();
				// 得到第一行的所有列
				Iterator<Cell> cellTitle = title.cellIterator();
				// 将标题的文字内容放入到一个map中。
				Map titlemap = new HashMap();
				String tmpContent = "";
				// 从标题第一列开始
				int i = 0;
				// 循环标题所有的列
				while (cellTitle.hasNext()) {
					Cell cell = (Cell) cellTitle.next();
					String value = cell.getStringCellValue();
					titlemap.put(i, value);
					i = i + 1;
				}
				/**
				 * 解析内容行
				 */
				// 用来格式化日期的DateFormat
				SimpleDateFormat sf;
				// 是不是走这里
				if (pattern.length < 2) {
					sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				} else{
					sf = new SimpleDateFormat(pattern[1]);
				}
				while (row.hasNext()) {
					Row rown = (Row) row.next();
					try {
						// 标题下的第一行
						
						Cell cell = rown.getCell((short) 0);
						// 防止读取空行.
//						if (cell == null || cell.toString() == null|| "".equals(cell.toString())) {
//							continue;
//						}//这样判断，第一列成了必填,干脆不判断了，各自的具体导入类中控制吧-shi.lianghui-2013.1.25
						// 行的所有列
						// Iterator<HSSFCell> cellbody =
						// rown.getLastCellNum().cellIterator();
						// 得到传入类的实例
						T tObject = clazz.newInstance();
						int k = 0;
						// 遍历一行的列
						boolean flag = false;
						// while (cellbody.hasNext()) {
						for (int j = 0; j < rown.getLastCellNum() + 1; j++) {
							cell = rown.getCell((short) j);
							// 这里得到此列的对应的标题
							String titleString = (String) titlemap.get(k);
							
							// 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
							if (fieldmap.containsKey(titleString)&& cell != null) {
								
								Method setMethod = (Method) fieldmap.get(titleString);
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
									if (evaluator.evaluateInCell(cell).getCellType() == Cell.CELL_TYPE_NUMERIC) {
										if (cell.toString().endsWith(".0")) {
											tmpContent = cell.toString().substring(0,cell.toString().indexOf(".0"));
										} else {
											if (null != cell.toString()&& cell.toString().indexOf(".") != -1&& cell.toString().indexOf("E") != -1) {
												DecimalFormat df = new DecimalFormat();
												tmpContent = df.parse(cell.toString()).toString();
											}else {
												tmpContent=cell.toString();
											} 
										}
									} else {
										tmpContent = cell.toString();
									}
									setMethod.invoke(tObject, tmpContent);

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
									String v = cell.toString();
									if(v!=null){
										if(v.indexOf(".")>0){
											v = v.substring(0,v.indexOf("."));
										}
										setMethod.invoke(tObject, new Integer(v));
									}
									
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
						if (flag) {
							dist.add(tObject);
						}
					} catch (Exception e) {
						log.error("导入出错",e);
 						this.errMessage+="第"+(rown.getRowNum()+1)+"行数据错误，错误信息："+e.getMessage().toString()+"<br/>";
						this.errNum++;
					}
				}
			}
		} catch (Exception e) {
			log.error("导入出错",e);
			this.errMessage+=e.getMessage().toString()+"<br/>";
			return dist;
		}
		return dist;
	}
}