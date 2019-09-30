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
	            <label>会员级别：</label>
	            <select class="easyui-combobox" name="search_userLevel" style="width:80px;">
	                <option value="">--请选择--</option>
	                <option value="1">VIP会员</option>
	                <option value="3">经理</option>
	                <option value="4">总监</option>
	                <option value="5">总裁</option>
	                <option value="6">董事</option>              
	            </select>
	            <label>分红资格：</label>
	            <select class="easyui-combobox" name="search_shareoutQua" style="width:80px;">
	                <option value="">--请选择--</option>
	                <option value="1">具备</option>
	                <option value="-1">不具备</option>               
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
	                <th field="name" width="140">会员名称</th>
	                <th field="phone" width="100">电话</th>
	                <th field="state" width="100" formatter="Employee.formatState">是否激活</th>
	                <th field="act_time" width="140">激活时间</th>
	                <th field="user_level" width="100">会员等级</th>
	                <th field="shareout_qua" width="100" formatter="Employee.shareoutQua">分红资格</th>
	                <th field="pre_goodsSum" width="100">上月销量</th>
	                <th field="pre_smallMarket" width="100">上月小市场</th>
	                <th field="current_goodsSum" width="100">当月新增</th>
	                <th field="current_smallMarket" width="100">当月小市场</th>
	                <th field="allorder_num" width="100">市场总销量</th>
	            </tr>
	            </thead>
	        </table>
	    </div>
    </div>
</div>
<script type="text/javascript" src="js/reportUserInfo.js"></script>
