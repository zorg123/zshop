var RechargeMng = {
    save: function () {
    	var user_id;
        var user_code = $('input[name="user_code"]').val();
        //判断用户是否为空
        if(user_code.length<=0){
        	$.messager.alert('系统提示', '请输入会员编号!', 'info');
        	return;
        }
        var parampd ={};
        parampd["coinTrackDto.user_code"] = user_code;
        //判断工号在系统中是否存在,不存在提示
        var isExist=0;
        CommonUtils.invokeSyncAction(base+'/FinancMgmt/getUserByCode.do', parampd, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){
                	var retobj = reply.ret;
                	if(retobj.retCode=='-1'){
                		$.messager.alert('系统提示', '输入的会员编号不存在!', 'info');
                	}
                	if(retobj.retCode=='0'){
                		$.messager.alert('系统提示', '输入的会员未激活!', 'info');
                	}
                	if(retobj.retCode=='1'){
                		isExist='1';
                		user_id = retobj.retUserId;
                	}
                }else{
                	$.messager.alert('系统提示', '查询用户失败!', 'info');
                }
			}			
		});
        if(isExist=='0'){
        	return;
        }
        if(isExist=='1'){
        	//判断输入的金额
        	var coin_num = $('input[name="coin_num"]').val();
        	 if(!/^\+?[1-9][0-9]*$/.test(coin_num)){
        		 $.messager.alert('系统提示', '充值金额请输入整数值!', 'info');
        		 return;
        	 }else{
        		 var param ={};
             	 param["coinTrackDto.user_code"] = $('input[name="user_code"]').val();
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
                 param["coinTrackDto.user_id"] = user_id;
                 //1:奖金币 2:电子币 3:重消币
                 param["coinTrackDto.coin_type"] = 2;
                 //1:广告费 2:辅导奖 3:提现 4:充值 5:互转 6:转电子币 7:购物 8:重消
                 param["coinTrackDto.create_type"] = 4;
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
        	 }
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
    	$('input[name="user_code"]').val('');
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