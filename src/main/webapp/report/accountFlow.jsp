<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<div region="center" class="easyui-layout">
	<div region="center" style="padding:2px;" class="easyui-layout">
	    <div region="north" style="height:50px;" id="search">
	        <div region="center" style="margin-top: 10px;margin-left: 10px;">
	            <label>会员编号：</label><input type="text" name="search_code">
	            <label>会员名称：</label><input type="text" name="search_name">
	            <label>币种类型：</label>
	            <select class="easyui-combobox" name="search_coin_type" style="width:80px;">
	                <option value="">--请选择--</option>
	                <option value="1">奖金币</option>
	                <option value="2">电子币</option>
	                <option value="3">重消币</option>
	            </select>
	            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	        </div>
	    </div>
	
	    <div region="center" title="员工列表" >
	        <table id="staffList"  rownumbers="true" pagination="true"
	               fitColumns="false" nowrap="false" showFooter="true" singleSelect="true" fit="true">
	            <thead>
	            <tr>
	                <th field="user_id" hidden>员工ID</th>
	                <th field="user_code" width="140">会员编号</th>
	                <th field="user_name" width="140">会员名称</th>
	                <th field="create_time" width="140">时间</th>
	                <th field="create_type_name" width="140">类型</th>
	                <th field="coin_num" width="140">金额</th>
	                <th field="comments" width="140">说明</th>
	                <th field="balance_comments" width="140">余额说明</th>
	            </tr>
	            </thead>
	        </table>
	    </div>
    </div>
</div>
<script type="text/javascript" src="js/accountFlow.js"></script>