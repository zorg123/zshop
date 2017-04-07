<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<style type="text/css">
    .top_5{
       padding-top: 5px;
    }
    .top_3{
        padding-top: 3px;
    }
</style>

<div region="center" class="easyui-layout">
    <div region="north" style="height:50px;" id="search" >
        <div region="center"style="margin-top: 5px;margin-left: 5px;" >
            <label>角色名称：</label><input type="text" name="search_name">
            <label>角色描述：</label><input type="text" name="search_desc">
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>

    <div region="center" title="角色列表" style="padding:2px;">
        <table id="roleList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" style="height:450px">
            <thead>
            <tr>
                <th field="role_id" width="40" hidden>角色ID</th>
                <th field="role_name" width="40">角色名称</th>
                <th field="role_desc" width="40">描述</th>
                <th field="create_date" width="40">角色维护时间</th>
            </tr>
            </thead>
        </table>
    </div>
</div>



<!---->
<div id="win_save" iconCls="icon-save" title="添加角色" style="background:#fafafa;padding:10px;display: none;">
    <div class="top_5">
        <label>角色名称:</label>
        <input class="easyui-validatebox" type="text" name="role_name"/>
    </div>   
    <div class="top_5">
        <label>角色描述:</label>
        <textarea name="role_desc" style="height:60px;"></textarea>
    </div>
    <div>
        <div style="margin:10px 0;">
            <a href="javascript:void(0);" id="save" iconCls="icon-save" class="easyui-linkbutton">保存</a>
            <a href="javascript:void(0);" id="cancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
        </div>
    </div>
</div>

<!---->
<div id="win_menu" title="角色权限分配" style="width:600px; display: none;">
	<div class="easyui-layout" style="width:580px;height:370px;">
	    <div region="west" style="width:250px" title="菜单目录">
	    	<div id="menu_tree" region="west"  animate="true" dnd="true">
	    	</div>
	    </div>
	    <div region="center" style="width:50px" title="操作区">
	    	<div style="padding-top:150px"> 
	    		<a href="javascript:void(0);" id="role_fun_add" class="easyui-linkbutton" >添加&gt;&gt; </a>
	   		</div>
	    	<div>	
	        	<a href="javascript:void(0);" id="role_fun_del" class="easyui-linkbutton" >删除&lt;&lt;</a>
	    	</div>
	    </div>
	    <div region="east" style="width:250px" title="已分配选择菜单">
	    	<div id="menu_select_tree" animate="true" dnd="true">
	    	</div>
	    </div>
	    <div region="south" style="padding: 5px; text-align: center;height:40px;">
	        <a href="javascript:void(0);" id="role_fun_save" class="easyui-linkbutton" icon="icon-ok">保存</a>
	        <a href="javascript:void(0);" id="role_fun_cancel" class="easyui-linkbutton" icon="icon-cancel">取消</a>
	    </div>
    </div>
</div>

<script type="text/javascript" src="js/role.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>