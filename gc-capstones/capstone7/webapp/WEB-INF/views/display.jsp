<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>${recipe.lbl}</title>
</head>
<body>
	<%@ include file="partials/header.jsp"%>
	<div class="col-sm display-5">
		<h1>${recipe.lbl}</h1>
	</div>
	<div class="col-sm">
		<img src="${recipe.img}" class="mx-auto">
		<p class="card-text">
	</div>
	<div>
		<c:if test="${recipe.healthLbl[0] ne null}">
			<h5>
				<c:forEach items="${recipe.healthLbl}" var="lbl">
					<span class="badge badge-secondary">${lbl}</span>
				</c:forEach>
			</h5>
			<c:if test="${recipe.time != 0}">
				 ${recipe.time} min.
        	</c:if>
		</c:if>

		<div>
			<a href="${recipe.url }">Recipe</a>
		</div>

	</div>
</body>
</html>