<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<table border="1">
			<tr align="center" bgcolor="lightgreen">
				<th width="7%">상품번호</th>
				<th width="7%">상품명</th>
				<th width="7%">가격</th>
				<th width="7%">제조사</th>
				<th width="7%">색상</th>
				<th width="7%">카테고리번호</th>
			</tr>
			<c:forEach var="prd" begin="0" end="${prdList.size()}" step="1" items="${prdList }">
				<tr>
					<td>${prd.prdNo }</td>
					<td>${prd.prdName }</td>
					<td>${prd.prdPrice }</td>
					<td>${prd.prdMaker }</td>
					<td>${prd.prdColor }</td>
					<td>${prd.ctgNo }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>