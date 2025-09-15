<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<c:url var="url1" value="/jstl/urlTestRes.jsp">
	<c:param name="id" value="hong"/>
	<c:param name="pwd" value="1234"/>
	<c:param name="name" value="홍길동"/>
	<c:param name="email" value="hong@abc.com"/>
</c:url>
<%-- url 구성하면서 파라미터 값 url에 포함시킴(쿼리스트링) --%>

<html>
<head>
<meta charset=”UTF-8">
<title> c:url  태그 실습</title>
</head>
<body> 
<a href='${url1}'>회원정보출력</a>
</body>
</html>
