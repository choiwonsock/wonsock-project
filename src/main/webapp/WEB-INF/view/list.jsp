<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<style type="text/css">
body{
	text-align: center; 	
}
table{
	border-collapse: collapse;
	width:1000px;
}
table th, td{
	border: 1px solid black;
	padding-left: 10px;
	padding-right: 10px;
}
#searchForm{
	margin-bottom: 10px;
}
.num{
	width:70px;
	text-align: center;
}
.imgContainer{
	width:70px
}
.errors{
	color: hotpink;
	font-style: italic;
}
a:link {
	color:hotpink;
	text-decoration: none;
	text-shadow: 0 0 24px;
} 
a:visited { 
	color:pink;
	text-decoration: none; 
	text-shadow: 0 0 24px; 
}
</style>
</head>
<body>
<h2>도서 목록</h2>
	<c:if test="${!empty booksList }">
	<form:form action="search" method="GET" >
		검색 키워드 입력 : 
		<input type="text" name="value"/>
		<input type="submit" value="찾기"/>
	</form:form>
	<table border="1">
		<tr>
			<th>등록 번호</th><th>도서 표지</th><th>도서 ISNB</th>
			<th>도서 제목</th><th>저자</th><th>출판사</th><th>가격</th>
		</tr>
		<c:forEach var="book" items="${booksList }">
			<tr>
				<td>${book.num }</td>
				<td><img src="<spring:url value='/resources/upload/${book.saveFilename }'/>" width="220" ></td>
				<td>${book.isbn }</td>
				<td><a href="<c:url value='/detail/${book.num }'/>">${book.bookname }</a></td>
				<td>${book.writer }</td>
				<td>${book.publish }</td>
				<td>${book.price }원</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<c:if test="${empty booksList }">
		도서 정보가 없습니다.<br>
	</c:if>
	
	<input type="button" value="도서 정보 추가" onclick="window:location='<c:url value='/add'/>'">
	<input type="button" value="메인으로" onclick="window:location='<c:url value='/main'/>'">
</body>
</html>