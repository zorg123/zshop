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
        	<label>所属模块：</label>
            <select class="easyui-combobox" name="query_catalog_id" style="width:80px;">
                <option value="">--请选择--</option>
                <option value="1">精品拼团</option>
                <option value="2">即时拼团</option>
            </select>
        	<label>是否有效：</label>
            <select class="easyui-combobox" name="query_state" style="width:80px;">
                <option value="">--请选择--</option>
                <option value="0">无效</option>
                <option value="1">有效</option>
            </select>
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <div region="center" title="商品列表" style="padding:2px;">
        <table id="commList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" fit="true">
            <thead>
            <tr>
            	<th field="goods_id" width="40" hidden>商品ID</th>
            	<th field="icon_url" width="40" hidden>图片位置</th>
                <th field="goods_name" width="40">商品名称</th>  
                <th field="catalog_id" width="40">所属模块</th>
                <th field="goods_price" width="40">价格</th>              
                <th field="pay_type" width="40">购买积分类型</th>
                <th field="goods_desc" width="40">简要描述</th>
                <th field="pic_url" width="40">图片</th>
                <th field="state" width="40">状态</th>
                <th field="eff_date" width="40">生效时间</th>
                <th field="exp_date" width="40">失效时间</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_save" iconCls="icon-save" title="会员充值" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr>
    		<td>商品名称:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="goods_name" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>所属模块:</td>
    		<td colspan="3">
    			<select class="easyui-combobox" name="catalog_id" style="width:200px;">
	                <option value="1">精品拼团</option>
	                <option value="2">即时拼团</option>
            	</select>
    		</td>
    	</tr>
    	<tr>
    		<td>价格:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="goods_price" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>购买积分类型:</td>
    		<td colspan="3"> <input type="checkbox" name="pay_type" checked="checked" value="2"/>电子积分<input type="checkbox" name="pay_type" value="3"  />重消积分</td>
    	</tr>
    	<tr>
    		<td>简单描述:</td>
    		<td colspan="3"> 
    		<input class="easyui-textbox" data-options="multiline:true" name="goods_desc" style="width:200px;height:50px">
    	</tr>
    	<tr>
    		<td>状态:</td>
    		<td colspan="3"> <select class="easyui-combobox" name="state" style="width:200px;">
	                <option value="0">无效</option>
	                <option value="1" selected="true">有效</option>
            	</select></td>
    	</tr>
    	<tr>
    		<td>生效时间:</td>
    		<td colspan="3"> <input type="text" name="eff_date" class="easyui-datebox" /></td>
    	</tr>
    	<tr>
    		<td>失效时间:</td>
    		<td colspan="3"> <input type="text" name="exp_date" class="easyui-datebox" /></td>
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
						<input id="photoCover" class="easyui-textbox" type="text" style="width:120px"/> 
						<span class="input-group-btn">
					    	<a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="$('input[id=uploadFile]').click();" style="width:80px">选择文件</a>									        
					     </span>
					</div>
				     <a class="easyui-linkbutton color2" href="javascript:void(0)" onclick="javascript:commMng.upload()" style="width:80px">上传</a>
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
<script type="text/javascript" src="js/goodsConfig.js"></script>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>