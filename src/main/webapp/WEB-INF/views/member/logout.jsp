<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
</head>
<body>
    <h1>로그아웃</h1>
    
    <%-- 세션에 저장된 사용자 정보 삭제 --%>
    <% session.invalidate(); %>
    
    <p>로그아웃 되었습니다.</p>
    
    <%-- 로그인 페이지로 이동하는 링크 --%>
    <a href="login.jsp">로그인 페이지로 이동</a>
</body>
</html>
