<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<s:set var="busTemplateItemList" value="result.busTemplateItemList" />
<jsp:include page="/public/infoShare/head.jsp"></jsp:include>
<jsp:include page="/public/infoShare/website-head.jsp"></jsp:include>
<div class="easyui-layout" style="height:490px;width:90%;margin:0 auto">
<script language="javascript" type="text/javascript" >
	var busId="<s:property value="busId" />";
	var q="<s:property value="q" />";
</script>
<div region="center" class="easyui-layout" style="border:0px">
    <div region="north" style="height:80px;border:0px" id="search">
        <div region="center" id="searchDiv" style="margin-top: 10px;margin-left: 5px;border:0px">
            <fieldset>
		    	<legend>个税查询</legend> 
	        	<div>         	
		            <label>查询开始时间：</label><input type="text" name="col5_start" db_field="busData.col5_start" is_like="0" class="easyui-datebox" style="width:100px;" />
		            <label>查询结束时间：</label><input type="text" name="c0l5_end" db_field="busData.col5_end" is_like="0" class="easyui-datebox" style="width:100px;" />
		            <s:if test="%{q == 1}">
		               <label>证件号码：</label><input type="text" name="s_user_code" db_field="busData.user_code" need_encode="1" is_like="1" style="width:100px;">
		               <label>员工名称：</label><input type="text" name="s_user_name" db_field="busData.col1" need_encode="1" is_like="1" style="width:100px;">	            
		            </s:if>
		            <s:else>
		            	<a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">查询</a>
		            </s:else>
		           <input type="hidden" db_field="busData.bus_id" is_like="0" value="<s:property value="busId" />"> 
		        
			        <s:if test="%{q == 1}">
		            	
		                 
			            	<label>批次号：</label><input type="text" name="s_batch_id" db_field="busData.batch_id" is_like="0" style="width:150px;"> 
			            	<a href="javascript:void(0);" class="easyui-linkbutton" id="delete_by_batch_btn" >按批次删除</a>
			            
			            	<a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">查询</a>
		            	
		            </s:if>
	            </div>
            </fieldset>
        </div>
     </div>

    <div region="center" title="" style="padding:2px;border:0px"> 
        <table id="salaryList"  rownumbers="true" pagination="true"
               fitColumns="false" nowrap="true" showFooter="true" singleSelect="false" style="width:100%" checkbox="true" autoRowHeight="false" fit="true">
            <thead>
            <tr> 
            	<th field="ck" checkbox="true"></th>
                <s:iterator  value="busTemplateItemList"  id="busTemplateItem" status="st">             	            	
            	  <th field="<s:property value="#busTemplateItem.data_col" />" width="<s:property value="#busTemplateItem.display_width" />"><s:property value="#busTemplateItem.item_name" /></th>
        	    </s:iterator>
            </tr>
            </thead>
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
       		<span id="importParseFailNum" class="red"></span><br/>
     		<span id="importSucNum" class="red"></span><br/>
     		<span id="importErrNum" class="red"></span><br/>
     		<span id="importErrMsg" class="red"></span><br/>
     		<span id="importBatchId" class="red"></span>                		
     	</div>	             
    </div>
</div>
</div>
<div id="output"></div>
<script type="text/javascript" src="<%=baseUri %>/bus/js/busMan.js"></script>
<jsp:include page="/public/infoShare/website-foot.jsp"></jsp:include>
