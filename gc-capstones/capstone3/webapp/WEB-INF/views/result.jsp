<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESULT</title>
</head>
<body>
	<br>
	<h1>${gallons} * ${mpg} = ${result} miles remaining.</h1>
	<br>
	<br>
	<a href="/mileage-form" target="_blank">CALCULATE ANOTHER VEHICLE</a>
	<a href="/">HOME</a>
</body>
</html>