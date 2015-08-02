<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ระบบจองรถยนต์</title>
<script>
	//Show/Hide search

	function Show_Divsearch(search) {
		if (false == $(search).is(':visible')) {
			$(search).show(250);
		} else {
			$(search).hide(250);
		}
	}

	//datepickup
	$(function() {

		$('#example1').datepicker({
			format : "dd/mm/yyyy",
		});
		$('#example2').datepicker({
			format : "dd/mm/yyyy",

		});
		$('#example3').datepicker({
			format : "dd/mm/yyyy",

		});
		$('#example4').datepicker({
			format : "dd/mm/yyyy",

		});
		$('#example5').datepicker({
			format : "dd/mm/yyyy",

		});
		$('#example6').datepicker({
			format : "dd/mm/yyyy"

		});

		var Check_url = document.URL;
		Check_url = Check_url.split("test=");
		Show_Div(Check_url[1]);

		var Check_url = document.URL;
		Check_url = Check_url.split("tests=");
		Show_Div1(Check_url[1]);

		$(".testx").val("");
	});

	//hide div

	function Show_Div(mode) {
		if (mode == 'main') {
			$(main).show(250);
			$(showdatarent).hide(250);
			$(editdatarent).hide(250);
		} else if (mode == 'showdatarent') {
			$(showdatarent).show(250);
			$(main).hide(250);
			$(editdatarent).hide(250);
		} else if (mode == 'editdatarent') {
			$(editdatarent).show(250);
			$(showdatarent).hide(250);
			$(main).hide(250);
		}
	}

	function Show_Div1(mode1) {
		if (mode1 == 'tablepro') {
			$(tablepro).show(250);
			$(adminproblem).hide(250);

		} else if (mode1 == 'adminproblem') {
			$(adminproblem).show(250);
			$(tablepro).hide(250);

		}
	}

	function Show_Div2(mode2) {
		if (mode2 == 'reportdata') {
			$(reportdata).show(250);
			$(reporttable).hide(250);

		} else if (mode2 == 'reporttable') {
			$(reporttable).show(250);
			$(reportdata).hide(250);

		}
	}
</script>


<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/css/bootstrap-combined.min.css"
	rel="stylesheet" />

<!-- SCRIPTS -->
<script class="cssdesk"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"
	type="text/javascript"></script>
<script class="cssdesk"
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"
	type="text/javascript"></script>
<script class="cssdesk"
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/js/bootstrap.min.js"
	type="text/javascript"></script>



