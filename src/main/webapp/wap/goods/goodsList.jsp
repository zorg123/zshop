<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>

<s:if test="goods.catalog_id == 1">    
    <s:set name="funcName" value="'精品拼团 '" />      
</s:if> 
<s:else>
   <s:set name="funcName" value="'即时拼团'" />  
</s:else>
<s:set name="goodsListPage" value="result.ret"/>
<s:set name="goodsList" value="#goodsListPage.rows"/>
<s:set name="total" value="#goodsList.total"/> 
<s:set var="pageCount" value="goodsListPage.pageCount"/>
<s:set var="pageIndex" value="goodsListPage.pageIndex"/>
<div data-url="/Goods/goodsList.do?goods.catalog_id=<s:property value="goods.catalog_id" />">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active"><s:property value="funcName"/></li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="am-g">
	                    <div class="am-u-sm-8 caption font-green ">
	                        <s:property value="funcName"/>列表
	                    </div>
	                    <div class="am-u-sm-4 am-u-md-3">
		                            <div class="am-input-group am-input-group-sm">
		                                <input type="text" class="am-form-field" id="searchContent" value="<s:property value="goods.goods_name"/>"/>
		                                <span class="am-input-group-btn">
		            						<button id="searchBtn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
		          						</span>
		                            </div>
		                   </div>
	                  </div>
                </div>    
                    
				<div class="tpl-block">                   
                    <div class="am-g">
                    	<div class="tpl-table-images">
                    		<s:iterator  value="#goodsList"  id="goodsIter" status="st"> 
	                    	 	<div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
	                                <div class="tpl-table-images-content">
	                                	<div class="tpl-table-images-content-i-time"><s:property value="#goodsIter.goods_name"/></div>
	                                	<a href="javascript:void(0);" class="tpl-table-images-content-i">  	                                		                               		                                      	
                                        	<img src="<%=baseUri %><s:property value="#goodsIter.icon_url"/>" alt="">
                                    	</a>
                                    	<div class="tpl-table-images-content-i-info">
                                            <span class="ico" style="margin-bottom:0px">
			                                   	 <%-- <span class="price-promo">￥ <s:property value="#goodsIter.goods_price"/> </span> <span class="price-original"><s:property value="#goodsIter.goods_market_price"/></span>  <s:if test="#goodsIter.pay_type == 2">电子币</s:if><s:if test="#goodsIter.pay_type == 3">重销币</s:if><s:if test="#goodsIter.pay_type == '2,3'">电子币或重销币</s:if> --%>  
			                                	<span class="sk_item_price">
			                                		拼团:<span class="mod_price sk_item_price_new">
				                                		<i>¥</i><span><s:property value="#goodsIter.goods_price"/></span>
			                                		</span>
			                                		<span class="mod_price sk_item_price_origin">
			                                		    <i style="font-size:12px;">¥</i><del><s:property value="#goodsIter.goods_market_price"/></del>
			                                		 </span> 
			                                		 (可用 <s:if test="#goodsIter.pay_type == 2">电子币</s:if><s:if test="#goodsIter.pay_type == 3">重销币</s:if><s:if test="#goodsIter.pay_type == '2,3'">电子币或重销币</s:if>)
			                                	</span>
			                               	</span>
                                        </div>
                                    	 <div class="tpl-table-images-content-block">
	                                        <div class="tpl-i-font">
	                                             <s:property value="#goodsIter.goods_desc"/>
	                                        </div>	                                        
	                                        <div class="am-btn-toolbar">
	                                            <form class="am-form am-form-horizontal" style="margin-top:10px">	                                            
		                                        	<div class="am-form-group" style="margin-bottom:0px">					                                   
					                                    <label class="am-u-sm-8" style="padding:0px;font-weight:400;font-size:14px;">
					                                        <input type="number" pattern="[0-9]*" name="amount" placeholder="输入你要购买的数量" style="font-size:14px" value="1">
					                                    </label>
					                                    <div class="am-btn-group am-btn-group-xs am-u-sm-4">
			                                            	 <button type="button" class="am-btn am-btn-default am-btn-success" goodsId="<s:property value="#goodsIter.goods_id"/>" onclick="buy(this);"><span class="am-icon-cart-arrow-down"></span> 购买</button> </div>
					                                    </div>
					                             </form>
	                                            
	                                        </div>
                                    </div>
                                    	
	                    			</div>
	                    		</div>
	                    	</s:iterator>
                    	</div> 
                    </div>
                    <div id="page">  </div>
                </div> 
        </div>
        
<script language="javascript" type="text/javascript" >
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var searchContentV= $("#searchContent").val();
			var params ={};
			params["rows"] = 6;
			params["page"]=context!=null?context.option.curr:1;
			params["goods.catalog_id"]='<s:property value="goods.catalog_id" />';
			if(searchContentV.length!=0){
				params["goods.goods_name"] = searchContentV;
			}
		    pageData.openContent(base+"/Goods/goodsList.do",params);
		}
	}
	
	$("#searchBtn").on("click",function(){
		jump(null,false);
	});
	
	function buy(obj){
		$this = $(obj);
		var goodsId = $this.attr("goodsId");
		//console.log($this.parent().parent().find("input[name='amount']"));
		var amount = $this.parent().parent().find("input[name='amount']").val();
		if(!amount || amount < 1){
			CommonUtils.showAlert("请先输入要购买的数量!");
			return ;
		}
		var params ={};
		params["goods.goods_id"] = goodsId;
		params["goods.goods_amount"] =amount;
		pageData.openContent(base+"/Goods/goodsDetail.do",params);
	}
	
	$("#page").page({pages:<s:property value="#goodsListPage.pageCount"/>,curr:<s:property value="#goodsListPage.pageIndex"/>,jump:jump});
</script>	