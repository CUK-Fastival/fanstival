<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성</title>
</head>
<body>
<h1>글 작성</h1>
<form method="post" action="${pageContext.request.contextPath}/board/write">
    <table>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" name="writer"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="content" rows="10" cols="50"></textarea></td>
        </tr>
    </table>
    <button type="submit" name="action" value="write">글 작성</button>
</form>
</body>
</html>
