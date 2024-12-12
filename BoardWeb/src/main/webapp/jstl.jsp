<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
</head>
<body>
	<!-- 1. JSTL 라이브러리 -->
	<!-- 2. JSTL 태그 지시자 선언 -->
	<%
	String myName = "홍길동";
	%>
	<c:set var="myName" value="Hong"></c:set>
	<c:out value="${myName}"></c:out> <!-- 교재 12장 참고 -->
	
	<!-- myAge 변수에 20 값을 저장. -->	
	<c:set var="myAge" value="20"></c:set>
	
	
	<!-- h3 태그로 출력. -->	
	<h3><c:out value="${myAge}"></c:out></h3>
	
	<!-- 조건문. -->
	<c:if test="${myAge >= 20}">
		<p>성인입니다.</p>	
	</c:if>
	<c:choose>
		<c:when test="${myAge >= 20}"><p>성인</p></c:when>
		<c:otherwise><p>청소년</p></c:otherwise>
	</c:choose>
	
	<!-- score = 85 저장. -->
	<c:set var="score" value="85"></c:set>
	
	<!-- score가 90 이상이면 A 80이상 B 70이상 C 그외 D -->
	<c:if test="${score >= 90}">
		<p>A</p>	
	</c:if>
	<c:choose>
		<c:when test="${score >= 80}"><p>B</p></c:when>
		<c:when test="${score >= 70}"><p>C</p></c:when>
		<c:otherwise><p>D</p></c:otherwise>
	</c:choose>
	
	<!-- 반복문 for(int i=1;i<10; i++){} -->
	
	<c:forEach var='i' begin="1" end="10" step="1">
		<c:if test="${i%2 ==0}">
			<p><c:out value="8* ${i} = ${8*i}" /></p>		
		</c:if>
	</c:forEach>
	
</body>
</html>