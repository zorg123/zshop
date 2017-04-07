<%@ page language="java" pageEncoding="utf-8"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>飞锐电子科技-CMS管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
overflow:hidden;
}
-->
</style>
<style> 
.navPoint { 
COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt 
} 
</style> 
<script type="text/javascript" src="/ress/js/jquery/jquery-1.7.1.min.js" ></script>
<script>
<!--
function switchSysBar(){
var openFlag=$("#img1").attr("openFlag");
//alert(openFlag);
if (openFlag=="1" || openFlag =='' || !openFlag )
{ 
	$("#img1").attr("src","/ress/images/admin/main_18_1.gif");
 	$("#frmTitle").hide();
 	$("#img1").attr("openFlag","0");
} 
else
{ 
	$("#img1").attr("src","/ress/images/admin/main_18.gif");
 	$("#frmTitle").show();
 	$("#img1").attr("openFlag","1");
} 
} 
//-->
</script>

</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout: fixed;">
			<tr>
				<td width="203" id=frmTitle noWrap name="fmTitle" align="center"
					valign="top">
					<iframe name="leftFrame" id="leftFrame" height="100%" width="180"
						src="left.jsp" border="0" frameborder="0" scrolling="no">
					</iframe>
				</td>
				<td width="8" valign="middle"
					background="/ress/images/admin/main_12.gif" onclick="switchSysBar()">
					<span class="navPoint"><img	src="/ress/images/admin/main_18.gif" name="img1" width=8
							height=52 id=img1>
					</span>
				</td>
				<td align="center" valign="top">
					<iframe name="rightFrame" id="rightFrame" height="100%"
						width="100%" border="0" frameborder="0" src="welcome.jsp"></iframe>
				</td>
				<td width="4" align="center" valign="top"
					background="/ress/images/admin/main_20.gif">
					¡¡
				</td>
			</tr>
		</table>
	</body>
</html>
