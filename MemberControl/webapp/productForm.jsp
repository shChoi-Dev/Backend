<%-- productForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>상품 등록창</title>
</head>
<body>
<%-- 폼 전송 경로를 /product/addProduct.do로 변경 --%>
<form method="post" action="${contextPath}/product/addProduct.do">
<h1 style="text-align:center">상품 등록창</h1>
<table align="center">
    <tr>
        <td width="200"><p align="right">상품번호</p></td>
        <td width="400"><input type="text" name="prdNo"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">상품명</p></td>
        <td width="400"><input type="text" name="prdName"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">가격</p></td>
        <td width="400"><input type="text" name="prdPrice"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">제조사</p></td>
        <td width="400"><input type="text" name="prdMaker"></td>
    </tr>
     <tr>
        <td width="200"><p align="right">색상</p></td>
        <td width="400"><input type="text" name="prdColor"></td>
    </tr>
     <tr>
        <td width="200"><p align="right">카테고리번호</p></td>
        <td width="400"><input type="text" name="ctgNo"></td>
    </tr>
    <tr>
        <td width="200"><p>&nbsp;</p></td>
        <td width="400">
           <input type="submit" value="등록하기">
           <input type="reset" value="다시입력">
       </td>
    </tr>
</table>
</form>
</body>
</html>