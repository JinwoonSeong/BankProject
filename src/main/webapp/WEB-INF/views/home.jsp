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
        <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-5">
                <a class="navbar-brand" href="#!">JW은행</a>
                <div>
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">메인페이지</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/mypage">마이페이지</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/accounts">내 계좌</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/transfer">계좌이체</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/accountRegister">계좌 개설</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/savingsAccountRegister">적금</a></li>
                        <li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/loan/apply">대출</a></li>
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
                            <c:if test="${ empty userVO }">
                                <a class="btn btn-primary btn-lg px-4 me-sm-3" href="login">로그인</a>
                                </c:if>
                                <c:if test="${ not empty userVO }">
									<a class="btn btn-primary btn-lg px-4 me-sm-3" href="logout">로그아웃</a>
								</c:if>
                                <a class="btn btn-outline-light btn-lg px-4" href="${ pageContext.request.contextPath }/signup">회원가입</a>
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
                        <h2 class="h4 fw-bolder">마이페이지</h2>
                        <p>내 정보를 보고 수정을 하고 싶다면?</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/mypage">
                            나만의 공간으로 가기!!
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-star"></i></div>
                        <h2 class="h4 fw-bolder">내 계좌</h2>
                        <p>고객님 어서오세요!</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/accounts">
                            내 계좌 확인하러 가기!
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                	<div class="col-lg-4 mb-5 mb-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-wifi"></i></div>
                        <h2 class="h4 fw-bolder">계좌이체</h2>
                        <p>계좌이체하기</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/transfer">
                            빠른 계좌이체
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-collection"></i></div>
                        <h2 class="h4 fw-bolder">계좌 개설</h2>
                        <p>JW은행과 동행해보세요!</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/accountRegister">
                            계좌 개설 하러가기!!
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-building"></i></div>
                        <h2 class="h4 fw-bolder">적금</h2>
                        <p>더 나은 미래를 위한 적금 생활 JW은행의 좋은 상품과 함께 시작해보세요!</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/savingsAccountRegister">
                            적금 하러가기!!
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                    <div class="col-lg-4">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-toggles2"></i></div>
                        <h2 class="h4 fw-bolder">대출</h2>
                        <p>JW은행이 당신의 희망을 이루도록 돕겠습니다! JW은행에 대출 상품을 확인해보세요!</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/loan/apply">
                            대출 하러가기!!
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
                    [${userVO.customer_id} 님으로 로그인중....]
                </c:if>
                <c:if test="${empty userVO}">
                    [로그인이 필요합니다.]
                </c:if>
            </td>
        </tr>
    </table>
</body>
</html>
