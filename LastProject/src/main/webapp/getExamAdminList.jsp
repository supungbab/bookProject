<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>��������</title>
</head>
<body>
		<h1>��������������</h1>
		<h3>${userName }��!
			�������� ���Ű� ȯ���մϴ�...<a href="logout.do">Log-out</a>
		</h3>
		<a href="getBoardList.do"><input type="button" value="Ȩ����" /></a>
		<div style="border:1px solid blue; width:600px;">
			<h1>���� �߰��ϱ�</h1>
			<form action="insertExam.do" method="post">
				<input name="code" type="hidden" value="${code }">

				<table border="1" width="600px">
					<tr>
						<td>����. <input style="width:400px" type=text name="question" /></td>
					</tr>
					<tr>
						<td>1. <input type=text name="example1" /></td>
					</tr>
					<tr>
						<td>2. <input type=text name="example2" /></td>
					</tr>
					<tr>
						<td>3. <input type=text name="example3" /></td>
					</tr>
					<tr>
						<td>4. <input type=text name="example4" /></td>
					</tr>
					<tr>
						<td>�� : <input type=text name="answer" /></td>
					</tr>
				</table>
				<input type="submit" value="�߰��ϱ�" />
			</form>
		</div>
		
		<div style="border:1px solid red; width:600px; float:left">
			<h1>���� �����ϱ�</h1>
			<c:forEach items="${examList }" var="exam">
			<form action="updateExam.do" method="post">
				<input name="code" type="hidden" value="${code }">
				<input name="num" type="hidden" value="${exam.num }">
				<table border="1" width="600px">
					<tr>
						<td>${exam.num }. <input style="width:400px" type=text name="question" value="${exam.question }" />
						<a href=#><input style="width:80px" type=button value="�����ϱ�" /></a><input type="submit" value="�����ϱ�" /></td>
					</tr>
					<tr>
						<td>1. <input type=text name="example1" value="${exam.example1 }" /></td>
					</tr>
					<tr>
						<td>2. <input type=text name="example2" value="${exam.example2 }" /></td>
					</tr>
					<tr>
						<td>3. <input type=text name="example3" value="${exam.example3 }" /></td>
					</tr>
					<tr>
						<td>4. <input type=text name="example4" value="${exam.example4 }" /></td>
					</tr>
					<tr>
						<td>�� : <input type=text name="answer" value="${exam.answer }" /></td>
					</tr>
				</table>
			</form>
			</c:forEach>
		</div>
		
</body>
</html>