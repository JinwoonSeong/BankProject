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
<meta charset="UTF-8">
<title>회원정보 수정하기</title>
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
                        <li class="nav-item"><a class="nav-link" href="account.jsp">계좌 개설</a></li>
                        <li class="nav-item"><a class="nav-link" href="savings.jsp">적금</a></li>
                        <li class="nav-item"><a class="nav-link" href="loans.jsp">대출</a></li>
                    </ul>
                </div>
            </div>
     </nav>
    <section class="bg-light py-5">
            <div class="container px-5 my-5 px-5">
                <div class="text-center mb-5">
                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-hammer"></i></div>
                    <h2 class="fw-bolder">회원정보 수정</h2>
                    <p class="lead mb-0">고객님의 정보를 수정하세요!</p>
                    </div>
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-6">
                        
                        <form action="${pageContext.request.contextPath}/member/update" method="post" onsubmit="return validateForm()" id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="customer_id" name="customer_id" value="<%= customerId %>" required pattern="[a-zA-Z0-9]+" title="아이디는 영문자와 숫자로만 입력해주세요." />
                                <label for="customer_id">고객님의 아이디</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="customer_name" name="customer_name"  value="<%= userVO.getCustomer_name() %>" required pattern="[가-힣]+" title="이름은 한글로만 입력해주세요." />
                                <label for="name">고객님의 이름</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" ype="email" id="email" name="email" required />
                                <label for="email">수정할 이메일</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="phone_number" name="phone_number" required pattern="010-\d{4}-\d{4}" title="연락처는 010-숫자4자리-숫자4자리 형식으로 입력해주세요." />
                                <label for="phone">수정할 전화번호</label>
                                <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                            </div>
                            
                            <div class="form-floating mb-3">
                                <input class="form-control" type="text" id="address" name="address" pattern=".*\S.*">
                                <label for="address">수정할 주소</label>
                            </div>
                            
                            <div class="form-floating mb-3">
                                <input class="form-control" type="password" id="password" name="password" required pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$" title="비밀번호는 영문자, 숫자, 특수 문자의 조합으로 8글자에서 15글자로 입력해주세요." />
                                <label for="password">수정할 비밀번호</label>
                            </div>
                            <div class="d-grid"><button class="btn btn-primary btn-lg"  type="submit">수정하기</button></div>
                        </forㅡ>
                    </div>
                </div>
            </div>
        </section> 
<script>
    function validatePassword() {
        var passwordInput = document.getElementById("password");
        var password = passwordInput.value;
        var passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$/;

        if (!passwordRegex.test(password)) {
            alert("비밀번호는 영문자, 숫자, 특수 문자의 조합으로 8글자에서 15글자로 입력해주세요.");
            passwordInput.value = "";
            passwordInput.focus();
            return false;
        }
        return true;
    }
   

    function validatePhone() {
        var phoneInput = document.getElementById("phone");
        var phone = phoneInput.value;
        var phoneRegex = /^010-\d{4}-\d{4}$/;

        if (!phoneRegex.test(phone)) {
            alert("유효하지 않은 번호입니다.");
            phoneInput.value = "";
            phoneInput.focus();
            return false;
        }
        return true;
    }

    function validateEmail() {
        var emailInput = document.getElementById("email");
        var email = emailInput.value;
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailRegex.test(email)) {
            alert("유효한 이메일 주소를 입력하세요.");
            emailInput.value = "";
            emailInput.focus();
            return false;
        }
        return true;
    }

    function validateForm() {
        return  validatePassword() && validatePhone() && validateEmail();
    }
</script>
                            

</body>
</html>