<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%
	String baseUri = request.getContextPath();
%>
<!DOCTYPE HTML>
<!DOCTYPE html>
<html>
<head>    
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>管理后台</title>
    <link href="<%=baseUri%>/admin/css/bootstrap.min.css"  rel="stylesheet">
    <link href="<%=baseUri%>/admin/css/a3common.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=baseUri%>/admin/css/login.css" >
    <link rel="stylesheet" href="<%=baseUri%>/admin/css/font_43459_lbtux0zjkr6yldi.css" >
	<script language="javascript" type="text/javascript" >
		var base="<%=baseUri%>";
	</script>
</head>
<body>
    <div id="main" class="main-warp" style="height:100%">
        <div class="main-content">
            <div class="formDiv">                
                <h2 class="text-center">后台管理登录</h2> 
                
                    <div class="dataform" >
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input id="user_name" name="user_name" type="text" class="inputs" placeholder="用户名" maxlength="64">
                        </div>
                        <div class="error-content">
                            <span id="userNameErr" class="errMsg"></span>
                        </div>

                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input class="inputs" type="password" name="user_pass" id="password" placeholder="密码" id="pwd" maxlength="20">
                        </div>
                        <div class="error-content">
                            <span id="passwordErr" class="errMsg"></span>
                        </div>
                        <div class="input-warp gap ">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input class="inputs"  name="valid_code" id="valid_code" placeholder="验证码" id="pwd" maxlength="20" style="width:50%">
                            <img id="valid_code_img" src="<%=baseUri%>/public/vc.jsp" style="cursor:pointer;height:30px;float:right;margin-top:-6px" onclick="javascript:this.src='<%=baseUri%>/public/vc.jsp?d='+(new Date());">
                        </div>
                        <div class="error-content">
                            <span id="passwordErr" class="errMsg"></span>
                        </div>

                        <div class="btn-warp gap">
                            <div class="text-center">                            
                                <button id="login_btn" class="btn btn-block lgbtn blue">登录</button>
                            </div>
                        </div>
                        <div class="gap">                            
                            <div class="pull-right" style="margin-top: 6px"><span class="split-space"></span><a  class="link"></a></div>                            
                            <div class="pretty-box" style="cursor:hand">
                                <input type="checkbox" value="1" name="remember-me" id="remember-me">
                                <label for="remember" style="font-weight: normal" >记住我</label>
                            </div>
                        </div>                        
                            <div class="biggap third-party-title">                               
                            </div>
                            <div class="third-auth">
                            </div>
                    </div>
            </div>
        </div>
    </div>

</body>
<link rel="stylesheet" type="text/css" href="/shop/public/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/shop/public/easyui/themes/icon.css">

<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=baseUri%>/public/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/CommonUtils.js"></script>
<script type="text/javascript" src="<%=baseUri%>/admin/login/login.js"></script>
</html>
