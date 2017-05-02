<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="rcInfoListPage" value="result.ret"/>
<s:set name="rcInfoList" value="#rcInfoListPage.rows"/>
<s:set name="total" value="#rcInfoList.total"/> 
<s:set var="pageCount" value="rcInfoListPage.pageCount"/>
<s:set var="pageIndex" value="rcInfoListPage.pageIndex"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">充值申请</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>申请列表</span>
	                    </div>
                    </div>
					<div class="tpl-block">
						<div class="am-g">
	                    	<div class="am-u-sm-12 am-u-md-6">
	                            <div class="am-btn-toolbar">
	                                <div class="am-btn-group am-btn-group-xs">
	                                    <button type="button" id="addBtn" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>新增</button>
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
	                                        	<th class="table-type">申请时间</th>
	                                            <th class="table-type">充值银行</th>
	                                            <th class="table-type">充值卡号</th>
	                                            <th class="table-type">充值金额</th>
	                                            <th class="table-type">充值留言</th>
	                                            <th class="table-type">是否充值</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#rcInfoList"  id="rcInfoIter" status="st">   
		                                        <tr>
		                                        	<td><s:date name="#rcInfoIter.create_time" format="yyyy-MM-dd HH:mm:ss"/></td>
		                                            <td><s:property value="#rcInfoIter.rec_bankname"/></td>
		                                            <td><s:property value="#rcInfoIter.rec_bankid"/></td>
		                                            <td><s:property value="#rcInfoIter.rec_num"/></td>
		                                            <td><s:property value="#rcInfoIter.rec_message"/></td>
		                                            <td><s:property value="#rcInfoIter.state_name"/></td>
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
</div>    
<script language="javascript" type="text/javascript" >
	$("#addBtn").on("click",function(){
		//CommonUtils.showAlert('操作成功!');
		pageData.openContent(base+"/wap/financMgmt/userRechargeAdd.jsp");
	})
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var params ={};
			params["rows"] = 5;
			params["page"]=context.option.curr;
		    pageData.openContent(base+"/FinancMgmt/queryRcInfo.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#rcInfoListPage.pageCount"/>,curr:<s:property value="#rcInfoListPage.pageIndex"/>,jump:jump});
</script>	