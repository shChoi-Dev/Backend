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
				<th width="7%">아이디</th>
				<th width="7%">비밀번호</th>
				<th width="7%">이름</th>
				<th width="7%">이메일</th>
				<th width="7%">가입일</th>
			</tr>
			<c:forEach var="mem" begin="0" end="${memList.size()}" step="1" items="${memList }">
				<tr>
					<td>${mem.memId }</td>
					<td>${mem.memPwd }</td>
					<td>${mem.memName }</td>
					<td>${mem.memEmail }</td>
					<td>${mem.memJoinDate }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>