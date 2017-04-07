var sign;

var Org={
	
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
  qrySubOrg:function(orgId){		
		var data ={"tbOrganation.up_org_id":orgId};
		var queryParams = $('#orgList').datagrid('options').queryParams;
		$.extend(queryParams, data);		
    	$('#orgList').datagrid('reload');
  },
  saveOrg: function () {
      if (this.check()) {
          var param = {};
          param["tbOrganation.org_code"] = $('#id_org_code').val();
          param["tbOrganation.org_name"] = $('#id_org_name').val();
          param["tbOrganation.state"] = $('#id_state').val();   
          var node = $('#organizationTree').tree('getSelected');          
          param["tbOrganation.up_org_id"] = node.id;
          var me = this;
          CommonUtils.invokeAsyncAction(base+'/Sys/Organation!insert.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '添加成功!', 'info');	  
	                	me.close();
	                    me.refresh();
	                }else{
	                	$.messager.alert('系统提示', '添加失败!', 'info');
	                }
				}			
			});           
      }
  },
  updateOrg: function (obj) {
           
      if (null === obj || undefined === obj) {
          $.messager.alert('系统提示', '未选择要修改的记录!', 'info');
          return;
      }      
      if (this.check()) {
          var param = {};
          param["tbOrganation.org_code"] = $('#id_org_code').val();
          param["tbOrganation.org_name"] = $('#id_org_name').val();
          param["tbOrganation.state"] = $('#id_state').val();          
          param["tbOrganation.org_id"] = obj;           
          var me = this;
          CommonUtils.invokeAsyncAction(base+'/Sys/Organation!update.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '修改成功!', 'info');	  
	                	 me.clear();
	                	 me.close();
	                     me.refresh();
	                }else{
	                	$.messager.alert('系统提示', '修改失败!', 'info');
	                }
				}			
			});            
      }
  },
  deleteOrg: function (obj) {
      var me = this;
      var param = {};
      param["tbOrganation.org_id"] = obj;
      CommonUtils.invokeAsyncAction(base+'/Sys/Organation!delete.do', param, function (reply) {
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
  refresh: function () {
      $('#orgList').datagrid('reload')
  },
  queryOrgInfo: function (obj) {
      var param = {}, me = this;
      param["tbOrganation.org_id"] = obj;        
      CommonUtils.invokeAsyncAction(base+'/Sys/Organation!queryList.do', param, function (reply) {
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
      $('#id_org_code').val(obj.org_code);
      $('#id_org_name').val(obj.org_name);      
      $('#id_up_org_name').val(obj.up_org_name);
      $('#id_up_org_id').val(obj.up_org_id);
      $('#id_state').val(obj.state);
  },
  clear: function () {
      $('#id_org_code').val('');
      $('#id_org_name').val('');
      $('#id_up_org_name').val('');
      $('#id_up_org_id').val('');
  },
  close: function () {
      $('#win_save').window('close');
      $('#win_save').hide();
  },
  check: function () {
      var orgCode = $('#id_org_code').val();
      var orgName = $('#id_org_name').val();
      
      if ((orgName || '') == '' || orgName.length == 0) {
          $.messager.alert('系统提示', '组织名称不能为空!', 'info');
          return false;
      }
      if ((orgCode || '') == '' || orgCode.length == 0) {
          $.messager.alert('系统提示', '组织编码不能为空!', 'info');
          return false;
      }
      return true;
  }
}

$(function(){	
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
		                	}	                	 
		                }else{
		                	$.messager.alert('系统提示', '加载子节点失败!', 'info');
		                }
					}
				});
			}			
			Org.qrySubOrg(node.id);            
		},
		onContextMenu: function(e, node){
			e.preventDefault();
		}
	});
	
	$('#orgList').datagrid({
		url:base+"/Sys/Organation!queryPageList.do",
		queryParams:{
			"tbOrganation.up_org_id":"-1"
		},
		loadFilter:function(data){				
			return CommonUtils.loadFilter(data);
		},
		toolbar:[{
	                text: '新增',
	                iconCls: 'icon-add',
	                handler: function () {
						sign = 'save';
	                    Org.clear();
	                    if($('#organizationTree').tree("getSelected")==null){
	                    	$.messager.alert('系统提示', '请在左侧的组织树中选择要添加到的组织!', 'info');
	                        return;
	                    }
	                    $('#id_up_org_name').val($('#organizationTree').tree("getSelected").text);
	                    $('#win_save').attr('title', '添加组织');
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
	                    var row = $('#orgList').datagrid('getSelected');
	                    if (null == row) {
	                        $.messager.alert('系统提示', '请选择要删除的记录!', 'info');
	                        return;
	                    }
	                    $.messager.confirm('系统提示', '是否删除？', function (r) {
	                        if (r) {
	                            Org.deleteOrg(row.org_id);
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
	                    var row = $('#orgList').datagrid('getSelected');
	                    if (null == row) {
	                        $.messager.alert('系统提示', '请选择要修改的记录!', 'info');
	                        return;
	                    }
	                    Org.queryOrgInfo(row.org_id);
	                    $('#win_save').attr('title', '修改组织');
	                    $('#win_save').show();
	                    $('#win_save').window({
	                        width: 350,
	                        height: 250,
	                        modal: true
	                    });
	                }
	            }]
	});
	
	$('#save').click(function () {
        if (sign === 'update') {
            var row = $('#orgList').datagrid('getSelected');
            Org.updateOrg(row.org_id);
        } else  Org.saveOrg();
    });
    $('#cancel').click(function () {
        Org.clear();
        Org.close();
    });
})