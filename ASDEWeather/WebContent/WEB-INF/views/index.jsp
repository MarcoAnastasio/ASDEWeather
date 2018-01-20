<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<title>Weather</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">




<!-- weather font  -->
<link href="resources/css/weather-icons.css" rel="stylesheet">
<link href="resources/css/weather-icons.min.css" rel="stylesheet">
<link href="resources/css/weather-icons-wind.css" rel="stylesheet">
<link href="resources/css/weather-icons-wind.min.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="resources/css/main.css" rel="stylesheet">



<!-- Alert css -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.11/ngStorage.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>


<script src="resources/js/app.js"></script>
<script src="resources/js/viewModel/usersSession.js"></script>
<script src="resources/js/controller/NotificationController.js"></script>
<script src="resources/js/controller/UserController.js"></script>
<script src="resources/js/controller/WeatherController.js"></script>
<script src="resources/js/controller/ForcastController.js"></script>
<script src="resources/js/controller/ForcastWeatherDecoder.js"></script>
<script src="resources/js/controller/SearchController.js"></script>

<script src="resources/js/utility/chartPlugin.js"></script>

<script src="resources/js/viewModel/responseHandler.js"></script>
</head>
<body id="page-top" ng-app="myApp" ng-controller="UserController"
	ng-cloak>

	<!-- Navigation -->
	<%@include file="navbar.jsp"%>

	<!-- Header -->
	<%@include file="header.jsp"%>

	<!-- My cities -->
	<%@include file="mycities.jsp"%>

	<!--  Other cities -->
	<%@include file="othercities.jsp"%>

	<!-- 	<div ng-view></div>   ?????????'
 -->
	<!-- Guide -->
	<%@include file="guide.jsp"%>

	<!-- Footer -->
	<%@include file="footer.jsp"%>

	<!-- Modal 1 -->
	<%@include file="detail_modal.jsp"%>

	<!--  Modal registration  -->
	<%@include file="registration_modal.jsp"%>

	<!--  Modal login  -->
	<%@include file="settings.jsp"%>


	<!--  JQeury UI -->
	<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
		integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
		crossorigin="anonymous"></script>

	<!-- Charts JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
	<!-- Bootstrap core JavaScript -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>

	<!-- Google API -->
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBr_onlsVMtLd-hHtEm_Os2-DZCtmgKc4Y&libraries=places,maps"></script>
	<script src="resources/js/imageAPI.js" type="application/javascript"></script>


	<!-- Custom scripts for this template -->
	<script src="resources/js/agency.min.js" type="application/javascript"></script>
	<script src="resources/js/sjcl.js" type="application/javascript"></script>

	<!-- Alert jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>


	<!--Notification decoder  -->
	<script
		src="resources/js/utility/NotificationDecoder.js" type="application/javascript"></script>

</body>
</html>