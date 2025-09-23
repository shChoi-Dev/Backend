<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
    <title>Student Search Result</title>
</head>
<body>
<h1>학생 검색 결과</h1>
<table border="1">
    <tr>
        <th>학번</th>
        <th>이름</th>
        <th>학년</th>
    </tr>
    <c:forEach var="student" items="${stdList}">
        <tr>
            <td>${student.no}</td>
            <td>${student.name}</td>
            <td>${student.year}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
