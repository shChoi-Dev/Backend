<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 조회</title>	
		<!-- head.jsp import -->
		<c:import url = "/WEB-INF/views/layout/head.jsp"></c:import>	 
	</head>
	<body>
		<div id="wrap">
			<!-- top.jsp import -->
			<c:import url = "/WEB-INF/views/layout/top.jsp"></c:import>
			<br>
			<h3>상품 조회</h3>	<br>
			<table border="1" width="70%" id="ctgTable">
				<tr><th>상품 번호</th>
				<th>상품명</th>
				<th>상품 가격</th>
				<th>제조사</th>
				<th>재고</th>
				<th>상품 설명</th>
				<th>사진</th></tr>
				
				<c:forEach items="${ prdList }" var="prd">
				<tr>
					<td><a href="<c:url value='/product/detailViewProduct/${prd.prdNo}' />">${prd.prdNo}</a></td>
					<td>${prd.prdName}</td>
					<td>${prd.prdPrice}</td>
					<td>${prd.prdCompany}</td>
					<td width="5%">${prd.prdStock}</td>
					<td>${prd.prdDescript}</td>
					<td width="5%">
						<img src="<c:url value='/prd_images/${prd.prdImg}'/>" width="100%">
					</td> 
				</tr>
				</c:forEach>			
			</table><br><br>
			
			<!--  index 페이지로 이동 링크 추가 -->
			<a href="<c:url value='/' />">홈으로 이동</a><br><br>
			<!-- footer.jsp import -->
			<c:import url = "/WEB-INF/views/layout/bottom.jsp"></c:import>
		</div>
	</body>
</html>