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
	            <label>会员状态：</label>
	            <select class="easyui-combobox" name="search_state" style="width:80px;">
	                <option value="-1">--请选择--</option>
	                <option value="1">已激活</option>
	                <option value="0">未激活</option>               
	            </select>
	            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	        </div>
	    </div>
	
	    <div region="center" title="员工列表" >
	        <table id="staffList"  rownumbers="true" pagination="true"
	               fitColumns="false" nowrap="false" showFooter="true" singleSelect="true" style="height:400px">
	            <thead>
	            <tr>
	                <th field="user_id" hidden>员工ID</th>
	                <th field="user_code" width="140">会员编号</th>
	                <th field="name" width="140">会员名称</th>
	                <th field="phone" width="100">电话</th>
	                <th field="state" width="100" formatter="Employee.formatState">是否激活</th>
	                <th field="user_level" width="100">会员等级</th>
	                <th field="act_time" width="140">激活时间</th>
	            </tr>
	            </thead>
	        </table>
	    </div>
    </div>
</div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>
<script type="text/javascript" src="js/reportUserInfo.js"></script>
