<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="org.jasig.cas.client.validation.Assertion" %>
<%@ page import="org.jasig.cas.client.util.AssertionHolder" %>
<%@ page import="java.util.*" %>
<%
	String baseUri = request.getContextPath();
	Assertion assertion = (Assertion) session.getAttribute("_const_cas_assertion_");
	AttributePrincipal principal=null;
	AttributePrincipal principal2 = (AttributePrincipal) request.getUserPrincipal();
	if(assertion!=null){
		principal =assertion.getPrincipal();
	}
/**
   if(principal!=null){


String loginName = principal.getName();

out.println("loginName   "+loginName);

Map<String, Object> attributes = principal.getAttributes();

  out.println("<br>");


 

  if(attributes != null) {

  out.println(attributes.get("userid"));

  out.println("<br>");

  out.println("password"+attributes.get("password"));

  out.println("<br>");

  out.println("EMAIL"+attributes.get("EMAIL"));

  out.println("<br>");

               out.println("FINDPASSWORDACTIVE"+attributes.get("FINDPASSWORDACTIVE"));


 

    out.println("<br>");

     }
   } **/
%>
<jsp:include page="/public/infoShare/head.jsp"></jsp:include>
<jsp:include page="/public/infoShare/website-head.jsp"></jsp:include>
<div class="easyui-layout" style="height:100%;width:90%;margin:0 auto">
<div region="center" class="easyui-layout" style="border:0">
    <div region="north" style="height:70px;;border:0;padding:0px" id="search">
        <fieldset>
	    <legend>员工信息管理</legend>        
        	<div id="conditionDiv">         	
            <label>员工姓名：</label><input type="text" class="easyui-textbox" name="name" db_field="infoUserExt.name" is_like="0"  />
            <label style="margin-left:10px">部门:</label><input class="easyui-combobox" name="department" db_field="infoUserExt.department"  data-options="valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=1'" />                      
            <label style="margin-left:10px"></label><a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
            </div>       
        </fieldset>
    </div>

    <div region="center"  style="border:0;width:98%;padding:0px">
        <div class="easyui-layout" style="height:100%;width:100%;margin:0 auto" >
        	<div region="center" title="员工信息" style="border:0;width:60%;padding:0px">
	        	<table id="staffList"  rownumbers="true" pagination="true"
	               fitColumns="true" nowrap="false" showFooter="true" singleSelect="false" style="height:100%" checkbox="true" autoRowHeight=true fit=true>            
	        	</table>
        	</div>
        	<div region="east" title="维度展现" style="border:0;width:500;padding:0px" data-options="collapsed:true" >
	        	<div id="orgPieDiv" style="width: 450px;height:400px;"></div>
        	</div>
        </div>
    </div>
</div>


<!--导入-->
<div id="execel_info" style="display: none;" title="Excel导入">
    <div rgion="center" style="height: 140px;;padding:0px">        	
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
    <div rgion="bottom" style="height: 80px;;padding:0px"> 
       	<div id="importHints">       	    
     		<span id="importBatchId" class="red"></span><br/>     
     		<span id="importSucNum" class="red"></span><br/>
     		<span id="importErrNum" class="red"></span><br/>
     		<span id="importErrMsg" class="red"></span><br/>           		
     	</div>	             
    </div>
</div>
<div id="output"></div>
</div>
<div id="dialogWindow" data-options="border:'thin',collapsible:false,minimizable: false,shadow:false">
    <div class="easyui-layout" data-options="fit:true,border:false">
        <div data-options="region:'center',border:false" style="padding:0px;">
            <iframe src=""  data-options="border:false"  style="width:100%;height:100%" frameborder="0"></iframe>
        </div>       
    </div>
</div>
<script type="text/javascript" src="js/staffMan.js"></script>
<jsp:include page="/public/infoShare/website-foot.jsp"></jsp:include>
