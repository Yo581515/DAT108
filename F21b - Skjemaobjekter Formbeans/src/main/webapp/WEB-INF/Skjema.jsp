<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="skjema" method="post">
		Navn <input type="text" name="navn" value="${skjema.navn}" /> 
		${skjema.navnFeilmelding} <br>
		Postnr <input type="text" name="postnr" value="${skjema.postnr}" /> 
		${skjema.postnrFeilmelding} <br>
		<input type="submit" value="Send inn" />
	</form>


</body>
</html>




