var editIndex = undefined;
var Menu={
	qryMenu:function(id){
		var data ={"menuId":id};
		var queryParams = $('#menuList').datagrid('options').queryParams;
		$.extend(queryParams, data);		
    	$('#menuList').datagrid('reload');
	},
	loadFilter :function(data){
		//alert(CommonUtils.dumpObject(data,10))
    	if (data.ret){
			return data.ret;
		} else {
			return data;
		}
    },
	add:function(){
		
	},
	edit:function(){
	
	},
	del:function(){
		
	},
	save:function(){
	
	},
	formatState:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "0"){
			retVal="无效";
		}else if (value == "1"){
			retVal = "有效";
		}
		return retVal;
	},
	onDbClickRow:function(index){
		if (editIndex != index){
			if (Menu.endEditing()){
				$('#menuList').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#menuList').datagrid('selectRow', editIndex);
			}
		}
	},
	endEditing:function(){
		if (editIndex == undefined){return true}
		if ($('#menuList').datagrid('validateRow', editIndex)){
			var ed = $('#menuList').datagrid('getEditor', {index:editIndex,field:'state'});
			var state = $(ed.target).combobox('getText');
			$('#menuList').datagrid('getRows')[editIndex]['state'] = state;
			$('#menuList').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	},
	append:function append(){
		if (Menu.endEditing()){
			$('#menuList').datagrid('appendRow',{state:'1'});
			editIndex = $('#menuList').datagrid('getRows').length-1;
			$('#menuList').datagrid('selectRow', editIndex)
					.datagrid('beginEdit', editIndex);
		}
	},
	reject: function (){		
		$('#menuList').datagrid('rejectChanges');
		editIndex = undefined;
	},
	remove:function (){ //删除正在编辑的行
		if (Menu.endEditing()){
			var sRows = $('#menuList').datagrid('getSelections');
			if(sRows.length>0){
				for(var i=0;i<sRows.length;i++){
					var r = sRows[i];
					var rIndex = $('#menuList').datagrid('getRowIndex',r);
					$('#menuList').datagrid('deleteRow',rIndex);
				}
			}else{
				$.messager.alert('系统提示', '未选择要删除的行!', 'info');
			}
		}
	},	
	acceptChanges : function (){//获取有变化的记录
		if (!Menu.endEditing()){
			$.messager.alert('系统提示', '编辑的行数据校验不通过!', 'info');;
		}
		var rows = $('#menuList').datagrid('getChanges','inserted');
		if(rows.length>0){
			var node = $('#menu_tree').tree('getSelected');
			var parentId= "-1";
			if(node){
				parentId = node.id;
			}
			for(var i=0;i<rows.length;i++){
				var t = rows[i];
				t.up_menu_id = parentId;
				rows[i] = t;
			}
		}
		var deleteRows = $('#menuList').datagrid('getChanges','deleted');
		var updateRows = $('#menuList').datagrid('getChanges','updated');
		//alert(CommonUtils.dumpObject(rows));
		//alert(rows.length+' rows are changed!');
		if(rows.length>0 || deleteRows.length>0 || updateRows.length>0){
			var param = {};	
			param.insertList = rows;
			param.deleteList = deleteRows;
			param.updateList = updateRows;
			CommonUtils.invokeAsyncJsonAction(base+'/Sys/Sys!optMenuList.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '操作成功!', 'info');	  
	                	$('#menuList').datagrid('reload');
	                }else{
	                	$.messager.alert('系统提示', '操作失败!', 'info');
	                }
				}			
			});
		}else{
			$.messager.alert('系统提示', '没有要保存的更改数据!', 'info');
		}
	}
}

$(function(){
	$('#menu_tree').tree({
		url:base+"/Sys/Login!getSubMenuTreeByUpId.do?menuId=-1",		
		loadFilter:function(data){	
			editIndex = undefined;
			return Menu.loadFilter(data);
		},
		onClick:function(node){
			var node = $('#menu_tree').tree('getSelected');			
			var param = {"menuId":node.id};			
			if($('#menu_tree').tree('isLeaf',node.target)){
				CommonUtils.invokeAsyncAction(base+'/Sys/Login!getSubMenuTreeByUpId.do', param, function (reply) {
					if((reply || '') !=''){
						var code = reply._code;
		                if(code=='0'){	 
		                	var menus = reply.ret;
		                	if((menus||'') !=''){
		                		$('#menu_tree').tree('append', {
		                            parent: (node ? node.target : null),
		                            data: menus
		                        });
		                	}	                	 
		                }else{
		                	$.messager.alert('系统提示', '加载子节点失败!', 'info');
		                }
					}
					
				});
			}
			Menu.qryMenu(node.id);
		},
		onContextMenu: function(e, node){
			e.preventDefault();
		}
	});
	
	$('#menuList').datagrid({
		url:base+"/Sys/Login!getSubMenuPagerListByUpId.do",
		queryParams:{
			"menuId":"-1"
		},
		loadFilter:function(data){
			editIndex = undefined;
			return Menu.loadFilter(data);
		},
		columns:[[  {field:'ck',checkbox:true},
					{field:'menu_id',title:'菜单ID',editor:'text'},    
					{field:'menu_name',title:'菜单名称',editor:'text'},
					{field:'menu_url',title:'菜单链接',editor:'text'},
					{field:'url_open_type',title:'打开方式',editor:'text'},
					{field:'menu_desc',title:'功能描述',editor:'text'},
					{field:'state',title:'菜单状态',formatter:Menu.formatState,editor:{
						type:'combobox',
						options:{
							valueField:'state',
							textField:'stateName',
							url:'state.json',
							required:true
						}}},
					{field:'order_id',title:'排序ID',editor:'text'}
						          
		 ]] ,
		toolbar:[{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){				
			  Menu.append();
			}
		},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){
				Menu.remove();//var row = $('#tt').datagrid('getSelected');
			}
		},'-',{
			text:'撤销更改',
			iconCls:'icon-undo',
			handler:function(){
				Menu.reject();
			}
		},'-',{
			text:'保存更改',
			iconCls:'icon-save',
			handler:function(){
				//$('#menuList').datagrid('acceptChanges');
				Menu.acceptChanges();
			}
		}]
	});
});
