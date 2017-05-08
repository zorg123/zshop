<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
%>
<link rel="stylesheet" href="<%=baseUri %>/wap/assets/orgChart/css/jquery.orgchart.css">
<link rel="stylesheet" href="<%=baseUri %>/wap/assets/orgChart/css/localStyle.css">
<script src="<%=baseUri %>/wap/assets/orgChart/js/jquery.orgchart.js"></script>
<div  data-url="/wap/user/userNetwork.jsp">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">团队管理</a></li>
                <li class="am-active">安置网络</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="am-breadcrumb">
                    <span>激活：</span><span style="display: inline-block; background-color: green;border: 1px solid #eee;width: 100px;text-align:center">绿色</span>
                    <span>未激活：</span><span style="display: inline-block; background-color: red;border: 1px solid #eee;width: 100px;text-align:center">白色</span>
                </div>
				<div class="tpl-block">
					<div class="am-u-sm-6">
					    <button type="button" id="subNetWork" class="am-btn am-btn-primary tpl-btn-bg-color-success am-btn-xs "  >向下置顶</button>                    
                        <button type="button" id="register" class="am-btn am-btn-primary tpl-btn-bg-color-success am-btn-xs"  style="display:none">注册</button>
                        </div>
                     <div class="am-u-sm-6">
                          <div class="am-input-group am-input-group-sm">
                              <input type="text" class="am-form-field" id="searchContent" placeholder="请输入账号" value="<s:property value="user.name"/>"/>
                              <span class="am-input-group-btn">
          						<button id="searchBtn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
        						</span>
                          </div>
	                 </div>
                </div>
                <div class="tpl-block">
					<div id="chart-container" style="width:100%;height:100%"></div>
                </div>
                
        </div>
        
<script language="javascript" type="text/javascript" >
	$(function() {
		
		$("#register").on("click",function(){
			$this= $(this);
			var d = $this.data["node"];
			console.log($("#register").data['node']);
			if(d instanceof Object){
				//CommonUtils.showAlert("/wap/user/register.jsp?puserCode="+d.userCode);
				pageData.openContent("/wap/user/register.jsp?puserCode="+d.userCode)
			}
			//pageData.openContent("/wap/user/register.jsp?");
		});
		$("#subNetWork").on("click",function(){
			$('#chart-container').empty();
			var d = $("#register").data['node'];
			if(d instanceof Object){
				var param={};
				param["user.user_id"]=d.id;
				CommonUtils.invokeAsyncAction(base+'/Sys/User/getUserNetWork.do', param, function (reply) {
					if((reply || '') !=''){
						var code = reply._code;					
		                if(code=='0'){
		                	 var result = reply.ret;               	 
		                	 init_network(result);
		                }else{
		                	CommonUtils.showAlert(reply._msg);
		                }
					}				
				});
			}else{
				CommonUtils.showAlert("请先选择一个节点!");
				return;
			}
			
		});
		
		$("#searchBtn").on("click",function(){
			var searchContentV = $("#searchContent").val();
			//if(searchContentV == null || searchContentV == ''){
			//	CommonUtils.showAlert("请输入查询的用户名!");
			//	return;
			//}
			var param={};
			param["user.user_code"]=searchContentV;
			$('#chart-container').empty();
			CommonUtils.invokeAsyncAction(base+'/Sys/User!getUserNetWork.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;					
	                if(code=='0'){
	                	 var result = reply.ret;               	 
	                	 init_network(result);
	                }else{
	                	CommonUtils.showAlert(reply._msg);
	                }
				}
			});
		});
		
		//初始化用户网络层级树
		var param={};
		CommonUtils.invokeAsyncAction(base+'/Sys/User!getUserNetWork.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;					
                if(code=='0'){
                	 var result = reply.ret;               	 
                	 init_network(result);
                }else{
                	CommmonUtils.showAlert(reply._msg);
                }
			}			
		});
		 
	});
	
	function init_network(sdata){
		$('#chart-container').empty();
		var $chart = $('#chart-container').orgchart({
		      'data' : sdata,
		      'nodeTitle':'title',
		      'direction':'t2b',
		      'createNode': function($node, data) {	
		    	   
    		      	$node.find(".content").addClass("contentMid");
    		      	var d = $node.data["data"]
				    var starDidv = '<div class="content contentMid">'+d.starName+'</div>';
				    $node.append(starDidv);
				  	var childNumDidv = '<div class="content">所有人数：'+d.allchild_num+'</div>';
				    $node.append(childNumDidv);
				    $node.on('click',function() { 
				    	  var childrenLength =data.childrenLength;
	          		      if((childrenLength<3) && data.userState =='1'){
	          		    	  $("#register").show();	          		    	
	          		      }else{
	          		    	  $("#register").hide();
	          		      }
	          		    $("#register").data["node"]=data;
	          		      
	          		});
			  }
		    })
 		    .on('click', '.orgchart', function(event) {
 		      if (!$(event.target).closest('.node').length) {
 		    	 $("#register").hide();
 		    	 $("#register").data["node"] = null;
 		      }           		   	 
 		  });
     	 $('.orgchart').addClass('noncollapsable')
	     $('.orgchart').css("width","100%");
         $('.orgchart').css("height","100%");
	}
</script>	