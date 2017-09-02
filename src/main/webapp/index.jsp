<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<h1 align = center>
		<c:set var="name" scope = "session" value="${requestScope.name}"/>
		<c:choose>
			<c:when test="${empty name or name.length() ==0}">
				Hello, world !
			</c:when>
			<c:otherwise>
				Hello, world ! I'm
				<c:out value = "${name}"/>
			</c:otherwise>
		</c:choose>
	</h1>
	<p align = 'center'>
		<Img src="images/ico.gif">
	</p>
</body>
</html>