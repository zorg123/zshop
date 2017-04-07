var type = "save";
var addMenuArray=[];
var deleteMenuArray=[];
var parentNodeCacheArray=[];//存放需要删除的父节点，如果没有子节点的话，就删除
var noticeMng = {
    save: function () {
        if (this.check()) {
            var param = noticeMng.getParams();
            var me = this;
            CommonUtils.invokeAsyncAction(base+'/Sys/Notice!insert.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '添加成功!', 'info');
	                	 me.clear();
	                	 me.close();
	                     me.refresh();	                	
	                }else{
	                	$.messager.alert('系统提示', '添加失败!', 'info');
	                }
				}			
			});           
        }
    },
    update: function (obj) {        

        if (null === obj || undefined === obj) {
            $.messager.alert('系统提示', '修改失败!', 'info');
            return;
        }
        if (this.check()) {
            var param = noticeMng.getParams();
            param["notice.notice_id"]=obj.notice_id;
            param["notice.content_id"]=obj.content_id;
            var me = this;
            CommonUtils.invokeAsyncAction(base+'/Sys/Notice!update.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	$.messager.alert('系统提示', '修改成功!', 'info');	  
	                	 me.clear();
	                	 me.close();
	                     me.refresh();
	                }else{
	                	$.messager.alert('系统提示', '修改失败!', 'info');
	                }
				}			
			});            
        }
    },
    deleteRole: function (obj) {
        var me = this;
        var param = {};
        param["notice.notice_id"] = obj;
        CommonUtils.invokeAsyncAction(base+'/Sys/Notice!delete.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){
                	$.messager.alert('系统提示', '删除成功!', 'info');
                     me.refresh();
                }else{
                	$.messager.alert('系统提示', '删除失败!', 'info');
                }
			}			
		});        
    },
    check: function () {
        var title = $('input[name="title"]').val();
        var eff_date = $("#eff_date").datebox('getValue');
        var exp_date = $("#exp_date").datebox('getValue');
        var state = $('select[name="state"]').val();
        var content = UE.getEditor('myEditor').getContent();
        
        if ((title || '') === '' || title.length === 0) {
            $.messager.alert('系统提示', '标题不能为空!', 'info');
            return false;
        }
        if ((eff_date || '') === '' || eff_date.length === 0) {
            $.messager.alert('系统提示', '生效时间不能为空!', 'info');
            return false;
        }
        
        if ((exp_date || '') === '' || exp_date.length === 0) {
            $.messager.alert('系统提示', '失效时间不能为空!', 'info');
            return false;
        }
        if(eff_date>exp_date){
        	 $.messager.alert('系统提示', '失效时间不能小于生效时间为空!', 'info');
             return false;
        }
        
        if ((state || '') === '' || state.length === 0) {
            $.messager.alert('系统提示', '状态不能为空!', 'info');
            return false;
        }
        
        if ((content || '') === '' || content.length === 0) {
            $.messager.alert('系统提示', '内容不能为空!', 'info');
            return false;
        }
        return true;
    },
    getParams:function(){
    	 var param ={};    	 
    	 param["notice.title"] = $('input[name="title"]').val();
    	 param["notice.eff_date"] = $("#eff_date").datebox('getValue');//$('input[name="eff_date"]').val();
    	 param["notice.exp_date"] = $("#exp_date").datebox('getValue');//$('input[name="exp_date"]').val();
    	 param["notice.state"] = $('select[name="state"]').val();
    	 param["notice.content"] = UE.getEditor('myEditor').getContent();
    	 return param;
    },
    clear: function () {
    	$('input[name="title"]').val('');
    	$("#eff_date").datebox('setValue','');
    	$("#exp_date").datebox('setValue','');//$('input[name="exp_date"]').val('');
        $('select[name="state"]').val('1');
        UE.getEditor('myEditor').setContent("");
    },
    close: function () {
        $('#win_save').window('close');
        $('#win_save').hide();
    },
    closeMenu:function(){
    	$('#win_menu').window('close');
        $('#win_menu').hide();
    },
    refresh: function () {
        $('#noticeList').datagrid('reload')
    },
    queryDetailById: function (obj) {
        var param = {}, me = this;
        param["notice.notice_id"] = obj;        
        CommonUtils.invokeAsyncAction(base+'/Sys/Notice!queryContentDetail.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
                if(code=='0'){
                	 var result = reply.ret;               	 
                	 me.setValues(result); 
                }
			}			
		});
    },
    setValues: function (obj) {
        $('input[name="title"]').val(obj.title);
        $("#eff_date").datebox('setValue',obj.eff_date.substring(0,10));//$("#dd").datebox('getValue');
        $("#exp_date").datebox('setValue',obj.exp_date.substring(0,10));
        //$('input[name="exp_date"]').val(obj.exp_date.substring(0,10));
        $('select[name="state"]').val(obj.state);        
        UE.getEditor('myEditor').setContent(obj.content);
    }
}


$(function () {
    $('#noticeList').datagrid({
        url: base+'/Sys/Notice!queryPageList.do',
        loadFilter:function(data){			
			return CommonUtils.loadFilter(data);
		},
        toolbar: [
            {
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {
                    sign = 'save';
                    noticeMng.clear();
                    $('#win_save').attr('title', '添加公告');
                    $('#win_save').show();
                    $('#win_save').window({
                        width: 550,
                        height: 500,
                        modal: true
                    });
                }
            },
            '-',
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    var row = $('#noticeList').datagrid('getSelected');
                    if (null == row) {
                        $.messager.alert('系统提示', '请选择要删除的记录!', 'info');
                        return;
                    }

                    $.messager.confirm('系统提示', '是否删除？', function (r) {
                        if (r) {
                        	noticeMng.deleteRole(row.notice_id);
                        }
                    })
                }
            },
            '-',
            {
                text: '修改',
                iconCls: 'icon-undo',
                handler: function () {
                    sign = 'update';
                    var row = $('#noticeList').datagrid('getSelected');
                    if (null == row) {
                        $.messager.alert('系统提示', '请选择要修改的记录!', 'info');
                        return;
                    }
                    noticeMng.clear();
                    noticeMng.queryDetailById(row.notice_id);
                    $('#win_save').attr('title', '修改公告');
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
        if (sign === 'update') {
            var row = $('#noticeList').datagrid('getSelected');
            noticeMng.update(row);
        } else  noticeMng.save();
    });
    $('#cancel').click(function () {
    	noticeMng.clear();
    	noticeMng.close();
    });

    $('#editorBtn').bind('click', function () {
    	$('#editorDiv').attr('title', '编辑内容');
        $('#editorDiv').show();        
        $('#editorDiv').window({
            width: 850,
            height: 450,
            modal: true
        });
    });

    $('#role_fun_save').bind('click', function () {
        Role.saveRoleFun();
    });

    $('#role_fun_add').bind('click', function () {
        Role.addFun();
    });
    
    $('#role_fun_del').bind('click', function () {
        Role.delFun();
    });
    
    $('#search_btn').bind('click', function () {
        var search_name = $('input[name="search_name"]').val();      
        var param = {};
        param["notice.title"] = search_name;       
        $('#noticeList').datagrid({
            queryParams: param
        });
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
                'insertimage', 'emotion', 'scrawl', 'insertvideo', 'music', 'attachment', 'map', 'gmap', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
                'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
                'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols',  '|',
                 'preview', 'searchreplace', 'help', 'drafts']
               ]
    });
});

function timeFormatter(date){
    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}
function timeParser(date){
    return new Date(Date.parse(date.replace(/-/g,"/")));
}