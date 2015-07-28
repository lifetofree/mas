<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ข้อมูลรายละเอียดรถยนต์</title>

<script>
	//Show/Hide search
	function Show_Divadd(insertdata) {
		if (false == $(insertdata).is(':visible')) {
			$(insertdata).show(250);
		} else {
			$(insertdata).hide(250);
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
					DataCar Name<small> (ข้อมูลรถยนต์)</small>
				</h2>
			</div>
		</div>
		<br>
		<div id="btnshow">
			<button type="button" data-original-title="add" data-toggle="tooltip"
				class="btn btn-success glyphicon glyphicon-plus"
				style="font-size: 11pt; width: 40pt; height: 20pt; text-align: center; font-weight: bold;"
				onclick="Show_Divadd(insertdata)" id="btndiv1"></button>
		</div>
		<br>
		<div id="insertdata"
			style="background-color: #EEEEEE; witdh: 50pt; Height: 150pt">

			<label
				style="font-weight: bold; padding-top: 10pt; font-size: 14pt; font-weight: bold; padding-left: 20pt">Add
				DataCar</label> <br>
			<form:form class="form-inline" modelAttribute="addDataCar"
				method="POST"
				action="${pageContext.request.contextPath}/datacar/edit">
				<div class="form-group">
					<form:hidden path="id" />
					<div class="col-sm-6" style="text-align: right">

						<label style="font-weight: bold;">ประเภทรถยนต์:</label>

					</div>
					<div class="col-sm-3">
						<c:choose>
							<c:when test="${not empty typecar}">


								<form:select path="tcidx" style="width: 130pt; height: 20pt">
									<option>กรุณาเลือกข้อมูล...</option>
									<c:forEach var="listValue" items="${typecar}">
										<option value="<c:out value='${listValue.id}' />">
											<c:out value="${listValue.typeCarTH}" />
										</option>
									</c:forEach>

								</form:select>

							</c:when>
						</c:choose>
					</div>

				</div>

				<div class="form-group" style="text-align: right">
					<div class="col-sm-6">
						<label style="font-weight: bold;">ประเภทยี่ห้อรถยนต์:</label>
					</div>
					<div class="col-sm-3">

						<c:choose>
							<c:when test="${not empty brand}">


								<form:select path="tbidx" style="width: 130pt; height: 20pt">
									<option>กรุณาเลือกข้อมูล...</option>
									<c:forEach var="listValue" items="${brand}">
										<option value="<c:out value='${listValue.id}' />">
											<c:out value="${listValue.brandTH}" />
										</option>
									</c:forEach>

								</form:select>

							</c:when>
						</c:choose>
					</div>

				</div>



				<div class="form-group">
					<div class="col-sm-4" style="text-align: right">

						<label style="font-weight: bold;">สี : </label>
					</div>
					<div class="col-sm-5">
						<form:input path="color" class="form-control"
							style="Height: 20pt;width:130pt" />
					</div>
				</div>
				<br>
				<br>
				<div class="form-group">
					<div class="col-sm-6">
						<label style="font-weight: bold; padding-top: 10pt;">เลขทะเบียนรถยนต์:
						</label>
					</div>
					<div class="col-sm-3">
						<form:input path="carli" class="form-control" style="Height: 20pt" />
					</div>

				</div>

				<div class="form-group">
					<div class="col-sm-5">
						<label
							style="font-weight: bold; padding-top: 10pt; padding-left: 40pt">จำนวน
							: </label>
					</div>
					<div class="col-sm-3">
						<form:select path="qty" style="Width: 130pt; Height: 20pt">
							<option value="none">เลือกจำนวนคน</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label style="font-weight: bold">สถานะ : </label>
					<form:select path="tcStatus" style="Width: 80pt; Height: 20pt"
						id="tcStatus" name="tcStatus">
						<option value="01">Online</option>
						<option value="00">Offline</option>
					</form:select>
				</div>
				<button type="submit" name="btnedit" value="savedatacar"
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
						<td style="font-weight: bold; font-size: 13pt; text-align: center">#</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">TypeCar</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">BrandCar</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">Color</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">CarLicense</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">Quantity</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">Status</td>
						<td style="font-weight: bold; font-size: 13pt; text-align: center">Management</td>

					</tr>
				</thead>
				<c:choose>
					<c:when test="${not empty retSampleList}">
						<c:forEach var="listValue" items="${retSampleList}">
							<tr>
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.id}" /></td>
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.tcidxDesc}" /></td>
									
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.tbidxDesc}" /></td>
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.color}" /></td>
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.carli}" /></td>
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.qty}" /></td>
								<td style="font-size: 13pt; text-align: center"><c:out
										value="${listValue.tcStatusDesc}" /></td>
								<td style="text-align: center"><a
									href="<c:url value='/datacar/edit/${listValue.id}' />"><span
										class="btn btn-primary glyphicon glyphicon-edit"
										data-original-title="edit" data-toggle="tooltip"
										onclick="Show_Divedit(editdata)" aria-hidden="true"></span></a> <a
									href="<c:url value='/datacar/delete/${listValue.id}' />"><span
										class="btn btn-danger glyphicon glyphicon-trash"
										data-original-title="delete" data-toggle="tooltip"
										onclick="Show_Divdelete" aria-hidden="true"></span></a></td>
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