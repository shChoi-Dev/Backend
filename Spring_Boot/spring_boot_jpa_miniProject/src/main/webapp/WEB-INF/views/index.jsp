<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TRVR - 당신의 모든 여행의 시작</title>
    <link rel="stylesheet" href="css/style.css">
    </head>
<body>

    <header>
        <div class="header-container">
            <h1><a href="/">TRVR</a></h1>

            <nav>
                <ul>
                    <li><a href="/category/carrier">캐리어</a></li>
                    <li><a href="/category/accessories">여행소품</a></li>
                    <li><a href="/category/safety">안전용품</a></li>
                </ul>
            </nav>

            <div class="user-menu">
                <ul>
                    <li><a href="/login">로그인</a></li>
                    <li><a href="/register">회원가입</a></li>
                    <li><a href="/mypage">마이페이지</a></li>
                    <li><a href="/cart">장바구니</a></li>
                </ul>
            </div>
        </div>
    </header>

    <main>
        <section class="main-banner">
            <img src="https://via.placeholder.com/1200x400" alt="메인 배너">
        </section>

        <section class="product-list">
            <h2>인기 상품</h2>
            <div class="items">
                <div class="item">
                    <img src="https://via.placeholder.com/300x300" alt="상품 이미지">
                    <h3>상품 이름 1</h3>
                    <p>100,000원</p>
                </div>
                <div class="item">
                    <img src="https://via.placeholder.com/300x300" alt="상품 이미지">
                    <h3>상품 이름 2</h3>
                    <p>120,000원</p>
                </div>
                </div>
        </section>

        <section class="reviews">
            <h2>Best Reviews</h2>
            <div class="review-items">
                <div class="review-item">
                    <p>"이 캐리어 정말 튼튼하고 좋아요! 추천합니다."</p>
                    <span>★★★★★ by user123</span>
                </div>
                <div class="review-item">
                    <p>"여행용품은 여기서만 사요. 배송도 빠르고 만족!"</p>
                    <span>★★★★★ by travel_lover</span>
                </div>
                </div>
        </section>

    </main>

    <footer>
        <div class="footer-container">
            <p>&copy; 2025 TRVR. All Rights Reserved.</p>
            <p>회사 정보 | 이용약관 | 개인정보처리방침</p>
        </div>
    </footer>

</body>
</html>
