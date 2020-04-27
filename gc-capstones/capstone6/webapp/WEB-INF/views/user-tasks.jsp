<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Tasks</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<div>

		<nav class="navbar navbar-expand-lg">

			<ul class="navbar-nav ml-auto">

				<li class="nav-item"><a href="/home"
					class="nav-link">Task Manager Home</a></li>
				<li class="nav-item"><a href="/" class="nav-link">Logout</a></li>

			</ul>

		</nav>
		<p>${message}</p>
		<a href="/add?userId=${userId}">Add a task</a>
		<table class="table table-striped">

			<tr>

				<th>Due Date</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			<c:forEach var="task" items="${user.tasks}">

				<tr>


					<td>${task.date}</td>
					<td>${task.description}</td>
					<td><a type=btn
						href="/edit?taskId=${task.id}&userId=${userId}">Edit</a>
						<p></p> <a href="/remove?taskId=${task.id}&userId=${userId}">Remove</a></td>

				</tr>

			</c:forEach>


		</table>

	</div>
</body>
</html>