<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>프로젝트 예제 : index 메인 페이지</title> 
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/menu.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/slideShow.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/tabMenu.css'/>">
	    <link rel="stylesheet" type="text/css" href="<c:url value='/css/product.css'/>">
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script src="<c:url value='/js/subMenu.js'/>"></script>
		<script src="<c:url value='/js/slideShow.js'/>"></script>
		<script src="<c:url value='/js/tabMenu.js'/>"></script>
		<script src="<c:url value='/js/index.js'/>"></script>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
    	<div id="wrap"> <header>
        		<div id="headerBox">
	            	<div id="logoBox"><a href="<c:url value='/'/>"><img src="<c:url value='/image/logo.png'/>" id="logoImg"></a></div>
					<div id="topMenuBox">로그인 이벤트 장바구니 고객센터 회원가입</div>
            	</div>
            </header>
            <nav>  <div id="mainMenuBox">
            		<ul id="menuItem">
						<li><a href="#">SPECIAL</a></li>
						<li><a href="#">메뉴항목1</a></li>
						<li><a href="#">메뉴항목2</a></li>
						<li><a href="#">메뉴항목3</a></li>
						<li><a href="#">메뉴항목4</a></li>
						<li><a href="#" id="showAllMenu">전체보기 ▼</a></li>
					</ul>
            	</div> <div id="subMenuBox">
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
                </div>    </nav>             
            <section><article  id="slideShow"> <div id="prevNextButtonBox">
						<img id="prevButton" src="<c:url value='/image/prevButton.png'/>">
						<img id="nextButton" src="<c:url value='/image/nextButton.png'/>">
					</div>	
					<div id="slideShowBox">
						<div id="slidePanel">
							<img src= "<c:url value='/image/slide_img_01.jpg'/>" class="slideImage">
							<img src= "<c:url value='/image/slide_img_02.jpg'/>" class="slideImage">
							<img src= "<c:url value='/image/slide_img_03.jpg'/>" class="slideImage">
							<img src= "<c:url value='/image/slide_img_04.jpg'/>" class="slideImage">
							<img src= "<c:url value='/image/slide_img_05.jpg'/>" class="slideImage">
						</div>
					</div> <div id = "controlPanel">
						<img src="<c:url value='/image/controlButton1.png'/>" class="controlButton">
						<img src="<c:url value='/image/controlButton1.png'/>" class="controlButton">
						<img src="<c:url value='/image/controlButton1.png'/>" class="controlButton">
						<img src="<c:url value='/image/controlButton1.png'/>" class="controlButton">
						<img src="<c:url value='/image/controlButton1.png'/>" class="controlButton">
					</div>	
                </article> 
                <article id="content1"> <div id="tabMenuBox">					
						<div id="tabMenu">
							<ul id="tab">
								<li><img src="<c:url value='/image/tab1.png'/>"></li>
								<li><img src="<c:url value='/image/tab2.png'/>"></li>
								<li><img src="<c:url value='/image/tab3.png'/>"></li>
								<li><img src="<c:url value='/image/tab4.png'/>"></li>
							</ul>
						</div>								
						<div id="tabContent">
							<div><a href="#"><img src="<c:url value='/image/tab_img_01.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/tab_img_02.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/tab_img_03.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/tab_img_04.jpg'/>"></a></div>
						</div>
					</div>			           
                       
                </article>
                <article  id="content2"> <div id="productBox">
						<h3> 베스트 상품</h3>
						<div class="product">
							<div><a href="#"><img src="<c:url value='/image/prd01.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/prd02.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/prd03.jpg'/>"></a></div>
						</div>
						<div class="product">
							<div><a href="#"><img src="<c:url value='/image/prd04.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/prd05.jpg'/>"></a></div>
							<div><a href="#"><img src="<c:url value='/image/prd06.jpg'/>"></a></div>
						</div>
					</div>     
                </article>
            </section>
            <footer> <div id="footerBox">
            	 <div id="bottomMenuBox">
						<ul id="bottomMenuItem">
							<li><a href="#">회사소개</a></li>
							<li><a href="#">이용약관</a></li>
							<li><a href="#">개인정보 처리방침</a></li>
							<li><a href="#">전자금융거래약관</a></li>
							<li><a href="#">보안센터</a></li>
							<li><a href="#">채용정보</a></li>
						</ul>
					</div> <div id="companyInfo"><img src="<c:url value='/image/footer.png'/>"></div>
					<div id="moveToTopBox"><img src="<c:url value='/image/moveToTop.png'/>" id="moveToTop"></div>
            	</div>
            </footer>
      </div> </body>
</html>