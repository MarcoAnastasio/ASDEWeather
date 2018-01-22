
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

			<div ng-repeat="currentWeather in currentWeathers"
				class="col-md-4 col-sm-6 portfolio-item ">
				
				<div class="card">
					<a class="portfolio-link" ng-click="WeatherForcast(currentWeather.city.name)"
						data-toggle="modal" href="#portfolioModal6">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fa fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid"
						src="resources/img/portfolio/weather-default.jpg" alt="City image"
						id="img-{{currentWeather.city.name.replace(' ','')}}" emit-last-repeater-element>
					</a>
					<div class="card-body">
						<div class="portfolio-link" ng-click="WeatherForcast(currentWeather.city.name.name)">
							<h3 class="card-title">{{currentWeather.city.name}}</h3>
							<p class="card-text">
								<i class="wi wi-{{currentWeather.weather.icon}}"
										style="font-size: 46px; color: #fed136; padding-top: 10px;"></i>
							</p>

							<p class="card-text text-muted">
								Maximum Temperature: {{currentWeather.mainTemp.tempMax}} &deg C <br> Minimum
								Temperature: {{currentWeather.mainTemp.tempMin}} &deg C <br> Humidity:
								{{currentWeather.mainTemp.humidity}} &deg C
							</p>
						</div>
											<button ng-if="$storage.status" ng-click="removeUserCity(currentWeather.city.id,currentWeather.city.name)" class="btn btn-lg btn-primary btn-circle pull-right">
						<i class="fa fa-star-o"></i>
					</button>
						<button ng-if="$storage.status"
							ng-click="addUserCity(currentWeather.city.id,currentWeather.city.name)"
							class="btn btn-lg btn-success btn-circle pull-right">
							<i class="fa fa-star"></i>
						</button>
					</div>
				</div>
			</div>
		</div> 
	</div> 
</section>