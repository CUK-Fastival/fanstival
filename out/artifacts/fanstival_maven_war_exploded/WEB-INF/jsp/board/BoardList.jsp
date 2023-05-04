<%@ page import="fanstival.domain.Board" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${pageTitle}</title> <!-- 제목 출력 -->
</head>
<body>
<h1>${pageTitle}</h1> <!-- 제목 출력 -->
<table>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
  </tr>
  <%
    List<Board> boardList = (List<Board>) request.getAttribute("boardList");
    for (Board board : boardList) {
  %>
  <tr>
    <td><%= board.getBoard_id() %></td>
    <td><%= board.getTitle() %></td>
    <td><%= board.getWriter() %></td>
    <td><%= board.getRegdate() %></td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
