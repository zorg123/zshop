
//定义函数对象
var Content ={
	init:function(){
		$("#mainLayout").ligerLayout({ leftWidth: 190, height: '100%',space:4});		
		Content.param={};
		var self= this;
		Content.channelTree = $("#channelTree").ligerTree({        
	        checkbox: false,
	        slide: false,
	        nodeWidth: 120,
	        idFieldName:'channel_id',
	        parentIDFieldName:'parent_id',
	        textFieldName:'channel_name',
	        attribute: ['channel_id', 'channel_name'],
	        onSelect: function (node)
	        {	 
			    var param = {};
			    param["content.channel_id"] = node.data.channel_id;
			    self.setParam(param);
	            if(self.contentList){	
	            	var options = self.contentList.options;
	            	options.newPage = 1;
	            	self.contentList.reload(self.contentList.options.where);
	            }
				if(!$(node.target).attr("isLoad")){
	            	self.getSubChannel(this,node,node.data.channel_id);
	            	$(node.target).attr("isLoad", true);
				}
	        }
	    });
		
		Content.contentList = $("#contentList").ligerGrid({
            height:'98%',
            width:'100%',
            checkbox: false,
            columns: [
                { display: 'ID', name: 'content_id', minWidth: 40 },	 
	            { display: '标题', name: 'title', align: 'left', width: 400, minWidth: 60 },
	            { display: '访问数', name: 'views_day', minWidth: 40 }	            
            ],
            url:base+'/Channel/Channel!qryContentPageList.do',
            pageSizeOptions: [5, 10, 15, 20],
            pageSize:15 ,
            root:'rows',
            parms:self.getParam,
            pageParmName:'page',
            pagesizeParmName:'rows',
            record:'total',
            rownumbers:true,
            toolbar: { items: [
	            { text: '增加', icon: 'add' ,click:self.showAddContent,img: base+'/public/ligerUI/skins/icons/add.gif'},
	            { line: true },
	            { text: '修改', icon: 'modify' ,click:self.showModifyContent,img: base+'/public/ligerUI/skins/icons/modify.gif'},
	            { line: true },
	            { text: '删除',click:self.deleteContent,img: base+'/public/ligerUI/skins/icons/delete.gif' }
	          ]
            } 
        });
	},
	getSubChannel:function(thisTree,node,parent_id){
		CommonUtils.invokeAsyncAction(base+'/Channel/Channel!qryChannelList.do',{"channel.parent_id":parent_id},function(reply){
			reply = reply.ret;
			thisTree.append(node.target,reply);
		});
	},
	setParam:function(param){
		Content.param = param;
	},
	getParam:function(){
		if(!Content.param){
			Content.param ={};
		}
		return Content.param;
	},
	showAddContent:function(){
		var selectParentChannel = Content.channelTree.getSelected();
		if(!selectParentChannel){
			$.ligerDialog.warn("请选择左侧要添加内容的栏目!");
			return false;
		}
		if(selectParentChannel.data.channel_id=='-1'){
			$.ligerDialog.warn("根目录下不能添加内容!");
			return false;
		}
	    var m = $.ligerDialog.open({
			 title:'内容添加', 
			 url: base+'/Channel/editContent.do', 
			 height: 600,
			 width:900,
			 isResize: true,
			 slide: false,
			 showToggle: true,
			 data: {
			 	channel_name: selectParentChannel.data.channel_name,
             	channel_id: selectParentChannel.data.channel_id,
             	callback:Content.operateCallBack
         	 }
		  });
	},
	showModifyContent:function(){
		var selectParentChannel = Content.channelTree.getSelected();
		if(!selectParentChannel){
			$.ligerDialog.warn("请选择左侧要添加内容的栏目!");
			return false;
		}
		var sRow = Content.contentList.getSelectedRow();
		if(!sRow){
			$.ligerDialog.warn("请选择要修改的内容");
			return false;
		}		
	    var m = $.ligerDialog.open({
			 title:'内容修改', 
			 url: base+'/Channel/editContent.do?content.content_id='+sRow.content_id, 
			 height: 600,
			 width:900,
			 isResize: true,
			 slide: false,
			 showToggle: true,
			 data: {
			 	channel_name: selectParentChannel.data.channel_name,
             	channel_id: selectParentChannel.data.channel_id,
             	callback:Content.operateCallBack
         	 }
		  });
	},
	deleteChannel:function(){
		var sRow = Content.contentList.getSelectedRow();
		if(!sRow){
			$.ligerDialog.warn("请选择要删除的栏目");
			return false;
		}
		$.ligerDialog.confirm("确定要删除 "+sRow.title+" 吗?",function(flag){
			if(flag){
				CommonUtils.invokeAsyncAction(base+'/Channel/Channel!deleteContent.do',{"content.content_id":sRow.content_id},function(reply){
					var result = reply.ret;
					if(result && result.code =='0'){
						$.ligerDialog.success('删除成功!');
						Content.operateCallBack();
					}else{
						$.ligerDialog.error(reply._msg);
					}
				});
			}
		});
	},
	operateCallBack:function(){
		$.ligerDialog.warn("操作成功");
		Content.contentList.reload();
	}
}

$(function(){
	Content.init();
})