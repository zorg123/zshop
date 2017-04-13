var RechargeMng = {
    save: function () {
        var user_code = $('input[name="user_code"]').val();
        var parampd ={};
        parampd["coinTrackDto.user_code"] = user_code;
        //判断工号在系统中是否存在,不存在提示
        var isExist=0;
        CommonUtils.invokeAsyncAction(base+'/FinancMgmt/getUserByCode.do', parampd, function (reply) {
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
        	var param ={};
        	param["coinTrackDto.user_code"] = $('input[name="user_code"]').val();
            param["coinTrackDto.coin_num"] = $('input[name="coin_num"]').val();
            //附件id
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
            var file_info = "<a name='upFile'  target='_blank' href='/Attachement/download.do?fid="+fileid+"'>"+fileName+"</a>";
            param["coinTrackDto.file_info"] = file_info;
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
	   $("#_easyui_textbox_input1").attr("value","");
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
                    $("#fileDownload ul").html("");
                    $("#_easyui_textbox_input1").attr("value","");
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 550,
                        height: 500,
                        modal: true
                    });
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