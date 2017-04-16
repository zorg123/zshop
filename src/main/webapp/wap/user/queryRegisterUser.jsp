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
<div class="tpl-content-wrapper">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">团队管理</a></li>
                <li class="am-active"><s:property value="funcName"/></li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span><s:property value="funcName"/>列表
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>
				<div class="tpl-block">
                    <div class="am-g">
                    	<div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>激活</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table class="am-table am-table-striped am-table-hover table-main">
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
	                                            <td><s:property value="#userIter.state"/></td>
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
        </div>
        
<script language="javascript" type="text/javascript" >
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var params ={};
			params["rows"] = 5;
			params["page"]=context.option.curr;
			params["user.state"]='<s:property value="#user.state" />';
		    pageData.openContent(base+"/Sys/User/queryRegisterUser.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#userListPage.pageCount"/>,curr:<s:property value="#userListPage.pageIndex"/>,jump:jump});
</script>	