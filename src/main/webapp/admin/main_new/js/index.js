var tab = null;
var accordion = null;
var tree = null;
var tabItems = [];
$(function (){
    //布局
    $("#layout1").ligerLayout({ leftWidth: 190, height: '100%',heightDiff:-34,space:4, onHeightChanged: f_heightChanged });
    var height = $(".l-layout-center").height();

    //Tab
    $("#framecenter").ligerTab({
        height: height,
        showSwitchInTab : true,
        showSwitch: true,
        onAfterAddTabItem: function (tabdata)
        {
            tabItems.push(tabdata);
            saveTabStatus();
        },
        onAfterRemoveTabItem: function (tabid)
        { 
            for (var i = 0; i < tabItems.length; i++)
            {
                var o = tabItems[i];
                if (o.tabid == tabid)
                {
                    tabItems.splice(i, 1);
                    saveTabStatus();
                    break;
                }
            }
        },
        onReload: function (tabdata)
        {
            var tabid = tabdata.tabid;
            //addFrameSkinLink(tabid);
        }
    });

    //面板
    $("#accordion1").ligerAccordion({ height: height - 24, speed: 200 });

    $(".l-link").hover(function (){
        $(this).addClass("l-link-over");
    }, function (){
        $(this).removeClass("l-link-over");
    });
        
    Menu.init();
    
    tab = liger.get("framecenter");
    accordion = liger.get("accordion1");
    tree = liger.get("tree1");
    $("#pageloading").hide();
    css_init();
    //pages_init();
    
    $("#logout").click(function(){//退出
		CommonUtils.invokeAsyncAction(base+'/Sys/Login!loginOut.do',{},function(reply){
           window.location.href=base+'/admin/login';
        })
	});
	$("#mdfPwd").click(function(){//修改密码
		$('#pwd_win').attr('title', '修改密码');
        $('#pwd_win').show();
        $('#pwd_win').window({
            width: 260,
            height: 200,
            modal: true
        });
	});
	
	$('#save').click(function () {
		Menu.mdfPwd();
	});
	 
	$('#cancel').click(function () {
		Menu.clear();
		Menu.close();
	});
});
function f_heightChanged(options)
{  
    if (tab)
        tab.addHeight(options.diff);
    if (accordion && options.middleHeight - 24 > 0)
        accordion.setHeight(options.middleHeight - 24);
}
function f_addTab(tabid, text, url)
{	
    tab.addTabItem({
        tabid: tabid,
        text: text,
        url: url,
        callback: function ()
        {            
            addFrameSkinLink(tabid); 
        }
    });
}

