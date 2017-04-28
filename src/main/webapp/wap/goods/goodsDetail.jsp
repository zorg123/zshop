<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>
<div id="goodDetailDiv">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active">商品受理</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>订单信息
                    </div>
                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form" id="acceptForm">
                            	<input type="hidden" name="goodsOrder.goods_id" db_field="goodsOrder.goods_id" value="<s:property value="goods.goods_id" />" />
                            	<input type="hidden" name="goodsOrder.goods_name" db_field="goodsOrder.goods_name" value="<s:property value="goods.goods_name" />" />
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">商品名称 </label>
                                    <div class="am-u-sm-9">
                                        <span type="text" class="am-form-field tpl-form-no-bg" ><s:property value="goods.goods_name" /></span> 
                                     </div>
                                </div> 
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">商品类型 </label>
                                    <div class="am-u-sm-9">
                                        <span type="text" class="am-form-field tpl-form-no-bg"><s:if test="goods.catalog_id == 1" >精品拼团</s:if><s:else>即时拼团</s:else></span>
                                    </div>
                                </div>                                  
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">商品描述</label>
                                    <div class="am-u-sm-9">
                                        <span type="text" class="am-form-field tpl-form-no-bg"><s:property value="goods.goods_desc" /></span> 
                                    </div>
                                </div>
								                              
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">商品价格</label>
                                    <div class="am-u-sm-9">
                                    	<input type="hidden" name="goods.goods_price" db_field="goods.goods_price" value="<s:property value="goods.goods_price" />" />
                                        <span type="text" class="am-form-field tpl-form-no-bg"><s:property value="goods.goods_price" /></span>
                                    </div>
                                </div>
                                                                
                                <s:if test="goods.pay_type == 2 || goods.pay_type == 3">
	                                <div class="am-form-group">
	                                    <label for="user-email" class="am-u-sm-3 am-form-label">支付方式</label>
	                                    <div class="am-u-sm-9">   
	                                        <input type="hidden" name="goodsOrder.pay_type" db_field="goodsOrder.pay_type" value="<s:property value="goods.pay_type" />" />                                     
	                                        <span type="text" class="am-form-field tpl-form-no-bg"><s:if test="goods.pay_type == 2" >电子币</s:if><s:if test="goods.pay_type == 3" >重消币</s:if></span>
	                                    </div>
                                	</div>
                                </s:if>
                                <s:elseif test="goods.pay_type=='2,3'">
                                	<div class="am-form-group">
	                                    <label for="user-phone" class="am-u-sm-3 am-form-label">支付类型</label>
	                                    <div class="am-u-sm-9">
	                                        <select data-am-selected db_field="goodsOrder.pay_type" name="goodsOrder.pay_type" >
											  <option value="2" selected>电子币</option>
											  <option value="3">重消币</option>
											</select>									
	                                    </div>
	                                </div>
                                </s:elseif>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">购买数量</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" db_field="goodsOrder.goods_amount" pattern="[0-9]*" name="goodsOrder.goods_amount" placeholder="输入你要购买的数量" value="<s:property value="goods.goods_amount" />">
                                        <small id="coinAmountTip"></small> 
                                    </div>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">收货信息：</label>
                                    <div class="am-u-sm-9">
                                    	<input type="text" class="am-form-field tpl-form-no-bg" db_field="goodsOrder.rev_people" name="goodsOrder.rev_people" value="<s:property value="goodsRevAddr.rev_people"/>" readonly/>
                                    	<input type="text" class="am-form-field tpl-form-no-bg" db_field="goodsOrder.rev_link_phone" name="goodsOrder.rev_link_phone" value="<s:property value="goodsRevAddr.rev_link_phone"/>" readonly/>
                                        <input type="hidden" db_field="goodsOrder.rev_area" name="goodsOrder.rev_area" value="<s:property value="goodsRevAddr.rev_provice"/>" readonly/>
                                        <input type="text" class="am-form-field tpl-form-no-bg" db_field="goodsOrder.rev_addr" value="<s:property value="goodsRevAddr.rev_provice"/><s:property value="goodsRevAddr.rev_city"/><s:property value="goodsRevAddr.rev_zone"/><s:property value="goodsRevAddr.rev_addr"/>" name="goodsOrder.rev_addr" placeholder="没有收货地址请点击管理按钮管理您的收货地址" readonly/>                                       
                                        <input type="button" id="manRevAddBtn" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="管理地址"></input>
                                     </div>
                                </div>                               

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <input type="submit" id="userProfileSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交"></input>                                    	
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
</div>
<div id="addrMngDiv"> 
	  
