<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title> 
<link rel="stylesheet" href="<%=baseUri%>/public/common/ress/css/tab.css" type="text/css" />
<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=baseUri%>/public/common/ress/js/tab.js"></script>

</head>
<style type="text/css">
*{ margin:0; padding:0; font-size:100%; }
html, body{ height:100%;}
.tabtop, .tabmain{ position:relative; }
.tabtop{}
.tabtop{ height:29px; margin-top:-29px;}
.tabmain{ height:100%;overflow:hidden;}
html{box-sizing:border-box; -webkit-box-sizing:border-box; -moz-box-sizing:border-box; padding:29px 0 0 0; overflow:hidden; }
#tab_menu {padding: 0px;width: 100%;height: 29px;}
#page {width:100%;height:100%;/*height: expression(parentNode . parentNode . offsetHeight-25);*/}
</style>
<script language="javascript">
var tab=null;
$( function() {
	  tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab_po',
		position :"top"
	});
	tab.add( {
		id :'tab_00000',
		title :"首页",
		url :"content.jsp",
		isClosed :false
	});
	
});
</script>

<body>
<div class="tabtop">	
    <div id="tab_menu" style="position:absolute; z-index:0; left:0px; top:0px;"></div>
    <div style=" position:absolute;text-align:right;right:5px; top:2px; width:70px; z-index:2;">
       <img id="icon_frash" src="<%=baseUri%>/public/common/ress/images/main/icon_frash.jpg" width="19" height="19" />&nbsp;
	   <img id="icon_close" src="<%=baseUri%>/public/common/ress/images/main/icon_close.jpg" width="19" height="19" />  
</div>
</div>

	
<div class="tabmain">
	<div id="page"></div>
</div>
</body>
</html>
