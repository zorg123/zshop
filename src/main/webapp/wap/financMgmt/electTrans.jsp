<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>    
<div class="tpl-content-wrapper">
			<ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">电子币互转</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 电子币互转
                    </div>
                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">会员编号</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="user_code" placeholder="会员编号">
                                        <small>输入要转入的会员编号</small>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">电子币金额</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" pattern="[0-9]" id="coin_num" placeholder="电子币金额">
                                        <small>输入要转入的电子币金额</small>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">交易密码</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" pattern="[0-9]*" id="trans_pwd" placeholder="交易密码">
                                        <small>请输入注册时候的交易密码</small>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" class="am-btn am-btn-primary" id="save">提交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
</div>
        
<script language="javascript" type="text/javascript" >
	$('#save').bind('click', function () {
		save();
	});
	function save(){
		if(check()){
			var param ={};
			param["coinTrackDto.user_code"] = $('#user_code').val();
			param["coinTrackDto.coin_num"] = $('#coin_num').val();
			param["coinTrackDto.comments"] = $('#trans_pwd').val();
	        CommonUtils.invokeSyncAction(base+'/FinancMgmt/insertElectTrans.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	var retobj = reply.ret;
	                	//-1:输入的工号不存在 0:未激活 1:转入的电子币大于当前账户的电子币 2:输入的交易密码错误!3:成功
	                	if(retobj.retCode=='3'){
	                		CommonUtils.showAlert('操作成功!');
	                		clear();
	                		return;
	                	}else{
	                		CommonUtils.showAlert(retobj.retString);
	                		return;
	                	}
	                }else{
	                	CommonUtils.showAlert('操作失败!');
	        	   		return false;
	                }
				}			
			});
		}
	}
	function check(){
		var user_code = $('#user_code').val();
		if(user_code.length<=0){
			CommonUtils.showAlert('会员编号不能为空!');
        	return false;
        }
		var coin_num = $('#coin_num').val();
	   	if(!/^\+?[1-9][0-9]*$/.test(coin_num)){
	   		CommonUtils.showAlert('转入电子币请输入整数值!');
	   		return false;
	   	}
	   	var trans_pwd = $('#trans_pwd').val();
	   	if(!/^\+?[1-9][0-9]*$/.test(trans_pwd)){
	   		CommonUtils.showAlert('交易密码请输入数字');
	   		return false;
	   	}
		return true;
	}
	function clear(){
		$('#user_code').val('');
		$('#coin_num').val('');
		$('#trans_pwd').val('');
	}
</script>	