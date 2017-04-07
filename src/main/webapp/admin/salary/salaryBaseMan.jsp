<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<div region="center" class="easyui-layout" style="border:0">
    <div region="north" style="height:50px;;border:0" id="search">
        <div region="center" style="margin-top: 10px;margin-left: 5px;border:0;border:0">
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
            <label>员工名称：</label><input type="text" name="s_user_name" style="width:100px;">        
            
            <label>批次号：</label><input type="text" name="s_batch_id">           
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" id="delete_by_batch_btn" >按批次删除</a>
            </div>
        </div>
    </div>

    <div region="center" title="员工工资列表" style="padding:2px;border:0;width:98%">
        <table id="salaryList"  rownumbers="true" pagination="true"
               fitColumns="false" nowrap="false" showFooter="true" singleSelect="false" style="height:450px" checkbox="true" autoRowHeight=false fit="true">            
        </table>
    </div>
</div>


<!--导入-->
<div id="execel_info" style="display: none;" title="Excel导入">
    <div rgion="center" style="height: 140px;">        	
    	<form action="" name="excelForm" method="POST" enctype="multipart/form-data">
	        <table id="execel_info_tb" style="height:120px">	            
	            <tr>
	                <td colspan="2">请选择导入文件：</td>
	            </tr>
	            <s:file name="upload" label="File"/>	           
	            <tr>
	            	<td colspan="2">
	            		<a href="javascript:void(0);" style="text-align: center;" id="import_btn" class="easyui-linkbutton" iconCls="icon-save">导入</a>
	            		<a href="javascript:void(0);" style="text-align: center;" id="cancel_import_btn" class="easyui-linkbutton" iconCls="icon-save">关闭</a>
	            	</td>
	            </tr>	           
	        </table>
        </from>
    </div> 
    <div rgion="bottom" style="height: 80px;"> 
       	<div id="importHints">       	    
     		<span id="importBatchId" class="red"></span><br/>     
     		<span id="importSucNum" class="red"></span><br/>
     		<span id="importErrNum" class="red"></span><br/>
     		<span id="importErrMsg" class="red"></span><br/>           		
     	</div>	             
    </div>
</div>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>
<script type="text/javascript" src="js/salaryBaseMan.js"></script>
