<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- menu -->
<header>
	<div id="headerBox">
		<div id="logoBox">
			<a href="<c:url value='/'/>"><img src="<c:url value='/image/logo.png'/>" id="logoImg"></a>
		</div>
		<div id="topMenuBox">
		<c:if test="${empty sessionScope.sid}">
			<a href="<c:url value='/member/loginForm'/>">로그인</a> 
			<a href="<c:url value='/member/joinForm'/>">회원가입</a>
		</c:if>
		
		<c:if test="${not empty sessionScope.sid}">
		${sessionScope.sid}님 환영합니다!
			<a href="<c:url value='/member/logout'/>">로그아웃</a> 
			<a href="<c:url value='/member/boardList'/>">게시판</a>
			<a href="<c:url value='/product/cartList'/>">장바구니</a>
			<a href="<c:url value='/member/myPage'/>">마이페이지</a>
		</c:if>    
		</div>
	</div>
</header>
<nav> <!-- 메뉴영역 -->
	<div id="mainMenuBox">
		<ul id="menuItem">
			<li><a href="#">SPECIAL</a></li>
			<li><a href="#">메뉴항목1</a></li>
			<li><a href="#">메뉴항목2</a></li>
			<li><a href="#">메뉴항목3</a></li>
			<li><a href="#">메뉴항목4</a></li>
			<li><a href="#" id="showAllMenu">전체보기 ▼</a></li>
		</ul>
	</div>
	<div id="subMenuBox">
		<div class="subMenuItem" id="subMenuItem1">
			<ul>
				<li><a href="#">subMenuItem1-1</a></li>
				<li><a href="#">subMenuItem1-2</a></li>
				<li><a href="#">subMenuItem1-3</a></li>
				<li><a href="#">subMenuItem1-4</a></li>
			</ul>
		</div>
		<div class="subMenuItem" id="subMenuItem2">
			<ul>
				<li><a href="#">subMenuItem2-1</a></li>
				<li><a href="#">subMenuItem2-2</a></li>
				<li><a href="#">subMenuItem2-3</a></li>
				<li><a href="#">subMenuItem2-4</a></li>
			</ul>
		</div>
		<div class="subMenuItem" id="subMenuItem3">
			<ul>
				<li><a href="#">subMenuItem3-1</a></li>
				<li><a href="#">subMenuItem3-2</a></li>
				<li><a href="#">subMenuItem3-3</a></li>
				<li><a href="#">subMenuItem3-4</a></li>
			</ul>
		</div>
		<div class="subMenuItem" id="subMenuItem4">
			<ul>
				<li><a href="#">subMenuItem4-1</a></li>
				<li><a href="#">subMenuItem4-2</a></li>
				<li><a href="#">subMenuItem4-3</a></li>
				<li><a href="#">subMenuItem4-4</a></li>
			</ul>
		</div>
		<div class="subMenuItem" id="subMenuItem5">
			<ul>
				<li><a href="#">subMenuItem5-1</a></li>
				<li><a href="#">subMenuItem5-2</a></li>
				<li><a href="#">subMenuItem5-3</a></li>
				<li><a href="#">subMenuItem5-4</a></li>
			</ul>
		</div>
		<div class="subMenuItem" id="subMenuItem6">
			<ul>
				<li><a href="#">subMenuItem6-1</a></li>
				<li><a href="#">subMenuItem6-2</a></li>
				<li><a href="#">subMenuItem6-3</a></li>
				<li><a href="#">subMenuItem6-4</a></li>
			</ul>
		</div>
	</div>
</nav>
