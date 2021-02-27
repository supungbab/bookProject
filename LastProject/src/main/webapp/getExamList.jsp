<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제풀기</title>
</head>
<body>
		<h1>문제풀기</h1>
		<h3>${userName }님!
			문제나라에 오신걸 환영합니다...<a href="logout.do">Log-out</a>
		</h3>
		<form action="ExamCheck.do" method="post">
			<input name="code" type="hidden" value="${code }">
			<c:forEach items="${examList }" var="exam">
			<table border="1">
				<tr>
					<td colspan="2">${exam.num }. ${exam.question }</td>
				</tr>
				<tr>
					<td><input type="radio" name="Q${exam.num}" value="1" checked /></td><td>1. ${exam.example1 }</td>
				</tr>
				<tr>
					<td><input type="radio" name="Q${exam.num}" value="2" /></td><td>2. ${exam.example2 }</td>
				</tr>
				<tr>
					<td><input type="radio" name="Q${exam.num}" value="3" /></td><td>3. ${exam.example3 }</td>
				</tr>
				<tr>
					<td><input type="radio" name="Q${exam.num}" value="4" /></td><td>4. ${exam.example4 }</td>
				</tr>
			</table>
			
			</c:forEach>
			
			<a href="getBoardList.do"><input type="button" value="홈으로" /></a> <input type="submit" value="답안 전송" />
		</form>
</body>
</html>