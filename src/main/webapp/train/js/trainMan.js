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
    	      CommonUtils.invokeAsyncAction(base+'/Train/deleteByIds.do', param, function (reply) {           
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
   },
   saveAudit:function(){
	   
	  var params = CommonUtils.getParam("audit_info",false);
	  var r = OperMan.getSelect();
	  params["infoTrainAudit.train_id"] = r.train_id;
      CommonUtils.invokeAsyncAction(base+'/Train/audit.do', params, function (reply) {           
           if ((reply || '') != '') {
               var code = reply._code;               
               if (code == '0') {  
            	   CommonUtils.confirmMsg('操作成功!',function(){
            		   $('#audit_info').window("close");
            		   OperMan.refresh();
                   });                   
               } else  {
               	   $.messager.alert('系统提示', '操作失败!', reply._msg);
               }              
           } else  {
           	 $.messager.alert('系统提示', '操作失败!', 'info');
           }
       });
    	        
   }
}

$(function () {	
    $('#dataList').datagrid({
        url:base+'/Train/queryTrainList.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
		pageSize:20,
		width:'100%',
		columns:[[  
				{field:'train_id',title:'',hidden:true},    
				{field:'train_name',title:'培训名称',hidden:true},
				{field:'ck',checkbox:true},
				{field:'train_title',title:'培训标题',width:'23%'},
				{field:'train_type_name',title:'培训类型',width:'10%'},
				{field:'train_start',title:'培训时间',width:'12%',formatter:function(value, row, index){
				    if (value.indexOf("T")>0) {
				        return value.replace("T"," ");
				    }
				    else {
				        return value;
				    }
				}},
				{field:'department_name',title:'培训部门',width:'10%'},
				{field:'people_amount',title:'参与人数',width:'5%'},
				{field:'train_peoples',title:'培训参与人员',width:'20%'},
				{field:'audit_staff_name',title:'审核人',width:'10%'},
				{field:'state',title:'状态',width:'8%',formatter:function(value, row, index){
				    var tvalue = value;
					if(value == "1"){
				    	tvalue ="已审核";
				    }else if(value == "2"){
				    	tvalue ="待审核";
				    }else if(value == "3"){
				    	tvalue ="审核不通过";
				    }else if(value == "0"){
				    	tvalue ="作废";
				    }
					return tvalue;
				}}	          
		      ]] ,
        toolbar: [
             {
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {     
                	
                	var url= base+"/Train/trainEdit.do?operType=1";
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
                	id = sRow.train_id;
                	var url= base+"/Train/trainEdit.do?operType=2&&infoTrain.train_id="+id;
                	CommonUtils.openWindow("修改",url,{width:700,height:600});                     
                }
            },{
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {                    
                	OperMan.deleteSel();                     
                }
            } ,{
                text: '审核',
                iconCls: 'icon-ok',
                handler: function () { 
                	var sRow = OperMan.getSelect();
                	if(!sRow){
                		CommonUtils.showMsg("请先选择一条记录!");
                		return;
                	}
                	if(sRow.state!='2'){
                		CommonUtils.showMsg("该记录不是待审核状态，不用审核!");
                		return;
                	}
                	$('#audit_info').attr('title', '审核');
                    $('#audit_info').show();
                    $('#audit_info').window({
                        width: 350,
                        height: 200,
                        modal: true
                    });                     
                }
            }     
        ]
    });

    $('#search_btn').bind('click', function () {
    	OperMan.search();
    });
    
    var data = $('#audit_result').combobox('getData');
    data[data.length] = { id: 1, text: '通过' };
    data[data.length] = { id: 0, text: '不通过' };
    $('#audit_result').combobox('loadData',data);
    
    $('#ok_btn').bind('click', function () {
    	OperMan.saveAudit();
    });
    $('#cancel_btn').bind('click', function () {
    	$('#audit_info').window("close");
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