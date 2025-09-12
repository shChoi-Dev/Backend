<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제 newMemberOK_최승훈</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<jsp:useBean id="member" class="sec01.MemberBean" scope="page">
		<jsp:setProperty property="*" name="member"/>
	</jsp:useBean>
	
	<h3>beans 속성값 출력(액션태그 사용)</h3>
	아이디 : <jsp:getProperty property="id" name="member"/><br>
	비밀번호 : <jsp:getProperty property="pwd" name="member"/> <br>
	이름 : <jsp:getProperty property="name" name="member"/><br>
	이메일 : <jsp:getProperty property="email" name="member"/><br>
	
	<h3>beans 속성값 출력(Getter사용)</h3>
	아이디 : <%=member.getId() %><br>
	비밀번호 : <%=member.getPwd() %><br>
	이름 : <%=member.getName() %><br>
	이메일 : <%=member.getEmail() %><br>
	
</body>
</html>