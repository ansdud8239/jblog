<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
//<c:set var="newline" value="\n"/>
//위 코드를 대체하기 위해 자바코드 구현
pageContext.setAttribute("newline", "\n");
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/blog/includes/hearder.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${map.postvo.title }</h4>
					<p>
						${fn:replace(map.postvo.contents,newline,"<br>") }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${map.postlist }" var="vo">
					<li><a href="${pageContext.request.contextPath}/${id}/${vo.categoryNo}/${vo.no}">${vo.title }</a> <span>${vo.regDate }</span>	</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${map.blogVo.profile }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
			<c:forEach items="${map.list }" var="vo">
				<li><a href="${pageContext.request.contextPath}/${id}/${vo.no}">${vo.name }</a></li>
			</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>