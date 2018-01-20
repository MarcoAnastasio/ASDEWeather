
<div class="container" ng-controller="SearchController"
	ng-show="searchStatus==1">

	<div class="row justify-content-center">

		<div class="col card" style="background-color: rgba(8, 38, 68, 0.5);">
			<div class="card-body">
				<div class="row">
					<div class="col card"
						style="border: 0px; padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">

						<div class="row">
							<img alt="" src='http://openweathermap.org/img/w/10n.png' />
							<h6 style="text-align: center; color: white; font-size: 20px;">
								{{currentWeather.weather.descritpion}}</h6>
						</div>

						<div class="container" style="padding-bottom:10px">
							<div class="row">
								<div class="col-sm">
									<h1 style="text-align: left; color: white; font-size: 70px;">{{currentWeather.mainTemp.temp}}
										&deg C</h1>
								</div>
								<div class="col-sm">



									<div class="container">
										<div class="row">
											<div class="col-sm">
												<h3
													style="text-align: center; color: white; font-size: 40px;">
													{{currentWeather.city.name}}</h3>

												<h6
													style="text-align: center; color: white; font-size: 20px;  font-style: italic;">
													{{currentWeather.city.country.name}}</h6>
											</div>

										</div>
									</div>
								</div>
								<div class="col-sm">
									<div style="padding-left: 5px;">
										<button type="button" class="btn btn-primary"
											ng-if="$storage.status"
											ng-click="addUserCity(currentWeather.forecast.city.id,currentWeather.forecast.city.name)">Add
											to my cities</button>
											
											
									</div>
									<div style="padding-left: 2px;">
										<button type="button" class="btn btn-primary"
											ng-click="clearSearch()">Clear Seach Result</button>

									</div>
								</div>
							</div>
						</div>


						<div class="container">
							<div class="row">
								<div class="col-sm">
									<table class="table table-sm "
										style="background-color: rgba(0, 0, 0, 0); color: white;">
										<tbody>
											<tr style="border: 0px;">
												<td>
													<h6 style="text-align: left;">Temprature</h6>
												</td>
												<td>{{currentWeather.mainTemp.temp}}</td>

											</tr>
											<tr>

												<td>
													<h6 style="text-align: left;">Minimum Tempreture</h6>
												</td>
												<td>{{currentWeather.mainTemp.tempMin}}</td>

											</tr>
											<tr>

												<td>
													<h6 style="text-align: left;">Maximum Temprature</h6>
												</td>
												<td>{{currentWeather.mainTemp.tempMax}}</td>

											</tr>
											<tr>

												<td>
													<h6 style="text-align: left;">Pressure</h6>
												</td>
												<td>{{currentWeather.mainTemp.pressure}}</td>

											</tr>
											
											
										</tbody>
									</table>
								</div>
								<div class="col-sm">
								
												<div id="map" style="width:100%; height:100%;background:rgba(0,0,0,0)"></div>
								</div>
							</div>
						</div>

					</div>

				</div>

				<div class="container">
					<div class="row">
						<div class="col-sm">
							<canvas id="lineChart"></canvas>
						</div>
						<div class="col-sm">
							<canvas id="humidty_doughnutChart" width="2px"
										style="color: white"></canvas>
						</div>

					</div>
				</div>

				<div class="col card"
					style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">
					<div class="row">
						<div class="col-sm" ng-repeat="times in currentDayForecast"
							style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0.5); color: white">

							<ul class="list-group">
								<li class="list-group-item"
									style="padding: 0px 0px; background-color: #fed136">
									<h2 style="color: white">
										{{currentDayForecast[$index].dateData.times}} hr</h2>
								</li>
								<li class="list-group-item"
									style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
									alt="" src='http://openweathermap.org/img/w/10n.png'></li>
								<li class="list-group-item "
									style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">
									<i class="wi wi-thermometer" style="color: #fed136"></i>
									{{currentDayForecast[$index].mainTemp.temp}} <i
									class="wi wi-celsius"></i>

								</li>
								<li class="list-group-item "
									style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">
									<i class="wi wi-humidity" style="color: #fed136"></i>
									{{currentDayForecast[$index].mainTemp.humidity}} %
								</li>
								<li class="list-group-item "
									style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">
									<i class="wi wi-barometer" style="color: #fed136"> </i>
									{{currentDayForecast[$index].mainTemp.pressure}} hPa
								</li>


							</ul>

						</div>


					</div>

				</div>
				
		

			</div>

		</div>


	</div>

</div>
