<%@ page contentType="text/xml; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="validCode" value="${param.validCode}"/>
<%
	String valid_code = (String)session.getAttribute("valid_code"); 
	System.out.println("valid_code=-->"+valid_code+"|validCode--->"+pageContext.getAttribute("validCode"));
%>
<c:set var="valid_code" value="<%=valid_code%>"/>
<c:if test="${valid_code == validCode}" >
	<c:set var="flag" value="1" />
</c:if>
<c:if test="${valid_code != validCode}" >
	<c:set var="flag" value="0" />
</c:if>
<root>
	<flag><c:out value="${flag}"/></flag>
</root>