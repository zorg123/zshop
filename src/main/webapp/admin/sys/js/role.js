var type = "save";
var addMenuArray=[];
var deleteMenuArray=[];
var parentNodeCacheArray=[];//存放需要删除的父节点，如果没有子节点的话，就删除
var Role = {
    save: function () {
        var role_name = $('input[name="role_name"]').val();
        var role_desc = $('textarea[name="role_desc"]').val();

        if (this.check()) {
            var param = {};
            param["tbRole.role_name"] = role_name;
            param["tbRole.role_desc"] = role_desc;
            var me = this;
            CommonUtils.invokeAsyncAction(base+'/Sys/Sys!insertRole.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '添加成功!', 'info');	  
	                	$('#roleList').datagrid('reload');
	                }else{
	                	$.messager.alert('系统提示', '添加失败!', 'info');
	                }
				}			
			});           
        }
    },
    update: function (obj) {
        var role_name = $('input[name="role_name"]').val();
        var role_desc = $('textarea[name="role_desc"]').val();

        if (null === obj || undefined === obj) {
            $.messager.alert('系统提示', '修改失败!', 'info');
            return;
        }
        if (this.check()) {
            var param = {};
            param["tbRole.role_name"] = role_name;
            param["tbRole.role_desc"] = role_desc;
            param["tbRole.role_id"] = obj;           
            var me = this;
            CommonUtils.invokeAsyncAction(base+'/Sys/Sys!updateRole.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '修改成功!', 'info');	  
	                	 me.clear();
	                     me.refresh();
	                }else{
	                	$.messager.alert('系统提示', '修改失败!', 'info');
	                }
				}			
			});            
        }
    },
    deleteRole: function (obj) {
        var me = this;
        var param = {};
        param["tbRole.role_id"] = obj;
        CommonUtils.invokeAsyncAction(base+'/Sys/Sys!deleteRole.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){
                	$.messager.alert('系统提示', '删除成功!', 'info');
                     me.refresh();
                }else{
                	$.messager.alert('系统提示', '删除失败!', 'info');
                }
			}			
		});        
    },
    check: function () {
        var role_name = $('input[name="role_name"]').val();
        var role_desc = $('textarea[name="role_desc"]').val();
        if ((role_name || '') === '' || role_name.length === 0) {
            $.messager.alert('系统提示', '角色名称不能为空!', 'info');
            return false;
        }
        return true;
    },
    clear: function () {
        $('input[name="role_name"]').val('');
        $('textarea[name="role_desc"]').val('');
    },
    close: function () {
        $('#win_save').window('close');
        $('#win_save').hide();
    },
    closeMenu:function(){
    	$('#win_menu').window('close');
        $('#win_menu').hide();
    },
    refresh: function () {
        $('#roleList').datagrid('reload')
    },
    queryRoleById: function (obj) {
        var param = {}, me = this;
        param["tbRole.role_id"] = obj;        
        CommonUtils.invokeAsyncAction(base+'/Sys/Sys!getRoleInfo.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){
                	 var result = reply.ret;
                	 if(result.length>0){
                		 me.setValues(result[0]);
                	 }
                	 
                }
			}			
		});
    },
    setValues: function (obj) {
        $('input[name="role_name"]').val(obj.role_name);
        $('textarea[name="role_desc"]').val(obj.role_desc);
    },
    loadTree: function () {//加载功能点树
        var me = this;
        var row = $('#roleList').datagrid('getSelected');
        if(!row){
        	$.messager.alert('系统提示', '请选择一个角色!', 'info');
        	return;
        }
        $('#menu_tree').tree({
    		url:base+"/Sys/Login!getNoSelectRootMenuByRole.do?roleId="+row.role_id,	
    		checkbox: true,
    		cascadeCheck:true,
    		loadFilter:function(data){        	            	
    			return CommonUtils.loadFilter(data);
    		},
    		onClick:function(node){    
    			$('#menu_tree').tree('toggle',node.target);
    			/**
    			var node = $('#menu_tree').tree('getSelected');			
    			var param = {"menuId":node.id,"roleId":row.role_id};			
    			if($('#menu_tree').tree('isLeaf',node.target)){
    				CommonUtils.invokeAsyncAction('/Sys/Login!getNoSelectSubMenuListByUpId.do', param, function (reply) {
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
    			*/
    		},
    		onContextMenu: function(e, node){
    			e.preventDefault();
    		}
    	});  
        
        $('#menu_select_tree').tree({
    		url:base+"/Sys/Login!getRootMenuByRole.do?roleId="+row.role_id,	
    		checkbox: true,
    		cascadeCheck:true,
    		loadFilter:function(data){ 
				return CommonUtils.loadFilter(data);
    		},
    		onClick:function(node){
    			$('#menu_select_tree').tree('toggle',node.target);
    			/**
    			var node = $('#menu_select_tree').tree('getSelected');			
    			var param = {"menuId":node.id,"roleId":row.role_id};			
    			if($('#menu_select_tree').tree('isLeaf',node.target)){
    				CommonUtils.invokeAsyncAction('/Sys/Login!getSubMenuListByUpIdAndRole.do', param, function (reply) {
    					if((reply || '') !=''){
    						var code = reply._code;
    		                if(code=='0'){	 
    		                	var menus = reply.ret;
    		                	if((menus||'') !=''){
    		                		$('#menu_select_tree').tree('append', {
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
    			*/
    		},
    		onContextMenu: function(e, node){
    			e.preventDefault();
    		}
    	});
    },
    unCheck: function () {//取消树的选中状态
        var nodes = $('#menu_tree').tree('getChecked');
        $.each(nodes, function (i, value) {
            $('#menu_tree').tree('uncheck', value.target);
        })
    },
    getCheck: function () {
        var arrayChecked = $('#menu_tree').tree('getChecked');
        var nodes = [];        
        var array = [];
        $.each(nodes, function (i, value) {
            array.push(value.id);
        });
        $.each(arrayChecked, function (i, value) {
            array.push(value.id);
        })

        $.unique(array);
        var ids = '';
        $.each(array, function (i, value) {
            ids += value
            ids += ',';
        })
        ids = ids.substring(0, ids.lastIndexOf(','));
        return ids;
    },
    saveRoleFun: function () {
        var me = this;       
        if (addMenuArray.length == 0 && deleteMenuArray.length == 0) {
            $.messager.alert('系统提示', '未变更任何权限!', 'info');
            return;
        }
        var row = $('#roleList').datagrid('getSelected');
        var addRoleMenus = addMenuArray.join(',');
        var deleteRoleMenus = deleteMenuArray.join(',');
        var param = {};
        param["deleteRoleMenus"] = deleteRoleMenus;
        param["addRoleMenus"] = addRoleMenus;
        param["roleId"] = row.role_id;

        CommonUtils.invokeAsyncAction(base+'/Sys/Login!saveRoleMenu.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){	
                	$.messager.alert('系统提示', '操作成功!', 'info');
                	me.closeMenu();                	 
                }else{
                	$.messager.alert('系统提示', '操作失败!', 'info');
                }
			}
			
		});
    },
    queryFnu: function (obj) {
        var me = this;
        var param = {};
        param.role_id = obj;

        Service.async('role', 'getFunIdByRoleId', param, function (reply) {
            var result = reply.RESULT;
            if ((result || false) !== false) {
                me.setTreeCheck(result);
            }
        })
    },
    setTreeCheck: function (datas) {//根据角色查询功能点
        $.each(datas, function (i, value) {
            var node = $('#menu_tree').tree('find', value.fun_id);
            if (null != node)$('#menu_tree').tree('check', node.target);
        })
    },
    expandAll: function () {
        var node = $('#menu_tree').tree('getSelected');
        if (node) {
            $('#menu_tree').tree('expandAll', node.target);
        } else {
            $('#menu_tree').tree('expandAll');
        }
    },
    clear: function () {
        $('input[name="role_name"]').val('');
        $('textarea[name="role_desc"]').val('');
    },
    addFun:function(){
    	var me = this;
    	parentNodeCacheArray = [];
    	var arrayChecked = $('#menu_tree').tree('getChecked');
    	if(arrayChecked!=null){
    		$.each(arrayChecked, function (i, value) {
                var tId = value.id;
                if(tId != -1 && $('#menu_select_tree').tree('find',tId) == null){
	                var selectTreeNode = me.getParentInSelectTree(value,"menu_tree","menu_select_tree",false);
	                $('#menu_select_tree').tree('append', {
	    				parent: selectTreeNode.target,
	    				data: [{
	    					id: value.id,
	    					text: value.text
	    				}]
	                });
	               	me.addToAddArray(value.id);
                }
                //if($('#menu_tree').tree('isLeaf',value.target)){
                //	$('#menu_tree').tree('remove',value.target);
                //}else{
                //	parentNodeCacheArray.push(value);
               // }                
            });
    		if(parentNodeCacheArray.length>0){
        		$.each(parentNodeCacheArray,function(i,v){        			
        			//alert($('#menu_tree').tree('getChildren',v.target));
        			if(v.id != -1 && ($('#menu_tree').tree('getChildren',v.target) == null || $('#menu_tree').tree('getChildren',v.target).length == 0) ){
        				$('#menu_tree').tree('remove',v.target);
        			}
        		});
        	}
    	}    	
    	//alert(addMenuArray.join(","));
    },
    getParentInSelectTree:function(node,sourceTree,targetTree,dFlag){//递归查找已选择中是否有新建的
    	 var parentNode = $('#'+sourceTree).tree('getParent',node.target);
    	 var selectTreeNode = $('#'+targetTree).tree('find',parentNode.id);
    	 if(!selectTreeNode){    		 
    		 selectTreeNode = Role.getParentInSelectTree(parentNode,sourceTree,targetTree,dFlag);
    		 var tt = $('#'+targetTree).tree('append', {
    				parent: selectTreeNode.target,
    				data: [{
    					id: parentNode.id,
    					text: parentNode.text
    				}]
    		 });
    		 selectTreeNode = $('#'+targetTree).tree('find',parentNode.id);
    		 if(!dFlag){
    			 Role.addToAddArray(parentNode.id);
    		 }else{
    			 Role.addToDeleteArray(parentNode.id);
    		 }
    	 }
    	 return selectTreeNode;
    },
    delFun:function(){
    	var me = this;
    	parentNodeCacheArray=[];
    	var arrayChecked = $('#menu_select_tree').tree('getChecked');
    	if(arrayChecked!=null){
    		$.each(arrayChecked, function (i, value) {
                var tId = value.id;
                if(tId != -1 ){
                	if($('#menu_tree').tree('find',tId) == null){
		                var selectTreeNode = me.getParentInSelectTree(value,"menu_select_tree","menu_tree",true);
		                $('#menu_tree').tree('append', {
		    				parent: selectTreeNode.target,
		    				data: [{
		    					id: value.id,
		    					text: value.text
		    				}]
		                });    
                	}
	                me.addToDeleteArray(tId);
                }
                if($('#menu_select_tree').tree('isLeaf',value.target)){
                	$('#menu_select_tree').tree('remove',value.target);
                }else{
                	parentNodeCacheArray.push(value);
                } 
            });
    		if(parentNodeCacheArray.length>0){
        		$.each(parentNodeCacheArray,function(i,v){
        			//alert($('#menu_select_tree').tree('getChildren',v.target));
        			if(v.id != -1 && ($('#menu_select_tree').tree('getChildren',v.target) == null || $('#menu_select_tree').tree('getChildren',v.target).length == 0)){
        				$('#menu_select_tree').tree('remove',v.target);
        			}
        		});
        	}
    	}    	
    	//alert(deleteMenuArray.join(","));
    },
    addToDeleteArray:function(value){//如果存在添加的列表中，则不填加到删除的列表，并从添加的列表中删除
    	var aIdx = addMenuArray.getIndexByValue(value);
    	if(aIdx == -1){
    		deleteMenuArray.push(value);
    	}else{
    		addMenuArray.remove(aIdx);
    	}
    },
    addToAddArray:function(value){//如果存在删除的列表中，则不填加到添加的列表，并从删除的列表中删除
    	var aIdx = deleteMenuArray.getIndexByValue(value);
    	if(aIdx == -1){
    		addMenuArray.push(value);
    	}else{
    		deleteMenuArray.remove(aIdx);
    	}
    }
}


