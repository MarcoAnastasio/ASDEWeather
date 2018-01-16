<section class="bg-light section-cities" id="portfolio">
	<div class="container" ng-controller="WeatherController"
		ng-init="loadSelectedCity()">
		<div class="row">
			<div class="col-lg-12 text-center">

				<h2 class="section-heading text-uppercase">Cities</h2>
				<h3 class="section-subheading text-muted">Popular City Weathers</h3>
			</div>
		</div>

		<div class="row">
			<!-- 
			<div ng-repeat="w in weatherData track by $index"
				class="col-md-4 col-sm-6 portfolio-item">
				<div class="card">
					<div class="card-header deep-orange lighten-1 white-text">
						{{w.name}}</div>
					<div class="card-body">
						<img src="{{w.icon}}" id="img-{{w.name}"
							emit-last-repeater-element />
						<h4 class="card-title">{{w.description}}</h4>
						<p class="card-text">
							Maximum Temperature:{{w.temp}} &deg C<br /> Minimum
							Temperature:{{w.minTemp}} &deg C<br /> Humidity:{{w.humidity}}<br />.
						</p>
						<a class="btn btn-primary" ng-click="WeatherForcast(w.name)">Detail</a>
					</div>
				</div>
			</div>
			
			
			old  ng-click="displayWeatherDetail(w.name)
			-->







			<div ng-repeat="w in weatherData track by $index"
				class="col-md-4 col-sm-6 portfolio-item ">
				<div class="card">
					<a class="portfolio-link" ng-click="WeatherForcast(w.name)"
						data-toggle="modal" href="#portfolioModal6">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fa fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid"
						src="resources/img/portfolio/06-thumbnail.jpg" alt="City image"
						id="img-{{w.name}}" emit-last-repeater-element> 			<!-- need emit-last...?? -->
					</a>
					<div class="card-body">
						<div class="portfolio-link" ng-click="WeatherForcast(w.name)">
							<h3 class="card-title">{{w.name}}</h3>
							<p class="card-text">
								{{w.description}} <span><img src="{{w.icon}}"
									id="img-{{w.name}" emit-last-repeater-element /></span>  <!-- need emit-last...?? -->
							</p>

							<p class="card-text text-muted">
								Maximum Temperature: {{w.temp}} &deg C <br> Minimum
								Temperature: {{w.minTemp}} &deg C <br> Humidity:
								{{w.humidity}} &deg C
							</p>
						</div>
						<button class="btn btn-lg btn-primary btn-circle pull-right">
							<i class="fa fa-star-o"></i>
						</button>
						<button class="btn btn-lg btn-success btn-circle pull-right">
							<i class="fa fa-star"></i>
						</button>
						<button class="btn btn-lg btn-danger btn-circle pull-right">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
			</div>

		</div>


	</div>
</section>