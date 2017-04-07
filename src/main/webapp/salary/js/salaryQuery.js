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
    
})