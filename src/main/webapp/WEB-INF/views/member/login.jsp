<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/CSS/home.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/table.css">
<script>
	let checkForm = function() {
		let f = document.loginForm
		let customer_id = f.customer_id
		let password = f.password
		
		if(customer_id.value === '') {
			alert('ID를 입력해주세요')
			customer_id.focus()
			return false
		}
		
		if(password.value === '') {
			alert('패스워드를 입력해주세요')
			password.focus()
			return false
		}
		return true
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
     <section class="bg-light py-5">
            <div class="container px-5 my-5 px-5">
                <div class="text-center mb-5">
                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi-check-all"></i></div>
                    <h2 class="fw-bolder">로그인</h2>
                    <p class="lead mb-0">고객님 어서오세요!</p>
                    </div>
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-6">
                        
                        <form:form modelAttribute="M" method="post" onsubmit="return checkForm()" name="loginForm">
                            
                            <div class="form-floating mb-3">
                                <form:input class="form-control" type="text" name="customer_id" path="customer_id" />
                                <label for="customer_id">아이디</label>
                            </div>
                            
                            <div class="form-floating mb-3">
                                <form:input class="form-control" type="password" name="password" path="password" />
                                <label for="password">비밀번호</label>
                            </div>
                            <div class="d-grid"><button class="btn btn-primary btn-lg"  type="submit">로그인</button></div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
        <footer class="py-5 bg-dark">
            <div class="container px-5"><p class="m-0 text-center text-white">&copy; 2024 Bank. All rights reserved.</p></div>
        </footer>

                            

	<%-- <header>
		<jsp:include page="../include/topMenu.jsp"/>
	</header> --%>
	<%--<section>
<div align="center">
		<hr>
		<h2>로그인</h2>
		<hr>
		<br>
		<form:form modelAttribute="M" method="post" onsubmit="return checkForm()" name="loginForm">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><form:input type="text" name="customer_id" path="customer_id"/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><form:input type="password" name="password" path="password"/></td>
				</tr>
			</table>
			<br>
			<div class="d-grid"><button class="btn btn-primary btn-lg"  type="submit">로그인</button></div>
		</form:form>
	</div>
	</section>--%>
	<footer>
		<strong></strong>
	</footer>
</body>
</html>
