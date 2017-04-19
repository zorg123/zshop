<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
%>

<div >
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