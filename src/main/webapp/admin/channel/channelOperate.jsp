<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<jsp:include page="/admin/main/head_new.jsp"></jsp:include>
<link href="<%=baseUri %>/public/common/ress/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="<%=baseUri %>/public/common/ress/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=baseUri %>/public/ligerUI/skins/Gray/css/grid.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=baseUri %>/admin/channel/js/channelOperate.js"></script>
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
<form method="post"  id="channelForm">
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0" style="border-collapse: unset; border-spacing: 1px;" >
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">上级栏目:</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			 <input name="channel.parent_id" id="channel.parent_id" type="hidden"/>
			 <span id="parentName"></span>
		</td>
		<td width="10%" class="pn-flabel pn-flabel-h">
			<span class="pn-frequired">*</span>栏目名称:
		</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input name="channel.channel_id"  value="<s:property value="channel.channel_id" />" type="hidden"/>
			<input name="channel.channel_name" type="text" id="channel.channel_name" ltype="text" validate="{required:true,minlength:1,maxlength:100}" value='<s:property value="channel.channel_name" />' style="width:200px"/>		
		</td>
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">
			访问路径:
		</td>
		<td colspan="3" width="40%" class="pn-fcontent">
			<input type="text" name="channel.channel_path" id="channel.channel_path" ltype="text" validate="{minlength:1,maxlength:100}" value="<s:property value="channel.channel_path"/>" style="width:400px"/><span class="pn-fhelp">该地址会默认添加channelId参数</span>
		</td>
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">
			<span class="pn-frequired">*</span>排列顺序:
		</td>
		<td colspan="3" width="40%" class="pn-fcontent">
			<input type="text" name="channel.priority" id="channel.priority" ltype="text" validate="{required:true,minlength:1,maxlength:4}" value="<s:property value="channel.priority"/>"/>
		</td>	
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">meta标题:</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input type="text" name="channel.title" id="channel.title" ltype="text" validate="{minlength:1,maxlength:255}" value="<s:property value="channel.title"/>" style="width:200px"/>
		</td>
		<td width="10%" class="pn-flabel pn-flabel-h">
			meta关键字:
		</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input type="text" name="channel.keywords" id="channel.keywords" ltype="text" validate="{minlength:1,maxlength:255}" value="<s:property value="channel.keywords"/>" style="width:200px"/>
		</td>
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">meta描述:</td>
		<td colspan="3" width="90%" class="pn-fcontent">
			<textarea cols="100" rows="4" name="channel.description" id="channel.description" style="width:400px"  style="width:200px" ><s:property value="channel.description"/></textarea>
		</td>
	</tr>	
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">
			<span class="pn-frequired">*</span>显示:
		</td>
		<td colspan="3" width="40%" class="pn-fcontent">
			<input id="displayOne" type="radio" name="channel.is_display" value="true" <s:if test="channel.is_display == true || channel.is_display == null || channel.is_display == ''"> checked="checked" </s:if> /><label for="displayOne">是</label> 
			<input id="displayTwo" type="radio" name="channel.is_display" value="false" <s:if test="channel.is_display == false "> checked="checked" </s:if> /><label for="displayTwo">否</label>
		</td>	
	</tr>
	<tr>
		<td width="10%" class="pn-flabel pn-flabel-h">外部链接:</td>
		<td colspan="3" width="40%" class="pn-fcontent">
			<input type="text" name="channel.link" id="channel.link" ltype="text" validate="{minlength:1,maxlength:255}" value="<s:property value="channel.link"/>" style="width:400px"/>
			<span class="pn-fhelp">直接使用该地址作为url</span>
		</td>
	</tr>
	<tr>
		<td width="10%" class="pn-flabel">标题图:</td>
		<td colspan="1" width="40%" class="pn-fcontent">
			<input type="text" id="uploadImgPath1" name="channel.title_img" value="<s:property value="channel.title_img"/>" style="width:220px"/> 
			<input type="button" value="预览" onclick="previewImg(1);" class="preview-button"/><br/>
			<span id="ufc1" style="position:relative">
				<input type='text' id='uploadFileText' name="uploadFileText" size="14"/> 
				<input onchange="$('#uploadFileText').val(this.value)" size="14" type="file" id="uploadFile" name="uploadFile" class="file-button"/>
			</span>	
			<input type="button" value="上传" onclick="ChannelOperate.uploadFile();" class="upload-button"/><br/>
			宽: <input type="text" name="channel.title_img_width" id="channel.title_img_width" value="<s:property value="channel.title_img_width"/>" size="5"/> 
			高: <input type="text" name="channel.title_img_height" id="channel.title_img_height" value="<s:property value="channel.title_img_height"/>" size="5"/>
		</td>
		<td colspan="2" class="pn-fbutton">
			<img id="preImg1" alt="预览" style="width:100px;height:70px;background-color:#CCCCCC;border:1px solid #333"/>
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