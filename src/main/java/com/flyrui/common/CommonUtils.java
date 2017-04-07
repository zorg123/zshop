package com.flyrui.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;


/**
 * 
 * 普通工具类，多为静态方法调用
 * 
 * @author  rover.lee
 * Jul 6, 2012 8:40:13 PM
 */
public class CommonUtils {
	
	private final static Logger logger = Logger.getLogger(CommonUtils.class);
	
	/**
	 * 
	 * 将一list转换为json数据
	 * 
	 * @param source
	 * @param propertiesMap
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * Administrator
	 * Jul 6, 2012
	 */
	public static String transformListToJson(List source,Map propertiesMap) throws FRException{
		String jsonStr = "";
		List retList = transformList(source,propertiesMap);
		jsonStr = JSONArray.fromObject(retList).toString();		
		return jsonStr;
	}
	
	/**
	 * 
	 * 将一list转换为json数据
	 * 
	 * @param source
	 * @param propertiesMap
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * Administrator
	 * Jul 6, 2012
	 */
	public static List transformList(List source,Map propertiesMap) throws FRException{		
		List targetList = new ArrayList();
		if(source!=null){
			
			Map  childMap = null;
			try{
				if(propertiesMap!=null){
					for(int i=0;i<source.size();i++){
						Object o = source.get(i);

						childMap = new HashMap();
						if(o.getClass().getName().startsWith("com.flyrui")){
							for(Iterator iter = propertiesMap.keySet().iterator();iter.hasNext();){
								String key = (String)iter.next();
								//转换的值
								String mapValue = (String)propertiesMap.get(key);
								Method m = getMethod(o,key);
								if(m!=null){							
									String value = getStrValueFromObject(m.invoke(o, null));
									if(mapValue!=null){
										childMap.put(mapValue, value);
									}else{
										childMap.put(key, value);
									}
								}else{
									logger.info("未在类中找到变量"+key+"的设置方法.");
								}
							}
						}else if(o instanceof Map){
							for(Iterator iter = propertiesMap.keySet().iterator();iter.hasNext();){
								String key = (String)iter.next();
								//转换的值
								String mapValue = (String)propertiesMap.get(key);
								Map mo = (Map)o;							
								String value = getStrValueFromObject(mo.get(key));
								if(mapValue!=null){
									childMap.put(mapValue, value);
								}else{
									childMap.put(key, value);
								}
							}
						}else {
							throw new FRException(new FRError(ErrorConstants.COMMON_NOT_SUPPORT)); 
						}
						targetList.add(childMap);

					}
				}else {
					targetList = source;
				}				
			}catch(FRException fr){
				throw fr;
			}catch(InvocationTargetException ex){
				throw new FRException(new FRError(ErrorConstants.COMMON_SYSTEM_ERROR),ex.getCause());
			}catch(Exception ex){
				throw new FRException(new FRError(ErrorConstants.COMMON_SYSTEM_ERROR),ex);
			}
		}		
		return targetList;
	}
	
	private static Method getMethod(Object o,String suffixMethod){
		Method[] methods = o.getClass().getMethods();
		Method retMethod = null;
		for(int i=0;i<methods.length;i++){
			Method m = methods[i];
			if(m.getName().compareToIgnoreCase("get"+suffixMethod)==0){
				retMethod = m;
				break;
			}
		}		
		return retMethod;
	}
	
	public static String getStrValueFromObject(Object o){
		String retStr = "";
		if(o ==null){
			return "";
		}
		
		if(o instanceof Integer){
			retStr = String.valueOf(o); 
		}else if(o instanceof BigDecimal){
			retStr = ((BigDecimal)o).toPlainString();
		}else if(o instanceof Date){
			retStr =  DateUtil.formatDate((Date)o, DateUtil.DATE_FORMAT_2);
		}else{
			retStr = o.toString();
		}
		return retStr;
	}
	
	public static void saveFile(File sourceFile,File newFile) throws FRException{
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try{		
			fos = new FileOutputStream(newFile);
			fis = new FileInputStream(sourceFile);
			byte[] b = new byte[1024];
			while(fis.read(b)!=-1){
				fos.write(b);
			}
		}catch(Exception ex){
			logger.error("上传文件报错",ex);
			throw new FRException(new FRError(ErrorConstants.FILE_NOT_FOUND));
		}finally{
			try{
				if(fos!=null){
					fos.close();
				}
				if(fis!=null){
					fis.close();
				}
			}catch(Exception ex){
				logger.error("关闭文件出错",ex);
			}
		}
	}
	public static String Encode(String text){
        char c;
        StringBuilder tmp = new StringBuilder(20);
        tmp.ensureCapacity(text.length() * 6);  //\\u542b
        for (int i = 0; i < text.length(); i++)
        {
            c = text.charAt(i);
            if (c < 256)
                tmp.append(c);
            else
            {
                tmp.append("\\u");
                tmp.append(Integer.toString(c, 16));//16进制
            }
        }
        return tmp.toString();
    }
}
