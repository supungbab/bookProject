<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���</title>
</head>
<body>
	<center>
		<h1>���� ��� �Դϴ�.</h1>
		<h3>${userName }��!
			�������� ���Ű� ȯ���մϴ�...<a href="logout.do">Log-out</a>
		</h3>
		<%String check = session.getAttribute("check").toString();%>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">����</th>
				<th bgcolor="orange" width="100">��������</th>
				<th bgcolor="orange" width="200">���� �� / ���� ��</th>
				<th bgcolor="orange" width="200">������</th>
			</tr>
			<%if(check.equals("[]")){%>
			<tr>
				<td>1</td>
				<td>���� ����</td>
				<td>���� ����</td>
				<td>������ ����</td>
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
		<a href="getBoardList.do"><input type="button" value="Ȩ����" /></a>
	</center>
</body>
</html>