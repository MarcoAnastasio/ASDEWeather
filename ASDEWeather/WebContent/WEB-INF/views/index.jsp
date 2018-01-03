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

<!-- Custom styles for this template -->
<link href="resources/css/agency.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script src="resources/js/app.js"></script>
<script src="resources/js/controller/UserController.js"></script>
<script src="resources/js/controller/WeatherController.js"></script>
</head>
<body id="page-top" ng-app="myApp" ng-controller="UserController">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav"
		style="align:left">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">Weather</a>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class=" navbar-nav text-uppercase navbar-list-left">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#portfolio">My cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#other-cities">Other cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#about">About</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#team">Team</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#contact">Contact</a></li>
				<li class="nav-item"><a
					class="nav-link js-scroll-trigger d-md-none d-lg-none"
					href="#contact">Login</a></li>
				<li class="nav-item"><a
					class="nav-link js-scroll-trigger d-md-none d-lg-none"
					href="#contact">Register</a></li>
			</ul>
		</div>

		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>

		<div style="float: right;" ng-show="status==1">
			<div style="float: right;">
				<button class="btn btn-primary btn-md hidden-sm visible-md"
					id="logout-top" ng-click="logout()">Log Out</button>
			</div>
			<div style="float: right; color: #fff; padding-right: 5px;">Hi
				{{data.name}},</div>
		</div>

		<div ng-show="status==0" id="user-top-bar"
			class="hidden-sm visible-md">
			<button
				class="btn btn-primary btn-md d-none d-sm-none d-md-inline d-lg-inline"
				id="login-top" data-toggle="modal" data-target="#exampleModal">
				Log In</button>
			<button
				class="btn btn-primary btn-md  d-none d-sm-none d-md-inline d-lg-inline"
				id="register-top">Register</button>
		</div>

	</div>
	</nav>

	<!-- Header -->
	<header class="masthead">
	<div class="container">
		<div class="intro-text">
			<div class="intro-lead-in">Welcome To UNICAL Weather!</div>
			<form>
				<div class="form-group">
					<input class="form-control form-control-lg" type="text"
						placeholder="Search for a city">
				</div>
				<div class="form-group">
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Search</a>
				</div>
			</form>
		</div>
	</div>
	</header>

	<!-- My cities -->
	<section id="portfolio">

	<div class="container" ng-controller="WeatherController"
		ng-init="loadSelectedCity()">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">My cities</h2>
				<h3 class="section-subheading text-muted">Your prefered cities.</h3>
			</div>
		</div>
		<div class="row">
			<div ng-repeat="w in weatherData track by $index"
				class="col-md-4 col-sm-6 portfolio-item">
				<!--  -->

				<div class="card">
					<div class="card-header deep-orange lighten-1 white-text" >
						{{w.name}}</div>
					<div class="card-body">
						<img src="{{w.icon}}" />
						<h4 class="card-title">{{w.description}}</h4>
						<p class="card-text">Maxumum Temprature:{{w.temp}} &deg C<br /> Minimum
							Temparature:{{w.minTemp}}  &deg C<br /> Humidity:{{w.humidity}}<br />.</p>
						<aclass="btn btn-primary" ng-click="displayWeatherDetail(w.name)">Detail</a>
					</div>
				</div>




				<!--  -->
				<!-- <a class="portfolio-link" href="" ng-click="displayWeatherDetail(w.name)" >
					<div class="">
						<div class="portfolio-hover-content">
							<i class="fa fa-plus fa-3x" style="color: #22222"></i>
						</div>
						<div>
							Maxumum Temprature:{{w.maxTemp}}<br /> Minimuma
							Temparature:{{w.minTemp}}<br /> Humidity:{{w.humidity}}<br />
						</div>
					</div> <img class="img-fluid" src="https://source.unsplash.com/"
					+{{w.name}}+",weather" alt="">
				</a>
				<div class="portfolio-caption">
					<button class="btn btn-primary" ng-click="displayWeatherDetail(w.name)">Detai</button>
					<h4>{{w.name}}</h4>
					<p class="text-muted">{{w.id}}</p> -->
				</div>
			</div>


		</div>
	</div>
	</section>

	<!-- Other cities -->
	<section class="bg-light" id="other-cities">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">Other cities</h2>
				<h3 class="section-subheading text-muted">Quello che vogliamo
					scrivere.</h3>
			</div>
		</div>

		<div class="row">

			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#portfolioModal1">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fa fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/img/portfolio/01-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>Threads</h4>
					<p class="text-muted"></p>
				</div>
			</div>

		</div>
	</div>
	</section>



	<!-- About -->
	<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">About</h2>
				<h3 class="section-subheading text-muted">Lorem ipsum dolor sit
					amet consectetur.</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<ul class="timeline">
					<li>
						<div class="timeline-image">
							<img class="rounded-circle img-fluid"
								src="resources/img/about/1.jpg" alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>2009-2011</h4>
								<h4 class="subheading">Our Humble Beginnings</h4>
							</div>
							<div class="timeline-body">
								<p class="text-muted">Lorem ipsum dolor sit amet,
									consectetur adipisicing elit. Sunt ut voluptatum eius sapiente,
									totam reiciendis temporibus qui quibusdam, recusandae sit vero
									unde, sed, incidunt et ea quo dolore laudantium consectetur!</p>
							</div>
						</div>
					</li>
					<li class="timeline-inverted">
						<div class="timeline-image">
							<img class="rounded-circle img-fluid"
								src="resources/img/about/2.jpg" alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>March 2011</h4>
								<h4 class="subheading">An Agency is Born</h4>
							</div>
							<div class="timeline-body">
								<p class="text-muted">Lorem ipsum dolor sit amet,
									consectetur adipisicing elit. Sunt ut voluptatum eius sapiente,
									totam reiciendis temporibus qui quibusdam, recusandae sit vero
									unde, sed, incidunt et ea quo dolore laudantium consectetur!</p>
							</div>
						</div>
					</li>
					<li class="timeline-inverted">
						<div class="timeline-image">
							<h4>
								Be Part <br>Of Our <br>Story!
							</h4>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<!-- Team -->
	<section class="bg-light" id="team">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">Our Amazing Team</h2>
				<h3 class="section-subheading text-muted">Lorem ipsum dolor sit
					amet consectetur.</h3>
			</div>
		</div>
		<div class="row">

			<div class="col-sm-4">
				<div class="team-member">
					<img class="mx-auto rounded-circle" src="resources/img/team/3.jpg"
						alt="">
					<h4>Diana Pertersen</h4>
					<p class="text-muted">Lead Developer</p>
					<ul class="list-inline social-buttons">
						<li class="list-inline-item"><a href="#"> <i
								class="fa fa-twitter"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="fa fa-facebook"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="fa fa-linkedin"></i>
						</a></li>
					</ul>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<p class="large text-muted">Lorem ipsum dolor sit amet,
					consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos
					non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
			</div>
		</div>

	</div>
	</section>

	<!-- Contact -->
	<section id="contact">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">Contact Us</h2>
				<h3 class="section-subheading text-muted">Lorem ipsum dolor sit
					amet consectetur.</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form id="contactForm" name="sentMessage" novalidate>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input class="form-control" id="name" type="text"
									placeholder="Your Name *" required
									data-validation-required-message="Please enter your name.">
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<input class="form-control" id="email" type="email"
									placeholder="Your Email *" required
									data-validation-required-message="Please enter your email address.">
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<input class="form-control" id="phone" type="tel"
									placeholder="Your Phone *" required
									data-validation-required-message="Please enter your phone number.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea class="form-control" id="message"
									placeholder="Your Message *" required
									data-validation-required-message="Please enter a message."></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="col-lg-12 text-center">
							<div id="success"></div>
							<button id="sendMessageButton"
								class="btn btn-primary btn-xl text-uppercase" type="submit">Send
								Message</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>

	<!-- Footer -->
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<span class="copyright">Copyright &copy; Your Website 2017</span>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<ul class="list-inline quicklinks">
					<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
					<li class="list-inline-item"><a href="#">Terms of Use</a></li>
				</ul>
			</div>
		</div>
	</div>
	</footer>

	<!-- Portfolio Modals -->

	<!-- Modal 1 -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true" ng-controller="WeatherController">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase" ng-model="cityName">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="resources/img/portfolio/01-full.jpg" alt="">
							<div id="openweathermap-widget-11"></div>
									<pre>
									
									
									
									
									
									
									
									</pre>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Threads</li>
									<li>Category: Illustration</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  Modal login  -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Log In</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!--  <div ng-bind="username==''?'empty':username" style="color:#000; height:30px; width:200px; border:solid 1px #000;"></div> -->
					<label>Username:</label><input ng-model="data.email" type="email"
						class="form-control" id="login-email" name="email"
						placeholder="Email" required> <label>Password:</label><input
						ng-model="data.password" type="password" class="form-control"
						id="password" name="password" placeholder="Password" required>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="login"
						ng-click="login()">Log In</button>
				</div>
			</div>
		</div>
	</div>
	<!--  END Modal login -->
	<!-- Modal -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form ng-submit="register(user)">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Register</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<div class="alert alert-danger" id="error-form">
						<strong>Danger!</strong>Please Complete the form!
					</div>
					<br /> <label>Name:</label><input ng-model="user.name" type="text"
						class="form-control" id="reg-name" name="reg-n-name"
						placeholder="Name" required> <label>Last Name:</label><input
						ng-model="user.lastname" type="text" class="form-control"
						id="reg-lastname" name="reg-n-lastname" placeholder="Last Name"
						required> <label>Email:</label><input
						ng-model="user.email" type="email" class="form-control"
						id="reg-email" name="reg-n-email"
						placeholder="username@domain.com" required> <label>Password:</label><input
						ng-model="user.password" type="password" class="form-control"
						id="reg-password" name="reg-n-password" placeholder="********"
						required> <label>Re-Password:</label><input
						type="password" class="form-control" id="reg-re-password"
						name="reg-n-re-password" placeholder="********" required>
					<label>Country:</label> <select class="form-control"
						ng-model="user.country" id="reg-country" name="reg-n-country"></select>

					<label>City:</label><input ng-model="user.city" type="text"
						class="form-control" id="reg-city" name="reg-n-city"
						placeholder="City" required>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

					<button type="submit" class="btn btn-primary" id="register"
						>Register</button>
				</div>
			</div>
		</div></form>
	</div>
	<!--  END Modal Register -->

	<!--  JQeury UI -->
	this.
	<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
		integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
		crossorigin="anonymous"></script>

	<!-- Charts JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
	<!-- Bootstrap core JavaScript -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>

	<!-- Custom scripts for this template -->
	<script src="resources/js/agency.min.js" type="application/javascript"></script>

</body>
</html>