<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css'/>">
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="<c:url value='/js/searchZip.js'/>"></script>
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp"/>
    <section>
        <h1 id="title">회원 정보 수정</h1>
        <form id="updateForm" name="updateForm" method="post" action="<c:url value='/member/updateMember'/>">
            <table>
                <tr>
                    <th>성명</th>
                    <td><input type="text" id="memName" name="memName" value="${memVo.memName}"></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <td><input type="text" id="memId" name="memId" value="${memVo.memId}" readonly></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" id="memPwd" name="memPwd" placeholder="변경할 경우에만 입력하세요"></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td>
                        <input type="text" id="memHp1" name="memHp1" size="3" value="${hp1}"> -
                        <input type="text" id="memHp2" name="memHp2" size="4" value="${hp2}"> -
                        <input type="text" id="memHp3" name="memHp3" size="4" value="${hp3}">
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" id="memEmail" name="memEmail" value="${memVo.memEmail}"></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>
                        <input type="text" id="memZipcode" name="memZipcode" size="5" value="${memVo.memZipcode}" readonly>
                        <input type="button" id="searchZipBtn" value="우편번호 찾기"><br>
                        <input type="text" id="memAddress1" name="memAddress1" size="40" value="${memVo.memAddress1}" readonly>
                        <input type="text" id="memAddress2" name="memAddress2" size="40" value="${memVo.memAddress2}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" id="button">
                        <br><input type="submit" value="수정 완료">
                        <input type="reset" value="다시 작성">
                    </td>
                </tr>
            </table>
        </form>
    </section>
    <c:import url="/WEB-INF/views/layout/bottom.jsp"/>
</div>
</body>
</html>