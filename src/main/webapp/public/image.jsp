<%@ page contentType="image/JPEG" pageEncoding="utf-8"%><%@ page import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %>

<%!
Color getRandomColor(int fc,int bc){//给定范围获得随机颜色
	Random random = new Random();
	if (fc > 255) fc = 255;
	if (bc > 255) bc = 255;
	int r = fc+random.nextInt(bc-fc);
	int g = fc+random.nextInt(bc-fc);
	int b = fc+random.nextInt(bc-fc);
	return new Color(r,g,b);
}
%>

<%

out.clear();
//设置页面不缓存

//response.setHeader("Pragma","No-cache");
//response.setHeader("Cache-Control","no-cache");
//response.setDateHeader("Expires", 0);
//在内存中创建图象
int width = 60, height = 20;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//获取图形上下文
Graphics graphics = image.getGraphics();
//设定背景色
graphics.setColor(new Color(255, 255, 255));
//graphics.setColor(getRandomColor(200,250));
graphics.fillRect(0, 0, width, height);
//画边框
graphics.setColor(new Color(0,0,0));
graphics.drawRect(0,0,width-1,height-1);
//设定字体
graphics.setFont(new Font("Times New Roman",Font.PLAIN,18));
//随机产生干扰线，使图象中的认证码不易被其它程序探测到
//graphics.setColor(getRandomColor(150,200));
graphics.setColor(new Color(255, 165, 0));
//生成随机类
Random random = new Random();
for (int i=0;i<55;i++){
	int x = random.nextInt(width);
	int y = random.nextInt(height);
	int xl = random.nextInt(12);
	int yl = random.nextInt(12);
	graphics.drawLine(x,y,x+xl,y+yl);
}
//取随机产生的认证码(4位数字)
//graphics.setColor(getRandomColor(100,150));
graphics.setColor(new Color(0, 0, 0));
String valid_code = "";
String code = "";
graphics.setFont(new Font("Atlantic Inline",Font.PLAIN,18));
//String s="0123456789"; // 设置备选验证码:数字"0-9" 
String s="abcdefghijklmnopqrstuvwxyz0123456789"; // 设置备选验证码:包括"a-z"和数字"0-9" 
//String s="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 设置备选验证码:包括"a-z"和数字"0-9" 
String sRand=""; 
  for(int i=0;i<4;i++){ 
   String ch=String.valueOf(s.charAt(random.nextInt(s.length()))); 
   graphics.drawString(ch,i*13+6,(random.nextInt(1)-1)+16); 
   valid_code+=ch;
  } 
  
 /*
for (int i=0; i<4; i++){
    code = String.valueOf(random.nextInt(10));
    //将认证码显示到图象中
    graphics.drawString(code,i*13+6,16);
    valid_code += code;
}
*/ 

//将认证码存入SESSION
session.setAttribute("valid_code",valid_code);

//图象生效
graphics.dispose();

//清除缓存
//response.reset();

//输出图象到页面
try {
		ImageIO.write(image, "JPEG", response.getOutputStream());
	} catch (Exception e) {
			//e.printStackTrace();
			// TODO: handle exception
}
//out.clear();
//out = pageContext.pushBody();  
%>