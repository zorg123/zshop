<%--
网站底部，包含了相关链接和版权信息、地址信息、联系方式等。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String baseUri = request.getContextPath();
%>
<div id="foot" class="container-fluid">
    <div id="foot-nav">
        <div class="container text-center">
            <div class="row">
                <div class="col-xs-12">
                    <span><a href="http://www.yrihr.com.cn/" style="color: white">黄科院外网</a></span>
                    <span class="separator">|</span>
                    <span><a href="http://www.yrihr.com.cn/english/" style="color: white">黄科院英文网</a></span>
                    <span class="separator">|</span>
                    <span><a href="http://www.yellowriver.gov.cn/" style="color: white">黄河网</a></span>
                </div>
            </div>
        </div>
    </div>
    <div class="container text-center">
        <div class="row">
            <div class="col-xs-12 nopadding">Copyright © 2015 黄河水利科学研究院，All rights reserved。</div>
            <div class="col-xs-12 nopadding"><span>联系电话:0371-66024525</span>&nbsp;&nbsp;<span>E-mail:hkywg@yrihr.com.cn</span></div>
            <div class="col-xs-12">地址：郑州市顺河路45号 邮政编码：450003</div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=baseUri %>/public/infoShare/login.js"></script> 
</body>
</html>