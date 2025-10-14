<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 수정</title>	
		<c:import url="/WEB-INF/views/layout/head.jsp"/>
		<link rel="stylesheet"   type="text/css"  href="<c:url value='/css/join.css'/>">
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>	
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		<script src="<c:url value='/js/searchZip.js'/> "></script>
	</head>
	<body>
	<div id="wrap">
		<!-- top.jsp 임포트 -->
			<c:import url="/WEB-INF/views/layout/top.jsp"/>
		<section>
	        <h1 id="title">회원 정보 수정</h1>
	        <form id="joinForm" name="updateForm" method="post"  
	        			action="<c:url value='/member/myInfoUpdate'/>">
	        	<table>
		            <tr>
		            	<th> 성명</th>
		           		<td><input type="text" id="memName" name="memName" value="${myInfo.memName }"></td>
	           		</tr>
		            <tr>
		            	<th> ID</th>
		            	<td><input type="text" id="memId" name="memId" value="${myInfo.memId }" readonly > 
	            	</tr>
		            <tr>
		            	<th>비밀번호</th>
		            	<td>
		            		<input type="button" id="memPwd" name="memPwd" value="비밀번호변경">
		            	</td>
	            	</tr>
		            <tr>
		            	<th>휴대폰 번호</th>
		            	<td><input type="text" id="memHp1" name="memHp1" size="3" value="${fn:split(myInfo.memHP, '-')[0]}"> 
		                    - <input type="text" id="memHp2" name="memHp2" size="4" value="${fn:split(myInfo.memHP, '-')[1]}">
		                    - <input type="text" id="memHp3" name="memHp3" size="4" value="${fn:split(myInfo.memHP, '-')[2]}"></td>
                    </tr>
                    <tr>
		            	<th>이메일</th>
		            	<td><input type="email" id="memEmail" name="memEmail" value="${myInfo.memEmail }"></td>
	            	</tr>
                    <tr>
		            	<th>주소</th>
		            	<td colspan="3">
		            		<input type="text" id="memZipcode" name="memZipcode" size="5" value="${myInfo.memZipcode }" readonly>
		            		<input type="button" id="searchZipBtn" name="searchZipBtn" value="우편번호 찾기"><br>
		            		<input type="text" id="memAddress1" name="memAddress1"   size="40" value="${myInfo.memAddress1 }" readonly>
		            		<input type="text" id="memAddress2" name="memAddress2" value="${myInfo.memAddress2 }" >
	            		</td>
	            	</tr>
		            	             
		             <tr>
		                <td colspan="2" align="center" id="button">
		                    <br><input type="submit" value="완료">
		                    <input type="reset" value="취소">
		                </td>
		            </tr>             
	            </table>
	      </form>	
      </section>
    <!-- bottom.jsp 임포트 -->
	<c:import url="/WEB-INF/views/layout/bottom.jsp"/>
     </div>
    </body>
</html>


