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
            	<th field="cf_id" width="40" hidden>ID</th>
            	<th field="cf_module" width="40" hidden>模块</th>
                <th field="cf_desc" width="40">参数描述</th>  
                <th field="cf_value" width="40">参数值</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_edit" iconCls="icon-save" title="会员充值" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr style="display: none;">
    		<td>ID:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_cf_id" style="width:200px"/></td>
    	</tr>
    	<tr style="display: none;">
    		<td>模块:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_cf_module" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>参数描述:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_cf_desc" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>参数值:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_cf_value" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td colspan="4" style="text-align:center"> 
    			<a href="javascript:void(0);" id="save" iconCls="icon-save" class="easyui-linkbutton">保存</a>
    			<a href="javascript:void(0);" id="cancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
    		</td>
    	</tr>
    </table>    
</div>
<div id="editorDiv" style="display:none">
 	<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<script type="text/javascript" src="js/frconfigMng.js"></script>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>