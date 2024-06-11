<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>대출 신청 결과</title>
</head>
<body>
    <h1>대출 신청 결과</h1>
    <c:if test="${applySuccess}">
        <p>대출 신청 완료!!</p>
    </c:if>
    <c:if test="${applyFailure}">
        <p>대출 신청 실패!! 다시 시도 해주세요.</p>
    </c:if>
    <a href="${ pageContext.request.contextPath }/loan/apply">대출 신청 페이지로 돌아가기</a>
</body>
</html>
