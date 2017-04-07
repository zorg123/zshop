<%@ page language="java" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">
<html>
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
.STYLE1 {font-size: 12px}
-->
</style>
<script type="text/javascript" src="/ress/js/jquery/jquery-1.7.1.min.js" ></script>
<script type="text/javascript" src="/ress/js/jquery/jquery-ui-1.8.18.custom.min.js" ></script>
<script type="text/javascript" src="/dwr/interface/LoginService.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script language="javascript">
<!--
  function submitLogin(){
	  var para ={};
	  var user_code = $.trim($("#user_code").val());
	  var password = $.trim($("#password").val());
	  if(user_code==''){
		alert('请输入用户名');
		return false;
	  }
	  para.user_code = user_code;
	  para.password= password;
	  LoginService.validateLogin(para,function(data){
		  if(!data||data==null) alert("系统超时未返回，请重试!");	  
		  //alert(data.code);
		  if(data.code=='0'){
			  document.location.href="/admin/main.jsp";
	      }else{
			//alert(data.msg);
			return false;
		 }
		     
	  });
  }
//-->
</script>
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="9fc967">&nbsp;</td>
  </tr>
  <tr>
    <td height="604"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="604" background="/ress/images/login/login_02.gif">&nbsp;</td>
        <td width="989"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="345" background="/ress/images/login/login_1.jpg">&nbsp;</td>
          </tr>
          <tr>
            <td height="47"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="539" height="47" background="/ress/images/login/login_06.gif" nowrap="nowrap">&nbsp;</td>
                <td width="206" background="/ress/images/login/login_06.gif" nowrap="nowrap"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="17%" height="22"><div align="center"><span class="STYLE1">用户名</span></div></td>
                    <td width="58%" height="22"><div align="center">
                        <input name="user_code" id="user_code" type="text" size="15" style="height:17px; border:solid 1px #bbbbbb">
                    </div></td>
                    <td width="25%" height="22">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="22"><div align="center"><span class="STYLE1">密码</span></div></td>
                    <td height="22"><div align="center">
                        <input name="password" id="password" type="password" size="15" style="height:17px; border:solid 1px #bbbbbb">
                    </div></td>
                    <td height="22"><div align="center"><a href="javascript:void(0);" onclick="submitLogin();"><img src="/ress/images/login/dl.gif" width="39" height="18" border="0"></img></a></div></td>
                  </tr>                  
                </table></td>
                <td width="244" background="/ress/images/login/login_07.gif" nowrap="nowrap">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="212" background="/ress/images/login/login_08.gif">&nbsp;</td>
          </tr>
        </table></td>
        <td background="/ress/images/login/login_04.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="70ad21">&nbsp;</td>
  </tr>
</table>
</body>
</html>
