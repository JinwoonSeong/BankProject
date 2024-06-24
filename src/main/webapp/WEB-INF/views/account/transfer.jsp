<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.member.vo.MemberVO" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<meta charset="UTF-8">
<title>계좌 이체</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
<script>
    // transfer.js (or wherever your JavaScript code resides)

    function checkAccountPassword(accountNum, accountPassword) {
        fetch('${pageContext.request.contextPath}/checkAccountPassword', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ accountNum: accountNum, accountPassword: accountPassword })
        })
        .then(response => response.json())
        .then(data => {
            if (data.valid) {
                // 계좌 비밀번호 일치 시 이체 처리
                // 이 곳에 이체 처리 로직 추가
            } else {
                // 계좌 비밀번호 불일치 시 처리
                alert('보내는 계좌의 비밀번호가 일치하지 않습니다.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    // 이체 버튼 클릭 이벤트 핸들러
    document.getElementById('transferButton').addEventListener('click', function() {
        var fromAccount = document.getElementById('from_Account').value;
        var toAccount = document.getElementById('to_Account').value;
        var amount = document.getElementById('amount').value;
        var depositorName = document.getElementById('depositorName').value;
        var fromAccountPassword = document.getElementById('from_Account_Password').value;

        // 보내는 계좌의 비밀번호 확인
        checkAccountPassword(fromAccount, fromAccountPassword);
    });
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
                    <h2 class="fw-bolder">계좌이체</h2>
                    <p class="lead mb-0">현명한 돈거래의 시작 JW은행!</p>
                    </div>
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-6">
                        
                        <form modelAttribute="M" action="${pageContext.request.contextPath}/transfer" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return checkForm()" name="transferForm">
                            
                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="from_Account" name="from_Account" path="from_Account" required />
                                <label for="from_Account">보내는 계좌</label>
                            </div>
                            
                            <div class="form-floating mb-3">
                                <input class="form-control" type="password" id="from_Account_Password" name="fromAccountPassword" path="fromAccountPassword" required />
                                <label for="fromAccountPassword">보내는 계좌 비밀번호</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="to_Account" name="to_Account" path="to_Account" required />
                                <label for="to_Account">받는계좌</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input class="form-control" type="number" id="amount" name="amount" path="amount" required />
                                <label for="amount">이체 금액</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="depositorName" name="depositorName" path="depositorName" required />
                                <label for="depositorName">입금자 명</label>
                            </div>
                            <div class="d-grid"><button class="btn btn-primary btn-lg"  type="submit">이체</button></div>
                        </form>
                    </div>
                </div>
            </div>
             <section class="py-5 border-bottom" id="features">
            <div class="container px-5 my-5">
                <div class="row gx-5">
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-shield-fill"></i></div>
                        <h2 class="h4 fw-bolder">출금</h2>
                        <p>돈 뽑으러가기!!</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/withdrawal">
                            출금 하러가기!!
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                    <div class="col-lg-4">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-trophy"></i></div>
                        <h2 class="h4 fw-bolder">입금</h2>
                        <p>돈 넣으러 가기!!</p>
                        <a class="text-decoration-none" href="${ pageContext.request.contextPath }/deposit">
                            입금 하러가기!!
                            <i class="bi bi-arrow-right"></i>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        </section>
        <footer class="py-5 bg-dark">
            <div class="container px-5"><p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p></div>
        </footer>
</body>
</html>
