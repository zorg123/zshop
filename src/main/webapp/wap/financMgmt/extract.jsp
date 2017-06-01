<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String baseUri = request.getContextPath();
%>
<s:set name="able_coin_num" value="result.able_coin_num"/>
<div>
			<ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">财务管理</a></li>
                <li class="am-active">会员提现</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 会员提现
                    </div>
                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal">
                            	<div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">可提现额度</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" placeholder='<s:property value="able_coin_num"/>' readOnly="true">
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">提现金额</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" pattern="[0-9]*" id="coin_num" placeholder="现金积分">
                                        <small>输入提现金额</small>
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
			param["coinTrackDto.coin_num"] = $('#coin_num').val();
			param["coinTrackDto.comments"] = $('#trans_pwd').val();
			CommonUtils.showLoading();
	        CommonUtils.invokeSyncAction(base+'/FinancMgmt/insertExtract.do', param, function (reply) {
	        	CommonUtils.closeLoading();
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	var retobj = reply.ret;
	                	//-1:转入的奖金币大于当前账户的奖金币 3:成功
	                	if(retobj.retCode=='3'){
	                		CommonUtils.showAlert('操作成功!');
	                		clear();
	                		pageData.openContent(base+"/FinancMgmt/initExtract.do");
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
	   		CommonUtils.showAlert('提现请输入整数值!');
	   		return false;
	   	}
	   	if(coin_num % 100!=0){
	   		CommonUtils.showAlert('提现金额为100的整数倍!');
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