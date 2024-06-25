<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>적금 계좌 개설 성공</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/home.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.5rem;
        }
        h2 {
            margin-top: 20px;
            color: #343a40;
            text-align: center;
        }
        .content {
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .content p {
            font-size: 1.1rem;
            color: #495057;
        }
        .btn-custom {
            display: block;
            width: 100%;
            margin-top: 20px;
            background-color: #343a40;
            color: white;
            border: none;
            padding: 10px;
            font-size: 1.1rem;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .btn-custom:hover {
            background-color: #495057;
        }
        footer {
            margin-top: 40px;
        }
        .footer-text {
            color: white;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">JW은행</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">메인페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accounts">내 계좌</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/transfer">계좌이체</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accountRegister">계좌 개설</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/savingsAccountRegister">적금</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/loan/apply">대출</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="content">
    <h2>적금 계좌 개설 성공</h2>
    <p>계좌 번호: ${accountNumber}</p>
    <p>적금액: ${amount}</p>
    <p>만기일자: 5년 뒤</p>
    <p>이자율: ${interestRate}%</p>
    <form action="${pageContext.request.contextPath}/" method="get">
        <button type="submit" class="btn-custom">확인</button>
    </form>
</div>

<footer class="py-5 bg-dark">
    <div class="container px-5">
        <p class="m-0 text-center footer-text">&copy; 2024 Bank. All rights reserved.</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
