<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/common/ress/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/common/ress/css/jq/jquery.loadmask.css">
	<link rel="stylesheet" type="text/css" href="<%=baseUri %>/public/easyui/themes/icon.css">
	<link href="<%=baseUri %>/public/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" id="mylink"/>     
    <link href="<%=baseUri %>/public/common/ress/css/mainnew.css" rel="stylesheet" type="text/css" />
    <script src="<%=baseUri %>/public/common/ress/js/jquery-1.5.1.min.js" type="text/javascript"></script>     
	<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.loadmask.min.js"></script>
	<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=baseUri %>/public/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=baseUri %>/public/easyui/locale/easyui-lang-zh_CN.js"></script>   
    <script src="<%=baseUri %>/public/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <script src="<%=baseUri %>/public/jquery-validation/jquery.validate.min.js"></script>
    <script src="<%=baseUri %>/public/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="<%=baseUri %>/public/jquery-validation/messages_cn.js" type="text/javascript"></script>   
    <script src="<%=baseUri %>/public/common/ress/js/jquery.cookie.js"></script>
    <script src="<%=baseUri %>/public/ligerUI/json2.js"></script>   
    <script type="text/javascript" src="<%=baseUri %>/public/common/js/ajaxfileupload.js"></script> 
	<script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/CommonUtils.js"></script>
	<script language="javascript" type="text/javascript" >
		var base="<%=baseUri%>";
	</script>
</head>
<body style="width:100%">
