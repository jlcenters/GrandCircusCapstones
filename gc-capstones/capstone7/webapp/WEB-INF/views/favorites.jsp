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
<head><%@ include
			file="partials/header.jsp"%>

<meta charset="ISO-8859-1">
<title>Favorites</title>
</head>
<body>
<c:forEach items="${list}" var="item">
<div class="card border-secondary mb-3" style="max-width: 20rem;">
  <div class="card-header">${item.lbl}</div>
  <div class="card-body">
    <img src="${item.img}"></image>
    <a href="${item.url}">Recipe</a>
  </div>
</div>
</c:forEach>
</body>
</html>