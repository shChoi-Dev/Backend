<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문 내역</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />
    <section>
        <h3>주문 내역</h3>
        <table border="1" width="900">
            <tr>
                <th>주문 번호</th>
                <th>주문 날짜</th>
                <th>받는 사람</th>
                <th>결제 수단</th>
            </tr>
            <c:choose>
                <c:when test="${empty orderList}">
                    <tr>
                        <td colspan="4">주문 내역이 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="order" items="${orderList}">
                        <tr>
                            <td>${order.ordNo}</td>
                            <td><fmt:formatDate value="${order.ordDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                            <td>${order.ordRcvReceiver}</td>
                            <td>${order.ordPay}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
    </section>
    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>