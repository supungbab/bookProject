<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>
<body>
	<center>
		<h1>���� ��� �Դϴ�.</h1>
		<h3>${userName }��! �������Դϴ�.
			�������� ���Ű� ȯ���մϴ�...<a href="logout.do">Log-out</a>
		</h3>
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">����</th>
				<th bgcolor="orange" width="200">�������</th>
				<th bgcolor="orange" width="150">����Ǯ��</th>
				<th bgcolor="orange" width="150">����Ȯ���ϱ�</th>
				<th bgcolor="orange" width="150">���������ϱ�</th>
			</tr>

			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<td>${board.title }</td>
					<td><a href="Exam.do?code=${board.code }">�����ϱ�</a></td>
					<td><a href="score.do?code=${board.code }">Ȯ���ϱ�</a></td>
					<td><a href="ExamManagement.do?code=${board.code }">�����ϱ�</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</center>
</body>
</html>