<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="icon" type="image/png" href="#" />

	</head>
	<body>	
		<form name="frmLogin" method="post" action="login">
			이름: <input type="text" id="user_id" name="user_id"><br>
			비밀번호: <input type="password" name="user_pw"><br>
			<input type="submit" value="확인"> <input type="reset" value="취소">
		</form> <br><br>

	</body>
</html>