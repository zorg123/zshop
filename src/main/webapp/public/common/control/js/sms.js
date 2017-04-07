/**
 * 发送短信验证码公用js
 */
var Sms = function() {
    this.sendFlag = 0;
    this.limitTime = 0;
    this.countTime = 0;
    this.countInterval = null;
    this.sendBtn = null;
    this.type='';
    this.sign=true;
    /**
     * 发送短信验证码
     * @param {} phoneNum	发送号码
     * @param {} sendBtn	发送短信验证码按钮对象
     * @param {} limitTime	允许再次发送时间
     */
    this.sendSms = function(phoneNum, sendBtn, limitTime,type) {
        var me = this;
        if (me.sendFlag == 0) {
            me.limitTime = limitTime || 100;
            me.countTime = me.limitTime;
            me.sendBtn = sendBtn;
            me.sendFlag = 1;
            me.type=type;
            //开始倒计时、并发送短信
            me.countDown();
            return me.send(phoneNum);
        }
    };
    this.send = function(phoneNum) {
        var me = this;
        var ret = {},param={};
        param.num=phoneNum;
        param.time=me.limitTime;
        param.type=me.type;
        try {
        	
           	//调后台广平代码发短信
           	Service.sync('sms','smsSend',param,function(reply){
               if((reply || '')!=='' && (reply.RESULT || '')!==''){
                 ret=reply.RESULT;
               }
           	});

            //发送成功
            //发送过于频繁
            if ((ret.id || '')!=='' && ret.id === '-5') {
                $(me.sendBtn).html("发送过于频繁，请稍后操作");
                me.sendFlag = 1;
               setTimeout(function() {
                    me.sendFlag = 0;
                    $(me.sendBtn).html("点击发送短信验证码");
                }, 3000);
            }else if((ret.ret_code || '')!=='' && ret.ret_code!=='1'){
                me.sendFlag = 0;
                $(me.sendBtn).html("点击发送短信验证码");
                me.sign=false;
            }
        } catch (e) {
            ret.ret_code = "-1";
        }
        return ret;
    };
    this.clearCountInterval = function() {
        var me = this;
        if (me.countTime == 0) {
            clearInterval(me.countInterval);
            me.sendFlag = 0;
            me.countTime = me.limitTime;
            $(me.sendBtn).html("点击发送短信验证码");
        }
    };
    /**
     * 发送短信验证码后倒计时计算
     * @param {} sendBtn 发送短信按钮
     */
    this.countDown = function() {
        var me = this;
        var h = "收不到请在<span style=\"color: #ff0000; font-size: 20px;\">" + me.limitTime + "</span>秒后再点击发送";
        $(me.sendBtn).html(h);
        me.countInterval = setInterval(function() {
            if(me.sign){
                me.countTime--;
                $(me.sendBtn).find("span").html(me.countTime);
            }
            //只要倒数时间为0了，都要清除定时器
            me.clearCountInterval();
        }, 1000);

    };
}