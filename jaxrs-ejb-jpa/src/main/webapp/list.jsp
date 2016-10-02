<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Saved Users</title>
    </head>
    <body>
    <h2>Saved Users:</h2>
    <ul>
        <c:forEach items="${users}" var="user">
            <li><c:out value="${user}" /></li>
        </c:forEach>
    </ul>
    </body>
</html>