<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>계좌 개설 성공</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
    <script>
        function goHome() {
            window.location.href = "${pageContext.request.contextPath}/";
        }
    </script>
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
                <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/transfer">계좌이체</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="account">계좌 개설</a></li>
                <li class="nav-item"><a class="nav-link" href="savings.jsp">적금</a></li>
                <li class="nav-item"><a class="nav-link" href="loans.jsp">대출</a></li>
            </ul>
        </div>
    </div>
</nav>
<section class="bg-light py-5">
    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-check-circle-fill"></i></div>
            <h2 class="fw-bolder">계좌 개설 성공</h2>
            <p class="lead mb-0">축하합니다! 계좌가 성공적으로 개설되었습니다.</p>
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body p-5 text-center">
                        <h3 class="card-title mb-3">계좌 번호</h3>
                        <p class="card-text display-4">${accountNumber}</p>
                        <button class="btn btn-primary btn-lg mt-3" onclick="goHome()">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="py-5 bg-dark">
    <div class="container px-5">
        <p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
