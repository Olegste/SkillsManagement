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
				<div class="panel-title">Edit your profile information here</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">

				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12"></div>

				<form:form
					action="${pageContext.request.contextPath}/profile/editProfile"
					method="post" commandName="user" enctype="multipart/form-data">
					<form:hidden path="userId" value="${user.userId}" />

					<div class="form-group">
						<label for="usarname" class="cols-sm-2 control-label">New
							username</label>
						<div style="margin-bottom: 25px" class="input-group">

							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="username" id="username" class="form-Control"
								placeholder="Enter your username" required="required"
								value="${user.username}" />
						</div>
					</div>


					<div class="form-group">
						<label for="usarFirstName" class="cols-sm-2 control-label">New
							first name</label>
						<div style="margin-bottom: 25px" class="input-group">

							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="userFirstName" id="userFirstName"
								class="form-Control" placeholder="Enter your first name"
								required="required" value="${user.userFirstName}" />
						</div>
					</div>
					<div class="form-group">
						<label for="usarname" class="cols-sm-2 control-label">New
							last name</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="userLastName" id="userLastName"
								class="form-Control" placeholder="Enter your last name"
								required="required" value="${user.userLastName}" />
						</div>
					</div>
					<div class="form-group">
						<label for="mainSkill" class="cols-sm-2 control-label">Main
							Skill</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="mainSkill" id="mainSkill" class="form-Control"
								placeholder="Enter your main skill" required="required"
								value="${user.mainSkill}" />
						</div>
					</div>
					<div class="form-group">
						<label for="usarname" class="cols-sm-2 control-label">New
							Email</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="userEmail" id="userEmail" class="form-Control"
								placeholder="Enter your email" required="required"
								value="${user.userEmail}" />
						</div>
					</div>
					<div class="form-group">
						<label for="usarname" class="cols-sm-2 control-label">New
							Password</label>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:input type="password" path="password" id="password"
								class="form-Control" placeholder="Enter your password"
								required="required" value="${user.password}" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label" for="productImage">Upload
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
			</div>
		</div>
	</div>

</div>
</body>
</html>