package com.flyrui.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.dao.pojo.salary.BusSalaryBase;
import com.flyrui.dao.pojo.salary.BusSalaryExtend;


/**
 * 按照模板T中声明的字段解析Excel文件内容 仅解析声明的字段 支持解析多sheet的Excel
 * 
 * @param <T>
 */
public class ImportSalaryBaseExcel<T> {
	private static final Log log =  LogFactory.getLog(ImportSalaryBaseExcel.class);

	// 错误信息
	private String errMessage="";
	// 转化失败数据数量
	private int errNum;
	
	Class<T> clazz;

	public ImportSalaryBaseExcel(Class<T> clazz) {
		this.clazz = clazz;
	}

	public String getErrMessage() {
		return errMessage;
	}
	public int getErrNum() {
		return errNum;
	}
	
	public List<BusSalaryBase> importExcel(File file, String... pattern) {
		List<BusSalaryBase> dist = new ArrayList<BusSalaryBase>();
		try {
			
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
			String batchId = UUIDHexGenerator.generator();
			
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
						String salaryId = UUIDHexGenerator.generator();
						Cell cell = rown.getCell((short) 0);
	
						// 得到传入类的实例
						BusSalaryBase tObject = (BusSalaryBase)clazz.newInstance();
						tObject.setSalary_id(salaryId);
						tObject.setBatch_id(batchId);
						tObject.setCreate_date(new Date());
						int k = 0;
						// 遍历一行的列
						boolean flag = false;
						cell = rown.getCell(2);
						if(cell ==null || "".equals(cell.toString())){
							continue;
						}
						// while (cellbody.hasNext()) {
						for (int j = 0; j < rown.getLastCellNum() + 1; j++) {
							cell = rown.getCell((short) j);
							// 这里得到此列的对应的标题
							String titleString = (String) titlemap.get(k);
							
							if (cell != null) {
								//前4列为固定的基本信息，直接写入SalaryBase表
								if(j==0){
									tObject.setUser_code(cell.toString());								
								}else if(j==1){
									tObject.setUser_name(cell.toString());
								}else if(j==2){
									tObject.setBank_account(cell.toString());
								}else if(j==3){
									//格式为 2016年9月，需要格式化为日期
									String sDate = cell.toString();
									Date d = null;
				    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
				    		    	try{
				    		    		d = sdf.parse(sDate);
				    		    	}catch(Exception ex){
				    		    		throw new Exception("日期格式错误:"+sDate);
				    		    	}
				    		    	
									tObject.setSalary_schedule(d);
								}else{
									//其他列转为扩展字段
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
									BusSalaryExtend busSalaryExtendTemp = new BusSalaryExtend();
									busSalaryExtendTemp.setSalary_id(salaryId);
									busSalaryExtendTemp.setExtend_name(titleString);
									busSalaryExtendTemp.setExtend_value(tmpContent);
									busSalaryExtendTemp.setOrder_id(j);
									busSalaryExtendTemp.setBatch_id(batchId);
									busSalaryExtendTemp.setCreate_date(new Date());
									List<BusSalaryExtend> tt = tObject.getBusSalaryExtendList();
		            				if(tt==null){
		            					tt = new ArrayList<BusSalaryExtend>();
		            					tObject.setBusSalaryExtendList(tt);
		            				}
		            				tt.add(busSalaryExtendTemp);
									
								}
							}
							// 下一列
							k = k + 1;
						}
						 
						dist.add(tObject);
						
					} catch (Exception e) {
 						this.errMessage+="第"+(rown.getRowNum()+1)+"行数据错误，错误信息："+e.getMessage().toString()+"<br/>";
						this.errNum++;
					}
				}
			}
		} catch (Exception e) {
			this.errMessage+=e.getMessage()+"<br/>";
			e.printStackTrace();
			return dist;
		}
		return dist;
	}
}