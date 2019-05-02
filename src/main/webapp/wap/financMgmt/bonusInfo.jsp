<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="bonusInfoListPage" value="result.ret"/>
<s:set name="bonusCoin" value="result.bonusCoin"/>
<s:set name="bonusInfoList" value="#bonusInfoListPage.rows"/>
<s:set name="total" value="#bonusInfoList.total"/> 
<s:set var="pageCount" value="bonusInfoListPage.pageCount"/>
<s:set var="pageIndex" value="bonusInfoListPage.pageIndex"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">奖金币明细</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>奖金明细列表</span>
	                    </div>
	                    <div class="actions">
	                        <ul class="actions-btn">
	                            <li class="red-on">即时奖金币:<s:property value="bonusCoin"/></li>
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
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#bonusInfoList"  id="bonusInfoIter" status="st">   
		                                        <tr>
		                                            <td><s:date name="#bonusInfoIter.create_time" format="yyyy-MM-dd HH:mm:ss"/></td>
		                                            <td><s:property value="#bonusInfoIter.create_type_name"/></td>
		                                            <td><s:property value="#bonusInfoIter.coin_num"/></td>
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
		    pageData.openContent("/FinancMgmt/queryBonusInfo.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#bonusInfoListPage.pageCount"/>,curr:<s:property value="#bonusInfoListPage.pageIndex"/>,jump:jump});
</script>	