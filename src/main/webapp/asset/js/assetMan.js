var importFlag = false;
var OperMan = {    
    search: function () {
        var params = CommonUtils.getParam("conditionDiv",false);
        $('#dataList').datagrid({
        	queryParams:params 
        })
    }, 
    refresh: function () {
        $('#dataList').datagrid('reload');
    },
    getSelect: function () {
        var row = $('#dataList').datagrid('getSelections');
        if(row.length == 0 || row.length>1){
        	CommonUtils.showMsg("请选择一条记录!");
        	return;
        }
        return row[0];
    },    
    loadFilter :function(data){
    	if (data.ret){
			return data.ret;
		} else {
			return data;
		}
    },
    importAsset:function(){
    	var options = {
  			  target:'#output',
  			  type:'POST',
  			  url:base+'/Asset/importAsset.do',
  			  data:{},				  
  			  beforeSubmit:function(){
  				  $("#execel_info_tb").mask("导入中，请稍后...");					  
  			  },
  			  success:function process(response) {	
  				
  				  var result = eval(response);
  				  if(result._code=='0'){
  					  importFlag = true;
  					  var returnValue = result.ret;
  					  
  					  if(returnValue.importErrNum==0){
  						  $.messager.alert('系统提示',"导入成功。", 'info');
  					  }else{
  						 $.messager.alert('系统提示',"导入失败，请见错误信息。", 'info');
  					  }
  					  
  					  $("#importSucNum").html("成功导入："+returnValue.importSucNum+" 条");
  					  $("#importErrNum").html("导入失败："+returnValue.importErrNum+" 条");
  					  $("#importErrMsg").html("失败信息："+returnValue.importErrMsg);
  					   					
  				  }else{
  					$.messager.alert('系统提示', result._msg, 'info');
  				  }
  			  },
  			  complete:function(){
  				$("#execel_info_tb").unmask(); 
  				$('#import_btn').attr("disabled",false);
  			  },
  			  error:function(){	
  				$.messager.alert('系统提示',"操作失败，请稍后重试。", 'info');
  			  }
  		};
    	if($("#upload").val() == ''){
    		$.messager.alert('系统提示',"请选择文件要导入的文件.", 'info');
    		return;
    	}
    	
    	$("form[name='excelForm']").ajaxSubmit(options); 
   },
   deleteSel:function(){
	   
       var data = $('#dataList').datagrid("getSelections");
       var ids = '';
       $.each(data, function (i, value) {
    	   var id = value.asset_id;
    	   if(id !='-1'){
    		   ids += id;
               ids += ','; 
    	   }           
       })
       
       if(ids=='' || $.trim(ids) == ''){
    	   $.messager.alert('系统提示',"请选择要删除的记录。", 'info');
    	   return;
       }
      
       $.messager.confirm('提示','确定要删除选择的记录?',function(r){
    	  if(r){
    		  var param = {};
    		  param["ids"] = ids;
    	      CommonUtils.invokeAsyncAction(base+'/Asset/deleteByIds.do', param, function (reply) {           
    	           if ((reply || '') != '') {
    	               var code = reply._code;               
    	               if (code == '0') {                    
    	                   $.messager.alert('系统提示', '删除成功!', 'info');
    	                   OperMan.refresh();
    	               } else  {
    	               	$.messager.alert('系统提示', '删除失败!', 'info');
    	               }              
    	           } else  {
    	           	 $.messager.alert('系统提示', '删除失败!', 'info');
    	           }
    	       })
    	  } 
       });       
   }
}

$(function () {	
    $('#dataList').datagrid({
        url:base+'/Asset/queryAssetList.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
		pageSize:20,
		width:'100%',
		columns:[[  
				{field:'asset_id',title:'',hidden:true},    
				{field:'asset_code',title:'资产编号'},
				{field:'asset_name',title:'资产名称'},
				{field:'asset_class_name',title:'资产分类'},
				{field:'make_date',title:'制单时间',formatter:function(value, row, index){
				    if (value.indexOf("T")>0) {
				        return value.replace("T"," ");
				    }
				    else {
				        return value;
				    }
				}},
				{field:'get_date',title:'取得日期',formatter:function(value, row, index){
				    if (value.indexOf("T")>0) {
				        return value.replace("T"," ");
				    }
				    else {
				        return value;
				    }
				}},
				{field:'asset_type',title:'规格型号'},
				{field:'asset_amount',title:'数量'},
				{field:'asset_cost',title:'价值'},
				{field:'use_department_name',title:'使用部门'},
				{field:'get_method_name',title:'取得方式'},
				{field:'use_staff',title:'使用人'},
				{field:'place',title:'存放地点'},
				{field:'use_direction',title:'使用方向'},
				{field:'use_state',title:'使用状况',formatter:function(value, row, index){
				    var tvalue = value;
					if(value == "1"){
				    	tvalue ="在用";
				    }else{
				    	tvalue ="失效";
				    }
					return tvalue;
				}},
				{field:'comments',title:'备注'},
				{field:'factory',title:'生产厂商'}		          
		      ]] ,
        toolbar: [
            {
                text: 'Excel导入',
                iconCls: 'icon-add',
                handler: function () {                    
                	$('#execel_info').attr('title', '设备信息Excel导入');
                    $('#execel_info').show();
                    $('#execel_info').window({
                        width: 450,
                        height: 380,
                        modal: true
                    });                   
                }
            }, {
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {     
                	
                	var url= base+"/Asset/assetEdit.do?operType=1";
                	CommonUtils.openWindow("新增",url);                   
                }
            },{
                text: '修改',
                iconCls: 'icon-mod',
                handler: function () {                    
                	var sRow = OperMan.getSelect();
                	if(!sRow){
                		CommonUtils.showMsg("请先选择一条记录!");
                		return;
                	}
                	id = sRow.asset_id;
                	var url= base+"/Asset/assetEdit.do?operType=2&&infoAsset.asset_id="+id;
                	CommonUtils.openWindow("修改",url);                     
                }
            },{
                text: '删除',
                iconCls: 'icon-del',
                handler: function () {                    
                	OperMan.deleteSel();                     
                }
            }      
        ]
    });

    $('#search_btn').bind('click', function () {
    	OperMan.search();
    })
    
    $('#cancel_import_btn').bind('click', function () {
    	$('#execel_info').hide();
        $('#execel_info').window("close");
        if(importFlag){
        	OperMan.search();
        }
    })
    $('#import_btn').bind('click', function () {
    	OperMan.importAsset();
    })
     $('#cancel_import_btn').bind('click', function () {
    	 $('#execel_info').window("colse");
    })
    
    var param = {};
    param["sqlId"]="7";
    CommonUtils.renderPieChart("orgPieDiv", "各部门设备使用情况", "各部门设备使用情况", null, param);
    
    $('#orgDataDiv').datagrid({
        url:base+'/InfoCommon/queryById.do?sqlId=7',        
		pageSize:20,
		width:'100%',
		columns:[[  
				{field:'name',title:'使用部门'},    
				{field:'value',title:'使用数量'}	          
		]] 
    });
    
})