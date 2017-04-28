<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();    
%>

<s:if test="url == '/Goods/goodsRevAddrListForSel.do'">    
    <s:set name="funcName" value="'选择收货地址'" />      
</s:if> 
<s:else>
   <s:set name="funcName" value="'收货地址管理'" />  
</s:else>
<s:set name="addrListPage" value="result.ret"/>
<s:set name="addrList" value="#addrListPage.rows"/>
<s:set name="total" value="#addrListPage.total"/> 
<s:set var="pageCount" value="#addrListPage.pageCount"/>
<s:set var="pageIndex" value="#addrListPage.pageIndex"/>
<div data-url="<s:property value="url" />">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">网上商城</a></li>
                <li class="am-active"><s:property value="funcName" /></li>
            </ol>
            <div class="tpl-portlet-components" id="addrListDiv">
            	<div class="portlet-title">
                    <div class="caption font-green ">
                        	收货地址列表
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
                                    <button type="button" id="modBtn" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plug"></span>修改</button>
                                </div>
                                <s:if test="url != '/Goods/goodsRevAddrListForSel.do'"> 
	                                <div class="am-btn-group am-btn-group-xs">
	                                    <button type="button" id="delBtn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span>删除</button>
	                                </div>
	                                <div class="am-btn-group am-btn-group-xs">
	                                    <button type="button" id="defaultBtn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span>设为默认</button>
	                                </div>
                                </s:if>
                                <%--如果是来选择地址的，显示选择和返回按钮 --%>
                                <s:if test="url == '/Goods/goodsRevAddrListForSel.do'"> 
                                	<div class="am-btn-group am-btn-group-xs">
                                    	<button type="button" id="selBtn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-check"></span>选择</button>
	                                </div>
	                                <div class="am-btn-group am-btn-group-xs">
	                                    <button type="button" id="cancelBtn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-arrow-left"></span>返回</button>
	                                </div>
                                </s:if>
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
	                                            <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
	                                            <th class="table-title">收货人</th>
	                                            <th class="table-title">收货人电话</th>
	                                            <th class="table-type">收货人地址</th>
	                                            <th class="table-type">是否默认地址</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <s:iterator  value="#addrList"  id="addrIter" status="st">   
		                                        <tr>
		                                            <td><input type="checkbox" addrId="<s:property value="#addrIter.addr_id"/>" revAddr='<s:property value="#addrIter.rev_provice"/><s:property value="#addrIter.rev_city"/><s:property value="#addrIter.rev_zone"/><s:property value="#addrIter.rev_addr"/>' addrArea="<s:property value="#addrIter.rev_provice"/>" revPeople="<s:property value="#addrIter.rev_people"/>" revLinkPhone="<s:property value="#addrIter.rev_link_phone"/>" ></td>
		                                            <td><s:property value="#addrIter.rev_people"/></td>
		                                            <td><a href="#"><s:property value="#addrIter.rev_link_phone"/></a></td>
		                                            <td><s:property value="#addrIter.rev_provice"/><s:property value="#addrIter.rev_city"/><s:property value="#addrIter.rev_zone"/><s:property value="#addrIter.rev_addr"/></td>  
		                                            <td><s:if test="#addrIter.is_default==1">是</s:if><s:else>否</s:else></td>                                       
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
        
        <div class="tpl-portlet-components" id="addrModDiv" style="display:none;padding-bottom: 60px">
            	    				
        </div>
