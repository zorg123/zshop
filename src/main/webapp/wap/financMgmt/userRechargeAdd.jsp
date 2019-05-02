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
                <li class="am-active">充值申请</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 充值申请
                    </div>
                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal">
                            	<div class="am-form-group">
                                    <label for="rec_bankname" class="am-u-sm-3 am-form-label">充值银行</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="rec_bankname" placeholder="充值银行">
                                        <small>请输入充值银行名称</small>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="rec_bankid" class="am-u-sm-3 am-form-label">充值卡号</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="rec_bankid" placeholder="充值卡号">
                                        <small>请输入充值卡号</small>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="rec_num" class="am-u-sm-3 am-form-label">充值金额</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" pattern="[0-9]*" id="rec_num" placeholder="充值金额">
                                        <small>输入充值金额</small>
                                    </div>
                                </div>
                               <div class="am-form-group">
                                    <label for="rec_message" class="am-u-sm-3 am-form-label">留言</label>
                                    <div class="am-u-sm-9">
                                        <textarea class="" rows="3" id="rec_message" placeholder="留言"></textarea>
                                        <small>100字以内</small>
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
			param["userRecharge.rec_bankname"] = $('#rec_bankname').val();
			param["userRecharge.rec_bankid"] = $('#rec_bankid').val();
			param["userRecharge.rec_num"] = $('#rec_num').val();
			param["userRecharge.rec_message"] = $('#rec_message').val();
			param["userRecharge.state"] = 0;
			CommonUtils.showLoading();
	        CommonUtils.invokeSyncAction(base+'/FinancMgmt/insertUserRec.do', param, function (reply) {
	        	CommonUtils.closeLoading();
				if((reply || '') !=''){
					var code = reply._code;
	                if(code=='0'){
	                	CommonUtils.showAlert('申请成功!');
	                	clear();
	                	pageData.openContent("/FinancMgmt/queryRecApply.do");
	        	   		return false;
	                }else{
	                	CommonUtils.showAlert('操作失败!');
	        	   		return false;
	                }
				}			
			});
		}
	}
	function check(){
		var rec_bankname = $('#rec_bankname').val();
	   	if(rec_bankname.length<=0){
	   		CommonUtils.showAlert('请输入充值银行!');
	   		return false;
	   	}
	   	var rec_bankid = $('#rec_bankid').val();
	   	if(rec_bankid.length<=0){
	   		CommonUtils.showAlert('请输入充值卡号!');
	   		return false;
	   	}
		var rec_num = $('#rec_num').val();
	   	if(!/^\+?[1-9][0-9]*$/.test(rec_num)){
	   		CommonUtils.showAlert('充值金额请输入整数值!');
	   		return false;
	   	}
	   	var rec_message = $('#rec_message').val();
	   	if(rec_message.length<=0){
	   		CommonUtils.showAlert('请输入留言!');
	   		return false;
	   	}
	   	if(rec_message.length>100){
	   		CommonUtils.showAlert('留言过长,请重新输入!');
	   		return false;
	   	}
		return true;
	}
	function clear(){
		$('#rec_bankname').val('');
		$('#rec_bankid').val('');
		$('#rec_num').val('');
		$('#rec_message').val('');
	}
</script>	