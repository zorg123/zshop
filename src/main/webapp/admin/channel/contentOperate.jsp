<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head_new.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=baseUri %>/public/ueditor1_3_6/lang/zh-cn/zh-cn.js"></script>
<link href="<%=baseUri %>/public/common/ress/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="<%=baseUri %>/public/common/ress/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=baseUri %>/public/ligerUI/skins/Gray/css/grid.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=baseUri %>/admin/channel/js/contentOperate.js"></script>
</head>
<body>
<script type="text/javascript">

//预览图片
function previewImg(n) {
	var img = $("#uploadImgPath"+n).val();
	if(img!="") {
		if(img.indexOf("?")==-1) {
			$("#preImg"+n).attr("src",img+"?d="+new Date()*1);
		} else {
			$("#preImg"+n).attr("src",img+"&d="+new Date()*1);
		}
		if(!$("#preImg"+n).attr("noResize")) {
			$("#preImg"+n).css("width","auto");
			$("#preImg"+n).css("height","auto");
		}
	} else {
		$("#preImg"+n).removeAttr("src");		
	}
}
</script>
<div class="body-box">
<form method="post"  id="contentForm">
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0" style="border-collapse: unset; border-spacing: 1px;" >
	<tr>
		<td width="20%" class="pn-flabel pn-flabel-h">所属栏目:</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			 <input name="content.channel_id" id="content.channel_id" type="hidden"/>
			 <span id="channelName"></span>
		</td>
		<td width="20%" class="pn-flabel pn-flabel-h">初始点击次数:</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			 <input name="content.views_day" type="text" id="content.views_day" ltype="text" validate="{required:true,minlength:1,maxlength:100}" value='<s:property value="content.views_day" />' style="width:200px"/>
		</td>
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">
			<span class="pn-frequired">*</span>标题:
		</td>
		<td colspan="3" width="40%" class="pn-fcontent">
			<input name="content.content_id"  value="<s:property value="content.content_id" />" type="hidden"/>
			<input name="content.title" type="text" id="content.title" ltype="text" validate="{required:true,minlength:1,maxlength:400}" value='<s:property value="content.title" />' style="width:500px"/>		
		</td>
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">
			简短标题:
		</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input type="text" name="content.short_title" id="content.short_title" ltype="text" validate="{minlength:1,maxlength:100}" value="<s:property value="content.short_title"/>" style="width:200px"/>
		</td>
		<td width="10%" class="pn-flabel pn-flabel-h">
			发布时间:
		</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input type="text" name="content.release_date" id="content.release_date" validate="{required:true}" value="<s:date name="content.release_date" format="yyyy-MM-dd HH:mm:ss" />" />
		</td>			
	</tr>	
	<tr>
		<td width="10%" class="pn-flabel">内容图:</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input type="text" id="uploadImgPath1" name="content.content_img" value="<s:property value="content.content_img"/>" style="width:220px"/> 
			<input type="button" value="预览" onclick="previewImg(1);" class="preview-button"/><br/>
			<span id="ufc1" style="position:relative">
				<input type='text' id='uploadFileText' name="uploadFileText" size="14"/> 
				<input onchange="$('#uploadFileText').val(this.value)" size="14" type="file" id="uploadFile" name="uploadFile" class="file-button"/>
			</span>	
			<input type="button" value="上传" onclick="ContentOperate.uploadFile();" class="upload-button"/><br/>
		</td>
		<td colspan="2" class="pn-fbutton">
			<img id="preImg1" alt="预览" style="width:100px;height:70px;background-color:#CCCCCC;border:1px solid #333"/>
		</td>
	</tr>
	<tr>
		<td colspan="4" class="pn-fcontent" style="text-align:left">
			<span>新闻内容:</span>
		</td>
	</tr>
	<tr>
		<td colspan="4" class="pn-flabel pn-flabel-h">
			<textarea name="contentTxt.txt" style="height:400px;width:850px" id="myEditor"><s:property value="contentTxt.txt" /></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4" class="pn-fbutton">			
			<input type="submit" value="提交" class="submit" id=""/> &nbsp; <input type="button" value="取消" class="reset"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>