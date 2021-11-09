<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<p>
		<font color="red">${loginMessage}</font>
	</p>
	<form action="LoggInnServlet" method="post">
		<fieldset>
			<legend>Login</legend>
			<p>
				Navn: <input type="text" name="brukerNavn" />
			</p>
			<p>
				Passord: <input type="text" name="passOrd" />
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
		<a href="http://localhost:8080/f17pwdWCV/registrer">Registrer her</a>
	</form>
</body>
</html>
