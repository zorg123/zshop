var importFlag = false;
var SalaryMan = {   
    
    search: function () {
	
        var param = SalaryMan.getParam();
        param["busId"]=busId;        
        $('#salaryList').datagrid({
        	queryParams: param
        })
    }, 
    getParam:function(flag){
    	var param={};
    	$("#searchDiv input[db_field]").each(function(i){
    		$field=$(this);
    		var fieldName=$field.attr("db_field");
    		var value = $field.val();
    		var isLike = $field.attr("is_like");
    		var needEncode = $field.attr("need_encode");
    		var comboname = $field.attr("comboname");
    		if(comboname){
    			value = $("input[name='"+comboname+"']").val();
    		}
    		if( isLike == '1'){
    			value="%"+value+"%"; 
    		}
    		if(flag == 1 && needEncode == 1){    			
    			value = encodeURI(encodeURI(value))    			
    		}
    		param[fieldName]=value;
    	});
    	return param;
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
  			  url:base+'/Bus/Bus!importBus.do',
  			  data:{'busId':busId},				  
  			  beforeSubmit:function(){
  				  $("#execel_info_tb").mask("导入中，请稍后...");					  
  			  },
  			  success:function process(response) {	  				
  				  
  				  var result = eval(response);
  				  if(result._code=='0'){
  					  importFlag = true;
  					  $.messager.alert('系统提示',"导入成功。", 'info');
  					  var returnValue = result.ret;  
  					  $("#importParseFailNum").html("成功导入："+returnValue.transformErrNum+" 条");
  					  $("#importSucNum").html("成功导入："+returnValue.importSucNum+" 条");
  					  $("#importErrNum").html("导入失败："+returnValue.importErrNum+" 条");
  					  $("#importErrMsg").html("失败信息："+returnValue.importErrMsg);
  					  $("#importBatchId").html("导入批次号："+returnValue.batchId);
  					  $('input[name="s_batch_id"]').val(returnValue.batchId)
  					
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
       param["busData.batch_id"] = batch_id;
       if(batch_id=='' || $.trim(batch_id) == ''){
    	   $.messager.alert('系统提示',"必须输入批次号。", 'info');
    	   return;
       }
       CommonUtils.invokeAsyncAction(base+'/Bus/Bus!deleteByBatch.do', param, function (reply) {           
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
    	   var id = value.data_id;
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
    	      CommonUtils.invokeAsyncAction(base+'/Bus/Bus!deleteByIds.do', param, function (reply) {           
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
        url:base+'/Bus/Bus!qryBusByMan.do?busData.bus_id='+busId+"&q="+q,
        loadFilter:function(data){		
	    	if(q!=1){
	        	//隐藏导入
	        	$('div.datagrid-toolbar a').eq(0).hide();
	        	//隐藏第一条分隔线
	        	$('div.datagrid-toolbar div').eq(0).hide();
	        	
	        	//隐藏删除
	        	$('div.datagrid-toolbar a').eq(1).hide();
	        	//隐藏第二条分隔线
	        	$('div.datagrid-toolbar div').eq(1).hide();
	        	
	        }
			return CommonUtils.loadFilter(data);
		},
        toolbar: [
            {
                text: 'Excel导入',
                iconCls: 'icon-redo',               
                handler: function () {                    
                    $('#execel_info').attr('title', '信息Excel导入');
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
            '-',
            {
                text: '导出',
                iconCls: 'icon-redo',
                handler: function () {     
            		var param = SalaryMan.getParam(1);
	                
            		var strParam = "";
            		for(var field in param){
            			strParam += field+"="+param[field]+"&";
            		}
            	    //var strParam = "busData.batch_id="+batch_id;
            	    //strParam += "&busData.salary_schedule_start="+salary_schedule_start;
            	    //strParam += "&busData.salary_schedule_end="+salary_schedule_end;   
            	    //strParam += "&busData.user_code="+user_code;  
            	    //strParam += "&busData.bus_id="+busId;  
            	    //strParam += "&busData.user_name="+encodeURI(encodeURI(user_name));  
            	    //strParam += "&busData.org_name="+encodeURI(encodeURI(org_name));  
            		var encodeFields="";
            		$("#searchDiv input[db_field][need_encode='1']").each(function(i){
                		$field=$(this);
                		var fieldName=$field.attr("db_field");
                		fieldName=fieldName.replace("busData.","");
                		encodeFields = encodeFields+";"+fieldName;
                	});
            		if(encodeFields!=''){
            			encodeFields = encodeFields.substring(1);
            		}
            	    strParam += "q="+q+"&encodeFields="+encodeFields;
            	    //console.log(strParam);
            	    var url = base+"/Bus/Bus!eportBus.do?"+strParam;
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

    if(q!=1){
    	//隐藏导入
    	$('div.datagrid-toolbar a').eq(0).hide();
    	//隐藏第一条分隔线
    	$('div.datagrid-toolbar div').eq(0).hide();
    	
    	//隐藏删除
    	$('div.datagrid-toolbar a').eq(1).hide();
    	//隐藏第二条分隔线
    	$('div.datagrid-toolbar div').eq(1).hide();
    	
    }
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