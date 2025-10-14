<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 탈퇴</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css'/>">
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp"/>
    <section>
        <h1 id="title">회원 탈퇴</h1>
        <form id="deleteForm" name="deleteForm" method="post" action="<c:url value='/member/deleteMember'/>">
            <table>
                <tr>
                    <td colspan="2" style="text-align: center; padding-bottom: 20px;">
                        회원 탈퇴를 위해 비밀번호를 입력해주세요.<br>
                        탈퇴 시 회원 정보는 복구할 수 없습니다.
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" id="pwd" name="pwd" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" id="button">
                        <br><input type="submit" value="탈퇴하기">
                        <input type="button" value="취소" onclick="location.href='<c:url value="/member/myPage"/>'">
                    </td>
                </tr>
            </table>
        </form>
    </section>
    <c:import url="/WEB-INF/views/layout/bottom.jsp"/>
</div>
</body>
</html>