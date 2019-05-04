<%@page import="com.flyrui.dao.pojo.sys.User"%>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
	String userType="";
	if(request.getSession().getAttribute("user")!=null){
		User currentUser =  (User)request.getSession().getAttribute("user");
		userType = currentUser.getUser_type();
	}
	
%>
<s:if test="#session.user.user_level == 0">    
    <s:set name="userLevelName" value="'未激活'" />      
</s:if>
<s:if test="#session.user.user_level == 1">    
    <s:set name="userLevelName" value="'普通会员'" />      
</s:if>
<s:if test="#session.user.user_level == 2">    
    <s:set name="userLevelName" value="'vip会员'" />      
</s:if>
<s:if test="#session.user.user_level == 3">    
    <s:set name="userLevelName" value="'经理'" />      
</s:if>
<s:if test="#session.user.user_level == 4">    
    <s:set name="userLevelName" value="'总监'" />      
</s:if>
<s:if test="#session.user.user_level == 5">    
    <s:set name="userLevelName" value="'总裁'" />      
</s:if>
<s:if test="#session.user.user_level == 6">    
    <s:set name="userLevelName" value="'合伙人'" />      
</s:if>
<jsp:include page="/wap/common/head.jsp"><jsp:param value="index" name="data-type"/></jsp:include>
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="<%=baseUri %>/wap/assets/img/myLogo.png" alt="">
        </a>
    </div> 
    <button class="am-btn am-btn-sm am-btn-success" id="menuToggle">
    	<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
   </button>
       
    <div class="am-fr am-margin-right">
          <ul class="am-nav am-nav-pills am-topbar-nav  admin-header-list tpl-header-list">
  			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                  <a class="am-dropdown-toggle tpl-header-list-link am-inline" href="javascript:;">
                      <span class="tpl-header-list-user-nick">
                      	<s:property value="#session.user.user_code" />
                      </span>
                      <span class="tpl-header-list-user-ico am-show-lg-only ">
                        <s:if test="#session.user.head_img == null">
                       		<img src="<%=baseUri %>/wap/assets/img/user01.png">
                       	</s:if>
                       	<s:else>
                       	    <img src="<%=baseUri %><s:property value='#session.user.head_img' />">
                       	</s:else>
                      </span>
                  </a>
                  <ul class="am-dropdown-content">
                  	  <li><a href="javascript:void(0);" onclick="pageData.genSubUser(this);"><span class="am-icon-users"></span>&nbsp;&nbsp;切换账号</a></li>
                      <li><a href="javascript:void(0);" onclick="pageData.loginOut(this);"><span class="am-icon-power-off"></span>&nbsp;&nbsp;退出</a></li>
                  </ul>
              </li>                
          </ul>
          <!--   <button class="am-btn am-btn-sm am-btn-success " id="menuToggle"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button> -->
    </div>
    <!-- <div class="am-fr am-margin-right">
    	
	</div> -->
  
    
</header>

<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-left-nav tpl-left-nav-hover " id="menu-collapse">
        <div class="tpl-left-nav-title">
           	功能列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
               <li class="tpl-left-nav-item" id="menu<s:property value="#menu.menu_id" />">
	               	<a href="javascript:void(0);" onclick="pageData.openIndex(this);" url="/Sys/Sys!index.do" class="nav-link active">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>                   
                     
               </li>
	           <s:iterator  value="menuList"  id="menu" status="st">	
	               <li class="tpl-left-nav-item" id="menu<s:property value="#menu.menu_id" />">
	               	 <a class="nav-link tpl-left-nav-link-list">
                        <i class="<s:property value="#menu.icon_class" escape="false" default="am-icon-square"/>"></i>
                        <span><s:property value="#menu.menu_name" escape="false"/></span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                   
                    <ul class="tpl-left-nav-sub-menu">
                        <s:iterator  value="#menu.sub_menu_list"  id="subMenu">
                           <%--未激活用户不显示拼团抢购 --%>
                           <s:if test="#session.user.state == 1 || (#session.user.state == 0 && #subMenu.menu_name !='拼团商品') ">    
         						<li id="tree<s:property value="#subMenu.menu_id" />" >
		                    		<a href="javascript:void(0);" url="<s:property value="#subMenu.menu_url" />" menuId="tree<s:property value="#subMenu.menu_id" />">
		                                <i class="am-icon-angle-right"></i>
		                                <span><s:property value="#subMenu.menu_name" escape="false"/></span>
		                                <i class="tpl-left-nav-content-ico am-fr am-margin-right"></i>
		                            </a>
	                    		</li>
							</s:if>
	                    	
                    	</s:iterator>
                    </ul>	  
                   </li>     			
	       		</s:iterator>
	       		<li class="tpl-left-nav-item" id="menu<s:property value="#menu.menu_id" />">
	               	<a href="javascript:void(0);" onclick="pageData.loginOut(this);" url="/wap/index/index.jsp" class="nav-link">
                        <i class="am-icon-power-off"></i>
                        <span>退出</span>
                    </a>                   
                     
               </li>
        	</ul>        
            
        </div>
    </div>
	<div id="mainContent" class="tpl-content-wrapper">
    </div>
    <script language="javascript" type="text/javascript" >
    	var userType = "<%=userType%>";
		$(function() {
			if(window.location.hash !=''){				
	    		var ha = window.location.hash.substring(1)
	        	var o = base64.decode(ha).split(";"); 
	    		pageData.openContent(o[1], null, o[0]);
	    	}else{
				pageData.openContent("/Sys/Sys!index.do");
	    	}
			
		});
	</script>
</div>
<jsp:include page="/wap/common/footer.jsp"></jsp:include>