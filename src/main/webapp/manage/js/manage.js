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
   deleteSel:function(){
	   
       var data = $('#dataList').datagrid("getSelections");
       var ids = '';
       $.each(data, function (i, value) {
    	   var id = value.train_id;
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
    	      CommonUtils.invokeAsyncAction(base+'/Manage/deleteByIds.do', param, function (reply) {           
    	           if ((reply || '') != '') {
    	               var code = reply._code;               
    	               if (code == '0') {  
    	            	   $.messager.alert('系统提示', '操作成功!', 'info');
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
        url:base+'/Manage/queryManageList.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
		pageSize:20,
		width:'100%',
		columns:[[  
				{field:'train_id',title:'',hidden:true},     
				{field:'ck',checkbox:true},
				{field:'titile',title:'标题',width:'23%'},
				{field:'manange_type_name',title:'记录类型',width:'10%'},
				{field:'eff_date',title:'生效时间',width:'12%',formatter:function(value, row, index){
				    if (value.indexOf("T")>0) {
				        return value.replace("T"," ");
				    }
				    else {
				        return value;
				    }
				}},
				{field:'exp_date',title:'失效时间',width:'12%',formatter:function(value, row, index){
				    if (value.indexOf("T")>0) {
				        return value.replace("T"," ");
				    }
				    else {
				        return value;
				    }
				}},
				{field:'state',title:'状态',width:'8%',formatter:function(value, row, index){
				    var tvalue = value;
					if(value == "1"){
				    	tvalue ="有效";
				    }else if(value == "0"){
				    	tvalue ="失效";
				    }
					return tvalue;
				}}	          
		      ]] ,
        toolbar: [
             {
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {     
                	
                	var url= base+"/Manage/manageEdit.do?operType=1";
                	CommonUtils.openWindow("新增",url,{width:700,height:600});                   
                }
            },{
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {                    
                	var sRow = OperMan.getSelect();
                	if(!sRow){
                		CommonUtils.showMsg("请先选择一条记录!");
                		return;
                	}
                	id = sRow.manage_id;
                	var url= base+"/Manage/manageEdit.do?operType=2&&infoManage.manage_id="+id;
                	CommonUtils.openWindow("修改",url,{width:700,height:600});                     
                }
            },{
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {                    
                	OperMan.deleteSel();                     
                }
            } 
        ]
    });

    $('#search_btn').bind('click', function () {
    	OperMan.search();
    });
    
    
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