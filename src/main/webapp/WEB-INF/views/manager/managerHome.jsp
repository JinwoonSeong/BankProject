<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JW은행</title>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/home.css">
</head>
<body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-5">
            <a class="navbar-brand" href="#!">JW은행</a>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/managerLogin">관리자 로그인</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">메인페이지</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/myaccount">내 계좌</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accountRegister">계좌 개설</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/savingsAccountRegister">적금</a></li>
                    <li class="nav-item"><a class="nav-link" href="loans.jsp">대출</a></li>
                    <c:if test="${not empty userVO}">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manager/logout">로그아웃</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Header-->
    <header class="bg-dark py-5">
        <div class="container px-5">
            <div class="row gx-5 justify-content-center">
                <div class="col-lg-6">
                    <div class="text-center my-5">
                        <h1 class="display-5 fw-bolder text-white mb-2">JW은행에 돈을 바쳐라 다 내꺼</h1>
                        <p class="lead text-white-50 mb-4">인터넷 뱅킹은 JW은행과 함께 하세요!!</p>
                        <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                            <c:if test="${empty userVO}">
                                <a class="btn btn-primary btn-lg px-4 me-sm-3" href="login">로그인</a>
                                <a class="btn btn-outline-light btn-lg px-4" href="${pageContext.request.contextPath}/signup">회원가입</a>
                            </c:if>
                            <c:if test="${not empty userVO}">
                                <a class="btn btn-primary btn-lg px-4 me-sm-3" href="${pageContext.request.contextPath}/manager/logout">로그아웃</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Features section-->
    <section class="py-5 border-bottom" id="features">
        <div class="container px-5 my-5">
            <div class="row gx-5">
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-house"></i></div>
                    <h2 class="h4 fw-bolder">회원 정보 조회</h2>
                    <a class="text-decoration-none" href="${pageContext.request.contextPath}/manager/listAccounts">
                        회원 정보 조회하기
                        <i class="bi bi-arrow-right"></i>
                    </a>
                </div>
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-star"></i></div>
                    <h2 class="h4 fw-bolder">상품 설정</h2>
                    <p>상품 추가, 수정 및 삭제</p>
                    <a class="text-decoration-none" href="${pageContext.request.contextPath}/manager/updateFI">
                        업무 보러가기!!
                        <i class="bi bi-arrow-right"></i>
                    </a>
                </div>
            </div>
        </div>
    </section>
    <footer class="py-5 bg-dark">
        <div class="container px-5"><p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p></div>
    </footer>
    <table>
        <tr>
            <!-- Existing table content -->
            <td align="right">
                <c:if test="${not empty userVO}">
                    [${userVO.id} 님으로 로그인중....]
                </c:if>
                <c:if test="${empty userVO}">
                    [로그인이 필요합니다.]
                </c:if>
            </td>
        </tr>
    </table>
</body>
</html>
