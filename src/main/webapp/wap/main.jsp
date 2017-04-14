<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
%>
<jsp:include page="/wap/common/head.jsp"><jsp:param value="index" name="data-type"/></jsp:include>

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="<%=baseUri %>/wap/assets/img/logo.png" alt="">
        </a>
    </div>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-comment-o"></span> 公告 <span class="am-badge tpl-badge-danger am-round">9</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-danger">9</span> 条新消息</h3><a href="###">全部</a></li>
                    <li>
                        <a href="#" class="tpl-dropdown-content-message">
                            <span class="tpl-dropdown-content-photo">
                  <img src="<%=baseUri %>/wap/assets/img/user02.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                  <span class="tpl-dropdown-content-from"> <s:property value="#session.user.name"/> </span>
                            <span class="tpl-dropdown-content-time">10分钟前 </span>
                            </span>
                            <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
                        </a>
                        <a href="#" class="tpl-dropdown-content-message">
                            <span class="tpl-dropdown-content-photo">
                  <img src="<%=baseUri %>/wap/assets/img/user03.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                  <span class="tpl-dropdown-content-from"> Steam </span>
                            <span class="tpl-dropdown-content-time">18分钟前</span>
                            </span>
                            <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>
                        </a>
                    </li>

                </ul>
            </li>
           
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick"><s:property value="#session.user.name"/></span><span class="tpl-header-list-user-ico"> <img src="<%=baseUri %>/wap/assets/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
        </ul>
    </div>
</header>

<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
           	功能列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
               <li class="tpl-left-nav-item" id="menu<s:property value="#menu.menu_id" />">
	               	<a href="javascript:void(0);" onclick="pageData.openIndex();" url="/wap/index/index.jsp" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
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
        	</ul>        
            
        </div>
    </div>
	<div id="mainContent">
		<div class="tpl-content-wrapper">
        <!-- <div class="tpl-content-page-title">
            Amaze UI 首页组件
        </div> -->
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-active">首页</a></li>
        </ol>
        
        <div class="row">
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat blue">
                    <div class="visual">
                        <i class="am-icon-comments-o"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 1349 </div>
                        <div class="desc"> 奖金币 </div>
                    </div>
                    <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i>
            </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat red">
                    <div class="visual">
                        <i class="am-icon-bar-chart-o"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 120 </div>
                        <div class="desc"> 电子币 </div>
                    </div>
                    <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i>
            </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat green">
                    <div class="visual">
                        <i class="am-icon-apple"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 653 </div>
                        <div class="desc"> 重消币 </div>
                    </div>
                    <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i>
            </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat purple">
                    <div class="visual">
                        <i class="am-icon-android"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 786 </div>
                        <div class="desc"> 奖金</div>
                    </div>
                    <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i>
            </a>
                </div>
            </div>



        </div>
        
        <div class="row">           
             <div class="am-u-md-6 am-u-sm-12 row-mb">
               <div class="tpl-portlet">
                 <div class="tpl-portlet-title">
                     <div class="tpl-caption font-green ">
                         <span>公告</span>
                     </div>
                 </div>

                 <div class="am-tabs tpl-index-tabs" >                            
                      <div class="am-tab-panel am-fade am-in am-active" >
                             <div id="wrapperA" class="wrapper">
                                 <div id="scroller" class="scroller">
                                     <ul id="noticeContent" class="tpl-task-list tpl-task-remind">
                                                                              
                                     </ul>
                                 </div>
                             </div>
                         </div> 
                     </div>
                   </div>
               </div>                
         </div>            
		</div>
		    
		<div id="noticeDetail" style="display:none" class="notie_detail">
		  <div class="layout">
		  <div class="section news-section">
		      <div class="container">
				  <div class="am-u-md-9">
				    <div class="article">
				    	<header class="article--header">
				           <h2 class="article--title"><span id="detailTitle"></span></h2>
				           <ul class="article--meta">
				             <li class="article--meta_item"><i class="am-icon-calendar"></i><span id="detailTime"></li>
				           </ul>
				         </header>
				         <div class="article--content" id="detailContent" >
				         </div>
				    </div>
				  </div>
				 </div>
			</div>
			</div>	
		  <div><a class="am-btn am-btn-primary am-round" href="javascript:;" onclick="layer.closeAll();"> 关闭</a></div>
		</div>
		<script language="javascript" type="text/javascript" >
			$(function() {
				pageData["index"]();
			});
		</script>		
	</div>    
    </div>
</div>
<jsp:include page="/wap/common/footer.jsp"></jsp:include>