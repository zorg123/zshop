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
        	<label>是否发货：</label>
            <select class="easyui-combobox" name="query_state" style="width:80px;">
                <option value="">--请选择--</option>
                <option value="0">未发货</option>
                <option value="1">已发货</option>
                <option value="2">待发货</option>
            </select>
            <label>商品名称：</label><input class="easyui-combobox" name="goods_id" db_field="goods_id"  data-options="valueField:'id',textField:'name',url:'<%=baseUri %>/InfoCommon/queryById.do?sqlId=8'" />
            <label>待发货开始时间：</label><input type="text" name="state_date_start" class="easyui-datebox" />
            <label>待发货结束时间：</label><input type="text" name="state_date_end" class="easyui-datebox" />
            <label>订单编号：</label><input type="text" name="query_order_code">
            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <div region="center" title="充值列表" style="padding:2px;">
        <table id="goodsOrderList"  rownumbers="true" pagination="true"
               fitColumns="true" nowrap="false" showFooter="true" singleSelect="true" fit="true">
            <thead>
            <tr>
            	<th field="order_id" width="40" hidden>订单ID</th>
            	<th field="user_id" width="40" hidden>会员id</th>
            	<th field="order_code" width="80">订单编号</th>
            	<th field="goods_name" width="80">商品名称</th>
            	<th field="catalog_id" width="100" formatter="formatCatalog" >商品类型</th>
            	<th field="goods_amount" width="40">购买数量</th>
            	<th field="total_fee" width="30">金额</th>
            	<th field="user_name" width="40">会员名称</th>
            	<th field="rev_people" width="30">收货人</th>
            	<th field="rev_link_phone" width="50">联系电话</th>
            	<th field="rev_addr" width="120">详细地址</th>
            	<th field="create_date" width="50">购买时间</th>
            	<th field="state_name"  width="40">订单状态</th>
            	<th field="state_date" width="50">待发货时间</th>
            	<th field="deal_exp_ord" width="80">物流订单号</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div id="win_edit" iconCls="icon-save" title="会员充值" style="background:#fafafa;padding:10px;display: none;">
    <table>
    	<tr style="display: none;">
    		<td>order_id:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_order_id" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>订单编号:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_order_code" style="width:200px"/></td>
    	</tr>
    	<tr>
    		<td>是否发货:</td>
    		<td colspan="3">
    		<select class="easyui-combobox" name="edit_state" style="width:200px;">
                <option value="0">未发货</option>
                <option value="1" selected>已发货</option>
            </select></td>
    	</tr>
    	<tr>
    		<td>物流单号:</td>
    		<td colspan="3"> <input class="easyui-validatebox" type="text" name="edit_deal_exp_ord" style="width:200px"/></td>
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
<script type="text/javascript" src="js/goodsOrder.js"></script>
<div id="output"></div>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>