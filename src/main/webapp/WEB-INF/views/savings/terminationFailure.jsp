<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>적금 해지 실패</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="${ pageContext.request.contextPath }/">JW은행</a>
        <!-- 네비게이션 바 생략 -->
    </div>
</nav>
<section class="bg-light py-5">
    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <h1 class="fw-bolder">적금 해지 실패</h1>
            <p class="lead fw-normal text-muted mb-0">${errorMessage}</p>
            <a href="${pageContext.request.contextPath}/savigsaccounts" class="btn btn-primary mt-4">내 적금 계좌로 돌아가기</a>
        </div>
    </div>
</section>
<footer class="py-5 bg-dark">
    <div class="container px-5"><p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p></div>
</footer>
</body>
</html>
