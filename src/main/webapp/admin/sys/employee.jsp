<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<div region="center" class="easyui-layout">
	<div region="west" split="true" title="组织目录" style="width:200px;">
    	<ul id="organizationTree"  animate="true" dnd="true">
    	</ul>
	</div>
	<div region="center" style="padding:2px;" class="easyui-layout">
	    <div region="north" style="height:50px;" id="search">
	        <div region="center" style="margin-top: 10px;margin-left: 10px;">
	            <label>员工工号：</label><input type="text" name="search_code">
	            <label>员工名称：</label><input type="text" name="search_name">
	            <label>是否有效：</label>
	            <!-- 
	            <select class="easyui-combobox" name="search_state" style="width:80px;">
	                <option value="-1">--请选择--</option>
	                <option value="1">有效</option>
	                <option value="0">无效</option>               
	            </select>
	             -->
	            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	        </div>
	    </div>
	
	    <div region="center" title="员工列表" >
	        <table id="staffList"  rownumbers="true" pagination="true"
	               fitColumns="false" nowrap="false" showFooter="true" singleSelect="true" style="height:400px">
	            <thead>
	            <tr>
	                <th field="user_id" hidden>员工ID</th>
	                <th field="user_code" width="80">员工工号</th>
	                <th field="name" width="140">员工名称</th>
					<th field="org_id" hidden>部门id</th>
	                <th field="org_name" width="150">部门名称</th>
	                <th field="mail" width="80">邮箱</th>
	                <th field="phone" width="80">电话</th>	                
	                <%--                <th field="bureau_name" width="40">区域名称</th>--%>
	                <%--            <th field="site_name" width="40">受理点名称</th>--%>	               
	                <th field="state" width="60" formatter="Employee.formatState">是否有效</th>
	                <th field="bank_account" width="140">银行账户</th>
	                <th field="id_card" width="80">身份证号</th>
	                <th field="position_level" width="80">员工级别</th>
	            </tr>
	            </thead>
	        </table>
	    </div>
    </div>
</div>


<!--角色-->
<div id="show_role" rgion="center" style="display: none;" title="分配角色">
    <div region="north" style="height: 40px;">
        <div region="center" style="margin-top: 5px;margin-left: 10px;margin-bottom: 5px;">
            <label>角色名称：</label><input type="text" name="role_name">
            <label>角色描述：</label><input type="text" name="role_desc">
        	 <a style="margin-right:10px;" href="javascript:void(0);" class="easyui-linkbutton" id="search_role_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <div region="center" style="height:350px">
        <table id="roleList" rownumbers="true" pagination="true"
               fit="true" fitcolumns="false" nowrap="false" showFooter="true" singleSelect="false" checkbox="true"  loadFilter="Employee.loadFilter" style="height:100%">           
        </table>
    </div>
    <div region="center" style="margin-top: 5px;text-align:center;margin-bottom: 5px;" >
    	<a href="javascript:void(0);" id="role_save" class="easyui-linkbutton" iconCls="icon-save">保存</a>
    </div>
</div>

<!--修改 详情-->
<div id="user_info" style="display: none;" title="用户信息">
    <div rgion="center" style="margin-left: 20px;">
        <table width="80%" border="0" align="center" cellpadding="1">
            <tr>
                <td>员工工号:</td>
                <td><label>
                    <input name="user_code" type="text"  id="user_code"/>
                </label></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input name="name" type="text" id="name"/></td>
            </tr>
             <tr>
                <td>所属部门:</td>
                <td>                    
                    <input name="org_name" type="text" id="org_name" disabled/>
                    <input name="org_id" type="hidden" id="org_id" />
                </td>
            </tr>
            <tr>
                <td>银行账号:</td>
                <td>
                    <input name="bank_account" type="text" id="bank_account" />
                </td>
            </tr>
            <tr>
                <td>身份证号:</td>
                <td>
                    <input name="id_card" type="text" id="id_card" />
                </td>
            </tr>
           <tr>
                <td>员工级别:</td>
                <td>
                	<select  id="position_level" name="position_level" style="width:80px;">
                        <option value="">--请选择--</option>
                        <option value="1">1</option>
                        <option value="2">2</option>  
                        <option value="3">3</option>                     
                    </select>
                 </td>
            </tr>
            <tr>
                <td>登陆密码:</td>
                <td>                    
                    <input name="password" type="password" id="password" />                   
                </td>
            </tr>
            <tr>
                <td>是否有效:</td>
                <td>
                    <select  id="state" name="state" style="width:80px;">
                        <option value="1">有效</option>
                        <option value="0">无效</option>                       
                    </select>
                </td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="phone" type="text" id="phone"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="sex" value="1"/>男
                    <input type="radio" name="sex" value="2"/>女
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>                    
                    <input name="mail" type="text" id="mail"/>                    
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div align="center">
                        <a href="javascript:void(0);" id="up_btn" class="easyui-linkbutton" iconCls="icon-save">保存</a>
                        <a href="javascript:void(0);" id="up_cel_btn" class="easyui-linkbutton"
                           iconCls="icon-cancel">取消</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>

