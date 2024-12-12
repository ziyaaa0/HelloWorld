<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<!-- board.jsp 원래 있던 부분. -->
<h3>글상세화면(board.jsp)</h3>


<form action="modifyForm.do">
	<input type="hidden" name="board_no" value="${board.boardNo}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
	
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo}</td>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>	
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="5" readonly class="form-control">${board.content}</textarea></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${board.creationDate}</td>
			<th>조회수</th>
			<td>${board.viewCnt}</td>
		</tr>	
	 	
	 	
	 	
	 	<!-- 로그인상태  => 권한에 따라 활성화/비활성화.
	 	 로그인 상태 아니면 => 권한 없음. --> 	
	 	<tr>	 	
		 	<td colspan="4" align="center">
		 	<c:choose>
			 	<c:when test="${logId ne null && board.writer == logId}">
			 		<input type="submit" class="btn btn-warning" value="수정화면" >
			 	</c:when>
			 	<c:otherwise>		 	
			 		<input type="submit" class="btn btn-warning" value="수정화면" disabled>
			 	</c:otherwise>
	 		</c:choose>
	 		</td>
	 	</tr>
	</table>
</form>
<!-- board.jsp 원래 있던 부분. -->

<jsp:include page="../includes/footer.jsp"></jsp:include>
