<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<nav>
			<h3><a href="/">Products</a> | <a href="/categories">Categories</a></h3>
		</nav>
		<h2>All Products</h2>
		<ul>
		<c:forEach items="${ products }" var="prod">
			<li><a href="/${ prod.id }">${ prod.name }</a></li>		
		</c:forEach>
		</ul>
	</div>

</body>
</html>