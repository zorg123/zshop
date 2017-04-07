<%@ page language="java" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
-->
</style>
<link href="/ress/css/zTreeStyle/zTreeIcons.css" rel="stylesheet" type="text/css" />
<link href="/ress/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ress/js/jquery/jquery-1.7.1.min.js" ></script>
<script type="text/javascript" src="/dwr/interface/LoginService.js"></script>
<script type="text/javascript" src="/dwr/interface/MenuService.js"></script>
<script type='text/javascript' src='/ress/js/dwr/engine.js'></script>

<script language="javascript" type="text/javascript" src="/ress/js/jquery/jquery-ztree-2.5.min.js" ></script>
</head>
<body>
<div>
	<ul id="menuTreeUL" class="tree"></ul>
</div>
</body>
<script type="text/javascript" language="javascript">
	var menuId="<c:out value="${param.menuId}" />";
</script>
<script type="text/javascript" src="/admin/js/left.js" ></script>
</html>
