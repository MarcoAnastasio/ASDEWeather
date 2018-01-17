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
				<!--  -->

				<div class="card">
					<div class="card-header deep-orange lighten-1 white-text" >
						{{w.city.name}}</div>
					<div class="card-body">
						<img src="{{w.icon}}" />
						<h4 class="card-title">{{w.description}}</h4>
						<p class="card-text">Maximum Temprature:{{w.mainTemperature.temp}} &deg C<br /> Minimum
							Temparature:{{w.mainTemperature.minTemp}}  &deg C<br /> Humidity:{{w.mainTemperature.humidity}}<br />.</p>
						<a class="btn btn-primary" ng-click="WeatherForcast(w.city.name)">Detail</a>
						<a class="btn btn-primary" ng-click="removeCity(w.city.name)">Remove</a>
					</div>
				</div>


		</div>
	</div>
	</section>