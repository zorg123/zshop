<%--
网站头部，包含logo和导航栏.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--网站头部--%>
<div id="head" class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 nopadding">
                <div class="col-xs-12 col-sm-6">
                    <a href="/"><img id="logo" class="img-responsive" src="${pageContext.request.contextPath}/public/infoShare/images/logo.png"></a>
                </div>
                <div class="col-xs-12 col-sm-6">
                    <%--<a class="pull-right login-link" href="#" onclick="openLoginWin()" style="display:none;">登陆系统</a>--%>
                    <div id="login-link" style="text-align:right; padding-top:5px;float: right">
                        <%--<input id="loginName" name="loginName" placeholder="登录账号" class="login-input">--%>
                        <%--<input type="password" id="loginPassword" name="loginPassword" placeholder="登录密码" class="login-input">--%>
                        <%--<button onclick="login()">登录</button>--%>
                        <a href="/manager/login" style="text-decoration: none;font-weight: bold;color: #1a75ce;"> 登录系统 </a>
                        &nbsp;&nbsp;<a href="/wx/RetrievePassword" style="text-decoration: none;">重置密码</a>&nbsp;&nbsp;<a href="http://10.4.56.5/" style="text-decoration: none;font-weight: bold;color: #1a75ce;"> 进入旧版OA系统 </a>
                    </div>
                    <div id="login-user-info" style="text-align:right; padding-top:5px; display:none; width:100%;">
                        <a class="login-link">您好：<span id="login-user-name-top"></span>（<span id="login-user-dep-top"></span>）</a>
                        <a class="pull-right login-link hidden-xs" href="http://10.4.56.5:8080/" style="padding:0px;padding-left: 5%;font-weight: bold;color: #1a75ce;"> 进入旧版OA系统</a>
                        <a class="pull-right login-link" href="/cas/logout" style="padding:0px;">安全退出</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--导航栏--%>
<nav class="navbar navbar-custom" role="navigation" style="margin-bottom:0px;">
    <div class="container">
        <div class="collapse navbar-collapse">
            <!--嵌套下拉菜单-->
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">首页</a></li>
                <li><a href="/web/005">办公室</a></li>
                <li><a href="/web/003">科研管理处</a></li>
                <li><a href="/web/002">科技推广处</a></li>
                <li><a href="/web/008">人事劳动处</a></li>
                <li><a href="/web/006">计划财务处</a></li>
                <li><a href="/web/007">党群工作处</a></li>
                <li><a href="/web/009">监察审计处</a></li>
                <li class="dropdown onpen">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        院属单位<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu top-menu">
                        <li><a href="/web/40289f43529299430152929c1bd80000">小浪底中心</a></li>
                        <li><a href="/web/004">泥沙所</a></li>
                        <li><a href="/web/5a9c10a6529b43e401529bc38b17000a">水保所</a></li>
                        <li><a href="/web/5a9c10a6529b43e401529bc3b538000c">工力学所</a></li>
                        <li><a href="/web/5a9c10a6529b43e401529bc3d7ac000e">水资源所</a></li>
                        <li><a href="/web/5a9c10a6529b43e401529bc426b60012">防汛所</a></li>
                        <li><a href="/web/001">信息工程中心</a></li>
                        <li><a href="/web/5a9c10a6529b43e401529bc44c750014">引黄灌溉中心</a></li>
                        <li><a href="#">水力学所</a></li>
                        <li><a href="/web/5a9c10a6529b43e401529bc4a9f50018">后勤服务中心</a></li>
                    </ul>
                </li>
            </ul>
           <div class="pull-right" data-container="body" data-toggle="popover" data-placement="auto left" data-content="功能菜单在这里!">
                <div class="start-menu glyphicon glyphicon-th-large" style="display: none;">
                    <div class="job-remind img-circle"></div>
                </div>
            </div>
        </div>
        <div class="visible-xs-block">
            <div class="pull-right" data-toggle="popover" data-placement="auto left" data-content="功能菜单在这里!">
                <span class="start-menu glyphicon glyphicon-th-large" ></span>
            </div>
        </div>
    </div>
</nav>


