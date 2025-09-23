<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameter 사용</title>
</head>
<body>
	Data 타입의 객체 필드 변수 birth의 표현<br>
	학번 : ${student.no}<br>
	성명 : ${student.name }<br>
	학년 : ${student.year }<br>
	생일 : <fmt:formatDate value="${student.birthday }" pattern="YYYY-MM-dd"/><br>
</body>
</html>