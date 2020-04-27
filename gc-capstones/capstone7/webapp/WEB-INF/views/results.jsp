<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Recipes || Results</title>
</head>
<body>
	<div class="contianer-fluid"><%@ include
			file="partials/header.jsp"%>
	</div>
	<div class="container-fluid text-right">
		<h4>
			Displaying results ${searchResults.from + 1} to ${searchResults.from + 10}
			of
			<fmt:formatNumber type="number" value="${searchResults.count}" />
		</h4>
	</div>
	<div class="container-fluid justify-content-center">
		<c:forEach items="${list}" var="item" varStatus="loop">
			<div class="card border-info mb-3">
				<div class="card-header">
					<h2>
						${item.lbl}
						<small class="text-muted">from ${item.src}</small>
					</h2>
				</div>
				<div class="card-body">
					<div class="container">
						<div class="row">
							<div class="col-sm">
								<img src="${item.img}" class="mx-auto">
								<p class="card-text">
							</div>
							<div class="col-sm display-5">
								<c:if test="${item.dietLbl[0] ne null}">
									<h5>
										<c:forEach items="${item.dietLbl}" var="lbl">
											<span class="badge badge-secondary">${lbl}</span>
										</c:forEach>
									</h5>
								</c:if>
								<c:if test="${item.healthLbl[0] ne null}">
									<h5>
										<c:forEach items="${item.healthLbl}" var="lbl">
											<span class="badge badge-secondary">${lbl}</span>
										</c:forEach>
									</h5>
								</c:if>
								<p class="card-text">
									<i><fmt:formatNumber type="number" maxIntegerDigits="1"
											value="${item.calories}" /> kCal <c:if test="${item.time != 0}">
							        			 / ${item.time} min.
        		 				</c:if> </i>
								</p>
								<p class="card-text">
									<c:url var="displayUrl" value="/display">
										<c:param name="recipeUri" value="${item.uri}" />
									</c:url>
									<a href="${displayUrl}">Recipe</a>
								<form action="/fav/add" method="post">
									<input type="hidden" name="arrayIndex" value="${loop.index}">
									<button type="submit" class="btn-success">Add to Favorites</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
	<div>
		<ul class="pagination pagination-lg">
			<c:if test="${searchResults.from != 0}">
				<li class="page-item active">
					<form method="post" action="/search">
						<input type="hidden" name="lbl" value="${searchResults.q}">
						<input type="hidden" name="from"
							value="${searchResults.from - 10 }">
						<button class="page-link">Previous
							[${searchResults.from-9}-${searchResults.from}]</button>
					</form>
				</li>
			</c:if>
			<c:if test="${searchResults.more}">
				<li class="page-item active">
					<form method="post" action="/search">
						<input type="hidden" name="lbl" value="${searchResults.q}">
						<input type="hidden" name="from"
							value="${searchResults.from + 10}">
						<button class="page-link">Next [${searchResults.from + 1}-${searchResults.from + 10}]</button>
					</form>
				</li>
			</c:if>
		</ul>

	</div>
</body>
</html>