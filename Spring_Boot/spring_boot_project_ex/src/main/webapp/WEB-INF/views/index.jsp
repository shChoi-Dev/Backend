<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>프로젝트 예제 : index 메인 페이지</title>
		<!-- head.jsp c:import runtime에 코드 결합 -->
		<c:import url="/WEB-INF/views/layout/head.jsp"/>
	</head>
	<body>
	<div id="wrap"> <!-- 전체 영역 -->
		<!-- top.jsp -->
		<c:import url="/WEB-INF/views/layout/top.jsp"/>
		<section>
			<article id="slideShow">
				<div id="prevNextButtonBox">
					<img id="prevButton" src="<c:url value='/image/prevButton.png'/>">
					<img id="nextButton" src="<c:url value='/image/nextButton.png'/>">
				</div>
				<div id="slideShowBox">
					<div id="slidePanel">
						<img src="<c:url value='/image/slide_img_01.jpg'/>"
							class="slideImage"> <img
							src="<c:url value='/image/slide_img_02.jpg'/>" class="slideImage">
						<img src="<c:url value='/image/slide_img_03.jpg'/>"
							class="slideImage"> <img
							src="<c:url value='/image/slide_img_04.jpg'/>" class="slideImage">
						<img src="<c:url value='/image/slide_img_05.jpg'/>"
							class="slideImage">
					</div>
				</div>
				<div id="controlPanel">
					<img src="<c:url value='/image/controlButton1.png'/>"
						class="controlButton"> <img
						src="<c:url value='/image/controlButton1.png'/>"
						class="controlButton"> <img
						src="<c:url value='/image/controlButton1.png'/>"
						class="controlButton"> <img
						src="<c:url value='/image/controlButton1.png'/>"
						class="controlButton"> <img
						src="<c:url value='/image/controlButton1.png'/>"
						class="controlButton">
				</div>
			</article>
			<article id="content1">
				<div id="tabMenuBox">
					<div id="tabMenu">
						<ul id="tab">
							<li><img src="<c:url value='/image/tab1.png'/>"></li>
							<li><img src="<c:url value='/image/tab2.png'/>"></li>
							<li><img src="<c:url value='/image/tab3.png'/>"></li>
							<li><img src="<c:url value='/image/tab4.png'/>"></li>
						</ul>
					</div>
					<div id="tabContent">
						<div>
							<a href="#"><img src="<c:url value='/image/tab_img_01.jpg'/>"></a>
						</div>
						<div>
							<a href="#"><img src="<c:url value='/image/tab_img_02.jpg'/>"></a>
						</div>
						<div>
							<a href="#"><img src="<c:url value='/image/tab_img_03.jpg'/>"></a>
						</div>
						<div>
							<a href="#"><img src="<c:url value='/image/tab_img_04.jpg'/>"></a>
						</div>
					</div>
				</div>

			</article>
			<article id="content2">
				<div id="productBox">
					<h3>베스트 상품</h3>
					<div class="product">
						<div>
							<a href="#"><img src="<c:url value='/image/prd01.jpg'/>"></a>
						</div>
						<div>
							<a href="#"><img src="<c:url value='/image/prd02.jpg'/>"></a>
						</div>
						<div>
							<a href="#"><img src="<c:url value='/image/prd03.jpg'/>"></a>
						</div>
					</div>
					<div class="product">
						<div><a href="#"><img src="<c:url value='/image/prd04.jpg'/>"></a></div>
						<div>
							<a href="#"><img src="<c:url value='/image/prd05.jpg'/>"></a>
						</div>
						<div>
							<a href="#"><img src="<c:url value='/image/prd06.jpg'/>"></a>
						</div>
					</div>
				</div>
			</article>
		</section>
		<!-- bottom -->
		<c:import url="/WEB-INF/views/layout/bottom.jsp"/>
	</div> <!-- warp 끝 -->
</body>
</html>