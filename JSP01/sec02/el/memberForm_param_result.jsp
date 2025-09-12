<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param 내장 객체 사용</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	아이디 : ${param.id}<br>
	비밀번호 : ${param.pwd}<br>
	이름 : ${param.name}<br>
	이메일 : ${param.email}<br>
</body>
</html>