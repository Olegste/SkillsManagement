<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Skills Management</title>
<!-- Angular JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
	
</script>

<%--Jquery--%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Main CSS -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


</head>
<div class="container">
	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign Up</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">


				<form:form action="${pageContext.request.contextPath}/register"
					method="post" commandName="user" enctype="multipart/form-data">
					<form:hidden path="userId" value="${user.userId}" />

					<div class="form-group">
						<label for="userFirstName" class="cols-sm-2 control-label">User
							First Name</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="userFirstName" id="userFirstName"
								class="form-Control" placeholder="Enter your first name"
								required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="userLastName" class="cols-sm-2 control-label">User
							Last Name</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="userLastName" id="userLastName"
								class="form-Control" placeholder="Enter your last name"
								required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="mainSkill" class="cols-sm-2 control-label">Main
							Skill</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="mainSkill" id="mainSkill" class="form-Control"
								placeholder="Enter your main skill" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="usarname" class="cols-sm-2 control-label">UserName</label>
						<span style="color: #ff0000">${usernameMsg}</span>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="username" id="username" class="form-Control"
								placeholder="Enter your username (NickName)" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:input type="password" path="password" id="password"
								class="form-Control" placeholder="Enter your password"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="userEmail" class="cols-sm-2 control-label">Email</label>
						<span style="color: #ff0000">${emailMsg}</span>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="userEmail" id="userEmail" class="form-Control"
								placeholder="Enter your email" required="required" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label" for="userImage">Upload
							Picture</label>
						<form:input id="userImage" path="userImage" type="file"
							class="form:input-large" />
					</div>

					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->



						<div class="col-sm-12 controls">
							<input type="submit" value="submit" class="btn btn-success"
								value="">
						</div>
					</div>
					<br />
					<br />
				</form:form>
				<div class="form-group">
					<div class="col-md-12 control">
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							Already have account?<a href="<c:url value="/login"/>">Sign
								in here</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>