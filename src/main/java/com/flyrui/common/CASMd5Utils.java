package com.flyrui.common;

import java.security.MessageDigest;

public class CASMd5Utils
{
  public static String getMdResults(String password, String id, String account)
  {
    if ((password == null) || (id == null) || (account == null)) {
      return null;
    }
    String result = password + "{" + id + "}" + "{" + account + "}";
    return MD5(result);
  }
  
  public static final String MD5(String s)
  {
    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    try
    {
      byte[] btInput = s.getBytes();
      
      MessageDigest mdInst = MessageDigest.getInstance("MD5");
      
      mdInst.update(btInput);
      
      byte[] md = mdInst.digest();
      
      int j = md.length;
      char[] str = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++)
      {
        byte byte0 = md[i];
        str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
        str[(k++)] = hexDigits[(byte0 & 0xF)];
      }
      return new String(str);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  public static final String getPwd(String password,String userCode){
	  return CASMd5Utils.getMdResults(password, "12",userCode);
  }
  public static void main(String[] args)
  {
	  System.out.println( CASMd5Utils.getPwd("112233", "admin"));
    System.out.println(getMdResults("123456", "402880bd52b43c210152b43c913e002a", "gushuangmei"));
  }
}
