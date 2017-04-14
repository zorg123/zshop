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
    <div region="north" style="height:50px;" id="search" >
        <div region="center"style="margin-top: 5px;margin-left: 5px;" >
        	<label>是否打款：</label>
            <select class="easyui-combobox" name="apply_state" style="width:80px;">
                <option value="">--请选择--</option>
                <option value="0">未打款</option>
                <option value="1">已打款</option>
            </select>
            <label>开始时间：</label><input type="text" name="start_time" class="easyui-datebox" />
            <label>结束时间：</label><input type="text" name="end_time" class="easyui-datebox" />
            <label>会员工号：</label><input type="text" name="query_user_code">
                      
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <div region="center" title="充值列表" style="padding:2px;">
        <table id="extractConfirmList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" fit="true">
            <thead>
            <tr>
            	<th field="id" width="40" hidden>提现ID</th>
            	<th field="user_id" width="40" hidden>用户id</th>
                <th field="user_code" width="40">会员编号</th>  
                <th field="user_name" width="40">会员名称</th>
                <th field="create_time" width="40">提现时间</th>              
                <th field="coin_num" width="40">提现金额</th>
                <th field="counter_num" width="40">手续费</th>
                <th field="act_num" width="40">打款金额</th>
                <th field="apply_state" width="40">是否打款</th>
                <th field="serial_num" width="40">打款流水号</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_edit" iconCls="icon-save" title="会员充值" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr style="display: none;">
    		<td>id:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_id" style="width:200px"/></td>
    	</tr>
    	<tr style="display: none;">
    		<td>用户编号:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_user_id" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>会员编号:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_user_code" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>打款金额:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_coin_num" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>是否打款:</td>
    		<td colspan="3">
    		<select class="easyui-combobox" name="edit_apply_state" style="width:200px;">
                <option value="1">已打款</option>
            </select></td>
    	</tr>
    	<tr>
    		<td>流水号:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_serial_num" style="width:200px"/></td>
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
<script type="text/javascript" src="js/userExtractConfirm.js"></script>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>