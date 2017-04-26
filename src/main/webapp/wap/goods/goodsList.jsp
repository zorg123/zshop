<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>

<s:if test="goods.catalog_id == 1">    
    <s:set name="funcName" value="'长期团购'" />      
</s:if> 
<s:else>
   <s:set name="funcName" value="'短期团购'" />  
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
                    <div class="caption font-green ">
                        <s:property value="funcName"/>列表
                    </div>
                </div>    
                    
				<div class="tpl-block">
                    <div class="am-g">                        
	                    <div class="am-u-sm-12 am-u-md-3">
	                            <div class="am-input-group am-input-group-sm">
	                                <input type="text" class="am-form-field" id="searchContent" value="<s:property value="goods.goods_name"/>"/>
	                                <span class="am-input-group-btn">
	            						<button id="searchBtn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
	          						</span>
	                            </div>
	                    </div>
                     </div>
                    <div class="am-g">
                    	<div class="tpl-table-images">
                    		<s:iterator  value="#goodsList"  id="goodsIter" status="st"> 
	                    	 	<div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
	                                <div class="tpl-table-images-content">
	                                	<div class="tpl-i-title">
	                                        <s:property value="#goodsIter.godos_name"/>
	                                    </div>
	                                	<a href="javascript:void(0);" class="tpl-table-images-content-i">  
	                                		<div class="tpl-table-images-content-i-info">
                                            <span class="ico">
			                                   	 价格：<s:property value="#goodsIter.goods_price"/> <s:if test="goodsIter.pay_type == 2">电子币</s:if><s:if test="goodsIter.pay_type == 3">重销币</s:if><s:if test="goodsIter.pay_type == '2,3'">电子币或重销币</s:if>
			                                </span>
                                        	</div>
                                        	<span class="tpl-table-images-content-i-shadow"></span>	                                		                                      	
                                        	<img src="<%=baseUri %><s:property value="#goodsIter.icon_url"/>" alt="">
                                    	</a>
                                    	 <div class="tpl-table-images-content-block">
	                                        <div class="tpl-i-font">
	                                             <s:property value="#goodsIter.godos_desc"/>
	                                        </div>	                                        
	                                        <div class="am-btn-toolbar">
	                                             <div class="am-btn-group am-btn-group-xs tpl-edit-content-btn">
	                                            	<div class="am-form-group">
					                                    <label class="am-u-sm-3 am-form-label">数量</label>
					                                    <div class="am-u-sm-9">
					                                        <input type="number" pattern="[0-9]*" name="amount" placeholder="输入你要购买的数量">
					                                    </div>
					                                </div>
	                                                <button type="button" class="am-btn am-btn-default am-btn-success" goodsId="<s:property value="#goodsIter.godos_id"/>" onclick="buy(this);"><span class="am-icon-cart-arrow-down"></span> 购买</button>	                                                
	                                            </div>
	                                        </div>
                                    </div>
                                    	
	                    			</div>
	                    		</div>
	                    	</s:iterator>
                    	</div> 
                    </div>
                </div> 
        </div>
        
<script language="javascript" type="text/javascript" >
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var searchContentV= $("#searchContent").val();
			var params ={};
			params["rows"] = 5;
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
		var amount = $this.parent().find("input[name='amount']").val();
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