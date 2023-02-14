<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<h1>${blogVo.title }</h1>
		<c:choose>
			<c:when test="${empty authUser}">
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<c:if test="${authUser.id == blogVo.id }">
						<li><a href="${pageContext.request.contextPath}/${blogVo.id }/admin/basic">블로그 관리</a></li>
					</c:if>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>