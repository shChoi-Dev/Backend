<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 상세 정보 조회</title>
	</head>
	<body>
		 <h3>도서 상세 정보 조회</h3>
	     <table border="1" width="300">
			<tr><td>도서번호</td><td>${book.bookNo}</td></tr>
            <tr><td>도서명</td><td>${book.bookName}</td></tr>
            <tr><td>저자</td><td>${book.bookAuthor}</td></tr>
            <tr><td>가격</td><td><fmt:formatNumber value="${book.bookPrice}" pattern="#,###" />원</td></tr>
            <tr><td>재고</td><td>${book.bookStock}</td></tr>
            <tr><td>출판일</td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd" /></td></tr>
			<tr><td>출판사 번호</td><td>${book.pubNo}</td></tr>
		</table><br><br>
	    <a href="<c:url value='/book/updateBookForm/${book.bookNo}'/>">[상품 정보 수정]</a><br>  	   
   <a href="javascript:deleteCheck();">[상품 정보 삭제]</a><br> 
	    <!-- 삭제 확인 메시지 출력 -->
	    <script>
	    	function deleteCheck(){
	    		let answer = confirm("삭제하시겠습니까?");
	    		if(answer) {
	    			location.href = "<c:url value='/book/deleteBook/${book.bookNo}'/>";
	    		}
	    	}
	    </script>
    
	    <!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/' />">[홈으로 이동]</a> 
	</body>
</html>