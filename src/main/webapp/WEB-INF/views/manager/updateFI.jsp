<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>적금 상품 관리</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/home.css">
    <style>
        body, html {
            height: 100%;
        }
        .content {
            min-height: calc(100vh - 100px);
            /* 100px is an approximate height for the footer */
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        h1 {
            color: #343a40;
            text-align: center;
            margin-bottom: 2rem;
        }
        .btn-group-vertical {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .btn-group-vertical .btn {
            width: 200px;
            margin-bottom: 1rem;
        }
        footer {
            height: 100px;
        }
    </style>
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
<div class="content container mt-5">
    <h1 class="mb-4">적금 상품 관리</h1>
    <div class="btn-group-vertical">
        <a href="${pageContext.request.contextPath}/savingsCRUD/add" class="btn btn-primary btn-lg">적금 상품 추가</a>
        <a href="${pageContext.request.contextPath}/savingsCRUD/edit" class="btn btn-warning btn-lg">적금 상품 수정</a>
        <a href="${pageContext.request.contextPath}/savingsCRUD/delete" class="btn btn-danger btn-lg">적금 상품 삭제</a>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<footer class="py-5 bg-dark mt-auto">
    <div class="container px-5">
        <p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p>
    </div>
</footer>
</body>
</html>
