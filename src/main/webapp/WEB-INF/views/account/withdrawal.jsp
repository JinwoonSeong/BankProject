<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>출금</title>
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
                        <li class="nav-item"><a class="nav-link" href="accounts">내 계좌</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="transfer">계좌이체</a></li>
                        <li class="nav-item"><a class="nav-link" href="account">계좌 개설</a></li>
                        <li class="nav-item"><a class="nav-link" href="savings">적금</a></li>
                        <li class="nav-item"><a class="nav-link" href="loans">대출</a></li>
                    </ul>
                </div>
            </div>
     </nav>
     <section class="bg-light py-5">
    <div class="container px-5 my-5 px-5">
        <div class="text-center mb-5">
            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-controller"></i></div>
            <h2 class="fw-bolder">출금</h2>
            <p class="lead mb-0">피같은 내돈.. 꼭 다시 데려올게!!</p>
        </div>
        
        <!-- 출금 성공 및 실패 메시지 -->
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <c:if test="${not empty successMessage}">
                    <p style="color:green; text-align: center;">${successMessage}</p>
                </c:if>
                <c:if test="${not empty errorMessage}">
                    <p style="color:red; text-align: center;">${errorMessage}</p>
                </c:if>
            </div>
        </div>

        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <!-- 출금 폼 -->
                <form action="${pageContext.request.contextPath}/withdrawal" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return checkForm()" name="withdrawalForm">
                    <div class="form-floating mb-3">
                        <input class="form-control" type="text" id="accountId" name="accountId" required />
                        <label for="accountId">출금할 계좌 번호</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input class="form-control" type="password" id="password" name="password" required />
                        <label for="password">계좌 비밀 번호</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input class="form-control" type="number" id="amount" name="amount" required min="0" />
                        <label for="amount">출금할 금액</label>
                    </div>

                    <div class="d-grid"><button class="btn btn-primary btn-lg" type="submit">출금</button></div>
                </form>
            </div>
        </div>
    </div>
</section>
    <footer class="py-5 bg-dark">
            <div class="container px-5"><p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p></div>
        </footer>
</body>
</html>
