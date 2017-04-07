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
        var position_level = $('input[name="s_position_level"]').val();
        var s_org_name = $('input[name="s_org_name"]').val();
        var param = {};
        param['busSalary.position_level'] = position_level;
        param['busSalary.salary_schedule_start'] = salary_schedule_start;
        param['busSalary.salary_schedule_end']= salary_schedule_end;
        param['busSalary.org_name']= "%"+s_org_name+"%";
        param['q']= '1';
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
        url: base+'/Salary/Salary!qrySalaryByLevelEmployee.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},		
		queryParams: {'q':1},
        toolbar: [
            {
                text: '导出',
                iconCls: 'icon-redo',
                handler: function () {     
            	   
            	    var param = Employee.getParams();
            	    var position_level = $('input[name="s_position_level"]').val();                                        
            	    var strParam = "busSalary.salary_schedule_start="+param["busSalary.salary_schedule_start"];
            	    strParam += "&busSalary.salary_schedule_end="+param["busSalary.salary_schedule_end"];
            	    strParam += "&busSalary.position_level="+position_level; 
            	    var s_org_name = $('input[name="s_org_name"]').val();
            	    strParam += "&busSalary.org_name="+encodeURI(encodeURI(s_org_name));
            	    strParam += "&q=1";
            	    var url =base+ "/Salary/Salary!eportLevelSarary.do?"+strParam;
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
    
    $('#cancel_import_btn').bind('click', function () {
    	$('#execel_info').hide();
        $('#execel_info').window("close");
    })
    
})