<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1>Product explorer</h1>
 
<h2>Add product</h2>
<form action="products?add=true" method="post">
    <input type="text" name="productName" placeholder="Product name" />
    <input type="number" name="productPrice" step="0.1" placeholder="Product price" />
    <input type="text" name="productCategory" placeholder="Product category" />
    <input type="submit" value="Add" />
</form>
 
<form action="products?add=false" method="post">
    <input type="text" name="query" placeholder="JPQL Query" style="width: 500px" />
    <input type="submit" value="Get" />
</form>
<a href="static">Get products ordered by price</a>
<h2>Get Products by category</h2>
<form action="category">
	<input type="text" name="category" placeholder="Product category" />
	<input type="submit" value="Get" />
</form>
</body>
</html>