<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>문제 목록 입니다.</h1>
		<h3>${userName }님! 관리자입니다.
			문제나라에 오신걸 환영합니다...<a href="logout.do">Log-out</a>
		</h3>
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">구분</th>
				<th bgcolor="orange" width="200">문제목록</th>
				<th bgcolor="orange" width="150">문제풀기</th>
				<th bgcolor="orange" width="150">점수확인하기</th>
				<th bgcolor="orange" width="150">문제관리하기</th>
			</tr>

			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<td>${board.title }</td>
					<td><a href="Exam.do?code=${board.code }">응시하기</a></td>
					<td><a href="score.do?code=${board.code }">확인하기</a></td>
					<td><a href="ExamManagement.do?code=${board.code }">관리하기</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</center>
</body>
</html>