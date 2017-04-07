<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<div region="west" split="true" title="组织目录" style="width:200px;height:400px">
    <ul id="organizationTree"  animate="true" dnd="true" >
    </ul>
</div>
<div region="center" title="组织列表" style="padding:2px;height:450px">
    <table id="orgList"  rownumbers="true" pagination="true"
           fitColumns="true" nowrap="false" showFooter="true" singleSelect="false" style="height:450px">
        <thead>
        <tr>
            <th field="org_id" width="40" hidden>组织ID</th>
            <th field="org_code" width="40">组织编码</th>
            <th field="org_name" width="40">组织名称</th>
            <th field="up_org_name" width="40">上级组织</th>
            <th field="state" width="40" formatter="Org.formatState">状态</th>
            <%--
            <th field="level_index" width="40" code="MENU_LEVEL">任务类型</th>
            <th field="state" width="40" code="DC_STATE">任务类型</th>
            --%>
        </tr>
        </thead>
    </table>
</div>
<div id="win_save" iconCls="icon-save" title="添加角色" style="background:#fafafa;padding:10px;display: none;">
    <div class="top_5" style="height:30px">
        <label>组织编码:</label>
        <input class="easyui-validatebox" type="text" id="id_org_code"/>
    </div>   
    <div class="top_5" style="height:30px">
        <label>组织名称:</label>
        <input class="easyui-validatebox" type="text" id="id_org_name"/>
    </div>
    <div class="top_5" style="height:30px">
        <label>上级组织名称:</label>
        <input class="easyui-validatebox" type="text" id="id_up_org_name" disabled/>
    </div>
    <div class="top_5" style="height:30px">
        <label>状态:</label>
        <select id="id_state" style="width:80px;">
             <option value="1">有效</option>
             <option value="0">无效</option>                       
         </select>
    </div>
    <div>
        <div style="margin:10px 0;">
            <a href="javascript:void(0);" id="save" iconCls="icon-save" class="easyui-linkbutton">保存</a>
            <a href="javascript:void(0);" id="cancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/org.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>