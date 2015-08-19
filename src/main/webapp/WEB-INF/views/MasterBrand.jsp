<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ข้อมูลยี่ห้อรถยนต์</title>

<script>
	//Show/Hide search
	function Show_Divadd(insertdata) {
		if (false == $(insertdata).is(':visible')) {
			$(insertdata).show(250);
		} else {
			$(insertdata).hide(250);
		}
	}

	/*	function Show_Divedit(editdata) {
	 if (false == $(insertdata).is(':visible')) {
	 $(insertdata).show(250);
	 } else {
	 $(insertdata).hide(250);
	 }
	 }*/
		
</script>

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/css/bootstrap-combined.min.css"
	rel="stylesheet" />

</head>
<body>
	<div id="panelMain">
	
		<div class="row">
			<div class="col-lg-12">
				<h2>
					Brand Car<small> (ข้อมูลยี่ห้อรถยนต์)</small>
				</h2>
			</div>
		</div>
		<br>
		<div id="btnshow">
			<button type="button" 
				class="btn btn-success glyphicon glyphicon-plus" data-original-title="add" data-toggle="tooltip"
				style="font-size: 11pt; width: 40pt; height: 20pt; text-align: center; font-weight: bold;"
				onclick="Show_Divadd(insertdata)" id="btndiv1"></button>
		</div>
		<br>
		<div id="insertdata"
			style="background-color: #EEEEEE; witdh: 50pt; Height: 70pt">

			<label
				style="font-weight: bold; padding-top: 10pt; font-size: 14pt; font-weight: bold; padding-left: 20pt">ADD
				BRAND</label>

			<form:form class="form-inline" modelAttribute="addBrand"
				method="POST" action="${pageContext.request.contextPath}/brand/edit">
				<div class="form-group">
					<form:hidden path="id" />
					<label
						style="font-weight: bold; padding-top: 10pt; padding-left: 40pt">ข้อมูลยี่อห้อรถยนต์
						: </label>
					<form:input path="brandTH" class="form-control" id="txtbrand" style="Height: 20pt" />
				</div>
				<div class="form-group">
					<label style="font-weight: bold">สถานะ : </label>
					<form:select path="tcStatus" style="Width: 80pt; Height: 20pt"
						id="tcStatus" name="tcStatus">
						<option value="01">Online</option>
						<option value="00">Offline</option>
					</form:select>
				</div>
				<button type="submit" name="btnedit" value="savebrand" 
					class="btn btn-success glyphicon glyphicon-floppy-disk"
					data-original-title="update" data-toggle="tooltip"></button>
				<button type="submit" name="btnedit" value="cancel"
					class="btn btn-danger glyphicon glyphicon-remove"
					data-original-title="cancel" data-toggle="tooltip"></button>
			</form:form>



		</div>

		<br>

		<div>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<td style="font-weight: bold; font-size: 13pt;">#</td>
						<td style="font-weight: bold; font-size: 13pt;">BrandName</td>
						<td style="font-weight: bold; font-size: 13pt;">Status</td>
						<td style="font-weight: bold; font-size: 13pt;">Management</td>

					</tr>
				</thead>
				<c:choose>
					<c:when test="${not empty retSampleList}">
						<c:forEach var="listValue" items="${retSampleList}">
							<tr>
								<td style="font-size: 13pt;"><c:out value="${listValue.id}" /></td>
								<td style="font-size: 13pt;"><c:out
										value="${listValue.brandTH}" /></td>
								<td style="font-size: 13pt;"><c:out
										value="${listValue.tcStatusDesc}" /></td>
								<td><a href="<c:url value='/brand/edit/${listValue.id}' />"><span
										class="btn btn-primary glyphicon glyphicon-edit"
										onclick="Show_Divedit(editdata)" aria-hidden="true"
										data-original-title="edit" data-toggle="tooltip"></span></a> <a
									href="<c:url value='/brand/delete/${listValue.id}' />"><span
										class="btn btn-danger glyphicon glyphicon-trash"
										onclick="return confirm('คุณต้องการลบ ยี่ห้อ${listValue.brandTH}?')" aria-hidden="true"
										data-original-title="delete" data-toggle="tooltip"></span></a></td>
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


	</div>
</body>
</html>