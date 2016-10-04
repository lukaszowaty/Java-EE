<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Funkcje JSTL</title>
</head>
<body>
    <c:if test="${not empty param.name }">
        <c:out value="${fn:toUpperCase(param.name) }" />
    </c:if>
    <h3>W nagłówku jest <c:out value="${fn:length(header) }"/> elementów:</h3>
    <c:forEach var="headerItem" items="${header }">
        <c:out value="${fn:toUpperCase(headerItem.key) }" /> : <c:out value="${fn:toLowerCase(headerItem.value) }" />
        <br>
    </c:forEach>
     
    <br>
    <c:set var="strings" value="${fn:split('Ala ma kota zmieniana na tablicę', ' ') }"/>
    <c:set var="joined" value="${fn:join(strings, '--') }"/>
    <c:out value="${joined }" />
    <br>
    <c:if test="${fn:startsWith(joined, 'Ala') }">
        Hura!
    </c:if>
    <c:out value="${fn:replace(joined, 'Ala', 'Karol') }" />
</body>
</html>