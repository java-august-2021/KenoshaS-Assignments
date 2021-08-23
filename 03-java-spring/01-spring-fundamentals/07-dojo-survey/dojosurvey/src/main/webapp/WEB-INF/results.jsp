<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey Results</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<p>Name:<c:out value="${ result.getName() }"/></p>
	<p>Language:<c:out value="${ result.getLanguage() }"/></p>
	<p><strong>Location:</strong><c:out value="${ result.getLocation() }"/></p>
	<p><strong>Comment:</strong><c:out value="${ result.getComment() }"/></p>
</body>
</html>