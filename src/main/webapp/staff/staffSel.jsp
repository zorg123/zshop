<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="org.jasig.cas.client.validation.Assertion" %>
<%@ page import="org.jasig.cas.client.util.AssertionHolder" %>;
<%@ page import="java.util.*" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/public/infoShare/head.jsp"></jsp:include>
<div class="easyui-layout" style="height:400px;width:90%;margin:0 auto">
	<div region="center" class="easyui-layout" style="border:0">
	    <div region="north" style="height:70px;;border:0;padding:0px" id="search">
	        <fieldset>
		    <legend>查询条件</legend>        
	        	<div id="conditionDiv">         	
	            <label>员工姓名：</label><input type="text" class="easyui-textbox" name="name" db_field="infoUserExt.name" is_like="0"  />
	            <label style="margin-left:10px">部门:</label><input class="easyui-combobox" name="department" db_field="infoUserExt.department"  data-options="valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=1'" />                      
	            <label style="margin-left:10px"></label><a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	            </div>       
	        </fieldset>
	    </div>
	
	    <div region="center"  style="border:0;width:98%;padding:0px">
	        <div class="easyui-layout" style="height:100%;width:100%;margin:0 auto" >
	        	<div region="center" style="border:0;width:60%;padding:0px">
		        	<table id="staffList"  rownumbers="true" pagination="true"
		               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" style="width:auto;height:100%" checkbox="true" autoRowHeight=true fit=true>            
		        	</table>
	        	</div>
	        </div>
	    </div>
	</div>
</div>
<script type="text/javascript" src="js/staffSel.js"></script>
</body>
</html>