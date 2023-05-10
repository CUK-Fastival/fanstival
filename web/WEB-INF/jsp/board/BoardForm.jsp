<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Board</title>
</head>
<body>
<h1>Create Board</h1>
<form method="post" action="/board/write">
    <label for="title">Title</label>
    <input type="text" id="title" name="title" required><br>
    <label for="content">Content</label>
    <textarea id="content" name="content" rows="10" cols="30" required></textarea><br>
    <button type="submit">Create</button>
</form>
<a href="${pageContext.request.contextPath}/board/list">Cancel</a>
</body>
</html>
