<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameter 사용</title>
</head>
<body>
	command 객체 활용해서 view에 전달될 경우 : 자동으로 model에 객체(obj)로 저장해서 view 전달<br>
	표현어에 사용할 떄는 객체명.필드명 형태로 사용 <br>
	학번 : ${student.no}<br>
	성명 : ${student.name }<br>
	학년 : ${student.year }<br>
</body>
</html>