<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>    
<div class="tpl-content-wrapper">
			<ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">奖金币转电子币</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 奖金币转电子币
                    </div>
                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal">
                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">奖金币</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" pattern="[0-9]*" id="coin_num" placeholder="奖金币">
                                        <small>请输入转入的奖金币总额</small>
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
                                        <button type="button" class="am-btn am-btn-primary" id="save">转入</button>
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
			param["coinTrackDto.coin_num"] = $('#coin_num').val();
			param["coinTrackDto.comments"] = $('#trans_pwd').val();
	        CommonUtils.invokeSyncAction(base+'/FinancMgmt/bonusToElect.do', param, function (reply) {
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	var retobj = reply.ret;
	                	//-1:转入的奖金币大于当前账户的奖金币 3:成功
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
		var coin_num = $('#coin_num').val();
	   	if(!/^\+?[1-9][0-9]*$/.test(coin_num)){
	   		CommonUtils.showAlert('转入奖金币请输入整数值!');
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
		$('#coin_num').val('');
		$('#trans_pwd').val('');
	}
</script>	