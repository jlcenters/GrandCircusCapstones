<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<div>
		<%@ include file="partials/post-header.jsp"%>

		<form method="post">

			<label>Task</label> <input type="text" name="descr" required>
			<label>Due Date</label> <input type="date" name="date" required>
			
			<button type="submit">ADD TASK</button>

		</form>

	</div>

</body>
</html>