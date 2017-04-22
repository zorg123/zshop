var RechargeMng = {
    save: function () {
    	var user_id;
        var user_code = $('input[name="user_code"]').val();
        //判断用户是否为空
        if(user_code.length<=0){
        	$.messager.alert('系统提示', '请输入会员编号!', 'info');
        	return;
        }
        var user_name = $('input[name="user_name"]').val();
        //判断用户名称是否为空
        if(user_name.length<=0){
        	$.messager.alert('系统提示', '请输入会员名称!', 'info');
        	return;
        }
    	//判断输入的金额
    	var coin_num = $('input[name="coin_num"]').val();
    	 if(!/^\+?[1-9][0-9]*$/.test(coin_num)){
    		 $.messager.alert('系统提示', '充值金额请输入整数值!', 'info');
    		 return;
    	 }else{
    		 var param ={};
         	 param["coinTrackDto.user_code"] = $('input[name="user_code"]').val();
         	 param["coinTrackDto.user_name"] = $('input[name="user_name"]').val();
             param["coinTrackDto.coin_num"] = $('input[name="coin_num"]').val();
             //附件id
             var file_info;
             if ($("#fileDownload ul li").length>0){
                var fileid;
                var fileName;
             	$("#fileDownload ul li").each(function(i,v){
                 	var $this = $(v);
                 	if($this.attr("fileid")){
                 		fileid = $this.attr("fileid");
                 	}
                 	if($this.attr("fileName")){
                 		fileName = $this.attr("fileName");
                 	}
                 });
                 file_info = "<a name='upFile'  target='_blank' href='/Attachement/download.do?fid="+fileid+"'>"+fileName+"</a>";
             }else{
             	file_info = "";
             }
             param["coinTrackDto.file_info"] = file_info;
             var me = this;
             CommonUtils.invokeAsyncAction(base+'/FinancMgmt/recharge.do', param, function (reply) {
 				if((reply || '') !=''){
 					var code = reply._code;
 			         if(code=='0'){
 			         	var retobj = reply.ret;
 			         	//3:成功
 			         	if(retobj.retCode=='3'){
 			         		$.messager.alert('系统提示', '添加成功!', 'info');
 			              	me.close();
 			                me.refresh();
 			         	}else{
 			         		$.messager.alert('系统提示', retobj.retString, 'info');
 			         	}
 			         }else{
 			        	$.messager.alert('系统提示', '添加失败!', 'info');
 			 	   		return false;
 			         }
 				}			
 			});       
    	 }
    },
    refresh: function () {
        $('#coinTrackList').datagrid('reload');
    },
    check: function () {
    	var user_id;
        var user_code = $('input[name="user_code"]').val();
        //判断用户是否为空
        if(user_code.length<=0){
        	$.messager.alert('系统提示', '请输入会员编号!', 'info');
        	return;
        }
        var param ={};
    	param["coinTrackDto.user_code"] = $('input[name="user_code"]').val();
        CommonUtils.invokeAsyncAction(base+'/FinancMgmt/getUserByCode.do', param, function (reply) {
		if((reply || '') !=''){
			var code = reply._code;
	         if(code=='0'){
	         	var retobj = reply.ret;
	         	//3:成功
	         	if(retobj.retCode=='1'){
	         		$('input[name="user_name"]').val(retobj.retUserName);
	         	}else{
	         		$.messager.alert('系统提示', retobj.retString, 'info');
	         		$('input[name="user_name"]').val('');
	         	}
	         }else{
	        	$.messager.alert('系统提示', '添加失败!', 'info');
	 	   		return false;
	         }
			}			
        });      
    },
    close: function () {
        $('#win_save').window('close');
        $('#win_save').hide();
    },
    clear: function () {
    	$('input[name="user_code"]').val('');
    	$('input[name="user_name"]').val('');
    	$('input[name="coin_num"]').val('');
    	$("#fileDownload ul").html("");
    	$("#_easyui_textbox_input1").val('');
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
  						  $("#fileDownload ul").append("<li fileId='"+returnValue.id+"' fileName='"+fileName+"'><a name='upFile'  target='_blank' href='/Attachement/download.do?fid="+returnValue.id+"'>"+fileName+"</a><a style='padding-left:20px;' href='javascript:void(0);' onclick='RechargeMng.deleteFile(this)'>删除</a></li>");
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
	   $("#fileDownload ul").html("");
	   $("#_easyui_textbox_input1").val('');
   }
}


$(function () {
    $('#coinTrackList').datagrid({
        url: base+'/FinancMgmt/getPagerListByConRec.do',
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
                    RechargeMng.clear();
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 450,
                        height: 300,
                        modal: true
                    });
                }
            },'-',
            {
            	text: '导出',
                iconCls: 'icon-redo',
                handler: function () {                 
                	var user_code = $('input[name="query_user_code"]').val();
	                var start_time = $('input[name="start_time"]').val();
	                var end_time = $('input[name="end_time"]').val();
	                
            	    var strParam = "coinTrackDto.user_code="+user_code;
            	    strParam += "&coinTrackDto.start_time="+start_time;
            	    strParam += "&coinTrackDto.end_time="+end_time;  
            	    var url = base+"/FinancMgmt/eportCoinTrackRec.do?"+strParam;
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
        RechargeMng.save();
    });
    $('#check').click(function () {
        RechargeMng.check();
    });
    $('#search_btn').bind('click', function () {
        var param = {};
        param["coinTrackDto.user_code"] = $('input[name="query_user_code"]').val();
        param["coinTrackDto.start_time"] = $('input[name="start_time"]').val();
        param["coinTrackDto.end_time"] = $('input[name="end_time"]').val();
        $('#coinTrackList').datagrid({
            queryParams: param
        });
    });
    $('#cancel').click(function () {
        RechargeMng.close();
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