<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.Date" %>
<%
	String baseUri = request.getContextPath();
    Long d = (new Date()).getTime();
    String dataType = request.getParameter("data-type");
%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户中心</title>
    <meta name="description" content="">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=baseUri %>/wap/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=baseUri %>/wap/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="<%=baseUri %>/wap/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=baseUri %>/wap/assets/css/validate.css">
    <link rel="stylesheet" href="<%=baseUri %>/wap/assets/css/admin.css">
    <link rel="stylesheet" href="<%=baseUri %>/wap/assets/css/app.css">
    <script src="<%=baseUri %>/wap/assets/js/echarts.min.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/jquery.min.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/amazeui.min.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/amazeui.page.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/iscroll.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/app.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/CommonUtils.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/layer.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/iscroll.js"></script>
    <script src="<%=baseUri %>/wap/assets/js/jquery-mvalidate.js"></script>
</head>
<script language="javascript" type="text/javascript" >
	var base="<%=baseUri%>";
</script>
<body data-type="<%=dataType%>">