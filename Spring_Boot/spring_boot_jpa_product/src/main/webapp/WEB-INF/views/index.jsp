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
		<h3>Sping Boot - MyBatis 사용 DB 연동 : 상품 관리</h3><br>		
		
		<a href="<c:url value='/product/listAllProduct'/>">전체 상품 조회</a><br>
		<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
		
		<!-- 이미지 출력 -->		
		<img src="/image/apple.png"> <!--  "/"가 static 폴더 찾음 -->
		<img src="<c:url value='/image/apple.png'/>"> 
		<!-- 맵핑 이름 project_image 사용해서 이미지 출력 -->
		<img src="/prd_images/apple.png"> <!-- 주의: 맨 앞에 / 없음 -->
		<img src="<c:url value='/prd_images/apple.png'/>"> 
				
		<h3>상품 검색</h3>
		<a href="<c:url value='/product/productSearchForm1'/>">상품 검색1</a><br>
		
	</body>
</html>



