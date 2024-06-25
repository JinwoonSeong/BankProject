<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/table.css">
<script>
    function checkForm() {
        var customer_id = document.getElementById("id").value;
        var password = document.getElementById("password").value;

        if (customer_id.trim() === '') {
            alert('아이디를 입력하세요.');
            return false;
        }

        if (password.trim() === '') {
            alert('비밀번호를 입력하세요.');
            return false;
        }

        return true;
    }
</script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="${ pageContext.request.contextPath }/">JW은행</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/">메인페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/mypage">마이페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/myaccount">내 계좌</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/accountRegister">계좌 개설</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/savingsAccountRegister">적금</a></li>
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/loans">대출</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${ pageContext.request.contextPath }/manager/login">관리자 로그인</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="py-5">
    <div class="container px-5">
        <div class="text-center mb-5">
            <h2 class="fw-bolder">관리자 로그인</h2>
            <p class="lead mb-0">관리자로 로그인하여 관리 페이지에 접근하세요</p>
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body p-5">
                        <form:form modelAttribute="M" method="post" onsubmit="return checkForm()" name="managerloginForm">
                            <div class="form-floating mb-3">
                                <form:input type="text" id="id" path="id" class="form-control" placeholder="아이디"/>
                                <label for="id">아이디</label>
                            </div>
                            <div class="form-floating mb-3">
                                <form:input type="password" id="password" path="password" class="form-control" placeholder="비밀번호"/>
                                <label for="password">비밀번호</label>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary btn-lg">관리자 로그인</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="py-5 bg-dark">
    <div class="container px-5">
        <p class="m-0 text-center text-white">&copy; 2024 JW은행. All rights reserved.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
