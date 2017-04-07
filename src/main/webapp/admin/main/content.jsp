<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/common/ress/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/common/ress/css/jq/jquery.loadmask.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/easyui/themes/icon.css">
<script type="text/javascript" src="<%=baseUri %>/ress/js/jquery/jquery-1.8.0.min.js"></script> 
<!--<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery-1.5.1.min.js"></script>-->
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.loadmask.min.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/json2.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/CommonUtils.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/artTemplate/template.js"></script>
<script language="javascript" type="text/javascript" >
	var base="<%=baseUri%>";
</script>
</head>
<body style="width:100%">
<link rel="stylesheet" href="<%=baseUri %>/public/common/ress/css/reset.css" type="text/css" />
<link rel="stylesheet" href="<%=baseUri %>/public/common/ress/css/main.css" type="text/css" />
<style>
html, body{overflow-y:auto;}
</style>

<div class="content_div">
	<div class="content_left">
    	<div class="content_left_div">
        	<div class="notice_div">
            	<div class="notice_title">
                	<div class="notice_title_right">
                    	<div class="notice_title_left">
                        	<h2>公告<span><a href=""></a></span></h2>
                        </div>
                    </div>
                </div>
                <div class="notice_content" id="noticeContent"></div>
            </div>           
        </div>
    </div>
</div>
<div id="noticeDetail" style="display:none" class="notie_detail">
	<div class="title">
		<span id="detailTitle"></span>
	</div>
	<div class="time">
		发布日期：<span id="detailTime"></span>
	</div>
	<div id="detailContent" class="content">
			
	</div>
</div>
<script type="text/javascript" src="<%=baseUri %>/admin/main/js/content.js" charset="utf-8"></script>
<script>
   $(function(){
		noticeIndex.queryNotices();
   });
</script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>