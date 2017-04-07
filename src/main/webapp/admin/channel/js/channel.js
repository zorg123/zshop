//定义函数对象
var Channel ={
	init:function(){
		$("#mainLayout").ligerLayout({ leftWidth: 190, height: '100%',space:4});
    
		Channel.param={};
		var self= this;
		Channel.channelTree = $("#channelTree").ligerTree({        
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
			    param["channel.parent_id"] = node.data.channel_id;			   
			    self.setParam(param);			    
	            if(self.channelList){	  
	            	var options = self.channelList.options;
	            	options.newPage = 1;
	            	self.channelList.reload(self.channelList.options.where);
	            }
				if(!$(node.target).attr("isLoad")){
	            	self.getSubChannel(this,node,node.data.channel_id);
	            	$(node.target).attr("isLoad", true);
				}
	        }
	    });
		//CommonUtils.invokeAsyncAction('/Channel/Channel!qryChannelList.do',{"channel.parent_id":-1},function(reply){
		//	reply = reply.ret;
		//	channelTree.append(channelTree.getNodeDom(0),reply);
		//});
		
		Channel.channelList = $("#channelList").ligerGrid({        
            width:'100%',
            checkbox: false,
            columns: [
                { display: 'ID', name: 'channel_id', minWidth: 40,width: '5%' },	 
	            { display: '栏目名称', name: 'channel_name', align: 'left', width: '40%', minWidth: 60 },
	            { display: '访问路径', name: 'channel_path', minWidth: 140, width: '40%' },
	            { display: '排序', name: 'priority', minWidth: 40, width: '5%' },
	            { display: '显示', name: 'is_display', minWidth: 40 , width: '5%'}	            
            ],
            url:base+'/Channel/Channel!qryChannelPageList.do',
            pageSizeOptions: [5, 10, 15, 20],
            height: '98%',
            pageSize:15 ,
            root:'rows',
            parms:self.getParam,
            pageParmName:'page',
            pagesizeParmName:'rows',
            record:'total',
            rownumbers:true,
            toolbar: { items: [
	            { text: '增加', icon: 'add' ,click:self.showAddChannel,img: base+'/public/ligerUI/skins/icons/add.gif'},
	            { line: true },
	            { text: '修改', icon: 'modify' ,click:self.showModifyChannel,img: base+'/public/ligerUI/skins/icons/modify.gif'},
	            { line: true },
	            { text: '删除',click:self.deleteChannel,img: base+'/public/ligerUI/skins/icons/delete.gif' }
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
			 url: base+'/Channel/editChannel.do', 
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
			 url: base+'/Channel/editChannel.do?channel.channel_id='+sRow.channel_id, 
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
				CommonUtils.invokeAsyncAction(base+'/Channel/Channel!deleteChannel.do',{"channel.channel_id":sRow.channel_id},function(reply){
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