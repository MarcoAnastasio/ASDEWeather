App	.controller("ForcastController", function($rootScope, $scope) {
					$scope.fiveDaysForcastData;
					$scope.oneDyaForcast = [];
					$scope.dateData = [];
					
					$rootScope.WeatherForcast = function(city) {
						$("#portfolioModal1").modal()
						console.log(city);
						$scope.city = city;
						dataToSend = {
							cityName : $scope.city
						};
						$
								.ajax({
									type : 'POST',
									url : "/ASDEWeather/api/weather/forecastWeatherByCity",
									contentType : "application/json",
									dataType : "json",
									data : JSON.stringify(dataToSend),
									success : function(response, status) {
										// console.log(res.status);
										if (response.status == "OK") {

											console
													.log("Weather Forcast Response");
										
											
											var forcasts =new Forecasts(response.response.listForecastWeather);
											//console.log(forcasts.);
											
											
											$scope.fiveDaysForcastData = groupBy(forcasts.forecastList,function(item){
												return [item.dateData.day];
											});
											$scope.oneDayForcast = $scope.fiveDaysForcastData[0];
											$scope.$apply();
											console.log($scope.oneDayForcast);
											//$scope.setFiveDaysForcastData($scope.fiveDaysForcastData )
										} else {
											console
													.log("Weather Responce Error");
											console.log(response);
										}
									}
								});
					}// end of WeatherForcast
					
					$scope.displayForcastDetail = function(input){
						$scope.oneDayForcast = input;
						$('.collapse').collapse()
					}
					
					$scope.setDiplayData = function(input){
						
						
					}
				
				})