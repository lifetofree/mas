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
				<h1 style="text-align: center">ระบบจองรถยนต์ Car Booking</h1>
			</div>
			<br>

			<!-- Search Box -->

			<div>
				<button type="button" class="btn"
					style="font-size: 11pt; width: 100pt; height: 20pt"
					onclick="Show_Divsearch(search)" id="btndiv1">Show Search</button>
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
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
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
							<button type="button" class="glyphicon glyphicon-search"
								style="font-size: 11pt; width: 70pt; height: 25pt">Search</button>
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
								<tbody>

									<tr>

										<td>17/07/58</td>
										<td>เมืองทองธานี</td>
										<td>ประชุม</td>
										<td>14:00</td>
										<td>อนุมัติ</td>
										<td style="text-align: center;"><button type="button"
												class="btn"
												style="font-size: 11pt; width: 50pt; height: 20pt"
												id="btndiv2" onclick="Show_Div('showdatarent')"
												value="showdatarent">ดู</button></td>
									</tr>
								</tbody>
							</table>


						</div>
						<!-- ตาราง-->







						<div id="datarent">
							<!--div id="datarent"  -->


							<div id="showdatarent" style="display: none">
								<!--div id="content"  -->
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
										<label>ไฟล์รูปภาพ</label>
									</div>
								</div>



								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ชื่อผู้จอง:</label>
									</div>
									<div class="col-sm-7">
										<label style="width: 130pt; height: 20pt">ชื่อ</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>แผนก:</label>
									</div>
									<div class="col-sm-7">
										<label style="width: 130pt; height: 20pt">แผนก</label>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ประเภทการจองรถยนต์:</label>
									</div>
									<div class="col-sm-7">
										<label style="width: 130pt; height: 20pt">ข้อมูลประเภทการจองรถยนต์</label>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ประเภทรถยนต์:</label>
									</div>
									<div class="col-sm-7">
										<label style="width: 130pt; height: 20pt">ข้อมูลประเภทรถยนต์
										</label>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>สถานที่เดินทาง:</label>
									</div>
									<div class="col-sm-9">
										<label style="width: 130pt; height: 20pt">ข้อมูลสถานที่เดินทาง
										</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>วันที่เริ่ม:</label>
									</div>
									<div class="col-sm-2">
										<label style="width: 130pt; height: 20pt">วันที่เริ่ม</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>วันที่สิ้นสุด:</label>
									</div>
									<div class="col-sm-4">
										<label style="width: 130pt; height: 20pt">วันที่สิ้นสุด</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>เวลาเเริ่ม:</label>
									</div>
									<div class="col-sm-2">
										<label style="width: 130pt; height: 20pt">เวลาเริ่ม</label>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>เวลาสิ้นสุด:</label>
									</div>
									<div class="col-sm-4">
										<label style="width: 130pt; height: 20pt">เวลาสิ้นสุด</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ผู้รับผิดชอบ:</label>
									</div>
									<div class="col-sm-3">
										<label style="width: 500pt; height: 20pt">ชื่อผู้รับผิดชอบ</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>เบอร์โทรศัพท์ :</label>
									</div>
									<div class="col-sm-3">
										<label style="width: 130pt; height: 20pt">เบอร์โทรศัพท์ติดต่อ</label>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ผู้ร่วมเดินทาง:</label>
									</div>
									<div class="col-sm-9">
										<label style="width: 300pt; height: 20pt">ชื่อผู้ร่วมเดินทาง</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>จำนวนผู้เดินทาง:</label>
									</div>
									<div class="col-sm-9">
										<label style="width: 130pt; height: 20pt">จำนวนคนที่เดินทาง</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>วัตถุประสงค์ในการเดินทาง:</label>
									</div>
									<div class="col-sm-7">
										<label style="width: 130pt; height: 20pt">วัตถุประสงค์ในการเดินทาง</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ผลการอนุมัติ:</label>
									</div>
									<div class="col-sm-7" style="display: none">
										<label style="width: 130pt; height: 20pt">ผลการอนุมัติ</label>
									</div>
									<div class="col-sm-9">
										<select style="Width: 130pt; Height: 20pt">
											<option value="00">เลือกผลอนุมัติ...</option>
											<option value="1">อนุมัติแล้ว</option>
											<option value="2">รออนุมัติ</option>
											<option value="3">ไม่อนุมัติ</option>
											<option value="3">ยกเลิก</option>
										</select>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-sm-1" style="text-align: left">
										<button type="button" class="btn"
											style="font-size: 11pt; width: 50pt; height: 20pt">Save</button>
									</div>

									<div class="col-sm-1" id="edit">
										<button type="button" class="btn"
											style="font-size: 11pt; width: 50pt; height: 20pt"
											id="btndiv3" onclick="Show_Div('editdatarent')"
											value="editdatarent">Edit</button>
									</div>
									<div class="col-sm-1">
										<button type="button" class="btn"
											style="font-size: 11pt; width: 50pt; height: 20pt">Back</button>
									</div>

								</div>



							</div>
							<!--div id="content"  -->



							<div id="editdatarent" style="display: none">
								<!-- div edit dataren -->
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
												<label style="width: 130pt; height: 20pt">ชื่อ</label>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-4" style="text-align: left">
												<label>แผนก:</label>
											</div>
											<div class="col-sm-7">
												<label style="width: 130pt; height: 20pt">แผนก</label>
											</div>
										</div>

										<div class="col-sm-4" style="text-align: left">
											<label>ประเภทการจองรถยนต์:</label>
										</div>
										<div class="col-sm-7">
											<select style="Width: 130pt; Height: 20pt">
												<option value="00">กรุณาเลือกข้อมูล...</option>
												<option value="1">เหมา</option>
												<option value="2">ไปรับ-ไปส่ง</option>
											</select>
										</div>
									</div>




									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>ประเภทการรถยนต์:</label>
										</div>
										<div class="col-sm-7">
											<select style="Width: 130pt; Height: 20pt">
												<option value="00">กรุณาเลือกข้อมูล...</option>
												<option value="1">รถบรรทุก</option>
												<option value="2">รถตู้</option>
											</select>
										</div>
									</div>



									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>สถานที่เดินทาง:</label>
										</div>
										<div class="col-sm-3">
											<select style="Width: 130pt; Height: 20pt">
												<option value="00">กรุณาเลือกข้อมูล...</option>
												<option value="1">เมืองทองธานี</option>
												<option value="2">นพวงศ์</option>
											</select>
										</div>
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
											<input type="text" id="example5"
												style="background-color: #FFFFFF; width: 130pt; Height: 20pt"
												name="txtdatestartedit">
										</div>
									</div>




									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>วันที่สิ้นสุด:</label>
										</div>
										<div class="col-sm-5">
											<input type="text" id="example6"
												style="background-color: #FFFFFF; width: 130pt; Height: 20pt"
												name="txtdateendedit">
										</div>
									</div>



									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>เวลาเริ่ม:</label>
										</div>
										<div class="col-sm-5">
											<select name="start_time" id="start_time"
												style="width: 130pt; height: 20pt">
												<option value="">- เวลาไป -</option>
												<option value="1">00:00</option>
												<option value="2">00:30</option>
												<option value="3">01:00</option>
												<option value="4">01:30</option>
												<option value="5">02:00</option>
												<option value="6">02:30</option>
												<option value="7">03:00</option>
												<option value="8">03:30</option>
												<option value="9">04:00</option>
												<option value="10">04:30</option>
												<option value="11">05:00</option>
												<option value="12">05:30</option>
												<option value="13">06:00</option>
												<option value="14">06:30</option>
												<option value="15">07:00</option>
												<option value="16">07:30</option>
												<option value="17">08:00</option>
												<option value="18">08:30</option>
												<option value="19">09:00</option>
												<option value="20">09:30</option>
												<option value="21">10:00</option>
												<option value="22">10:30</option>
												<option value="23">11:00</option>
												<option value="24">11:30</option>
												<option value="25">12:00</option>
												<option value="26">12:30</option>
												<option value="27">13:00</option>
												<option value="28">13:30</option>
												<option value="29">14:00</option>
												<option value="30">14:30</option>
												<option value="31">15:00</option>
												<option value="32">15:30</option>
												<option value="33">16:00</option>
												<option value="34">16:30</option>
												<option value="35">17:00</option>
												<option value="36">17:30</option>
												<option value="37">18:00</option>
												<option value="38">18:30</option>
												<option value="39">19:00</option>
												<option value="40">19:30</option>
												<option value="41">20:00</option>
												<option value="42">20:30</option>
												<option value="43">21:00</option>
												<option value="44">21:30</option>
												<option value="45">22:00</option>
												<option value="46">22:30</option>
												<option value="47">23:00</option>
												<option value="48">23:30</option>
												<option value="49">24:00</option>
											</select>

										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>เวลาสิ้นสุด:</label>
										</div>
										<div class="col-sm-5">
											<select name="end_time" id="end_time"
												style="width: 130pt; height: 20pt">
												<option value="">- เวลากลับ -</option>
												<option value="1">00:00</option>
												<option value="2">00:30</option>
												<option value="3">01:00</option>
												<option value="4">01:30</option>
												<option value="5">02:00</option>
												<option value="6">02:30</option>
												<option value="7">03:00</option>
												<option value="8">03:30</option>
												<option value="9">04:00</option>
												<option value="10">04:30</option>
												<option value="11">05:00</option>
												<option value="12">05:30</option>
												<option value="13">06:00</option>
												<option value="14">06:30</option>
												<option value="15">07:00</option>
												<option value="16">07:30</option>
												<option value="17">08:00</option>
												<option value="18">08:30</option>
												<option value="19">09:00</option>
												<option value="20">09:30</option>
												<option value="21">10:00</option>
												<option value="22">10:30</option>
												<option value="23">11:00</option>
												<option value="24">11:30</option>
												<option value="25">12:00</option>
												<option value="26">12:30</option>
												<option value="27">13:00</option>
												<option value="28">13:30</option>
												<option value="29">14:00</option>
												<option value="30">14:30</option>
												<option value="31">15:00</option>
												<option value="32">15:30</option>
												<option value="33">16:00</option>
												<option value="34">16:30</option>
												<option value="35">17:00</option>
												<option value="36">17:30</option>
												<option value="37">18:00</option>
												<option value="38">18:30</option>
												<option value="39">19:00</option>
												<option value="40">19:30</option>
												<option value="41">20:00</option>
												<option value="42">20:30</option>
												<option value="43">21:00</option>
												<option value="44">21:30</option>
												<option value="45">22:00</option>
												<option value="46">22:30</option>
												<option value="47">23:00</option>
												<option value="48">23:30</option>
												<option value="49">24:00</option>
											</select>
										</div>
									</div>



									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>ผู้รับผิดชอบ:</label>
										</div>
										<div class="col-sm-5">
											<input type="text" style="width: 130pt; Height: 20pt">
										</div>
									</div>


									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>ผู้ร่วมเดินทาง:</label>
										</div>
										<div class="col-sm-5">
											<input type="text" style="width: 130pt; Height: 20pt">
										</div>
									</div>


									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>จำนวนผู้เดินทาง:</label>
										</div>
										<div class="col-sm-5">
											<select style="Width: 130pt; Height: 20pt">
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
											</select>
										</div>
									</div>




									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>เบอร์โทรศัพท์ :</label>
										</div>
										<div class="col-sm-5">
											<input type="text" style="width: 130pt; Height: 20pt"
												PlaceHolder="เบอร์โทรศัพท์ มือถือ">
										</div>
									</div>


									<div class="form-group">
										<div class="col-sm-4" style="text-align: left">
											<label>วัตถุประสงค์เดินทาง:</label>
										</div>
										<div class="col-sm-7">
											<textarea class="form-control" rows="5" id="comment"></textarea>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4" style="text-align: left">
											<label>ผลการอนุมัติ:</label>
										</div>

										<div class="col-sm-7">
											<select style="Width: 130pt; Height: 20pt">
												<option value="00">เลือกผลอนุมัติ...</option>
												<option value="1">อนุมัติแล้ว</option>
												<option value="2">รออนุมัติ</option>
												<option value="3">ไม่อนุมัติ</option>
												<option value="3">ยกเลิก</option>
											</select>
										</div>
									</div>
									<br>

									<div class="row">
										<div class="col-sm-6" style="text-align: left">
											<button type="button" class="btn"
												style="font-size: 11pt; width: 50pt; height: 20pt">Save</button>
										</div>

										<div class="col-sm-1">
											<button type="button" class="btn"
												style="font-size: 11pt; width: 50pt; height: 20pt"
												onclick="Show_Div('main')" id="btndiv1" value="main">Back</button>
										</div>
									</div>
									<br>




								</div>
								<!-- div class="col-lg-9" -->
							</div>
							<!-- div edit dataren -->
						</div>
						<!--div id="datarent"  -->
					</div>
					<!-- div pane1หน้าตารางจอง  แถบใหญ่-->


					<!-- Tab2 -->
					<div id="pane2" class="tab-pane">
						<!-- div pane2-->
						<div class="row">
							<h4
								style="font-size: 16pt; font-weight: bold; text-align: center">ข้อมูลรถยนต์</h4>
						</div>
						<br>

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
										<label style="font-weight: bold">รถตู้</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold; text-align: left">ยี่ห้อรถยนต์:</label>
									</div>
									<div class="col-sm-5">
										<label style="font-weight: bold">Toyota</label>
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-3">
										<label style="font-weight: bold; text-align: left">สีรถยนต์
											:</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold">บรอนด์เงิน</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold; text-align: left">ทะเบียนรถ:</label>
									</div>
									<div class="col-sm-5">
										<label style="font-weight: bold">ฮฉ 2398</label>
									</div>
								</div>




								<div class="form-group">
									<div class="col-sm-3">
										<label style="font-weight: bold; text-align: left">จำนวนที่นั่ง
											:</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold">12 ที่นั่ง</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold; text-align: left">สถานะใช้งาน:</label>
									</div>
									<div class="col-sm-5">
										<label style="font-weight: bold">พร้อมบริการ</label>
									</div>
								</div>




								<div class="form-group">
									<div class="col-sm-3">
										<label style="font-weight: bold; text-align: left">พนักงานขับรถ
											:</label>
									</div>
									<div class="col-sm-9">
										<label style="font-weight: bold">วิรัช สุพรรณคง(วิรัช)</label>
									</div>
								</div>



							</div>
						</fieldset>

						<fieldset
							style="margin-top: 30px; border: 3px dashed #000000; background-color: #eeeeee; overflow: auto; margin-left: 1%; float: left;"
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
										<label style="font-weight: bold">รถตู้</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold; text-align: left">ยี่ห้อรถยนต์:</label>
									</div>
									<div class="col-sm-5">
										<label style="font-weight: bold">Toyota</label>
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-3">
										<label style="font-weight: bold; text-align: left">สีรถยนต์
											:</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold">บรอนด์เงิน</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold; text-align: left">ทะเบียนรถ:</label>
									</div>
									<div class="col-sm-5">
										<label style="font-weight: bold">ฮฉ 2398</label>
									</div>
								</div>




								<div class="form-group">
									<div class="col-sm-3">
										<label style="font-weight: bold; text-align: left">จำนวนที่นั่ง
											:</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold">12 ที่นั่ง</label>
									</div>
									<div class="col-sm-2">
										<label style="font-weight: bold; text-align: left">สถานะใช้งาน:</label>
									</div>
									<div class="col-sm-5">
										<label style="font-weight: bold">พร้อมบริการ</label>
									</div>
								</div>




								<div class="form-group">
									<div class="col-sm-3">
										<label style="font-weight: bold; text-align: left">พนักงานขับรถ
											:</label>
									</div>
									<div class="col-sm-9">
										<label style="font-weight: bold">วิรัช สุพรรณคง(วิรัช)</label>
									</div>
								</div>



							</div>
						</fieldset>



					</div>
					<!-- div pane2-->







					<!-- Tab3 -->
					<div id="pane3" class="tab-pane">
						<!-- div pan3-->
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
										<label style="width: 130pt; height: 20pt">ชื่อ</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-4" style="text-align: left">
										<label>แผนก:</label>
									</div>
									<div class="col-sm-7">
										<label style="width: 130pt; height: 20pt">แผนก</label>
									</div>
								</div>


								<div class="col-sm-4" style="text-align: left">
									<label>ประเภทการจองรถยนต์:</label>
								</div>
								<c:choose>
									<c:when test="${not empty typerent}">

										<div class="col-sm-7">
											<select style="width: 130pt; height: 20pt">
												<option>กรุณาเลือกข้อมูล</option>
												<c:forEach var="listValue" items="${typerent}">
													<option value="<c:out value='${listValue.typerentTH}' />">
														<c:out value="${listValue.typerentTH}" />
													</option>
												</c:forEach>

											</select>
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
											<select style="width: 130pt; height: 20pt">
												<option>กรุณาเลือกข้อมูล</option>
												<c:forEach var="listValue" items="${typecar}">
													<option value="<c:out value='${listValue.typeCarTH}' />">
														<c:out value="${listValue.typeCarTH}" />
													</option>
												</c:forEach>

											</select>
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
											<select style="width: 130pt; height: 20pt">
												<option>กรุณาเลือกข้อมูล</option>
												<c:forEach var="listValue" items="${place}">
													<option value="<c:out value='${listValue.placeTH}' />">
														<c:out value="${listValue.placeTH}" />
													</option>
												</c:forEach>

											</select>
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
									<input type="text" id="example3"
										style="background-color: #FFFFFF; width: 130pt; Height: 20pt"
										name="txtdatestart"> 
								</div>
							</div>




							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>วันที่สิ้นสุด:</label>
								</div>
								<div class="col-sm-5">
									<input type="text" id="example4"
										style="background-color: #FFFFFF; width: 130pt; Height: 20pt"
										name="txtdateend">
								</div>
							</div>



							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>เวลาเริ่ม:</label>
								</div>
								<div class="col-sm-5">
									<select name="start_time" id="start_time"
										style="width: 130pt; height: 20pt">
										<option value="">- เวลาไป -</option>
										<option value="1">00:00</option>
										<option value="2">00:30</option>
										<option value="3">01:00</option>
										<option value="4">01:30</option>
										<option value="5">02:00</option>
										<option value="6">02:30</option>
										<option value="7">03:00</option>
										<option value="8">03:30</option>
										<option value="9">04:00</option>
										<option value="10">04:30</option>
										<option value="11">05:00</option>
										<option value="12">05:30</option>
										<option value="13">06:00</option>
										<option value="14">06:30</option>
										<option value="15">07:00</option>
										<option value="16">07:30</option>
										<option value="17">08:00</option>
										<option value="18">08:30</option>
										<option value="19">09:00</option>
										<option value="20">09:30</option>
										<option value="21">10:00</option>
										<option value="22">10:30</option>
										<option value="23">11:00</option>
										<option value="24">11:30</option>
										<option value="25">12:00</option>
										<option value="26">12:30</option>
										<option value="27">13:00</option>
										<option value="28">13:30</option>
										<option value="29">14:00</option>
										<option value="30">14:30</option>
										<option value="31">15:00</option>
										<option value="32">15:30</option>
										<option value="33">16:00</option>
										<option value="34">16:30</option>
										<option value="35">17:00</option>
										<option value="36">17:30</option>
										<option value="37">18:00</option>
										<option value="38">18:30</option>
										<option value="39">19:00</option>
										<option value="40">19:30</option>
										<option value="41">20:00</option>
										<option value="42">20:30</option>
										<option value="43">21:00</option>
										<option value="44">21:30</option>
										<option value="45">22:00</option>
										<option value="46">22:30</option>
										<option value="47">23:00</option>
										<option value="48">23:30</option>
										<option value="49">24:00</option>
									</select>

								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>เวลาสิ้นสุด:</label>
								</div>
								<div class="col-sm-5">
									<select name="end_time" id="end_time"
										style="width: 130pt; height: 20pt">
										<option value="">- เวลากลับ -</option>
										<option value="1">00:00</option>
										<option value="2">00:30</option>
										<option value="3">01:00</option>
										<option value="4">01:30</option>
										<option value="5">02:00</option>
										<option value="6">02:30</option>
										<option value="7">03:00</option>
										<option value="8">03:30</option>
										<option value="9">04:00</option>
										<option value="10">04:30</option>
										<option value="11">05:00</option>
										<option value="12">05:30</option>
										<option value="13">06:00</option>
										<option value="14">06:30</option>
										<option value="15">07:00</option>
										<option value="16">07:30</option>
										<option value="17">08:00</option>
										<option value="18">08:30</option>
										<option value="19">09:00</option>
										<option value="20">09:30</option>
										<option value="21">10:00</option>
										<option value="22">10:30</option>
										<option value="23">11:00</option>
										<option value="24">11:30</option>
										<option value="25">12:00</option>
										<option value="26">12:30</option>
										<option value="27">13:00</option>
										<option value="28">13:30</option>
										<option value="29">14:00</option>
										<option value="30">14:30</option>
										<option value="31">15:00</option>
										<option value="32">15:30</option>
										<option value="33">16:00</option>
										<option value="34">16:30</option>
										<option value="35">17:00</option>
										<option value="36">17:30</option>
										<option value="37">18:00</option>
										<option value="38">18:30</option>
										<option value="39">19:00</option>
										<option value="40">19:30</option>
										<option value="41">20:00</option>
										<option value="42">20:30</option>
										<option value="43">21:00</option>
										<option value="44">21:30</option>
										<option value="45">22:00</option>
										<option value="46">22:30</option>
										<option value="47">23:00</option>
										<option value="48">23:30</option>
										<option value="49">24:00</option>
									</select>
								</div>
							</div>



							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>ผู้รับผิดชอบ:</label>
								</div>
								<div class="col-sm-5">
									<input type="text" style="width: 130pt; Height: 20pt">
								</div>
							</div>


							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>ผู้ร่วมเดินทาง:</label>
								</div>
								<div class="col-sm-5">
									<input type="text" style="width: 130pt; Height: 20pt">
								</div>
							</div>


							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>จำนวนผู้เดินทาง:</label>
								</div>
								<div class="col-sm-5">
									<select style="Width: 130pt; Height: 20pt">
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
									</select>
								</div>
							</div>




							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>เบอร์โทรศัพท์ :</label>
								</div>
								<div class="col-sm-5">
									<input type="text" style="width: 130pt; Height: 20pt"
										PlaceHolder="เบอร์โทรศัพท์ มือถือ">
								</div>
							</div>


							<div class="form-group">
								<div class="col-sm-4" style="text-align: left">
									<label>วัตถุประสงค์เดินทาง:</label>
								</div>
								<div class="col-sm-7">
									<textarea class="form-control" rows="5" id="comment"></textarea>
								</div>
							</div>



							<div class="form-group">
								<div class="col-sm-8" style="padding-left: 220pt">
									<button type="button" class="glyphicon glyphicon-floppy-disk"
										style="font-size: 13pt; width: 50pt; height: 20pt">Send</button>


								</div>
							</div>
						</div>
						<!-- div class="col-lg-9" -->

					</div>
					<!-- div pane3-->









					<!-- Tab4 -->
					<div id="pane4" class="tab-pane">
						<!-- div pane4-->

						<div class="row" id="reportdata">
							<div>
								<fieldset
									style="width: 750pt; height: 50pt; margin-top: 3px; border: 0px dashed #009900; background-color: #eeeeee; overflow: auto; margin-left: 1%; float: left; text-align: center;">
									<br>
									<h4 style="font-size: 24pt; text-align: center;">---ไม่มีข้อมูลแสดง---</h4>
								</fieldset>
							</div>
							<button type="button" class="btn"
								style="font-size: 11pt; width: 50pt; height: 20pt"
								onclick="Show_Div2('reporttable')">ดู</button>
						</div>

						<div id="reporttable" style="display: none">
							<!-- ตารางรีพอร์ท -->
							<table
								class="table table-striped table-bordered table-hover table-responsive;">
								<thead>
									<tr>
										<th style="text-align: center;">ลำดับที่</th>
										<th style="text-align: center;">รายละเอียดการจอง</th>
										<th style="text-align: center;">ผลการอนุมัติ</th>
										<th style="text-align: center;">วันเวลาเดินทาง</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>John</td>
										<td>Carter</td>
										<td>Carter</td>

									</tr>

								</tbody>
							</table>
							<button type="button" class="btn"
								style="font-size: 11pt; width: 50pt; height: 20pt"
								onclick="Show_Div2('reportdata')">Back</button>
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
									<tbody>
										<tr>
											<td>1</td>
											<td>John</td>
											<td>Carter</td>
											<td>Carter</td>

										</tr>

									</tbody>
								</table>
							</div>

							<div class="row">
								<div class="col-sm-3" style="text-align: left">
									<label>หัวข้อ :</label>
								</div>
								<div class="col-sm-7" style="display: none">
									<input type="text" style="width: 150pt; Height: 20pt">
								</div>
							</div>

							<br>


							<div class="row">
								<div class="col-sm-3" style="text-align: left">
									<label> ข้อความ :</label>
								</div>
								<div class="col-sm-9">
									<textarea class="form-control" rows="5" id="comment"
										style="width: 150pt"></textarea>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3" style="text-align: left">
									<label> ติดต่อ :</label>
								</div>
								<div class="col-sm-9">
									<input type="text"
										style="width: 150pt; Height: 20pt; display: none"
										PlaceHolder="กรุณาระบุเบอร์โทรศัพท์ หรือ เบอร์แผนก">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-4" style="text-align: left; display: none">
									<button type="button" class="btn"
										style="font-size: 11pt; width: 50pt; height: 20pt">Send</button>
								</div>
							</div>

						</div>




						<!-- ส่วนแจ้งปัญหา Admin-->
						<div id="admin">
							<div id="adminproblem" style="display: none">
								<div class="row">
									<div class="col-sm-3" style="text-align: left">
										<label>ชื่อผู้แจ้ง :</label>
									</div>
									<div class="col-sm-7">
										<label>ชื่อผู้แจ้งปัญหา</label>
									</div>
								</div>
								<br>

								<div class="row">
									<div class="col-sm-3">
										<label>ชื่อหัวข้อ</label>
									</div>
									<div class="col-sm-7">
										<label>ชื่อหัวข้อ</label>
									</div>

								</div>

								<div class="row">
									<div class="col-sm-3">
										<label>เนื้อหาข้อความ</label>
									</div>
									<div class="col-sm-9">
										<label>เนื้อหาข้อความ</label>
									</div>
								</div>


								<br>
								<div class="row">
									<div class="col-sm-3">
										<label>เบอร์โทรศัพท์ติดต่อ</label>
									</div>
									<div class="col-sm-9">
										<label>เบอร์โทรศัพท์ติดต่อ</label>
									</div>
								</div>

								<br>

								<div class="row">
									<div class="col-sm-4" style="text-align: left">
										<button type="button" class="btn"
											style="font-size: 11pt; width: 50pt; height: 20pt">Accept</button>
									</div>
								</div>


								<button type="button" class="btn"
									style="font-size: 11pt; width: 50pt; height: 20pt"
									onclick="Show_Div1('tablepro')">Back</button>
							</div>

							<!-- ส่วนแจ้งปัญหา Admin -->
							<div id="tablepro">
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
											<td>1</td>
											<td>John</td>
											<td>Carter</td>
											<td style="text-align: center;"><button type="button"
													class="btn"
													style="font-size: 11pt; width: 50pt; height: 20pt"
													onclick="Show_Div1('adminproblem')">ดู</button></td>

										</tr>
									</tbody>
								</table>

							</div>

							<br>
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
