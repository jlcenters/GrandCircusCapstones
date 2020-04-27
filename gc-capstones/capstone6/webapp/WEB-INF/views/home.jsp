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

		<nav class="navbar navbar-expand-lg">

			<ul class="navbar-nav ml-auto">

				<li class="nav-item"><a href="/tasks?userId=${userId}"
					class="nav-link">My Tasks</a></li>
				<li class="nav-item"><a href="/" class="nav-link">Logout</a></li>

			</ul>

		</nav>
		<h2>${message}</h2>
		<a href="/add?userId=${userId}">Add a task</a>
		<table class="table table-striped">

			<tr>

				<th>Due Date</th>
				<th>Due By</th>
				<th>Description</th>
			</tr>
			<c:forEach var="task" items="${tasks}">

				<tr>

					<td>${task.date}</td>
					<td>${task.user.username}</td>
					<td>${task.description}</td>

				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>