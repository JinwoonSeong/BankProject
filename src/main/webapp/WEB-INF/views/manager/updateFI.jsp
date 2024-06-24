<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>적금 상품 관리</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">적금 상품 관리</h1>
        <a href="${pageContext.request.contextPath}/savingsCRUD/add" class="btn btn-primary">적금 상품 추가</a>
        <a href="${pageContext.request.contextPath}/savingsCRUD/edit" class="btn btn-warning">적금 상품 수정</a>
        <a href="${pageContext.request.contextPath}/savingsCRUD/delete" class="btn btn-danger">적금 상품 삭제</a>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
