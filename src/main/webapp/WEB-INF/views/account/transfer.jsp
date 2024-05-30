<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.member.vo.MemberVO" %>
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
<meta charset="UTF-8">
<title>계좌 이체</title>
</head>
<body>
    <h2>계좌 이체</h2>
    
    <%-- 계좌 이체 양식 --%>
    <form action="${pageContext.request.contextPath}/transfer" method="post" enctype="application/x-www-form-urlencoded">
        <label for="fromAccount">보내는 계좌:</label>
        <input type="text" id="from_Account" name="from_Account" required><br><br>
        
        <label for="toAccount">받는 계좌:</label>
        <input type="text" id="to_Account" name="to_Account" required><br><br>
        
        <label for="amount">이체 금액:</label>
        <input type="number" id="amount" name="amount" required><br><br>
        
        <button type="submit">이체</button>
    </form>
</body>
</html>
