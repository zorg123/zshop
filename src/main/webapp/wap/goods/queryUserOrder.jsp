<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="goodsOrderListPage" value="result.ret"/>
<s:set name="goodsOrderList" value="#goodsOrderListPage.rows"/>
<s:set name="total" value="#goodsOrderListPage.total"/> 
<s:set var="pageCount" value="goodsOrderListPage.pageCount"/>
<s:set var="pageIndex" value="goodsOrderListPage.pageIndex"/>
<div   data-url="/Goods/queryUserOrder.do">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">会员购物</a></li>
                <li class="am-active">订单查询  </li>
            </ol>
            <div class="tpl-portlet-components" id="addrListDiv">
            	<div class="portlet-title">
                    <div class="caption font-green ">
                        	订单列表
                    </div>
                </div>    
                    
				<div class="tpl-block">  
					<div class="am-g">
					    <div class="am-btn-group doc-js-btn-1"  data-am-button>
						  <label class="am-btn am-btn-primary am-btn-sm <s:if test="conditionType == 0" >am-active</s:if>">
						    <input type="radio" name="searchCon" value="0"  > 未发货
						  </label>
						  <label class="am-btn am-btn-primary am-btn-sm <s:if test="conditionType == 2" >am-active</s:if>">
						    <input type="radio" name="searchCon" value="2"  > 待发货
						  </label>
						  <label class="am-btn am-btn-primary  am-btn-sm <s:if test="conditionType == 1" >am-active</s:if>">
						    <input type="radio" name="searchCon" value="1"  > 已发货
						  </label>
						  <label class="am-btn am-btn-primary am-btn-sm <s:if test="conditionType == 4" >am-active</s:if>" >
						    <input type="radio" name="searchCon" value="4"  > 一个月内订单
						  </label>
						</div>  
					</div>
				    <div class="am-g">                        
                    	<div class="am-u-sm-12 am-u-md-6" style="height:30px;margin-top:10px">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="modRevBtn" class="am-btn am-btn-default am-btn-success" style="display:none"><span class="am-icon-plug"></span>修改收货地址</button>
                                    <button type="button" id="goodSendBtn" class="am-btn am-btn-default am-btn-success" style="display:none; margin-left:10px"><span class="am-icon-plug"></span>申请发货</button>
                                    <button type="button" id="goodChangeBtn" class="am-btn am-btn-default am-btn-success" style="display:none; margin-left:10px"><span class="am-icon-exchange"></span>换货</button>
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
                                            <th class="table-title">商品类型</th>
                                            <th class="table-type">购买数量</th>
                                            <th class="table-type">消费金额</th>
                                            <th class="table-type">支付类型</th>
                                            <th class="table-type">收货人</th>
                                            <th class="table-type">收货人电话</th>
                                            <th class="table-type">收货人地址</th>
                                            <th class="table-type">订单状态</th>
                                            <th class="table-type">购买日期</th>
                                            <th class="table-type">物流信息</th>
                                            <th class="table-type">备注</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator  value="#goodsOrderList"  id="goodsOrderIter" status="st">   
	                                        <tr>
	                                            <td><input type="checkbox" orderId="<s:property value="#goodsOrderIter.order_id"/>"  goodsId="<s:property value="#goodsOrderIter.goods_id"/>" orderType="<s:property value="#goodsOrderIter.order_type"/>" goodsType="<s:property value="#goodsOrderIter.goods_type"/>" state="<s:property value="#goodsOrderIter.state"/>"></td>
	                                            <td><s:property value="#goodsOrderIter.order_code"/></td>
	                                            <td><s:property value="#goodsOrderIter.goods_name"/></td>
	                                            <td><s:if test="#goodsOrderIter.catalog_id == 1" >会员商品</s:if><s:else>拼团商品</s:else></td>
	                                            <td><s:property value="#goodsOrderIter.goods_amount"/></td>
	                                            <td><s:property value="#goodsOrderIter.total_fee"/></td>
	                                            <td><s:if test="#goodsOrderIter.pay_type == 2" >电子积分</s:if><s:if test="#goodsOrderIter.pay_type == 3" >重消积分</s:if></td>
	                                            <td><s:property value="#goodsOrderIter.rev_people"/></td>
	                                            <td><s:property value="#goodsOrderIter.rev_link_phone"/></td>
	                                            <td><s:property value="#goodsOrderIter.rev_addr"/></td> 
	                                            <td><s:if test="#goodsOrderIter.state == 0" >未发货</s:if><s:if test="#goodsOrderIter.state == 1" >已发货</s:if><s:if test="#goodsOrderIter.state == 2" >待发货</s:if><s:if test="#goodsOrderIter.state == -1" >已赠送</s:if></td>  
	                                            <td> <s:date name="#goodsOrderIter.create_date" format="yyyy-MM-dd HH:mm:ss"/></td>
	                                            <td><s:property value="#goodsOrderIter.deal_exp_ord"/></td>
	                                            <td><s:property value="#goodsOrderIter.comments"/></td>
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
			var params ={};
			params["rows"] = 10;			
			params["conditionType"] = conditionType;
			params["page"]=context!=null?context.option.curr:1;		
			console.log(params);
		    pageData.openContent("/Goods/queryUserOrder.do",params);
		}
		conditionType ="";
		return false;
	}	
	
	$("input[name='searchCon']").on("change",function(){	
		conditionType = $("input[name='searchCon']:checked").val();
		jump(null,false);
		return true;
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
	    pageData.openContent("/Goods/modGoodsRevAddr.do",params);
	});
	
	$("#goodSendBtn").on("click",function(){
		var goodsList=[];
		$.each($("#listForm input:checked"),function(i,v){
			var orderId = $(this).attr("orderId");
			goodsList.push(orderId);
		});
		if(goodsList.length==0){
			CommonUtils.showAlert("请先选择要发货的记录!");
			return;
		}
		if(goodsList.length>1){
			CommonUtils.showAlert("只能选择一个记录修改!");
			return;
		}
		
		var params ={};
		params["goodsOrder.order_id"]=goodsList[0];			
	    pageData.openContent("/Goods/goodsSends.do",params);
	});
	
	$("#goodChangeBtn").on("click",function(){
		var goodsList=[];
		var orderId ;
		var goodsId;
		$.each($("#listForm input:checked"),function(i,v){
			orderId = $(this).attr("orderId");
			goodsId = $(this).attr("goodsId");
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
		params["orderId"]=orderId;	
		params["goods.goods_id"]=goodsId;	
	    pageData.openContent("/Goods/goodsChangeList.do",params);		
	});
	
	$("#listForm td input[type='checkbox']").on("click",function(event,param){
		
		var $this = $(this);
		var orderType = $this.attr("orderType");
		var goodType = $this.attr("goodsType");
		var state = $this.attr("state");
		$("#listForm td input[type='checkbox']").prop("checked",false);
		$this.prop("checked",true);
		$("#modRevBtn").hide();
		$("#goodSendBtn").hide();
		$("#goodChangeBtn").hide();
		if($this.is(":checked") && state == '0'){
			$("#modRevBtn").show();
			$("#goodSendBtn").show();
			if(goodType=="0"){
			  $("#goodChangeBtn").show();
			}
		}else{			
			$("#modRevBtn").hide();
			$("#goodSendBtn").hide();
			$("#goodChangeBtn").hide();
		}
	});
	
	var pageCount = '<s:property value="#goodsOrderListPage.pageCount"/>';

	var pageIndex = '<s:property value="#goodsOrderListPage.pageIndex"/>';	
	if(pageIndex==0){
		pageIndex = -1;
	}
	
	$("#page").page({pages:pageCount,curr:pageIndex,jump:jump});
</script>	