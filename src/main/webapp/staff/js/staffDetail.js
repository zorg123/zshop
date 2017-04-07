var StaffDetail = {    
    save: function () {
        var params = CommonUtils.getParam("conditionDiv",false);
        var url=base+'/Staff/update.do';        
        CommonUtils.invokeAsyncAction(url, params, function (reply) {           
	           if ((reply || '') != '') {
	               var code = reply._code;               
	               if (code == '0') {                   
	                   CommonUtils.confirmMsg('操作成功!',function(){
	                	   CommonUtils.closeWindow(); 
	                   });
	                   
	               } else  {
	               	$.messager.alert('系统提示', '操作失败!', 'info');
	               }              
	           } else  {
	           	 $.messager.alert('系统提示', '操作失败!', 'info');
	           }       
	     });
    },
    cancel:function(){
    	CommonUtils.closeWindow();
    }
};

 $('#save_btn').bind('click', function () {
	 StaffDetail.save();
 });
 
 $('#cancel_btn').bind('click', function () {
	 StaffDetail.cancel();
 })
