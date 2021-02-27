<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>회원가입</title>
	</head>
	<body>
		<h1>회원가입</h1>
		<form action="join.do" method="post">
			<table>
				<tr>
					<td bgcolor="orange">아이디</td>
					<td><input type="text" name="id" value="" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">비밀번호</td>
					<td><input type="password" name="password" value="" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">이름</td>
					<td><input type="text" name="name" value="" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit"
						value="회원가입" /></td>
				</tr>
			</table>
		</form>
		<a href="login.jsp"><input type="button" value="홈으로" /></a>
	</body>
</html>