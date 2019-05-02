<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="accoutFlowListPage" value="result.ret"/>
<s:set name="accoutFlowList" value="#accoutFlowListPage.rows"/>
<s:set name="total" value="#accoutFlowList.total"/> 
<s:set var="pageCount" value="accoutFlowListPage.pageCount"/>
<s:set var="pageIndex" value="accoutFlowListPage.pageIndex"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">账户流水</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>账户流水列表</span>
	                    </div>
                    </div>
					<div class="tpl-block">
	                    <div class="am-g">
	                        <div class="am-u-sm-12">
	                            <form class="am-form">
	                               <div class ="am-scrollable-horizontal">
	                                <table class="am-table am-table-striped am-table-hover am-text-nowrap table-main">
	                                    <thead>
	                                        <tr>
	                                            <th class="table-type">时间</th>
	                                            <th class="table-type">类型</th>
	                                            <th class="table-type">金额</th>
	                                            <th class="table-type">说明</th>
	                                            <th class="table-type">余额说明</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#accoutFlowList"  id="accoutFlowIter" status="st">   
		                                        <tr>
		                                            <td><s:date name="#accoutFlowIter.create_time" format="yyyy-MM-dd HH:mm:ss"/></td>
		                                            <td><s:property value="#accoutFlowIter.create_type_name"/></td>
		                                            <td><s:property value="#accoutFlowIter.coin_num"/></td>
		                                            <td><s:property value="#accoutFlowIter.comments"/></td>
		                                            <td><s:property value="#accoutFlowIter.balance_comments"/></td>
		                                        </tr>
	                                        </s:iterator>                                        
	                                    </tbody>
	                                </table>	                                
	                                </div>
	                            </form>
	                            <div id="page">  </div>
	                        </div>
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
			params["rows"] = 10;
			params["page"]=context.option.curr;
		    pageData.openContent("/FinancMgmt/queryAccoutFlowForWap.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#accoutFlowListPage.pageCount"/>,curr:<s:property value="#accoutFlowListPage.pageIndex"/>,jump:jump});
</script>	