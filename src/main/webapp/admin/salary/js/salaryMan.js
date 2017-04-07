var importFlag = false;
var SalaryMan = {
    save: function () {
        var me = this;
        var data = CommonUtils.getInputDomain('save_user_info');
        var param = {};
        param["user.user_code"] = data.user_code;
        param["user.name"] = data.name;
        param["user.password"] = data.password;
        param["user.phone"] = data.phone;
        param["user.state"] = $('input[name="state"]','#save_user_info').val();
        param["user.mail"] = data.mail;
        param["user.sex"] = $('input[name="sex"][checked]', '#save_user_info').val();
        alert(CommonUtils.dumpObject(param));
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
        param["user.state"] = $('input[name="state"]', '#user_info').val();
        param["user.sex"] = $('input[name="sex"][checked]', '#user_info').val();
        param["user.mail"] = data.mail;
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
    search: function () {
        var user_code = $('input[name="s_user_code"]').val();
        var salary_schedule_start = $('input[name="s_salary_schedule_start"]').val();
        var salary_schedule_end = $('input[name="s_salary_schedule_end"]').val();
        var user_name = "%"+$('input[name="s_user_name"]').val()+"%";
        //var salary_type = $('input[name="s_salary_type"]').val();
        var batch_id = $('input[name="s_batch_id"]').val();
        var org_name = "%"+$('input[name="s_org_name"]').val()+"%";   
        //alert(org_name);
        $('#salaryList').datagrid({
        	queryParams: {'busSalary.batch_id':batch_id,'busSalary.salary_schedule_start':salary_schedule_start,'busSalary.salary_schedule_end':salary_schedule_end,'busSalary.user_code': user_code, 'busSalary.user_name': user_name,'busSalary.org_name':org_name}
        })
    },    
    setUserInfo: function (data) {
        var obj = $('#user_info');
        $('#user_code', obj).val(data.user_code);
        $('#name', obj).val(data.name);
        $('#state', obj).val(data.state);
        $('#mail', obj).val(data.mail);
        $('#phone', obj).val(data.phone);
        $('#org_id', obj).val(data.org_id);
        $('radio[name="sex"]', obj).val(data.sex);
    },
    refresh: function () {
        $('#salaryList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#salaryList').datagrid('getSelected');

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
    importSalary:function(){
    	var options = {
  			  target:'#output',
  			  type:'POST',
  			  url:base+'/Salary/Salary!importSalary.do',
  			  data:{},				  
  			  beforeSubmit:function(){
  				  $("#execel_info_tb").mask("导入中，请稍后...");					  
  			  },
  			  success:function process(response) {	
  				
  				  //$('#execel_info').hide();
  		          //$('#execel_info').window("close");
  		          //$('#salaryList').datagrid('reload');
  				  //alert(response);
  				  var result = eval(response);
  				  if(result._code=='0'){
  					  importFlag = true;
  					  $.messager.alert('系统提示',"导入成功。", 'info');
  					  var returnValue = result.ret;  
  					  $("#importSucNum").html("成功导入："+returnValue.importSucNum+" 条");
  					  $("#importErrNum").html("导入失败："+returnValue.importErrNum+" 条");
  					  $("#importErrMsg").html("失败信息："+returnValue.importErrMsg);
  					  $("#importBatchId").html("导入批次号："+returnValue.batchId);
  					  //$('input[name="s_batch_id"]').val(returnValue.batchId)
  					
  				  }else{
  					$.messager.alert('系统提示', result._msg, 'info');
  				  }
  			  },
  			  complete:function(){
  				$("#execel_info_tb").unmask(); 
  				$('#import_btn').attr("disabled",false);
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
   },
   deleteByBatch: function () {
	   var batch_id = $('input[name="s_batch_id"]').val();	   
       var param = {};
       param["busSalary.batch_id"] = batch_id;
       if(batch_id=='' || $.trim(batch_id) == ''){
    	   $.messager.alert('系统提示',"必须输入批次号。", 'info');
    	   return;
       }
       CommonUtils.invokeAsyncAction(base+'/Salary/Salary!deleteByBatch.do', param, function (reply) {           
           if ((reply || '') != '') {
               var code = reply._code;               
               if (code == '0') {                    
                   $.messager.alert('系统提示', '操作成功!', 'info');
                   $('#salaryList').datagrid('reload');
               } else  {
               	$.messager.alert('系统提示', '操作失败!', 'info');
               }              
           } else  {
           	 $.messager.alert('系统提示', '操作失败!', 'info');
           }
       })
   },
   deleteSel:function(){
	   
       var data = $('#salaryList').datagrid("getSelections");
       var ids = '';
       $.each(data, function (i, value) {
    	   var id = value.salary_id;
    	   if(id !='-1'){
    		   ids += id;
               ids += ','; 
    	   }           
       })
       
       if(ids=='' || $.trim(ids) == ''){
    	   $.messager.alert('系统提示',"请选择要删除的记录。", 'info');
    	   return;
       }
      
       $.messager.confirm('提示','确定要删除选择的记录?',function(r){
    	  if(r){
    		  var param = {};
    		  param["ids"] = ids;
    	      CommonUtils.invokeAsyncAction(base+'/Salary/Salary!deleteByIds.do', param, function (reply) {           
    	           if ((reply || '') != '') {
    	               var code = reply._code;               
    	               if (code == '0') {                    
    	                   $.messager.alert('系统提示', '删除成功!', 'info');
    	                   $('#salaryList').datagrid('reload');
    	               } else  {
    	               	$.messager.alert('系统提示', '删除失败!', 'info');
    	               }              
    	           } else  {
    	           	 $.messager.alert('系统提示', '删除失败!', 'info');
    	           }
    	       })
    	  } 
       });       
   }
}

$(function () {	
    $('#salaryList').datagrid({
        url:base+'/Salary/Salary!qrySalaryByMan.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
        toolbar: [
            {
                text: 'Excel导入',
                iconCls: 'icon-redo',
                handler: function () {                    
                    $('#execel_info').attr('title', '工资信息Excel导入');
                    $('#execel_info').show();
                    $('#execel_info').window({
                        width: 350,
                        height: 280,
                        modal: true
                    });                    
                }
            },
            '-',
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {                    
            		SalaryMan.deleteSel();                    
                }
            },
            {
                text: '导出',
                iconCls: 'icon-redo',
                handler: function () {     
	            	var user_code = $('input[name="s_user_code"]').val();
	                var salary_schedule_start = $('input[name="s_salary_schedule_start"]').val();
	                var salary_schedule_end = $('input[name="s_salary_schedule_end"]').val();
	                var user_name = $('input[name="s_user_name"]').val();
	                //var salary_type = $('input[name="s_salary_type"]').val();
	                var batch_id = $('input[name="s_batch_id"]').val();
	                var org_name = $('input[name="s_org_name"]').val();
	                
            	    var strParam = "busSalary.batch_id="+batch_id;
            	    strParam += "&busSalary.salary_schedule_start="+salary_schedule_start;
            	    strParam += "&busSalary.salary_schedule_end="+salary_schedule_end;   
            	    strParam += "&busSalary.user_code="+user_code;  
            	    strParam += "&busSalary.user_name="+encodeURI(encodeURI(user_name));  
            	    strParam += "&busSalary.org_name="+encodeURI(encodeURI(org_name));  
            	    strParam += "&q=1";
            	    var url = base+"/Salary/Salary!eportSarary.do?"+strParam;
            	    //alert(url);
            	    if(parent.parent.document){
						parent.document.location.href=url;
					}else if(parent.document){
						parent.document.location.href=url;
					}else{
						document.location.href=url;
					}                 
                }
            }           
        ]
    })

    $('#search_btn').bind('click', function () {
    	SalaryMan.search();
    	//$("[field='user_name']").hide();
    })

    $('#delete_by_batch_btn').bind('click', function () {
    	SalaryMan.deleteByBatch();
    })

    $('#import_btn').bind('click', function () {    	
    	$('#import_btn').attr("disabled",true);
    	SalaryMan.importSalary();
    }) 
    $('#cancel_import_btn').bind('click', function () {
    	$('#execel_info').hide();
        $('#execel_info').window("close");
        if(importFlag){
        	SalaryMan.search();
        }
    })
    
})