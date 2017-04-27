var ExtractConfirmMng = {
    refresh: function () {
        $('#extractConfirmList').datagrid('reload');
    },
    close: function () {
        $('#win_edit').window('close');
        $('#win_edit').hide();
    },
    editInit: function(obj){
    	$('input[name="edit_id"]').val(obj.id);
    	$('input[name="edit_user_id"]').val(obj.user_id);
    	$('input[name="edit_user_code"]').val(obj.user_code);
    	$('input[name="edit_coin_num"]').val(obj.act_num);
    	$('input[name="edit_serial_num"]').val(obj.serial_num);
    	$('input[name="edit_user_code"]').attr("disabled",true);
    	$('input[name="edit_coin_num"]').attr("disabled",true);
    },
    getSelect: function () {
        var row = $('#extractConfirmList').datagrid('getSelected');
        return row;
    },
    save: function(){
    	var param ={};
    	param["coinTrackDto.id"] = $('input[name="edit_id"]').val();
    	param["coinTrackDto.user_id"] = $('input[name="edit_user_id"]').val();
        param["coinTrackDto.apply_state"] = "1";
        param["coinTrackDto.serial_num"] = $('input[name="edit_serial_num"]').val();
        //提款为负值，所以要乘以-1
        param["coinTrackDto.coin_num"] = $('input[name="edit_coin_num"]').val()*-1;
        var me = this;
        CommonUtils.invokeAsyncAction(base+'/FinancMgmt/updateCoinTrack.do', param, function (reply) {
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
    $('#extractConfirmList').datagrid({
        url: base+'/FinancMgmt/getPagerListByConExtConf.do',
        loadFilter:function(data){
        	var jsonStr = JSON.stringify(data);
        	if (jsonStr.indexOf("T")>0) {
        		jsonStr = jsonStr.replace(/T/g," ");
        		data =  JSON.parse(jsonStr);
		    }
			return CommonUtils.loadFilter(data);
		},
        toolbar: [
            {
                text: '修改',
                iconCls: 'icon-undo',
                handler: function () {
                	var row = ExtractConfirmMng.getSelect();
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
                    ExtractConfirmMng.editInit(row);
                }
            },'-',
            {
            	text: '导出',
                iconCls: 'icon-redo',
                handler: function () {                 
                	var user_code = $('input[name="query_user_code"]').val();
	                var start_time = $('input[name="start_time"]').val();
	                var end_time = $('input[name="end_time"]').val();
	                var apply_state = $('input[name="apply_state"]').val();
	                
            	    var strParam = "coinTrackDto.user_code="+user_code;
            	    strParam += "&coinTrackDto.start_time="+start_time;
            	    strParam += "&coinTrackDto.end_time="+end_time;
            	    strParam += "&coinTrackDto.apply_state="+apply_state;
            	    var url = base+"/FinancMgmt/eportCoinTrackExtConf.do?"+strParam;
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
    });
    $('#save').click(function () {
        ExtractConfirmMng.save();
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
        ExtractConfirmMng.close();
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