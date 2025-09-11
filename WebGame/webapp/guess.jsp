<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자 맞히기 게임</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
        <h2>🎮 숫자 알아맞히기 게임</h2>
        <p>1부터 10 사이의 숫자를 맞춰보세요!</p>

        <form action="guess" method="post">
            <label for="userGuess">숫자 입력:</label>
            <input type="text" id="userGuess" name="userGuess" required autocomplete="off" autofocus>
            <input type="submit" value="확인">
        </form>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <p class="message"><%= message %></p>
        <%
            }
        %>
        
        <%
        	Boolean isGameEnd = (Boolean) request.getAttribute("gameEnd");
        	if (isGameEnd != null && isGameEnd) {
        %>
        	<p><a href="guess" class="play-button">새 게임 시작하기</a></p>
        <%
        	} else {
        %>
        	<p style="margin-top: 30px;"><a href="index.html">메인으로 돌아가기</a></p>
        <%
        	}
        %>
    </div>
</body>
</html>