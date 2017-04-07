var noticeIndex = {    
    close: function () {
        $('#noticeContent').window('close');
        $('#noticeContent').hide();
    },    
    queryNotices: function () {
        var param = {}, me = this;      
        param.rows = 5;
        param.page = 0;
        CommonUtils.invokeAsyncAction(base+'/Sys/Notice!queryEffNoticeList.do', param, function (reply) {
			if((reply || '') !=''){
				var code = reply._code;
				console.log(reply);
                if(code=='0'){
                	 var result = reply.ret;               	 
                	 me.setValues(result); 
                }
			}			
		});
    },
    setValues: function (obj) {
    	var content = $("#noticeContent");
    	var HTML="<ul>";
    	if(obj!=null && obj.length>0){    		
    		for(var i=0;i<obj.length;i++){
    			var oo = obj[i];
    			//alert(oo.create_date);
    			HTML+="<li ><div class='title'><a herf='javascript:void(0);' onclick=\"noticeIndex.openDetail("+oo.notice_id+")\">"+oo.title+"</a></div> <div class='time'>"+CommonUtils.transformDate(oo.eff_date,'1')+"</div></li>";
    		}
    		HTML+="</ul>";
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
	                	 $('#noticeDetail').attr('title', '公告详情');
	                     $('#noticeDetail').show();
	                     $('#noticeDetail').window({
	                         width: 650,
	                         height: 400,
	                         modal: true
	                     });
                	 }
                }
			}			
		});    	  
    }
}
