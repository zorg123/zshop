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
	            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	        </div>
	    </div>
	
	    <div region="center" title="员工列表" >
	        <table id="staffList"  rownumbers="true" pagination="true"
	               fitColumns="false" nowrap="false" showFooter="true" singleSelect="true">
	            <thead>
	            <tr>
	                <th field="user_code" width="140">会员编号</th>
	                <th field="user_name" width="140">会员名称</th>
	                <th field="cash_coin" width="100">现金账户</th>
	                <th field="elect_coin" width="100">电子账户</th>
	                <th field="reconsmp_coin" width="100">重消账户</th>
	                <th field="bonusact_sum" width="100">奖金总收入</th>
	                <th field="reconsmpact_sum" width="100">重消总收入</th>
	            </tr>
	            </thead>
	        </table>
	    </div>
    </div>
</div>
<script type="text/javascript" src="js/accountInfo.js"></script>