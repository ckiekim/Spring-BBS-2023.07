<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Parameter</title>
</head>
<body style="margin: 40px;">
	<h1>폼 데이터 전달</h1>
	<hr>
	<form action="/sbbs/basic/basic8" method="post">
		ID: <input type="text" name="id"><br><br>
		PWD: <input type="password" name="pwd"><br><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>