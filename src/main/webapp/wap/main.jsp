<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
%>
<jsp:include page="/wap/common/head.jsp"><jsp:param value="index" name="data-type"/></jsp:include>

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="<%=baseUri %>/wap/assets/img/myLogo.png" alt="">
        </a>
    </div>    
    <div class="am-fr am-margin-right">
    	<button class="am-btn am-btn-sm am-btn-success " id="menuToggle"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
	</div>
    
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
                        <i class="am-icon-home"></i>
                        <span><s:property value="#menu.menu_name" escape="false"/></span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                   
                    <ul class="tpl-left-nav-sub-menu">
                        <s:iterator  value="#menu.sub_menu_list"  id="subMenu">
	                    	<li id="tree<s:property value="#menu.menu_id" />" >
	                    		<a href="javascript:void(0);" url="<s:property value="#subMenu.menu_url" />" >
	                                <i class="am-icon-angle-right"></i>
	                                <span><s:property value="#subMenu.menu_name" escape="false"/></span>
	                                <i class="tpl-left-nav-content-ico am-fr am-margin-right"></i>
	                            </a>
	                    	</li>
                    	</s:iterator>
                    </ul>	  
                   </li>     			
	       		</s:iterator>
	       		<li class="tpl-left-nav-item" id="menu<s:property value="#menu.menu_id" />">
	               	<a href="javascript:void(0);" onclick="pageData.loginOut(this);" url="/wap/index/index.jsp" class="nav-link">
                        <i class="am-icon-key"></i>
                        <span>退出</span>
                    </a>                   
                     
               </li>
        	</ul>        
            
        </div>
    </div>
	<div id="mainContent" class="tpl-content-wrapper">
    </div>
    <script language="javascript" type="text/javascript" >
		$(function() {
			pageData.openContent("/Sys/Sys!index.do");
		});
	</script>
</div>
<jsp:include page="/wap/common/footer.jsp"></jsp:include>