$(function() {

        var $fullText = $('.admin-fullText');
        /*$('#admin-fullscreen').on('click', function() {
            $.AMUI.fullscreen.toggle();
        });

        $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
            $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
        });*/

        /*var dataType = $('body').attr('data-type');
        for (key in pageData) {
            if (key == dataType) {
                pageData[key]();
            }
        }*/

        $('.tpl-switch').find('.tpl-switch-btn-view').on('click', function() {
            $(this).prev('.tpl-switch-btn').prop("checked", function() {
                    if ($(this).is(':checked')) {
                        return false
                    } else {
                        return true
                    }
                })
                // console.log('123123123')

        });
        
     // ==========================
        // 侧边导航下拉列表
        // ==========================

    $('.tpl-left-nav-link-list').on('click', function() {
            $(this).siblings('.tpl-left-nav-sub-menu').slideToggle(80)
                .end()
                .find('.tpl-left-nav-more-ico').toggleClass('tpl-left-nav-more-ico-rotate');
        })
        // ==========================
        // 头部导航隐藏菜单
        // ==========================

    $('#menuToggle').on('click', function() {
        $('.tpl-left-nav').toggle();
        $('.tpl-content-wrapper').toggleClass('tpl-content-wrapper-hover');
    });
    $(".tpl-left-nav-sub-menu a").on('click', function() {
    	var $this = $(this);
    	$url = $this.attr("url");
    	
    	$(".tpl-left-nav-sub-menu a").removeClass("active");
    	$this.addClass("active");
    	$(".tpl-left-nav-item >a").removeClass("active");
    	//$this.parent().parent().parent().find("a:first").addClass("active");
    	if (browser.versions.mobile){
    		$('#menuToggle').trigger("click");
    	}
    	if($url != ''){
    		pageData.openContent($url);
    	}
    	
        return false;
    });
   
});

var pageData={
	'index':function indexdata(){
		var myScrollA = new IScroll('#wrapperA', {
            scrollbars: true,
            mouseWheel: true,
            interactiveScrollbars: true,
            shrinkScrollbars: 'scale',
            preventDefault: false,
            fadeScrollbars: true
        });
		
		this.queryNotices();
		
	},
	queryNotices: function () {
	        var param = {}, me = this;      
	        param.rows = 5;
	        param.page = 0;
	        CommonUtils.invokeAsyncAction(base+'/Sys/Notice!queryEffNoticeList.do', param, function (reply) {
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
	    	var content = $("#noticeContent");
	    	var HTML="";
	    	if(obj!=null && obj.length>0){    		
	    		for(var i=0;i<obj.length;i++){
	    			var oo = obj[i];	
	    			HTML+="<li><div class='cosB'>"+CommonUtils.transformDate(oo.eff_date,'1')+"</div>";
	    			HTML+="  <div class='cosA'><span class='cosIco'><i class='am-icon-bell-o'></i></span>";
	    			HTML+="   <span><a herf='javascript:void(0);' onclick=\"pageData.openDetail("+oo.notice_id+")\">"+oo.title+"</a></span>";
	    			HTML+="  </div>";
	    			HTML+="</li>"; 
	    		}
	    		HTML+="";
	    		content.append(HTML);
	    	}else{
	    		content.append("没有公告信息.");
	    	}      
	    },
	    openDetail:function(notice_id){
	    	var param = {}, me = this;      
	        param["notice.notice_id"] = notice_id;
	    	CommonUtils.invokeAsyncAction(base+'/Sys/Notice!queryContentDetail.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	 var result = reply.ret;   
	                	 if(result!=null){
		                	 $("#detailTitle").html(result.title);
		                	 $("#detailTime").html(CommonUtils.transformDate(result.eff_date));
		                	 $("#detailContent").html(result.content);
		                	 var html = $("#noticeDetail").html();
		                	 var pageii = layer.open({
		                		  type: 1
		                		  ,content: html
		                		  ,anim: 'up'
		                		  ,style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;'
		                	 });  
	                	 }
	                }
				}			
			});    	  
	  },	 
	 openContent:function($url,data,targetElement){
		 if(!targetElement){
			 targetElement = "mainContent";
		 }
		 $main = $("#"+targetElement);
		 if($url==null || $url==""){
			 return;
		 }
		 var params={};
		 if(data){
			 params = data;
		 }
		 $main.empty();
	     $.ajax({
				type:"post",//设置提交方式
				url:$url,//提交URL
				data:params,
				async:true,//设置调用方式，采用同步调用，异步会产生数据框为空的问题
				contentType:"application/x-www-form-urlencoded;charset=UTF-8",			
				//调用失败回调函数
				error:function(XMLHttpRequest, textStatus, errorThrown) {
					//alert("服务调用失败" + "\n" + errorThrown);
					$main.html("服务调用失败" + "\n" + errorThrown);
		        },
				//调用成功的回调函数
				success:function(html) {
					if(html instanceof Object){						
						if(html._code=="SYS_ERR002"){
							document.location.href="/wap/login"
						}else{
							$main.html(html._msg);
						}
					}else{
						$main.html(html);
					}
					
				}
		 });
	 },
	 openIndex:function(o){
		 var $this = $(o);		 
		 this.openContent($this.attr("url"));
		 $this.addClass("active");
		 $(".tpl-left-nav-sub-menu a").removeClass("active");
		 if (browser.versions.mobile){
			 $('#menuToggle').trigger("click");
		 }
	 },
	 "refresh":function(){		
		 var url =$("div[data-url]").attr("data-url");		
		 if(url!=''){
			 this.openContent(url);
		 }
	 },
	 "loginOut":function(){
		 CommonUtils.invokeAsyncAction(base+'/Sys/Login!loginOut.do',{},function(reply){
	           window.location.href=base+'/wap/login/';
	     })
	 }
}
    