<script language="javascript" type="text/javascript" >
	var jump = function(context,first) {
		//CommonUtils.showAlert('当前第：' + context.option.curr + "页");
		if(!first){
			
			var params ={};
			params["rows"] = 5;
			params["page"]=context!=null?context.option.curr:1;
		    pageData.openContent(base+'<s:property value="url" />',params);
		}
	}
	
		
	function delUser(){
		var addrList=[];
		$.each($("#listForm input:checked"),function(i,v){
			var addrId = $(this).attr("addrId");
			addrList.push(addrId);
		});
		if(addrList.length==0){
			CommonUtils.showAlert("请先选择要删除的记录!");
			return;
		}
		if(addrList.length>1){
			CommonUtils.showAlert("只能选择一个记录删除!");
			return;
		}
		var param={};
		param["ids"] = addrList.join(",");
		CommonUtils.showConfirm("确定要删除吗?",function(){				
			CommonUtils.invokeAsyncAction(base+'/Goods/delGoodsRevAddr.do', param, function (reply) {
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
	
	function edit(record){
		
		var params={};
		if(record){
			params["goodsRevAddr.addr_id"] = record[0];
		}
		pageData.openContent(base+"/Goods/goodsRevAddrEdit.do",params,"addrModDiv");
		if ($.AMUI.support.animation) {
			$("#addrListDiv").addClass("am-animation-fade am-animation-reverse").one($.AMUI.support.animation.end, function() {
				$("#addrListDiv").removeClass("am-animation-fade am-animation-reverse");
				$("#addrListDiv").hide();
				$("#addrModDiv").show();
				$("#addrModDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
					$("#addrModDiv").removeClass("am-animation-fade");	 
					
		        });
	        });
			
		}else{
			$("#addrListDiv").hide();
			$("#addrModDiv").show();
		}
		
	}
	
	$("#searchBtn").on("click",function(){
		jump(null,false);
	})
	
	$("#addBtn").on("click",function(){
		edit();
	})
	
	$("#modBtn").on("click",function(){
		var addrList = [];
		$.each($("#listForm input:checked"),function(i,v){
			var addrId = $(this).attr("addrId");
			addrList.push(addrId);
		});
		if(addrList.length==0){
			CommonUtils.showAlert("请先选择要修改的记录!");
			return;
		}
		if(addrList.length>1){
			CommonUtils.showAlert("只能选择一条记录!");
			return;
		}
		edit(addrList);
	})
	if($("#delBtn")){
		$("#delBtn").on("click",function(){
			delUser();
		});
	}
	if($("#defaultBtn")){
		$("#defaultBtn").on("click",function(){
			var addrList = [];
			$.each($("#listForm input:checked"),function(i,v){
				var addr={};
				addr["addrId"] =  $(this).attr("addrId");
				addr["revAddr"] =  $(this).attr("revAddr");
				addr["revPeople"] =  $(this).attr("revPeople");
				addr["revLinkPhone"] =  $(this).attr("revLinkPhone");	
				addr["addrArea"] =  $(this).attr("addrArea");
				addrList.push(addr);
			});
			if(addrList.length==0){
				CommonUtils.showAlert("请先选择要操作的记录!");
				return;
			}
			if(addrList.length>1){
				CommonUtils.showAlert("只能选择一条记录!");
				return;
			}
			var param ={};
			param["goodsRevAddr.addr_id"] = addrList[0].addrId;
			
			CommonUtils.showConfirm("确定要设置此地址 '"+addrList[0].revAddr+"' 为默认地址吗?",function(){				
				CommonUtils.invokeAsyncAction(base+'/Goods/setDefaultRevAddr.do', param, function (reply) {
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
	   });
	}
	if($("#selBtn")){
		$("#selBtn").on("click",function(){		
			var addrList = [];
			$.each($("#listForm input:checked"),function(i,v){
				var addr={};
				addr["addrId"] =  $(this).attr("addrId");
				addr["revAddr"] =  $(this).attr("revAddr");
				addr["revPeople"] =  $(this).attr("revPeople");
				addr["revLinkPhone"] =  $(this).attr("revLinkPhone");	
				addr["addrArea"] =  $(this).attr("addrArea");
				addrList.push(addr);
			});
			if(addrList.length==0){
				CommonUtils.showAlert("请先选择记录!");
				return;
			}
			if(addrList.length>1){
				CommonUtils.showAlert("只能选择一条记录!");
				return;
			}
			if(confirmAddr){
				confirmAddr(addrList[0]);
			}
			if(goAccept){
				goAccept();
			}
		})
	}
	if($("#cancelBtn")){
		$("#cancelBtn").on("click",function(){
			if(goAccept){
				goAccept();
			}
		})
	}
	function goBack(){
		if ($.AMUI.support.animation) {
			$("#addrModDiv").addClass("am-animation-fade am-animation-reverse").one($.AMUI.support.animation.end, function() {
				$("#addrModDiv").removeClass("am-animation-fade am-animation-reverse");
				$("#addrModDiv").hide();
				$("#addrListDiv").show();
				$("#addrListDiv").addClass("am-animation-fade").one($.AMUI.support.animation.end, function() {				
					$("#addrListDiv").removeClass("am-animation-fade");	 
					
		        });
	        });
			
		}else{
			$("#addrModDiv").hide();
			$("#addrListDiv").show();
		}
	}
	
	$("#page").page({pages:<s:property value="#addrListPage.pageCount"/>,curr:<s:property value="#addrListPage.pageIndex"/>,jump:jump});
</script>	