/**
 * 
 */
App
		.controller(
				"WeatherController",
				function($rootScope, $scope) {

					$scope.query = {
						city : ""
					};

					$scope.weatherData = [];
					$scope.weatherForcastData = [];
					$scope.currentLoation = {};

					$scope.search = function search() {
					}

					
					
/**
 *******************
 */
					$rootScope.loadSelectedCity = function() {
						console.log("load selected city");
						dataToSend = {
							'latitude' : "",
							'longtidue' : ""
						};
						$
								.ajax({
									type : 'POST',
									url : "/ASDEWeather/api/weather/indexRequest",
									dataType : "json",
									contentType : "application/json",
									data : JSON.stringify(dataToSend),
									success : function(response, status) {
										// console.log(res.status);
										if (response.status == "OK") {

											console.log("Weather Response");
											console.log(response.response);

											$scope
													.setWeatherData(response.response.randomCitiesWeather);
											// console.log($scope.weatherData)
											// $scope.setData(response.response);
											// $scope.displayWeatherGraph();
										} else {
											console
													.log("Weather Responce Error");
											console.log(response);
										}
									},
									error : function(e) {
										console.log(e);
									}
								});
					}
					
/**
 * 
 */
					$scope.loadOneCity = function() {
						console.log("In one City load");
						var currentLocation = [];
						// call the current location data
						getCurrentLocation();

						console.log($scope.currentLoation)
						dataToSend = {
							cityName : $scope.currentLoation.city
						};
						$
								.ajax({
									type : 'POST',
									url : "ASDEWeather/api/weather/forecastWeatherByCity",
									contentType : "application/json",
									dataType : "json",
									data : JSON.stringify(dataToSend),
									success : function(response, status) {
										// console.log(res.status);
										if (response.status == "OK") {

											console
													.log("Weather One City  Response");
											console.log(response);

										} else {
											console
													.log("Weather Responce Error");
											console.log(response);
										}
									}
								});

					}// end of load One City
					$scope.setData = function(input) {
						for (var i = 0; i < input.length; i++) {
							$scope.weatherData
									.push({
										id : input[i]["city"]["id"],
										name : input[i]["city"]["name"],
										icon : 'http://openweathermap.org/img/w/'
												+ input[i]["list"][0]["weather"][0]["icon"]
												+ '.png',
										description : input[i]["list"][0]["weather"][0]["description"],
										temp : input[i]["list"][0]["main"]["temp"],
										minTemp : input[i]["list"][0]["main"]["temp_min"],
										humidity : input[i]["list"][0]["main"]["humidity"]
									});
							console
									.log(input[i]["list"][0]["main"]["temp_min"]);
							// console.log(input[i][3][0]["main"]["temp"]);
							// for(var j=0; j< input[i]["list"]["main"].length;
							// j++ )
							// {
							// console.log(input[i]["list"][j]["main"])
							// }

						}
						console.log($scope.weatherData)
						$scope.$apply();

					}// end of setData function

					// setWeatherData
					$scope.setWeatherData = function(input) {
						console.log("setWeatherData")

						if (input != null) {
							console.log(input);
							for (var i = 0; i < input.length; i++) {
								$scope.weatherData
										.push({
											id : input[i]["city"]["id"],
											name : input[i]["city"]["name"],
											dataAndTime : input[i]["city"]["name"],
											temp : input[i]["mainTemperature"]["temp"],
											minTemp : input[i]["mainTemperature"]["tempMin"],
											maxTemp : input[i]["mainTemperature"]["tempMax"],
											humidity : input[i]["mainTemperature"]["humidity"],
											pressure : input[i]["mainTemperature"]["pressure"],
											description : input[i]["weather"]["descritpion"],
											icon : 'http://openweathermap.org/img/w/'
													+ input[i]["weather"]["icon"]
													+ '.png',
										});
								$scope.$apply();
							}
						}
						console.log($scope.weatherData)

					}// end of setWeatherData
					$scope.setWeatherForcastData = function(input) {
						console.log("in forcast");
						console.log(input);
						/*
						 * for(vari=0; i<input.length; i++){
						 * $scope.weatherForcastData.push ({
						 * id:input[i]["city"]["id"],
						 * name:input[i]["city"]["name"],
						 * icon:'http://openweathermap.org/img/w/'+input[i]["list"][0]["weather"][0]["icon"]+'.png',
						 * for(var j = 0; j< input[i]["list"].length; j++){
						 * description:input[i]["list"][j]["weather"][0]["description"],
						 * temp:input[i]["list"][j]["main"]["temp"],
						 * minTemp:input[i]["list"][j]["main"]["temp_min"],
						 * humidity:input[i]["list"][j]["main"]["humidity"], } })
						 *  }
						 */
					}

					$scope.displayWeatherDetail = function(cityName) {
						console.log("----" + $scope.weatherData[0])
						$scope.cityName = cityName;

						// /alert("Dispay Weather detail")
						$("#portfolioModal1").modal()

					}

					// *****************************/
					// Get Curent locatio --------*/
					// */
					// ****************************/

					function getCurrentLocation() {
						$.getJSON("http://ip-api.com/json/", function(data) {
							$scope.currentLoation = data;
						});
						/*
						 * $.ajax({ type:"GET", url:"http://ip-api.com/json",
						 * dataType:"json",
						 * 
						 * success:function(response,status){
						 * console.log(response); return response; } })
						 */
					}

					// end of getCcurrent location

					//
					$scope.weatherDetail = function(city) {

					}

/**
*+++++++++++++++++++++++++++++ Adding city to preference
*/
					$scope.AddToPreference = function(cityName) {

						var user_id = 1;
						var user_username = "Ciccio";
						var user_firstName = "testName";
						var user_lastName = "testLastName";
						var user_email = "email@test.com";

						console.log("Adding city" + cityName + " To user : "
								+ +user_id + "," + user_username
								+ "preferences");

						data = {

							"id" : user_id,
							"username" : user_username,
							"firstName" : user_firstName,
							"lastName" : user_lastName,
							"email" : user_email,
							"preferedCities" : [ {
								"id" : "2524881",
								"name" : "Crotone"
							} ]
						};

						$.ajax({
							type : 'POST',
							url : "/ASDEWeather/api/auth/user/updateUser",
							contentType : "application/json",
							dataType : "json",
							data : JSON.stringify(data),
							success : function(response, status) {
								console.log(response);
								return response;
							}
						});

					}

/**
 *****************************
 */
					$rootScope.getPreferedCities = function(data) {
						console.log("Call from user controller")
						console.log(data);
						$scope.setWeatherData(data);
						$scope.$apply();
					}
					
/**
 ******************************
 */
					$scope.displayWeatherGraph = function() {
						var chartColors = {
							red : 'rgb(255, 99, 132)',
							orange : 'rgb(255, 159, 64)',
							yellow : 'rgb(255, 205, 86)',
							green : 'rgb(75, 192, 192)',
							blue : 'rgb(54, 162, 235)',
							purple : 'rgb(153, 102, 255)',
							grey : 'rgb(231,233,237)'
						};

						var ctx = $("#myChart");
						var myChart = new Chart(ctx, {
							type : 'line',
							data : {
								labels : [ "Sunday", "Monday", "Tuesday",
										"Wednesday", "Thurday", "Friday",
										"Saturday" ],
								datasets : [ {
									label : 'Temprature',
									backgroundColor : chartColors.red,
									borderColor : chartColors.red,
									data : [ 19, 19, 18, 14, 13, 11, 12 ],
									fill : false

								}, {
									label : 'Humidity',
									backgroundColor : chartColors.blue,
									borderColor : chartColors.blue,
									data : [ 65, 60, 70, 63, 70, 62, 65 ],
									fill : false
								}

								]
							},
							fill : false,
							options : {
								responsive : true,
								fill : false,
								title : {
									display : true,
									text : 'City Name Weather'
								},
								tooltips : {
									mode : 'label',
								},

								scales : {
									xAxes : [ {
										display : true,
										scaleLabel : {
											display : true,
											labelString : 'Days'
										}
									} ],
									yAxes : [ {
										display : true,
										scaleLabel : {
											display : true,
											labelString : 'Value'
										}
									} ]
								}
							}

						});
					}
				});