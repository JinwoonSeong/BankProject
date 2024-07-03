<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Terminate Savings Account</title>
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
                <li class="nav-item"><a class="nav-link" href="mypage">마이페이지</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="accounts">내 계좌</a></li>
                <li class="nav-item"><a class="nav-link" href="transfer">계좌이체</a></li>
                <li class="nav-item"><a class="nav-link" href="account">계좌 개설</a></li>
                <li class="nav-item"><a class="nav-link" href="savings">적금</a></li>
                <li class="nav-item"><a class="nav-link" href="loans">대출</a></li>
            </ul>
        </div>
    </div>
</nav>
<section class="bg-light py-5">
    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <h1 class="fw-bolder">적금 계좌 해지</h1>
            <p class="lead fw-normal text-muted mb-0">적금 계좌를 해지하려면 아래 정보를 입력하세요.</p>
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6 col-xl-4">
                <div class="card mb-5 mb-xl-0">
                    <div class="card-body p-5">
                        <c:if test="${not empty errorMessage}">
                            <p style="color: red;">${errorMessage}</p>
                        </c:if>
                        <form action="${pageContext.request.contextPath}/terminate" method="Post">
                            <input type="hidden" name="accountId" value="${account.savings_account_num}" />
                            <div class="mb-3">
                                <label for="password" class="form-label">비밀번호</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="mb-3">
                                <label for="targetAccountId" class="form-label">이체할 계좌번호</label>
                                <input type="text" class="form-control" id="targetAccountId" name="targetAccountId" required>
                            </div>
                            <button type="submit" class="btn btn-outline-danger">적금 해지</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="py-5 bg-dark">
    <div class="container px-5"><p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p></div>
</footer>
</body>
</html>
