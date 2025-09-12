<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가위바위보 게임</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<style>
    .choice-btn {
        display: inline-block; /* 버튼처럼 가로 정렬 및 크기 조절 가능 */
        font-size: 2.5em; /* 아이콘 크기 키우기 */
        width: 80px; /* 고정 너비 */
        height: 80px; /* 고정 높이 */
        line-height: 80px; /* 세로 중앙 정렬 */
        text-align: center; /* 가로 중앙 정렬 */
        margin: 0 10px;
        text-decoration: none;
        border: 2px solid #007bff; /* 파란색 테두리 */
        color: #007bff; /* 파란색 아이콘 */
        border-radius: 50%; /* 완전한 원 형태로 */
        transition: all 0.2s ease-in-out; /* 부드러운 전환 효과 */
        background-color: white; /* 흰색 배경 */
    }

    .choice-btn:hover {
        background-color: #007bff; /* 호버 시 배경색 변경 */
        color: white; /* 호버 시 아이콘색 변경 */
        transform: translateY(-3px); /* 살짝 위로 뜨는 효과 */
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2); /* 그림자 효과 */
    }
</style>
</head>
<body>
	<div class="container">
        <h2>✌️✊✋ 가위바위보 게임</h2>
        <p>아래 버튼을 눌러 컴퓨터와 대결하세요!</p>

        <div class="choices">
            <a href="rsp?choice=가위" class="choice-btn">✌️ 가위</a>
            <a href="rsp?choice=바위" class="choice-btn">✊ 바위</a>
            <a href="rsp?choice=보" class="choice-btn">🖐️ 보</a>
        </div>

        <%-- 서블릿에서 결과가 전달되었을 때만 이 부분을 표시 --%>
        <% if (request.getAttribute("resultMsg") != null) { %>
            <div class="result-box">
                <h3>--- 결과 ---</h3>
                <p><strong>나의 선택:</strong> <%= request.getAttribute("userChoice") %></p>
                <p><strong>컴퓨터의 선택:</strong> <%= request.getAttribute("computerChoice") %></p>
                <h4><strong><%= request.getAttribute("resultMsg") %></strong></h4>
            </div>
        <% } %>

        <p style="margin-top: 30px;"><a href="index.html" class="back-button">메인으로 돌아가기</a></p>
    </div>
</body>
</html>