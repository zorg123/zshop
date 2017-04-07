var operEdit = {    
    save: function () {
        var params = CommonUtils.getParam("conditionDiv",1,false);
        params["infoManage.content"] = UE.getEditor('myEditor').getContent();
        var servFiles = [];
        //获取附件信息
        $("#fileDownload ul li").each(function(i,v){
        	var $this = $(v);
        	if($this.attr("fileid")){
        		params["infoServFileList["+i+"].file_id"]=$this.attr("fileid");
        		params["infoServFileList["+i+"].rela_type"]="manage";
        		params["infoServFileList["+i+"].state"]="1";
        	}
        });
        //params["infoServFileList"]=servFiles;
        
        var url=base+'/Manage/update.do';        
        CommonUtils.invokeAsyncAction(url, params, function (reply) {           
	           if ((reply || '') != '') {
	               var code = reply._code;               
	               if (code == '0') {                   
	                   CommonUtils.showMsgAlert('操作成功!',function(){
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
    },
    upload:function(){
    	var options = {
  			  target:'#output',
  			  type:'POST',
  			  url:base+'/Attachement/upload.do',
  			  data:{},				  
  			  beforeSubmit:function(){
  				  $("#fileForm").mask("导入中，请稍后...");					  
  			  },
  			  success:function process(response) {	
  				
  				  var result = eval(response);
  				  if(result._code=='0'){  					 
  					  var returnValue = result.ret;
  					  if(returnValue){
  						  var fileName = returnValue.fileName;
  						  $("#fileDownload ul").append("<li fileId='"+returnValue.id+"'><a name='upFile'  target='_blank' href='/Attachement/download.do?fid="+returnValue.id+"'>"+fileName+"</a><a style='padding-left:20px;' href='javascript:void(0);' onclick='operEdit.deleteFile(this)'>删除</a></li>");
  						  CommonUtils.showMsg("上传成功!");  	
  				  		}
  					   					
  				  }else{
  					CommonUtils.showMsg(result._msg);
  				  }
  			  },
  			  complete:function(){
  				$("#fileForm").unmask(); 
  			  },
  			  error:function(){	
  				CommonUtils.showMsg('系统提示',"操作失败，请稍后重试。");
  			  }
  		};
    	if($("#upload").val() == ''){
    		CommonUtils.showMsg('系统提示',"请选择文件要上传的文件.");
    		return;
    	}
    	
    	$("form[name='fileForm']").ajaxSubmit(options); 
   },
   deleteFile(o){
	   var $this = $(o);
	   $this.parent().remove();
   }
};

if(parent){
	parent.window.operEdit = operEdit;
}
window.callback = operEdit.callback;
$("#staff_btn").bind("click",function(){
	operEdit.open();
});

$('input[id=uploadFile]').change(function() {  
	$('#photoCover').textbox('setValue',$(this).val());  
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
