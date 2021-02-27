<%@page contentType="text/html; charset=EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서 상세</title>
</head>
<body>
	<center>
		<h1>도서 상세</h1>
		<a href="logout.do">Log-out</a>
		<hr>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">도서 코드</td>
					<td align="left">${book.code }</td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">도서 제목</td>
					<td align="left">${book.title }</td>
				</tr>
				<tr>
					<td bgcolor="orange">작가</td>
					<td align="left">${book.author }</td>
				</tr>
				<tr>
					<td bgcolor="orange">대여여부</td>
					<td align="left">${book.exits }</td>
				</tr>
				<tr>
					<td bgcolor="orange">대여자</td>
					<td align="left">${book.userid }</td>
				</tr>
			</table>
		<hr>
		<a href="/biz/books/${book.code }/borrow">도서 대출</a>
		<a href="/biz/books/${book.code }/return">도서 반납</a>
		<a href="/biz/books">도서 목록</a>
	</center>
</body>
</html>
