<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>거래내역</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="${ pageContext.request.contextPath }/">JW은행</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/">메인페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/mypage">마이페이지</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${ pageContext.request.contextPath }/accounts">내 계좌</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/transfer">계좌이체</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/accountRegister">계좌 개설</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/savingsAccountRegister">적금</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/loan/apply">대출</a></li>
            </ul>
        </div>
    </div>
</nav>
     <section class="bg-light py-5">
    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <h1 class="fw-bolder">거래 내역</h1>
            <p class="lead fw-normal text-muted mb-0">나의 적금 계좌 거래 내역을 확인하세요!</p>
        </div>
        <div class="container px-5 my-5">
            <h2>계좌 정보</h2>
            <table border="1" class="table table-striped">
                <tr>
                    <th>계좌번호</th>
                    <td>${installment_savings.savings_account_num}</td>
                </tr>
                <tr>
                    <th>적금주</th>
                    <td>${installment_savings.customer_id}</td>
                </tr>
                <tr>
                    <th>잔액</th>
                    <td><fmt:formatNumber value="${installment_savings.amount}" type="number" groupingUsed="true" /></td>
                </tr>
            </table>
            
            <h2>거래내역</h2>
            <table border="1" class="table table-striped">
                <thead>
                    <tr>
                        <th>거래유형</th>
                        <th>날짜</th>
                        <th>거래금액</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="transaction" items="${transactions}">
                        <tr>
                            <td>${transaction.transaction_type}</td>
                            <td>${transaction.transactionDate}</td>
                            <td><fmt:formatNumber value="${transaction.amount}" type="number" groupingUsed="true" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<footer class="py-5 bg-dark">
    <div class="container px-5">
        <p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p>
    </div>
</footer>
</body>
</html>
