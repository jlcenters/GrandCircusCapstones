<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Manager</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<%@ include file="partials/pre-header.jsp"%>
	<div>

		<h1>Task Manager</h1>

		<p>${loginPrompt}</p>

		<form method="post">

			<p>${message }</p>
			<label>Name</label> <input type="text" name="user" required>
			<label>Password</label> <input type="password" name="pass" required>
			<button type="submit">LOG IN</button>
		</form>

	</div>

</body>
</html>