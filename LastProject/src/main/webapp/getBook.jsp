<%@page contentType="text/html; charset=EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ��</title>
</head>
<body>
	<center>
		<h1>���� ��</h1>
		<a href="logout.do">Log-out</a>
		<hr>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">���� �ڵ�</td>
					<td align="left">${book.code }</td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">���� ����</td>
					<td align="left">${book.title }</td>
				</tr>
				<tr>
					<td bgcolor="orange">�۰�</td>
					<td align="left">${book.author }</td>
				</tr>
				<tr>
					<td bgcolor="orange">�뿩����</td>
					<td align="left">${book.exits }</td>
				</tr>
				<tr>
					<td bgcolor="orange">�뿩��</td>
					<td align="left">${book.userid }</td>
				</tr>
			</table>
		<hr>
		<a href="/biz/books/${book.code }/borrow">���� ����</a>
		<a href="/biz/books/${book.code }/return">���� �ݳ�</a>
		<a href="/biz/books">���� ���</a>
	</center>
</body>
</html>
