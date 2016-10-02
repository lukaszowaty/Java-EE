<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library Viewer</title>
</head>
<body>    
<h1>Biblioteka viewer</h1>
    <form action="BookServlet" method="post">
        <input placeHolder="ISBN" type="text" name="isbn">
        <br>
        <input placeHolder="Tytuł" type="text" name="title">
        <br>
        <input placeHolder="Opis" type="text" name="description">
        <br>
        Szukaj: <input type="radio" name="option" value="search"> Dodaj: <input type="radio" name="option" value="add">
        Modyfikuj: <input type="radio" name="option" value="update"> Usuń: <input type="radio" name="option" value="delete">
        <br>
        <input type="submit" value="Wyślij">
    </form>
</body>
</html>