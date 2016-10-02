<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Order manager</h2>
 
<h3>Add client</h3>
<form action="addclient" method="post" id="addform">
    <input type="text" name="firstName" placeholder="Client first name" />
    <br />
    <input type="text" name="lastName" placeholder="Client last name" />
    <br />
    <input type="text" name="address" placeholder="Address" />
    <br />
    <input type="submit" value="Add Client" />
</form>
 
<h3>Add order</h3>
<form action="addorder" method="post">
    <input type="number" name="clientId" placeholder="Client ID" />
    <br />
    <input type="text" name="productName" placeholder="Product name" />
    <br />
    <input type="text" name="orderDetails" placeholder="Details" />
    <br />
    <input type="submit" value="Add Order" />
</form>
 
<h3>Get client</h3>
<form action="getclient" method="post" id="addform">
    <input type="number" name="clientId" placeholder="Client ID" />
    <input type="submit" value="Get Client" />
</form>
 
<h3>Get order</h3>
<form action="getorder" method="post" id="addform">
    <input type="number" name="orderId" placeholder="Order ID" />
    <input type="submit" value="Get Order" />
</form>
</body>
</html>