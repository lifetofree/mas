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
	<br/><br/>
	<h1 align="center">ระบบจองห้องประชุม</h1>	
	<br/>
	
	<h3>ข้อมูลห้องประชุม<small> (รายละเอียด)</small></h3>
	<br/>
	
		Error : ${ retRoom } <br />
		

		<form:form class="form-inline" modelAttribute="dataM0_TbRoom"
			method="POST"
			action="${pageContext.request.contextPath}/room/upsert">
			
			
			<div class="form-group">
			<label class="col-sm-5 control-label">ชื่อห้องประชุม</label>
				<div class="col-sm-10">
				<form:input path="name" type="text" class="form-control" 
                                id="name" placeholder="Name" />
				<form:errors path="name" class="control-label" />	
				</div>	
			
			
			
			<label class="col-sm-5 control-label">จำนวนคน</label>
				<div class="col-sm-10">
				<form:input path="quantity" type="text" class="form-control" 
                                id="quantity" placeholder="Quantity" />
				<form:errors path="quantity" class="control-label" />	
				</div>	
			</div>
					
			<br/><br/>
			<%-- <form:select path="country">
				<form:options items="${countryList}" />
			</form:select> --%>
			<button type="submit" name="cmdName" value="save"
				class="btn btn-default">
				<span class="glyphicon glyphicon-ok" aria-hidden="true"
					data-original-title="save" data-toggle="tooltip"></span>
			</button>
			<button type="submit" name="cmdName" value="cancel"
				class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"
					data-original-title="cancel" data-toggle="tooltip"></span>
			</button>
		</form:form>

		<br />
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td>ID</td>
					<td>ชื่อห้องประชุม</td>
					<td>จำนวนคน</td>
					<td>Management</td>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${not empty retRoomList}">
					<c:forEach var="listValue" items="${retRoomList}">
						<tr>
							<td><c:out value="${listValue.id}" /></td>
							<td><c:out value="${listValue.name}" /></td>
							<td><c:out value="${listValue.quantity}" /></td>
							<td><a
								href="<c:url value='/room/upsert/${listValue.id}' />"><span
									class="glyphicon glyphicon-edit" aria-hidden="true"
									data-original-title="edit" data-toggle="tooltip"></span></a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>