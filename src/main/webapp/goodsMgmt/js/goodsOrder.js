var GoodsOrderMng = {
    refresh: function () {
        $('#goodsOrderList').datagrid('reload');
    },
    close: function () {
        $('#win_edit').window('close');
        $('#win_edit').hide();
    },
    editInit: function(obj){
    	$('input[name="edit_order_id"]').val(obj.order_id);
    	$('input[name="edit_order_code"]').val(obj.order_code);
    	$('input[name="edit_deal_exp_ord"]').val(obj.deal_exp_ord);
    	$('input[name="edit_order_code"]').attr("disabled",true);
    },
    getSelect: function () {
        var row = $('#goodsOrderList').datagrid('getSelected');
        return row;
    },
    save: function(){
    	var param ={};
    	param["goodsOrder.order_id"] = $('input[name="edit_order_id"]').val();
    	param["goodsOrder.state"] = $('input[name="edit_state"]').val();
        param["goodsOrder.deal_exp_ord"] = $('input[name="edit_deal_exp_ord"]').val();
        var me = this;
        CommonUtils.invokeAsyncAction(base+'/GoodsMgmt/updateGoodsOrder.do', param, function (reply) {
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
    formatState:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "0"){
			retVal="未发货";
		}else if (value == "1"){
			retVal = "已发货";
		}else if (value == "2"){
			retVal = "待发货";
		}
		return retVal;
	}
}
$(function () {
    $('#goodsOrderList').datagrid({
        url: base+'/GoodsMgmt/getPagerListByCon.do',
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
                	var row = GoodsOrderMng.getSelect();
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
                    GoodsOrderMng.editInit(row);
                }
            },'-',
            {
            	text: '导出',
                iconCls: 'icon-redo',
                handler: function () {                 
                	var state = $('input[name="query_state"]').val();
                	var goods_id = $('input[name="goods_id"]').val();
	                var state_date_start = $('input[name="state_date_start"]').val();
	                var state_date_end = $('input[name="state_date_end"]').val();
	                //var order_code = $('input[name="query_order_code"]').val();
	                
            	    var strParam = "goodsOrder.state="+state;
            	    strParam += "&goodsOrder.goods_id="+goods_id;
            	    strParam += "&goodsOrder.state_date_start="+state_date_start;
            	    strParam += "&goodsOrder.state_date_end="+state_date_end;
            	    //strParam += "&goodsOrder.order_code="+order_code;
            	    var url = base+"/GoodsMgmt/exportGoodsOrder.do?"+strParam;
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
    	GoodsOrderMng.save();
    });
    $('#search_btn').bind('click', function () {
        var param = {};
        param["goodsOrder.state"] = $('input[name="query_state"]').val();
        param["goodsOrder.goods_id"] = $('input[name="goods_id"]').val();
        param["goodsOrder.state_date_start"] = $('input[name="state_date_start"]').val();
        param["goodsOrder.state_date_end"] = $('input[name="state_date_end"]').val();
        param["goodsOrder.order_code"] = $('input[name="query_order_code"]').val();
        $('#goodsOrderList').datagrid({
            queryParams: param
        });
    });
    $('#cancel').click(function () {
    	GoodsOrderMng.close();
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