<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼에 입력된 값으로 빈 속성값 설정</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<!-- StudentBean 클래스의 속성값을 한번에 저장 : 값은 request 객체 파라미터로 전달
		클래스 필드명과 파라미터명이 동일한 경우 파라미터값을 필드에 저장
	 -->
	<jsp:useBean id="student" class="sec01.StudentBean" scope="page">
		<jsp:setProperty property="*" name="student"/>
	</jsp:useBean>
	
	<h3>beans 속성값 출력(Getter사용)</h3>
	학번 : <%=student.getStdNo() %><br>
	성명 : <%=student.getStdName() %><br>
	전화번호 : <%=student.getStdPhone() %><br>
	주소 : <%=student.getStdAddress() %><br>
	학년 : <%=student.getStdYear() %><br>
	취미 : 
	
	<%
		String[] stdInterests = student.getStdInterest();
		for(int i=0; i<stdInterests.length; i++) {
			%>
			<%=stdInterests[i] + " "%>
		<% }
	%>
	
</body>
</html>