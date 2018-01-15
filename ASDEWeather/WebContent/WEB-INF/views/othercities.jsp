<section class="bg-light" id="other-cities">
	<div class="container" ng-controller="WeatherController"
		ng-init="loadSelectedCity()">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">Popular City Weathers</h2>
				<h3 class="section-subheading text-muted">Quello che vogliamo
					scrivere.</h3>
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
						<p class="card-text">Maximum Temprature:{{w.temp}} &deg C<br /> Minimum
							Temparature:{{w.minTemp}}  &deg C<br /> Humidity:{{w.humidity}}<br />.</p>
						<a class="btn btn-primary" ng-click="WeatherForcast(w.name)">Detail</a>
					</div>
				</div>


		</div>
	</div>
	
	<!-- 	<div class="row">

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

		</div> -->
	</div>
	</section>