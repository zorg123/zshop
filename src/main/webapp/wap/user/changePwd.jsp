<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>

<div   data-url="/wap/user/changePwd.jsp">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">资料管理</a></li>
                <li class="am-active">密码修改</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>密码修改
                    </div>
                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form" id="changePwdForm">
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">用户账号 </label>
                                    <div class="am-u-sm-8">
                                         <span type="text" class="am-form-field tpl-form-no-bg" ><s:property value="#session.user.user_code" /></span>                                     
                                    </div>
                                </div> 
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">原登录密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg" db_field="user.old_password"  name="user.old_password" placeholder="修改登录密码时请先输入原登录密码" />
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">新登录密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg" db_field="user.password"  name="user.password" placeholder="请输入登录密码" data-pattern="[0-9]{6,6}"   data-descriptions="user.password" data-describedby="user.password-description"/>  
                                        <small id="user.password-description"></small>                                        
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">确认新登录密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg"  name="user.confirm_password" placeholder="请输入确认登录密码" data-pattern="[0-9]{6,6}" data-descriptions="user.confirm_password" data-describedby="user.confirm_password-description" data-conditional="confirmPwd"/>                                        
                                    	<small id="user.confirm_password-description"></small>  
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">原交易密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg" db_field="user.old_trans_pwd"  name="user.old_trans_pwd" placeholder="修改交易密码请先输入原交易密码" />                                        
                                    	<small id="user.trans_pwd-description"></small>  
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">新交易密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg" db_field="user.trans_pwd"  name="user.trans_pwd" placeholder="请输入交易密码" data-pattern="[0-9]{6,6}"  data-descriptions="user.trans_pwd" data-describedby="user.trans_pwd-description"/>                                        
                                    	<small id="user.trans_pwd-description"></small>  
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">确认新交易密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg"   name="user.confirm_trans_pwd" placeholder="请输入确认交易密码" data-pattern="[0-9]{6,6}"  data-descriptions="user.confirm_trans_pwd" data-describedby="user.confirm_trans_pwd-description" data-conditional="confirmTransPwd"/>                                        
                                    	<small id="user.confirm_trans_pwd-description"></small>  
                                    </div>
                                </div> 
                                <div class="am-form-group">
                                    <div class="am-u-sm-8 am-u-sm-push-3">
                                        <input type="submit" id="registerSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交"></input>                                    	
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>


            </div>










        </div>
        
      <script language="javascript" type="text/javascript" >
			$(function() {	
				$("#changePwdForm").mvalidate({
			            type:2,
			            onKeyup:true,
			            sendForm:false,
			            firstInvalidFocus:true,
			            valid:function(event,options){
			                //点击提交按钮时,表单通过验证触发函数
			                 var params = CommonUtils.getParam("changePwdForm",false);
			                 if(params["user.password"]!='' && params["user.old_password"]==''){
			                	 CommonUtils.showAlert("修改登录密码，请输入原登录密码!");
			                	 return; 
			                 }
			                 if(params["user.trans_pwd"]!='' && params["user.old_trans_pwd"]==''){
			                	 CommonUtils.showAlert("修改交易密码，请输入原交易密码!");
			                	 return; 
			                 }
			                 CommonUtils.showLoading();
							 CommonUtils.invokeAsyncAction(base+'/Sys/User/modifyPwd.do', params, function (reply) {           
				  	            CommonUtils.closeLoading();
								if ((reply || '') != '') {
				  	               var code = reply._code;               
				  	               if (code == '0') {  
				  	            	   CommonUtils.showAlert('操作成功!');
				  	            	  setTimeout(function(){ pageData["refresh"](); }, 1000);   	                   
				  	               } else  {
				  	            	  CommonUtils.showAlert(reply._msg);
				  	             }              
				  	           } else  {
				  	        	      CommonUtils.showAlert('操作失败!');
				  	           }
				  	         });
					 
			                event.preventDefault();
			                return false;
			            },
			            conditional:{
			                confirmPwd:function(val){			                	
			                	return (val==$("#changePwdForm input[name='user.password']").val()) ? true :false;
			                },
			                confirmTransPwd:function(val){			                    
			                    return (val==$("#changePwdForm input[name='user.trans_pwd']").val()) ? true :false; 
			                },
			            },
			            descriptions:{			               
			                "user.password" : {
			                    required : '<div class="field-invalidmsg">请输入登录密码</div>',
			                    pattern : '<div class="field-invalidmsg">密码格式不对，必须为6位数字</div>',
			                    valid : ''
			                },
			                "user.confirm_password":{
			                     required : '<div class="field-invalidmsg">请输入确认登录密码</div>',
			                     conditional : '<div class="field-validmsg">两次登录密码不一样</div>',
			                     pattern : '<div class="field-invalidmsg">密码格式不对，必须为6位数字</div>',
			                     valid : ''
			                },
			                "user.trans_pwd" : {
			                    required : '<div class="field-invalidmsg">请输入交易密码</div>', 
			                    pattern : '<div class="field-invalidmsg">密码格式不对，必须为6位数字</div>',
			                    valid : ''
			                },
			                "user.confirm_trans_pwd":{
			                    required : '<div class="field-invalidmsg">请输入确认交易密码</div>',
			                    conditional : '<div class="field-invalidmsg">两次交易密码不一样</div>',
			                    pattern : '<div class="field-invalidmsg">密码格式不对，必须为6位数字</div>',
			                    valid : ''
			                }
			            }
			     });
			   
				
				// $("#registerSubmit").bind("click",function(){
				//	 
				// });
				 
			});
		</script>	