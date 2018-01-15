<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true" ng-controller="ForcastController">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-12 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase" ng-model="cityName">{{city}}</h2>
								<p class="item-intro text-muted">Weather Forecast</p>
								<table class="table">
									<thead>
										<tr>
											<th>Time</th>
											<th>Max Temp</th>
											<th>Min Temp</th>
											<th>Humidity</th>
											<th>Cloud</th>
											<th>Description</th>
											<th>Wind</th>
										</tr>
									</thead>
								<tbody ng-repeat="hours in oneDayForcast">
									<tr >
										<td>
										{{hours.dateData.times}}
										</td>
										<td>
										{{hours.mainTemp.tempMin}}&deg C
										</td>
										<td>
										{{hours.mainTemp.tempMax}}&deg C
										</td>
										<td>
										{{hours.mainTemp.humidity}}&deg C
										</td>
										<td>
										{{hours.clouds}}
										</td>
										<td>
										{{hours.weather.descritpion}}
										</td>
										<td>
										Degree:{{hours.wind.deg}} <br />
										Speed:{{hours.wind.speed}}
										</td>
									</tr>
								  
								
								</tbody>
								</table>
								<table class="table">
								
								<!-- <tr ng-repeat="days in fiveDaysForcastData"> -->	
									
										
										<td ng-repeat = "days in fiveDaysForcastData">
																						
												 {{days[0].dateData.dayName}}<br />										
													<button type="button" ng-click="displayForcastDetail(days)" class="btn btn-warning btm-sm">
												{{days[0].mainTemp.tempMax}}&deg C</button>
												<button type="button" class="btn btn-secondary btm-sm">
												{{days[0].mainTemp.tempMin}}&deg C</button>
										</td>
											
									
										
									</div>	
								<!-- </tr> -->						
									<!-- <tr ng-repeat="hours in days">
									
										
										<td>
										{{hours.dateData.dayName}}<br />
										{{hours.dateData.times}} <br />
										<img src="http://openweathermap.org/img/w/10n.png">
										</td>
											<td>
																				
											<button type="button" class="btn btn-warning btm-sm">{{hours.mainTemp.tempMax}}&deg C</button>
											<button type="button" class="btn btn-secondary btm-sm">{{hours.mainTemp.tempMin}}&deg C</button>
											{{hours.weather.descritpion}}	<br />
											Humidity:{{hours.mainTemp.humidity}}<br />
											Pressure:{{hours.mainTemp.pressure}}<br />
											
											<div ng-repeat=(key,value)>
												{{value.}}
											</td> -->
											</table>
								</div>	
							</div>
						</div>
							<div id="openweathermap-widget-11"></div>
									{{city}}
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Threads</li>
									<li>Category: Illustration</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
	