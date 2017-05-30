<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="goodsOrderListPage" value="result.ret"/>
<s:set name="goodsOrderList" value="#goodsOrderListPage.rows"/>
<s:set name="total" value="#goodsOrderListPage.total"/> 
<s:set var="pageCount" value="#goodsOrderListPage.pageCount"/>
<s:set var="pageIndex" value="#goodsOrderListPage.pageIndex"/>
<div   data-url="/Goods/queryUserOrder.do">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active">订单查询</li>
            </ol>
            <div class="tpl-portlet-components" id="addrListDiv">
            	<div class="portlet-title">
                    <div class="caption font-green ">
                        	订单列表
                    </div>
                </div>    
                    
				<div class="tpl-block">    
				    <div class="am-g">
                        
                    	<div class="am-u-sm-12 am-u-md-6" style="height:30px">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="modRevBtn" class="am-btn am-btn-default am-btn-success" style="display:none"><span class="am-icon-plug"></span>修改收货地址</button>
                                </div>                             
                            </div>
                        </div>
                     </div>                
                    <div class="am-g">
                        <div class="am-u-sm-12 ">
                            <form class="am-form" id="listForm"> 
                              <div class ="am-scrollable-horizontal">
                                <table class="am-table am-table-striped am-table-hover am-text-nowrap table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-title">订单编号</th>
                                            <th class="table-title">购买商品</th>
                                            <th class="table-type">购买数量</th>
                                            <th class="table-type">消费金额</th>
                                            <th class="table-type">支付类型</th>
                                            <th class="table-type">收货人</th>
                                            <th class="table-type">收货人电话</th>
                                            <th class="table-type">收货人地址</th>
                                            <th class="table-type">订单状态</th>
                                            <th class="table-type">购买日期</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator  value="#goodsOrderList"  id="goodsOrderIter" status="st">   
	                                        <tr>
	                                            <td><input type="checkbox" orderId="<s:property value="#goodsOrderIter.order_id"/>" orderType="<s:property value="#goodsOrderIter.order_type"/>" state="<s:property value="#goodsOrderIter.state"/>"></td>
	                                            <td><s:property value="#goodsOrderIter.order_code"/></td>
	                                            <td><s:property value="#goodsOrderIter.goods_name"/></td>
	                                            <td><s:property value="#goodsOrderIter.goods_amount"/></td>
	                                            <td><s:property value="#goodsOrderIter.total_fee"/></td>
	                                            <td><s:if test="#goodsOrderIter.pay_type == 2" >电子积分</s:if><s:if test="#goodsOrderIter.pay_type == 3" >重消积分</s:if></td>
	                                            <td><s:property value="#goodsOrderIter.rev_people"/></td>
	                                            <td><s:property value="#goodsOrderIter.rev_link_phone"/></td>
	                                            <td><s:property value="#goodsOrderIter.rev_addr"/></td> 
	                                            <td><s:if test="#goodsOrderIter.state == 0" >未发货</s:if><s:if test="#goodsOrderIter.state == 1" >已发货</s:if></td>  
	                                            <td> <s:date name="#goodsOrderIter.create_date" format="yyyy-MM-dd HH:mm:ss"/></td>                                         
	                                        </tr>
                                        </s:iterator>                                        
                                    </tbody>
                                </table>
                                
							</div>
							<div id="page">  </div>
                            </form>
                        </div>

                    </div>
                </div> 
        </div>
        

<script language="javascript" type="text/javascript" >
	var jump = function(context,first) {		
		if(!first){
			var searchContentV= $("#searchContent").val();
			var params ={};
			params["rows"] = 5;
			params["page"]=context!=null?context.option.curr:1;			
		    pageData.openContent(base+"/Goods/queryUserOrder.do",params);
		}
	}	
	
	$("#searchBtn").on("click",function(){
		jump(null,false);
	});
	$("#modRevBtn").on("click",function(){
		var goodsList=[];
		$.each($("#listForm input:checked"),function(i,v){
			var orderId = $(this).attr("orderId");
			goodsList.push(orderId);
		});
		if(goodsList.length==0){
			CommonUtils.showAlert("请先选择要修改的记录!");
			return;
		}
		if(goodsList.length>1){
			CommonUtils.showAlert("只能选择一个记录修改!");
			return;
		}
		var params ={};
		params["goodsOrder.order_id"]=goodsList[0];			
	    pageData.openContent(base+"/Goods/modGoodsRevAddr.do",params);
	});
	
	$("#listForm td input[type='checkbox']").on("click",function(event,param){
		
		var $this = $(this);
		var goodType = $this.attr("orderType");
		var state = $this.attr("state");
		$("#listForm td input[type='checkbox']").prop("checked",false);
		$this.prop("checked",true);
		if($this.is(":checked") && goodType == '1' && state == '0'){
			$("#modRevBtn").show();
		}else{			
			$("#modRevBtn").hide();
		}
	});
	
	$("#page").page({pages:<s:property value="pageCount"/>,curr:<s:property value="pageIndex"/>,jump:jump});
</script>	