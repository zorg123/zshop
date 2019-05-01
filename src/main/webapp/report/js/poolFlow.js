var importFlag = false;
var PoolFlow = {
    search: function () {      
        var search_create_type = $('input[name="search_create_type"]').val();
        $('#poolFlowList').datagrid({
            queryParams: {'coinTrackDto.create_type': search_create_type}
       })
    },
    refresh: function () {
        $('#poolFlowList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#poolFlowList').datagrid('getSelected');

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
        url: base+'/FinancMgmt/getPagerListByConAccountFlow.do',
        loadFilter:function(data){
        	var jsonStr = JSON.stringify(data);
        	if (jsonStr.indexOf("T")>0) {
        		jsonStr = jsonStr.replace(/T/g," ");
        		data =  JSON.parse(jsonStr);
		    }
			return PoolFlow.loadFilter(data);
		}
    })

    $('#search_btn').bind('click', function () {
    	PoolFlow.search();
    })
})