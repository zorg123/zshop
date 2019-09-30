var importFlag = false;
var Employee = {
    search: function () {
    	    	
        var search_code = $('input[name="search_code"]').val();
        var search_name = $('input[name="search_name"]').val();       
        var search_userLevel = $('input[name="search_userLevel"]').val();
        var search_shareoutQua = $('input[name="search_shareoutQua"]').val();
        $('#staffList').datagrid({
            queryParams: {'user.user_code': search_code, 'user.name': search_name, 'user.user_level': search_userLevel,'user.shareout_qua': search_shareoutQua,'user.bus_state': 1,'user.notInChild': 1}
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
	},
	shareoutQua:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "-1"){
			retVal="不具备";
		}else if (value == "1"){
			retVal = "具备";
		}else{
			retVal="不具备";
		}
		return retVal;
	}
}

$(function () {
    $('#staffList').datagrid({
        url: base+'/Sys/User!queryUser.do',
        queryParams: {'user.bus_state':1,'user.notInChild':1},
        loadFilter:function(data){
        	var jsonStr = JSON.stringify(data);
        	if (jsonStr.indexOf("T")>0) {
        		jsonStr = jsonStr.replace(/T/g," ");
        		data =  JSON.parse(jsonStr);
		    }
			return Employee.loadFilter(data);
		}
    })

    $('#search_btn').bind('click', function () {
        Employee.search();
    })
})