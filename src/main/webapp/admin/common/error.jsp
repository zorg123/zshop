<%@ page language="java" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.util.*" %>
<%@ page import="com.opensymphony.xwork2.util.*" %>
<%--<%
Map ctx =((ValueStack)request.getAttribute("struts.valueStack")).getContext();
Set keys = ctx.keySet();
for (Object key:keys) {
    out.println("key=" + key + ",");
    if (ctx.get(key) != null) {
      out.println("value=" + ctx.get(key));
    }
    out.println("<br/>");
}
%>--%>
<s:set var="errorCode" value="result._code" />
<%--如果是未登录，则提示完信息后，直接跳到登录界面 --%>

<b><s:property value="result._msg"/></b>
<script language="javascript" type="text/javascript">
alert("<s:property value="result._msg" escapeHtml="false" />");
<s:if test="#errorCode == 'SYS_ERR002'">	
	parent.document.location.href="/admin/login/";
</s:if>
</script>