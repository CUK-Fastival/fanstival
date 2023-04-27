<html>
<head>
    <title>Insert Data</title>
</head>
<body>

<form action="./Registration" method="post">
    <p>ID:</p>
    <input type="text" name="user_id"/>
    <br/>
    <p>password:</p>
    <input type="password" name="user_password"/>
    <p>Name:</p>
    <input type="text" name = "user_name">
    <p>NickName:</p>
    <input type="text" name = "user_nick">
    <p>Idol:</p>
    <input type="text" name = "user_idol">
    <p>phone:</p>
    <input type="text" name = "user_phone">
    <p>email:</p>
    <input type="text" name = "user_email">
    <br/><br/><br/>
    <form method="post" action="${pageContext.request.contextPath}/Registration">
        <button type="submit" name="action" value="register">submit</button>
    </form>
</form>
</body>
</html>