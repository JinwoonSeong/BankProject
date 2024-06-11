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
    <title>대출 신청</title>
</head>
<body>
    <h1>대출 신청</h1>
    <form action="${ pageContext.request.contextPath }/loan/apply" method="post">
        <label for="Loan_num">대출 번호:</label>
        <input type="text" id="Loan_num" name="Loan_num"  value="<%= kr.ac.kopo.account.dao.RandomAccountNumberGenerator.generateRandomAccountNumber() %>" required><br>
        
        <label for="borrower">대출자 명:</label>
        <input type="text" id="borrower" name="borrower" value="<%= userVO.getCustomer_name() %>" required><br>
        
        <label for="loan_type">대출 종류:</label>
        <input type="text" id="loan_type" name="loan_type" required><br>
        
        <label for="customerId">고객 ID:</label>
        <input type="text" id="customerId" name="customerId" value="<%= customerId %>" required><br>

        <label for="accountId">대출받을 계좌번호:</label>
        <input type="text" id="accountId" name="accountId" required><br>

        <label for="amount">대출 금액:</label>
        <input type="number" id="amount" name="amount" required><br>

        <label for="startDate">대출 시작일:</label>
        <input type="date" id="startDate" name="startDate" required><br>

        <label for="endDate">대출 만기일:</label>
        <input type="date" id="endDate" name="endDate" required><br>

        <label for="interestRate">대출 이자율:</label>
        <input type="number" step="0.01" id="interestRate" name="interestRate" required><br>
        
        <label for="Repayment_status">상환여부:</label>
        <input type="number" id="Repayment_status" name="Repayment_status" required><br>
        
        

        <button type="submit">Apply</button>
    </form>
    <form action="${ pageContext.request.contextPath }/loan/view" method="get">
    <input type="hidden" name="customerId" value="id"/>
    <button type="submit">View Loan</button>
</form>
</body>
</html>
