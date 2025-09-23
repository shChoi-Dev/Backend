<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 검색 결과</title>
</head>
<body>
	<h3>상품 검색 결과</h3>
	
		<table border='1'>
			<tr>
				<td>상품 번호</td>
				<td>상품명</td>
				<td>가격</td>
				<td>제조회사</td>
			</tr>
			<c:forEach items="${prdList}" var="prd">
			<tr>
				<td>${prd.prdNo}</td>
				<td>${prd.prdName}</td>
				<td>${prd.prdPrice}</td>
				<td>${prd.prdMaker}</td>
			</tr>
			</c:forEach>
		</table>
	

</body>
</html>