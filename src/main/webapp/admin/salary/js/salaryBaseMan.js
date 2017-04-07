var importFlag = false;
var SalaryMan = {    
    search: function () {
        var params = SalaryMan.getQueryParam();
        $('#salaryList').datagrid({
        	queryParams:params 
        })
    }, 
    getQueryParam:function(){
    	var user_code = ""; //$('input[name="s_user_code"]').val();
        var salary_schedule_start = $('input[name="s_salary_schedule_start"]').val();
        var salary_schedule_end = $('input[name="s_salary_schedule_end"]').val();
        var user_name = $('input[name="s_user_name"]').val();
        if(user_name != ""){
        	user_name = "%"+user_name+"%";
        }
        //var salary_type = $('input[name="s_salary_type"]').val();
        var batch_id = $('input[name="s_batch_id"]').val();
        var org_name = "";//"%"+$('input[name="s_org_name"]').val()+"%";
        return {'busSalary.batch_id':batch_id,'busSalary.salary_schedule_start':salary_schedule_start,'busSalary.salary_schedule_end':salary_schedule_end,'busSalary.user_code': user_code, 'busSalary.user_name': user_name,'busSalary.org_name':org_name,'q':1};
    },
    refresh: function () {
        $('#salaryList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#salaryList').datagrid('getSelected');
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
  			  url:base+'/SalaryBase/SalaryBase!importSalary.do',
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
  					    
  					  $("#importBatchId").html("导入批次号："+returnValue.batchId); 
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
   },
   printSalary:function(){
	   
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
    	   $.messager.alert('系统提示',"请选择要打印的记录。", 'info');
    	   return;
       }
      
       $.messager.confirm('提示','确定要打印选择的记录?',function(r){
    	  if(r){    		  
		    var $form = $("#printForm");
		    if($form.length == 0){
		    	
		    	$form = $('<form id="printForm"></form>');
			    $form.attr('action', base+"/SalaryBase/SalaryBase!printSarary.do");
			    $form.attr('method', 'post');
			    $form.attr('target', '_blank');
	
		        var kldm_input = $('<input type="hidden" name="ids" id="ids" />');
		        kldm_input.attr('value', ids);
		        $form.append(kldm_input);
	
		        $form.appendTo('body');
		    }else{
		    	$("#ids").val(ids);
		    }
	        $form.submit();
    	  } 
       });       
   },
   printSalaryQuery:function(){
	   
	   var params = SalaryMan.getQueryParam();
	   params.rows = 1000;
	   params.page = 1;
       $.messager.confirm('提示','确定要打印查询的全部记录?',function(r){
    	  if(r){    		  
		    var $form = $("#printAllForm");
		    if($form.length == 0){
		    	
		    	$form = $('<form id="printForm"></form>');
			    $form.attr('action', base+"/SalaryBase/SalaryBase!pringSalaryByQuery.do");
			    $form.attr('method', 'post');
			    $form.attr('target', '_blank');
			    //{'busSalary.batch_id':batch_id,'busSalary.salary_schedule_start':salary_schedule_start,'busSalary.salary_schedule_end':salary_schedule_end,'busSalary.user_code': user_code, 'busSalary.user_name': user_name,'busSalary.org_name':org_name,'q':1};
			    for(var key in params){
			    	console.log(key);
			    	var value_input = $('<input type="hidden" name="'+key+'" id="'+key+'" />');
			    	value_input.attr('value', params[key]);
			        $form.append(value_input);
			    }		        
	
		        $form.appendTo('body');
		    }else{
		    	$("#ids").val(ids);
		    }
	        $form.submit();
    	  } 
       });       
   }
}

$(function () {	
    $('#salaryList').datagrid({
        url:base+'/SalaryBase/SalaryBase!qrySalaryByMan.do?q=1',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
		frozenColumns:[[    
		      {field:'bank_account',title:'银行账号'},    
		      {field:'user_name',title:'姓名',width:60},
		      {field:'user_code',title:'人员编号'},
		      {field:'salary_schedule',title:'发放时间',width:80,formatter:function(value, row, index){
		    	    if (value.indexOf("-")>0) {
		    	    	var dateStr = value.split("-")
		    	        return dateStr[0]+'年' + dateStr[1] + '月';
		    	    }
		    	    else {
		    	        return value;
		    	    }
		    	}}
		]],
		columns:[[    
		          {field:'extend_info',title:'',width:2400,align:'left'},    
		          {field:'batch_id',title:'批次号',align:'center'}
		      ]] ,
        toolbar: [
            {
                text: 'Excel导入',
                iconCls: 'icon-add',
                handler: function () {                    
                    $('#execel_info').attr('title', '工资信息Excel导入');
                    $('#execel_info').show();
                    $('#execel_info').window({
                        width: 450,
                        height: 380,
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
            	    //strParam += "&busSalary.user_code="+user_code;  
            	    strParam += "&busSalary.user_name="+encodeURI(encodeURI(user_name));  
            	    //strParam += "&busSalary.org_name="+encodeURI(encodeURI(org_name));  
            	    strParam += "&q=1";
            	    var url = base+"/SalaryBase/SalaryBase!eportSarary.do?"+strParam;
            	    //alert(url);
            	    if(parent.parent.document){
						parent.document.location.href=url;
					}else if(parent.document){
						parent.document.location.href=url;
					}else{
						document.location.href=url;
					}                 
                }
            },
            '-',
            {
                text: '打印',
                iconCls: 'icon-print',
                handler: function () {                    
            		SalaryMan.printSalary();                    
                }
            },'-',
            {
                text: '打印查询记录',
                iconCls: 'icon-print',
                handler: function () {                    
            		SalaryMan.printSalaryQuery();                    
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