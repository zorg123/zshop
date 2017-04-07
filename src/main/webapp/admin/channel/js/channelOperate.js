
//定义函数对象
var ChannelOperate ={
	getDialog:function(){
		return frameElement.dialog;
	},
	getParentData:function(){
		return this.getDialog().get('data');
	},
	init:function(){
		var self = this;
		var parentData=this.getParentData();		
		$("#parentName").html(parentData.channel_name);
		$("[id='channel.parent_id']").val(parentData.channel_id);	
		
	 	$.metadata.setType("attr", "validate");
		$("#channelForm").validate({submitHandler:function (){  
			if($("[id='channel.channel_path']").val()=="" && $("[id='channel.link']").val()==""){
				$.ligerDialog.warn("访问路径和外部链接不能同时为空!")
				return false;
			}
			var queryString = $('#channelForm').formSerialize();			
			CommonUtils.invokeAsyncAction(base+'/Channel/Channel!updateChannel.do',queryString,function(reply){
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
	ChannelOperate.init();
})