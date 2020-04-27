<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM</title>
</head>
<body>
<h1></h1>
	<form action="/mileage-result">
		<p>
			<label>Gallons</label> <input type="text" name="gallons" />
		</p>
		<p>
			<label>Mileage</label> <input type="text" name="mpg" />
		</p>
		<p>
			<button type="submit">CALCULATE</button>
		</p>
	</form>
</body>
</html>