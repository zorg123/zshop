var importFlag = false;
var StaffMan = {    
    search: function () {
        var params = CommonUtils.getParam("conditionDiv",false);
        $('#staffList').datagrid({
        	queryParams:params 
        })
    }, 
    refresh: function () {
        $('#staffList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#staffList').datagrid('getSelected');
        return row;
    },    
    loadFilter :function(data){
    	if (data.ret){
			return data.ret;
		} else {
			return data;
		}
    },
    importSalary:function(){
    	var options = {
  			  target:'#output',
  			  type:'POST',
  			  url:base+'/Staff/importStaff.do',
  			  data:{},				  
  			  beforeSubmit:function(){
  				  $("#execel_info_tb").mask("导入中，请稍后...");					  
  			  },
  			  success:function process(response) {	
  				
  				  var result = eval(response);
  				  if(result._code=='0'){
  					  importFlag = true;
  					  var returnValue = result.ret;
  					  
  					  if(returnValue.importErrNum==0){
  						  $.messager.alert('系统提示',"导入成功。", 'info');
  					  }else{
  						 $.messager.alert('系统提示',"导入失败，请见错误信息。", 'info');
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
       $.messager.confirm('提示','确定要删除该批次的记录，删除后将不可恢复?',function(r){
     	  if(r){
	       CommonUtils.invokeAsyncAction(base+'/SalaryBase/SalaryBase!deleteByBatch.do', param, function (reply) {           
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
     	  }
       });
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
    	      CommonUtils.invokeAsyncAction(base+'/SalaryBase/SalaryBase!deleteByIds.do', param, function (reply) {           
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
    $('#staffList').datagrid({
        url:base+'/Staff/queryUserList.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
		pageSize:20,
		width:'100%',
		columns:[[  
				{field:'id',title:'',hidden:true},    
				{field:'name',title:'姓名'},
				{field:'account',title:'登录名'},
				{field:'department_name',title:'部门'},
				{field:'status',title:'员工状态',formatter:function(value, row, index){
				    var tvalue = value;
					if(value == '0'){
						tvalue ="待认证";
				    }else if(value == "1"){
				    	tvalue ="通过认证";
				    }else if(value == "-1"){
				    	tvalue ="禁用";
				    }
					return tvalue;
				}},
				{field:'phone',title:'联系电话'},
				{field:'citizen_id',title:'身份证号码'},
				{field:'register_time',title:'注册时间',formatter:function(value, row, index){
					    if (value.indexOf("T")>0) {
					        return value.replace("T"," ");
					    }
					    else {
					        return value;
					    }
				}}		          
		      ]] ,
        toolbar: [
            {
                text: 'Excel导入',
                iconCls: 'icon-add',
                handler: function () {                    
                	$('#execel_info').attr('title', '人员扩展信息Excel导入');
                    $('#execel_info').show();
                    $('#execel_info').window({
                        width: 450,
                        height: 380,
                        modal: true
                    });                   
                }
            }, {
                text: '查看详情',
                iconCls: 'icon-add',
                handler: function () {      
                	var sRow = StaffMan.getSelect();
                	if(!sRow){
                		CommonUtils.showMsg("请先选择一条记录!");
                		return;
                	}
                	id = sRow.id;
                	var url= base+"/Staff/queryUserDetail.do?operType=3&infoUserExt.id="+id;
                	CommonUtils.openWindow("查看基本信息",url);                   
                }
            }, {
                text: '修改',
                iconCls: 'icon-add',
                handler: function () {                    
                	var sRow = StaffMan.getSelect();
                	if(!sRow){
                		CommonUtils.showMsg("请先选择一条要修改的记录!");
                		return;
                	}
                	id = sRow.id;
                	var url= base+"/Staff/queryUserDetail.do?operType=1&infoUserExt.id="+id;
                	CommonUtils.openWindow("修改基本信息",url);                    
                }
            }     
        ]
    })

    $('#search_btn').bind('click', function () {
    	StaffMan.search();
    })
    
    $('#cancel_import_btn').bind('click', function () {
    	$('#execel_info').hide();
        $('#execel_info').window("close");
        if(importFlag){
        	StaffMan.search();
        }
    })
    $('#import_btn').bind('click', function () {
    	StaffMan.importSalary();
    })
     $('#cancel_import_btn').bind('click', function () {
    	 $('#execel_info').window("colse");
    })
    
    var param = {};
    param["sqlId"]="2";
    CommonUtils.renderPieChart("orgPieDiv", "各部门员工情况", "各部门员工情况", null, param);
    
})