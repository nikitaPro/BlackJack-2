<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style>
   body {
    background: url(images/ship_long.png) repeat-x 0 100% fixed,
                linear-gradient(to top, #5080b1, #004e8c) fixed;
    animation: city 30s linear infinite;
    -webkit-animation: city 60s linear infinite;
   }
   @keyframes city {
    from { background-position: -1300px 100%, 0 0;}
    to { background-position: 0 100%, 0 0; }
   }
   @-webkit-keyframes city {
    from { background-position: -1300px 100%, 0 0;}
    to { background-position: 0 100%, 0 0; }
   }
   main {
    width: 50%;
    min-height: 411px;
    display: block;
    margin: auto;
    background: rgba(255,255,255,0.6);
    padding: 20px;
   }
  </style>
<title>Hello</title>
</head>
<body>
<audio src="audio/piraty-karibskogo-morya--original.mp3" autoplay>
  Your browser does not support the <code>audio</code> element.
</audio>
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