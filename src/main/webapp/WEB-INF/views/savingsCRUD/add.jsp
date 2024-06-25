<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>적금 상품 추가</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/home.css">
    <style>
        body, html {
            height: 100%;
        }
        .main-content {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: calc(100vh - 100px); /* 100px is the approximate height for the footer */
        }
        footer {
            height: 100px;
        }
    </style>
    <script>
        function validateProductNumber() {
            var productNumber = document.getElementById("product_number").value;
            var productNumberMessage = document.getElementById("productNumberMessage");

            if (/^\d{2}$/.test(productNumber)) {
                productNumberMessage.textContent = "유효한 상품 코드입니다.";
                productNumberMessage.style.color = "green";
                return true;
            } else {
                productNumberMessage.textContent = "상품 코드는 숫자 2자리여야 합니다.";
                productNumberMessage.style.color = "red";
                return false;
            }
        }

        function validateForm() {
            return validateProductNumber();
        }

        document.addEventListener('DOMContentLoaded', () => {
            document.getElementById("product_number").addEventListener("input", validateProductNumber);
        });
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="#!">JW은행</a>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/managerLogin">관리자 로그인</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manager/managerHome">메인페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manager/listAccountsForManager">회원정보조회</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/manager/updateFI">상품 설정</a></li>
                <c:if test="${not empty userVO}">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manager/logout">로그아웃</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="main-content">
    <div class="container mt-5">
        <h1 class="mb-4">적금 상품 추가</h1>
        <form:form modelAttribute="savingsAccount" method="post" onsubmit="return validateForm()">
            <div class="mb-3">
                <label for="deposit_type" class="form-label">적금 종류:</label>
                <form:input path="deposit_type" id="deposit_type" class="form-control" />
            </div>
            <div class="mb-3">
                <label for="interest_rate" class="form-label">이자율:</label>
                <form:input path="interest_rate" id="interest_rate" class="form-control" />
            </div>
            <div class="mb-3">
                <label for="product_number" class="form-label">상품코드:</label>
                <form:input path="product_number" id="product_number" class="form-control" />
                <span id="productNumberMessage" class="form-text"></span>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-lg">추가</button>
            </div>
        </form:form>
        <c:if test="${addSuccess}">
            <p class="text-success mt-3">적금 상품이 성공적으로 추가되었습니다.</p>
        </c:if>
        <c:if test="${addFailure}">
            <p class="text-danger mt-3">적금 상품 추가에 실패했습니다. 다시 시도해주세요.</p>
        </c:if>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<footer class="py-5 bg-dark">
    <div class="container px-5">
        <p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p>
    </div>
</footer>
</body>
</html>
