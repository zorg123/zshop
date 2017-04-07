var operEdit = {    
    save: function () {
        var params = CommonUtils.getParam("conditionDiv",1,false);
        var url=base+'/Asset/update.do';        
        CommonUtils.invokeAsyncAction(url, params, function (reply) {           
	           if ((reply || '') != '') {
	               var code = reply._code;               
	               if (code == '0') {                   
	                   CommonUtils.confirmMsg('操作成功!',function(){
	                	   CommonUtils.closeWindow(); 
	                	   if(parent.OperMan){
	                		   parent.OperMan.refresh();
	                	   }
	                   });
	                   
	               } else  {
	               	$.messager.alert('系统提示', '操作失败!', 'info');
	               }              
	           } else  {
	           	 $.messager.alert('系统提示', '操作失败! ', 'info');
	           }       
	     });
    },
    cancel:function(){
    	CommonUtils.closeWindow();
    }
};

if(parent){
	parent.window.operEdit = operEdit;
}
