<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Fun! - ${title}</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<script>
	window.menu = '${title}'; //setting variable menu to solve active menu problem
</script>

<title>Online Shopping Fun! - ${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Custom Theme included here -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


</head>

<body>

	<div class="wrapper">
		<!-- Navigation starts -->
		<%@ include file="./shared/navbar.jsp"%>
		<!-- Navigation ends -->

		<div class="content">
			<!-- Page of Content home.jsp comes here -->
			<c:if test="${userClickHome eq true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Page Content of home.jsp comes here -->

			<!-- Page  Content of about comes here -->
			<c:if test="${userClickAbout eq true}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Page Content of about comes here -->

			<!-- Page  Content of contact comes here -->
			<c:if test="${userClickContact eq true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- Page Content of contact comes here -->

			<!-- Page  Content of products comes here -->
			<c:if test="${userClickProducts eq true || userClickCategoryProducts eq true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- Page Content of products comes here -->
		</div>
		<!-- Footer comes here-->
		<%@ include file="./shared/footer.jsp"%>
		<!-- Footer comes here ends -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Linking my own app.js-- custom javascript for my project -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>