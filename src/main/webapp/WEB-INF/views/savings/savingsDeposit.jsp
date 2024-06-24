<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>적금 입금</title>
</head>
<body>
    <h1>적금 입금</h1>
    <form action="savingsDeposit" method="post">
        <table>
            <tr>
                <td>적금 계좌 번호:</td>
                <td><input type="text" name="savingsAccountNum" /></td>
            </tr>
            <tr>
                <td>입금 금액:</td>
                <td><input type="text" name="amount" /></td>
            </tr>
        </table>
        <input type="submit" value="입금" />
    </form>

    <c:if test="${depositSuccess}">
        <p>적금 입금이 성공했습니다.</p>
    </c:if>
    <c:if test="${depositFailure}">
        <p>적금 입금이 실패했습니다. 다시 시도해주세요.</p>
    </c:if>
</body>
</html>
