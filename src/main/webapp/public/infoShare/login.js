/**
 * 登录和加载菜单.
 */
$(document).ready(function(){
    $(".start-menu").click(showOrHideMenu); //点击开始菜单.
    $("#menu-container").click(function(){event.stopPropagation();});   //阻止开始菜单面板上的click事件冒泡。
    $("body").click(function(){$("#menu-container").slideUp();});//点击body任意地方隐藏开始菜单.
    $("#show-all-function-btn").click(showAllFunction); //显示所有功能。
    $("#hide-not-available-function-btn").click(hideNotAvailableFunction);  //隐藏没有授权的功能.
    $("body").delegate(".popover-content", "click", closePopover);  //点击关闭开始菜单提示框.
    checkLogin();   //检查登录状态.
});

//隐藏或者显示系统菜单.
function showOrHideMenu(event){
    if($("#menu-container").css("display") == 'none'){
        $("#menu-container").slideDown();
    }else{
        $("#menu-container").slideUp();
    }
    event.stopPropagation();
}

//检查用户登录状态并设置相关视图。
function checkLogin(flag){
    $.get("/account/login-user", {}, function(res){
        var user = res.user;        
        if(user){
            //已经登陆.
            //隐藏登陆连接.
            $("#login-link").hide();
            $("#login-user-info").show();
            //显示欢迎语。
            $("#login-user-name").text(user.name);
            $("#login-user-name-top").text(user.name);
            $("#login-user-dep").text(res.depName);
            $("#login-user-dep-top").text(res.depName);
            loadFunctionMenu(); //初始化功能菜单.
            loadJobAndMsg();    //加载待办实现和站内消息。
            setInterval("loadJobAndMsg()",30000);    //定时刷新站内消息和代办工作.
            //显示开始菜单.
            $(".start-menu").show();
            $(".start-menu:visible:first").parent().popover('show');
        }else{
        	if(!flag){
	        	//如果没登录，则去主网站自动登录下
	            $.get("/manager/login",{},function(){
	            	checkLogin(true)
	            });
        	}
        	if(flag){
        		//没有登陆系统.
        		$("#login-link").show();
        		$(".start-menu").hide();
        	}
        }
    }, "json");
}

//加载当前用户的功能菜单，并且显示功能菜单。
function loadFunctionMenu(){
    $.get("/account/user-function", {}, function(functions){
        //判断菜单权限.
        $.each($(".menu-item"), function(i, n){
            var link = $(n).find("a:first");
            if(link && link.attr("href") != '' && functions[link.attr("href")]){
                //存在该权限.
                $(n).find(".disable-div-disabled").css({"display":"none"});
            }else{
                link.removeAttr("href");
                $(n).find(".disable-div-disabled").css({"display":""});
                $(this).css({"display":"none"});//隐藏没有权限的菜单.
            }
        });
    }, "json");
}

//加载待办工作和站内消息。
function loadJobAndMsg(){
    var msgList = _loadMessage();
    var taskList = _loadTaskJob();
    _loadProcessTaskCount();//刷新单项工作审批待办事项.
    var totalSize = 0;
    if(msgList && msgList.length > 0){
        totalSize += msgList.length;
    }
    if(taskList && taskList.length > 0){
        totalSize += taskList.length;
    }
    if(totalSize > 0){
        $(".job-remind").text(totalSize < 100 ? totalSize : 99);
        $(".job-remind").show();
    }
}

//加载站内消息.
function _loadMessage(){
    var msgList;
    $.ajax({
        type: "GET",
        url : "/manager/inform/unread",
        dataType: "json",
        cache: false,
        async:false,
        success : function(data, textStatus){
            msgList = data.result;
        }
    });
    //设置未读消息数量.
    $(".msg-unread-count").text(msgList ? (msgList.length > 99 ? "100+" : msgList.length) : "");
    //填充站内消息.
    $(".user-message").find(".message-title").remove();
    $.each(msgList, function(i, n){
        if(i > 5){
            return false;
        }
        $(".user-message").append("<div class='message-title'><span class='message-mark unread'>●</span><a href='javascript:readMessage(\""+n.id+"\");'>"+n.title+"</a><span class='message-time'>"+n.time+"</span></div>");
    });
    return msgList;
}

//加载用户待审批任务.
function _loadTaskJob(){
    var taskList;
    $.ajax({
        type: "GET",
        url : "/workflow/process/task",
        dataType: "json",
        cache: false,
        async:false,
        success : function(data, textStatus){
            taskList = data.result;
        }
    });
    if(!taskList){
        console.log("工作审批系统请求失败，未能获得待办工作。");
        return false;
    }
    //填充代办任务.
    $(".user-task").find(".message-title").remove();
    $.each(taskList, function(i, n){
        if(i > 5){
            return false;
        }
        $(".user-task").append("<div class='message-title'><span class='message-mark unread'>●</span>"+n.processName+"["+n.taskName+"]<span class='message-time'>"+n.time+"</span></div>");
    });
    return taskList;
}

//分别加载各个工作流程定义的待办任务数量。
function _loadProcessTaskCount(){
    $.get("/workflow/process/task-job-count", {}, function(res){
        for(var key in res.result){
            $(".process-job-remind[pdk='"+key+"']").text(res.result[key]);
            if(res.result[key] > 0){
                $(".process-job-remind[pdk='"+key+"']").show();
            }else{
                $(".process-job-remind[pdk='"+key+"']").hide();
            }
        }
    }, "json");
}

//点击阅读站内消息。
function readMessage(msgId){
    window.open("/manager/inform/"+msgId+"/form");
    setTimeout("_loadMessage()", 1000);//刷新站内消息。
}

//显示所有被隐藏的菜单.
function showAllFunction(){
    $(".menu-item").show();
    $("#show-all-function-btn").hide();
    $("#hide-not-available-function-btn").show();
}

//隐藏不可用功能。
function hideNotAvailableFunction(){
    $(".menu-item:has(.disable-div-disabled:visible)").hide();
    $("#show-all-function-btn").show();
    $("#hide-not-available-function-btn").hide();
}

//点击关闭开始菜单提示框.
function closePopover(){
    $(this).parents(".popover").remove();
}