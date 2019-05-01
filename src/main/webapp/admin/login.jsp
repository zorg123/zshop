<%@ page language="java" pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>    
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>仿钉钉网登录注册页面静态模板源码 - 代码库</title>
    <link href="/admin/css/bootstrap.min.css"  rel="stylesheet">
    <link href="/admin/css/a3common.css" rel="stylesheet">
    <link rel="stylesheet" href="/admin/css/login.css" >
    <link rel="stylesheet" href="/admin/css/font_43459_lbtux0zjkr6yldi.css" >
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


    <div id="main" class="main-warp">
        <div class="main-content">
            <div class="formDiv">
                
                    <h2 class="text-center">登录</h2>
                
                
                <form id="loginForm" method="post">
                    <div class="dataform" >
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input id="user_code" name="user_code" type="text" class="inputs" placeholder="用户名" maxlength="64">
                        </div>
                        <div class="error-content">
                            <span id="userNameErr" class="errMsg"></span>
                        </div>

                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input class="inputs" type="password" name="password" id="password" placeholder="密码" id="pwd" maxlength="20">
                        </div>
                        <div class="error-content">
                            <span id="passwordErr" class="errMsg"></span>
                        </div>

                        <div class="btn-warp gap">
                            <div class="text-center">                               
                                <input type="hidden" value="jsform" id="_app"/>
                                <button type="submit" id="btnLogin" class="btn btn-block lgbtn blue">登录</button>
                            </div>
                        </div>
                        <div class="gap">
                            
                                <div class="pull-right" style="margin-top: 6px"><a href="javascript:;" class="link"></a><span class="split-space"></span><a  class="link"></a></div>
                            
                            <div class="pretty-box">
                                <input type="checkbox" value="1" name="REMEMBER" id="remember" class="">
                                <label for="remember" style="font-weight: normal" >记住我</label>
                            </div>
                        </div>

                        
                            <div class="biggap third-party-title">
                               
                            </div>
                            <div class="third-auth">                              
                                
                               
                                
                            </div>
                        
                    </div>
                </form>

            </div>
        </div>
    </div>

</body>
</html>
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
