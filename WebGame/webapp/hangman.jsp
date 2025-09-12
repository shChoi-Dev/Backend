<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행맨 게임</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<style>
    .alphabet-btn {
        font-size: 1em;
        width: 35px;
        height: 35px;
        margin: 2px;
    }
</style>
</head>
<body>
<div class="container">
        <h2>🎰 행맨 게임</h2>
        <p>과일 이름을 맞춰보세요!</p>

        <%
            // 세션에서 게임 상태 가져오기
            char[] wordState = (char[]) session.getAttribute("wordState");
            Integer remainingAttempts = (Integer) session.getAttribute("remainingAttempts");
            Set<Character> guessedLetters = (Set<Character>) session.getAttribute("guessedLetters");
            String gameMessage = (String) request.getAttribute("gameMessage");
        %>

        <div class="word-display">
            <% for (char c : wordState) { out.print(c + " "); } %>
        </div>

        <div class="game-info">
            남은 기회: <%= remainingAttempts %>
        </div>

        <%-- 게임 종료 메시지 또는 알파벳 버튼 표시 --%>
        <% if (gameMessage != null) { %>
            <div class="game-message <%= gameMessage.contains("축하") ? "win" : "" %>">
                <%= gameMessage %>
            </div>
            <p style="margin-top: 20px;"><a href="hangman" class="play-button">새 게임 시작</a></p>
        <% } else { %>
            <div class="alphabet-buttons">
                <form action="hangman" method="post">
                    <% for (char c = 'A'; c <= 'Z'; c++) { %>
                        <button type="submit" name="guess" value="<%= c %>" class="alphabet-btn" 
                                <%= guessedLetters.contains(c) ? "disabled" : "" %>>
                            <%= c %>
                        </button>
                    <% } %>
                </form>
            </div>
        <% } %>

        <p style="margin-top: 30px;"><a href="index.html" class="back-button">메인으로 돌아가기</a></p>
    </div>
</body>
</html>