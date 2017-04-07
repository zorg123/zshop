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

<script language="javascript" >
	var operType="<s:property value="operType" />";
</script>
<s:if test='#parameters.operType[0] != "1" && #parameters.operType[0] != "2"'>     
   <s:set name="controlDisabled" value="'disabled:true,'"/>
</s:if>
<div class="easyui-layout" style="height:350px;width:90%;margin:0 auto">
	<div region="center" class="easyui-layout" style="border:0">
	    <div region="center" style="height:100%;width:100%;border:0;padding:0px" id="search">
	        <fieldset>
		    	<legend>仪器设备信息</legend>        
	        	<div id="conditionDiv">
	        		<table style="width:100%"> 
	        			<tr style="width:100%;height:35px"> 
		        			<td>       	
		            		<label>资产编号：</label>
		            		<input type="hidden" name="asset_id" value="<s:property value="infoAsset.asset_id" />" db_field="infoAsset.asset_id">
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.asset_code" />" name="asset_code" db_field="infoAsset.asset_code"   /></label>
		            		</td>
		            		<td>       	
		            		<label>资产名称：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.asset_name" />" name="asset_name" db_field="infoAsset.asset_name" /></label>
		            		</td>	            		
	            		</tr>
	            		<tr style="width:100%;height:35px"> 
	            		    <td>       	
		            		 <label>资产分类：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="asset_class" value="<s:property value="infoAsset.asset_class" />" db_field="infoAsset.asset_class"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=assetClass'" />
		            		</td>
		            		<td>       	
		            		 <label>制单时间：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-datebox" name="make_date" value="<s:date name="infoAsset.make_date" format="yyyy-MM-dd"/>" db_field="infoAsset.make_date"  data-options="<s:property value="controlDisabled" />" />
		            		</td>
	            		    
	            		    
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            	     <td>       	
		            		 <label>取得时间：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-datebox" name="get_date" value="<s:date name="infoAsset.get_date" format="yyyy-MM-dd"/>" db_field="infoAsset.get_date"  data-options="<s:property value="controlDisabled" />" />
		            		</td>
		            		<td>       	
		            		 	<label>使用部门：</label>
		            		</td>
		            		<td>
		            		    <input class="easyui-combobox" name="use_department" value="<s:property value="infoAsset.use_department" />" db_field="infoAsset.use_department"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=1'" />
		            		</td>
		            		       		
	            		</tr>
	            		<tr style="width:100%;height:35px"> 
	            		   <td>       	
		            		<label>数量：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.asset_amount" />" name="asset_amount" db_field="infoAsset.asset_amount"   /></label>
		            		</td>
		            		<td>
		            		<label>面积：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.asset_area" />" name="asset_area" db_field="infoAsset.asset_area"   /></label>
		            		</td>
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            		
		        			<td>
		            		<label>价值：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.asset_cost" />" name="asset_cost" db_field="infoAsset.asset_cost"   /></label>
		            		</td>
		            		 <td>       	
		            		<label>规格型号：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.asset_type" />" name="asset_type" db_field="infoAsset.asset_type"   /></label>
		            		</td>   	            		
		        					            		
	            		</tr>
	            		<tr style="width:100%;height:35px">
	            		    <td>
		            		<label>存放地点：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.place" />" name="place" db_field="infoAsset.place"   /></label>
		            		</td>
		            		<td>
		            		<label>使用人：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoAsset.use_staff" />" name="use_staff" db_field="infoAsset.use_staff"   /></label>
		            		</td>
	            		</tr>
	            		<tr style="width:100%;height:35px"> 
	            			<td>       	
		            		 	<label>取得方式：</label>
		            		</td>
		            		<td>
		            		    <input class="easyui-combobox" name="sex" value="<s:property value="infoAsset.get_method" />" db_field="infoAsset.get_method"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=assetGetMethod'" />
		            		</td>
		        			
		            		<td>       	
		            		 <label>使用状况：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="use_state" value="<s:property value="infoAsset.use_state" />" db_field="infoAsset.use_state"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=assetUseState'" />
		            		</td>
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            			            		
		        			<td>       	
		            		<label>备注：</label>
		            		</td>
		            		<td colspan="3">
		            			<input type="text" class="easyui-textbox" name="comments" value="<s:property value="infoAsset.comments" />" db_field="infoAsset.comments" />
		            		</td>		            			            		
	            		</tr>
					</table>
	            </div>       
	        </fieldset>
	    </div>	    
	</div>   
   		<%--按钮区域 
	    <div region="south" class="easyui-layout" style="border:0">
			<table style="width:100%"> 
				<tr>
					<td colspan="2">
						<a href="javascript:void(0);" class="easyui-linkbutton" id="save_btn"  >保存</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" id="cancel_btn" >取消</a>
					</td>					
				</tr>
			</table>
		</div>--%>
	
</div>

<script type="text/javascript" src="<%=baseUri %>/asset/js/assetEdit.js"></script>

</body>
</html>