<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.Date" %>
<%
	String baseUri = request.getContextPath();
    Long d = (new Date()).getTime();
%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">    
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit"> 
<title>黄河水利科学院办公系统</title>
<link href="<%=baseUri %>/public/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/common/ress/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/common/ress/css/jq/jquery.loadmask.css">
<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/easyui/themes/icon.css">
<link rel="stylesheet" href="<%=baseUri %>/public/infoShare/css/common-base.css">
<link rel="stylesheet" href="<%=baseUri %>/public/infoShare/css/website.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/public/bootstrap-3.2.0/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/public/bootstrap-3.2.0/respond.min.js"></script>
<![endif]-->
 
 <script type="text/javascript" src="<%=baseUri %>/public/infoShare/jquery-1.11.1.min.js"></script>
<!--<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery-1.5.1.min.js"></script>-->
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.loadmask.min.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/easyui/jquery.easyui.extend.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/json2.js"></script>
<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/CommonUtils.js?v=<%=d%>"></script>
<script type="text/javascript" src="<%=baseUri %>/public/echarts/echarts.min.js"></script>
<script language="javascript" type="text/javascript" >
	var base="<%=baseUri%>";
</script>
<script src="<%=baseUri %>/public/bootstrap/js/bootstrap.min.js"></script>
</head>
<body id="index-page">
