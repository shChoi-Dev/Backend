<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>index 페이지입니다</h3>
	<a href="/project/showInfo">showInfo</a><br>
	<a href="/project/showInfo2">showInfoMV</a><br>
	<a href="/project/showInfo3">showInfoMV + Model</a><br>
	<hr>
	<h3>BookInfo(연습문제)</h3>
	<a href="/project/bookInfoView1">Model을 이용한 bookInfo</a><br>
	<a href="/project/bookInfoView2">ModelAndView를 이용한 bookInfo</a><br>
	<hr>
	<h3>학생정보</h3>
	<a href="/project/student/studentForm">학생정보입력(정적경로)</a><br>
	<a href="<c:url value='/student/studentForm2'/>">학생정보입력(동적경로)</a><br>
	<hr>
	<h3>상품등록(연습문제)</h3>
	<a href="/project/product/productForm">상품정보입력(정적경로)</a><br>
	<a href="<c:url value='/product/productForm2'/>">상품정보입력(동적경로)</a>
	
</body>
</html>