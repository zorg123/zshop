<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="bonusActListPage" value="result.ret"/>
<s:set name="bonusActSum" value="result.bonusActSum"/>
<s:set name="reconsmpActSum" value="result.reconsmpActSum"/>
<s:set name="actSum" value="result.actSum"/>
<s:set name="bonusActList" value="#bonusActListPage.rows"/>
<s:set name="total" value="#bonusActList.total"/>
<s:set var="pageCount" value="bonusActListPage.pageCount"/>
<s:set var="pageIndex" value="bonusActListPage.pageIndex"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">奖金实收</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>奖金实收列表</span>
	                    </div>
	                    <div class="actions">
	                        <ul class="actions-btn">
	                            <li class="purple-on">实收总额:<s:property value="actSum"/></li>
	                            <li class="red-on">重消总额:<s:property value="reconsmpActSum"/></li>
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
	                                            <th class="table-type">广告费</th>
	                                            <th class="table-type">辅导奖</th>
	                                            <th class="table-type">重消奖</th>
	                                            <th class="table-type">实收</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#bonusActList"  id="bonusActIter" status="st">   
		                                        <tr>
		                                            <td ><s:date name="#bonusActIter.create_time" format="yyyy-MM-dd HH:mm:ss"/></td>
		                                            <td class="font-green bold"><s:property value="#bonusActIter.gg_fee"/></td>
		                                            <td class="font-green bold"><s:property value="#bonusActIter.fd_fee"/></td>
		                                            <td class="font-green bold"><s:property value="#bonusActIter.re_fee"/></td>
		                                            <td class="font-green bold"><s:property value="#bonusActIter.act_fee"/></td>
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
		    pageData.openContent(base+"/FinancMgmt/queryBonusAct.do",params);
		}
	}
	$("#page").page({pages:<s:property value="#bonusActListPage.pageCount"/>,curr:<s:property value="#bonusActListPage.pageIndex"/>,jump:jump});
</script>	