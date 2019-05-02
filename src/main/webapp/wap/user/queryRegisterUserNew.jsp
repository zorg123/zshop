<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>

<s:if test="user.state == 1">    
    <s:set name="funcName" value="'已激活会员'" />      
</s:if> 
<s:else>
   <s:set name="funcName" value="'非激活会员'" />  
</s:else>
<s:set name="userListPage" value="result.ret"/>
<s:set name="userList" value="#userListPage.rows"/>
<s:set name="total" value="#userList.total"/> 
<s:set var="pageCount" value="userListPage.pageCount"/>
<s:set var="pageIndex" value="userListPage.pageIndex"/>
<div   data-url="/Sys/User/queryRegisterUser.do?user.state=<s:property value="user.state" />">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">拼团管理</a></li>
                <li class="am-active"><s:property value="funcName"/></li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
                    <div class="caption font-green ">
                        <s:property value="funcName"/>列表
                    </div>
                </div>    
                    
				<div class="tpl-block">
                    <div class="am-g">
                        <s:if test="user.state != 1">
	                    	<div class="am-u-sm-12 am-u-md-6">
	                            <div class="am-btn-toolbar">
	                                <div class="am-btn-group am-btn-group-xs">
	                                    <button type="button" id="activeBtn" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>激活</button>
	                                </div>
	                                <div class="am-btn-group am-btn-group-xs" style="display: none">
	                                    <button type="button" id="delBtn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span>删除</button>
	                                </div>
	                            </div>
	                        </div>
                   		</s:if>
	                    <div class="am-u-sm-12 am-u-md-3">
	                            <div class="am-input-group am-input-group-sm">
	                                <input type="text" class="am-form-field" id="searchContent" value="<s:property value="user.name"/>"/>
	                                <span class="am-input-group-btn">
	            						<button id="searchBtn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
	          						</span>
	                            </div>
	                    </div>
                     </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form" id="listForm">
                                <table class="am-table am-table-striped am-table-hover am-text-nowrap table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-title">用户账号</th>
                                            <th class="table-title">姓名</th>
                                            <th class="table-type">状态</th>
                                            <th class="table-author am-hide-sm-only">注册时间</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator  value="#userList"  id="userIter" status="st">   
	                                        <tr>
	                                            <td><input type="checkbox" userId="<s:property value="#userIter.user_id"/>"></td>
	                                            <td><s:property value="#userIter.user_code"/></td>
	                                            <td><a href="#"><s:property value="#userIter.name"/></a></td>
	                                            <td><s:if test="#userIter.state == 1" >已激活</s:if><s:if test="#userIter.state == 0" >未激活</s:if></td>
	                                            <td class="am-hide-sm-only"><s:date name="#userIter.register_date" format="yyyy-MM-dd HH:mm:ss"/></td>                                            
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
		    pageData.openContent("/Sys/User/queryWaitActiveUser.do",params);
		}
	}
	<s:if test="user.state != 1">
		function activeUser(){
			var actUserList=[];
			var userId;
			//var name;
			$.each($("#listForm input:checked"),function(i,v){
				userId = $(this).attr("userId");
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
			param["beActivedUserId"] = userId;
			//alert(userId);
			CommonUtils.showConfirm("确定要把您的订单赠送1个给该用户，并激活该用户吗?",function(){
				CommonUtils.invokeAsyncAction(base+"/Sys/User/activeUser2.do", param, function (reply) {           
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
		pageData.openContent(base+"/Sys/User/queryWaitActiveUser.do",params);
		
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