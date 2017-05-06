<%@ page contentType="image/JPEG" pageEncoding="utf-8"%>
<%@ page import="com.flyrui.common.VerifyCodeUtils" %>
<%

out.clear();
//设置页面不缓存

response.setHeader("Pragma", "No-cache"); 
response.setHeader("Cache-Control", "no-cache"); 
response.setDateHeader("Expires", 0); 
response.setContentType("image/jpeg");

//生成随机字串 
String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
 
//删除以前的
session.removeAttribute("valid_code");
session.setAttribute("valid_code", verifyCode.toLowerCase()); 

//生成图片 
int w = 200, h = 34; 
VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

%>