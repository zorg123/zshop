<%@ page language="java" pageEncoding="utf-8"%> 
<%@ taglib uri="/struts-tags" prefix="s" %>
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
	color: #FFFFFF;
}
.STYLE2 {
	font-size: 12px;
	color: #333333;
}
-->
a:link {font-size:12px; color:#000000; text-decoration:none;}
a:visited {font-size:12px; color:#000000; text-decoration:none;}
a:hover {font-size:12px; color:#00CCFF;text-decoration:none;}
.STYLE4 {font-size: 12px}
</style>
<link rel="stylesheet" type="text/css" href="/ress/css/common/common.css"></link>
<script type="text/javascript" src="/ress/js/common/commonUtils.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type="text/javascript" src="/ress/js/jquery/jquery-1.7.1.min.js" ></script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr style="height:11px;">
    <td  style="height:11px;background:url(/ress/images/admin/main_03.gif)">
    	<!--  <img src="/ress/images/admin/main_01.gif" > -->
    </td>
  </tr>
  <tr style="height:80px;">
    <td background="/ress/images/admin/main_07_80.gif">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr >
        <td style="width:282px;height:80px" background="/ress/images/admin/main_05_80.gif" rowspan="2" >&nbsp;</td>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><span class="STYLE1"><img src="/ress/images/admin/home.gif" width="12" height="13"> </span><span class="STYLE4"><a href="#">回首页</a></span><span class="STYLE1"> <img src="/ress/images/admin/quit.gif" width="16" height="16"> </span><span class="STYLE4"><a href="#">退出系统</a></span><span class="STYLE1"> </span></td>
          </tr>
        </table>
        </td>
        <td width="247" background="/ress/images/admin/main_08_80.gif">
        </td>
        <td width="483" background="/ress/images/admin/main_09_80.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="/ress/images/admin/uesr.gif" width="14" height="14"><span class="STYLE2">当前登录用户：<label id="userName"></label> 角色：<label id="roleName"></label> 上次登录时间：<label id="lastLoginTime"></label></span></td>
          </tr>
        </table>
        </td>
      </tr>
      <tr>
       <td colspan="3">
       	<div class="nav_content">
       		<ul style="margin-left:0px">
       		    <s:iterator value="menuList" id="menu" status="listStat">
       		    	<s:set var="className" value="" />       		    	
       		        <s:if test="#listStat.index == 0">       		            
       		        	<s:set var="className" value="'nav_contenton'" />
       		        	<s:set var="curMenuId" value="#menu.menu_id" />
       		        </s:if>        
       				<li id="<s:property value="#menu.menu_id" />" class="<s:property value="#className" />">
       					<span><a href="javascript:void(0)" url="<s:property value="#menu.menu_url" />" openType="<s:property value="#menu.url_open_type" />" ><s:property value="#menu.menu_name" /></a></span>
       				</li>
       			</s:iterator>       			
       		</ul>
       	 </div>
       </td>
      </tr>
    </table>
    </td>
  </tr>
  <tr></tr>
</table>
</body>
<script lanauge="javascript" type="text/javascript">
    var userName="";
    var roleRoleName="";
    var curMenuId = "<s:property value="#curMenuId" />";
    LoginService.getLoginSessionInfo(function(data){
		if(data!=null){
			userName=data.name;
			var lastLoginTime=data.last_login_time;
			var roleList = data.roleList;			
			if(roleList!=null&&roleList.length>0){
				for(var i =0; i<roleList.length;i++){
					roleRoleName=roleRoleName+roleList[i].role_name+",";
				}
				if(roleRoleName.length>0){
					roleRoleName=roleRoleName.substring(0,roleRoleName.length-1);
				}
				$("#userName").text(userName);
				$("#roleName").text(roleRoleName);	
				$("#lastLoginTime").text(getTime(lastLoginTime));		
				//alert(parent.document.getElementById("mainFrame").contentWindow.document.getElementById("leftFrame").src);
			}else{
				alert("你还没有角色，请联系管理员分配后在登录!");
				parent.document.location.href="/login.jsp"
			}
		}else{
		  alert("你还没有登陆，请登录!");
		  parent.document.location.href="/admin/login.jsp"		 
		}
	});
	function getTime(d){
			var hour=d.getHours();
			var minute=d.getMinutes();
			var second=d.getSeconds();
			var year = d.getFullYear();
			var month = d.getMonth()+1;
			var day = d.getDate();
			var dStr = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;	
			return dStr;
	}
	$(document).ready(function(){
		$(".nav_content ul li").hover(function(){$(this).addClass("nav_contenton").siblings().removeClass("nav_contenton");},function(){$("#"+curMenuId).addClass("nav_contenton").siblings().removeClass("nav_contenton");});
		$(".nav_content ul li span").last().addClass("nav_contentspan");

		$(".nav_content ul li span a").click(function(){
			var openType = $(this).attr("openType");
			var url = $(this).attr("url");
			curMenuId = $(this).parent().parent().attr("id");
			//alert(url);
			if(openType=='1'){
				openBlankWindow(url);
			}else{
				url=url+"?menuId="+curMenuId;
				$(parent.mainFrame.document).find("#leftFrame").attr("src",url);
			}
			$(this).parent().parent().addClass("nav_contenton").siblings().removeClass("nav_contenton");
		});
		
	});
</script>
</html>
