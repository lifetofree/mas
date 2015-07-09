<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ข้อมูลประเภทรถยนต์</title>

<script>
	//Show/Hide search
	function Show_Divadd(insertdata) {
		if (false == $(insertdata).is(':visible')) {
			$(insertdata).show(250);
		} else {
			$(insertdata).hide(250);
		}
	}

	function Show_Divedit(editdata) {
		if (false == $(editdata).is(':visible')) {
			$(editdata).show(250);
		} else {
			$(editdata).hide(250);
		}
	}
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
					TypeCar Data<small> (ข้อมูลประเภทรถยนต์)</small>
				</h2>
			</div>
		</div>
		<br>
		<div id="btnshow">
			<button type="button"
				class="btn btn-success glyphicon glyphicon-plus"
				style="font-size: 11pt; width: 40pt; height: 20pt; text-align: center; font-weight: bold;"
				onclick="Show_Divadd(insertdata)" id="btndiv1"></button>
		</div>
		<br>
		<div id="insertdata"
			style="display: none; background-color: #EEEEEE; witdh: 50pt; Height: 70pt">
			<label
				style="font-weight: bold; padding-top: 10pt; font-size: 14pt; font-weight: bold; padding-left: 20pt">Add
				TypeCar</label>
			<form:form class="form-inline" modelAttribute="addTypeCar"
				method="POST" action="${pageContext.request.contextPath}/typecar/add">
				<div class="form-group">

					<label
						style="font-weight: bold; padding-top: 10pt; padding-left: 40pt">ข้อมูลรถยนต์
						: </label>
					<form:input path="typeCarTH" class="form-control"
						style="Height: 20pt" />
				</div>
				<div class="form-group">
					<label style="font-weight: bold">สถานะ : </label>
					<form:select path="tcStatus" style="Width: 80pt; Height: 20pt"
						id="tcStatus" name="tcStatus">
						<option value="01">Online</option>
						<option value="00">Offline</option>
					</form:select>
				</div>
				<button type="submit"
					class="btn btn-success glyphicon glyphicon-floppy-disk"></button>
				<button type="submit"
					class="btn btn-danger glyphicon glyphicon-remove"></button>
			</form:form>
		</div>

		<div id="editdata"
			style="display: none; background-color: #EEEEEE; witdh: 50pt; Height: 70pt">
			<form:form class="form-inline" modelAttribute="addTypeCar"
				method="POST" action="">
			<label
				style="font-weight: bold; padding-top: 10pt; font-size: 14pt; font-weight: bold; padding-left: 20pt">UpDate
				TypeCar</label>
			
				<div class="form-group">

					<label
						style="font-weight: bold; padding-top: 10pt; padding-left: 40pt">ข้อมูลรถยนต์
						: </label>
					<form:input path="typeCarTH" class="form-control"
						style="Height: 20pt" />
				</div>
				<div class="form-group">
					<label style="font-weight: bold">สถานะ : </label>
					<form:select path="tcStatus" style="Width: 80pt; Height: 20pt"
						id="tcStatus" name="tcStatus">
						<option value="01">Online</option>
						<option value="00">Offline</option>
					</form:select>
				</div>
				<button type="submit" class="btn btn-success glyphicon glyphicon-ok"></button>
				<button type="submit"
					class="btn btn-danger glyphicon glyphicon-remove"></button>
			</form:form>
		</div>
		<br>

		<div>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<td style="font-weight: bold">#</td>
						<td style="font-weight: bold">TypeName</td>
						<td style="font-weight: bold">Status</td>
						<td style="font-weight: bold">Management</td>

					</tr>
				</thead>
				<c:choose>
					<c:when test="${not empty retSampleList}">
						<c:forEach var="listValue" items="${retSampleList}">
							<tr>
								<td><c:out value="${listValue.id}" /></td>
								<td><c:out value="${listValue.typeCarTH}" /></td>
								<td><c:out value="${listValue.tcStatusDesc}" /></td>
								<td><a
									href="<c:url value='/typecar/edit/${listValue.id}' />"><span
										class="btn btn-primary glyphicon glyphicon-edit"
										data-toggle="tooltip" onclick="Show_Divedit(editdata)"
										aria-hidden="true"></span></a> <a id="btndelete"
									class="btn btn-danger glyphicon glyphicon-trash"
									data-toggle="tooltip"></a></td>


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