$(function () {
    $('#roleList').datagrid({
        url: base+'/Sys/User!queryRoleList.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
        toolbar: [
            {
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {
                    sign = 'save';
                    Role.clear();
                    $('#win_save').attr('title', '添加角色');
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 350,
                        height: 250,
                        modal: true
                    });
                }
            },
            '-',
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    var row = $('#roleList').datagrid('getSelected');
                    if (null == row) {
                        $.messager.alert('系统提示', '请选择要删除的记录!', 'info');
                        return;
                    }

                    $.messager.confirm('系统提示', '是否删除？', function (r) {
                        if (r) {
                            Role.deleteRole(row.role_id);
                        }
                    })
                }
            },
            '-',
            {
                text: '修改',
                iconCls: 'icon-undo',
                handler: function () {
                    sign = 'update';
                    var row = $('#roleList').datagrid('getSelected');
                    if (null == row) {
                        $.messager.alert('系统提示', '请选择要修改的记录!', 'info');
                        return;
                    }
                    Role.queryRoleById(row.role_id);
                    $('#win_save').attr('title', '修改角色');
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 350,
                        height: 250,
                        modal: true
                    });
                }
            },
            '-',
            {
                text: '关联菜单',
                iconCls: 'icon-reload',
                handler: function () {
                    var row = $('#roleList').datagrid('getSelected');
                    if (null == row) {
                        $.messager.alert('系统提示', '未选中记录行!', 'info');
                        return;
                    }
                    addMenuArray=[];
                    deleteMenuArray=[];
                    parentNodeCacheArray=[];
                    $('#win_menu').show();
                    $('#win_menu').window({
                        width: 600,
                        height: 430,
                        modal: true
                    });
                    Role.loadTree();
                }
            }           
        ]
    });

    $('#save').click(function () {
        if (sign === 'update') {
            var row = $('#roleList').datagrid('getSelected');
            Role.update(row.role_id);
        } else  Role.save();
    });
    $('#cancel').click(function () {
        Role.clear();
    });

    $('#role_fun_cancel').bind('click', function () {
        Role.closeMenu();
    });

    $('#role_fun_save').bind('click', function () {
        Role.saveRoleFun();
    });

    $('#role_fun_add').bind('click', function () {
        Role.addFun();
    });
    
    $('#role_fun_del').bind('click', function () {
        Role.delFun();
    });
    
    $('#search_btn').bind('click', function () {
        var search_name = $('input[name="search_name"]').val();
        var search_desc = $('input[name="search_desc"]').val();
        var param = {};
        param["role.role_name"] = search_name;
        param["role.role_desc"] = search_desc;
        $('#roleList').datagrid({
            queryParams: param
        });
    });
    

});
