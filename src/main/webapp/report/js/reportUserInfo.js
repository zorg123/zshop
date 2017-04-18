var importFlag = false;
var Employee = {
    search: function () {
    	    	
        var search_code = $('input[name="search_code"]').val();
        var search_name = $('input[name="search_name"]').val();       
        var search_state = $('input[name="search_state"]').val();
        $('#staffList').datagrid({
            queryParams: {'user.user_code': search_code, 'user.name': search_name, 'user.state': search_state,'user.bus_state': 1}
       })
    },
    refresh: function () {
        $('#staffList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#staffList').datagrid('getSelected');

        return row;
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
    formatState:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "0"){
			retVal="未激活";
		}else if (value == "1"){
			retVal = "已激活";
		}
		return retVal;
	}
}

$(function () {
    $('#staffList').datagrid({
        url: base+'/Sys/User!queryUser.do',
        queryParams: {'user.bus_state':1},
        loadFilter:function(data){			
			return Employee.loadFilter(data);
		}
    })

    $('#search_btn').bind('click', function () {
        Employee.search();
    })
})