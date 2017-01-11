<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container">
	<div class="row">

		<div class="col-md-12 ">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>User Skills</h4>
				</div>
				<div class="panel-body">

					<div class="box box-info">

						<div class="box-body">

							<div class="col-md-12">
								<h4 style="color: #00b1b1;">Welcome:
									${pageContext.request.userPrincipal.name} this is your skills
									group</h4>
								<p style="color: #00b1b1;">Click on group name to see your
									skills</p>
								<hr style="margin: 5px 0 5px 0;">
							</div>
							<div class="col-md-12">
								<c:forEach items="${skillsGroupList}" var="skillsGroup">
									<a
										href="<spring:url value="/skillsGroup/viewSkillsGroup/${skillsGroup.skillsGroupId}" />"><h1>${skillsGroup.groupName}</h1></a>
									<hr style="margin: 5px 0 5px 0;">
								</c:forEach>
								<br /> <a class="btn btn-primary"
									href="<c:url value="/skillsGroup/addSkillsGroup" />">Add
									Group</a>
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