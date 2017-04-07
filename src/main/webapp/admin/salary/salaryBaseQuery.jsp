<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<div region="center" class="easyui-layout">
    <div region="north" style="height:50px;" id="search">
        <div region="center" style="margin-top: 10px;margin-left: 5px;">
        	<div> 
        	<!-- 
            <label>工资类型：</label>
           
            <select class="easyui-combobox" name="s_salary_type" style="width:80px;">
                <option value="-1">--请选择--</option>
                <option value="1">月工资</option>
                <option value="2">年终奖</option>               
            </select>
             -->
            <label>发放开始时间：</label><input type="text" name="s_salary_schedule_start" class="easyui-datebox" />
            <label>发放结束时间：</label><input type="text" name="s_salary_schedule_end" class="easyui-datebox" />
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
            </div>
        </div>
    </div>

    <div region="center" title="员工工资列表" style="padding:2px;">
        <table id="salaryList"  rownumbers="true" pagination="true"
               fitColumns="false" nowrap="false" showFooter="true" singleSelect="false" style="height:450px" checkbox="true" autoRowHeight=false fit="true">            
        </table>
    </div>
</div>

<jsp:include page="/admin/main/foot.jsp"></jsp:include>
<script type="text/javascript" src="js/salaryBaseQuery.js"></script>
