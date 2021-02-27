<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
	<table border="1">
			<tr>
				<th bgcolor="orange" width="100">책코드</th>
				<th bgcolor="orange" width="200">책 제목</th>
				<th bgcolor="orange" width="150">작가</th>
				<th bgcolor="orange" width="150">대여여부</th>
				<th bgcolor="orange" width="150">대여자</th>
			</tr>

			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.code}</td>
					<td><a href="books/${book.code}">${book.title}</a></td>
					<td>${book.author}</td>
					<td>${book.exits}</td>
					<td>${book.userid}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="getBoardList.do"><input type="button" value="홈으로" /></a>
</body>
</html>