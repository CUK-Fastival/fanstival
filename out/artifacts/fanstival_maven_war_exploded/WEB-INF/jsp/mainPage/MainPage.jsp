<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
</head>
<body>
<h1>Main Page</h1>
<p>Welcome, <%= request.getAttribute("nickname") %> (ID: <%= request.getAttribute("userId") %>)</p>
<a href="${pageContext.request.contextPath}./board/write">Write Board</a>
<a href="${pageContext.request.contextPath}/board/list">Board List</a>


</body>
</html>
