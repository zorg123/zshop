<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String pUserCode = request.getParameter("puserCode")==null?"":request.getParameter("puserCode");
%>

<div class="tpl-content-wrapper">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">团队管理</a></li>
                <li class="am-active">用户注册</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span>注册信息
                    </div>
                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form" id="registerForm">
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">用户账号 </label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="am-form-field tpl-form-no-bg" db_field="user.user_code"  name="user.user_code" placeholder="请输入用户账号" />                                        
                                    </div>
                                </div> 
                                 <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">登录密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg" db_field="user.password"  name="user.password" placeholder="请输入登录密码" />                                        
                                    </div>
                                </div>
                                 <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">确认登录密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg"  name="user.confirm_password" placeholder="请输入确认登录密码" />                                        
                                    </div>
                                </div>
                                 <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">交易密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg" db_field="user.trans_pwd"  name="user.trans_pwd" placeholder="请输入交易密码" />                                        
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">确认交易密码 </label>
                                    <div class="am-u-sm-8">
                                        <input type="password" class="am-form-field tpl-form-no-bg"   name="user.confirm_trans_pwd" placeholder="请输入确认交易密码" />                                        
                                    </div>
                                </div>   
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-4 am-form-label">手机号码</label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="tpl-form-input" db_field="user.user_phone" name="user.user_phone" placeholder="请输入手机号码，为必填">                                        
                                    </div>
                                </div>
								<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">姓名 </label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="am-form-field tpl-form-no-bg" db_field="user.name"  name="user.name" placeholder="请输入用户账号" />                                        
                                    </div>
                                </div>                              
                                 <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-4 am-form-label">接点人账号</label>
                                    <div class="am-u-sm-8">
                                        <input type="text" class="am-form-field tpl-form-no-bg" db_field="user.pid" value="<%=pUserCode %>" name="user.pid" placeholder="请输入接点人账号或手机号" />                                        
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-8 am-u-sm-push-3">
                                        <button type="button" id="registerSubmit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
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
				pageData["register"](); 
			});
		</script>	