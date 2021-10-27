<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meldinger</title>
</head>
<body>
    <h2>Meldinger</h2>

	<c:forEach items="${meldinger}" var="m">
        <p><b>(#${m.id})
            ${m.formatertTidsstempel} skrev
            <c:out value="${m.avsender}"/>:</b></p>
            <blockquote><i><c:out value="${m.tekst}" /></i></blockquote>
	</c:forEach>
    
    <form method="post">
        <fieldset><legend>Ny melding</legend>
        <p>Skriv melding:<br />
        <textarea name="melding" rows="2" cols="45"></textarea></p>
        <p>Avsender:<br />
        <input type="text" name="avsender" />
        <input type="submit" value="Send melding" />
        <input type="reset" value="Nullstill" /></p>
        </fieldset>
    </form>
</body>
</html>
