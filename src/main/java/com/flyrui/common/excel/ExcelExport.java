package com.flyrui.common.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelExport<T> {

	// 格式化日期
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @param title
	 *            标题
	 * @param dataset
	 *            集合
	 * @param out
	 *            输出流
	 */
	public void exportExcel(String title, Collection<T> dataset,OutputStream out) {
		// 声明一个工作薄
		try {
			// 首先检查数据看是否是正确的
			Iterator<T> its = dataset.iterator();
			if (dataset == null || !its.hasNext() || title == null
					|| out == null) {
				throw new Exception("传入的数据不对！");
			}
			// 取得实际泛型类
			T ts = (T) its.next();
			Class tCls = ts.getClass();
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth((short) 15);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置标题样式
			style = ExcelStyle.setHeadStyle(workbook, style);

			// 得到所有字段

			Field filed[] = ts.getClass().getDeclaredFields();
			// 标题
			List<String> exportfieldtile = new ArrayList<String>();
			// 导出的字段的get方法
			List<Method> methodObj = new ArrayList<Method>();
			// 遍历整个filed
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// 如果设置了annottion
				if (exa != null) {
					String exprot = exa.exportName();
					// 添加到标题
					exportfieldtile.add(exprot);
					// 添加到需要导出的字段的方法
					String fieldname = f.getName();
					String getMethodName = "get"
							+ fieldname.substring(0, 1).toUpperCase()
							+ fieldname.substring(1);

					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});

					methodObj.add(getMethod);
				}
			}
			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < exportfieldtile.size(); i++) {
				HSSFCell cell = row.createCell((short) i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(
						exportfieldtile.get(i));
				cell.setCellValue(text);
			}

			int index = 0;

					
			Iterator<T> its2 = dataset.iterator();
			while (its2.hasNext()) {
				// 从第二行开始写，第一行是标题
				index++;
				row = sheet.createRow(index);
				T t = (T) its2.next();
				for (int k = 0; k < methodObj.size(); k++) {
					HSSFCell cell = row.createCell((short) k);
					Method getMethod = methodObj.get(k);
					Object value = getMethod.invoke(t, new Object[] {});
					//HSSFCellStyle cellStyle = getCellTypeByValue(value,workbook);
					//if(cellStyle!=null){
					String textValue = getValue(value);
					if(value instanceof Float){
						cell.setCellType(cell.CELL_TYPE_NUMERIC);
						try{
							cell.setCellValue(Double.parseDouble(textValue));
						}catch(Exception ex){
							cell.setCellValue(textValue);
						}
					}else{						
						cell.setCellValue(textValue);
					}
					//}
					
					
				}

			}
			workbook.write(out);
  
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public File getExportExcel(String title, Collection<T> dataset,String fileName) throws FileNotFoundException{
		this.exportExcel(title, dataset, new FileOutputStream(fileName));
		return new File(fileName); 
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
