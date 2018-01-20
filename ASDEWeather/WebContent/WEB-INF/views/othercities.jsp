
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
						src="resources/img/portfolio/weather-default.jpg" alt="City image"
						id="img-{{w.name.replace(' ','')}}" emit-last-repeater-element>
					</a>
					<div class="card-body">
						<div class="portfolio-link" ng-click="WeatherForcast(w.name)">
							<h3 class="card-title">{{w.name}}</h3>
							<p class="card-text">
								{{w.description}} <span><img src="{{w.icon}}" /></span>
							</p>

							<p class="card-text text-muted">
								Maximum Temperature: {{w.temp}} &deg C <br> MinimumThere is a new 
								Temperature: {{w.minTemp}} &deg C <br> Humidity:
								{{w.humidity}} &deg C
							</p>
						</div>
						<!-- 					<button ng-if="$storage.status" ng-click="removeUserCity(w.id,w.name)" class="btn btn-lg btn-primary btn-circle pull-right">
						<i class="fa fa-star-o"></i>
					</button> -->
						<button ng-if="$storage.status"
							ng-click="addUserCity(w.id,w.name)"
							class="btn btn-lg btn-success btn-circle pull-right">
							<i class="fa fa-star"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>