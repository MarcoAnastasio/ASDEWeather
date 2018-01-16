
<section id="portfolio" ng-if="status == 1">
	<div ng-if="$storage.userData.preferedCities == null">Add Cities</div>
	<div class="container" ng-controller="WeatherController">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">My cities</h2>
				<h3 class="section-subheading text-muted">Your prefered cities.</h3>
			</div>
		</div>
		<div class="row">

			
			<div ng-repeat="w in $storage.userData.preferedCities track by $index"

				class="col-md-4 col-sm-6 portfolio-item">

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
			-->


			<div ng-repeat="w in weatherData track by $index"
				ng-click="displayWeatherDetail(w.name)"
				class="col-md-4 col-sm-6 portfolio-item ">
				<div class="card portfolio-link ">
					<a class="portfolio-link" data-toggle="modal"
						href="#portfolioModal6">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fa fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" id="img-{{w.name}}"
						src="resources/img/portfolio/weather-default.jpg" alt="City image" emit-last-repeater-element>
					</a>
					<div class="card-body">
						<h3 class="card-title">{{w.name}}</h3>
						<p class="card-text ">
							{{w.description}} <span><img src="{{w.icon}}" /></span>
						</p>

						<p class="cardtext text-muted">
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