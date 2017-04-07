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
<div class="easyui-layout" style="height:300px;width:90%;margin:0 auto">
	<div region="center" class="easyui-layout" style="border:0">
	    <div region="center" style="height:100%;width:100%;border:0;padding:0px" id="search">
	        <fieldset>
		    	<legend>员工信息</legend>        
	        	<div id="conditionDiv">
	        		<table style="width:100%"> 
	        			<tr style="width:100%"> 
		        			<td>       	
		            		<label>员工姓名：</label>
		            		<input type="hidden" name="id" value="<s:property value="infoUserExt.id" />" db_field="infoUserExt.id">
		            		</td>
		            		<td>
		            			<label><s:property value="infoUserExt.name" /></label>
		            		</td>
		            		<td>       	
		            		 	<label>部门：</label>
		            		</td>
		            		<td>
		            		    <label><s:property value="infoUserExt.department_name" /></label>
		            		</td> 
		            				            		
	            		</tr>
	            		<tr style="width:100%"> 
	            		    <td>       	
		            		    <label>身份证号：</label>
		            		</td>
		            		<td>
		            			<label><s:property value="infoUserExt.citizen_id" /></label>
		            		</td>
	            		    <td>       	
		            		 <label>性别：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="sex" value="<s:property value="infoUserExt.sex" />" db_field="infoUserExt.sex"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=sex'" />
		            		</td>
		            	</tr>
		            	<tr style="width:100%">
		        			<td>
		        			<label>政治面貌：</label>
		            		</td>
		            		<td>
		            			<input type="text" class="easyui-combobox"  value="<s:property value="infoUserExt.political_status" />" name="political_status" db_field="infoUserExt.political_status" data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=zzmm'" />
		            		</td>
		            		<td>       	
		            		 <label>参加工作日期：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-datebox" name="work_date" value="<s:date name="infoUserExt.work_date" format="yyyy-MM-dd"/>" db_field="infoUserExt.work_date"  data-options="<s:property value="controlDisabled" />" />
		            		</td>	            		
	            		</tr>
	            		<tr style="width:100%"> 
	            		    <td>       	
		            		<label>进入时间：</label>
		            		</td>
		            		<td>
		            			<input type="text" class="easyui-datebox" value="<s:date name="infoUserExt.join_date" format="yyyy-MM-dd"/>" name="join_date" db_field="infoUserExt.join_date"  data-options="<s:property value="controlDisabled" />"/>
		            		</td>
		            		<td>       	
		            		 <label>学历：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="education" value="<s:property value="infoUserExt.education" />" db_field="infoUserExt.education"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=xl'"/>
		            		</td>
		            	</tr>
		            	<tr style="width:100%">
		            		
		        			<td>       	
		            		 <label>学位：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="degree" value="<s:property value="infoUserExt.degree" />" db_field="infoUserExt.degree"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=xw'" />
		            		</td>
		            		<td>       	
		            		 <label>职务名称：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="job_title" value="<s:property value="infoUserExt.job_title" />" db_field="infoUserExt.job_title"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=zw'" />
		            		</td>	            		
		        					            		
	            		</tr>
	            		<tr style="width:100%">
	            		     <td> 	
		            		<label>任职时间：</label>
		            		</td>
		            		<td>
		            			<input type="text" class="easyui-datebox"  value="<s:date name="infoUserExt.serving_time" format="yyyy-MM-dd"/>" name="serving_time" db_field="infoUserExt.serving_time" data-options="<s:property value="controlDisabled" />" />
		            		</td>
		            		<td>       	
		            		 <label>现级别提拔时间：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-datebox" name="nowjob_up_time" value="<s:date name="infoUserExt.nowjob_up_time" format="yyyy-MM-dd"/>" db_field="infoUserExt.nowjob_up_time"  data-options="<s:property value="controlDisabled" />" />
		            		</td>
	            		</tr>
	            		<tr style="width:100%"> 
		        			<td>       	
		            		 <label>专业技术资格名称：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="qualify_name" value="<s:property value="infoUserExt.qualify_name" />" db_field="infoUserExt.qualify_name"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=zyjszg'" />
		            		</td>
		            		<td>       	
		            		 <label>专业技术级别：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="qualify_level" value="<s:property value="infoUserExt.qualify_level" />" db_field="infoUserExt.qualify_level"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=zyjsjb'" />
		            		</td>
		            	</tr>
		            	<tr style="width:100%">
		            			            		
		        			<td>       	
		            		<label>聘任专业技术岗位等级：</label>
		            		</td>
		            		<td>
		            			<input type="text" class="easyui-combobox" name="appoint_level" value="<s:property value="infoUserExt.appoint_level" />" db_field="infoUserExt.appoint_level"  data-options="<s:property value="controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=prjsgwdj'"/>
		            		</td>
		            		<td colspan="2">
		            			
		            		</td>	            		
	            		</tr>
					</table>
	            </div>       
	        </fieldset>
	    </div>	    
	</div>
	<s:if test='#parameters.operType[0] == "1"'>     
   		<%--按钮区域 --%>
	    <div region="south" class="easyui-layout" style="border:0">
			<table style="width:100%"> 
				<tr>
					<td colspan="2">
						<a href="javascript:void(0);" class="easyui-linkbutton" id="save_btn"  >保存</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" id="cancel_btn" >取消</a>
					</td>					
				</tr>
			</table>
		</div>
	</s:if>	
</div>

<script type="text/javascript" src="<%=baseUri %>/staff/js/staffDetail.js"></script>

</body>
</html>