
//定义函数对象
var Config ={
	init:function(){
		$("#mainLayout").ligerLayout({ leftWidth: 190, height: '100%',space:4});
		Config.configList = $("#channelList").ligerGrid({
            height:'100%',
            width:'98%',
            checkbox: false,
            columns: [
                { display: 'ID', name: 'channel_id', minWidth: 40 },	 
	            { display: '配置描述', name: 'channel_name', align: 'left', width: 300, minWidth: 60 },
	            { display: '配置值', name: 'channel_path', minWidth: 140 },
	            { display: '配置时间', name: 'priority', minWidth: 40 },
	            { display: '配置类型', name: 'is_display', minWidth: 40 }	            
            ],
            url:'/Channel/Channel!qryChannelPageList.do',
            pageSizeOptions: [5, 10, 15, 20],
            pageSize:15 ,
            root:'rows',
            parms:self.getParam,
            pageParmName:'page',
            pagesizeParmName:'rows',
            record:'total',
            rownumbers:true,
            toolbar: { items: [
	            { text: '增加', icon: 'add' ,click:self.showAddChannel,img: '/public/ligerUI/skins/icons/add.gif'},
	            { line: true },
	            { text: '修改', icon: 'modify' ,click:self.showModifyChannel,img: '/public/ligerUI/skins/icons/modify.gif'},
	            { line: true },
	            { text: '删除',click:self.deleteChannel,img: '/public/ligerUI/skins/icons/delete.gif' }
	          ]
            } 
        });
	},
	getSubChannel:function(thisTree,node,parent_id){
		CommonUtils.invokeAsyncAction('/Channel/Channel!qryChannelList.do',{"channel.parent_id":parent_id},function(reply){
			reply = reply.ret;
			thisTree.append(node.target,reply);
		});
	},
	setParam:function(param){
		Channel.param = param;
	},
	getParam:function(){
		if(!Channel.param){
			Channel.param ={};
		}
		return Channel.param;
	},
	showAddChannel:function(){
		var selectParentChannel = Channel.channelTree.getSelected();
		if(!selectParentChannel){
			$.ligerDialog.warn("请选择左侧的父栏目!");
			return false;
		}
	    var m = $.ligerDialog.open({
			 title:'栏目添加', 
			 url: '/Channel/editChannel.do', 
			 height: 500,
			 width:800,
			 isResize: true,
			 slide: false,
			 showToggle: true,
			 data: {
			 	channel_name: selectParentChannel.data.channel_name,
             	channel_id: selectParentChannel.data.channel_id,
             	callback:Channel.operateCallBack
         	 }
		  });
	},
	showModifyChannel:function(){
		var selectParentChannel = Channel.channelTree.getSelected();
		if(!selectParentChannel){
			$.ligerDialog.warn("请选择左侧的父栏目!");
			return false;
		}
		var sRow = Channel.channelList.getSelectedRow();
		if(!sRow){
			$.ligerDialog.warn("请选择要修改的栏目");
			return false;
		}		
	    var m = $.ligerDialog.open({
			 title:'栏目修改', 
			 url: '/Channel/editChannel.do?channel.channel_id='+sRow.channel_id, 
			 height: 500,
			 width:800,
			 isResize: true,
			 slide: false,
			 showToggle: true,
			 data: {
			 	channel_name: selectParentChannel.data.channel_name,
             	channel_id: selectParentChannel.data.channel_id,
             	callback:Channel.operateCallBack
         	 }
		  });
	},
	deleteChannel:function(){
		var sRow = Channel.channelList.getSelectedRow();
		if(!sRow){
			$.ligerDialog.warn("请选择要删除的栏目");
			return false;
		}
		$.ligerDialog.confirm("确定要删除 "+sRow.channel_name+" 吗?",function(flag){
			if(flag){
				CommonUtils.invokeAsyncAction('/Channel/Channel!deleteChannel.do',{"channel.channel_id":sRow.channel_id},function(reply){
					var result = reply.ret;
					if(result && result.code =='0'){
						$.ligerDialog.success('删除成功!');
						Channel.operateCallBack();
					}else{
						$.ligerDialog.error(reply._msg);
					}
				});
			}
		});
	},
	operateCallBack:function(){
		$.ligerDialog.warn("操作成功");
		Channel.channelList.reload();
	}
}

$(function(){
	Channel.init();
})