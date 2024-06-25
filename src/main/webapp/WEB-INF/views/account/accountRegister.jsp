<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.member.vo.MemberVO" %>
<%@ page import="kr.ac.kopo.account.dao.RandomAccountNumberGenerator" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>계좌 개설</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
    <script>
        // 비밀번호 유효성을 검사하는 함수
        async function checkPasswordValidity(password) {
            try {
                const response = await fetch('${pageContext.request.contextPath}/checkPassword', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ password: password })
                });
                const result = await response.json();
                if (result.valid) {
                    document.getElementById('passwordMessage').textContent = '비밀번호가 유효합니다.';
                    document.getElementById('passwordMessage').style.color = 'green';
                } else {
                    document.getElementById('passwordMessage').textContent = '비밀번호가 유효하지 않습니다.';
                    document.getElementById('passwordMessage').style.color = 'red';
                }
            } catch (error) {
                console.error('Error:', error);
            }
        }

        // 비밀번호 입력 필드에 이벤트 리스너 추가
        document.addEventListener('DOMContentLoaded', () => {
            const passwordInput = document.getElementById('account_password');
            passwordInput.addEventListener('input', () => {
                const password = passwordInput.value;
                if (password.length === 6) {
                    checkPasswordValidity(password);
                } else {
                    document.getElementById('passwordMessage').textContent = '숫자 6자리로 입력해주세요.';
                    document.getElementById('passwordMessage').style.color = 'red';
                }
            });
        });

        // 약관 동의 체크 확인
        function validateForm() {
            const termsCheckbox = document.getElementById('terms');
            if (!termsCheckbox.checked) {
                alert('약관에 동의하셔야 계좌를 개설할 수 있습니다.');
                return false;
            }
            return true;
        }
        
        function checkDuplicate(field) {
            var value = document.getElementById(field).value;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/checkDuplicate", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var response = JSON.parse(xhr.responseText);
                    if (response.isDuplicate) {
                        document.getElementById(field + "_message").innerText = field + "가 이미 사용 중입니다.";
                        document.getElementById(field + "_message").style.color = "red";
                    } else {
                        document.getElementById(field + "_message").innerText = field + "를 사용할 수 있습니다.";
                        document.getElementById(field + "_message").style.color = "green";
                    }
                }
            };
            xhr.send(field + "=" + value);
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
            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-check-all"></i></div>
            <h2 class="fw-bolder">계좌 등록 폼</h2>
            <% if (request.getAttribute("registerSuccess") != null) { %>
                <p style="color: green;">계좌 개설이 완료되었습니다.</p>
            <% } else if (request.getAttribute("registerFailure") != null) { %>
                <p style="color: red;">계좌 개설에 실패하였습니다.</p>
            <% } %>
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <form action="${pageContext.request.contextPath}/accountRegister" method="post" onsubmit="return validateForm()">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="customer_id" name="customer_id" value="<%= customerId %>" required readonly>
                        <label for="customer_id">고객 ID</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="account_name" name="name" value="<%= userVO.getCustomer_name() %>" required readonly>
                        <label for="account_name">계좌명</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="account_password" name="account_password" required pattern="[0-9]{6}" title="숫자 6자리로 입력해주세요.">
                        <label for="account_password">계좌 비밀번호 [6자리 숫자]</label>
                        <span id="passwordMessage" style="color: red;"></span>
                    </div>
                    <div class="mb-3">
                        <h3>약관 동의</h3>
                        <textarea id="termsText" class="form-control" rows="10" readonly>
본인은 아래의 계좌 개설 약관을 충분히 읽고 이해하였으며, 이에 동의합니다:
1. 계좌 개설 및 사용
✔ 본인은 계좌 개설 신청서를 제출하며, 본인의 개인정보가 계좌 개설 및 관리를 위해 사용됨에 동의합니다.
본인은 본 계좌를 합법적인 용도로만 사용할 것이며, 금융 기관의 모든 규정과 절차를 준수할 것을 약속합니다.

2. 개인정보 처리
✔ 본인은 본인의 개인정보가 계좌 개설 및 관련 서비스 제공을 위해 수집, 이용, 제공될 수 있음에 동의합니다.
✔ 본인은 개인정보 보호법 등 관련 법령에 따라 개인정보의 열람, 정정, 삭제를 요구할 수 있음을 이해합니다.

3. 수수료 및 기타 비용			
✔ 본인은 계좌 사용에 따른 수수료 및 기타 비용이 발생할 수 있으며, 이에 대한 상세 내역은 금융 기관의 수수료 안내를 통해 확인할 수 있음을 이해합니다.
✔ 본인은 수수료 변경 시 금융 기관이 사전에 통지하며, 변경된 수수료에 동의하지 않을 경우 계좌 해지를 요청할 수 있음을 이해합니다.

4. 계좌 관리 및 변경			
✔ 본인은 계좌 정보 변경(주소, 연락처 등) 시 지체 없이 금융 기관에 통지할 것을 약속합니다.
✔ 본인은 금융 기관이 필요 시 계좌 정보를 업데이트하고, 서비스 향상을 위해 계좌 사용 내역을 분석할 수 있음에 동의합니다.

5. 위험 및 책임			
✔ 본인은 계좌 사용 중 발생할 수 있는 모든 손실 및 손해에 대해 금융 기관이 책임지지 않음을 이해하고 동의합니다.
✔ 본인은 금융 기관의 고의 또는 중대한 과실이 아닌 한, 금융 기관이 계좌 사용으로 인해 발생할 수 있는 손실에 대해 책임지지 않음을 동의합니다.

6. 계좌 해지			
✔ 본인은 언제든지 계좌 해지를 요청할 수 있으며, 해지 절차는 금융 기관의 정책에 따를 것을 동의합니다.
✔ 계좌 해지 시 발생할 수 있는 잔여 수수료 및 비용에 대해 이해하고 동의합니다.
본인은 위의 모든 약관을 읽고 이해한 후, 이에 동의하여 계좌를 개설합니다.
                        </textarea>
                        <div class="form-check mt-3">
                            <input class="form-check-input" type="checkbox" id="terms" name="terms" required>
                            <label class="form-check-label" for="terms">약관에 동의합니다</label>
                        </div>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-lg">등록</button>
                    </div>
                </form>
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
