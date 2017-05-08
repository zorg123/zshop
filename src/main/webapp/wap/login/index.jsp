<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>
<%
	String baseUri = request.getContextPath();	
	Long d = (new Date()).getTime();
%>
<!DOCTYPE html>
<!-- saved from url=(0044)http://user.worldviewhk.cn/index.html#/login -->
<html lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1,maximum-scale=1,minimum-scale=1" />
  <title>用户系统</title>
  <!-[if lt IE9]>   
    <script src="<%=baseUri %>/public/bootstrap/html5shiv.min.js" type="text/javascript"></script>  
  <![endif]-> 
  <link href="<%=baseUri %>/wap/login/app.709121d2ef79e972876f395a735fe6e1.css" rel="stylesheet" />
  <style type="text/css">.trans-contain[data-v-4145efda]{position:relative;width:100%;max-width:350px;margin:10% auto 0;box-sizing:border-box;perspective:800px;overflow-x:hidden}.trans-contain .el-form[data-v-4145efda]{background-color:#fff;width:100%;padding:40px;border-radius:6px;box-sizing:border-box;transform-style:preserve-3d;transition:all .8s ease-in-out 0s;-webkit-backface-visibility:hidden;backface-visibility:hidden}.trans-contain .el-form .title[data-v-4145efda]{font-weight:400;font-size:24px;margin-top:0;text-align:center;color:#20a0ff;margin-bottom:25px}.trans-contain .el-form .veri[data-v-4145efda]{height:34px;position:absolute;top:1px;right:1px;z-index:1;width:100px;border:0;border-top-right-radius:4px;border-bottom-right-radius:4px}.trans-contain .el-form .el-form-item__label[data-v-4145efda]{text-align:left}.trans-contain .el-form .btn-block[data-v-4145efda]{width:100%;margin-top:20px}.trans-contain .el-form[data-v-4145efda]:first-child{position:relative;z-index:1}.trans-contain .el-form[data-v-4145efda]:last-child{position:absolute;z-index:1;top:0;left:0;right:0;height:100%;transform:rotateY(180deg);margin-left:auto;margin-right:auto;visibility:hidden;opacity:0}.trans-contain.trans .el-form[data-v-4145efda]:first-child{transform:rotateY(-180deg);visibility:hidden;opacity:0}.trans-contain.trans .el-form[data-v-4145efda]:last-child{transform:rotateY(0);visibility:visible;opacity:1}@media (max-width:445px){.wrap-outer .trans-contain[data-v-4145efda]{padding-left:5%;padding-right:5%}.el-form[data-v-4145efda]:last-child{width:90%}}.foot[data-v-4145efda]{color:#fff;text-align:center;margin-top:20px;margin-bottom:0;font-size:1.2em}.text-right[data-v-4145efda]{text-align:right}a[data-v-4145efda]{text-decoration:none;color:#20a0ff}a[data-v-4145efda]:hover{color:#4db3ff}
/*# sourceURL=/./src/pages/Login.vue */
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi8uL3NyYy9wYWdlcy9Mb2dpbi52dWUiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQ0EsZ0NBQWdDLGtCQUFrQixXQUFXLGdCQUFnQixrQkFBa0Isc0JBQXNCLGtCQUFrQixpQkFBaUIsQ0FDdkosQUFDRCx5Q0FBeUMsc0JBQXNCLFdBQVcsYUFBYSxrQkFBa0Isc0JBQXNCLDRCQUE0QixrQ0FBa0MsbUNBQW1DLDBCQUEwQixDQUN6UCxBQUNELGdEQUFnRCxnQkFBbUIsZUFBZSxhQUFhLGtCQUFrQixjQUFjLGtCQUFrQixDQUNoSixBQUNELCtDQUErQyxZQUFZLGtCQUFrQixRQUFRLFVBQVUsVUFBVSxZQUFZLFNBQVMsNEJBQTRCLDhCQUE4QixDQUN2TCxBQUNELDhEQUE4RCxlQUFlLENBQzVFLEFBQ0Qsb0RBQW9ELFdBQVcsZUFBZSxDQUM3RSxBQUNELHFEQUFxRCxrQkFBa0IsU0FBUyxDQUMvRSxBQUNELG9EQUFvRCxrQkFBa0IsVUFBVSxNQUFNLE9BQU8sUUFBUSxZQUFZLDBCQUEwQixpQkFBaUIsa0JBQWtCLGtCQUFrQixTQUFTLENBQ3hNLEFBQ0QsMkRBQTJELDJCQUEyQixrQkFBa0IsU0FBUyxDQUNoSCxBQUNELDBEQUEwRCxxQkFBcUIsbUJBQW1CLFNBQVMsQ0FDMUcsQUFDRCx5QkFDQSw0Q0FBNEMsZ0JBQWdCLGdCQUFnQixDQUMzRSxBQUNELHFDQUFxQyxTQUFTLENBQzdDLENBQ0EsQUFDRCx1QkFBdUIsV0FBVyxrQkFBa0IsZ0JBQWdCLGdCQUFnQixlQUFlLENBQ2xHLEFBQ0QsNkJBQTZCLGdCQUFnQixDQUM1QyxBQUNELG1CQUFtQixxQkFBcUIsYUFBYSxDQUNwRCxBQUNELHlCQUF5QixhQUFhLENBQ3JDIiwiZmlsZSI6IkxvZ2luLnZ1ZSIsInNvdXJjZXNDb250ZW50IjpbIlxuLnRyYW5zLWNvbnRhaW5bZGF0YS12LTQxNDVlZmRhXXtwb3NpdGlvbjpyZWxhdGl2ZTt3aWR0aDoxMDAlO21heC13aWR0aDo0MDBweDttYXJnaW46MTAlIGF1dG8gMDtib3gtc2l6aW5nOmJvcmRlci1ib3g7cGVyc3BlY3RpdmU6ODAwcHg7b3ZlcmZsb3cteDpoaWRkZW5cbn1cbi50cmFucy1jb250YWluIC5lbC1mb3JtW2RhdGEtdi00MTQ1ZWZkYV17YmFja2dyb3VuZC1jb2xvcjojZmZmO3dpZHRoOjEwMCU7cGFkZGluZzo0MHB4O2JvcmRlci1yYWRpdXM6NnB4O2JveC1zaXppbmc6Ym9yZGVyLWJveDt0cmFuc2Zvcm0tc3R5bGU6cHJlc2VydmUtM2Q7dHJhbnNpdGlvbjphbGwgLjhzIGVhc2UtaW4tb3V0IDBzOy13ZWJraXQtYmFja2ZhY2UtdmlzaWJpbGl0eTpoaWRkZW47YmFja2ZhY2UtdmlzaWJpbGl0eTpoaWRkZW5cbn1cbi50cmFucy1jb250YWluIC5lbC1mb3JtIC50aXRsZVtkYXRhLXYtNDE0NWVmZGFde2ZvbnQtd2VpZ2h0Om5vcm1hbDtmb250LXNpemU6MjRweDttYXJnaW4tdG9wOjA7dGV4dC1hbGlnbjpjZW50ZXI7Y29sb3I6IzIwYTBmZjttYXJnaW4tYm90dG9tOjI1cHhcbn1cbi50cmFucy1jb250YWluIC5lbC1mb3JtIC52ZXJpW2RhdGEtdi00MTQ1ZWZkYV17aGVpZ2h0OjM0cHg7cG9zaXRpb246YWJzb2x1dGU7dG9wOjFweDtyaWdodDoxcHg7ei1pbmRleDoxO3dpZHRoOjEwMHB4O2JvcmRlcjowO2JvcmRlci10b3AtcmlnaHQtcmFkaXVzOjRweDtib3JkZXItYm90dG9tLXJpZ2h0LXJhZGl1czo0cHhcbn1cbi50cmFucy1jb250YWluIC5lbC1mb3JtIC5lbC1mb3JtLWl0ZW1fX2xhYmVsW2RhdGEtdi00MTQ1ZWZkYV17dGV4dC1hbGlnbjpsZWZ0XG59XG4udHJhbnMtY29udGFpbiAuZWwtZm9ybSAuYnRuLWJsb2NrW2RhdGEtdi00MTQ1ZWZkYV17d2lkdGg6MTAwJTttYXJnaW4tdG9wOjIwcHhcbn1cbi50cmFucy1jb250YWluIC5lbC1mb3JtW2RhdGEtdi00MTQ1ZWZkYV06Zmlyc3QtY2hpbGR7cG9zaXRpb246cmVsYXRpdmU7ei1pbmRleDoxXG59XG4udHJhbnMtY29udGFpbiAuZWwtZm9ybVtkYXRhLXYtNDE0NWVmZGFdOmxhc3QtY2hpbGR7cG9zaXRpb246YWJzb2x1dGU7ei1pbmRleDoxO3RvcDowO2xlZnQ6MDtyaWdodDowO2hlaWdodDoxMDAlO3RyYW5zZm9ybTpyb3RhdGVZKDE4MGRlZyk7bWFyZ2luLWxlZnQ6YXV0bzttYXJnaW4tcmlnaHQ6YXV0bzt2aXNpYmlsaXR5OmhpZGRlbjtvcGFjaXR5OjBcbn1cbi50cmFucy1jb250YWluLnRyYW5zIC5lbC1mb3JtW2RhdGEtdi00MTQ1ZWZkYV06Zmlyc3QtY2hpbGR7dHJhbnNmb3JtOnJvdGF0ZVkoLTE4MGRlZyk7dmlzaWJpbGl0eTpoaWRkZW47b3BhY2l0eTowXG59XG4udHJhbnMtY29udGFpbi50cmFucyAuZWwtZm9ybVtkYXRhLXYtNDE0NWVmZGFdOmxhc3QtY2hpbGR7dHJhbnNmb3JtOnJvdGF0ZVkoMCk7dmlzaWJpbGl0eTp2aXNpYmxlO29wYWNpdHk6MVxufVxuQG1lZGlhIChtYXgtd2lkdGg6IDQ0NXB4KXtcbi53cmFwLW91dGVyIC50cmFucy1jb250YWluW2RhdGEtdi00MTQ1ZWZkYV17cGFkZGluZy1sZWZ0OjUlO3BhZGRpbmctcmlnaHQ6NSVcbn1cbi5lbC1mb3JtW2RhdGEtdi00MTQ1ZWZkYV06bGFzdC1jaGlsZHt3aWR0aDo5MCVcbn1cbn1cbi5mb290W2RhdGEtdi00MTQ1ZWZkYV17Y29sb3I6I2ZmZjt0ZXh0LWFsaWduOmNlbnRlcjttYXJnaW4tdG9wOjIwcHg7bWFyZ2luLWJvdHRvbTowO2ZvbnQtc2l6ZToxLjJlbVxufVxuLnRleHQtcmlnaHRbZGF0YS12LTQxNDVlZmRhXXt0ZXh0LWFsaWduOnJpZ2h0XG59XG5hW2RhdGEtdi00MTQ1ZWZkYV17dGV4dC1kZWNvcmF0aW9uOm5vbmU7Y29sb3I6IzIwYTBmZlxufVxuYVtkYXRhLXYtNDE0NWVmZGFdOmhvdmVye2NvbG9yOiM0ZGIzZmZcbn1cbiJdLCJzb3VyY2VSb290Ijoid2VicGFjazovLyJ9 */</style>
  <style type="text/css">
   .boxBG{
		background: -webkit-gradient(linear, 0% 0%, 100% 0%, from(rgb(110, 192, 252)), to(rgb(255, 99, 233))); /** Chrome Safari **/
		
		background: -moz-linear-gradient(left, #6EC0FC, #FF63E9); /** FireFox **/
		
		background: -o-linear-gradient(left, #6EC0FC, #FF63E9);/** Opear **/ 
		
		background: -ms-linear-gradient(left,#6EC0FC 0%,#FF63E9 100%);/** IE9 IE10 **/
		
		filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6EC0FC',endColorstr='#FF63E9',grandientType=0); /** IE7 **/ 
		
		-ms-filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#6EC0FC',endColorstr='#FF63E9',grandientType=0); /** IE8 **/
	}
  </style>
<script language="javascript" type="text/javascript" >
	var base="<%=baseUri%>";
</script>
 </head>
 <body>
  <div id="app">
   <div data-v-4145efda="" class="wrap-outer">
    <div data-v-4145efda="" class="trans-contain">
     <form class="el-form" data-v-4145efda="">
      <h5 data-v-4145efda="" class="title">用户系统</h5> 
      <div class="el-form-item is-required" data-v-4145efda="">
       <div class="el-form-item__content">
        <div class="login-sub-Key el-input" data-v-4145efda="">       
         <input type="text" name="user_name" placeholder="请输入账号" autocomplete="off" class="el-input__inner" />        
        </div>       
       </div>
      </div> 
      <div class="el-form-item is-required" data-v-4145efda="">      
       <div class="el-form-item__content">
        <div class="login-sub-Key el-input" data-v-4145efda="">        
         <input type="password" name="user_pass" placeholder="请输入密码" autocomplete="off" class="el-input__inner" />       
        </div>     
       </div>
      </div> 
      <div class="el-form-item is-required" data-v-4145efda="">       
       <div class="el-form-item__content">
        <div class="login-sub-Key el-input" data-v-4145efda="">       
         <input type="text" name="valid_code" placeholder="请输入验证码" autocomplete="off" class="el-input__inner" />        
        </div> 
        <img data-v-4145efda="" id="veri" src="<%=baseUri%>/public/vc.jsp" alt="" onclick="javascript:this.src='<%=baseUri%>/public/vc.jsp?time='+Math.random()" class="veri" style="cursor:pointer" />
        
       </div>
      </div> 
      <div class="el-row" data-v-4145efda="">
       <div class="el-col el-col-12" data-v-4145efda="">
          <label class="el-checkbox" data-v-4145efda="">
        	<span class="el-checkbox__input is-checked">
        		<span class="el-checkbox__inner"></span>
        			<input type="checkbox" class="el-checkbox__original" value="" />
        		</span>
        		<span class="el-checkbox__label">记住我</span>
          </label>
       </div>        
      </div> 
      <div class="el-row" data-v-4145efda="">
       <div class="el-col el-col-24" data-v-4145efda="">
        <button type="button" id="login_btn" class="el-button btn-block el-button--primary" data-v-4145efda="">         
         <span>登录</span></button>
       </div>
      </div>
     </form> 
     <form class="el-form" data-v-4145efda="">
      
     </form>
    </div> 
    <p data-v-4145efda="" class="foot">Copyright All Rights Reserved. &copy; 2006-2017</p>
   </div> 
   <section id="pageBg" class="row">
    <div id="canvas" class="boxBG"  >
     <canvas width="1365" height="633" style="width: 1821px; height: 844px;"></canvas>
    </div>
   </section>
  </div>  
  <script src="<%=baseUri %>/wap/assets/js/jquery.min.js"></script>
  <script type="text/javascript" src="<%=baseUri %>/public/common/ress/js/jquery.cookie.js"></script>   
  <script src="<%=baseUri %>/wap/assets/js/CommonUtils.js"></script>
  <script src="<%=baseUri %>/wap/assets/js/layer.js"></script>
  <script src="<%=baseUri %>/wap/login/login.js?d=<%=d %>"></script>
 </body>
</html>