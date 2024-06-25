<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Terminate Savings Account</title>
</head>
<body>
    <h2>Terminate Savings Account</h2>
    <form action="${pageContext.request.contextPath}/terminate" method="post">
        <input type="hidden" id="savingsAccountNum" name="savingsAccountNum" value="${account.savings_account_num}" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <button type="submit">Terminate Account</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>




