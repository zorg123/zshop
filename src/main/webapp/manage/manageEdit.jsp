<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		    	<legend>管理办法/制度文件信息</legend>        
	        	<div id="conditionDiv">
	        		<table style="width:100%"> 
	        			<tr style="width:100%;height:35px"> 
		        			<td>       	
		            		<label>标题：</label>
		            		<input type="hidden" name="manage_id" value="<s:property value="infoManage.manage_id" />" db_field="infoManage.manage_id" >
		            		</td>
		            		<td colspan="3">
		            			<input type="text" class="easyui-textbox" value="<s:property value="infoManage.titile" />" name="titile" db_field="infoManage.titile"   style="width:90%" />
		            		</td>		
	            		</tr>
	            		<tr style="width:100%;height:35px"> 
	            		    <td>       	
		            		 <label>类型：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="manange_type" value="<s:property value="infoManage.manange_type" />" db_field="infoManage.manange_type"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=manage_type'" />
		            		</td>
		            		<td>       	
		            		 <label>状态：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-combobox" name="state" value="<s:property value="infoManage.state" />" db_field="infoManage.state"  data-options="<s:property value="#controlDisabled" />valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=3&dictType=state'" />
		            		</td>
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            	    <td>       	
		            		 <label>生效时间：</label>
		            		</td>
		            		<td>
		            			<input class="easyui-datebox" name="eff_date" value="<s:date name="infoManage.eff_date" format="yyyy-MM-dd"/>" db_field="infoManage.eff_date"  data-options="<s:property value="controlDisabled" />" />
		            		</td>
		            	    <td>       	
		            		<label>失效时间：</label>
		            		</td>
		            		<td colspan="3" >
		            			<input class="easyui-datebox" name="exp_date" value="<s:date name="infoManage.exp_date" format="yyyy-MM-dd"/>" db_field="infoManage.exp_date"  data-options="<s:property value="controlDisabled" />" style="width:90%"/>
		            		</td>		            		  		
	            		</tr>
		            	<tr style="width:100%;height:35px"> 
	            		   <td>       	
		            		<label>附件：</label>
		            		</td>
		            		<td colspan="3">
		            			<div id="fileDownload">
		            				<ul>
		            				    <s:iterator  value="infoManage.infoServFileList"  id="infoServFile" status="st">	
		            				    	<li fileId='<s:property value="#infoServFile.file_id" />'><a name='upFile'  target='_blank' href='/Attachement/download.do?fid=<s:property value="#infoServFile.file_id" />'><s:property value="#infoServFile.file_name" /></a><a style='padding-left:20px;' href='javascript:void(0);' onclick='operEdit.deleteFile(this)'>删除</a></li>
		            				    </s:iterator>
		            					
		            				</ul>
		            			</div>
		            			<form action="" id="fileForm" name="fileForm" method="POST" enctype="multipart/form-data">
		            				<input type="file" name="uploadFile" value="" id="uploadFile" style="display:none">
									<div class="input-group" style="float:left"> 
										<input id="photoCover" class="easyui-textbox" type="text" > 
										<span class="input-group-btn">
										    <a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="$('input[id=uploadFile]').click();" style="width:80px">选择文件</a>									        
									     </span>
									</div>
		            				<a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="javascript:operEdit.upload()" style="width:80px">上传</a>
		            			</form>
		            		</td>		            		
		            	</tr>
		            	<tr style="width:100%;height:35px">
		            			            		
		        			<td>       	
		            		<label>内容：</label>
		            		</td>
		            		<td colspan="3">
		            			<textarea name="content" style="height:300px;width:80%" id="myEditor"><s:property value="infoManage.content" /></textarea>
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
<script type="text/javascript" src="<%=baseUri %>/manage/js/manageEdit.js"></script>
<div id="output"></div>
</body>
</html>