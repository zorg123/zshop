<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>

<div data-url="/FinancMgmt/getAccountInfo.do">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">资料管理</a></li>
                <li class="am-active">资料查看</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>资料信息
                    </div>
                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form" id="accountfileForm">
                            	<div class="am-form-group">
                                    <label for="accoutInfo-account_bank" class="am-u-sm-4 am-form-label">开户银行</label>
                                    <div class="am-u-sm-8">
                                        <select db_field="accoutInfo.account_bank" value="<s:property value="accoutInfo.account_bank" />" name="accoutInfo.account_bank" id="account_bank">
										  <option value="1">工商银行</option>
										  <option value="2">建设银行</option>
										  <option value="3">农业银行</option>
										  <option value="4">中国银行</option>
										  <option value="5">支付宝</option>
										</select>	
                                    </div>
                                </div>
                                
                                <div class="am-form-group" id="bankBrcDiv">
                                    <label for="accoutInfo-account_bank_brc" class="am-u-sm-4 am-form-label">开户支行</label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="tpl-form-input" db_field="accoutInfo.account_bank_brc" name="accoutInfo.account_bank_brc" placeholder="请输入开户支行，为必填"  data-descriptions="accoutInfo.account_bank_brc" data-describedby="accoutInfo.account_bank_brc-description" value="<s:property value="accoutInfo.account_bank_brc" />"/>                                        
                                    	<small id="accoutInfo.account_bank_brc-description"></small>  
                                    </div>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="accoutInfo-account_id" class="am-u-sm-4 am-form-label" id="bankNameLabel">银行账号</label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="tpl-form-input" db_field="accoutInfo.account_id" name="accoutInfo.account_id" placeholder="请输入银行账号，为必填" data-required="true" data-descriptions="accoutInfo.account_id" data-describedby="accoutInfo.account_id-description" value="<s:property value="accoutInfo.account_id" />"/>                                        
                                    	<small id="accoutInfo.account_id-description"></small>  
                                    </div>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="accoutInfo-account_name" class="am-u-sm-4 am-form-label" id="bankPersonName">开户人姓名</label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="tpl-form-input" db_field="accoutInfo.account_name" name="accoutInfo.account_name" placeholder="请输入开户人姓名，为必填" data-required="true" data-descriptions="accoutInfo.account_name" data-describedby="accoutInfo.account_name-description" value="<s:property value="accoutInfo.account_name" />"/>                                        
                                    	<small id="accoutInfo.account_name-description"></small>  
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

        </div>
        
      <script language="javascript" type="text/javascript" >
      		function showZhifuBaoTip(){
      			$("#bankBrcDiv").hide();
      			$("#bankNameLabel").html("支付宝账号");
      			$("#bankPersonName").html("账号姓名");
      		}
      		function showOtherBankTip(){
      			$("#bankBrcDiv").show();
      			$("#bankNameLabel").html("银行账号");
      			$("#bankPersonName").html("开户人姓名");
      		}
      		<s:if test="accoutInfo.account_bank == 5" >
      			showZhifuBaoTip();
      		</s:if>
      		
			$(function() {	
				
				 $("#account_bank").on("change",function(){
					 var $this = $(this);
					 if($this.val()==5){
						 showZhifuBaoTip();
					 } else{
						 showOtherBankTip();
					 }
				 });
				
				 
				$("#accountfileForm").mvalidate({
			            type:2,
			            onKeyup:true,
			            sendForm:false,
			            firstInvalidFocus:true,
			            valid:function(event,options){
			                //点击提交按钮时,表单通过验证触发函数
			                 var params = CommonUtils.getParam("accountfileForm",false);
			                 params["accoutInfo.account_bank"] = $("#account_bank").val();
			                 if($("#account_bank").val()!=5){
			                	 if(params["accoutInfo.account_bank_brc"] ==""){
			                		 CommonUtils.showAlert(' 请输入开户支行');
			                		 return false;
			                	 }
			                 }
			                 CommonUtils.showLoading();
							 CommonUtils.invokeAsyncAction(base+'/FinancMgmt/updateAccountInfo.do', params, function (reply) {           
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
			            descriptions:{	
			            	"accoutInfo.account_bank_brc":{
			            		required : '<div class="field-invalidmsg">请输入开户支行</div>',
			            		valid : ''
			            	},
			            	"accoutInfo.account_id":{
			            		required : '<div class="field-invalidmsg">请输入银行账号</div>',
			            		valid : ''
			            	},
			            	"accoutInfo.account_name":{
			            		required : '<div class="field-invalidmsg">请输入开户人姓名</div>',
			            		valid : ''
			            	}
			            }
			     });
				//$('select[data-am-selected]').selected({
				//    selectBox:3
				//});
				var selected = '<s:property value="accoutInfo.account_bank" />';
				$("#account_bank").val(selected);
			});
		</script>