<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="org.jasig.cas.client.validation.Assertion" %>
<%@ page import="org.jasig.cas.client.util.AssertionHolder" %>
<%@ page import="java.util.*" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/public/infoShare/head.jsp"></jsp:include>
<jsp:include page="/public/infoShare/website-head.jsp"></jsp:include>
<div class="easyui-layout" style="height:100%;width:90%;margin:0 auto">
<div region="center" class="easyui-layout" style="border:0">
    <div region="north" style="height:70px;;border:0;padding:0px" id="search">
        <fieldset>
	    <legend>制度文件和管理办法</legend>        
        	<div id="conditionDiv">        	
            <label style="margin-left:10px">名称：</label><input type="text" class="easyui-textbox" name="titile" db_field="infoManage.titile" is_like="0"  />
            <label style="margin-left:10px">类型:</label><input class="easyui-combobox" name="manange_type" db_field="infoManage.manange_type"  data-options="valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=manage_type'" />
            <label style="margin-left:10px">录入开始时间:</label><input class="easyui-datebox" name="create_date_start" db_field="infoManage.create_date_start"  />                      
            <label style="margin-left:10px">录入结束时间:</label><input class="easyui-datebox" name="create_date_end" db_field="infoManage.create_date_end"  />  
            <label style="margin-left:10px"></label><a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
            </div>       
        </fieldset>
    </div>

    <div region="center"  style="border:0;width:98%;padding:0px">
        <div class="easyui-layout" style="height:100%;width:100%;margin:0 auto" >
        	<div region="center" title="信息列表" style="border:0;width:60%;padding:0px">
	        	<table id="dataList"  rownumbers="true" pagination="true"
	               fitColumns="false" nowrap="false" showFooter="true" singleSelect="false" style="height:100%" checkbox="true" autoRowHeight=true fit=true>            
	        	</table>
        	</div>
        	<div region="east" title="维度展现" style="border:0;width:700;padding:0px" data-options="collapsed:true" >
	        	<div class="easyui-layout" style="height:100%;width:100%;margin:0 auto" >
	        		<div region="center"  title="列表展现" style="border:0;width:35%;padding:0px" >
	        			<table id="orgDataDiv"  fitColumns="false" nowrap="false" showFooter="true" singleSelect="false" style="width:auto;height:100%" checkbox="true" autoRowHeight=true fit=true>            
	        			</table>	        		        			
	        		</div>
	        		<div region="east" style="border:0;width:65%;padding:0px">
	        			<div id="orgPieDiv" style="width: 450px;height:400px;"></div>
	        		</div>
	        	</div>	        	
        	</div>
        </div>
    </div>
</div>
<div id="audit_info" style="display: none;" title="审核">
    <div rgion="center" style="height: 120px;;padding:0px">        	
    	<form action="" name="excelForm" method="POST" enctype="multipart/form-data">
	        <table id="execel_info_tb" align="center" style="height:120px">	            
	            <tr>
	                <td>审核结果:</td>
	                <td>
	                	<input type="text" class="easyui-combobox" id="audit_result" name="audit_result" db_field="infoTrainAudit.audit_result" data-options="valueField:'id',textField:'text'"  />
            		</td>
            	</tr>
            	<tr>
            		<td>审核意见:</td>
	                <td>
	                	<input class="easyui-textbox" name="audit_comments" db_field="infoTrainAudit.audit_comments" data-options="multiline:true" />
            		</td>
	            </tr>
	                        
	            <tr>
	            	<td colspan="2">
	            		<a href="javascript:void(0);" style="text-align: center;" id="ok_btn" class="easyui-linkbutton" iconCls="icon-save">确认</a>
	            		<a href="javascript:void(0);" style="text-align: center;" id="cancel_btn" class="easyui-linkbutton" iconCls="icon-save">关闭</a>
	            	</td>
	            </tr>	           
	        </table>
        </from>
    </div> 
</div>
<div id="output"></div>
</div>
<div id="dialogWindow" data-options="border:'thin',collapsible:false,minimizable: false,shadow:false" >
    <div class="easyui-layout" data-options="fit:true,border:false" >
        <div data-options="region:'center',border:false" style="padding:0px;overflow:hidden">
            <iframe src=""  data-options="border:false"  style="width:100%;height:100%;" frameborder="0"></iframe>
        </div> 
        <div data-options="region:'south',border:false" style="text-align:right;padding:10px 10px;border-top:0px solid #ddd;height:50px">
            <a class="easyui-linkbutton color1" href="javascript:void(0)" onclick="javascript:operEdit.save();" style="width:80px">保存</a>
            <a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="javascript:operEdit.cancel()" style="width:80px">取消</a>            
        </div>      
    </div>
</div>

<script type="text/javascript" src="js/manage.js"></script>
<jsp:include page="/public/infoShare/website-foot.jsp"></jsp:include>
