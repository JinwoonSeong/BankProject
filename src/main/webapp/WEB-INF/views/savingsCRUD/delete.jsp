<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>적금 상품 삭제</title>
</head>
<body>
    <h1>적금 상품 삭제</h1>
    <form action="${pageContext.request.contextPath}/savingsCRUD/delete" method="post">
        <table>
            <tr>
                <td>적금 종류:</td>
                <td><input type="text" name="depositType" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="삭제" /></td>
            </tr>
        </table>
    </form>
    <c:if test="${deleteSuccess}">
        <p>적금 상품이 성공적으로 삭제되었습니다.</p>
    </c:if>
    <c:if test="${deleteFailure}">
        <p>적금 상품 삭제에 실패했습니다. 다시 시도해주세요.</p>
    </c:if>
</body>
</html>
