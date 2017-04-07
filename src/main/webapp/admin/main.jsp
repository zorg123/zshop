<%@ page language="java" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>飞锐电子科技-CMS管理系统</title>
<script type="text/javascript" src="/ress/js/jquery/jquery-1.7.1.min.js" ></script>
<script type="text/javascript" src="/ress/js/jquery/jquery.loadmask.min.js" ></script>
<script type="text/javascript" src="/ress/js/jquery/jquery.popup.js" ></script>
<script language="javascript">
 var showMessage = function(message,callback){
	 
	//if(!callback){
		//alert(message);
		//pop({text:message,tile:"提示"},3);
	//}else {
		
	//	pop({text:message,tile:"提示"},3,callback)
	//}
 };
</script>
</head>
<frameset rows="91,*,23" frameborder="no" border="0" framespacing="0">
  <frame src="/Sys/getRootMenuByRole.action" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="center.jsp" name="mainFrame" id="mainFrame" />
  <frame src="footer.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>

</html>
