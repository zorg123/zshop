var importFlag = false;
var Employee = {
    save: function () {
        var me = this;
        var data = CommonUtils.getInputDomain('save_user_info');
        var param = {};
        param["user.user_code"] = data.user_code;
        param["user.name"] = data.name;
        param["user.password"] = data.password;
        param["user.phone"] = data.phone;
        param["user.state"] = $('#state','#save_user_info').val();
        param["user.mail"] = data.mail;
        param["user.sex"] = $('input[name="sex"]:checked', '#save_user_info').val();
        param["user.bank_account"] = data.bank_account;
        var node = $('#organizationTree').tree('getSelected');
        param["user.org_id"] = node.id;
        param["user.id_card"] = data.id_card;
        param["user.position_level"] = $('#position_level','#save_user_info').val()
        //alert(CommonUtils.dumpObject(param));
        if ((data.user_code || '') === '') {
            $.messager.alert('系统提示', '用户工号不能为空!', 'info');
            return;
        }
        if ((data.password || '') === '') {
            $.messager.alert('系统提示', '用户密码不能为空!', 'info');
            return;
        }
        //alert(param.state);
        CommonUtils.invokeAsyncAction(base+'/Sys/User!insertUser.do', param, function (reply) {           
            var code = reply._code;
            var msg = reply._msg;
            if (code == "0") {
                $.messager.alert('系统提示', '操作成功!', 'info');
                me.refresh();
                me.clearInfo('save_user_info');
                $('#save_user_info').hide();
                $('#save_user_info').window("close");
            } else {
            	$.messager.alert('系统提示', msg, 'info');
            }
        })
    },
    update: function () {
        var me = this;
        var row = me.getSelect();
        var data = CommonUtils.getInputDomain('user_info');
        var param = {};
        param["user.user_id"] = row.user_id;
        param["user.user_code"] = data.user_code;
        param["user.name"] = data.name;
        param["user.phone"] = data.phone;
        param["user.state"] = $('#state', '#user_info').val();
        param["user.sex"] = $('input[name="sex"]:checked', '#user_info').val();
        //alert($('input[name="sex"]:checked', '#user_info').val());
        param["user.mail"] = data.mail;
        param["user.bank_account"] = data.bank_account;
        param["user.password"] = data.password;
        param["user.id_card"] = data.id_card;
        param["user.position_level"] = $('#position_level','#user_info').val()
        if ((data.user_code || '') === '') {
            $.messager.alert('系统提示', '用户工号不能为空!', 'info');
            return;
        }
       
        CommonUtils.invokeAsyncAction(base+'/Sys/User!updateUser.do', param, function (reply) {
        	var code = reply._code;
            var msg = reply._msg;
            if (code == "0") {
                $.messager.alert('系统提示', '操作成功!', 'info');
                me.refresh();
                me.clearInfo('user_info');
                $('#user_info').hide();
                $('#user_info').window("close");
            } else {
            	$.messager.alert('系统提示', msg, 'info');
            }
        })
    },
    search: function (orgId) {
    	    	
        var search_code = $('input[name="search_code"]').val();
        var search_name = $('input[name="search_name"]').val();       
        var search_state = $('input[name="search_state"]').val();
        if(!orgId){
        	var node = $('#organizationTree').tree('getSelected');
        	if(node != null){
        		orgId = node.id;
        	}else{
        		orgId ="";
        	}
        }
        
        $('#staffList').datagrid({
            queryParams: {'user.user_code': search_code, 'user.name': search_name, 'user.state': search_state,'user.org_id':orgId,'user.bus_state': 0}
       })
    },
    queryByStaffNo: function (id) {
        var me = this;
        var param = {};
        param["user.user_id"] = id;
        param["page"] = 1;
        param["rows"] = 10;
        CommonUtils.invokeAsyncAction(base+'/Sys/User!queryUserById.do', param, function (reply) {
            if ((reply || '') !== '') {
                var result = reply.ret[0];
                me.setUserInfo(result);
            } else {
                $.messager.alert('系统提示', '获取数据失败!', 'info');
            }
        })
    },
    setUserInfo: function (data) {
        var obj = $('#user_info');
        $('#user_code', obj).val(data.user_code);
        $('#name', obj).val(data.name);
        $('select[name="state"]', obj).val(data.state);
        $('#mail', obj).val(data.mail);
        $('#phone', obj).val(data.phone);
        $('#bank_account', obj).val(data.bank_account);
        $('#password', obj).val(data.password);
        $('#org_id', obj).val(data.org_id);
        $('#org_name', obj).val(data.org_name);
        $('#id_card', obj).val(data.id_card);
        $('select[name="position_level"]', obj).val(data.position_level);
        $('input[name="sex"]', obj).each(function(i,v){        	
        	if($(v).val()==data.sex){
        		$(v).attr("checked","checked");
        	}
        }); 
    },
    refresh: function () {
        $('#staffList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#staffList').datagrid('getSelected');

        return row;
    },
    searchRole: function () {
        var role_name = $('input[name="role_name"]').val();
        var role_desc = $('input[name="role_desc"]').val();

        $('#roleList').datagrid({
            queryParams: {'role.role_name': role_name, 'role.role_desc': role_desc}
        })
    },
    clearInfo: function (id) {
        var obj = $('#' + id);
        $('#user_code', obj).val('');
        $('#name', obj).val('');        
        $('#mail', obj).val('');
        $('#phone', obj).val('');
        $('#org_id', obj).val('');        
    },
    initUserRole: function () {
        var me = this;
        var row = me.getSelect();
        $('#employee_role_list').datagrid({
            url: base+'/Sys/User!queryRoleIdByUserId.do',
            loadFilter:function(data){			
				return Employee.loadFilter(data);
			},
            queryParams: {'user.user_id': row.user_id}
        })
    },
    loadFilter :function(data){
    	if (data.ret){
			return data.ret;
		} else {
			return data;
		}
    },
    saveUserRole: function () {
        var me = this;
        var row = me.getSelect();
        if (null == row) {
            $.messager.alert('系统提示', '未选中任何用户!', 'info');
            return;
        }
        var data = $('#roleList').datagrid("getSelections");
        var ids = '';
        $.each(data, function (i, value) {
            ids += value.role_id;
            ids += ',';
        })
        ids = ids.substring(0, ids.lastIndexOf(','));
        var param = {};
        param.ids = ids;
        param["user.user_id"] = row.user_id;
        CommonUtils.invokeAsyncAction(base+'/Sys/User!saveUserRole.do', param, function (reply) {
        	if ((reply || '') != '') {
                var code = reply._code;
                if(code=='0'){
                	$.messager.alert('系统提示', '保存成功!', 'info');
                	 $('#user_role_info').hide();
                     $('#user_role_info').window("close");
                }else{
                	$.messager.alert('系统提示', '保存失败!', 'info');
                }
            } else {
                $.messager.alert('系统提示', '获取数据失败!', 'info');
            }
        })
    },
    delUserRole: function () {
        var me = this;
        var row = me.getSelect();
        var data = $('#employee_role_list').datagrid("getSelections");
        if (data.length == 0) {
            $.messager.alert("系统提示", '未选中任何数据!', 'info');
            return;
        }
        var ids = '';
        $.each(data, function (i, value) {
            ids += value.role_id;
            ids += ',';
        })
        ids = ids.substring(0, ids.lastIndexOf(','));

        var param = {};
        param["user.user_id"] = row.user_id;
        param.ids = ids;

        CommonUtils.invokeAsyncAction(base+'/Sys/User!deleteUserRole.do', param, function (reply) {           
            if ((reply || '') != '') {
                var code = reply._code;               
                if (code == '0') {                    
                    $.messager.alert('系统提示', '操作成功!', 'info');
                } else  {
                	$.messager.alert('系统提示', '操作失败!', 'info');
                }
                $('#user_role_info').hide();
                $('#user_role_info').window("close");
            } else  {
            	$.messager.alert('系统提示', '操作失败!', 'info');
            }
        })
    },
    deleteUser: function (user_id) {
    	var me = this;       
        var param = {};
        param["user.user_id"] =user_id;    
        CommonUtils.invokeAsyncAction(base+'/Sys/User!deleteUser.do', param, function (reply) {           
            var code = reply._code;
            var msg = reply._msg;
            if (code == "0") {
                $.messager.alert('系统提示', '操作成功!', 'info');
                me.refresh();                
            } else {
            	$.messager.alert('系统提示', msg, 'info');
            }
        })
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
    importUser:function(){
    	var options = {
  			  target:'#output',
  			  type:'POST',
  			  url:base+'/Sys/User!importUser.do',
  			  data:{},				  
  			  beforeSubmit:function(){
  				  $("#execel_info_tb").mask("导入中,请稍后...");					  
  			  },
  			  success:function process(response) {
  				  //$('#execel_info').hide();
  		          //$('#execel_info').window("close");
  		          //$('#salaryList').datagrid('reload');
  				  //alert(response);
  				  var result = eval(response);
  				  if(result._code=='0'){
  					  importFlag = true;
  					  var returnValue = result.ret;  
  					  if(returnValue.importErrNum == 0){
  						  $.messager.alert('系统提示',"导入成功。", 'info');
  					  }else{
  						  $.messager.alert('系统提示',"部分导入失败，请查看信息。", 'info');
  					  }
  					  $("#importSucNum").html("成功导入："+returnValue.importSucNum+" 条");
  					  $("#importErrNum").html("导入失败："+returnValue.importErrNum+" 条");
  					  $("#importErrMsg").html("失败信息："+returnValue.importErrMsg);
  				  }else{
  					$.messager.alert('系统提示', result._msg, 'info');
  				  }
  			  },
  			  complete:function(){
  				$("#execel_info_tb").unmask();
  				$('#import_btn').attr("disabled",true);  
  			  },
  			  error:function(){	
  				$.messager.alert('系统提示',"操作失败，请稍后重试。", 'info');
  			  }
  		};
    	if($("#upload").val() == ''){
    		$.messager.alert('系统提示',"请选择文件要导入的文件.", 'info');
    		return;
    	}
    	$("form[name='excelForm']").ajaxSubmit(options); 
   }
}

$(function () {	
	$('#organizationTree').tree({
		url:base+"/Sys/Organation!queryTreeList.do?tbOrganation.up_org_id=-1",		
		loadFilter:function(data){
			return CommonUtils.loadFilter(data);
		},
		onClick:function(node){
			var node = $('#organizationTree').tree('getSelected');			
			var param = {"tbOrganation.up_org_id":node.id};			
			if($('#organizationTree').tree('isLeaf',node.target)){
				CommonUtils.invokeAsyncAction(base+'/Sys/Organation!queryTreeList.do', param, function (reply) {
					if((reply || '') !=''){
						var code = reply._code;
		                if(code=='0'){	 
		                	var menus = reply.ret;
		                	if((menus||'') !=''){
		                		$('#organizationTree').tree('append', {
		                            parent: (node ? node.target : null),
		                            data: menus
		                        });
		                		//Employee.search(node.id);
		                	}	                	 
		                }else{
		                	$.messager.alert('系统提示', '加载子节点失败!', 'info');
		                }
					}
				});
			}
				
			//Employee.search(node.id);		
            
		},
		onContextMenu: function(e, node){
			e.preventDefault();
		}
	});
    $('#staffList').datagrid({
        url: base+'/Sys/User!queryUser.do',
        queryParams: {'user.bus_state':0},
        loadFilter:function(data){			
			return Employee.loadFilter(data);
		},
        toolbar: [
            {
                text: '添加',
                iconCls: 'icon-save',
                handler: function () {
            		var node = $('#organizationTree').tree('getSelected');
            		if(node == null){
            			$.messager.alert("系统提示",'请先选择左侧要添加到的组织。','info');
            			return false;
            		}
            		$("#org_name",$('#save_user_info')).val(node.text);
                    $('#save_user_info').show();
                    $('#save_user_info').window({
                        width: 350,
                        height: 400,
                        modal: true
                    });
                }
            },
            '-',
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
	            	 var row = Employee.getSelect();
	                 if (null === row) {
	                     $.messager.alert('系统提示', '未选中记录!', 'info');
	                     return;
	                 }
	                 $.messager.confirm('系统提示', '是否删除 '+row.name+'？', function (r) {
	                        if (r) {
	                        	 Employee.deleteUser(row.user_id);;
	                        }
	                 });
                }
            },
            '-',
            {
                text: '修改',
                iconCls: 'icon-redo',
                handler: function () {
                    var row = Employee.getSelect();
                    if (null === row) {
                        $.messager.alert('系统提示', '未选中记录!', 'info');
                        return;
                    }
                    $('#user_info').attr('title', '修改用户信息');
                    $('#user_info').show();
                    $('#user_info').window({
                        width: 350,
                        height: 400,
                        modal: true
                    });
                    Employee.queryByStaffNo(row.user_id);
                }
            },
            '-',
            {
                text: '分配角色',
                iconCls: 'icon-reload',
                handler: function () {
                    var row = Employee.getSelect();
                    if (null === row) {
                        $.messager.alert('系统提示', '未选中任何记录!', 'info');
                        return;
                    }
                    $('#show_role').show();
                    $('#show_role').window({
                        width: 650,
                        height: 480,
                        modal: true
                    });  
                    
                    $('#roleList').datagrid({
                    	url:base+'/Sys/User!queryRoleList.do',
                    	loadFilter:function(data){			
            				return Employee.loadFilter(data);
            			},
            			width:'100%',
            			height:'100%',
            			columns:[[  
            			          	{field:'ck',checkbox:true},
            						{field:'role_id',title:'角色id'},    
            						{field:'role_name',title:'角色名称'},
            						{field:'role_desc',title:'描述'},
            						{field:'create_date',title:'角色维护时间',formatter:function(value, row, index){
            						    if(value){
	            							if (value.indexOf("T")>0) {
	            						        return value.replace("T"," ");
	            						    }
	            						    else {
	            						        return value;
	            						    }
            						    }
            					}}          
            		   ]] 
                    })
                }
            },
            '-',
            {
                text: '查看用户角色',
                iconCls: 'icon-reload',
                handler: function () {
                    var row = Employee.getSelect();
                    if (null === row) {
                        $.messager.alert('系统提示', '未选中任何记录!', 'info');
                        return;
                    }
                    $('#user_role_info').show();
                    $('#user_role_info').window({
                        width: 500,
                        height: 450,
                        modal: true
                    });
                    //Employee.initUserRole();
                    $('#employee_role_list').datagrid({
                    	url:base+'/Sys/User!queryRoleIdByUserId.do',
                    	loadFilter:function(data){			
            				return Employee.loadFilter(data);
            			},
            			queryParams: {'user.user_id': row.user_id},
            			width:'100%',
            			height:'100%',
            			columns:[[
            			          	{field:'ck',checkbox:true},
            						{field:'role_id',title:'角色id'},    
            						{field:'role_name',title:'角色名称'},
            						{field:'role_desc',title:'描述'},
            						{field:'create_date',title:'角色维护时间',formatter:function(value, row, index){
            						    if(value){
	            							if (value.indexOf("T")>0) {
	            						        return value.replace("T"," ");
	            						    }
	            						    else {
	            						        return value;
	            						    }
            						    }
            					}}          
            		   ]] 
                    })
                }
            },
            '-',
            {
                text: 'Excel员工导入',
                iconCls: 'icon-save',
                handler: function () {                    
                    $('#execel_info').attr('title', '员工信息Excel导入');
                    $('#execel_info').show();
                    $('#execel_info').window({
                        width: 350,
                        height: 280,
                        modal: true
                    });                    
                }
            }
        ]
    })

    $('#search_btn').bind('click', function () {
        Employee.search();
    })

    $('#search_role_btn').bind('click', function () {
        Employee.searchRole();
    });

    $('#up_btn').bind('click', function () {
        Employee.update();
    })

    $('#up_cel_btn').bind('click', function () {
        Employee.clearInfo('user_info');
        $("#user_info").window("close");
    })

    $('#save_btn').bind('click', function () {
        Employee.save();
    })

    $('#save_cel_btn').bind('click', function () {
        Employee.clearInfo('save_user_info');
        $('#save_user_info').hide();
        $('#save_user_info').window("close");
    })

    $('#role_save').bind('click', function () {
        Employee.saveUserRole();
    })

    $('#del_user_btn').bind('click', function () {
        Employee.delUserRole();
    })    
    
    $('#import_btn').bind('click', function () {
    	$('#import_btn').attr("disabled",false);
    	Employee.importUser();
    }) 
    $('#cancel_import_btn').bind('click', function () {
    	$('#execel_info').hide();
        $('#execel_info').window("close");
        if(importFlag){
        	Employee.search();
        }
    })
})