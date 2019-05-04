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
	            <%-- <label>分红池类型：</label>
	            <select class="easyui-combobox" name="search_create_type" style="width:150px;">
	                <option value="">--请选择--</option>
	                <option value="2">2级分红池</option>
	                <option value="3">3级分红池</option>
	                <option value="4">4级分红池</option>
	                <option value="5">5级分红池</option>
	                <option value="6">6级分红池</option>
	            </select> --%>
	            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	        </div>
	    </div>
	
	    <div region="center" title="分红池明细" >
	        <table id="poolFlowList"  rownumbers="true" pagination="true"
	               fitColumns="false" nowrap="false" showFooter="true" singleSelect="true" fit="true">
	            <thead>
	            <tr>
	                <th field="cf_desc" width="200">分红池类型</th>
	                <th field="total" width="200">分红池金额</th>
	                <th field="usercount" width="200">具备分红资格的人数</th>
	            </tr>
	            </thead>
	        </table>
	    </div>
    </div>
</div>
<script type="text/javascript" src="js/poolInfo.js"></script>