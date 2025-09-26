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
		<h3>MyBatis 사용 DB 연동 : 상품 관리</h3><br>
		
		<a href="/mybatis/product/listAllProduct">전체 상품 조회</a><br> 
		<a href="<c:url value='/product/listAllProduct'/>">전체 상품 조회</a><br>
		<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
		<a href="<c:url value='/product/productSearchForm1'/>">상품 검색1</a><br>
		<hr>
		이미지 표현<br>
		<img src="/mybatis/resources/image/apple.png"><br>
		<hr>
		<h3>Ajax연습</h3>
		<a href="<c:url value='/loginForm'/>">로그인</a><br>
		<a href="<c:url value='/loginForm2'/>">로그인2</a><br>
		
		

</body>
</html>