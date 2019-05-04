<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>
<div id="goodsSendDiv">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active">订单发货</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>订单发货信息
                    </div>
                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form" id="acceptForm">
                            	<input type="hidden" name="goodsOrder.order_id" db_field="goodsOrder.order_id" value="<s:property value="goodsOrder.order_id" />" />
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">商品名称 </label>
                                    <div class="am-u-sm-9">
                                        <span type="text" class="am-form-field tpl-form-no-bg" ><s:property value="goodsOrder.goods_name" /></span> 
                                     </div>
                                </div>  
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">订单编码 </label>
                                    <div class="am-u-sm-9">
                                        <span type="text" class="am-form-field tpl-form-no-bg" ><s:property value="goodsOrder.order_code" /></span> 
                                     </div>
                                </div> 
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">购买数量 </label>
                                    <div class="am-u-sm-9">
                                        <span type="text" class="am-form-field tpl-form-no-bg" ><s:property value="goodsOrder.goods_amount" /></span> 
                                     </div>
                                </div> 
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">发货数量</label>
                                    <input name="goodsAmount" id="goodsAmount" value="<s:property value="goodsOrder.goods_amount" />" type="hidden">
                                    <div class="am-u-sm-9">
                                    	<input type="number" pattern="[0-9]*" placeholder="输入你要发货的数量，不能大于<s:property value="goodsOrder.goods_amount" />" style="font-size:14px"  db_field="goodsOrderSplitNumber" name="goodsOrderSplitNumber" value="<s:property value="goodsOrder.goods_amount" />">
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
                                        <input type="submit" id="modSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交"></input>  
                                        <input type="submit" id="cancelSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="返回"></input>                                    	
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
</div>
<div id="addrMngDiv" style="display:none"> 
	  
</div>
        
<script language="javascript" type="text/javascript" >
	$(function() {
		
		$("#manRevAddBtn").on("click",function(){
			var params={};
			pageData.openContent("/Goods/goodsRevAddrListForSel.do",params,"addrMngDiv");
			if ($.AMUI.support.animation) {
				$("#goodsSendDiv").addClass("am-animation-fade am-animation-reverse").one($.AMUI.support.animation.end, function() {
					$("#goodsSendDiv").removeClass("am-animation-fade am-animation-reverse");
					$("#goodsSendDiv").hide();
					$("#addrMngDiv").show();
					$("#addrMngDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
						$("#addrMngDiv").removeClass("am-animation-fade");								
			        });
		        });						
			}else{
				$("#goodsSendDiv").hide();
				$("#addrMngDiv").show();
			}
		});
		
		$("input[name='goodsOrderSplitNumber']").on("change",function(){
			var v = $(this).val();
			var tv = $("#goodsAmount").val();
			if(parseInt(v)<1){
				 CommonUtils.showAlert("发货数量不能小于1!");
				 $(this).focus();
			}else if(parseInt(v)>parseInt(tv)){
				CommonUtils.showAlert("发货数量不能大于购买数量!");
				 $(this).focus();
			}
			
		});
				
		$("#acceptForm").mvalidate({
	            type:2,
	            onKeyup:true,
	            sendForm:false,
	            firstInvalidFocus:true,
	            valid:function(event,options){
	            	event.preventDefault();
	            	var revPeople =$("#acceptForm input[name='goodsOrder.rev_people']").val();
	            	 if($.trim(revPeople) == ''){
	            		 CommonUtils.showAlert("请选择收货地址!");
	            		 return false;
	            	 }
	            	 var tv = $("#goodsAmount").val();
	            	 var v = $("input[name='goodsOrderSplitNumber']").val();
	            	 if(parseInt(v)>parseInt(tv) || parseInt(v)<1){
	            		 CommonUtils.showAlert("发货数量填写错误!");
	            		 return false;
	            	 }
	                //点击提交按钮时,表单通过验证触发函数
	                 var params = CommonUtils.getParam("acceptForm",false);			                 
					 CommonUtils.invokeAsyncAction(base+'/Goods/goodsSendsAccept.do', params, function (reply) {           
		  	           
						if ((reply || '') != '') {
		  	               var code = reply._code;               
		  	               if (code == '0') {  
		  	            	   var ret = reply.ret;
		  	            	   CommonUtils.showAlert('操作成功!');
		  	            	 	setTimeout(function(){ $("#cancelSubmit").trigger("click"); }, 500);//提示后500ms跳转到订单查询结果
		  	            	   
		  	            	
		  	               } else  {
		  	            	  CommonUtils.showAlert(reply._msg);
		  	             }              
		  	           } else  {
		  	        	      CommonUtils.showAlert('操作失败!');
		  	           }
		  	         },true);					 
	                
	                return false;
	            }
	     });
		
		$("#cancelSubmit").on("click",function(){
			var params={};
			pageData.openContent("/Goods/queryUserOrder.do",params);	
			return false;
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
				$("#goodsSendDiv").show();
				$("#goodsSendDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
					$("#goodsSendDiv").removeClass("am-animation-fade");								
		        });
	        });						
		}else{
			$("#addrMngDiv").hide();
			$("#goodsSendDiv").show();
		}
	};
</script>	