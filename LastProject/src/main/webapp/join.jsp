<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>ȸ������</title>
	</head>
	<body>
		<h1>ȸ������</h1>
		<form action="join.do" method="post">
			<table>
				<tr>
					<td bgcolor="orange">���̵�</td>
					<td><input type="text" name="id" value="" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">��й�ȣ</td>
					<td><input type="password" name="password" value="" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">�̸�</td>
					<td><input type="text" name="name" value="" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit"
						value="ȸ������" /></td>
				</tr>
			</table>
		</form>
		<a href="login.jsp"><input type="button" value="Ȩ����" /></a>
	</body>
</html>