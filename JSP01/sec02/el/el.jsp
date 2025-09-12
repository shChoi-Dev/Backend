<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
plain text로 출력 : 100<br>
표현식으로 출력<%=100 %><br>
표현언어(EL)로 출력 : ${100}<br>
표현언어(EL)로 출력 : ${"문자열"}<br>
표현언어(EL)로 출력 : ${true}<br>
표현언어(EL)로 출력 : ${true && true}<br>
표현언어(EL)로 출력 : ${100 - 90}<br>
표현언어(EL)로 출력 : ${100 % 90}<br>
표현언어(EL)로 출력 : ${100 mod 90}<br>
<%-- 표현언어(EL)로 출력 : ${"hello" + "world"}<br> --%>
<!-- 문자열 연산의 결과 -->
</body>
</html>