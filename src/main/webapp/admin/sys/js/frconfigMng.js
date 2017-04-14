var FrconfigMng = {
    refresh: function () {
        $('#frconfigList').datagrid('reload');
    },
    close: function () {
        $('#win_edit').window('close');
        $('#win_edit').hide();
    },
    editInit: function(obj){
    	$('input[name="edit_cf_id"]').val(obj.cf_id);
    	$('input[name="edit_cf_module"]').val(obj.cf_module);
    	$('input[name="edit_cf_desc"]').val(obj.cf_desc);
    	$('input[name="edit_cf_value"]').val(obj.cf_value);
    	$('input[name="edit_cf_desc"]').attr("disabled",true);
    },
    getSelect: function () {
        var row = $('#frconfigList').datagrid('getSelected');
        return row;
    },
    save: function(){
    	var param = {'cf_id': $('input[name="edit_cf_id"]').val(),'cf_value': $('input[name="edit_cf_value"]').val()};
        var me = this;
        CommonUtils.invokeAsyncAction(base+'/Frconfig/updateFrConfig.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){
                	$.messager.alert('系统提示', '修改成功!', 'info');
                	me.close();
                    me.refresh();
                }else{
                	$.messager.alert('系统提示', '修改失败!', 'info');
                }
			}			
		});
    }
}
$(function () {
    $('#frconfigList').datagrid({
        url: base+'/Frconfig/queryFrCfgList.do',
        loadFilter:function(data){
        	//alert(JSON.stringify(data));
			return CommonUtils.loadFilter(data);
		},
		queryParams: {'cf_module': "financMgmt"},
        toolbar: [
            {
                text: '修改',
                iconCls: 'icon-undo',
                handler: function () {
                	var row = FrconfigMng.getSelect();
                    if (null === row) {
                        $.messager.alert('系统提示', '未选中记录!', 'info');
                        return;
                    }
                    sign = 'edit';
                    $('#win_edit').attr('title', '打款修改');
                    $('#win_edit').show();
                    $('#win_edit').window({
                        width: 450,
                        height: 300,
                        modal: true
                    });
                    FrconfigMng.editInit(row);
                }
            }
        ]
    });
    $('#save').click(function () {
    	FrconfigMng.save();
    });
    $('#search_btn').bind('click', function () {
        var param = {};
        param["coinTrackDto.apply_state"] = $('input[name="apply_state"]').val();
        param["coinTrackDto.user_code"] = $('input[name="query_user_code"]').val();
        param["coinTrackDto.start_time"] = $('input[name="start_time"]').val();
        param["coinTrackDto.end_time"] = $('input[name="end_time"]').val();
        $('#extractConfirmList').datagrid({
            queryParams: param
        });
    });
    $('#cancel').click(function () {
    	FrconfigMng.close();
    });
});

function timeFormatter(date){
    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}
function timeParser(date){
    return new Date(Date.parse(date.replace(/-/g,"/")));
}
$('input[id=uploadFile]').change(function() {
	$('#photoCover').textbox('setValue',$(this).val());
}); 