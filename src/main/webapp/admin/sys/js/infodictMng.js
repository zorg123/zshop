var FrconfigMng = {
    refresh: function () {
        $('#frconfigList').datagrid('reload');
    },
    close: function () {
        $('#win_edit').window('close');
        $('#win_edit').hide();
    },
    addclose: function () {
        $('#win_add').window('close');
        $('#win_add').hide();
    },
    editInit: function(obj){
    	$('input[name="edit_dict_id"]').val(obj.dict_id);
    	$('input[name="edit_dict_code"]').val(obj.dict_code);
    	$('input[name="edit_dict_name"]').val(obj.dict_name);
    	$('input[name="edit_dict_value"]').val(obj.dict_value);
    	$('input[name="edit_dict_code"]').attr("disabled",true);
    	$('input[name="edit_dict_name"]').attr("disabled",true);
    },
    getSelect: function () {
        var row = $('#frconfigList').datagrid('getSelected');
        return row;
    },
    save: function(){
    	var param = {'infodictDto.dict_id': $('input[name="edit_dict_id"]').val(),
    			'infodictDto.dict_code': $('input[name="edit_dict_code"]').val(),
    			'infodictDto.dict_value': $('input[name="edit_dict_value"]').val(),
    			'infodictDto.dict_type': 'starInit'};
        var me = this;
        CommonUtils.invokeAsyncAction(base+'/Infodict/updateInfoDict.do', param, function (reply) {
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
    },
    addsave: function(){
    	var param = {'infodictDto.dict_code': $('input[name="add_dict_code"]').val(),
    			'infodictDto.dict_value': $('input[name="add_dict_value"]').val(),
    			'infodictDto.dict_type': 'starInit'};
        var me = this;
        CommonUtils.invokeAsyncAction(base+'/Infodict/insertInfoDict.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
				if(code=='0'){
		        	var retobj = reply.ret;
		        	//-1:转入的奖金币大于当前账户的奖金币 3:成功
		        	if(retobj.retCode=='3'){
		        		$.messager.alert('系统提示', '添加成功!', 'info');
	                	me.addclose();
	                    me.refresh();
		        	}else{
		        		$.messager.alert('系统提示', retobj.retString, 'info');
		        	}
		        }else{
		        	$.messager.alert('系统提示', '操作失败!', 'info');
		        }
			}			
		});
    }
}
$(function () {
    $('#frconfigList').datagrid({
        url: base+'/Infodict/queryInfoDictList.do',
        loadFilter:function(data){
        	//alert(JSON.stringify(data));
			return CommonUtils.loadFilter(data);
		},
		queryParams: {'infodictDto.dict_type': "starInit"},
        toolbar: [
			{
			    text: '添加',
			    iconCls: 'icon-add',
			    handler: function () {
			        sign = 'add';
			        $('#win_add').attr('title', '添加');
			        $('#win_add').show();
			        $('#win_add').window({
			            width: 450,
			            height: 300,
			            modal: true
			        });
			    }
			},'-',
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
                    $('#win_edit').attr('title', '修改');
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
    $('#addsave').click(function () {
    	FrconfigMng.addsave();
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
    $('#addcancel').click(function () {
    	FrconfigMng.addclose();
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