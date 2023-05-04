<%--
  Created by IntelliJ IDEA.
  User: 82104
  Date: 2023-03-29
  Time: 오후 5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$FAN'STiVAL$</title>
  </head>
  <body>
  $Fan'stival Page$
  <div id="menu">
    <form method="post" action="${pageContext.request.contextPath}/Login">
      <button type="submit" name="action" value="signIn">로그인</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/Registration">
      <button type="submit" name="action" value="newAccount">새로운 계정 생성</button>
    </form>
  </div>

  </body>
</html>
