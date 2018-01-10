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