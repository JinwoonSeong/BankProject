<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kr.ac.kopo.member.vo.MemberVO" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="kr.ac.kopo.account.dao.RandomAccountNumberGenerator" %>
    <%
    // 로그인 여부 확인
    MemberVO userVO = (MemberVO) session.getAttribute("userVO");
    String customerId = null;
    if (userVO != null) {
        customerId = userVO.getCustomer_id();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>회원 탈퇴</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-5">
                <a class="navbar-brand" href="${ pageContext.request.contextPath }/">JW은행</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/">메인페이지</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="mypage">마이페이지</a></li>
                        <li class="nav-item"><a class="nav-link" href="myaccount.jsp">내 계좌</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/transfer">계좌이체</a></li>
                        <li class="nav-item"><a class="nav-link" href="account.jsp">계좌 개설</a></li>
                        <li class="nav-item"><a class="nav-link" href="savings.jsp">적금</a></li>
                        <li class="nav-item"><a class="nav-link" href="loans.jsp">대출</a></li>
                    </ul>
                </div>
            </div>
     </nav>
     <section class="bg-light py-5">
    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-emoji-angry-fill"></i></div>
            <h2 class="fw-bolder">회원탈퇴</h2>
            <p class="lead mb-0">진짜 탈퇴할려고? 왜??</p>
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <form modelAttribute="member" method="post" action="${pageContext.request.contextPath}/deleteAccount" onsubmit="return checkForm()" name="deleteAccountForm">
                    <div class="form-floating mb-3">
                        <input class="form-control" type="text" id="userId" name="userId" path="userId" value="<%= customerId %>" required />
                        <label for="customer_id">아이디</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input class="form-control" type="password" id="password" name="password" path="password" required />
                        <label for="password">비밀번호</label>
                    </div>
                    <div class="d-grid">
                        <button class="btn btn-primary btn-lg" type="submit">회원 탈퇴</button>
                    </div>
                </form>
                <c:if test="${not empty successMessage}">
                    <p style="color:green;">${successMessage}</p>
                </c:if>
                <c:if test="${not empty errorMessage}">
                    <p style="color:red;">${errorMessage}</p>
                </c:if>
            </div>
        </div>
    </div>
</section>
<footer class="py-5 bg-dark">
    <div class="container px-5">
        <p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p>
    </div>
</footer>
    <!--<h1>회원 탈퇴</h1>
    <form action="${ pageContext.request.contextPath }/deleteAccount" method="post">
        <label for="userId">ID:</label>
        <input type="text" id="userId" name="userId" value="<%= customerId %>" required><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Delete Account">
    </form>
    
    <c:if test="${not empty successMessage}">
        <p style="color:green;">${successMessage}</p>
    </c:if>
    
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if> -->
</body>
</html>
