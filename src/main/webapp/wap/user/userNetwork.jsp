<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();	
%>
<link rel="stylesheet" href="<%=baseUri %>/wap/assets/orgChart/css/jquery.orgchart.css">
<link rel="stylesheet" href="<%=baseUri %>/wap/assets/orgChart/css/localStyle.css">
<script src="<%=baseUri %>/wap/assets/orgChart/js/jquery.orgchart.js"></script>
<div class="tpl-content-wrapper">           
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">团队管理</a></li>
                <li class="am-active">安置网络</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <span>激活：</span><span style="display: inline-block; background-color: green;border: 1px solid #eee;width: 100px;text-align:center">绿色</span> 
                    <span>未激活：</span><span style="display: inline-block; background-color: red;border: 1px solid #eee;width: 100px;text-align:center">白色</span>
                </div>

                <div class="tpl-block">
					<div id="chart-container" style="width:100%"></div>
                </div>
                <div class="tpl-block">
					<div class="am-u-sm-8 am-u-sm-push-3">
                        <button type="button" id="register" class="am-btn am-btn-primary tpl-btn-bg-color-success "  style="display:none">注册</button>
                    </div>
                </div>
        </div>
        
<script language="javascript" type="text/javascript" >
	$(function() {
		
		$("#register").on("click",function(){
			$this= $(this);
			var d = $this.data["node"];
			console.log($("#register").data['node']);
			if(d instanceof Object){
				CommonUtils.showAlert("/wap/user/register.jsp?puserCode="+d.userCode);
				pageData.openContent("/wap/user/register.jsp?puserCode="+d.userCode)
			}
			//pageData.openContent("/wap/user/register.jsp?");
		});
		
		//初始化用户网络层级树
		var param={};
		CommonUtils.invokeAsyncAction(base+'/Sys/User!getUserNetWork.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;					
                if(code=='0'){
                	 var result = reply.ret;               	 
               	  var $chart = $('#chart-container').orgchart({
          		      'data' : result,
          		      'nodeTitle':'title',
          		      'direction':'t2b',     
          		      'createNode': function($node, data) {		   
	          		      	$node.find(".content").addClass("contentMid");
	          		      	var d = $node.data["data"]
          				    var starDidv = '<div class="content contentMid">用户星级：'+d.starName+'</div>';
          				    $node.append(starDidv);
          				  	var childNumDidv = '<div class="content">所有人数：'+d.allchild_num+'</div>';
        				    $node.append(childNumDidv);
          			  }
          		    }).on('click', '.node', function() {
          		      var $this = $(this);          		      
          		      var $children = $('#chart-container').orgchart('getRelatedNodes',$this,"children"); 
          		      console.log($children.length);
          		      console.log($this.data["data"]);
          		      if($children.length<3){
          		    	  $("#register").show();
          		    	  $("#register").data["node"]= $this.data["data"];
          		    	
          		      }else{
          		    	  $("#register").hide();
          		    	  $("#register").data["node"] = null;
          		      }
          		      
          		    })
           		    .on('click', '.orgchart', function(event) {
           		      if (!$(event.target).closest('.node').length) {
           		    	 $("#register").hide();
           		    	 $("#register").data["node"] = null;
           		      }           		   	 
           		  });
               	 $('.orgchart').addClass('noncollapsable')
      		     $('.orgchart').css("width","100%")
                }
			}			
		});
		 
	});
</script>	