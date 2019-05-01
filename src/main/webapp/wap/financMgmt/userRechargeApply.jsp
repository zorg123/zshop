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
	                                <div class="am-btn-group am-btn-group-xs">
	                                 	<button type="button" id="delBtn" class="am-btn am-btn-default am-btn-success"><span class="am-icon-trash-o"></span>删除</button>
	                                </div>
	                            </div>
	                        </div>
	                     </div>
	                    <div class="am-g">
	                        <div class="am-u-sm-12">
	                            <form class="am-form" id="listForm">
	                               <div class ="am-scrollable-horizontal">
	                                <table class="am-table am-table-striped am-table-hover am-text-nowrap table-main">
	                                    <thead>
	                                        <tr>
	                                        	<th class="table-check"></th>
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
		                                            <td><input type="checkbox" recCode="<s:property value="#rcInfoIter.rec_code"/>" state="<s:property value="#rcInfoIter.state"/>"></td>
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
	                                </div>
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
		pageData.openContent("/wap/financMgmt/userRechargeAdd.jsp");
	});
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			var params ={};
			params["rows"] = 5;
			params["page"]=context!=null?context.option.curr:1;
		    pageData.openContent("/FinancMgmt/queryRecApply.do",params);
		}
	}
	
	$("#delBtn").on("click",function(){
		delRec();
	})
	function delRec(){
		var recList=[];
		$.each($("#listForm input:checked"),function(i,v){
			var recCode = $(this).attr("recCode");
			var state = $(this).attr("state");
			var o ={};
			o["recCode"] = recCode;
			o["state"] = state;
			recList.push(o);
		});
		if(recList.length==0){
			CommonUtils.showAlert("请先选择要删除的记录!");
			return;
		}
		if(recList.length>1){
			CommonUtils.showAlert("只能选择一个记录删除!");
			return;
		}
		var o =recList[0];
		if(o.state=='1'){
			CommonUtils.showAlert("已经充值的记录不能删除!");
			return;
		}
		var param={};
		param["userRecharge.rec_code"] = o.recCode;
		CommonUtils.showConfirm("确定要删除吗?",function(){				
			CommonUtils.invokeAsyncAction(base+'/FinancMgmt/deleteUserCharge.do', param, function (reply) {
	  	           if ((reply || '') != '') {
	  	               var code = reply._code;               
	  	               if (code == '0') {  
	  	            	 CommonUtils.showAlert('操作成功!');
	  	            	 if(jump){jump()}; 	                   
	  	               } else  {
	  	            	  CommonUtils.showAlert(reply._msg);
	  	               }              
	  	           } else  {
	  	        	      CommonUtils.showAlert('操作失败!');
	  	           }
	  	    },true);
		});
	}
	$("#page").page({pages:<s:property value="#rcInfoListPage.pageCount"/>,curr:<s:property value="#rcInfoListPage.pageIndex"/>,jump:jump});
</script>	