var importFlag = false;
var operEdit = {    
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
    ok:function(){
    	var s = operEdit.getSelect();
    	if(s){
    		if(parent){
    			parent.window.callback(s);
    			operEdit.cancel();
    		}
    	}else{
    		CommonUtils.showMsg("请选择一个审核人员!");
    	}
    },
    cancel:function(){
    	CommonUtils.closeWindow("dialogWindow1");
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
				}}	          
		      ]] 
    });

    $('#search_btn').bind('click', function () {
    	operEdit.search();
    }) 
    
    if(parent){
    	parent.window.operEdit1 = operEdit;
    }
})