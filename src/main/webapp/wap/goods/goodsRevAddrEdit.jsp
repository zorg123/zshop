<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>
<s:if test="goodsRevAddr.addr_id == null">    
    <s:set name="funcName" value="'新增收货地址'" />      
</s:if>
<s:if test="goodsRevAddr.addr_id != null">    
    <s:set name="funcName" value="'修改收货地址'" />      
</s:if>
 <div>
      <div class="portlet-title">
          <div class="caption font-green bold">
              <span class="am-icon-code"></span>
          </div>
      </div>

      <div class="tpl-block">

          <div class="am-g">
              <div class="tpl-form-body tpl-form-line">
                  <form class="am-form tpl-form-line-form" id="userProfileForm">
                      <div class="am-form-group">
                          <label for="user-email" class="am-u-sm-4 am-form-label">用户账号 </label>
                          <div class="am-u-sm-8">
                              <span type="text" class="am-form-field tpl-form-no-bg" ><s:property value="user.user_code" /></span> 
                          </div>
                      </div> 
                      <div class="am-form-group">
                          <label for="user-email" class="am-u-sm-4 am-form-label">姓名 </label>
                          <div class="am-u-sm-8">
                              <span type="text" class="am-form-field tpl-form-no-bg"><s:property value="user.name" /></span>
                          </div>
                      </div>                                  
                      <div class="am-form-group">
                          <label for="user-name" class="am-u-sm-4 am-form-label">手机号码</label>
                          <div class="am-u-sm-8">
                              <input type="text" class="tpl-form-input" data-validate="phone" db_field="user.user_phone" name="user.user_phone" placeholder="请输入手机号码，为必填" data-required="true" data-descriptions="user.user_phone" data-describedby="user.user_phone-description" value="<s:property value="user.user_phone" />"/>                                        
                          	<small id="user.user_phone-description"></small>  
                          </div>
                      </div>
                            
                      <div class="am-form-group">
                          <label for="user-email" class="am-u-sm-4 am-form-label">邮箱</label>
                          <div class="am-u-sm-8">
                              <input type="text" class="am-form-field tpl-form-no-bg" db_field="user.mail" value="<s:property value="user.mail" />" name="user.mail" placeholder="请输入邮箱" data-pattern="[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$" data-descriptions="user.mail" data-describedby="user.mail-description"/>                                        
                          	<small id="user.mail-description"></small>  
                          </div>
                      </div>
                      
                      <div class="am-form-group">
                          <label for="user-phone" class="am-u-sm-4 am-form-label">证件类型</label>
                          <div class="am-u-sm-8">
                              <select data-am-selected="" db_field="user.cert_type" value="<s:property value="user.cert_type" />" name="user.cert_type"  data-descriptions="user.cert_type" data-describedby="user.cert_type-description">
  <option value="1" <s:if test="user.cert_type == 1">selected </s:if>>身份证</option>
  <option value="2" <s:if test="user.cert_type == 2">selected </s:if>>军官证</option>
</select>	
<small id="cert_type-description"></small>									
                          </div>
                      </div>
                      
                      <div class="am-form-group">
                          <label for="user-email" class="am-u-sm-4 am-form-label">证件号码</label>
                          <div class="am-u-sm-8">
                              <input type="text" class="am-form-field tpl-form-no-bg" db_field="user.cert_id" value="<s:property value="user.cert_id" />" name="user.cert_id" placeholder="请输入证件号码" />                                        
                           </div>
                      </div>
                     <div class="am-form-group  am-cf">
                          <label for="user-weibo" class="am-u-sm-4 am-form-label">头像 </label>
                          <div class="am-u-sm-8">
                              <div class="am-form-group am-form-file  am-cf">
                                  <div class="tpl-form-file-img  am-cf">
                                      <img src="<%=baseUri %><s:property value="user.head_img" />" id="up-img-touch" class="am-circle" alt="点击图片上传" >
                                  </div>  
                                 <small> <div>请点击图片修改头像</div> </small>  
                                 <input type="hidden" db_field="user.head_img" value="<s:property value="user.head_img" />" name="user.head_img" />                                       
                              </div>
                          </div>
                      </div>

                      <div class="am-form-group">
                          <div class="am-u-sm-8 am-u-sm-push-3">
                              <input type="submit" id="userProfileSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交"></input>                                    	
                          </div>
                      </div>
                  </form>

              </div>
          </div>
      </div>
  </div>

        
        
      <script language="javascript" type="text/javascript" >
			$(function() {	
				$("#userProfileForm").mvalidate({
			            type:2,
			            onKeyup:true,
			            sendForm:false,
			            firstInvalidFocus:true,
			            valid:function(event,options){
			                //点击提交按钮时,表单通过验证触发函数
			                 var params = CommonUtils.getParam("userProfileForm",false);			                 
							 CommonUtils.invokeAsyncAction(base+'/Sys/User/ModifyUser.do', params, function (reply) {           
				  	           
								if ((reply || '') != '') {
				  	               var code = reply._code;               
				  	               if (code == '0') {  
				  	            	   CommonUtils.showAlert('操作成功!');
				  	            	   pageData["refresh"]();   	                   
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
		</script>	