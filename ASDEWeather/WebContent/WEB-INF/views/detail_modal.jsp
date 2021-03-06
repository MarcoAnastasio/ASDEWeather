<div class="portfolio-modal modal fade" id="portfolioModal1"
	tabindex="-1" role="dialog" aria-hidden="true"
	ng-controller="ForcastController">
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
							<h3 ng-if= uvforecast !== null>{{uvforecast}} UV   </h3>
							<p class="item-intro text-muted">Weather Forecast</p>

							<div class="table-responsive">
								<table class="table table-responsive">
									<td ng-repeat="days in fiveDaysForcastData">
										<div ng-click="displayForcastDetail(days)">
											{{days[0].dateData.dayName}}<br />
											<button type="button" class="btn btn-warning btm-sm">
												{{days[0].mainTemp.tempMax}}&deg C</button>
											<button type="button" class="btn btn-secondary btm-sm">
												{{days[0].mainTemp.tempMin}}&deg C</button>
										</div>
									</td>
								</table>
							</div>

							<div class="table-responsive">
								<table class="table ">
									<thead style="background:#fed136;">
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
										<tr>
											<td>{{hours.dateData.times}}</td>
											<td>{{hours.mainTemp.tempMin}}&deg C</td>
											<td>{{hours.mainTemp.tempMax}}&deg C</td>
											<td>{{hours.mainTemp.humidity}}&#37</td>
											<td>{{hours.cloud}}&#37</td>
											<td><i class="wi wi-{{hours.weather.icon}}"
									style="font-size: 46px; color: #fed136;"></i></td>
											<td>{{hours.wind.speed}} m/s <br />
												{{hours.wind.deg}}
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<button class="btn btn-primary" data-dismiss="modal" type="button">
					<i class="fa fa-times"></i> Close Project
				</button>
			</div>
		</div>
	</div>
</div>
