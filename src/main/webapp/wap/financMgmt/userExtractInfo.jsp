<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="extractInfoListPage" value="result.ret"/>
<s:set name="extractInfoList" value="#extractInfoListPage.rows"/>
<s:set name="total" value="#extractInfoList.total"/> 
<s:set var="pageCount" value="extractInfoListPage.pageCount"/>
<s:set var="pageIndex" value="extractInfoListPage.pageIndex"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">提现明细</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>提现列表</span>
	                    </div>
                    </div>
					<div class="tpl-block">
	                    <div class="am-g">
	                        <div class="am-u-sm-12">
	                            <form class="am-form">
	                                <table class="am-table am-table-striped am-table-hover table-main">
	                                    <thead>
	                                        <tr>
	                                            <th class="table-type">时间</th>
	                                            <th class="table-type">金额</th>
	                                            <th class="table-type">状态</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#extractInfoList"  id="extractInfoIter" status="st">   
		                                        <tr>
		                                            <td><s:date name="#extractInfoIter.create_time" format="yyyy-MM-dd HH:mm:ss"/></td>
		                                            <td><s:property value="#extractInfoIter.coin_num"/></td>
		                                            <td><s:property value="#extractInfoIter.apply_state"/></td>
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
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var params ={};
			params["rows"] = 5;
			params["page"]=context.option.curr;
		    pageData.openContent(base+"/FinancMgmt/queryUserExtractInfo.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#extractInfoListPage.pageCount"/>,curr:<s:property value="#extractInfoListPage.pageIndex"/>,jump:jump});
</script>	