<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
    .top_5{
       padding-top: 5px;
    }
    .top_3{
        padding-top: 3px;
    }
</style>

<div region="center" class="easyui-layout">
    <div region="center" title="参数列表" style="padding:2px;">
        <table id="frconfigList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" fit="true">
            <thead>
            <tr>
            	<th field="dict_id" width="40" hidden>ID</th>
            	<th field="dict_code" width="40">会员编号</th>
                <th field="dict_name" width="40">会员名称</th>  
                <th field="dict_value" width="40">会员星级</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_edit" iconCls="icon-save" title="修改" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr style="display: none;">
    		<td>用户ID:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_dict_id" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>会员编码:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_dict_code" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>会员名称:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_dict_name" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>会员等级:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_dict_value" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td colspan="4" style="text-align:center"> 
    			<a href="javascript:void(0);" id="save" iconCls="icon-save" class="easyui-linkbutton">保存</a>
    			<a href="javascript:void(0);" id="cancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
    		</td>
    	</tr>
    </table>    
</div>
<div id="win_add" iconCls="icon-save" title="添加" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr>
    		<td>会员编码:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="add_dict_code" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>会员名称:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="add_dict_name" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>会员等级:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="add_dict_value" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td colspan="4" style="text-align:center"> 
    			<a href="javascript:void(0);" id="addsave" iconCls="icon-save" class="easyui-linkbutton">保存</a>
    			<a href="javascript:void(0);" id="addcancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
    		</td>
    	</tr>
    </table>    
</div>
<div id="editorDiv" style="display:none">
 	<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<script type="text/javascript" src="js/infodictMng.js"></script>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>