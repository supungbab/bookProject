<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>점수 목록</title>
</head>
<body>
	<center>
		<h1>점수 목록 입니다.</h1>
		<h3>${userName }님!
			문제나라에 오신걸 환영합니다...<a href="logout.do">Log-out</a>
		</h3>
		<%String check = session.getAttribute("check").toString();%>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">구분</th>
				<th bgcolor="orange" width="100">응시일자</th>
				<th bgcolor="orange" width="200">정답 수 / 문제 수</th>
				<th bgcolor="orange" width="200">응시자</th>
			</tr>
			<%if(check.equals("[]")){%>
			<tr>
				<td>1</td>
				<td>응시 없음</td>
				<td>점수 없음</td>
				<td>응시자 없음</td>
			</tr>
			<%} 
			else{ %>
			<c:forEach items="${scorelist }" var="score">
				<tr>
					<td>${score.seq }</td>
					<td>${score.examdate }</td>
					<td>${score.score } / ${num}</td>
					<td>${score.id }</td>
				</tr>
			</c:forEach>
			<%} %>
		</table>
		<a href="getBoardList.do"><input type="button" value="홈으로" /></a>
	</center>
</body>
</html>