</div>
<div id="successTipDiv" style="display:none"> 
	  		<ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active">商品受理</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>订单信息
                    </div>
                </div>
                 <div class="tpl-block">
                 	
					  <div>受理成功</div>
					  <div>订单单号为：<span id="orderCodeSpan"></span></div>
					  <div>
					  	<input type="button" id="continueBuyBtn" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="继续购买"></input>
					    <input type="button" id="queryOrderBtn" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="查询订单"></input>
					  </div>					
                 </div>
            </div>
     
</div>
        
<script language="javascript" type="text/javascript" >
	$(function() {	
		$("#acceptForm input[name='goodsOrder.goods_amount']").on("input",function(e){
			checkCoin();
		});
		
		if($("#acceptForm select[name='goodsOrder.pay_type']")){
			$("#acceptForm select[name='goodsOrder.pay_type']").on("change",function(e){
				checkCoin();
			});
		}
		
		$("#acceptForm input[name='goodsOrder.goods_amount']").trigger("input");
		
		function checkCoin(){
			$("#userProfileSubmit").removeAttr("disabled");
			var amount = $("#acceptForm input[name='goodsOrder.goods_amount']").val();
			if(amount <1){
				CommonUtils.showAlert("购买数量不能小于1!");
				$("#userProfileSubmit").attr("disabled",true);
				return false;
			}
			
			var payTypeObj = $("#acceptForm input[name='goodsOrder.pay_type']");					
			if(!payTypeObj || payTypeObj.length==0){
				payTypeObj = $("#acceptForm select[name='goodsOrder.pay_type']");						
			}
			var payType = payTypeObj.val();
			if(!payType || payType == null){
				CommonUtils.showAlert("没有支付方式，暂时不能购买!");
				$("#userProfileSubmit").attr("disabled",true);
				return false;
			}
			
			var params = {};
			params["goods.pay_type"] = payType;
			params["goods.goods_amount"] = amount;
			params["goods.goods_price"] = $("#acceptForm input[name='goods.goods_price']").val();
			CommonUtils.invokeAsyncAction(base+'/Goods/checkCoin.do', params, function (reply) {           
	  	        $("#coinAmountTip").empty("");   
				if ((reply || '') != '') {
  	               var code = reply._code;               
  	               if (code == '0') {  
  	            	   var ret = reply.ret;
  	            	   if(ret.check == 0){
  	            		 $("#coinAmountTip").html("<div class='field-invalidmsg'>当前余额不足，余额为:"+ret.coin+"</div>"); 
  	            		 $("#userProfileSubmit").attr("disabled",true);
  	            	   }else{
  	            		 $("#coinAmountTip").html("<div class='field-invalidmsg'>当前余额为:"+ret.coin+"</div>"); 
  	            	   }
  	               }else{
  	            	 $("#userProfileSubmit").attr("disabled",true);
  	             }              
  	           }else {
  	        	 	$("#userProfileSubmit").attr("disabled",true);;
  	           }
  	         });
		}
		
		$("#manRevAddBtn").on("click",function(){
			var params={};
			pageData.openContent(base+"/Goods/goodsRevAddrListForSel.do",params,"addrMngDiv");
			if ($.AMUI.support.animation) {
				$("#goodDetailDiv").addClass("am-animation-fade am-animation-reverse").one($.AMUI.support.animation.end, function() {
					$("#goodDetailDiv").removeClass("am-animation-fade am-animation-reverse");
					$("#goodDetailDiv").hide();
					$("#addrMngDiv").show();
					$("#addrMngDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
						$("#addrMngDiv").removeClass("am-animation-fade");								
			        });
		        });						
			}else{
				$("#goodDetailDiv").hide();
				$("#addrMngDiv").show();
			}
		});
		
		$("#continueBuyBtn").on("click",function(){
			pageData.openContent(base+"/Goods/goodsList.do?goods.catalog_id=<s:property value="goods.catalog_id" />",null,"addrMngDiv");
		});
		
		$("#queryOrderBtn").on("click",function(){
			var orderCode = $("#orderCodeSpan").html();
			pageData.openContent(base+"/Goods/queryUserOrder.do?goodsOrder.order_code="+orderCode,null);
		});
		$("#acceptForm").mvalidate({
	            type:2,
	            onKeyup:true,
	            sendForm:false,
	            firstInvalidFocus:true,
	            valid:function(event,options){
	            	
	                //点击提交按钮时,表单通过验证触发函数
	                 var params = CommonUtils.getParam("acceptForm",false);			                 
					 CommonUtils.invokeAsyncAction(base+'/Goods/accept.do', params, function (reply) {           
		  	           
						if ((reply || '') != '') {
		  	               var code = reply._code;               
		  	               if (code == '0') {  
		  	            	   var ret = reply.ret;
		  	            	   CommonUtils.showAlert('操作成功!');
		  	            	   $("#orderCodeSpan").html(ret.order_code);  
		  	            	 if ($.AMUI.support.animation) {
		  	   				 $("#goodDetailDiv").addClass("am-animation-fade am-animation-reverse").one($.AMUI.support.animation.end, function() {
		  	   					$("#goodDetailDiv").removeClass("am-animation-fade am-animation-reverse");
		  	   					$("#goodDetailDiv").hide();
		  	   					$("#successTipDiv").show();
		  	   					$("#successTipDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
		  	   						$("#successTipDiv").removeClass("am-animation-fade");								
		  	   			        });
		  	   		         });						
		  	   			}else{
		  	   				$("#goodDetailDiv").hide();
		  	   				$("#successTipDiv").show();
		  	   			}
		  	               } else  {
		  	            	  CommonUtils.showAlert(reply._msg);
		  	             }              
		  	           } else  {
		  	        	      CommonUtils.showAlert('操作失败!');
		  	           }
		  	         },true);					 
	                event.preventDefault();
	                return false;
	            },
	            descriptions:{
	            	"user.user_phone":{
	                    required : '<div class="field-invalidmsg">请输入手机号码</div>',
	                    pattern : '<div class="field-invalidmsg">您输入的手机号码格式不正确</div>',
	                    valid : '<div class="field-validmsg">验证通过</div>'
	                },
	                "user.mail" : {
	                    pattern : '<div class="field-invalidmsg">邮箱格式不对</div>',
	                    valid : ''
	                }
	            }
	     });
	   
		
		$('select[data-am-selected]').selected({
		    selectBox:1
		  });
		 
	});
	
	function confirmAddr(addr){
		if(addr){
			$("#acceptForm input[name='goodsOrder.rev_people']").val(addr.revPeople);
			$("#acceptForm input[name='goodsOrder.rev_addr']").val(addr.revAddr);
			$("#acceptForm input[name='goodsOrder.rev_link_phone']").val(addr.revLinkPhone);
			$("#acceptForm input[name='goodsOrder.rev_area']").val(addr.addrArea);
		}
	}
	
	function goAccept(){					
		if ($.AMUI.support.animation) {
			$("#addrMngDiv").addClass("am-animation-fade am-animation-reverse").one($.AMUI.support.animation.end, function() {
				$("#addrMngDiv").removeClass("am-animation-fade am-animation-reverse");
				$("#addrMngDiv").hide();
				$("#goodDetailDiv").show();
				$("#goodDetailDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
					$("#goodDetailDiv").removeClass("am-animation-fade");								
		        });
	        });						
		}else{
			$("#addrMngDiv").hide();
			$("#goodDetailDiv").show();
		}
	};
</script>	