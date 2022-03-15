<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 추가</title>
<style type="text/css">

#thumbnailContainer{
	width:180px;
	height:270px;
}
#table{
	text-align: center;
	border-collapse: collapse;
}
#table td{
	border:solid 1px;
}
#table td input{
	width:80%;
	border:1px solid gray;
}
.attr{
	width:100px;
}
#table td textarea{
	overflow-y:scroll;
	border:none;
	resize:none;
}
#top{
	text-align: right;
}
.errors{
	color: hotpink;
	font-style: italic;
}
</style>
<script>
function PreviewImage() {
 
    var preview = new FileReader();
    preview.onload = function (e) {
    	document.getElementById("user_image").src = e.target.result;
	};
	preview.readAsDataURL(document.getElementById("imgFilename").files[0]);
};
</script>
</head>
<body>
	<h3>도서 추가</h3>
	<form:form commandName="bookDto" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th colspan="3" align="right"><font color="red">* 표시는 필수입니다.</font></th>
			</tr>
			<tr>
				<th rowspan="7" width="33%"><img id="user_image" src="#" alt="" ></th>
			</tr>
			<tr>
				<th><font color="red">*</font>ISBN</th>
				<td><form:input path="isbn" />
				<form:errors path="isbn"/></td>
			</tr>
			<tr>
				<th><font color="red">*</font>도서명</th>
				<td><form:input path="bookname"/>
				<form:errors path="bookname"/></td>
			</tr>
			<tr>
				<th><font color="red">*</font>저자</th>
				<td><form:input path="writer"/>
				<form:errors path="writer"/></td>
			</tr>
			<tr>
				<th><font color="red">*</font>출판사</th>
				<td><form:input path="publish"/>
				<form:errors path="publish"/></td>
			</tr>
			<tr>
				<th><font color="red">*</font>도서 가격</th>
				<td><form:input path="price"/>
				<form:errors path="price"/></td>
			</tr>
			<tr>
				<th><font color="red">*</font>이미지</th>
				<td><input type="file" name="imgFilename" id="imgFilename" onchange="PreviewImage();" accept="image/*"/>
				
				<form:errors path="imgFilename"/></td>
			</tr>
			<tr>
				<th><font color="red">*</font>책 소개</th>
				<td colspan="2"><form:textarea rows="10" cols="50" path="intro"/>
				<form:errors path="intro"/></td>
			</tr>	
		</table>
		<input type="submit" value="도서 등록">
		<input type="button" value="메인으로" onclick="window:location='<c:url value='/main'/>'">
	</form:form>
</body>
</html>