package com.flyrui.dao.pojo.test;

import java.text.SimpleDateFormat;

public class Test
{
    private String a ;

    public String getA()
    {
        return a;
    }

    public void setA(String a)
    {
        this.a = a;
    }
    
    public static void main(String[] args){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
    	try{
    		System.out.println(sdf.format(sdf.parse("2014年3月")));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
}
