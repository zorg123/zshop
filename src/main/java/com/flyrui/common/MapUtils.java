package com.flyrui.common;

import java.util.Map;

public class MapUtils
{
    public static String getStrFromMap(Map m,String key){
        String retStr="";
        if(m==null){
        	return retStr;
        }
        if(m.get(key) != null ){
            retStr = (String)m.get(key);
        }
        return retStr;
    }
}
