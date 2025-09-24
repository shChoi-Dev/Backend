<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<h3>MyBatis 사용 DB 연동 : 도서 관리</h3><br>
		
		<a href="/book/book/listAllBook">전체 도서정보 조회</a><br> 
		<a href="<c:url value='/book/listAllBook'/>">전체 도서정보 조회</a><br>
		<a href="<c:url value='/book/newBookForm'/>">도서 등록</a><br>

</body>
</html>