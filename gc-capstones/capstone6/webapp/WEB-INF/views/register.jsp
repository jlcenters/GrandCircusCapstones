<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<div>
		<h3>${message}</h3>
		<form method="post">

			<label>Name</label> <input type="text" name="user" required>
			<label>Password</label> <input type="password" name="pass1" required>
			<label>Re-enter Password</label> <input type="password" name="pass2"
				required>
			<button type="submit">REGISTER</button>

		</form>
		<a type=btn href="/">Go Back</a>
	</div>

</body>
</html>