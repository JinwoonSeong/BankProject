<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>계좌 해지 확인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/home.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">JW은행</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">메인페이지</a></li>
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
            <h1 class="fw-bolder">계좌 해지 확인</h1>
            <p class="lead fw-normal text-muted mb-0">계좌에 잔액이 남아 있습니다. 그래도 해지하시겠습니까? 계속 진행 시 계좌에 남아있던 모든 돈은 JW은행으로 귀속됩니다.</p>
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <div class="card mb-5">
                    <div class="card-body p-5">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">
                                ${error}
                            </div>
                        </c:if>
                        <form action="${pageContext.request.contextPath}/confirmClose" method="Get">
                            <input type="hidden" name="accountId" value="${account.account_num}">
                            <div class="mb-3">
                                <label for="password" class="form-label">비밀번호</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-danger">계속 진행</button>
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
