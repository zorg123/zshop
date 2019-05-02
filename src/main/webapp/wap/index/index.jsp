<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
%>
<s:set name="retAccoutInfo" value="result.retAccoutInfo"/>
<s:set name="curMonthOrdrs" value="result.ret.curMonthOrdrs"/>
<s:set name="lastMonthOrdrs" value="result.ret.lastMonthOrdrs"/>
<s:set name="userLevelShareoutList" value="result.ret.userLevelShareoutList"/>
<s:if test="result.ret.userLevel == 0">    
    <s:set name="userLevelName" value="'未激活'" />      
</s:if>
<s:if test="result.ret.userLevel == 1">    
    <s:set name="userLevelName" value="'普通会员'" />      
</s:if>
<s:if test="result.ret.userLevel == 2">    
    <s:set name="userLevelName" value="'vip会员'" />      
</s:if>
<s:if test="result.ret.userLevel == 3">    
    <s:set name="userLevelName" value="'经理'" />      
</s:if>
<s:if test="result.ret.userLevel == 4">    
    <s:set name="userLevelName" value="'总监'" />      
</s:if>
<s:if test="result.ret.userLevel == 5">    
    <s:set name="userLevelName" value="'总裁'" />      
</s:if>
<s:if test="result.ret.userLevel == 6">    
    <s:set name="userLevelName" value="'合伙人'" />      
</s:if>
<div >
        <!-- <div class="tpl-content-page-title">
            Amaze UI 首页组件
        </div> -->
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-active">首页</a></li>
        </ol>
        
        <div class="row" style="padding:0px 10px">
        	<%--
        	<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat blue">
                    <div class="visual">
                        <i class="am-icon-comments-o"></i>
                    </div>
                    <div class="details">
                        <div class="number"> <s:property value="#accountInfo.bonus_coin"/> </div>
                        <div class="desc">奖金币  </div>
                    </div>
                    <!-- <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i> -->
            </a>
                </div>
            </div>
        	 --%>
        	 <div class="am-u-lg-3 am-u-md-6 am-u-sm-6" >
                <div class="dashboard-stat purple">
                    <div class="visual">
                        <i class="am-icon-android"></i>
                    </div>
                    <div class="details">
                    		 <div class="number" style="color:red">
                    		 	当前级别：<s:property value="userLevelName"/>&nbsp;&nbsp;&nbsp;&nbsp; 
                    		 	<s:if test="result.ret.getShareout_qua == 1">具备分红资格
                    		 	</s:if><s:else> 你不具备分红资格 </s:else>
                    		 </div>
                         	<div class="desc">您的当月订单：<s:property value="curMonthOrdrs"/>&nbsp;&nbsp;&nbsp;&nbsp;上月订单：<s:property value="lastMonthOrdrs"/></div>
                        	
                    </div>
                </div>
            </div>
        	 <div class="am-u-lg-3 am-u-md-6 am-u-sm-6" >
                <div class="dashboard-stat purple">
                    <div class="visual">
                        <i class="am-icon-android"></i>
                    </div>
                    <div class="details">
                        <div class="number"> <s:property value="#retAccoutInfo.bonus_coin"/> </div>
                        <div class="desc"> 奖金币</div>
                    </div>
                    <!-- <a class="more" href="#"> 查看更多
		                <i class="m-icon-swapright m-icon-white"></i>  
		            </a>-->
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-6">
                <div class="dashboard-stat red">
                    <div class="visual">
                        <i class="am-icon-bar-chart-o"></i>
                    </div>
                    <div class="details">
                        <div class="number"><s:property value="#retAccoutInfo.elect_coin"/> </div>
                        <div class="desc"> 电子币 </div>
                    </div>
                    <!-- <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i>  -->
            </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-6" >
                <div class="dashboard-stat green">
                    <div class="visual">
                        <i class="am-icon-apple"></i>
                    </div>
                    <div class="details">
                        <div class="number"> <s:property value="#retAccoutInfo.reconsmp_coin"/> </div>
                        <div class="desc"> 重消币</div>
                    </div>
                    <!-- <a class="more" href="#"> 查看更多
                <i class="m-icon-swapright m-icon-white"></i>  -->
            </a>
                </div>
            </div>


        </div>
        <div class="row"  style="padding:0px 10px">           
             <div class="am-u-md-6 am-u-sm-12 row-mb">
               <div class="tpl-portlet">
                 <div class="tpl-portlet-title">
                     <div class="tpl-caption font-green ">
                         <span>运营信息</span>
                     </div>
                 </div>
                 <div class="am-tabs tpl-index-tabs" >                            
                      <div class="am-tab-panel am-fade am-in am-active" >
                             <div id="wrapperA" class="wrapper">
                                 <div  class="scroller">
                                     <ul class="tpl-task-list tpl-task-remind">                                         
							    		 <s:iterator  value="#userLevelShareoutList"  id="shareoutIter" status="st"> 
							    		     <s:if test="#st.index>0" >
									    		  <li>
									    			  <div class='cosA'>
									    				<span style="font-size:16px;color:red"> <s:property value="#shareoutIter.cf_value"/> </span>共有  <span style="font-size:16px;color:red"> <s:property value="#shareoutIter.usercount"/> </span>个用户，奖金池为： <span style="font-size:16	px;color:blue"> <s:property value="#shareoutIter.total"/> </span>
									    			  </div>
									    		 </li>	
								    		 </s:if>						    		 	
							    		 </s:iterator>                                 
                                     </ul>
                                 </div>
                             </div>
                         </div> 
                     </div>
                   </div>
               </div>    
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
			  <div class="am-u-md-12">
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
					 
	  		<div style="text-align: center;">
	  			<a class="am-btn am-btn-primary am-round" href="javascript:;" style="margin-top:10px;" onclick="layer.closeAll();"> 关闭</a>
	  	 	</div>
	  	  </div>
	  </div>
	</div>	
</div>
<script language="javascript" type="text/javascript" >
			$(function() {
				pageData["index"]();
			});
</script>	