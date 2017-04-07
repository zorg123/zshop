
//定义函数对象
var ContentOperate ={
	getDialog:function(){
		return frameElement.dialog;
	},
	getParentData:function(){
		return this.getDialog().get('data');
	},
	init:function(){
		var self = this;
		var parentData=this.getParentData();		
		$("#channelName").html(parentData.channel_name);
		$("input[id='content.channel_id']").val(parentData.channel_id);	
		//发布日期
		$("input[name='content.release_date']").ligerDateEditor({
            format: "yyyy-MM-dd hh:mm:ss", 
            showTime:true,
            initValue:$("input[name='content.release_date']").val()
		});
	 	$.metadata.setType("attr", "validate");
		$("#contentForm").validate({submitHandler:function (){           
			var queryString = $('#contentForm').formSerialize();
			//alert(queryString);
			CommonUtils.invokeAsyncAction(base+'/Channel/Channel!updateContent.do',queryString,function(reply){
				var result = reply.ret;
				if(result && result.code=='0'){					
					self.getDialog().close();
					parentData.callback();
				}else{
					$.ligerDialog.warn(reply._msg);
				}
			});
			}
		});
		$("input[type='button'][class='reset']").click(function(){
			self.getDialog().close();
		});
	},
	uploadFile:function(){		
		var fileName = $("#uploadFile").val();
		if(fileName==""){
			$.ligerDialog.warn("请先选择文件!")
			return false;
		}
		CommonUtils.uploadFile(base+"/Common/uploadImg.do", "uploadFile", {}, function(result){
			if(result.ret){
				result = result.ret;
				if(result.code=="0"){
					$("#uploadImgPath1").val(base+result.filePath);
				}
			}
		});
	}
}

$(function(){
	ContentOperate.init();
	UE.getEditor('myEditor',{
        toolbars: [
                   [ 'source', '|', 'undo', 'redo', '|',
                'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
                'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
                'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
                'directionalityltr', 'directionalityrtl', 'indent', '|',
                'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
                'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
                'insertimage', 'emotion', 'scrawl', 'insertvideo', 'music', 'attachment', 'map', 'gmap', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
                'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
                'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols',  '|',
                 'preview', 'searchreplace', 'help', 'drafts']
               ]
    });
})