<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>적금 상품 추가</title>
</head>
<body>
    <h1>적금 상품 추가</h1>
    <form:form modelAttribute="savingsAccount" method="post" action="${pageContext.request.contextPath}/savingsCRUD/add">
        <table>
            <tr>
                <td>계좌 번호:</td>
                <td><form:input path="savings_account_num" /></td>
            </tr>
            <tr>
                <td>고객 ID:</td>
                <td><form:input path="customer_id" /></td>
            </tr>
            <tr>
                <td>계좌 소유자:</td>
                <td><form:input path="account_holder" /></td>
            </tr>
            <tr>
                <td>적금 종류:</td>
                <td><form:input path="deposit_type" /></td>
            </tr>
            <tr>
                <td>금액:</td>
                <td><form:input path="amount" /></td>
            </tr>
            <tr>
                <td>이자율:</td>
                <td><form:input path="interest_rate" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="추가" /></td>
            </tr>
        </table>
    </form:form>
    <c:if test="${addSuccess}">
        <p>적금 상품이 성공적으로 추가되었습니다.</p>
    </c:if>
    <c:if test="${addFailure}">
        <p>적금 상품 추가에 실패했습니다. 다시 시도해주세요.</p>
    </c:if>
</body>
</html>
