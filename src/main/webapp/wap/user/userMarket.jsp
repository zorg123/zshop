<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>
<s:set name="userMarketList" value="result.ret"/>
<s:set name="lastMonthOrdrs" value="result.lastMonthOrdrs"/>
<s:set name="curMonthOrdrs" value="result.curMonthOrdrs"/>
<s:set name="totalUserGoodsOrders" value="result.totalUserGoodsOrders"/>
<div>           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">会员管理</a></li>
                <li class="am-active">市场统计</li>
            </ol>
            <div class="tpl-portlet-components">
            	<div class="portlet-title">
            		<div class="tpl-portlet-title">
	                    <div class="tpl-caption font-green ">
	                       <i class="am-icon-cloud-download"></i>
	                       <span>统计列表</span>
	                    </div>
	                    <div class="actions">
	                        <ul class="actions-btn">
	                            <li class="purple-on">上月销量:<s:property value="lastMonthOrdrs"/></li>
	                            <li class="blue-on">本月新增:<s:property value="curMonthOrdrs"/></li>
	                            <li class="red-on">市场总销量:<s:property value="totalUserGoodsOrders"/></li>
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
	                                            <th class="table-type">编号</th>
	                                            <th class="table-type">姓名</th>
	                                            <th class="table-type">类型</th>
	                                            <th class="table-type">状态</th>
	                                            <th class="table-type">级别</th>
	                                            <!-- <th class="table-type">会员订单总数</th> -->
	                                            <th class="table-type">VIP会员总数</th>
	                                            <th class="table-type">经理总数</th>
	                                            <th class="table-type">总监总数</th>
	                                            <th class="table-type">总裁总数</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#userMarketList"  id="userMarketIter" status="st">   
		                                        <tr>
		                                        	<td><s:property value="#userMarketIter.user_code"/></td>
		                                            <td><s:property value="#userMarketIter.name"/></td>
		                                            <td><s:property value="#userMarketIter.user_type"/></td>
		                                            <td><s:property value="#userMarketIter.state"/></td>
		                                            <td><s:property value="#userMarketIter.user_level"/></td>
		                                            <!-- <td>
			                                            <s:if test="#userMarketIter.allorder_num==null || #userMarketIter.allorder_num==''">
			                                            	0
			                                            </s:if>
			                                            <s:else>
			                                            	<s:property value="#userMarketIter.allorder_num"/>
			                                            </s:else>
		                                            </td> -->
		                                            <td><s:property value="#userMarketIter.grade2Number"/></td>
		                                            <td><s:property value="#userMarketIter.grade3Number"/></td>
		                                            <td><s:property value="#userMarketIter.grade4Number"/></td>
		                                            <td><s:property value="#userMarketIter.grade5Number"/></td>
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