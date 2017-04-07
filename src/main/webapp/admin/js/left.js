var menuTree ="";
var setting = {
	expandSpeed: "",
	showLine: true,
	callback:{
		click:getSubMenuNode
	}
};

$(document).ready(function(){	
	getSubMenJsonByParentId(menuId,initMenuCallBack);
});

function initMenuCallBack(retValue){
	menuTree = $("#menuTreeUL").zTree(setting,retValue);
}

function getSubMenuNode(event, treeId, treeNode){
	var nMenuId = treeNode.id;
	//如果已经没有子节点，则找子节点，否则不找
	if(!treeNode.nodes){
		getSubMenJsonByParentId(nMenuId,function(retValue){
			if(retValue.length>0){
				menuTree.addNodes(treeNode,retValue);
				menuTree.expandNode(treeNode,true,false);
			}
		});
	}
}

function getSubMenJsonByParentId(tmenuId,callBack){	
	//获取菜单	
	MenuService.getSubMenuJsontByUpId(tmenuId,function(data){
		if(data!=null){
			var code = data.code;
			if(code == '0000'){
				var retValue = eval(data.retValue);
				for(var i=0;i<retValue.length;i++){
					var node = retValue[i];
					if(node.url_open_type == '1'){
						node.target="_blank";
					}else{
						node.target="rightFrame";
					}
				}				
				callBack&callBack(retValue);				
			}else{
				alert(data.msg);
			}
		}
	});
}