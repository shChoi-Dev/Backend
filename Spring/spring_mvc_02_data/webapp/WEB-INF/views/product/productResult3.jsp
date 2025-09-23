<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameter 사용</title>
</head>
<body>
	<h3>상품 등록 결과</h3>
	상품번호: ${product.prdNo}<br>
	상품명: ${product.prdName}<br>
    가격: ${product.prdPrice} 원<br>
    제조회사: ${product.prdCompany}<br>
    제조일: ${product.prdDate}<br>
     재고: ${product.prdStock} 개<br>
</body>
</html>