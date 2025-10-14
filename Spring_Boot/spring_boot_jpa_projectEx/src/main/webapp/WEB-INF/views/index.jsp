<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>프로젝트 예제</title>
		<!-- head.jsp -->
		<c:import url="/WEB-INF/views/layout/head.jsp" > </c:import>
	</head>
	<body>
		<div id="wrap">
			<!-- top.jsp import -->
			<c:import url="/WEB-INF/views/layout/top.jsp" > </c:import>
			
			<section>
				<article id="slideShow">
					<div id = "prevNextButtonBox">
						<img id="prevButton" src="image/prevButton.png">
						<img id="nextButton" src="image/nextButton.png">
					</div>
					<div id="slideShowBox">
						<div id="slidePanel">
							<img src="image/slide_img_01.jpg" class="slideImage">
							<img src="image/slide_img_02.jpg" class="slideImage">
							<img src="image/slide_img_03.jpg" class="slideImage">
							<img src="image/slide_img_04.jpg" class="slideImage">
							<img src="image/slide_img_05.jpg" class="slideImage">
						</div> <!-- slidePanel 끝 -->
					</div>	<!-- slideShowBox 끝  -->			
					<div id="controlPanel">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
					</div>
				</article>
				<article id="content1">
					<div id="tabMenuBox">
						<div id="tabMenu">
							<ul id="tab">
								<li><img src="image/tab1.png"></li>
								<li><img src="image/tab2.png"></li>
								<li><img src="image/tab3.png"></li>
								<li><img src="image/tab4.png"></li>
							</ul>
					   </div> 
						<div id="tabContent">
							<div><a href="#"><img src="image/tab_img_01.jpg"></a></div>
							<div><a href="#"><img src="image/tab_img_02.jpg"></a></div>
							<div><a href="#"><img src="image/tab_img_03.jpg"></a></div>
							<div><a href="#"><img src="image/tab_img_04.jpg"></a></div>
						</div>
					</div> <!--  tabMenuBox -->
				</article>
				<article id="content2">
					<div id="productBox">
						<h3>베스트 상품</h3>
						<div class='product'>
							<div><a href='#'><img src="image/prd01.jpg"></a></div>
							<div><a href='#'><img src="image/prd02.jpg"></a></div>
							<div><a href='#'><img src="image/prd03.jpg"></a></div>
						</div>
						<div class='product'>
							<div><a href='#'><img src="image/prd04.jpg"></a></div>
							<div><a href='#'><img src="image/prd05.jpg"></a></div>
							<div><a href='#'><img src="image/prd06.jpg"></a></div>
						</div>
					</div>
				</article>
			</section>
			<!-- bottom.jsp import  -->
			<c:import url="/WEB-INF/views/layout/bottom.jsp" > </c:import>
			
			<div><img src="image/chatbot.png" id="cbi"></div>
			<div id="chatbotBox" >
			<!-- Header -->
				<div id="chatHeader">
					<span>챗봇</span>
					<button id="closeBtn">X</button>
				</div>
				<div id="chatBox"></div>
				
				<form id = "chatForm" method="post">
					<input type="text"  id="message"  name="message" placeholder="질문을 입력하세요" autofocus>
					<input type="submit" id="submitBtn" value="전송">
				</form>
			</div>
		</div>
	</body>
</html>