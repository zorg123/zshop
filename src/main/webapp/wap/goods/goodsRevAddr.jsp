<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>

<s:if test="selAddr == 1">    
    <s:set name="funcName" value="'选择收货地址'" />      
</s:if> 
<s:else>
   <s:set name="funcName" value="'收货地址管理'" />  
</s:else>
<s:set name="addrListPage" value="result.ret"/>
<s:set name="addrList" value="#addrListPage.rows"/>
<s:set name="total" value="#addrListPage.total"/> 
<s:set var="pageCount" value="#addrListPage.pageCount"/>
<s:set var="pageIndex" value="#addrListPage.pageIndex"/>
<div   data-url="/Goods/goodsRevAddr.do?selAddr=<s:property value="selAddr" />">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active"><s:property value="funcName" /></li>
            </ol>
            <div class="tpl-portlet-components" id="addrListDiv">
            	<div class="portlet-title">
                    <div class="caption font-green ">
                        	收货地址列表
                    </div>
                </div>    
                    
				<div class="tpl-block">
                    <div class="am-g">
                        
                    	<div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="activeBtn" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>新增</button>
                                </div>
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="activeBtn" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>修改</button>
                                </div>
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="delBtn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span>删除</button>
                                </div>
                            </div>
                        </div>
                     </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form" id="listForm">
                                <table class="am-table am-table-striped am-table-hover table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-title">收货人</th>
                                            <th class="table-title">收货人电话</th>
                                            <th class="table-type">收货人地址</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator  value="#addrList"  id="addrIter" status="st">   
	                                        <tr>
	                                            <td><input type="checkbox" userId="<s:property value="#addrIter.user_id"/>"></td>
	                                            <td><s:property value="#addrIter.rev_people"/></td>
	                                            <td><a href="#"><s:property value="#addrIter.rev_link_phone"/></a></td>
	                                            <td><s:property value="#addrIter.rev_addr"/></td>                                         
	                                        </tr>
                                        </s:iterator>                                        
                                    </tbody>
                                </table>
                                <div id="page">  </div>

                            </form>
                        </div>

                    </div>
                </div> 
        </div>
        
        <div class="tpl-portlet-components" id="addrModDiv">
            	    				
        </div>
<script language="javascript" type="text/javascript" >
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var searchContentV= $("#searchContent").val();
			var params ={};
			params["rows"] = 5;
			params["page"]=context!=null?context.option.curr:1;
			params["user.state"]='<s:property value="user.state" />';
			if(searchContentV.length!=0){
				params["user.name"] = searchContentV;
			}
		    pageData.openContent(base+"/Sys/User/queryRegisterUser.do",params);
		}
	}
	<s:if test="user.state != 1">
		function activeUser(){
			var actUserList=[];
			$.each($("#listForm input:checked"),function(i,v){
				var userId = $(this).attr("userId");
				actUserList.push(userId);
			});
			if(actUserList.length==0){
				CommonUtils.showAlert("请先选择要激活的用户!");
				return;
			}
			if(actUserList.length>1){
				CommonUtils.showAlert("只能选择一个用户激活!");
				return;
			}
			var param={};
			param["ids"] = actUserList.join(",");
			CommonUtils.showConfirm("确定要激活吗?",function(){
				CommonUtils.invokeAsyncAction(base+'/Sys/User/activeUser.do', param, function (reply) {           
		  	           if ((reply || '') != '') {
		  	               var code = reply._code;               
		  	               if (code == '0') {  
		  	            	   CommonUtils.showAlert('操作成功!');
		  	            	 pageData["refresh"]() 	                   
		  	               } else  {
		  	            	  CommonUtils.showAlert(reply._msg);
		  	               }              
		  	           } else  {
		  	        	      CommonUtils.showAlert('操作失败!');
		  	           }
		  	    },true);
			});
		}
		
		function delUser(){
			var actUserList=[];
			$.each($("#listForm input:checked"),function(i,v){
				var userId = $(this).attr("userId");
				actUserList.push(userId);
			});
			if(actUserList.length==0){
				CommonUtils.showAlert("请先选择要删除的用户!");
				return;
			}
			if(actUserList.length>1){
				CommonUtils.showAlert("只能选择一个用户删除!");
				return;
			}
			var param={};
			param["ids"] = actUserList.join(",");
			CommonUtils.showConfirm("确定要删除吗?",function(){				
				CommonUtils.invokeAsyncAction(base+'/Sys/User/delUnActiveUser.do', param, function (reply) {
		  	           if ((reply || '') != '') {
		  	               var code = reply._code;               
		  	               if (code == '0') {  
		  	            	 CommonUtils.showAlert('操作成功!');
		  	            	 pageData["refresh"]() 	                   
		  	               } else  {
		  	            	  CommonUtils.showAlert(reply._msg);
		  	               }              
		  	           } else  {
		  	        	      CommonUtils.showAlert('操作失败!');
		  	           }
		  	    },true);
			});
		}
		
	</s:if>
	function searchUser(){
		var searchContentV= $("#searchContent").val();
		
		if(searchContentV.length==0){
			CommonUtils.showAlert("请输入要查询的用户名称!");
			return;
		}
		var params={};
		params["user.name"] = searchContentV;
		params["rows"] = 5;
		params["page"]=1;
		params["user.state"]='<s:property value="user.state" />';		
		pageData.openContent(base+"/Sys/User/queryRegisterUser.do",params);
		
	}
	$("#searchBtn").on("click",function(){
		jump(null,false);
	})
	<s:if test="user.state != 1">
		$("#activeBtn").on("click",function(){
			activeUser();
		})
		$("#delBtn").on("click",function(){
			delUser();
		})
	</s:if>
	$("#page").page({pages:<s:property value="#userListPage.pageCount"/>,curr:<s:property value="#userListPage.pageIndex"/>,jump:jump});
</script>	