function addFrameSkinLink(tabid)
{
    var prevHref = getLinkPrevHref(tabid) || "";
    var skin = getQueryString("skin");
    if (!skin) return;
    skin = skin.toLowerCase();
    attachLinkToFrame(tabid, prevHref + skin_links[skin]);
}
var skin_links = {
    "aqua": base+"/public/ligerUI/skins/Aqua/css/ligerui-all.css",
    "gray": base+"/public/ligerUI/skins/Gray/css/all.css",
    "silvery": base+"/public/ligerUI/skins/Silvery/css/style.css",
    "gray2014": base+"/public/ligerUI/skins/gray2014/css/all.css"
};
function pages_init()
{
    var tabJson = $.cookie('liger-home-tab'); 
    if (tabJson)
    { 
        var tabitems = JSON2.parse(tabJson);
        for (var i = 0; tabitems && tabitems[i];i++)
        { 
            f_addTab(tabitems[i].tabid, tabitems[i].text, tabitems[i].url);
        } 
    }
}
function saveTabStatus()
{ 
    $.cookie('liger-home-tab', JSON2.stringify(tabItems));
}
function css_init()
{
    var css = $("#mylink").get(0), skin = getQueryString("skin");
    $("#skinSelect").val(skin);
    $("#skinSelect").change(function ()
    { 
        if (this.value)
        {
            location.href = "index.htm?skin=" + this.value;
        } else
        {
            location.href = "index.htm";
        }
    });

   
    if (!css || !skin) return;
    skin = skin.toLowerCase();
    $('body').addClass("body-" + skin); 
    $(css).attr("href", skin_links[skin]); 
}
function getQueryString(name)
{
    var now_url = document.location.search.slice(1), q_array = now_url.split('&');
    for (var i = 0; i < q_array.length; i++)
    {
        var v_array = q_array[i].split('=');
        if (v_array[0] == name)
        {
            return v_array[1];
        }
    }
    return false;
}
function attachLinkToFrame(iframeId, filename)
{ 
    if(!window.frames[iframeId]) return;
    var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
    var fileref = window.frames[iframeId].document.createElement("link");
    if (!fileref) return;
    fileref.setAttribute("rel", "stylesheet");
    fileref.setAttribute("type", "text/css");
    fileref.setAttribute("href", filename);
    head.appendChild(fileref);
}
function getLinkPrevHref(iframeId)
{
    if (!window.frames[iframeId]) return;
    var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
    var links = $("link:first", head);
    for (var i = 0; links[i]; i++)
    {
        var href = $(links[i]).attr("href");
        if (href && href.toLowerCase().indexOf("ligerui") > 0)
        {
            return href.substring(0, href.toLowerCase().indexOf("lib") );
        }
    }
} 
var Menu={		
		init:function(){
			var self =this;
			$(".ligerTree").ligerTree({        
		        checkbox: false,
		        slide: false,
		        nodeWidth: 120,
		        idFieldName:'menu_id',
		        parentIDFieldName:'up_menu_id',
		        textFieldName:'menu_name',
		        attribute: ['url_open_type', 'menu_name','menu_url', 'menu_id'],
		        onClick: function (node)
		        {
		            //console.log(node);
		            // console.log(this.id);
		            //var manager = $("#"+this.id).ligerGetTreeManager();
		            //console.log(manager);
				    //alert(node.data.menu_url != (base+"/"));
				    //alert(node.data.menu_url);
					if (!node.data.menu_url){
		            	//如果节点没有url，查询数据库看是否有子节点。
						if(!$(node.target).attr("isLoad")){
			            	self.getSubModule(this,node,node.data.menu_id);
			            	$(node.target).attr("isLoad", true)
						}
		            	return;
		            };
		            var tabid = $(node.target).attr("tabid");
		            if (!tabid)
		            {
		                tabid = new Date().getTime();
		                $(node.target).attr("tabid", tabid)
		            } 
		            var url =node.data.menu_url;
		            if(base!=''){
		            	url = base+"/"+url;
		            }
		            f_addTab(tabid, node.data.menu_name, url);
		            
		        }
		    });
		},
		getSubModule:function(thisTree,node,fun_id){
			
			CommonUtils.invokeAsyncAction(base+'/Sys/Login!getSubTwoLevelMenuList.do',{menuId:fun_id},function(reply){
				var arr=new Array();
				reply = reply.ret;
				//for(var i in reply ){
				//	var r = reply[i];
				//	if(base !=''){
				//		r.menu_url = base+"/"+r.menu_url
				//	}
				//}
				thisTree.append(node.target,reply);
			});
		},		
		clear: function () {
		      $('#old_pwd').val('');
		      $('#new_pwd').val('');
		      $('#re_new_pwd').val('');
		},
		close: function () {
		      $('#pwd_win').window('close');
		      $('#pwd_win').hide();
		},
		mdfPwd:function(){
			 var oldPwd = $('#old_pwd').val();
		     var newPwd =  $('#new_pwd').val();
		     var reNewPwd = $('#re_new_pwd').val();
		     if($.trim(oldPwd) == ""){
		    	 $.messager.alert("温馨提示","老用户密码不能为空!","info");
		    	 return false;
		     }	     
		     if($.trim(newPwd) == ""){
		    	 $.messager.alert("温馨提示","新用户密码不能为空!","info");
		    	 return false;
		     }	     
		     if($.trim(reNewPwd) == ""){
		    	 $.messager.alert("温馨提示","确认密码不能为空!","info");
		    	 return false;
		     }
		     if($.trim(reNewPwd) != $.trim(newPwd) ){
		    	 $.messager.alert("温馨提示","新密码和确认密码不一致!","info");
		    	 return false;
		     }
		     var param ={};
		     param["oldPwd"] = oldPwd;
		     param["newPwd"] = newPwd;
			CommonUtils.invokeAsyncAction(base+'/Sys/Login!modifyPwd.do',param,function(reply){
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){	 
	                	$.messager.alert('系统提示', '修改成功!', 'info');
	                	Menu.clear();
	            		Menu.close();
	                }else{
	                	$.messager.alert('系统提示', reply._msg, 'info');
	                }
				}
		    })
		}
	}