<div class="container">
    <div id="menu-container" class="container box-shadow-1">
        <div id="menu-bar" class="row">
            <div class="menu-panel col-md-9">

                
                <div class="menu-group">
                    <div class="group-title">信息共享</div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/hetong">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/19.png">
                        </div>
                        <div class="menu-text-c text-center">科研项目/合同</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/baogao">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/15.png">
                        </div>
                        <div class="menu-text-c text-center">科研报告</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/lunwen">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/12.png">
                        </div>
                        <div class="menu-text-c text-center">科研论文</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/zhuanzhu">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/24.png">
                        </div>
                        <div class="menu-text-c text-center">出版专著</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/zhuanli">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/36.png">
                        </div>
                        <div class="menu-text-c text-center">专利</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/zhuzuoquan">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/32.png">
                        </div>
                        <div class="menu-text-c text-center">著作权</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/jiangli">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/38.png">
                        </div>
                        <div class="menu-text-c text-center">工程技术奖项</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/apparatus">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/33.png">
                        </div>
                        <div class="menu-text-c text-center">设备仪器</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/rongyuchenghao">
                            <div class="menu-img-div">
                                <div class="disable-div-disabled"></div>
                                <img class="img-responsive menu-img" src="/image/menu-ico/40.png">
                            </div>
                            <div class="menu-text-c text-center">荣誉称号</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/07.png">
                        </div>
                        <div class="menu-text-c text-center">经费计划</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/08.png">
                        </div>
                        <div class="menu-text-c text-center">经费支出</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/11.png">
                        </div>
                        <div class="menu-text-c text-center">经费结算</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/26.png">
                        </div>
                        <div class="menu-text-c text-center">资产购置</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/01.png">
                        </div>
                        <div class="menu-text-c text-center">报告审查</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/19.png">
                        </div>
                        <div class="menu-text-c text-center">科研项目变更</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/04.png">
                        </div>
                        <div class="menu-text-c text-center">出差审批</div>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/work-plan">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/39.png">
                        </div>
                        <div class="menu-text-c text-center">周工作安排</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/33.png">
                        </div>
                        <div class="menu-text-c text-center">办公物资领用</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/46.png">
                        </div>
                        <div class="menu-text-c text-center">培训登记</div>
                    </div>

                    <div class="menu-item">
                        <a class="noling" href="/user/tax">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/11.png">
                        </div>
                        <div class="menu-text-c text-center">个税查询</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/10.png">
                        </div>
                        <div class="menu-text-c text-center">工资查询</div>
                    </div>
                    <div class="menu-item">
                        <a class="noling" href="/manager/xxgx/person">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/21.png">
                        </div>
                        <div class="menu-text-c text-center">人员信息</div>
                        </a>
                    </div>
                </div>

                <div class="menu-group-border"></div>

                <div class="menu-group">
                    <div class="group-title">工作审批</div>
                    <div class="menu-item">
                        <a class="noline" href="/workflow/incoming">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <div class="process-job-remind img-circle" pdk="swglProcess"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/15.png">
                        </div>
                        <div class="menu-text-c text-center">收文管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/workflow/dispatch">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <div class="process-job-remind img-circle" pdk="fwglProcess"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/01.png">
                        </div>
                        <div class="menu-text-c text-center">发文管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/workflow/egress">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <div class="process-job-remind img-circle" pdk="wcsqProcess"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/04.png">
                        </div>
                        <div class="menu-text-c text-center">领导外出登记</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/workflow/vacation/task">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <div class="process-job-remind img-circle" pdk="xjsqProcess"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/20.png">
                        </div>
                        <div class="menu-text-c text-center">休假审批</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/workflow/xxsh/task">
                            <div class="menu-img-div">
                                <div class="disable-div-disabled"></div>
                                <div class="process-job-remind img-circle" pdk="xxsh"></div>
                                <img class="img-responsive menu-img" src="/image/menu-ico/12.png">
                            </div>
                            <div class="menu-text-c text-center">新闻稿件审核</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/12.png">
                        </div>
                        <div class="menu-text-c text-center">合同签订</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/07.png">
                        </div>
                        <div class="menu-text-c text-center">经费计划</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/08.png">
                        </div>
                        <div class="menu-text-c text-center">预算支付</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/09.png">
                        </div>
                        <div class="menu-text-c text-center">经费结算</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/03.png">
                        </div>
                        <div class="menu-text-c text-center">会议申请</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/24.png">
                        </div>
                        <div class="menu-text-c text-center">论文备案</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/30.png">
                        </div>
                        <div class="menu-text-c text-center">专著备案</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/31.png">
                        </div>
                        <div class="menu-text-c text-center">固定资产</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/24.png">
                        </div>
                        <div class="menu-text-c text-center">报告审查</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/29.png">
                        </div>
                        <div class="menu-text-c text-center">项目变更</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/04.png">
                        </div>
                        <div class="menu-text-c text-center">出差审批</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/26.png">
                        </div>
                        <div class="menu-text text-center">物资领用</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/34.png">
                        </div>
                        <div class="menu-text-c text-center">请假审批</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/39.png">
                        </div>
                        <div class="menu-text-c text-center">考勤管理</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/46.png">
                        </div>
                        <div class="menu-text-c text-center">培训登记</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/13.png">
                        </div>
                        <div class="menu-text-c text-center">任务交办</div>
                    </div>
                    <div class="menu-item">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/02.png">
                        </div>
                        <div class="menu-text-c text-center">绩效考核</div>
                    </div>
                </div>

                <div class="menu-group-border"></div>

                <div class="menu-group">
                    <div class="group-title">系统管理</div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/department">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/44.png">
                        </div>
                        <div class="menu-text-c text-center">机构管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/user">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/28.png">
                        </div>
                        <div class="menu-text-c text-center">人员管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/role">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/16.png">
                        </div>
                        <div class="menu-text-c text-center">角色管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/column">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/12.png">
                        </div>
                        <div class="menu-text-c text-center">栏目管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/workflow/processdefinition">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/42.png">
                        </div>
                        <div class="menu-text-c text-center">流程管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noling" href="/manager/tax">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/09.png">
                        </div>
                        <div class="menu-text-c text-center">个税管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/log/operation">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/16.png">
                        </div>
                        <div class="menu-text-c text-center">操作日志</div>
                        </a>
                    </div>
                </div>

                <div class="menu-group-border"></div>

                <div class="menu-group">
                    <div class="group-title">信息管理</div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/information">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/01.png">
                        </div>
                        <div class="menu-text-c text-center">信息发布</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/week-work/apply-list">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/39.png">
                        </div>
                        <div class="menu-text-c text-center">周工作报会</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/week-work/manager-list">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/29.png">
                        </div>
                        <div class="menu-text-c text-center">周工作发布</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/week-work/gonggao/list">
                        <div class="menu-img-div">
                            <div class="disable-div-disabled"></div>
                            <img class="img-responsive menu-img" src="/image/menu-ico/15.png">
                        </div>
                        <div class="menu-text-c text-center">周工作管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noline" href="/manager/xxgx/rongyuchenghao/add-list">
                            <div class="menu-img-div">
                                <div class="disable-div-disabled"></div>
                                <img class="img-responsive menu-img" src="/image/menu-ico/40.png">
                            </div>
                            <div class="menu-text-c text-center">荣誉称号管理</div>
                        </a>
                    </div>
                    <div class="menu-item">
                        <a class="noling" href="/manager/xxgx/person/add-list">
                            <div class="menu-img-div">
                                <div class="disable-div-disabled"></div>
                                <img class="img-responsive menu-img" src="/image/menu-ico/21.png">
                            </div>
                            <div class="menu-text-c text-center">人员信息管理</div>
                        </a>
                    </div>
                </div>
                <div class="text-right pull-right">
                    <button id="show-all-function-btn" class="btn btn-xs btn-link">全部功能</button>
                    <button id="hide-not-available-function-btn" class="btn btn-xs btn-link" style="display: none;">隐藏未授权功能</button>
                </div>
                
                <div class="function-panel-border hidden-xs"></div>
            </div>
            <div class="function-panel col-md-3">
                <div class="user-info">
                    <div>您好：<span id="login-user-name"></span>（<span id="login-user-dep"></span>）</div>
                    <div class="text-right">
                        <a class="btn btn-sm btn-link" href="/user/password">修改密码</a>
                        <a class="btn btn-sm btn-link">修改信息</a>
                        <a class="btn btn-sm btn-link" href="http://10.4.56.8/cas/logout">安全退出</a>
                    </div>
                </div>
                <div class="user-message function-group">
                    <div class="function-group-title"><span class="glyphicon glyphicon-envelope"></span>&nbsp;站内消息<span class="pull-right more"><a href="/manager/inform/self" class="noline">更多>></a></span></div>
                    
                </div>
                <div class="user-task function-group">
                    <div class="function-group-title"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;待办工作<span class="pull-right more">更多>></span></div>
                    
                </div>
            </div>
        </div>
    </div>
</div>

