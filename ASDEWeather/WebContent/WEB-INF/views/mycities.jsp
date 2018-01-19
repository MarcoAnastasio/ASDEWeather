<section id="portfolio" ng-if="status == 1">
	<div class="container col-lg-12 text-center"
		ng-if="$storage.userData.preferedCities == null">
		<h2 class="section-heading text-uppercase">You got no preferred
			cities!</h2>
		<h3 class="section-subheading text-muted">Search a city and add
			to your list. Don't miss any single news!</h3>
	</div>
	<div class="container" ng-if="$storage.userData.preferedCities != null"
		ng-controller="WeatherController">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">My cities</h2>
				<h3 class="section-subheading text-muted">Your prefered cities</h3>
			</div>
		</div>
		<div class="row">

			<div
				ng-repeat="w in $storage.userData.preferedCities track by $index"
				class="col-md-4 col-sm-6 portfolio-item">
				<!--  -->


				<div class="card">
					<a class="portfolio-link" ng-click="WeatherForcast(w.city.name)"
						data-toggle="modal" href="#portfolioModal6">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fa fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid"
						src="resources/img/portfolio/weather-default.jpg" alt="City image"
						id="img-{{w.city.name.replace(' ','')}}-p" emit-last-repeater-element-city>
					</a>
					<div class="card-body">
						<div class="portfolio-link" ng-click="WeatherForcast(w.city.name)">
							<h3 class="card-title">{{w.city.name}}</h3>
							<p class="card-text">
								{{w.description}} <span><img src="{{w.icon}}" /></span>
							</p>

							<p class="card-text text-muted">
								Maximum Temperature: {{w.mainTemperature.temp}} &deg C <br>
								Minimum Temperature: {{w.mainTemperature.tempMin}} &deg C <br>
								Humidity: {{w.mainTemperature.humidity}} &deg C
							</p>
						</div>
						<!-- <button class="btn btn-lg btn-primary btn-circle pull-right">
						<i class="fa fa-star-o"></i>
					</button>
					<button ng-if="$storage.status" ng-click="addUserCity(w.city.id,w.city.name)" class="btn btn-lg btn-success btn-circle pull-right">
						<i class="fa fa-star"></i>
					</button> -->
						<button ng-if="$storage.status"
							ng-click="removeUserCity(w.city.id,w.city.name)"
							class="btn btn-lg btn-danger btn-circle pull-right">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>



			</div>
		</div>
	</div>
</section>