<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head_new.jsp"></jsp:include>
<link href="<%=baseUri %>/public/ligerUI/skins/Gray/css/grid.css" rel="stylesheet" type="text/css"/>
<div id="mainLayout" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
	 <div position="left"  title="栏目目录" id="leftLayout"> 
        	<div>
        		<ul id="channelTree">
			      	<li isexpand="true" channel_name="根目录" channel_id="-1" >
                 		<span>根目录</span>
                 	</li>
        		</ul>
        	</div>                 
      </div>
      <div position="center" id="rightLayOut" style="padding-top:5px;padding-left:5px"> 
          <div id="contentList" >              
          </div> 
      </div> 
</div>
<script type="text/javascript" src="<%=baseUri %>/admin/channel/js/content.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>