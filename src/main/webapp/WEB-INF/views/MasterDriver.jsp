<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Data</title>
</head>
<body>
<div id="panelMain"><!--div master-->
<div id="PanelBody_UpdatePanel1">
	
            <div class="row">
                <div class="col-lg-12">
                    <h2>Driver Data<small> (ข้อมูลคนขับรถ)</small></h2>
                </div>
            </div>
            
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="col-lg-1">
                                        <a id="PanelBody_btnadd" class="btn btn-success" data-toggle="tooltip" title="" href="javascript:__doPostBack('ctl00$PanelBody$btnadd','')" data-original-title="Insert"><i class="fa fa-plus"></i></a>
                                    </div>
                                    <div class="col-lg-3">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel-body">
                            <div class="form-horizontal" role="form">
                            <div>
		<table class="table table-striped table-bordered table-hover table-responsive col-lg-12" cellspacing="0" rules="all" border="1" id="PanelBody_GvMaster" style="border-collapse:collapse;">
			<tbody><tr class="table_headCenter" style="height:40px;">
				<th scope="col">#</th><th scope="col">EmpID</th><th scope="col">FirstName</th><th scope="col">Surname</th><th scope="col">Tel</th><th scope="col">Email</th><th scope="col">More</th>
			</tr><tr>
				<td>
                                            1
                                        </td><td align="left">
                                            &nbsp;&nbsp;&nbsp;<span id="PanelBody_GvMaster_lblTypeCode1_0" class="col-sm-10"><lable id="lblidemp">รหัสพนักงาน</lable></span>
                                        </td><td align="left">
                                            &nbsp;&nbsp;&nbsp;<span id="PanelBody_GvMaster_lblTypeCode_0" class="col-sm-10"><lable id="lblname">ชื่อ</lable></span>
                                        </td><td align="left">
                                            &nbsp;&nbsp;&nbsp;<span id="PanelBody_GvMaster_lblNameTypecode_0" class="col-sm-10"><lable id="lblsurname">นามสกุล</lable></span>
                                        </td><td align="left">
                                            &nbsp;&nbsp;&nbsp;<span id="PanelBody_GvMaster_lblUStatusDetail_0" class="col-sm-10"><lable id="lbltel">เบอร์โทร</lable></span>
                                        </td>
                                        <td align="left">
                                            &nbsp;&nbsp;&nbsp;<span id="PanelBody_GvMaster_lblUStatusDetail_0" class="col-sm-10"><lable id="lblemail">อีเมล์</lable></span>
                                        </td>
                                        <td>
                                        
                                            <a id="PanelBody_GvMaster_Edit_0" class="btn btn-primary" data-toggle="tooltip" title="" href="javascript:__doPostBack('ctl00$PanelBody$GvMaster$ctl02$Edit','')" data-original-title="Edit"><i class="fa fa-edit"></i></a>
                                            <a onclick="return confirm('คุณต้องการลบรายการนี้ใช่หรือไม่ ?');" id="PanelBody_GvMaster_Delete_0" class="btn btn-danger" data-toggle="tooltip" title="" href="javascript:__doPostBack('ctl00$PanelBody$GvMaster$ctl02$Delete','')" data-original-title="Delete"><i class="fa fa-trash-o"></i></a>
                                        </td>
			</tr>
			<!--  <tr class="PageCustom">
				<td colspan="7"><table>
					<tbody><tr>
						<td><span class="btn btn-info" data-original-title="" title="">1</span></td><td><a href="javascript:__doPostBack('ctl00$PanelBody$GvMaster','Page$2')" class="btn btn-default" data-original-title="" title="">2</a></td><td><a href="javascript:__doPostBack('ctl00$PanelBody$GvMaster','Page$3')" class="btn btn-default" data-original-title="" title="">3</a></td><td><a href="javascript:__doPostBack('ctl00$PanelBody$GvMaster','Page$4')" class="btn btn-default" data-original-title="" title="">4</a></td><td><a href="javascript:__doPostBack('ctl00$PanelBody$GvMaster','Page$5')" class="btn btn-default" data-original-title="" title="">...</a></td><td><a href="javascript:__doPostBack('ctl00$PanelBody$GvMaster','Page$Last')" class="btn btn-default" data-original-title="" title="">Last</a></td>
					
				</tbody></table></td>
			</tr></tr>-->
		</tbody></table>
	</div>
                        </div>
                            </div>
                    </div>
                    </div>
</div>
</body>
</html>