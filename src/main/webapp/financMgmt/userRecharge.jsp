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
            <label>开始时间：</label><input type="text" name="start_time" class="easyui-datebox" />
            <label>结束时间：</label><input type="text" name="end_time" class="easyui-datebox" />
            <label>会员工号：</label><input type="text" name="query_user_code">          
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <div region="center" title="充值列表" style="padding:2px;">
        <table id="coinTrackList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" fit="true">
            <thead>
            <tr>
            	<th field="id" width="40" hidden>充值记录ID</th>
                <th field="user_code" width="40">会员编号</th>  
                <th field="user_name" width="40">会员名称</th>
                <th field="coin_num" width="40">充值金额</th>              
                <th field="create_time" width="40">充值时间</th>
                <th field="oper_user_name" width="40">充值人名称</th>
                <th field="file_info" width="40">文件</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_save" iconCls="icon-save" title="会员充值" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr>
    		<td>会员编号:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="user_code" style="width:140px"/></td>
    	</tr>
    	<tr>
    		<td>充值金额:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="coin_num" style="width:140px"/></td>
    	</tr>
		<tr style="width:100%;height:35px"> 
			<td>       	
			<label>附件：</label>
			</td>
			<td colspan="3">
				<div id="fileDownload">
					<ul>
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
				     <a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="javascript:RechargeMng.upload()" style="width:80px">上传</a>
				</form>
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
<script type="text/javascript" src="js/userRecharge.js"></script>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>