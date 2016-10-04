<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All cookies</title>
</head>
<body>
	<%
		for(Cookie c: request.getCookies()) {
	%>
		<%= c.getName() + " > " + c.getValue() %>
		<br>
	<%
		}
	%>			
	<a href="CookieServlet?cookie=print">Refresh page</a>
	<br>
	<a href="index.jsp">Homepage</a>	
</body>
</html>