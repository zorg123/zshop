<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%
	String baseUri = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CMS管理系统</title>
<link rel="stylesheet" href="<%=baseUri%>/public/common/ress/css/reset.css" type="text/css" />
<link rel="stylesheet" href="<%=baseUri%>/public/common/ress/css/login.css" type="text/css" />
<script language="javascript" type="text/javascript" >
	var base="<%=baseUri%>";
</script>
</head>
<style type="text/css">
*{ margin:0; padding:0; font-size:100%; }
html, body{ height:100%; }
html{box-sizing:border-box; -webkit-box-sizing:border-box; -moz-box-sizing:border-box; padding:0 0 40px 0; overflow:hidden;}
</style>
<body>
<div class="wrapper">
	<div class="main_div">
    	<div class="left_div floatleft">
        	<div class="left_content">
            	<ul>
               	  <li>人员管理</li>
               	  <li>内容配置</li>
               	  <li>组织管理</li>
                </ul>
            </div>
		</div>
        <div class="center_div floatleft">
       	  <div class="login_msg">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  	<tr>
                   	  	<th>用户名：</th>
                  	</tr>
                  	<tr>
                    	<td><input type="text" name="user_name" class="Input1"></td>
                  	</tr>
                  	<tr>
                   	  	<th>密码：</th>
                  	</tr>
                  	<tr>
                    	<td><input type="password" name="user_pass"  class="Input1"></td>
                  	</tr>
                  	 <tr>
                   	  	<th>验证码：</th>
                  	</tr>
                  	<tr>
                    	<td><input type="text" style="width:80px" name="valid_code" class="Input2"><img id="valid_code_img" src="<%=baseUri%>/public/vc.jsp" style="cursor:pointer;padding-top:3px;height:28px;" onclick="javascript:this.src='<%=baseUri%>/public/vc.jsp?d='+(new Date());"></td>
                  	</tr>
               	</table>
		  </div>
            <div class="login_bnt">
		    <div class="bnt_login" id="login_btn" onMouseOver="this.style.backgroundImage='url(<%=baseUri%>/public/common/ress/images/login/login_hover.png)'"
                 onMouseOut="this.style.backgroundImage='url(<%=baseUri%>/public/common/ress/images/login/login_normal.png)'">
             </div>
            </div>
		</div>
    	<div class="right_div floatleft"></div>
    	<div class="clear"></div>
  </div>
</div>

<link rel="stylesheet" type="text/css" href="<%=baseUri%>/public/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri%>/public/easyui/themes/icon.css">
<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=baseUri%>/public/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/CommonUtils.js"></script>
<script type="text/javascript" src="<%=baseUri%>/admin/login/login.js"></script>
</body>
</html>
