<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Confirm Terminate Savings Account</title>
</head>
<body>
    <h2>Confirm Terminate Savings Account</h2>
    <form action="${pageContext.request.contextPath}/confirmTerminate" method="post">
        <input type="hidden" id="savingsAccountNum" name="savingsAccountNum" value="${account.savings_account_num}" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="transferAccountNum">Transfer Account Number:</label>
        <input type="text" id="transferAccountNum" name="transferAccountNum" required><br>

        <button type="submit">Confirm Terminate</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>
