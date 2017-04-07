var Employee = {    
    search: function () {
    	var param = Employee.getParams();
        $('#salaryList').datagrid({
        	queryParams: param
        });
    },
    getParams:function(){
    	var salary_schedule_start = $('input[name="s_salary_schedule_start"]').val();
        var salary_schedule_end = $('input[name="s_salary_schedule_end"]').val();
        var salary_type = $('input[name="s_salary_type"]').val();
        var param = {};
        param['busSalary.salary_type'] = salary_type;
        param['busSalary.salary_schedule_start'] = salary_schedule_start;
        param['busSalary.salary_schedule_end']= salary_schedule_end;
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
  			  url:base+'/Salary/Salary!importSalary.do',
  			  data:{},				  
  			  beforeSubmit:function(){
  				  //$("#execel_info").mask("操作中...");					  
  			  },
  			  success:function process(response) {	
  				  alert("导入成功!");
  				  $('#execel_info').hide();
  		          $('#execel_info').window("close");
  				  return;
  				  var result = response;//eval(response);
  				  if(result._code=='0'){
  					  var returnValue = result.ret;  
  					  $("#importSucNum").html("成功导入："+returnValue.importSucNum);
  					  $("#importErrNum").html("导入失败："+returnValue.importErrNum);
  					  $("#importErrMsg").html("失败信息："+returnValue.importErrMsg);
  				  }else{
  					$.messager.alert('系统提示', result._msg, 'info');
  				  }
  			  },
  			  complete:function(){
  				  //$("#execel_info").unmask();  
  			  },
  			  error:function(){	
  				$.messager.alert('系统提示',"操作失败，请稍后重试。", 'info');
  			  }
  		};
    	$("form[name='excelForm']").ajaxSubmit(options); 
   }
}

$(function () {	
    $('#salaryList').datagrid({
        url: base+'/Salary/Salary!qrySalaryByEmployee.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},		
        toolbar: [
            {
                text: '导出',
                iconCls: 'icon-redo',
                handler: function () {     
            	   
            	    var param = Employee.getParams();
            	    var strParam = "busSalary.salary_type="+param["busSalary.salary_type"];
            	    strParam += "&busSalary.salary_schedule_start="+param["busSalary.salary_schedule_start"];
            	    strParam += "&busSalary.salary_schedule_end="+param["busSalary.salary_schedule_end"];
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
        Employee.search();
    })

    $('#import_btn').bind('click', function () {
        Employee.importSalary();
    }) 
    $('#cancel_import_btn').bind('click', function () {
    	$('#execel_info').hide();
        $('#execel_info').window("close");
    })
    
})