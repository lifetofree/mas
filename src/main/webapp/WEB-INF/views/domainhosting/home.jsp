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
	<div id="panelMain">
		<h4>Domain &amp; Hosting</h4>
        <hr />
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Domain</td>
					<!-- <td>Action</td> -->
				</tr>
			</thead>
			<c:choose>
				<c:when test="${not empty retDomainList}">
					<c:forEach var="domainList" items="${retDomainList}">
						<tr>
							<td><c:out value="${domainList.id}" /></td>
							<td><c:out value="${domainList.domain}" /></td>
							<td><c:out value="${domainList.status}" /></td>
							<%-- <td><a
								href="<c:url value='/samples/upsert/${listValue.id}' />"><span
									class="glyphicon glyphicon-edit" aria-hidden="true"
									data-original-title="edit" data-toggle="tooltip"></span></a></td> --%>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<!-- <td>-</td> -->
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>