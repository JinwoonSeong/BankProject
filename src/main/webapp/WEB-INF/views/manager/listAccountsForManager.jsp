<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>내 계좌</title>
</head>
<body>
    <h1>내 계좌 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>계좌번호</th>
                <th>예금주</th>
                <th>잔액</th>
                <th>거래내역</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.account_num}</td>
                    <td>${account.name}</td>
                    <td>${account.account_money}</td>
                    <td><a href="${pageContext.request.contextPath}/account/${account.account_num}">View Details</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
