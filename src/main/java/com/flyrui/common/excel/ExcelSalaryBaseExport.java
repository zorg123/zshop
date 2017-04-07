package com.flyrui.common.excel;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.flyrui.dao.pojo.salary.BusSalaryBase;
import com.flyrui.dao.pojo.salary.BusSalaryExtend;

public class ExcelSalaryBaseExport {

	// 格式化日期
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");

	/**
	 * 
	 * @param title
	 *            标题
	 * @param dataset
	 *            集合
	 * @param out
	 *            输出流
	 */
	public void exportExcel(String title, List<BusSalaryBase> dataset,OutputStream out) {
		// 声明一个工作薄
		try {
			// 首先检查数据看是否是正确的
			Iterator<BusSalaryBase> its = dataset.iterator();
			if (dataset == null || !its.hasNext() || title == null
					|| out == null) {
				throw new Exception("传入的数据不对！");
			}
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth((short) 15);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置标题样式
			//style = ExcelStyle.setHeadStyle(workbook, style);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setLeftBorderColor(HSSFColor.BLACK.index);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setRightBorderColor(HSSFColor.BLACK.index);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setTopBorderColor(HSSFColor.BLACK.index);

			int index = 0;
			HSSFRow row=null;//标题头
			HSSFRow row2=null;//标题内容	
			HSSFRow row3=null;//空行
			Iterator<BusSalaryBase> its2 = dataset.iterator();
			while (its2.hasNext()) {
				// 从第二行开始写，第一行是标题
				
				row = sheet.createRow(index);
				row2 = sheet.createRow(++index);
				row3 = sheet.createRow(++index);
				int curColumn = 0;
				int curColumn2 = 0;
				BusSalaryBase t = (BusSalaryBase) its2.next();
				HSSFCell cell = row.createCell(curColumn++,HSSFCell.CELL_TYPE_STRING);
				/*cell.setCellValue("银行账号");
				cell.setCellStyle(style);
				cell = row.createCell(curColumn++,HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(t.getBank_account());
				cell.setCellStyle(style);				
				cell = row.createCell(curColumn++,HSSFCell.CELL_TYPE_STRING);*/
				
				cell.setCellValue("姓名");
				cell.setCellStyle(style);
				cell = row2.createCell(curColumn2++,HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(t.getUser_name());
				cell.setCellStyle(style);
				
				cell = row.createCell(curColumn++,HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("发放时间");
				cell.setCellStyle(style);
				cell = row2.createCell(curColumn2++,HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(sdf.format(t.getSalary_schedule()));
				cell.setCellStyle(style);
				List<BusSalaryExtend> busSalaryExtendList = t.getBusSalaryExtendList();
				
				if(busSalaryExtendList!=null){
					
					for (int k = 0; k < busSalaryExtendList.size(); k++) {
						BusSalaryExtend b = busSalaryExtendList.get(k);
						cell = row.createCell(curColumn++,HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(b.getExtend_name());
						cell.setCellStyle(style);
						
						cell = row2.createCell(curColumn2++,HSSFCell.CELL_TYPE_NUMERIC);
						try{
							cell.setCellValue(Double.parseDouble(b.getExtend_value()));
						}catch(Exception ex){
							cell.setCellValue(b.getExtend_value());
						}
						cell.setCellStyle(style);
					}
				}
				
				index++;
			}
			workbook.write(out);
  
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public String getValue(Object value) {
		String textValue = "";
		if (value == null)
			return textValue;

		if (value instanceof Boolean) {
			boolean bValue = (Boolean) value;
			textValue = "是";
			if (!bValue) {
				textValue = "否";
			}
		} else if (value instanceof Date) {
			Date date = (Date) value;

			textValue = sdf.format(date);
		} else
			textValue = value.toString();

		return textValue;
	}
	
	public HSSFCellStyle getCellTypeByValue(Object value,HSSFWorkbook workBook){
		HSSFCellStyle cellStyle = null;
		if(value == null){
			return null;
		}
		if(value instanceof Float){
			cellStyle = workBook.createCellStyle();
			HSSFDataFormat df = workBook.createDataFormat();
			cellStyle.setDataFormat(df.getFormat("#,##0.00"));
            //cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));            
		}
		return cellStyle;
	}

	public static void main(String[] args) throws Exception {
		/**
		 * //构造一个模拟的List来测试，实际使用时，这个集合用从数据库中查出来 List list = new ArrayList(); for
		 * (int i = 0; i < 100; i++) { MntoeidDto pojo = new MntoeidDto();
		 * pojo.setEid("登录名"+i); pojo.setMn("用户名"+i); pojo.setUmg(i+"");
		 * pojo.setXnmn("Xnmn"+i); list.add(pojo); }
		 * //构造输出对象，可以从response输出，直接向用户提供下载 OutputStream out = new
		 * FileOutputStream("D:\\testOne.xls"); //开始时间 Long l =
		 * System.currentTimeMillis(); //注意 ExcelExport<MntoeidDto> ex = new
		 * ExcelExport<MntoeidDto>(); // ex.exportExcel("测试", list, out);
		 * out.close(); //结束时间 Long s = System.currentTimeMillis();
		 * System.out.println("总共耗时：" + (s - l));
		 **/

	}
}
