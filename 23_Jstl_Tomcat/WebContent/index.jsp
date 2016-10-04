<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${param.name }" /></title>
</head>
<body>
    <!-- Warunek -->
    <c:if test="${not empty param.name }">
        <!-- Ustawiamy atrybut na podstawie parametru -->
        <c:set var="name" value="${param.name }" scope="page" />
         
        <!-- Wyświetlamy  atrybut -->
        <h1>Witaj <c:out value="${pageScope.name }" /></h1>
         
        <!-- Usuwamy atrybut -->
        <c:remove var="name"/>
    </c:if>
     
    <h2>To co o Tobie wiemy:</h2>
    <h3>Ciasteczka:</h3>
    <c:forEach var="cookieItem" items="${cookie }">
        <c:out value="${cookieItem.key }" /> : <c:out value="${cookieItem.value }"></c:out>
        <br>
    </c:forEach>
     
    <h3>Informacje z nagłówka:</h3>
    <c:forEach var="headerItem" items="${header }">
        <c:out value="${headerItem.key }" /> : <c:out value="${headerItem.value }" />
        <br>
    </c:forEach>
     
    <c:if test="${not empty param.name}" >
        <c:choose>
            <c:when test="${param.name eq 'Jan' }">
                Tajna informacja do Jana
            </c:when>
            <c:when test="${param.name eq 'Bartosz' }">
                Tajna informacja do Bartosza
            </c:when>
            <c:otherwise>
                Brak tajnej informacji
            </c:otherwise>
        </c:choose>
    </c:if>b
</body>
</html>