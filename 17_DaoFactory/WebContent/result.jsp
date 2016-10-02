<%@ page import="pl.javastart.model.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Book book = (Book) request.getAttribute("book"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Wynik zapytania <%= request.getAttribute("option") %></h1>
    <p>W wyniku Twojego zapytania otrzymano następujacy wynik:</p>
    <p>Tytuł: <%= book.getTitle() %><br>
    ISBN: <%= book.getIsbn() %><br>
    Opis: <%= book.getDescription() %></p>
</body>
</html>