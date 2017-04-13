var RechargeMng = {
    save: function () {
        var user_code = $('input[name="user_code"]').val();
        //判断工号在系统中是否存在,不存在提示
        var isExist=1;
        if(isExist==1){
        	var param ={};
        	param["coinTrackDto.user_code"] = $('input[name="user_code"]').val();
            param["coinTrackDto.coin_num"] = $('input[name="coin_num"]').val();
            var me = this;
            CommonUtils.invokeAsyncAction(base+'/FinancMgmt/insertCoinTrack.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '添加成功!', 'info');
	                	me.close();
	                    me.refresh();
	                }else{
	                	$.messager.alert('系统提示', '添加失败!', 'info');
	                }
				}			
			});       
        }else{
        	$.messager.alert('系统提示', '充值会员编号在系统中不存在,请重新输入!', 'info');
        }
    },
    refresh: function () {
        $('#coinTrackList').datagrid('reload');
    },
    close: function () {
        $('#win_save').window('close');
        $('#win_save').hide();
    },
    clear: function () {
    	//$('input[name="title"]').val('');
    	//$("#eff_date").datebox('setValue','');
    	//$("#exp_date").datebox('setValue','');//$('input[name="exp_date"]').val('');
        //$('select[name="state"]').val('1');
    }
}


$(function () {
    $('#coinTrackList').datagrid({
        url: base+'/FinancMgmt/getPagerListByCon.do',
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
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {
                    sign = 'save';
                    $('#win_save').attr('title', '会员充值');
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 250,
                        height: 200,
                        modal: true
                    });
                }
            }
        ]
    });

    $('#save').click(function () {
        RechargeMng.save();
    });
    $('#cancel').click(function () {
    	RechargeMng.close();
    });
    
    $('#search_btn').bind('click', function () {
        var param = {};
        param["coinTrackDto.user_code"] = $('input[name="user_code"]').val();
        param["coinTrackDto.start_time"] = $('input[name="start_time"]').val();
        param["coinTrackDto.end_time"] = $('input[name="end_time"]').val();
        $('#coinTrackList').datagrid({
            queryParams: param
        });
    });
});

function timeFormatter(date){
    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}
function timeParser(date){
    return new Date(Date.parse(date.replace(/-/g,"/")));
}