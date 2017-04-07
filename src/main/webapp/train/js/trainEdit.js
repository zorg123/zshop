var operEdit = {    
    save: function () {
        var params = CommonUtils.getParam("conditionDiv",1,false);
        params["infoTrain.train_content"] = UE.getEditor('myEditor').getContent();
        var url=base+'/Train/update.do';        
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
    },
    open:function(){
    	var url= base+"/staff/staffSel.jsp";
    	CommonUtils.openWindow("选择审核人",url,{id:'dialogWindow1',width:600,height:500});
    },
    callback:function(obj){
    	$("#audit_staff_name").textbox("setValue",obj.name);
    	$("#audit_staff").val(obj.id);
    }
};

if(parent){
	parent.window.operEdit = operEdit;
}
window.callback = operEdit.callback;
$("#staff_btn").bind("click",function(){
	operEdit.open();
});

UE.getEditor('myEditor',{
    toolbars: [
               [ 'source', '|', 'undo', 'redo', '|',
            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
            'directionalityltr', 'directionalityrtl', 'indent', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
            'pagebreak', 'background', 'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols',  '|',
             'preview', 'searchreplace', 'help']
           ]
});
