<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container">
	<div class="centered">
		<div class="jumbotron">
			<h2>Here you can add new skills group.</h2>
		</div>
	</div>
</div>
<div class="container">

	<div class="col-md-7 ">
		<form:form
			action="${pageContext.request.contextPath}/skillsGroup/addSkillsGroup"
			method="post" commandName="skillsGroup" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Enter name of group</label>
				<form:input path="groupName" id="groupName" class="form-Control"
					required="required" placeholder="Group Name" />
			</div>

			<br>
			<input type="submit" value="submit" class="btn btn-primary">
			<a href="<c:url value="/skillsGroup" />" class="btn btn-danger">Cancel</a>
		</form:form>
	</div>
</div>

</body>
</html>