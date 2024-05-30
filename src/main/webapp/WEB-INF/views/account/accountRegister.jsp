<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.member.vo.MemberVO" %>
<%@ page import="kr.ac.kopo.account.dao.RandomAccountNumberGenerator" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
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
    <title>계좌 등록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h2>계좌 등록 폼</h2>
     <% if (request.getAttribute("registerSuccess") != null) { %>
    <p style="color: green;">계좌 개설이 완료되었습니다.</p>
		<% } else if (request.getAttribute("registerFailure") != null) { %>
    <p style="color: red;">계좌 개설에 실패하였습니다.</p>
		<% } %>

    <form action="${pageContext.request.contextPath}/accountRegister" method="post">
        <div>
    		<label for="account_num">계좌 번호:</label>
    		<input type="text" id="account_num" name="account_num" value="<%= kr.ac.kopo.account.dao.RandomAccountNumberGenerator.generateRandomAccountNumber() %>" required readonly>
		</div>

        <div>
		    <label for="customer_id">고객 ID:</label>
		    <!-- 세션에서 가져온 고객 ID를 입력 필드에 자동으로 채워넣기 -->
		    <input type="text" id="customer_id" name="customer_id" value="<%= customerId %>" required readonly>
		</div>

        <div>
            <label for="account_name">계좌명:</label>
            <!-- 계좌명 입력 필드를 비활성화 -->
            <input type="text" id="account_name" name="name" value="<%= userVO.getCustomer_name() %>" required readonly>
        </div>
        <div>
            <label for="account_password">계좌 비밀번호:</label> 
			<input type="password" id="account_password" name="account_password" required pattern="[0-9]{6}" title="숫자 6자리로 입력해주세요."> [6자리 숫자]
        </div>
        <button type="submit">등록</button>
    </form>
</body>
</html>
