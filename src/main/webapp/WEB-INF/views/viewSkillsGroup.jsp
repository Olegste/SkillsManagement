<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
								<h1 style="color: #00b1b1;">Group: ${skillsGroup.groupName}</h1>
								<br />
								<c:forEach items="${skillList}" var="skills">
									<h3>- ${skills.skillName}</h3>
									<hr style="margin: 5px 0 5px 0;">
								</c:forEach>
							</div>
							<div class="col-md-12">
								<br />

								<div class="col-md-7 ">
									<form:form
										action="${pageContext.request.contextPath}/skillsGroup/viewSkillsGroup/${skillsGroup.skillsGroupId}"
										method="post" commandName="skills">
										<div class="form-group">
											<label for="name">Enter name of skill</label>
											<form:input path="skillName" id="skillName"
												class="form-Control" required="required"
												placeholder="Skill Name" />
										</div>

										<br>
										<input type="submit" value="add" class="btn btn-primary">
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>