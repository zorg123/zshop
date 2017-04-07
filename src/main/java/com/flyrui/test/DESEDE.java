package com.flyrui.test;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

public class DESEDE
{
  private static final String Algorithm = "DESede";
  
  private static byte[] encryptMode(byte[] keybyte, byte[] src)
  {
    try
    {
      SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
      Cipher c1 = Cipher.getInstance("DESede");
      c1.init(1, deskey);
      return c1.doFinal(src);
    }
    catch (NoSuchAlgorithmException e1)
    {
      e1.printStackTrace();
    }
    catch (NoSuchPaddingException e2)
    {
      e2.printStackTrace();
    }
    catch (Exception e3)
    {
      e3.printStackTrace();
    }
    return null;
  }
  
  private static byte[] decryptMode(byte[] keybyte, byte[] src)
  {
    try
    {
      SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
      Cipher c1 = Cipher.getInstance("DESede");
      c1.init(2, deskey);
      return c1.doFinal(src);
    }
    catch (NoSuchAlgorithmException e1)
    {
      e1.printStackTrace();
    }
    catch (NoSuchPaddingException e2)
    {
      e2.printStackTrace();
    }
    catch (Exception e3)
    {
      e3.printStackTrace();
    }
    return null;
  }
  
  private static String byte2hex(byte[] b)
  {
    String hs = "";
    String stmp = "";
    for (int n = 0; n < b.length; n++)
    {
      stmp = Integer.toHexString(b[n] & 0xFF);
      if (stmp.length() == 1) {
        hs = hs + "0" + stmp;
      } else {
        hs = hs + stmp;
      }
    }
    return hs.toUpperCase();
  }
  
  public static byte[] hex2byte(String hex)
    throws IllegalArgumentException
  {
    if (hex.length() % 2 != 0) {
      throw new IllegalArgumentException();
    }
    char[] arr = hex.toCharArray();
    byte[] b = new byte[hex.length() / 2];
    int i = 0;
    int j = 0;
    for (int l = hex.length(); i < l;)
    {
      String swap = arr[(i++)] + arr[i]+"";
      int byteint = Integer.parseInt(swap, 16) & 0xFF;
      b[j] = new Integer(byteint).byteValue();
      i++;
      j++;
    }
    return b;
  }
  
  public static String encryptIt(String sourceCode)
  {
    Security.addProvider(new SunJCE());
    byte[] keyBytes = { 17, 34, 79, 88, -120, 16, 64, 56, 40, 37, 121, 81, 
      -53, -35, 85, 102, 119, 41, 116, -104, 48, 64, 54, -30 };
    byte[] encoded = encryptMode(keyBytes, sourceCode.getBytes());
    return byte2hex(encoded);
  }
  
  public static String decryptIt(String encodedCode)
  {
    Security.addProvider(new SunJCE());
    byte[] keyBytes = { 17, 34, 79, 88, -120, 16, 64, 56, 40, 37, 121, 81, 
      -53, -35, 85, 102, 119, 41, 116, -104, 48, 64, 54, -30 };
    byte[] encoded = decryptMode(keyBytes, hex2byte(encodedCode));
    return new String(encoded);
  }
  
  public static void main(String[] args)
  {
    String str = "1";
    String str1 = encryptIt(str);
    //String str2 = decryptIt(str1);
    System.out.println(str1);
    //if (str.equals(str2)) {
    //  System.out.println("加密解密成功了");
   // }
    //System.out.println(decryptIt("ED94C2C049B041FD"));
  }
}

