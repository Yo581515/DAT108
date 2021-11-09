<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brukere</title>
</head>
<body>


	<c:forEach items="${brukerliste}" var="b">
		<p>${b}</p>
	</c:forEach>
</body>
</html>
