<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrer</title>
</head>
<body>
	<p>
		<font color="red">${loginMessage}</font>
	</p>
	<form action="registrer" method="post">
		<fieldset>
			<legend>Registrer</legend>
			<p>
				Navn: <input type="text" name="brukerNavn" />
			</p>
			<p>
				Passord: <input type="text" name="passOrd" />
			</p>
			<p>
				<input type="submit" value="Registrer" />
			</p>
		</fieldset>
	</form>
</body>
</html>