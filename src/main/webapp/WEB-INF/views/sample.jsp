<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
</head>
<body>
	test home body
	<div id="panelMain">
		Error : ${ retSamples } <br />

<<<<<<< HEAD
		<form:form class="form-inline" modelAttribute="addHosting">
			<div class="form-group">
				<form:input path="name" class="form-control" placeHolder="Host Name" />
				<form:input path="domain" class="form-control" placeHolder="Domain Name" />
=======
		<form:form class="form-inline" modelAttribute="addHosting"
			method="POST" action="${pageContext.request.contextPath}/samples/add">
			<div class="form-group">
				<form:input path="name" class="form-control" placeHolder="Host Name" />
				<form:input path="domain" class="form-control"
					placeHolder="Domain Name" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
		
		<form:form class="form-inline" modelAttribute="addHosting"
			method="POST" action="">
			<div class="form-group">
				<form:input path="id" class="form-control" placeHolder="Host Name" />
				<form:input path="name" class="form-control" placeHolder="Host Name" />
				<form:input path="domain" class="form-control"
					placeHolder="Domain Name" />
>>>>>>> origin/dev
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>

		<br />
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Domain</td>
<<<<<<< HEAD
=======
					<td>Action</td>
>>>>>>> origin/dev
				</tr>
			</thead>
			<c:choose>
				<c:when test="${not empty retSampleList}">
					<c:forEach var="listValue" items="${retSampleList}">
						<tr>
							<td><c:out value="${listValue.id}" /></td>
							<td><c:out value="${listValue.name}" /></td>
							<td><c:out value="${listValue.domain}" /></td>
<<<<<<< HEAD
=======
							<td><a
								href="<c:url value='/samples/edit/${listValue.id}' />"><span
									class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
>>>>>>> origin/dev
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>-</td>
						<td>-</td>
<<<<<<< HEAD
=======
						<td>-</td>
						<td>-</td>
>>>>>>> origin/dev
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>