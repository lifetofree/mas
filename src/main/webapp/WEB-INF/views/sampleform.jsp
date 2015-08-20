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
	
		Error : ${ retSampleform } <br />

		<form:form class="form-inline" modelAttribute="dataSampletest"
			method="POST"
			action="${pageContext.request.contextPath}/sampleform/upsert">
			<div class="form-group" >
				<form:hidden path="id" />
				ชื่อผู้สร้าง : <form:input path="name" class="form-control" placeHolder="Host Name" /><br/><br/>
				ชื่อห้องประชุม : <form:input path="lastname" class="form-control" placeHolder="Last Name" /><br/><br/>
				 สถานที่ : <select name="place" class="form-control">
						<option selected="selected" value="เลือกสถานที่">เลือกสถานที่</option>
						<option value="นพวงศ์">นพวงศ์ </option>
						<option value="เมืองทองธานี">เมืองทองธานี</option>
					  </select><br/><br/>
				จำนวนคน : <select name="quantity" class="form-control">
						<% for(int i=0; i<25; i++){ %>
            			<option value="<%=i%>"><%=i%></option>
            			<% } %>
            			</select><br/><br/>
				      		
        		 วันที่สร้าง: <select name="date" class="form-control">
            			<% for(int i=1; i<=31; i++){ %>
            			<option value="<%=i%>"><%=i%></option>
            			<% } %>
            			</select><br/><br/>
            			          				
			</div>
			
			<br/><br/><br/>
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
					<td>รหัสห้องพัก</td>
					<td>ชื่อผ้สร้าง</td>
					<td>ชื่อห้องประชุม</td>
					<td>สถานที่</td>
					<td>จำนวนคน</td>
					<td>แก้ไข</td>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${not empty retSampleformList}">
					<c:forEach var="listValue" items="${retSampleformList}">
						<tr>
							<td><c:out value="${listValue.id}" /></td>
							<td><c:out value="${listValue.name}" /></td>
							<td><c:out value="${listValue.lastname}" /></td>
							<td><c:out value="${listValue.place}" /></td>
							<td><c:out value="${listValue.quantity}" /></td>
							<td>
							<a
								href="<c:url value='/samples/upsert/${listValue.id}' />"><span
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
						<td>-</td>
						<td>-</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>