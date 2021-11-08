<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Shop</title>
</head>
<body>
	<p>Du er innlogget som ${username}</p>
	Din handlekurv:
	<br />
	<table border="1">
		<tr>
			<th>Vare</th>
			<th>Pris</th>
		</tr>

		<c:forEach var="item" items="${cart.items}">
		<tr>
			<td>${item.name}</td>
			<td align="right">${item.price}</td>
		</tr>
		</c:forEach>

	</table>
	<br />
	<form action="${WEBSHOP_URL}" method="post">
		<fieldset>
			<legend>Handle</legend>
			<input type="checkbox" name="bukse" />Bukse<br /> <input
				type="checkbox" name="genser" />Genser<br />
			<p>
				<input type="submit" value="Legg i handlekurv" />
			</p>
		</fieldset>
	</form>
	<form action="${LOGOUT_URL}" method="get">
		<fieldset>
			<p>
				<input type="submit" value="Logg ut" />
			</p>
		</fieldset>
	</form>
</body>
</html>
