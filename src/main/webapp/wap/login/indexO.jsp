<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>
<%
	String baseUri = request.getContextPath();	
	Long d = (new Date()).getTime();
%>
<jsp:include page="/wap/common/head.jsp"></jsp:include>
<script language="javascript" type="text/javascript" >
	var base="<%=baseUri%>";
</script>
<body >
  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				System<span> Login</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<i> 登录 </i> 
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form"> 
				<fieldset>
					<div class="am-form-group">
						<input type="text" class="" name="user_name" id="user_name" placeholder="请输入登录名">
					</div>
					<div class="am-form-group">
						<input type="password" class="" name="user_pass" id="user_pass" placeholder="请输入密码">
					</div>
					<div class="am-input-group am-login-input-group">
						<input type="text" class="" name="valid_code" placeholder="请输入验证码"><span  class="am-input-group-label am-login-input-group-label"><img id="valid_code_img" src="<%=baseUri%>/public/image.jsp" style="cursor:pointer;padding-top:3px" onclick="javascript:this.src='<%=baseUri%>/public/image.jsp?d='+(new Date());"></span>
					</div>
					<p><a  href="javascript:void(0);" id="login_btn" class="am-btn am-btn-default">登录</a></p>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<script src="<%=baseUri %>/wap/login/login.js?d=<%=d %>"></script>
<jsp:include page="/wap/common/footer.jsp"></jsp:include>