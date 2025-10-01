<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전체 도서 조회</title>		 
	</head>
	<body>
		<h3>전체 도서 조회</h3>		
		<table border="1" width="600">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>저자</th>
				<th>가격</th>
				<th>재고</th>
				<th>출판일</th>
				<th>출판사 번호</th>
			</tr>
			
			<%-- 컨트롤러가 Model에 담아 보낸 bookList를 JSTL forEach를 이용해 반복 처리 --%>
			<c:forEach items="${bookList}" var="book">
			<tr>
				<%-- 도서 번호를 클릭하면 해당 도서의 상세 정보 페이지로 이동하는 링크 생성 --%>
				<td><a href="<c:url value='/book/detailViewBook/${book.bookNo}'/>">${book.bookNo}</a></td>
				<td>${book.bookName}</td>
				<td>${book.bookAuthor}</td>
				<%-- 가격을 세 자리마다 콤마(,)를 찍어 원화 형식으로 표시 --%>
				<td><fmt:formatNumber value="${book.bookPrice}" pattern="#,###" /> 원</td>
				<td>${book.bookStock}</td>
				<%-- 날짜를 'yyyy-MM-dd' 형식으로 표시 --%>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/></td>
				<td>${book.pubNo}</td>
			</tr>
			</c:forEach>
						
		</table><br><br>
		
		<!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/'/>">홈으로 이동</a>
	</body>
</html>