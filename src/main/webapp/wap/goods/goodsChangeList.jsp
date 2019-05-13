<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="goodsListPage" value="result.ret"/>
<s:set name="goodsList" value="#goodsListPage.rows"/>
<s:set name="total" value="#goodsList.total"/> 
<s:set var="pageCount" value="goodsListPage.pageCount"/>
<s:set var="pageIndex" value="goodsListPage.pageIndex"/>
<s:set var="goodsName" value="goods.goods_name"/>
<div data-url="/Goods/goodsList.do?goods.catalog_id=<s:property value="goods.catalog_id" />">          
           
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="am-g">
	                    <div class="am-u-sm-5 caption font-green ">
	                        <s:property value="funcName"/>可换商品列表
	                    </div>
	                    <div class="am-u-sm-7 am-u-md-6">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" class="am-form-field" id="searchContent" value="<s:property value="#goodsName"/>"/>
                                <span class="am-input-group-btn">
            						<button id="searchBtn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
            						<button id="backBtn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success " style="margin-left:10px" type="button">返回</button>
          						</span>
                            </div>
		                 </div>
	                  </div>
                </div>    
                    
				<div class="tpl-block">                   
                    <div class="am-g">
                    	<div class="tpl-table-images" id="masonryGrid">
                    		<s:iterator  value="#goodsList"  id="goodsIter" status="st"> 
	                    	 	<div class="am-u-sm-12 am-u-md-6 am-u-lg-4 grid-item">
	                                <div class="tpl-table-images-content">
	                                	<div class="tpl-table-images-content-i-time"><s:property value="#goodsIter.goods_name"/></div>
	                                	<a href="javascript:void(0);" class="tpl-table-images-content-i">  	                                		                               		                                      	
                                        	<img src="<%=baseUri %><s:property value="#goodsIter.icon_url"/>" alt="">
                                    	</a>
                                    	<div class="tpl-table-images-content-i-info">
                                            <span class="ico" style="margin-bottom:0px">
			                                   	 <%-- <span class="price-promo">￥ <s:property value="#goodsIter.goods_price"/> </span> <span class="price-original"><s:property value="#goodsIter.goods_market_price"/></span>  <s:if test="#goodsIter.pay_type == 2">电子币</s:if><s:if test="#goodsIter.pay_type == 3">重销币</s:if><s:if test="#goodsIter.pay_type == '2,3'">电子币或重销币</s:if> --%>  
			                                	<span class="sk_item_price">
			                                		<s:if test="goods.catalog_id == 1">会员价格:</s:if><s:else>拼团价格:</s:else><span class="mod_price sk_item_price_new">
				                                		<i>¥</i><span><s:property value="#goodsIter.goods_price"/></span>
			                                		</span>
			                                		<s:if test="#goodsIter.goods_market_price != null">
			                                		  <span class="mod_price sk_item_price_origin">
			                                		    <i style="font-size:12px;">¥</i><del><s:property value="#goodsIter.goods_market_price"/></del>
			                                		 </span>
			                                		</s:if>			                                		 
			                                		 (可用 <s:if test="#goodsIter.pay_type == 2">电子币</s:if><s:if test="#goodsIter.pay_type == 3">重消币</s:if><s:if test="#goodsIter.pay_type == '2,3'">电子币或重消币</s:if>)
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
					                                    <div class="am-btn-group am-btn-group-xs am-u-sm-4">
			                                            	 <button type="button" class="am-btn am-btn-default am-btn-success" goodsId="<s:property value="#goodsIter.goods_id"/>" orderId="<s:property value="orderId"/>" onclick="changeGoods(this);"><span class="am-icon-cart-arrow-down"></span> 换货</button> </div>
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
			params["orderId"]='<s:property value="orderId" />';
			if(searchContentV.length!=0){
				params["goods.goods_name"] = searchContentV;
			}
		    pageData.openContent("/Goods/goodsChangeList.do",params);
		}
	}
	
	$("#searchBtn").on("click",function(){
		jump(null,false);
	});
	
	$("#backBtn").on("click",function(){
		pageData.openContent("/Goods/queryUserOrder.do");
	});
	
	function changeGoods(obj){
		$this = $(obj);
		var goodsId = $this.attr("goodsId");
		var orderId = $this.attr("orderId");
		
		var params ={};
		params["goods.goods_id"] = goodsId;
		params["orderId"] =orderId;
		CommonUtils.showConfirm("确定要换货吗?",function(){
			CommonUtils.invokeAsyncAction(base+'/Goods/goodsChange.do', params, function (reply) {
				if ((reply || '') != '') {
		               var code = reply._code;               
		               if (code == '0') {  
		            	   CommonUtils.showAlert("操作成功!");
		            	   setTimeout(function(){ pageData.openContent("/Goods/queryUserOrder.do",null); }, 1000);   
		               } else  {
		            	  CommonUtils.showAlert(reply._msg);
		             }              
		           } else  {
		        	   CommonUtils.showAlert('操作失败，请重试!');
		           }
		     },true);
		});
	}
	
	var $container = $('#masonryGrid');    
    $container.imagesLoaded(function(){
        $container.masonry({
            itemSelector: '.grid-item',
            columnWidth: '.grid-item',
            percentPosition: true
        });
    });
    
    $("#masonryGrid .grid-item .tpl-table-images-content").hover(function(){
    		$(this).css("border-color","red");
    	},function() {
    		$(this).css("border-color","#e7ecf1");
    });
   
	$("#page").page({pages:<s:property value="#goodsListPage.pageCount"/>,curr:<s:property value="#goodsListPage.pageIndex"/>,jump:jump});
</script>	