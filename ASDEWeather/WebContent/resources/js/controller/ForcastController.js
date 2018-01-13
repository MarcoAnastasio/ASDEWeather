App	.controller("ForcastController", function($rootScope, $scope) {
					$scope.fiveDaysForcastData = [];
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
											$scope
													.setFiveDaysForcastData(response.response.listForecastWeather);

										} else {
											console
													.log("Weather Responce Error");
											console.log(response);
										}
									}
								});
					}// end of WeatherForcast

					$scope.setFiveDaysForcastData = function(input) {
			
						var counter = 0;
						var CurrentDay = splitDay(input[0]["dateTimeCalulation"]);
						
						var counterOftheday = 0;
						
						for (var i = 0; i < input.length; i++) {
							if (CurrentDay != splitDay(input[i]["dateTimeCalulation"])) {
								counter++;								
								CurrentDay = splitDay(input[i]["dateTimeCalulation"]);							
								switchDay(input[i], counter);
							} else {
								switchDay(input[i], counter);
							}

						}// end of for loop

						console.log($scope.fiveDaysForcastData[0].Day1);
					}

					function splitDay(input) {
						var date;
						date = input.split(" ");
						return date[0];

					}
					function splitHour(input) {
						var date;
						date = input.split(" ");
						return date[1];

					}
					function switchDay(data, counter) {
						switch (counter) {
						case 0:
							$scope.fiveDaysForcastData.push({
								Day1 : data
							});
							break;
						case 1:
							$scope.fiveDaysForcastData.push({
								Day2 : data
							});
							break;
						case 2:
							$scope.fiveDaysForcastData.push({
								Day3 : data
							});
							break;
						case 3:
							$scope.fiveDaysForcastData.push({
								Day4 : data
							});
							break;
						case 4:
							$scope.fiveDaysForcastData.push({
								Day5 : data
							});
							break;
						}
					}

				})