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
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/lang/zh-cn/zh-cn.js"></script>

<script language="javascript" >
	var operType="<s:property value="operType" />";
</script>
<s:if test='#parameters.operType[0] != "1" && #parameters.operType[0] != "2"'>     
   <s:set name="controlDisabled" value="'disabled:true,'"/>
</s:if>
<div class="easyui-layout" style="height:480px;width:90%;margin:0 auto">
	<div region="center" class="easyui-layout" style="border:0">
	    <div region="center" style="height:100%;width:100%;border:0;padding:0px" id="search">
	        <fieldset>
		    	<legend>培训信息</legend>        
	        	<div id="conditionDiv">
	        		<table style="width:100%"> 
	        			<tr style="width:100%;height:35px"> 
		        			<td>       	
		            		<label>培训标题：</label>
		            		<input type="hidden" name="train_id" value="<s:property value="infoTrain.train_id" />" db_field="infoTrain.train_id" >
		            		</td>
		            		<td colspan="3">
		            			<input type="text" class="easyui-textbox" value="<s:property value="infoTrain.train_title" />" name="train_title" db_field="infoTrain.train_title"   style="width:90%" />
		            		</td>		
	            		</tr>
	            		<tr style="width:100%;height:35px"> 
	            		    <td>       	
		            		 <label>培训类型：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="train_type" value="<s:property value="infoTrain.train_type" />" db_field="infoTrain.train_type"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=TrainType'" />
		            		</td>
		            		<td>       	
		            		 <label>培训时间：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-datebox" name="train_start" value="<s:date name="infoTrain.train_start" format="yyyy-MM-dd"/>" db_field="infoTrain.train_start"  data-options="<s:property value="controlDisabled" />" />
		            		</td>
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            	     <td>       	
		            		 <label>培训人员：</label>
		            		</td>
		            		<td colspan="3" >
		            			<input class="easyui-textbox" name="train_peoples" value="<s:property value="infoTrain.train_peoples" />" db_field="infoTrain.train_peoples"  data-options="<s:property value="controlDisabled" />" style="width:90%"/>
		            		</td>		            		  		
	            		</tr>
	            		<tr style="width:100%;height:35px"> 
	            		   <td>       	
		            		<label>培训部门：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-combobox" value="<s:property value="infoTrain.department" />" name="department" db_field="infoTrain.department"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=1'" /></label>
		            		</td>
		            		<td>
		            		<label>参与人数：</label>
		            		</td>
		            		<td>
		            			<label><input type="text" class="easyui-textbox" value="<s:property value="infoTrain.people_amount" />" name="people_amount" db_field="infoTrain.people_amount"   /></label>
		            		</td>
		            	</tr>
		            	<tr style="width:100%;height:35px"> 
	            		   <td>       	
		            		<label>审核人：</label>
		            		</td>
		            		<td colspan="3">
		            			<input type="hidden"  value="<s:property value="infoTrain.audit_staff" />" id="audit_staff" name="audit_staff" db_field="infoTrain.audit_staff"  data-options="disabled:true" />
		            			<input type="text" class="easyui-textbox" value="<s:property value="infoTrain.audit_staff_name" />" id="audit_staff_name" name="audit_staff_name" db_field="infoTrain.audit_staff_name"  data-options="disabled:true" /><a href="javascript:void(0);" style="text-align: center;" id="staff_btn" class="easyui-linkbutton" iconCls="icon-save">选择</a>
		            		</td>		            		
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            			            		
		        			<td>       	
		            		<label>培训内容：</label>
		            		</td>
		            		<td colspan="3">
		            			<textarea name="content" style="height:300px;width:80%" id="myEditor"><s:property value="infoTrain.train_content" /></textarea>
		            		</td>		            			            		
	            		</tr>
					</table>
	            </div>       
	        </fieldset>
	    </div>	    
	</div> 
</div>
<div id="dialogWindow1" data-options="border:'thin',collapsible:false,minimizable: false,shadow:false" >
    <div class="easyui-layout" data-options="fit:true,border:false" >
        <div data-options="region:'center',border:false" style="padding:0px;">
            <iframe src=""  data-options="border:false"  style="width:100%;height:100%" frameborder="0"></iframe>
        </div> 
        <div data-options="region:'south',border:false" style="text-align:right;padding:10px 10px;border-top:0px solid #ddd;height:50px">
            <a class="easyui-linkbutton color1" href="javascript:void(0)" onclick="javascript:operEdit1.ok();" style="width:80px">确认</a>
            <a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="javascript:operEdit1.cancel()" style="width:80px">取消</a>            
        </div>      
    </div>
</div>
<script type="text/javascript" src="<%=baseUri %>/train/js/trainEdit.js"></script>

</body>
</html>