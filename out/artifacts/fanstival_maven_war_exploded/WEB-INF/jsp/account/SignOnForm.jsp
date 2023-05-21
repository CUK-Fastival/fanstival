<html>
<head>
    <title>Sign In</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>ID:</p>
    <input type="text" name="user_id"/>
    <br/>
    <p>Password:</p>
    <input type="password" name="user_password"/>
    <br/><br/><br/>
    <input type="submit" name="action" value="signIn"/>
</form>
</body>
</html>
