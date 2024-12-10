<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>  

<!-- board.jsp 원래 있던 부분. -->
<h3>글상세화면(board.jsp)</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("board");
%>
<table class="table">
  <tr>
    <th>글번호</th><td><%=bvo.getBoardNo() %></td>
  </tr>
    <tr>
    <th>작성자</th><td><%=bvo.getWriter() %></td>
  </tr>
  <tr>
    <th>내용</th><td><%=bvo.getContent() %></td>
  </tr>
</table>
<!-- board.jsp 원래 있던 부분. -->

<jsp:include page="../includes/footer.jsp"></jsp:include>  
