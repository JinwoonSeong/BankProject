<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<table border="1" style="width:100%" class="topMenu">
	<tr>
		<td rowspan="2" style="width:150px; height: 45px;">
			<a href="${ pageContext.request.contextPath }">
			<img src="${ pageContext.request.contextPath }/resources/images/logo.png"
				 style="width: 150px; heigth: 45px;">
			</a>
		</td>
		<td align="right">
			<c:if test="${ not empty userVO }">
			[${ userVO.name } 님으로 로그인중....]
			</c:if>
			<c:if test="${empty userVO} }">
			[로그인이 필요합니다.]
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<nav>
				<c:if test="${ userVO.type eq  'S' }">
				회원관리 |
				</c:if>
				<a href="${ pageContext.request.contextPath }/board">게시판</a> |
				<c:choose>
					<c:when test="${ empty userVO }">
				회원가입 |
				<a href="${ pageContext.request.contextPath }/login">로그인</a> |
				</c:when>
				<c:otherwise>
				마이페이지 |
				<a href="${ pageContext.request.contextPath}/logout">로그아웃</a>	|
				</c:otherwise>
				</c:choose>
			</nav>
		</td>
	</tr>
</table>