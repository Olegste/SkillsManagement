<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Skills Management</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/FeedEk.css "/>"
	rel="stylesheet">
<style>
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 13px;
	line-height: 17px !important;
}
</style>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="<c:url value="/"/>">Skills
							Management</a>
					</div>
					<ul class="nav navbar-nav ">
						<li><a href="<c:url value="/news"/>">News</a></li>
						<li><a href="<c:url value="/skillsGroup"/>">Skills</a></li>
						<li><a href="<c:url value="/profile"/>">Profile</a></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<li><a href="<c:url value="/profile"/>">Logged as:
								${pageContext.request.userPrincipal.name}</a></li>
						<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
					</ul>
				</div>

			</nav>
		</div>
	</div>