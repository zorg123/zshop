
var sign=false;
var Login={
    login:function(){
        var user_name=$('input[name="user_name"]').val();
        var user_pass=$('input[name="user_pass"]').val();
        var valid_code= "";       
        if($('input[name="valid_code"]').length>0){
        	valid_code = $('input[name="valid_code"]').val();
        	if((valid_code || '')==='' || valid_code.length===0){        		
        		CommonUtils.showAlert('验证码不能为空!');
                $('input[name="valid_code"]').focus();
                return false;
            }
        	
        }
        
        if(this.check()){
            var param={};                      
            param.user_name=user_name;
            param.user_pass=user_pass;
            param.valid_code=valid_code;            
            if(!sign){
            	sign = true;
            	
            	CommonUtils.invokeAsyncAction(base+'/Sys/Login!validateWapLogin.do',param,function(reply){
            		
                    var result=reply.ret;                    
                    sign=false;                    
                    if(!result||reply==result) CommonUtils.showAlert("系统超时未返回，请重试!");	  
          		 
          		  	if(result.code=='0'){          		  		
          		  		window.location.href=base+"/Sys/mainwap.do?r="+(new Date()).getTime();
          		  	}else{  	    
          		  		Login.refreshValidCode();
          		  		CommonUtils.showAlert(result.msg);
          		  		return false;
          		  	}
                })
            }
        }
        return false;
    },
    check:function(){
        var user_name=$('input[name="user_name"]').val();
        var user_pass=$('input[name="user_pass"]').val();

        if((user_name || '')==='' || user_name.length===0){
        	CommonUtils.showAlert('工号不能为空!');
            $('input[name="user_name"]').focus();
            return false;
        }

        if((user_pass || '')==='' || user_pass.length===0){
        	CommonUtils.showAlert('密码不能为空!');
            $('input[name="user_pass"]').focus();
            return false;
        }

        return true;
    },
    refreshValidCode:function(){    	
    	$("#valid_code_img").attr("src",base+'/public/image.jsp?d='+(new Date()));
    }
}


$(function(){        
    
    $('#login_btn').click(function(){    	
        Login.login();
        return false; 
    });    
   
})
 

