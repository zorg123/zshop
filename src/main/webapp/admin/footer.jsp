<%@ page language="java" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
}
.STYLE1 {
	font-size: 12px;
	color: #147233;
}
-->
</style>
<script type="text/javascript" src="/ress/js/jquery/jquery-1.7.1.min.js" ></script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="23" background="/ress/images/admin/main_25.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="181" height="23" background="/ress/images/admin/main_24.gif">&nbsp;</td>
        <td><div align="right" class="STYLE1"><label id="dateLb"></label></div></td>
        <td width="25"><img src="/ress/images/admin/main_27.gif" width="25" height="23" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<script language="javascript">
<!--
function setTime() {
	var now= new Date();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	var year = now.getFullYear();
	var month = now.getMonth()+1;
	var day = now.getDate();
	var myweekday = now.getDay();
	if (myweekday == 0)
			weekday = " 星期日 ";
		else if (myweekday == 1)
			weekday = " 星期一 ";
		else if (myweekday == 2)
			weekday = " 星期二 ";
		else if (myweekday == 3)
			weekday = " 星期三 ";
		else if (myweekday == 4)
			weekday = " 星期四 ";
		else if (myweekday == 5)
			weekday = " 星期五 ";
		else if (myweekday == 6)
			weekday = " 星期六 ";
	var dStr = year+"年"+month+"月"+day+"日 "+hour+":"+minute+":"+second+" "+weekday;	
	$("#dateLb").text(dStr);
}
 window.setInterval(setTime,1000);
//-->
</script>
</html>