<!--新增 详情-->
<div id="save_user_info" style="display: none;" title="用户信息">
    <div rgion="center" style="margin-left: 20px;">
        <table width="80%" border="0" align="center" cellpadding="1">
            <tr>
                <td>员工工号:</td>
                <td><label>
                    <input name="user_code" type="text" id="user_code"/>
                </label></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><label>
                    <input name="password" type="password" id="password"/>
                </label></td>
            </tr>
            <tr>
                <td>名称:</td>
                <td><input name="name" type="text" id="name"/></td>
            </tr>
            <tr>
                <td>银行账号:</td>
                <td>
                    <input name="bank_account" type="text" id="bank_account" />
                </td>
            </tr>
            <tr>
                <td>所属部门:</td>
                <td>                    
                    <input name="org_name" type="text" id="org_name" disabled/>
                    <input name="org_id" type="hidden" id="org_id" />
                </td>
            </tr>
            <tr>
                <td>身份证号:</td>
                <td>
                    <input name="id_card" type="text" id="id_card" />
                </td>
            </tr>
           <tr>
                <td>员工级别:</td>
                <td>
                	<select id="position_level" name="position_level" style="width:80px;">
                        <option value="">--请选择--</option>
                        <option value="1">1</option>
                        <option value="2">2</option>  
                        <option value="3">3</option>                     
                    </select>
                 </td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="phone" type="text" id="phone"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><label>
                    <input type="radio" name="sex" value="1"/>男
                    <input type="radio" name="sex" value="2"/>女
                </label></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><label>
                    <input name="mail" type="text" id="mail"/>
                </label></td>
            </tr>
            <tr>
                <td>是否有效:</td>
                <td>
                    <select class="easyui-combobox" id="state" name="state" style="width:80px;">
                        <option value="1">有效</option>
                        <option value="0">无效</option>                       
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div align="center">
                        <a href="javascript:void(0);" id="save_btn" class="easyui-linkbutton" iconCls="icon-save">保存</a>
                        <a href="javascript:void(0);" id="save_cel_btn" class="easyui-linkbutton"
                           iconCls="icon-cancel">取消</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>

<!--用户的角色-->
<div id="user_role_info" rgion="center" style="display: none;" title="用户角色">
    <div region="center"  style="height: 350px;">
        <table id="employee_role_list" rownumbers="true" pagination="true"
               fit="true" fitColumns="false" nowrap="false" showFooter="true" singleSelect="false" checkbox="true" loadFilter="Employee.loadFilter" style="height:100%">
        </table>
    </div>
    <div region="bottom"  style="height: 40px;text-align:center" >
        <a href="javascript:void(0);" style="text-align: center;" id="del_user_btn" class="easyui-linkbutton" iconCls="icon-save">删除</a>
    </div>
</div>
<!--导入-->
<div id="execel_info" style="display: none;" title="员工信息导入">
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
       	<div id="importHints" style="padding-left:10px;line-height:17px">
     		<span id="importSucNum" class="red"></span><br/>
     		<span id="importErrNum" class="red"></span><br/>
     		<span id="importErrMsg" class="red"></span><br/>
     		<span id="importBatchId" class="red"></span>                		
     	</div>	             
    </div>
</div>
<div id="output"></div>

<jsp:include page="/admin/main/foot.jsp"></jsp:include>
<script type="text/javascript" src="js/employee.js"></script>
