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
	상품번호: ${prdNo}<br>
	상품명: ${prdName}<br>
    가격: ${prdPrice} 원<br>
    제조회사: ${prdCompany}<br>
    제조일: ${prdDate}<br>
    재고: ${prdStock} 개<br>
     
    <br><br>
	url을 통한 데이터 전달<br>
	학번은 서버에게 전달해서 해당 학번 학생의 정보를 확인 <br>
	http://localhost:8080/project/product/productDetailView/001<br>
	학번 : <a href="/project/product/productDetailView/${prdName}">${prdName}</a><br>
	<br>
	url을 통한 데이터 여러개 전달<br>
	학번 : <a href="/project/product/productDetailView/${prdName}/${prdStock}/${prdNo}">${prdName}</a><br>
	<br>
	url을 통한 정적 데이터 여러개 전달<br>
	학번 : <a href="/project/product/productDetailView/아이폰17Pro/2/25">정적데이터url로 전달</a><br>
</body>
</html>