<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<div region="west" split="true" title="菜单目录" style="width:200px;">
	<ul id="menu_tree"  animate="true" dnd="true">
	</ul>
</div>  
<div region="center" title="菜单列表" style="padding:2px;">
        <table id="menuList" rownumbers="true" pagination="true" 
            fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" style="height:450px"
            data-options="			
				onDblClickRow: Menu.onDbClickRow
			">            
        </table>
</div>
<script type="text/javascript" src="js/menu.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>