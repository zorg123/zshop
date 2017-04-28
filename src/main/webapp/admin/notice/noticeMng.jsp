<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
    .top_5{
       padding-top: 5px;
    }
    .top_3{
        padding-top: 3px;
    }
</style>

<div region="center" class="easyui-layout">
    <div region="north" style="height:50px;" id="search" >
        <div region="center"style="margin-top: 5px;margin-left: 5px;" >
            <label>公告标题：</label><input type="text" name="search_name">            
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>

    <div region="center" title="公告列表" style="padding:2px;">
        <table id="noticeList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" fit="true">
            <thead>
            <tr>
                <th field="notice_id" width="40" hidden>公告ID</th>
                <th field="content_id" width="40" hidden>内容id</th>
                <th field="title" width="40">标题</th>  
                <th field="create_date" width="40">创建时间</th>
                <th field="eff_date" width="40">生效时间</th>              
                <th field="exp_date" width="40">失效时间</th>
                <th field="state" width="40" formatter="CommonUtils.formatState">状态</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_save" iconCls="icon-save" title="添加公告" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr>
    		<td>标题:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="title" style="width:340px"/></td>
    	</tr>
    	<tr>
    		<td>生效时间:</td>
    		<td> <input class="easyui-datebox" type="text" id="eff_date" name="eff_date" required="true" style="width:170px" editable="false" formatter="timeFormatter" parser="timeParser"/></td>    	
    		<td>失效时间:</td>
    		<td><input class="easyui-datebox"  type="text" id="exp_date" name="exp_date" required="true" style="width:170px" editable="false" formatter="timeFormatter" parser="timeParser" /></td>
    	</tr>
    	<tr>
    		<td>状态:</td>
    		<td colspan="3"> 
    			<select  name="state">
		        	<option value="1">有效</option>
		        	<option value="0">无效</option>
        		</select>
        	</td>
    	</tr>
    	<tr>
    		<td>内容:</td>
    		<td colspan="3">
    			<textarea name="content" style="height:400px;width:450px" id="myEditor"></textarea>
    			<!--  <a href="javascript:void(0);" id="editorBtn" iconCls="icon-save" class="easyui-linkbutton">编辑</a> -->
    		</td>
    	</tr>
    	<tr>
    		<td colspan="4" style="text-align:center"> 
    			<a href="javascript:void(0);" id="save" iconCls="icon-save" class="easyui-linkbutton">保存</a>
    			<a href="javascript:void(0);" id="cancel" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
    		</td>
    	</tr>
    </table>    
</div>
<div id="editorDiv" style="display:none">
 	<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<script type="text/javascript" src="js/noticeMng.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>