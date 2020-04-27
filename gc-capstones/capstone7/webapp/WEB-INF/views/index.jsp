<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-2kOE+STGAkgemIkUbGtoZ8dJLqfvJ/xzRnimSkQN7viOfwRvWseF7lqcuNXmjwrL"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<head>
<meta charset="ISO-8859-1">
<title>Recipes 'R' Us</title>
</head>
<body class = "bg">
	<div class = "new"
		style="background-image: url('https://image.shutterstock.com/image-photo/healthy-food-clean-eating-selection-260nw-722718097.jpg');">
		<%@ include file="partials/header.jsp"%>
		<form action="/search" method="post" class="label-header">
			<div>
				<label>Quick Recipe Search</label><input type="text" name="lbl"
					required>
			</div>
			<div>
				<input name="dietLbls" type="hidden">
			</div>
			<div>
				<input name="healthLbls" type="hidden">
			</div>
			<input type="hidden" name="from" value=0>
			<button>Search!!</button>
		</form>
	</div>
</body>
</html>