</head>
<body>
	<div id="panelMain">
		<!--div master-->
		<div class="form-horizontal">
			<!--div form-->

			<!-- Header -->
			<div class="row">
				<h1 style="text-align: center">ระบบจองรถยนต์ CarBooking</h1>
			</div>
			<br>

			<!-- Search Box -->

			<div>
				<button type="button"
					class="btn btn-primary glyphicon glyphicon-search"
					data-original-title="add" data-toggle="tooltip"
					style="font-size: 11pt; width: 40pt; height: 20pt;"
					onclick="Show_Divsearch(search)" id="btndiv1"></button>
			</div>
			<br>
			<div class="row" id="search" style="display: none;">
				<!--div Show Search-->
				<div class="col-sm-11">
					<!--div class="col-sm-11-->

					<br>
					<div class="form-group">
						<div class="col-sm-2">
							<label style="text-align: left"> ประเภทการค้นหา: </label>
						</div>
						<div class="col-sm-3">
							<select style="Width: 160pt; Height: 20pt">
								<option value="00">กรุณาเลือกประเภทค้นหา...</option>
								<option value="1">ประเภทการจองรถยนต์</option>
								<option value="2">ประเภทรถยนต์</option>
								<option value="3">รายงาน</option>
							</select>
						</div>

						<div class="col-sm-2">
							<label style="text-align: left">ข้อมูลการค้นหา:</label>
						</div>
						<div class="col-sm-2">
							<select style="Width: 160pt; Height: 20pt">
								<option value="00">กรุณาเลือกข้อมูล...</option>

							</select>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-2">
							<label style="text-align: left"> ระบุช่วงเวลา : </label>
						</div>
						<div class="col-sm-3">
							<select style="Width: 160pt; Height: 20pt">
								<option value="00">กรุณาเลือกช่วงเวลา...</option>
								<option value="1">มากกว่า</option>
								<option value="2">น้อยกว่า</option>
								<option value="3">ระหว่าง</option>
							</select>
						</div>
						<div class="col-sm-1">
							<label style="text-align: left">วันที่ : </label>
						</div>
						<div class="col-sm-2">
							<input type="text" id="example1"
								style="background-color: #FFFFFF; width: 120pt; Height: 20pt">

						</div>
						<div class="col-sm-2">
							<input type="text" id="example2"
								style="background-color: #FFFFFF; width: 120pt; Height: 20pt"
								name="txtdate1">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-2">
							<label style="text-align: left">ผลการอนุมัติ</label>
						</div>
						<div class="col-sm-3">
							<select style="Width: 160pt; Height: 20pt">
								<option value="00">กรุณาเลือกผลอนุมัติ...</option>
								<option value="1">อนุมัติแล้ว</option>
								<option value="2">รออนุมัติ</option>
								<option value="3">ไม่อนุมัติ</option>
								<option value="3">ยกเลิก</option>
							</select>
						</div>

						<div class="col-sm-2">
							<label style="text-align: left">รหัสพนักงาน</label>
						</div>
						<div class="col-sm-2">
							<input type="text" name="idemp"
								style="width: 160pt; height: 20pt">
						</div>

					</div>


					<br>

					<div class="form-group">
						<div class="col-sm-11">
							<button type="button"
								class="btn btn-defualt glyphicon glyphicon-search"
								data-original-title="search" data-toggle="tooltip"
								style="font-size: 11pt; width: 40pt; height: 20pt"></button>
						</div>
					</div>



				</div>
				<!--div class="col-sm-11-->
			</div>
			<!--div Show Search-->


			<div class="tabbable">
				<!--div tab-->

				<ul class="nav nav-tabs">
					<li class="active"><a href="#pane1" data-toggle="tab">หน้าหลัก</a></li>
					<li><a href="#pane2" data-toggle="tab">ข้อมูลรถยนต์</a></li>
					<li><a href="#pane3" data-toggle="tab">จองรถยนต์</a></li>
					<li><a href="#pane4" data-toggle="tab">รายงาน</a></li>
					<li><a href="#pane5" data-toggle="tab">แจ้งปัญหา</a></li>
				</ul>
				<div class="tab-content">
					<!-- เรียกใช้ tab-->
					<br>
					<div id="pane1" class="tab-pane active">
						<!-- div pane1หน้าตารางจอง  แถบใหญ่-->

						<div id="main">
							<form:form modelAttribute="addCarBooking" method="POST"
								action="${pageContext.request.contextPath}/carbookings/view">
								<!-- หน้าแรก-->
								<p
									style="text-align: center; font-weight: bold; font-size: 17pt;">รายการจองรถ</p>

								<table
									class="table table-striped table-bordered table-hover table-responsive">
									<thead>
										<tr>
											<th style="text-align: center;">วันเดือนปี</th>
											<th style="text-align: center;">สถานที่</th>
											<th style="text-align: center;">วัตถุประสงค์</th>
											<th style="text-align: center;">เวลา</th>
											<th style="text-align: center;">ผลการอนุมัติ</th>
											<th style="text-align: center;">รายละเอียด</th>
										</tr>
									</thead>
									<c:choose>
										<c:when test="${not empty retSampleList}">
											<c:forEach var="listValue" items="${retSampleList}">
												<tr>
													<td style="font-size: 13pt;"><c:out
															value="${listValue.datestart}" /></td>
													<td style="font-size: 13pt; text-align: center"><c:out
															value="${listValue.tpidxDesc}" /></td>
													<td style="font-size: 13pt; text-align: center"><c:out
															value="${listValue.objective}" /></td>
													<td style="font-size: 13pt; text-align: center"><c:out
															value="${listValue.timestartDisplay}" /></td>
													<td style="font-size: 13pt; text-align: center"><c:out
															value="${listValue.tsidxDesc}" /></td>

													<td style="text-align: center"><a
														href="<c:url value='/carbookings/view/${listValue.id}'/>?test=showdatarent"><span
															class="btn btn-primary glyphicon glyphicon-list-alt"
															id="btndiv2" aria-hidden="true"
															data-original-title="view" data-toggle="tooltip"></span></a></td>
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
							</form:form>
						</div>
						<!-- ตาราง-->



						<div id="datarent">
							<!--div id="datarent"  -->


							<div id="showdatarent" style="display: none">
								<!--div id="content"  -->
								<form:form modelAttribute="addCarBooking" method="POST"
									action="${pageContext.request.contextPath}/carbookings/savestatus">
									<div>
										<h4
											style="font-size: 16pt; font-weight: bold; text-align: center">ข้อมูลการจองรถยนต์</h4>
									</div>

									<br>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>รูปภาพ:</label>
										</div>

										<div class="col-sm-7">

											<%-- <img id="myImg" name="myImg" class="img-rounded"
												src="/mas/src/main/webapp/WEB-INF/views/place.jpg,<c:out value='${myImage}'/>"> --%>
										</div>
									</div>

									<form:hidden path="id" />
									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ชื่อผู้จอง:</label>
										</div>
										<div class="col-sm-7">
											<label style="width: 130pt; height: 20pt">กานต์ธิดา</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>แผนก:</label>
										</div>
										<div class="col-sm-7">
											<label style="width: 130pt; height: 20pt">MIS</label>
										</div>
									</div>


									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ประเภทการจองรถยนต์:</label>
										</div>
										<div class="col-sm-7">
											<label>${carbooking.tridxDesc}</label>

										</div>
									</div>


									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ประเภทรถยนต์:</label>
										</div>
										<div class="col-sm-7">
											<label>${carbooking.tcidxDesc} </label>
										</div>
									</div>


									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>สถานที่เดินทาง:</label>
										</div>
										<div class="col-sm-9">
											<label>${carbooking.tpidxDesc}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>วันที่เริ่ม:</label>
										</div>
										<div class="col-sm-4">
											<label>${carbooking.datestart}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>วันที่สิ้นสุด:</label>
										</div>
										<div class="col-sm-4">
											<label>${carbooking.dateend}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>เวลาเเริ่ม:</label>
										</div>
										<div class="col-sm-2">
											<label>${carbooking.timestartDisplay}</label>
										</div>
									</div>


									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>เวลาสิ้นสุด:</label>
										</div>
										<div class="col-sm-4">
											<label>${carbooking.timeendDisplay}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ผู้รับผิดชอบ:</label>
										</div>
										<div class="col-sm-3">
											<label>${carbooking.responsible}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>จำนวนผู้เดินทาง :</label>
										</div>
										<div class="col-sm-3">
											<label>${carbooking.qty}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ผู้ร่วมเดินทาง:</label>
										</div>
										<div class="col-sm-9">
											<label>${carbooking.nametip}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>เบอร์โทรศัพท์ :</label>
										</div>
										<div class="col-sm-3">
											<label>${carbooking.tel}</label>
										</div>
									</div>


									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>วัตถุประสงค์ในการเดินทาง:</label>
										</div>
										<div class="col-sm-7">
											<label>${carbooking.objective}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ผลการอนุมัติ:</label>
										</div>
										<div class="col-sm-3">
											<label>${carbooking.tsidxDesc}</label>
										</div>

										<c:choose>
											<c:when test="${not empty status}">
												<div class="col-sm-3">
													<form:select path="tsidx"
														style="width: 130pt; height: 20pt">
														<option>เลือกผลอนุมัติ...</option>
														<c:forEach var="listValue" items="${status}">
															<option value="<c:out value='${listValue.id}' />">
																<c:out value="${listValue.statusTH}" />
															</option>
														</c:forEach>
													</form:select>
												</div>
											</c:when>
										</c:choose>

									</div>
									<br>
									<div class="row">
										<div class="col-sm-1">
											<button type="submit"
												class="btn btn-danger glyphicon glyphicon-arrow-left"
												name="btnsavestatus" data-original-title="back"
												data-toggle="tooltip" value="back"></button>
										</div>
										<div class="col-sm-1">

											<button type="submit"
												class="btn btn-success glyphicon glyphicon-floppy-disk"
												data-original-title="save" data-toggle="tooltip"
												name="btnsavestatus" value="savestatus"></button>
										</div>
										<div class="col-sm-1">
											<a
												href="<c:url value='/carbookings/savestatus/${carbooking.id}'/>?test=editdatarent"><span
												class="btn btn-primary glyphicon glyphicon-edit"
												id="btndiv3" aria-hidden="true" data-original-title="edit"
												data-toggle="tooltip"></span></a>
										</div>
									</div>

									<br>
								</form:form>
							</div>
							<!--div id="content"  -->



							<div id="editdatarent" style="display: none">
								<!-- div edit dataren -->
								<form:form modelAttribute="addCarBooking" method="POST"
									action="${pageContext.request.contextPath}/carbookings/editdata">
									<h4
										style="font-size: 16pt; font-weight: bold; text-align: center">ข้อมูลการจองรถยนต์</h4>


									<br>

									<div class="col-lg-9">
										<!-- div class="col-lg-9" -->
										<div class="form-group">

											<div class="row">
												<div class="col-sm-4" style="text-align: left">
													<label>ชื่อผู้จอง:</label>
												</div>
												<div class="col-sm-7">
													<label style="width: 130pt; height: 20pt">กานต์ธิดา</label>
												</div>
											</div>

											<div class="row">
												<div class="col-sm-4" style="text-align: left">
													<label>แผนก:</label>
												</div>
												<div class="col-sm-7">
													<label style="width: 130pt; height: 20pt">MIS</label>
												</div>
											</div>

											<div class="col-sm-4" style="text-align: left">
												<label>ประเภทการจองรถยนต์:</label>
											</div>
											<c:choose>
												<c:when test="${not empty typerent}">
													<div class="col-sm-7">
														<form:select id="selectTypeRentId" path="tridx"
															style="width: 130pt; height: 20pt">
															<c:forEach items="${typerent}" var="listValue">
																<option
																	<c:if test="${listValue.id eq carbooking.tridx}">selected="selected"</c:if>
																	value="${listValue.id}">${listValue.typerentTH}</option>
															</c:forEach>
														</form:select>
													</div>
												</c:when>
											</c:choose>
										</div>




										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>ประเภทการรถยนต์:</label>
											</div>
											<c:choose>
												<c:when test="${not empty typecar}">

													<div class="col-sm-7">
														<form:select id="selectTypeCarId" path="tcidx"
															style="width: 130pt; height: 20pt">
															<c:forEach items="${typecar}" var="listValue">
																<option
																	<c:if test="${listValue.id eq carbooking.tcidx}">selected="selected"</c:if>
																	value="${listValue.id}">${listValue.typeCarTH}</option>
															</c:forEach>
														</form:select>
													</div>
												</c:when>
											</c:choose>

										</div>



										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>สถานที่เดินทาง:</label>
											</div>
											<c:choose>
												<c:when test="${not empty place}">

													 <div class="col-sm-3">
														<form:select id="selectPlaceId" path="tpidx"
															style="width: 130pt; height: 20pt">
															<c:forEach items="${place}" var="listValue">
																<option
																	<c:if test="${listValue.id eq carbooking.tpidx}">selected="selected"</c:if>
																	value="${listValue.id}">${listValue.placeTH}</option>
															</c:forEach>
														</form:select>
													</div>
												</c:when>
											</c:choose>
											<div class="col-sm-3">
												<input type="text" placeHolder="อื่นๆ โปรดระบุ..."
													style="width: 100pt; height: 20pt">
											</div>
										</div>




										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>วันที่เริ่ม:</label>
											</div>
											<div class="col-sm-5">
												<form:input path="datestart"
													style="width: 130pt; height: 20pt" id="example5"></form:input>
											</div>
										</div>




										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>วันที่สิ้นสุด:</label>
											</div>
											<div class="col-sm-5">
												<form:input path="dateend"
													style="width: 130pt; height: 20pt" id="example6"></form:input>
											</div>
										</div>



										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>เวลาเริ่ม:</label>
											</div>
											<div class="col-sm-5">
												<c:choose>
													<c:when test="${not empty listTime}">
															<form:select path="timestartDisplay" style="width: 130pt; height: 20pt">
																<c:forEach items="${listTime}" var="listValue">
																	<option
																		<c:if test="${listValue.id eq carbooking.timestart}">selected="selected"</c:if>
																		value="${listValue.id}">${listValue.name}</option>
																</c:forEach>
															</form:select>
														
													</c:when>
												</c:choose>
												
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>เวลาสิ้นสุด:</label>
											</div>
											<div class="col-sm-5">
												<c:choose>
													<c:when test="${not empty listTime}">
			
														<form:select path="timeendDisplay" style="width: 130pt; height: 20pt">
																<c:forEach items="${listTime}" var="listValue">
																	<option
																		<c:if test="${listValue.id eq carbooking.timeend}">selected="selected"</c:if>
																		value="${listValue.id}">${listValue.name}</option>
																</c:forEach>
															</form:select>
														
													</c:when>
												</c:choose>
												
											</div>
										</div>



										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>ผู้รับผิดชอบ:</label>
											</div>
											<div class="col-sm-5">
												<form:input path="responsible"
													style="width: 130pt; Height: 20pt"></form:input>
											</div>
										</div>


										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>ผู้ร่วมเดินทาง:</label>
											</div>
											<div class="col-sm-5">
												<form:input path="nametip"
													style="width: 130pt; Height: 20pt"></form:input>
											</div>
										</div>


										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>จำนวนผู้เดินทาง:</label>
											</div>
											<div class="col-sm-5">
											<c:choose>
													<c:when test="${not empty listQty}">
															<form:select path="qty" style="width: 130pt; height: 20pt">
																<c:forEach items="${listQty}" var="listValue">
																	<option
																		<c:if test="${listValue.id eq carbooking.qty}">selected="selected"</c:if>
																		value="${listValue.id}">${listValue.name}</option>
																</c:forEach>
															</form:select>
														
													</c:when>
												</c:choose>
												<%-- <form:select path="qty" style="Width: 130pt; Height: 20pt">
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
												</form:select> --%>
											</div>
										</div>




										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>เบอร์โทรศัพท์ :</label>
											</div>
											<div class="col-sm-5">
												<form:input path="tel" style="width: 130pt; Height: 20pt"
													PlaceHolder="เบอร์โทรศัพท์ มือถือ"></form:input>
											</div>
										</div>


										<div class="form-group">
											<div class="col-sm-4" style="text-align: left">
												<label>วัตถุประสงค์เดินทาง:</label>
											</div>
											<div class="col-sm-7">
												<form:textarea path="objective" rows="5" id="comment"></form:textarea>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-4" style="text-align: left">
												<label>ผลการอนุมัติ:</label>
											</div>

											<c:choose>
												<c:when test="${not empty status}">
													<div class="col-sm-3">
														<%-- <form:select path="tsidx"
															style="width: 130pt; height: 20pt">
															<c:forEach var="listValue" items="${status}">
																<option value="<c:out value='${listValue.id}' />">
																	<c:out value="${listValue.statusTH}" />
																</option>
															</c:forEach> 
														</form:select>--%>
														<form:select id="selectStatusId" path="tsidx"
															style="width: 130pt; height: 20pt">
															<c:forEach items="${status}" var="listValue">
																<option
																	<c:if test="${listValue.id eq carbooking.tsidx}">selected="selected"</c:if>
																	value="${listValue.id}">${listValue.statusTH}</option>
															</c:forEach>
														</form:select>
													</div>
												</c:when>
											</c:choose>
										</div>
										<br>

										<div class="row" style="padding-left: 200pt">
											<div class="col-sm-6" style="text-align: left">

												<button type="submit"
													class="btn btn-success glyphicon glyphicon-ok"
													data-original-title="save" data-toggle="tooltip"
													name="btnedit" value="edit"></button>

												<button type="submit"
													class="btn btn-danger glyphicon glyphicon-remove"
													data-original-title="cancel" data-toggle="tooltip"
													value="main" name="btnedit"></button>


											</div>
										</div>
										<br>




									</div>
									<!-- div class="col-lg-9" -->
								</form:form>
							</div>
							<!-- div edit dataren -->
						</div>
						<!--div id="datarent"  -->

					</div>
					<!-- div pane1หน้าตารางจอง  แถบใหญ่-->


					<!-- Tab2 -->
					<div id="pane2" class="tab-pane">
						<form:form modelAttribute="addCarBooking">
							<!-- div pane2-->
							<div class="row">
								<h4
									style="font-size: 16pt; font-weight: bold; text-align: center">ข้อมูลรถยนต์</h4>
							</div>
							<br>
							<c:choose>
								<c:when test="${not empty datacarList}">
									<c:forEach var="listValue" items="${datacarList}">
										<fieldset
											style="margin-top: 3px; border: 3px dashed #000000; background-color: #eeeeee; overflow: auto; margin-left: 1%; float: left;"
											class="col-lg-11">
											<br>

											<!--  <div class="col-lg-3">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img	src="Image/download.jpg"></a>

								</div>
							</div>-->

											<div>
												<div class="form-group">
													<div class="col-sm-3">
														<label style="font-weight: bold; text-align: left">ประเภทรถยนต์
															:</label>
													</div>
													<div class="col-sm-2">
														<label style="font-weight: bold">${listValue.tcidxDesc}</label>
													</div>
													<div class="col-sm-2">
														<label style="font-weight: bold; text-align: left">ยี่ห้อรถยนต์:</label>
													</div>
													<div class="col-sm-5">
														<label style="font-weight: bold">${listValue.tbidxDesc}</label>
													</div>
												</div>


												<div class="form-group">
													<div class="col-sm-3">
														<label style="font-weight: bold; text-align: left">สีรถยนต์
															:</label>
													</div>
													<div class="col-sm-2">
														<label style="font-weight: bold">${listValue.color}</label>
													</div>
													<div class="col-sm-2">
														<label style="font-weight: bold; text-align: left">ทะเบียนรถ:</label>
													</div>
													<div class="col-sm-5">
														<label style="font-weight: bold">${listValue.carli}</label>
													</div>
												</div>




												<div class="form-group">
													<div class="col-sm-3">
														<label style="font-weight: bold; text-align: left">จำนวนที่นั่ง
															:</label>
													</div>
													<div class="col-sm-2">
														<label style="font-weight: bold">${listValue.qty}</label>
													</div>
													<div class="col-sm-2">
														<label style="font-weight: bold; text-align: left">สถานะใช้งาน:</label>
													</div>
													<div class="col-sm-5">
														<label style="font-weight: bold">${listValue.tcStatusDesc}</label>
													</div>
												</div>




												<div class="form-group">
													<div class="col-sm-3">
														<label style="font-weight: bold; text-align: left">พนักงานขับรถ
															:</label>
													</div>
													<div class="col-sm-9">
														<label style="font-weight: bold">วิรัช
															สุพรรณคง(วิรัช)</label>
													</div>
												</div>



											</div>
										</fieldset>
									</c:forEach>
								</c:when>

								<c:otherwise>
									<fieldset
										style="margin-top: 3px; border: 3px dashed #000000; background-color: #eeeeee; overflow: auto; margin-left: 1%; float: left;"
										class="col-lg-11">
										<br>

										<div>
											<div class="form-group">
												<div class="col-sm-3">
													<label style="font-weight: bold; text-align: left">ประเภทรถยนต์
														:</label>
												</div>
												<div class="col-sm-2">
													<label style="font-weight: bold"></label>
												</div>
												<div class="col-sm-2">
													<label style="font-weight: bold; text-align: left">ยี่ห้อรถยนต์:</label>
												</div>
												<div class="col-sm-5">
													<label style="font-weight: bold"></label>
												</div>
											</div>


											<div class="form-group">
												<div class="col-sm-3">
													<label style="font-weight: bold; text-align: left">สีรถยนต์
														:</label>
												</div>
												<div class="col-sm-2">
													<label style="font-weight: bold"></label>
												</div>
												<div class="col-sm-2">
													<label style="font-weight: bold; text-align: left">ทะเบียนรถ:</label>
												</div>
												<div class="col-sm-5">
													<label style="font-weight: bold"></label>
												</div>
											</div>




											<div class="form-group">
												<div class="col-sm-3">
													<label style="font-weight: bold; text-align: left">จำนวนที่นั่ง
														:</label>
												</div>
												<div class="col-sm-2">
													<label style="font-weight: bold"></label>
												</div>
												<div class="col-sm-2">
													<label style="font-weight: bold; text-align: left">สถานะใช้งาน:</label>
												</div>
												<div class="col-sm-5">
													<label style="font-weight: bold"></label>
												</div>
											</div>




											<div class="form-group">
												<div class="col-sm-3">
													<label style="font-weight: bold; text-align: left">พนักงานขับรถ
														:</label>
												</div>
												<div class="col-sm-9">
													<label style="font-weight: bold"></label>
												</div>
											</div>



										</div>
									</fieldset>
								</c:otherwise>
							</c:choose>
						</form:form>
					</div>

					<!-- div pane2-->


					<!-- Tab3 -->
					<div id="pane3" class="tab-pane">
						<!-- div pan3-->
						<form:form modelAttribute="addCarBooking" method="POST"
							action="${pageContext.request.contextPath}/carbookings/save">
							<div class="row">
								<h4
									style="font-size: 16pt; font-weight: bold; text-align: center">ขั้นตอนการจองรถยนต์</h4>
							</div>
							<br>

							<div class="col-lg-9">
								<!-- div class="col-lg-9" -->
								<div class="form-group">

									<div class="row">
										<div class="col-sm-4" style="text-align: left">
											<label>ชื่อผู้จอง:</label>
										</div>
										<div class="col-sm-7">
											<form:label path="empidx" style="width: 130pt; height: 20pt">กานต์ธิดา</form:label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4" style="text-align: left">
											<label>แผนก:</label>
										</div>
										<div class="col-sm-7">
											<form:label path="departidx"
												style="width: 130pt; height: 20pt">MIS</form:label>
										</div>
									</div>


									<div class="col-sm-4" style="text-align: left">
										<label>ประเภทการจองรถยนต์:</label>
									</div>
									<c:choose>
										<c:when test="${not empty typerent}">
											<div class="col-sm-7">
												<form:select path="tridx" style="width: 130pt; height: 20pt">
													<option>กรุณาเลือกข้อมูล</option>
													<c:forEach var="listValue" items="${typerent}">
														<option value="<c:out value='${listValue.id}' />">
															<c:out value="${listValue.typerentTH}" />
														</option>
													</c:forEach>
												</form:select>
											</div>
										</c:when>
									</c:choose>

								</div>

								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>ประเภทการรถยนต์:</label>
									</div>

									<c:choose>
										<c:when test="${not empty typecar}">

											<div class="col-sm-7">
												<form:select path="tcidx" style="width: 130pt; height: 20pt">
													<option>กรุณาเลือกข้อมูล</option>
													<c:forEach var="listValue" items="${typecar}">
														<option value="<c:out value='${listValue.id}' />">
															<c:out value="${listValue.typeCarTH}" />
														</option>
													</c:forEach>

												</form:select>
											</div>
										</c:when>
									</c:choose>


								</div>



								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>สถานที่เดินทาง:</label>
									</div>
									<c:choose>
										<c:when test="${not empty place}">

											<div class="col-sm-3">
												<form:select path="tpidx" style="width: 130pt; height: 20pt">
													<option>กรุณาเลือกข้อมูล</option>
													<c:forEach var="listValue" items="${place}">
														<option value="<c:out value='${listValue.id}' />">
															<c:out value="${listValue.placeTH}" />
														</option>
													</c:forEach>

												</form:select>
											</div>
										</c:when>
									</c:choose>
									<div class="col-sm-3">
										<form:input path="etcplace" class="testx"
											placeHolder="อื่นๆ โปรดระบุ..."
											style="width: 100pt; height: 20pt"></form:input>
									</div>
								</div>




								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>วันที่เริ่ม:</label>
									</div>
									<div class="col-sm-5">
										<form:input path="datestart" class="testx" id="example3"
											style="background-color: #FFFFFF; width: 130pt; Height: 20pt"></form:input>
									</div>
								</div>




								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>วันที่สิ้นสุด:</label>
									</div>
									<div class="col-sm-5">
										<form:input path="dateend" class="testx" id="example4"
											style="background-color: #FFFFFF; width: 130pt; Height: 20pt"
											name="txtdateend"></form:input>
									</div>
								</div>



								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>เวลาเริ่ม:</label>
									</div>
									<div class="col-sm-5">
										<form:select path="timestart"
											style="width: 130pt; height: 20pt">
											<option value="">- เวลาไป -</option>
											<option value="0000">00:00</option>
											<option value="0030">00:30</option>
											<option value="0100">01:00</option>
											<option value="0130">01:30</option>
											<option value="0200">02:00</option>
											<option value="0230">02:30</option>
											<option value="0300">03:00</option>
											<option value="0330">03:30</option>
											<option value="0400">04:00</option>
											<option value="0430">04:30</option>
											<option value="0500">05:00</option>
											<option value="0530">05:30</option>
											<option value="0600">06:00</option>
											<option value="0630">06:30</option>
											<option value="0700">07:00</option>
											<option value="0730">07:30</option>
											<option value="0800">08:00</option>
											<option value="0830">08:30</option>
											<option value="0900">09:00</option>
											<option value="0930">09:30</option>
											<option value="1000">10:00</option>
											<option value="1030">10:30</option>
											<option value="1100">11:00</option>
											<option value="1130">11:30</option>
											<option value="1200">12:00</option>
											<option value="1230">12:30</option>
											<option value="1300">13:00</option>
											<option value="1330">13:30</option>
											<option value="1400">14:00</option>
											<option value="1430">14:30</option>
											<option value="1500">15:00</option>
											<option value="1530">15:30</option>
											<option value="1600">16:00</option>
											<option value="1630">16:30</option>
											<option value="1700">17:00</option>
											<option value="1730">17:30</option>
											<option value="1800">18:00</option>
											<option value="1830">18:30</option>
											<option value="1900">19:00</option>
											<option value="1930">19:30</option>
											<option value="2000">20:00</option>
											<option value="2030">20:30</option>
											<option value="2100">21:00</option>
											<option value="2130">21:30</option>
											<option value="2200">22:00</option>
											<option value="2230">22:30</option>
											<option value="2300">23:00</option>
											<option value="2330">23:30</option>
											<option value="2400">24:00</option>
										</form:select>

									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>เวลาสิ้นสุด:</label>
									</div>
									<div class="col-sm-5">
										<form:select path="timeend" style="width: 130pt; height: 20pt">
											<option value="">- เวลากลับ -</option>
											<option value="0000">00:00</option>
											<option value="0030">00:30</option>
											<option value="0100">01:00</option>
											<option value="0130">01:30</option>
											<option value="0200">02:00</option>
											<option value="0230">02:30</option>
											<option value="0300">03:00</option>
											<option value="0330">03:30</option>
											<option value="0400">04:00</option>
											<option value="0430">04:30</option>
											<option value="0500">05:00</option>
											<option value="0530">05:30</option>
											<option value="0600">06:00</option>
											<option value="0630">06:30</option>
											<option value="0700">07:00</option>
											<option value="0730">07:30</option>
											<option value="0800">08:00</option>
											<option value="0830">08:30</option>
											<option value="0900">09:00</option>
											<option value="0930">09:30</option>
											<option value="1000">10:00</option>
											<option value="1030">10:30</option>
											<option value="1100">11:00</option>
											<option value="1130">11:30</option>
											<option value="1200">12:00</option>
											<option value="1230">12:30</option>
											<option value="1300">13:00</option>
											<option value="1330">13:30</option>
											<option value="1400">14:00</option>
											<option value="1430">14:30</option>
											<option value="1500">15:00</option>
											<option value="1530">15:30</option>
											<option value="1600">16:00</option>
											<option value="1630">16:30</option>
											<option value="1700">17:00</option>
											<option value="1730">17:30</option>
											<option value="1800">18:00</option>
											<option value="1830">18:30</option>
											<option value="1900">19:00</option>
											<option value="1930">19:30</option>
											<option value="2000">20:00</option>
											<option value="2030">20:30</option>
											<option value="2100">21:00</option>
											<option value="2130">21:30</option>
											<option value="2200">22:00</option>
											<option value="2230">22:30</option>
											<option value="2300">23:00</option>
											<option value="2330">23:30</option>
											<option value="2400">24:00</option>
										</form:select>
									</div>
								</div>



								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>ผู้รับผิดชอบ:</label>
									</div>
									<div class="col-sm-5">
										<form:input path="responsible" class="testx"
											style="width: 130pt; Height: 20pt"></form:input>
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>จำนวนผู้เดินทาง:</label>
									</div>
									<div class="col-sm-5">
										<form:select path="qty" style="Width: 130pt; Height: 20pt">
											<option value="00">กรุณาเลือกจำนวนคน...</option>
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
									<div class="col-sm-4" style="text-align: left">
										<label>รายชื่อผู้เดินทาง :</label>
									</div>
									<div class="col-sm-5">
										<form:input path="nametip" style="width: 130pt; Height: 20pt"
											class="testx"></form:input>
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>เบอร์โทรศัพท์ :</label>
									</div>
									<div class="col-sm-5">
										<form:input path="tel" style="width: 130pt; Height: 20pt"
											class="testx" PlaceHolder="เบอร์โทรศัพท์ มือถือ"></form:input>
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>วัตถุประสงค์เดินทาง:</label>
									</div>
									<div class="col-sm-7">
										<form:textarea path="objective" rows="5" class="testx"
											id="comment"></form:textarea>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4" style="text-align: left">
										<label>แนบไฟล์รูปภาพ:</label>
									</div>
									<div class="col-sm-7">
										<input type="file" name="upload_file" />
									</div>
								</div>



								<div class="form-group">
									<div class="col-sm-8" style="padding-left: 220pt">
										<button type="submit" name="btnsave" value="savecarbooking"
											class="btn btn-success glyphicon glyphicon-floppy-disk"
											data-original-title="send" data-toggle="tooltip"></button>
										<button type="submit" name="btnsave" value="cancel"
											class="btn btn-danger glyphicon glyphicon-remove"
											data-original-title="cancel" data-toggle="tooltip"></button>


									</div>
								</div>
							</div>
							<!-- div class="col-lg-9" -->
						</form:form>
					</div>
					<!-- div pane3-->


					<!-- Tab4 -->
					<div id="pane4" class="tab-pane">
						<!-- div pane4-->

						<div class="row" id="reportdata">

							<div>
								<button type="submit"
									class="btn btn-primary glyphicon glyphicon-list-alt"
									data-original-title="view" data-toggle="tooltip"
									style="font-size: 11pt; width: 50pt; height: 20pt"
									onclick="Show_Div2('reporttable')"></button>
							</div>
							<br>
							<div>
								<fieldset
									style="width: 750pt; height: 50pt; margin-top: 3px; border: 0px dashed #009900; background-color: #eeeeee; overflow: auto; margin-left: 1%; float: left; text-align: center;">
									<br>
									<h4 style="font-size: 24pt; text-align: center;">---ไม่มีข้อมูลแสดง---</h4>
								</fieldset>

							</div>
						</div>

						<div id="reporttable" style="display: none">
							<!-- ตารางรีพอร์ท -->
							<table
								class="table table-striped table-bordered table-hover table-responsive;">
								<thead>
									<tr>
										<th style="text-align: center;">ลำดับที่</th>
										<th style="text-align: center;">แผนก</th>
										<th style="text-align: center;">ผู้จอง</th>
										<th style="text-align: center;">ประเภทการจอง</th>
										<th style="text-align: center;">ประเภทรถยนต์</th>
										<th style="text-align: center;">สถานที่</th>
										<th style="text-align: center;">วันเวลาเดินทาง</th>
										<th style="text-align: center;">ผลการอนุมัติ</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="text-align: center;">1</td>
										<td style="text-align: center;">MIS</td>
										<td style="text-align: center;">กานต์ธิดา</td>
										<td style="text-align: center;">เหมา</td>
										<td style="text-align: center;">รถตู้</td>
										<td style="text-align: center;">ลาดพร้าว</td>
										<td style="text-align: center;">22/July/2015 08:30</td>
										<td style="text-align: center;">อนุมัติ</td>

									</tr>

								</tbody>
							</table>
							<!-- <button type="button"
								class="btn btn-danger glyphicon glyphicon-arrow-left"
								data-original-title="back" data-toggle="tooltip"
								style="font-size: 11pt; width: 50pt; height: 20pt"
								onclick="Show_Div2('reportdata')"></button> -->
						</div>
						<!-- ตารางรีพอร์ท -->

					</div>
					<!-- div pane4-->


					<!-- Tab 5 -->
					<div id="pane5" class="tab-pane">
						<!-- div pane5-->

						<div class="row">
							<p style="text-align: center; font-weight: bold; font-size: 17pt">แจ้งปัญหา</p>
							<br>
						</div>

						<!-- ส่วนแจ้งปัญหา user-->

						<div id="user" style="display: none">
							<form:form modelAttribute="addCarBooking" method="POST"
								action="${pageContext.request.contextPath}/carbookings/problem">
								<div>
									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>หัวข้อ :</label>
										</div>
										<div class="col-sm-7">
											<form:input path="topic" class="testx"
												style="width: 150pt; Height: 20pt"></form:input>
										</div>
									</div>

									<br>


									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label> ข้อความ :</label>
										</div>
										<div class="col-sm-7">
											<form:textarea path="context" rows="5" id="comment"
												class="testx" style="width: 150pt"></form:textarea>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label> ติดต่อ :</label>
										</div>
										<div class="col-sm-7">
											<form:input path="tel" style="width: 150pt; Height: 20pt;"
												class="testx" PlaceHolder="กรุณาระบุเบอร์โทรศัพท์"></form:input>
										</div>
									</div>
									<br>
									<div class="row">
										<div style="text-align: left; padding-left: 225pt">
											<button type="submit" name="btnproblem" value="saveproblem"
												class="btn btn-success glyphicon glyphicon-floppy-disk"
												data-original-title="send" data-toggle="tooltip"
												style="font-size: 11pt; width: 50pt; height: 20pt"></button>

											<button type="submit"
												class="btn btn-danger glyphicon glyphicon-remove"
												name="btnproblem" value="cancel"
												data-original-title="cancel" data-toggle="tooltip"
												style="font-size: 11pt; width: 50pt; height: 20pt"></button>
										</div>
									</div>
								</div>
								<br>
								<br>
								<br>
								<div id="tableuser">
									<table
										class="table table-striped table-bordered table-hover table-responsive;">
										<thead>
											<tr>
												<th style="text-align: center;">ลำดับที่</th>
												<th style="text-align: center;">หัวข้อ</th>
												<th style="text-align: center;">ปัญหาที่เกิดขึ้น</th>
												<th style="text-align: center;">สถานะ</th>
											</tr>
										</thead>
										<c:choose>
											<c:when test="${not empty problemList}">
												<c:forEach var="listValue" items="${problemList}">
													<tr>
														<td style="text-align: center;"><c:out
																value="${listValue.id}" /></td>
														<td style="text-align: center;"><c:out
																value="${listValue.topic}" /></td>
														<td style="text-align: center;"><c:out
																value="${listValue.context}" /></td>
														<td style="text-align: center;"><c:out
																value="${listValue.tspidxDesc}" /></td>

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
							</form:form>
						</div>




						<!-- ส่วนแจ้งปัญหา Admin-->
						<div id="admin">


							<!-- ส่วนแจ้งปัญหา Admin -->
							<div id="tablepro">
								<form:form modelAttribute="addCarBooking" method="POST"
									action="${pageContext.request.contextPath}/carbookings/viewproblem">
									<table
										class="table table-striped table-bordered table-hover table-responsive">
										<thead>
											<tr>
												<th style="text-align: center;">ลำดับที่</th>
												<th style="text-align: center;">หัวข้อ</th>
												<th style="text-align: center;">สถานะ</th>
												<th style="text-align: center;">เพิ่มเติม</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<c:choose>
													<c:when test="${not empty problemList}">
														<c:forEach var="listValue" items="${problemList}">
															<tr>
																<td style="text-align: center;"><c:out
																		value="${listValue.id}" /></td>
																<td style="text-align: center;"><c:out
																		value="${listValue.topic}" /></td>
																<td style="text-align: center;"><c:out
																		value="${listValue.tspidxDesc}" /></td>
																<td style="text-align: center;"><a
																	href="<c:url value='/carbookings/viewproblem/${listValue.id}'/>?tests=adminproblem"><span
																		class="btn btn-primary glyphicon glyphicon-list-alt"
																		id="btndiv2" aria-hidden="true"
																		data-original-title="view" data-toggle="tooltip"></span></a></td>

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


											</tr>
										</tbody>
									</table>
								</form:form>
							</div>


							<br>

							<div id="adminproblem" style="display: none">
								<form:form modelAttribute="addCarBooking">
									<div class="row">
										<form:hidden path="tbpidx" />
										<div class="col-sm-3" style="text-align: left">
											<label>ชื่อผู้แจ้ง :</label>
										</div>
										<div class="col-sm-7">
											<label>นางสาว กานต์ธิดา ตระกูลบุญรักษ์</label>
										</div>
									</div>
									<br>

									<div class="row">
										<div class="col-sm-3">
											<label>ชื่อหัวข้อ</label>
										</div>
										<div class="col-sm-7">
											<label>${problem.topic}</label>
										</div>

									</div>

									<div class="row">
										<div class="col-sm-3">
											<label>เนื้อหาข้อความ</label>
										</div>
										<div class="col-sm-9">
											<label>${problem.context}</label>
										</div>
									</div>


									<br>
									<div class="row">
										<div class="col-sm-3">
											<label>เบอร์โทรศัพท์ติดต่อ</label>
										</div>
										<div class="col-sm-9">
											<label>${problem.telproblem}</label>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-3" style="text-align: left">
											<label>ผลการอนุมัติ:</label>
										</div>

										<div class="col-sm-9">
											<select style="Width: 130pt; Height: 20pt">
												<option value="none">เลือกผลอนุมัติ...</option>
												<option value="2">รับทราบ</option>

											</select>
										</div>
									</div>


									<br>

									<div class="row" style="padding-left: 220pt">
										<div class="col-sm-4" style="text-align: left">
											<button type="submit"
												class="btn btn-success glyphicon glyphicon-floppy-disk"
												data-original-title="accept" data-toggle="tooltip"
												style="font-size: 11pt; width: 50pt; height: 20pt"></button>
											<button type="submit"
												class="btn btn-danger glyphicon glyphicon-arrow-left"
												style="font-size: 11pt; width: 50pt; height: 20pt"
												data-original-title="back" data-toggle="tooltip"
												onclick="Show_Div1('tablepro')"></button>
										</div>
									</div>


								</form:form>
							</div>

						</div>
						<!-- ปิดส่วน Admin -->



					</div>
					<!-- div pane5-->
				</div>
				<!-- เรียกใช้ tab-->



			</div>
			<!--div tab-->


		</div>
		<!--div form-->

	</div>
	<!--div master-->



</body>
</html>
