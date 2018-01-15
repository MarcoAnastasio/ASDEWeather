<section class="bg-light section-cities" id="portfolio">

	<div class="container" ng-controller="WeatherController"
		ng-init="loadSelectedCity()">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">Cities</h2>
				<h3 class="section-subheading text-muted">Some cities chosen by
					us</h3>
			</div>
		</div>
		<div class="row">

			<div ng-repeat="w in weatherData track by $index"
				ng-click="displayWeatherDetail(w.name)"
				class="col-md-4 col-sm-6 portfolio-item ">
				<div class="card portfolio-link ">

					<div class="card-header">
						<a href="#" class="btn btn-primary a-btn-slide-text"> <span
							class="glyphicon glyphicon-plus" aria-hidden="true"></span> <span><strong>Add</strong></span>
						</a>
					</div>


					<a class="portfolio-link" data-toggle="modal"
						href="#portfolioModal6">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fa fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid"
						src="resources/img/portfolio/06-thumbnail.jpg" alt="City image">
					</a>
					<div class="card-body">
						<h3 class="card-title">{{w.name}}</h3>
						<p class="card-text ">
							{{w.description}} <span><img src="{{w.icon}}" /></span>
						</p>

						<p class="card-text text-muted">
							Maxumum Temprature: {{w.temp}} &deg C <br> Minimum
							Temprature: {{w.minTemp}} &deg C <br> Humidity:
							{{w.humidity}} &deg C
						</p>

					</div>

				</div>
			</div>

		</div>
	</div>
</section>