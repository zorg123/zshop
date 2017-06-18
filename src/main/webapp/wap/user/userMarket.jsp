<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="userMarketList" value="result.ret"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">团队管理</a></li>
                <li class="am-active">市场统计</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>统计列表</span>
	                    </div>
                    </div>
					<div class="tpl-block">
	                    <div class="am-g">
	                        <div class="am-u-sm-12">
	                            <form class="am-form">
	                                <table class="am-table am-table-striped am-table-hover table-main">
	                                    <thead>
	                                        <tr>
	                                            <th class="table-type">编号</th>
	                                            <th class="table-type">姓名</th>
	                                            <th class="table-type">人数</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#userMarketList"  id="userMarketIter" status="st">   
		                                        <tr>
		                                        	<td><s:property value="#userMarketIter.user_code"/></td>
		                                            <td><s:property value="#userMarketIter.name"/></td>
		                                            <td><s:property value="#userMarketIter.allchild_num"/></td>
		                                        </tr>
	                                        </s:iterator>                                        
	                                    </tbody>
	                                </table>
	                            </form>
	                        </div>
	                    </div>
	                </div>
                </div> 
        </div>
</div>	