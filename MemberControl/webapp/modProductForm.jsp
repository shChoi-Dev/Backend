<%-- modProductForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<head>
<meta charset="UTF-8">
<title>상품 정보 수정창</title>
</head>
<body>
 <h1 style="text-align:center;">상품 정보 수정창</h1>
<form method="post" action="${contextPath}/product/modProduct.do">
 <table align="center">
   <tr>
     <td width="200"><p align="right">상품번호</p></td>
     <%-- 상품번호는 수정 불가하도록 disabled 처리 --%>
     <td width="400"><input type="text" name="prdNo_disabled" value="${prdInfo.prdNo}" disabled></td>
   </tr>
   <tr>
     <td width="200"><p align="right">상품명</p></td>
     <td width="400"><input type="text" name="prdName" value="${prdInfo.prdName}"></td>
   </tr>
   <tr>
     <td width="200"><p align="right">가격</p></td>
     <td width="400"><input type="text" name="prdPrice" value="${prdInfo.prdPrice}"></td>
   </tr>
   <tr>
     <td width="200"><p align="right">제조사</p></td>
     <td width="400"><input type="text" name="prdMaker" value="${prdInfo.prdMaker}"></td>
   </tr>
   <tr>
     <td width="200"><p align="right">색상</p></td>
     <td width="400"><input type="text" name="prdColor" value="${prdInfo.prdColor}"></td>
   </tr>
   <tr>
     <td width="200"><p align="right">카테고리번호</p></td>
     <td width="400"><input type="text" name="ctgNo" value="${prdInfo.ctgNo}"></td>
   </tr>
    <%-- disabled된 상품번호 값을 컨트롤러로 보내기 위한 hidden input --%>
   <input type="hidden" name="prdNo" value="${prdInfo.prdNo}" />
   <tr align="center">
    <td colspan="2" width="400">
       <input type="submit" value="수정하기">
       <input type="reset" value="다시입력">
    </td>
   </tr>
 </table>
</form>
</body>
