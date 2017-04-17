<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="electInfoListPage" value="result.ret"/>
<s:set name="electCoin" value="result.electCoin"/>
<s:set name="electInfoList" value="#electInfoListPage.rows"/>
<s:set name="total" value="#electInfoList.total"/> 
<s:set var="pageCount" value="electInfoListPage.pageCount"/>
<s:set var="pageIndex" value="electInfoListPage.pageIndex"/>
<div class="tpl-content-wrapper">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">电子币明细</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>电子币明细列表</span>
	                    </div>
	                    <div class="actions">
	                        <ul class="actions-btn">
	                            <li class="red-on">即时电子币:<s:property value="electCoin"/></li>
	                        </ul>
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
	                                            <th class="table-type">类型</th>
	                                            <th class="table-type">金额</th>
	                                            <th class="table-type">说明</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#electInfoList"  id="electInfoIter" status="st">   
		                                        <tr>
		                                            <td><s:date name="#electInfoIter.create_time" format="yyyy-MM-dd HH:mm:ss"/></td>
		                                            <td><s:property value="#electInfoIter.create_type_name"/></td>
		                                            <td><s:property value="#electInfoIter.coin_num"/></td>
		                                            <td><s:property value="#electInfoIter.comments"/></td>
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
		    pageData.openContent(base+"/FinancMgmt/queryElectInfo.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#electInfoListPage.pageCount"/>,curr:<s:property value="#electInfoListPage.pageIndex"/>,jump:jump});
</script>	