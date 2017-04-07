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
            <thead>
                <tr>
                    <th checkbox="true" width="40" ></th>
                    <th field="menu_id" width="40" >菜单ID</th>                   
                    <th field="menu_name" width="40" data-options="editor:'text'">菜单名称</th>
                    <th field="menu_url" width="40" data-options="editor:'text'">菜单链接</th>
                    <th field="url_open_type" width="40" data-options="editor:'text'">打开方式</th>
                    <th field="menu_desc" width="40"  data-options="editor:'text'">功能描述</th>
                    <th field="state" width="40" formatter="Menu.formatState" data-options="editor:{
							type:'combobox',
							options:{
								valueField:'state',
								textField:'stateName',
								url:'state.json',
								required:true
							}}">菜单状态</th>
                    <th field="order_id" width="40" data-options="editor:'numberbox'">排序ID</th>
                    <%-- 
                    <th field="state" width="40" code="DC_STATE">任务类型</th>
                    --%>
                </tr>
            </thead>
        </table>
</div>
<script type="text/javascript" src="js/menu.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>