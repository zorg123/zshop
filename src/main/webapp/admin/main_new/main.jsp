<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>FRCMS-后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=baseUri%>/public/common/ress/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=baseUri%>/public/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=baseUri%>/public/common/ress/css/jq/jquery.loadmask.css">
	<link rel="stylesheet" type="text/css" href="<%=baseUri%>/public/easyui/themes/icon.css">
	<link href="<%=baseUri%>/public/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" id="mylink"/>     
    <link href="<%=baseUri%>/public/common/ress/css/mainnew.css" rel="stylesheet" type="text/css" />
    <script src="<%=baseUri%>/public/common/ress/js/jquery-1.5.1.min.js" type="text/javascript"></script>     
	<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/jquery.loadmask.min.js"></script>
	<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=baseUri%>/public/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=baseUri%>/public/easyui/locale/easyui-lang-zh_CN.js"></script>   
    <script src="<%=baseUri%>/public/ligerUI/js/ligerui.all.js" type="text/javascript"></script>    
    <script src="<%=baseUri%>/public/common/ress/js/jquery.cookie.js"></script>
    <script src="<%=baseUri%>/public/ligerUI/json2.js"></script>    
	<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/CommonUtils.js"></script>
	<script language="javascript" type="text/javascript" >
		var base="<%=baseUri%>";
	</script>
    <script src="<%=baseUri%>/admin/main_new/js/index.js" type="text/javascript"></script>
  <style type="text/css"> 
    body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('/admin/main_new/loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('lib/images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('lib/images/topicon.gif') no-repeat 10px 5px;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
     .body-gray2014 #framecenter{
        margin-top:3px;
    }
      .viewsourcelink {
         background:#B3D9F7;  display:block; position:absolute; right:10px; top:3px; padding:6px 4px; color:#333; text-decoration:underline;
    }
    .viewsourcelink-over {
        background:#81C0F2;
    }
    .l-topmenu-welcome label {color:white;
    }
    #skinSelect {
        margin-right: 6px;
    }
 </style>
</head>
<body style="padding:0px;background:#EAEEF5;">  
<div id="pageloading"></div>  
<div class="header">
  <div class="header_logo"></div>
    <div class="header_center">
    	<ul class="quick_menu">
    	
        </ul>
    </div>
    <div class="header_right">
    	<!--  <a id="profile" href="javascript:void(0)"><img src="<%=baseUri%>/public/common/ress/images/main/icon_home.png" width="16" height="16" style="vertical-align:middle;">&nbsp;个人资料</a> -->
    	<a id="mdfPwd" href="javascript:void(0)"><img src="<%=baseUri%>/public/common/ress/images/main/icon_home.png" width="16" height="16" style="vertical-align:middle;">&nbsp;修改密码</a>
    	<!--   <a id="relogin" href="javascript:void(0)"><img src="/public/common/ress/images/main/icon_reset.png" width="16" height="16" style="vertical-align:middle;">&nbsp;重新登录</a>-->
    	<a id="logout" href="javascript:void(0)"><img src="<%=baseUri%>/public/common/ress/images/main/icon_close.png" width="16" height="16" style="vertical-align:middle;">&nbsp;退出</a>
    </div>
    <div class="clear"></div>
</div>
<div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
        <div position="left"  title="功能模块" id="accordion1"> 
        		<s:iterator  value="menuList"  id="menu" status="st">	
        			<div title="<s:property value="#menu.menu_name" escape="false"/>" class="l-scroll">
                         <ul id="tree<s:property value="#menu.menu_id" />" class="ligerTree" style="margin-top:3px;">                         	
                         	<s:iterator  value="#menu.sub_menu_list"  id="subMenu">
                         		<li isexpand="true" menu_name="<s:property value="#subMenu.menu_name" escape="false"/>" menu_id="<s:property value="#subMenu.menu_id" />" menu_url="<s:property value="#subMenu.menu_url" />" url_open_type="<s:property value="#subMenu.url_open_type" />">
                         			<span><s:property value="#subMenu.menu_name" escape="false"/></span>
                         		</li>	
                         	</s:iterator>
                         </ul>
                    </div>
        		</s:iterator>                   
        </div>
        <div position="center" id="framecenter"> 
            <div tabid="home" title="我的主页" style="height:300px" >
                <iframe frameborder="0" name="home" id="home" src="<%=baseUri%>/admin/main/content.jsp"></iframe>
            </div> 
        </div> 
        
    </div>
    <div  style="height:32px; line-height:32px; text-align:center;">
            Copyright @ 2011-2017 未名科技
    </div>
    <div style="display:none" id="pwd_win">
	<div>
		<table style="width:100%;padding:25px 20px 20px 20px;text-align:center">
			<tr><td>原密码:</td><td><input type="password" id="old_pwd" name="old_pwd" width="100px" /></td></tr>
			<tr><td>新密码:</td><td><input type="password" id="new_pwd" name="new_pwd" width="100px" /></td></tr>
			<tr><td>确认新密码:</td><td><input type="password" id="re_new_pwd" name="re_new_pwd" width="100px" /></td></tr>
			<tr>
				<td colspan="2">
					<div style="margin:10px 0;">
	            		<a href="javascript:void(0);" id="save" iconCls="icon-save" class="easyui-linkbutton">保存</a>
	            		<a href="javascript:void(0);" id="cancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
	        		</div>
        		</td>
        	</tr>
		</table>
	</div>
</div>
    <div style="display:none"></div>
</body>
</html>

