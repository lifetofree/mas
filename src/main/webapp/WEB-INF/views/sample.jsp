<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
				</tr>
			</thead>
			<c:forEach var="listValue" items="${retSampleList}">
				<tr>
					<td><c:out value="${listValue.id}" /></td>
					<td><c:out value="${listValue.name}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>