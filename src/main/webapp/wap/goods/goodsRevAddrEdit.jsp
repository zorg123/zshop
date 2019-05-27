<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>
<s:set name="areaMap" value="result.ret"/>
<s:if test="goodsRevAddr.addr_id == null">    
    <s:set name="funcName" value="'新增收货地址'" />      
</s:if>
<s:if test="goodsRevAddr.addr_id != null">    
    <s:set name="funcName" value="'修改收货地址'" />      
</s:if>
  <div>
      <div class="portlet-title">
          <div class="caption font-green bold">
              <span class="am-icon-code"></span><s:property value="funcName" />
          </div>
      </div>

      <div class="tpl-block">

          <div class="am-g">
              <div class="tpl-form-body tpl-form-line">
                  <form class="am-form tpl-form-line-form" id="goodsRevAddrForm" >
                  	  <input type="hidden" db_field="goodsRevAddr.addr_id"  value="<s:property value="goodsRevAddr.addr_id" />" name="goodsRevAddr.addr_id" />
                      <div class="am-form-group">
                          <label for="user-email" class="am-u-sm-3 am-form-label">收货人 </label>
                          <div class="am-u-sm-9">                              
                              <input type="text" class="am-form-field tpl-form-no-bg" db_field="goodsRevAddr.rev_people" data-required="true" value="<s:property value="goodsRevAddr.rev_people" />" name="goodsRevAddr.rev_people" placeholder="请输入收货人" data-descriptions="goodsRevAddr.rev_people" data-describedby="goodsRevAddr.rev_people-description"/>
                           	  <small id="goodsRevAddr.rev_people-description"></small>
                           </div>
                      </div> 
                      <div class="am-form-group">
                          <label for="user-email" class="am-u-sm-3 am-form-label">联系电话 </label>
                          <div class="am-u-sm-9">                             
                              	<input type="text" class="am-form-field tpl-form-no-bg" db_field="goodsRevAddr.rev_link_phone"  data-required="true"  value="<s:property value="goodsRevAddr.rev_link_phone" />" name="goodsRevAddr.rev_link_phone" placeholder="请输入收货人联系电话" data-pattern="\d{11}" data-descriptions="goodsRevAddr.rev_link_phone" data-describedby="goodsRevAddr.rev_link_phone-description"/>
                                <small id="goodsRevAddr.rev_link_phone-description"></small>
                          </div>
                      </div>                                  
                      <div class="am-form-group">
                          <label for="user-name" class="am-u-sm-3 am-form-label">联系地址</label>
                          <div class="am-u-sm-9">
								<div class="am-form-group">
									<div class="am-u-md-6 am-u-lg-4 am-u-sm-12" style="padding-top:10px;padding-left:0px;">
	                                <select id="provSel" data-am-selected  db_field="goodsRevAddr.rev_provice" value="<s:property value="goodsRevAddr.rev_provice" />" name="goodsRevAddr.rev_provice"  data-descriptions="goodsRevAddr.rev_provice" data-describedby="goodsRevAddr.rev_provice-description" data-am-dropdown="{boundary: '#provSel'}" use_text="true">
		  								<s:iterator  value="#areaMap.prov"  id="provIter" status="st"> 
		  									<option value="<s:property value="#provIter.id" />" <s:if test="goodsRevAddr.rev_provice == #provIter.name">selected </s:if>><s:property value="#provIter.name" /></option>
		  								</s:iterator>  								
								 	</select>
								 	</div>
								 	<div class="am-u-md-6 am-u-lg-4 am-u-sm-12" style="padding-top:10px;padding-left:0px;">
								 	<select id="zoneSel" data-am-selected db_field="goodsRevAddr.rev_city" value="<s:property value="goodsRevAddr.rev_city" />" name="goodsRevAddr.rev_city"  data-descriptions="goodsRevAddr.rev_city" data-describedby="goodsRevAddr.rev_city-description" use_text="true">
		  								<s:iterator  value="#areaMap.zone"  id="provIter" status="st"> 
		  									<option value="<s:property value="#provIter.id" />" <s:if test="goodsRevAddr.rev_city == #provIter.name">selected </s:if>><s:property value="#provIter.name" /></option>
		  								</s:iterator>  								
								 	</select>
								 	</div>
								 	<div class="am-u-md-6 am-u-lg-4 am-u-sm-12" style="padding-top:10px;padding-left:0px;">
								 	<select id="xianSel" data-am-selected db_field="goodsRevAddr.rev_zone" value="<s:property value="goodsRevAddr.rev_zone" />" name="goodsRevAddr.rev_zone"  data-descriptions="goodsRevAddr.rev_zone" data-describedby="goodsRevAddr.rev_zone-description" use_text="true">
		  								<s:iterator  value="#areaMap.xian"  id="provIter" status="st"> 
		  									<option value="<s:property value="#provIter.id" />" <s:if test="goodsRevAddr.rev_zone == #provIter.name">selected </s:if>><s:property value="#provIter.name" /></option>
		  								</s:iterator>  								
								 	</select>	
								 	</div>
								 </div>
								 	<input type="text" class="am-form-field tpl-form-no-bg" db_field="goodsRevAddr.rev_addr" data-required="true"   value="<s:property value="goodsRevAddr.rev_addr" />" name="goodsRevAddr.rev_addr" placeholder="请输入详细地址" data-descriptions="goodsRevAddr.rev_addr" data-describedby="goodsRevAddr.rev_addr-description"/>						                               
                              	<small id="goodsRevAddr.rev_addr-description"></small>  
                          </div>
                      </div>               
                                           
                      
                      <div class="am-form-group">
                          <div class="am-u-sm-8 am-u-sm-push-3">
                              <input type="submit" id="userProfileSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交"></input>  
                              <input type="button" id="goBackBtn" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="返回"></input>  
                                                              	
                          </div>
                      </div>
                  </form>

              </div>
          </div>
      </div>
  </div>

        
        
      <script language="javascript" type="text/javascript" >
			$(function() {	
				
				$("#provSel").on('change', function() {					
					var provId = $(this).val();
					var params={};
					params["ids"]=provId;
					CommonUtils.invokeAsyncAction(base+'/Goods/getNextLevelAddr.do', params, function (reply) {
						if ((reply || '') != '') {
		  	               var code = reply._code;               
		  	               if (code == '0') {  
		  	            	 $("#zoneSel").empty();
		  	            	 var result = reply.ret;
		  	            	 for(var o in result){
		  	            		$("#zoneSel").append('<option value="' + result[o].id +'"> ' + result[o].name + '</option>');  
		  	            	 }
		  	            	 if (!$.AMUI.support.mutationobserver) {
		  	            		$("#zoneSel").trigger('changed.selected.amui');
		  	                 }                  
		  	               } else  {
		  	            	  CommonUtils.showAlert(reply._msg);
		  	             }              
		  	           } else  {
		  	        	   CommonUtils.showAlert('查询失败，请重试!');
		  	           }
		  	         });
                 });
				
				$("#zoneSel").on('change', function() {					
					var zoneId = $(this).val();
					var params={};
					params["ids"]=zoneId;
					CommonUtils.invokeAsyncAction(base+'/Goods/getNextLevelAddr.do', params, function (reply) {
						if ((reply || '') != '') {
		  	               var code = reply._code;               
		  	               if (code == '0') {  
		  	            	 $("#xianSel").empty();
		  	            	 var result = reply.ret;
		  	            	 for(var o in result){
		  	            		$("#xianSel").append('<option value="' + result[o].id +'"> ' + result[o].name + '</option>');  
		  	            	 }
		  	            	 if (!$.AMUI.support.mutationobserver) {
		  	            		$("#xianSel").trigger('changed.selected.amui');
		  	                 }                  
		  	               } else  {
		  	            	  CommonUtils.showAlert(reply._msg);
		  	             }              
		  	           } else  {
		  	        	   CommonUtils.showAlert('查询失败，请重试!');
		  	           }
		  	         });
                 });
	
				
				$("#goodsRevAddrForm").mvalidate({
			            type:2,
			            onKeyup:true,
			            sendForm:false,
			            firstInvalidFocus:true,
			            valid:function(event,options){
			                //点击提交按钮时,表单通过验证触发函数
			                 var params = CommonUtils.getParam("goodsRevAddrForm",false);			                 
							 CommonUtils.invokeAsyncAction(base+'/Goods/goodsRevAddrUpdate.do', params, function(reply) {           
				  	           
								if ((reply || '') != '') {
				  	               var code = reply._code;               
				  	               if (code == '0') {  
				  	            	   CommonUtils.showAlert('操作成功!');	
				  	            	   if(jump){jump()};
				  	            	  if(goBack){goBack()};
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
			            	"goodsRevAddr.rev_link_phone":{
			                    required : '<div class="field-invalidmsg">请输入手机号码</div>',
			                    pattern : '<div class="field-invalidmsg">您输入的手机号码格式不正确</div>',
			                    valid : ''
			                },
			                "goodsRevAddr.rev_people":{
			                	required : '<div class="field-invalidmsg">请输入收货人</div>',
			                    valid : ''
			                },
			                "goodsRevAddr.rev_addr":{
			                	required : '<div class="field-invalidmsg">请输入收货人地址</div>',
			                    valid : ''
			                }
			            }
			     });
			   
				
				$('select[data-am-selected]').selected({
				    selectBox:1,
					maxHeight: 150
				});
				$("#goBackBtn").on("click",function(){
					if(goBack){
						goBack();
					}
				});
			});
		</script>	