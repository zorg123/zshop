package com.flyrui.common.utls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Const {
	
	public static String DEFAULT_UPLOAD_FILE_HOME_DIR="res";
	
	public static String DEFAULT_UPLOAD_FILE_PICTURE_DIR="pic";
	
	public static String DEFAULT_UPLOAD_FILE_ATTACHE_DIR="attach";
	
	public static String DEFAULT_UPLOAD_FILE_CAPTURE_DIR="capture";
	
	public static String DEFAULT_UPLOAD_FILE_MOVIE_DIR="movie";
	
	private static Map getEmptyMap(){
		return new HashMap() ;
	}
	
	public static int getPageSize(Map m ){
		return ((Integer)m.get("pageSize")).intValue() ;
	}
	
	public static int getPageIndex(Map m ){
		return ((Integer)m.get("pageIndex")).intValue() ;
	}
	
	/**
	 * 根据tStr字段 构建新map
	 * @param sm  原map
	 * @param tStr 从原map，根据tStr字段作为key，构建需要的map
	 * @return
	 */
	public static Map getMapForTargetStr(Map sm , String tStr){
		if(sm == null || sm.isEmpty() ||
				tStr == null || "".equals(tStr.trim()))
			return getEmptyMap() ; 
		Map tm = new HashMap() ;
		Iterator it = sm.keySet().iterator() ;
		String[] tStrArray = tStr.split(",") ;
		for(int i = 0 , j= tStrArray.length ; i< j ; i++) {
			String n = tStrArray[i];
			if (null != n && sm.get(n.trim()) != null) {
				tm.put(n, (String)sm.get(n));
			}
		}
		return tm ;
	}
	
	public static boolean containValue(Map m , String name ){
		return m.get(name) != null ;
	}
	
	public static  boolean containStrValue(Map m , String name) {
		if( !containValue( m , name ) )
			return false ;
		String t = (String)m.get(name) ;
		return t != null && !"".equals(t.trim()) ;
	}
	
	public static  String getStrValue(Map m , String name) {
		
		if (null == m || m.isEmpty()) return "";
		
		Object t = m.get(name) ;
		if(t == null )
			return "" ;
		return ((String)m.get(name)).trim() ;
	}
	
	public static  int getIntValue(Map m , String name) {
		Object t = m.get(name) ;
		if(t == null )
			return 0 ;
		String ret = ((String)m.get(name)).trim() ;
		return Integer.parseInt(ret) ;
	}
	
	public static List getArrayList(Map m, String key) {
		if (null == m || m.isEmpty()) return null;
		Object t = m.get(key) ;
		if(t == null )
			return null ;
		return ((ArrayList)m.get(key));
	}
}
