<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">

		<div class="col-md-12 ">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>User Profile</h4>
				</div>
				<div class="panel-body">

					<div class="box box-info">

						<div class="box-body">
							<div class="col-md-4">
								<div align="center">
									<img alt="User Pic"
										src="<c:url value="/resources/images/${user.userId}.png" /> "
										id="profile-image1" class="img-circle img-responsive">

								</div>

								<br>

								<!-- /input-group -->
							</div>
							<div class="col-md-8 ">
								<h4 style="color: #00b1b1;">Welcome:${user.username}</h4>
								<p>${user.mainSkill}</p>
								<hr style="margin: 5px 0 5px 0;">
							</div>
							<div class="col-md-6 user-information">
								<br />
								<p>
									<strong>First Name</strong> : ${user.userFirstName}
								</p>
								<p>
									<strong>Last Name</strong> : ${user.userLastName}
								</p>
								<p>
									<strong>Email</strong> : ${user.userEmail}
								</p>

								<!-- /.box-body -->
							</div>

							<div class="col-md-2">
								<br /> <a class="btn btn-info"
									href="<c:url value="/profile/editProfile" />">Edit</a> <a
									class="btn btn-danger"
									href="<c:url value="/profile/deleteProfile" />">Delete</a>

							</div>
							<!-- /.box -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>