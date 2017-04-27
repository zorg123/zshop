var commMng = {
    save: function () {
        var goods_name = $('input[name="goods_name"]').val();
        if(goods_name.length<=0){
        	$.messager.alert('系统提示', '请输入商品名称!', 'info');
        	return;
        }
        var goods_price = $('input[name="goods_price"]').val();
        if(!/^\+?[1-9][0-9]*$/.test(goods_price)){
   		 $.messager.alert('系统提示', '商品价格请输入整数值!', 'info');
   		 return;
        }
        var pay_type = $("input[name='pay_type']:checked").map(function () {
            return $(this).val();
        }).get().join(',');
        if(pay_type.length<=0){
        	$.messager.alert('系统提示', '请选择购买积分类型!', 'info');
        	return;
        }
        var goods_desc = $('input[name="goods_desc"]').val();
        if(goods_desc.length<=0){
        	$.messager.alert('系统提示', '请输入商品描述!', 'info');
        	return;
        }
        var eff_date = $('input[name="eff_date"]').val();
        if(eff_date.length<=0){
        	$.messager.alert('系统提示', '请选择生效时间!', 'info');
        	return;
        }
        var exp_date = $('input[name="exp_date"]').val();
        if(exp_date.length<=0){
        	$.messager.alert('系统提示', '请选择失效时间!', 'info');
        	return;
        }
        //图片url
        var icon_url="";
        //图片下载地址
        var pic_url = "";
        if ($("#fileDownload ul li").length>0){
           var fileid;
           var fileName;
           var fileUrl;
        	$("#fileDownload ul li").each(function(i,v){
            	var $this = $(v);
            	if($this.attr("fileid")){
            		fileid = $this.attr("fileid");
            	}
            	if($this.attr("fileName")){
            		fileName = $this.attr("fileName");
            	}
            	if($this.attr("fileUrl")){
            		fileUrl = $this.attr("fileUrl");
            	}
            });
        	icon_url = fileUrl;
        	pic_url = "<a name='upFile'  target='_blank' href='/Attachement/download.do?fid="+fileid+"'>"+fileName+"</a>";
        }
        //alert("图片URL=="+icon_url);
        //alert("图片下载地址=="+pic_url);
        if(icon_url=="" || icon_url==undefined || pic_url=="" || pic_url==undefined){
        	$.messager.alert('系统提示', '请上传商品图片!', 'info');
        	return;
        }
        var param ={};
        param["goods.goods_name"] = $('input[name="goods_name"]').val();
        param["goods.catalog_id"] = $('input[name="catalog_id"]').val();
        param["goods.goods_price"] = $('input[name="goods_price"]').val();
        var pay_type = $("input[name='pay_type']:checked").map(function () {
            return $(this).val();
        }).get().join(',');
        param["goods.pay_type"] = pay_type;
        param["goods.goods_desc"] = $('input[name="goods_desc"]').val();
        param["goods.state"] = $('input[name="state"]').val();
        param["goods.eff_date"] = $('input[name="eff_date"]').val();
        param["goods.exp_date"] = $('input[name="exp_date"]').val();
        param["goods.icon_url"] = icon_url;
        param["goods.pic_url"] = pic_url;
        var me = this;
        CommonUtils.invokeAsyncAction(base+'/GoodsMgmt/insertGoodsConfig.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
		         if(code=='0'){
		        	$.messager.alert('系统提示', '添加成功!', 'info');
		        	me.clear();
	                me.refresh();
		        	me.close();
		         }else{
		        	$.messager.alert('系统提示', '添加失败!', 'info');
		 	   		return false;
		         }
			}			
        });
    },
    refresh: function () {
        $('#commList').datagrid('reload');
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
    	$('input[name="goods_name"]').val('');
    	$('input[name="goods_price"]').val('');
    	$('#goods_desc').textbox('setText', "");
    	$('input[name="eff_date"]').val('');
    	$('input[name="exp_date"]').val('');
    	$("#fileDownload ul").html("");
    	$("#_easyui_textbox_input2").val('');
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
  						  $("#fileDownload ul").append("<li fileId='"+returnValue.id+"' fileName='"+fileName+"' fileUrl='"+returnValue.fileUrl+"'><a name='upFile'  target='_blank' href='/Attachement/download.do?fid="+returnValue.id+"'>"+fileName+"</a><a style='padding-left:20px;' href='javascript:void(0);' onclick='commMng.deleteFile(this)'>删除</a></li>");
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
	   $("#_easyui_textbox_input2").val('');
   },
   formatState:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "0"){
			retVal="未发布";
		}else if (value == "1"){
			retVal = "已发布";
		}
		return retVal;
   },
   formatCatalogId:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "1"){
			retVal="精品拼团";
		}else if (value == "2"){
			retVal = "即时拼团";
		}
		return retVal;
  },
  payType:function(value,row){
		//alert(CommonUtils.dumpObject(row));
		var retVal = value;
		if(value == "2"){
			retVal="电子积分";
		}else if (value == "2,3"){
			retVal = "电子积分,重消积分";
		}else if (value == "3"){
			retVal = "重消积分";
		}
		return retVal;
  }
}


$(function () {
    $('#commList').datagrid({
        url: base+'/GoodsMgmt/getPagerListByConGoodsConfig.do',
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
                    //commMng.clear();
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 450,
                        height: 400,
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
    	commMng.clear();
    });
    $('#check').click(function () {
    	commMng.check();
    });
    $('#search_btn').bind('click', function () {
        var param = {};
        param["goods.catalog_id"] = $('input[name="query_catalog_id"]').val();
        param["goods.state"] = $('input[name="query_state"]').val();
        $('#commList').datagrid({
            queryParams: param
        });
    });
    $('#cancel').click(function () {
    	commMng.close();
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