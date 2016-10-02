<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tajna baza </title>
</head>
<body>
    <h1>Zaloguj się</h1>
    <form action="InputServlet" method="post">
        <input type="text" placeHolder="Username" name="username">
        <br>
        <input type="password" placeHolder="Password" name="password">
        <br>
        <input type="submit" value="Zaloguj">
    </form>
</body>
</html>