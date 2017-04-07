// JavaScript Document
window.onresize=function()
{
   if(!parent.gi('frame1')) return;
   var rows = parent.gi('frame1').rows.split(",");
   if(rows.length < 2 || rows[1]!="*") return;
   gi("bottom_center").style.width = "0px";
 
   if(document.body.clientHeight > gi("sub_tabs").clientHeight+gi("bottom").clientHeight)
      gi("left_menu").style.height=(document.body.clientHeight-gi("sub_tabs").clientHeight-gi("bottom").clientHeight)+"px";
 
   var widthTotal = parseInt(gi("bottom").clientWidth);
   var widthLeft = parseInt(gi("bottom_left").clientWidth);
   var widthRight = parseInt(gi("bottom_right").clientWidth);
   if(!isNaN(widthTotal) && !isNaN(widthLeft) && !isNaN(widthRight))
   {
      gi("bottom_center").style.width = widthTotal - widthLeft - widthRight + "px";
   }
};
function init()
{
   window.onresize();
}
 

var cur_id="",cur_expand="";
var flag=0,sflag=0;
 
//-------- 菜单点击事件 -------
function c(id)
{
  var targetid,targetelement;
  var strbuf;
 
  var el=gi(id);
  if(!el)
     return;
  //-------- 如果点击了展开或收缩按钮---------
  targetid=el.id+"d";
  targetelement=gi(targetid);
  var expandUL=gi(cur_expand+"d");
  var expandLink=gi(cur_expand);
  if(!targetelement){
	  return;
  }
  
  if (targetelement.style.display=="none")
  {
     if(expandUL && expandLink && el.id.substr(0,1)=="m")
     {
        expandLink.className="";
        expandUL.style.display='none';
     }
     if(el.id.substr(0,1)=="m")
        cur_expand=el.id;
     el.className="active";
     targetelement.style.display='';
 
     menu_flag=0;
     //gi("expand_link").src="images/green_minus.gif";
  }
  else
  {
     el.className="";
     targetelement.style.display="none";
 
     menu_flag=1;
     //gi("expand_link").src="images/green_plus.gif";
     var links=document.getElementsByTagName("A");
     for (i=0; i<links.length; i++)
     {
       el=links[i];
       if(el.parentNode.className.toUpperCase()=="L1" && el.className=="active" && el.id.substr(0,1)=="m")
       {
          menu_flag=0;
         // gi("expand_link").src="images/green_minus.gif";
          break;
       }
     }
  }
}
//-------- 打开网址 -------
var gi = function(id) {return document.getElementById(id);};
var userAgent = navigator.userAgent.toLowerCase();
var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera) && userAgent.substr(userAgent.indexOf('msie') + 5, 3);
function MouseOverBtn(){event.srcElement.className+="Hover";}
function MouseOutBtn() {event.srcElement.className=event.srcElement.className.substr(0,event.srcElement.className.indexOf("Hover"));}
function CorrectButton()
{
   var inputs=document.getElementsByTagName("INPUT");
   for(var i=0; i<inputs.length; i++)
   {
      var el = inputs[i];
      var elType = el.type.toLowerCase();
      var elClass = el.className.toLowerCase();
      var elLength = Math.ceil(el.value.replace(/[^\x00-\xff]/g,"**").length/2);
      if(elType!="button" && elType!="submit" && elType!="reset" || elClass!="bigbutton"&&elClass!="smallbutton")
         continue;
      
      if(elLength<=3)
         el.className+="A";
      else if(elLength==4)
         el.className+="B";
      else if(elLength>=5 && elLength<=7)
         el.className+="C";
      else if(elLength>=8 && elLength<=11)
         el.className+="D";
      else
         el.className+="E";
      
      if(is_ie)
      {
         el.attachEvent("onmouseover", MouseOverBtn);
         el.attachEvent("onmouseout",  MouseOutBtn);
      }
   }
}
if(is_ie)
   window.attachEvent("onload", CorrectButton);
else
   window.addEventListener("load", CorrectButton,false);
   
var Menu={
	left_on:'T',
	init:function(){
		CommonUtils.invokeAsyncAction(base+'/Sys/Sys!getRootMenuByRole.do',{},function(reply){
			var arr=new Array();
			reply = reply.ret;
			if(reply){
				for(var i=0,j=reply.length;i<j;i++){
					var mu = reply[i];
					arr.push('<li onclick="Menu.getModule('+mu.menu_id+',\''+mu.menu_name+'\')"><p><img src="'+base+'/public/common/ress/images/main/icon_0'+(i+1)+'.png" width="40" height="40"></p>');
					arr.push('<p><a href="javascript:void(0)">'+mu.menu_name+'</a></p></li>');
				}
			}
			$(".quick_menu").html(arr.join(" "));
			correctPNG();
			$(".quick_menu li").first().trigger("click").addClass("current");
			$(".quick_menu li").click(function(){
				$(this).siblings().removeClass("current");
				$(this).addClass("current");
			})
		});
	},
	getModule:function(fun_id,fun_name){
		$(".leftmenutop").html(fun_name);
		$("#menu").html("");
		CommonUtils.invokeAsyncAction(base+'/Sys/Login!getSubTwoLevelMenuList.do',{menuId:fun_id},function(reply){
			var arr=new Array();
			reply = reply.ret;
			if( reply && reply!='undefined' ){
				for(var i=0,j=reply.length;i<j;i++){
					var mu = reply[i];
					arr.push('<li class="L1"><a href="javascript:c(\'m'+mu.menu_id+'\');" id="m'+mu.menu_id+'"><span class="date">'+mu.menu_name+'</span></a></li>');
					arr.push('<ul id="m'+mu.menu_id+'d" class="U1" style="display:none;">');
					var subMenu = mu.sub_menu_list;
					if(subMenu){
						for(var m=0,n=subMenu.length;m<n;m++){
							var smu = subMenu[m];
							arr.push('<li class="L21"><a href="javascript:Menu.openTab('+smu.menu_id+',\''+smu.menu_name+'\',\''+base+smu.menu_url+'\')"><span>'+smu.menu_name+'</span></a></li>');
						}
					}
					arr.push('</ul> ');
					
				}
			}
			$("#menu").html(arr.join(" "));
			
			$("#menu li").trigger("click");
			$("#menu li").first().find("a").addClass("active");
			$("#menu li").first().next("ul").show();
			$("#menu li").click(function(){
				$(this).siblings().find("a").removeClass("active");
				$(this).find("a").addClass("active");
				$(this).siblings().next("ul").hide();
			});
			
			
		});
	},
	openTab:function(fun_id,fun_name,fun_url){
		frame_window.tab.add( {
			id :'tab_'+fun_id,
			title :fun_name,
			url :fun_url,
			isClosed :true
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
var frame_window ;
$(function(){
	Menu.init();
//	frame_window=document.getElementById("frame_page").contentWindow;
	frame_window=$("#frame_page").get(0).contentWindow;
	
	$("#profile").click(function(){//个人资料修改
	
	});
	/*$("#relogin").click(function(){//重登录
	
	});*/
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
	 
	$("#center_line").click(function(){//中间栏目
		if(Menu.left_on=='T'){
			$(".leftmenu").hide();
			$(".main_div").css("margin-left","0px")
			Menu.left_on='F';
		}else{
			$(".leftmenu").show();
			$(".main_div").css("margin-left","150px")
			Menu.left_on='T';
		}
	});
	
})
