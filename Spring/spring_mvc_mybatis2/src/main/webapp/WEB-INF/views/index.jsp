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
		<a href="<c:url value='/book/listAllBook'/>">전체 도서정보 조회</a><br>
		<a href="<c:url value='/book/newBookForm'/>">도서 등록</a><br>
<<<<<<< HEAD
		
		<h4>--- 도서 검색 ---</h4>
		<a href="<c:url value='/book/bookSearchForm1'/>">방법 1: 도서 검색 (Controller + @ResponseBody)</a><br>
		<a href="<c:url value='/book/bookSearchForm2'/>">방법 2: 도서 검색 (Controller + View 반환)</a><br>
		<a href="<c:url value='/book/bookSearchForm3'/>">방법 3: 도서 검색 (Controller + @RestController)</a><br>
=======

>>>>>>> parent of 6215d48 (study: 웹 백엔드 기초 학습 | 250929(오전/오후))
</body>
</html>