<html>
 <head>
<meta charset="UTF-8">
</head> 
<body>
<h2>User Manager</h2>
    <h3>Save user</h3>
    <form action="create" method="post">
        <input type = "text" name="username" placeholder="Username" /><br />
        <input type = "text" name="email" placeholder="Email" /><br />
        <input type = "password" name="password" placeholder="Password" /><br />
        <input type = "text" name="firstname" placeholder="First name (optional)" /><br />
        <input type = "text" name="lastname" placeholder="Last name (optional)" /><br />
        <input type = "text" name="address" placeholder="Address (optional)" /><br />
        <input type="submit" value="Save" />
    </form>
     
    <h3>Get user</h3>
    <form action="read" method="post">
        <input type = "text" name="id" placeholder="User Id" /><br />
        <input type="submit" value="Get" />
    </form>
</body>
</html>