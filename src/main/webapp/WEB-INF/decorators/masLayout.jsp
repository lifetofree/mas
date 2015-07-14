<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:url value="/resources/bootstrap/css/bootstrap.min.css"
	var="cssbootstrap" />
<c:url value="/resources/angular/angular.js" var="scriptangular" />
<c:url value="/resources/jquery/jquery-2.1.4.min.js" var="scriptjquery" />
<c:url value="/resources/bootstrap/js/bootstrap.min.js"
	var="scriptbootstrap" />
<c:url value="/resources/ui-bootstrap/ui-bootstrap-tpls-0.13.0.min.js"
	var="scriptui" />

<c:url value="/resources/custom/css/custom.css" var="csscustom" />
<c:url value="/resources/custom/js/custom.js" var="scriptcustom" />

<link href="${cssbootstrap}" rel="stylesheet">
<script src="${scriptangular}" type="text/javascript"></script>
<script src="${scriptjquery}" type="text/javascript"></script>
<script src="${scriptbootstrap}" type="text/javascript"></script>
<script src="${scriptui}" type="text/javascript"></script>

<link href="${csscustom}" rel="stylesheet">
<script src="${scriptcustom}" type="text/javascript"></script>

<title>MAS | <decorator:title
		default="Management and Analysis System" />
</title>
<decorator:head />
</head>

<body>
	<nav class="navbar navbar-default sidebar" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#mas-sidebar-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">MAS</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="mas-sidebar-navbar-collapse">
				<ul class="nav navbar-nav">
					<!--  class="active" -->
					<li><a href="#">Home<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
					<li><a href="#">Profile<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
					<li><a href="#">Messages<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Settings <span class="caret"></span><span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-cog"></span></a>
						<ul class="dropdown-menu forAnimate" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
					<li><a href="#">Home<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
					<li><a href="#">Profile<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
					<li><a href="#">Messages<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Settings <span class="caret"></span><span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-cog"></span></a>
						<ul class="dropdown-menu forAnimate" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="main">
		<!-- Content Here -->
		<decorator:getProperty property="div.panelMain" />
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("body").tooltip({
				selector : '[data-toggle=tooltip]'
			});
		});
	</script>
</body>
</html>