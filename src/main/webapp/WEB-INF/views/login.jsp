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

</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<c:if test="${not empty msg}">
						<div class="msg" style="color: ff0000">${msg}</div>
					</c:if>
					
					


					<form name="loginForm"
						action="<c:url value="/j_spring_security_check"/>" method="post">
						<c:if test="${not empty error }">
							<div class="error" style="color: ff0000">${error}</div>
						</c:if>
						<div class="form-group">
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input id="username"
									type="text" class="form-control" name="username"
									placeholder="UserName" required="required">
							</div>
						</div>
						<div class="form-group">
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input id="password"
									type="password" class="form-control" name="password"
									placeholder="password" required="required">
							</div>
							<!-- Show password use JS (main.js) -->
							<div class="input-group">
								<div class="checkbox">
									<label> <input id="showPassword" type="checkbox" />Show
										Password
									</label> <label> <input class="pull-right" id="login-remember"
										type="checkbox" name="_spring_security_remember_me" value="1">
										Remember me
									</label>
								</div>
							</div>
						</div>






						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<input type="submit" value="Login" class="btn btn-default" /> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</form>
					<div class="form-group">
						<div class="col-md-12 control">
							<div
								style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
								Don't have an account! <a href="<c:url value="/register"/>">Sign
									Up Here</a>
							</div>
						</div>
					</div>




				</div>
			</div>
		</div>

	</div>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<!--main js-->
	<script src="<c:url value="/resources/js/custom.js" />"></script>
</body>
</html>