
<div class="container" ng-controller="SearchController"
	ng-show="searchStatus==1">

	<div class="row justify-content-center">
		
			<div class="col card" style="background-color: rgba(8, 38, 68, 0.5);">
				<div class="card-body">
					<div class="col card"
						style="border: 0px; padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">
<!-- 						<div class="row" > -->
						<!-- <div style="padding-left: 5px;">
							<button type="button" class="btn btn-success">Add to my
								cities</button> </div>
							<div style="padding-left: 2px;">
								<button type="button" class="btn btn-danger">Remove</button>
							</div>
						</div> -->

					</div>
					<div class="row">
						<div class="col card"
							style="border: 0px; padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">

							<div class="row">
								<div class="col card"
									style="border: 0px; background-color: rgba(0, 0, 0, 0);">
									<h1 style="text-align: left; color: white; font-size: 70px;">
										{{currentWeather.mainTemp.temp}} &deg C</h1>

								</div>
							</div>
							<div class="row">
								<div class="col card"
									style="border: 0px; background-color: rgba(0, 0, 0, 0);">
									<h3 style="text-align: center; color: white; font-size: 40px;">
										{{currentWeather.city.name}}
										,{{currentWeather.city.country.name}}</h3>
								</div>
							</div>
							<div class="row">


								<div class="col card"
									style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">

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
											<tr>

												<td>
													<h6 style="text-align: left;">Sea Level</h6>
												</td>
												<td>{{currentWeather.mainTemp.seaLevel}}</td>

											</tr>
											<tr>

												<td>
													<h6 style="text-align: left;">Ground Level</h6>
												</td>
												<td>{{currentWeather.mainTemp.groundLevel}}</td>

											</tr>
											<tr>

												<td>
													<h6 style="text-align: left;">Humidity</h6>
												</td>
												<td>{{currentWeather.mainTemp.humidity}}</td>

											</tr>
											<tr>

												<td>
													<h6 style="text-align: left;">TempKf</h6>
												</td>
												<td>{{currentWeather.mainTemp.tempKf}}</td>

											</tr>
										</tbody>
									</table>


								</div>

								<div class="col card"
									style="padding: 0px 0px; border: 0px; background-color: rgba(0, 0, 0, 0);">




									<canvas id="humidty_doughnutChart" width="2px" style="color:white"></canvas>
									<canvas id="pressure__doughnutChart"></canvas>
								</div>
							</div>
						</div>

					</div>
					
						<div class="col card"
							style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">
							<div class="row">
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(155, 252, 192, 0.5); color: white"
									ng-if=currentDayForcast[0].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[0].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[0].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(213, 111, 250, 0.5); color: white"
									ng-if=currentDayForcast[1].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[1].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[1].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(250, 143, 111, 0.5); color: white"
									ng-if=currentDayForcast[2].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[2].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[2].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(249, 236, 92, 0.5); color: white"
									ng-if=currentDayForcast[3].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[3].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[3].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(92, 105, 249, 0.5); color: white"
									ng-if=currentDayForcast[4].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[4].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[4].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(255, 255, 255, 0.5); color: white"
									ng-if=currentDayForcast[5].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[5].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[5].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(60, 225, 251, 0.5); color: white"
									ng-if=currentDayForcast[6].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[6].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[6].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>
								<div class="col-sm"
									style="padding: 0px 0px; background-color: rgba(251, 60, 225, 0.5); color: white"
									ng-if=currentDayForcast[7].date.time>

									<ul class="list-group">
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[7].date.time}}</li>
										<li class="list-group-item"
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);"><img
											alt="" src='http://openweathermap.org/img/w/10n.png'></li>
										<li class="list-group-item "
											style="padding: 0px 0px; background-color: rgba(0, 0, 0, 0);">{{currentDayForcast[8].mainTemp.temp}}
											&deg C</li>


									</ul>

								</div>


							</div>

						</div>


				</div>

			</div>
		

	</div>

</div>


