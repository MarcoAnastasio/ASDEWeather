/**
 * 
 */
App.controller("SearchController", function($rootScope, $scope) {
	
	$scope.citis = [ {
		"id" : '121212',
		"name" : 'cosenza'
	}, {
		"id" : '131313',
		"name" : 'rende'
	}, {
		"id" : '14141414',
		"name" : 'london'
	} ];
	
	
	 console.log("Search Status");
	  console.log($rootScope.searchStatus);
	  
	  $scope.clear=function(){
		  $rootScope.searchStatus=0;
		  console.log("am called");
	  };
	
	$scope.autoComplateCall = function() {
		$scope.cityListHide=0;
		var dataToSend = {
			"subName" : $scope.query

		};
		if ($scope.query.length > 3) {
			$.ajax({
				type : 'POST',
				url : "/ASDEWeather/api/commons/cityByNameSubstring",
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(dataToSend),
				success : function(response, status) {

					if (response.status == "OK") {
						$rootScope.cities = response.response;
						
					} else {
						console.log("Weather Response Error");
						console.log(response);
					}
				},
				error : function(e) {
					console.log(e);
				}
			});
		}
	}


	$scope.currentWeatherByCityCall = function($cityId, $cityName,$city) {	
		$scope.forecastByCityCall($cityId, $cityName);  ///call the weather
		$scope.cityListHide=1;
		var dataToSend = {
				"cityId" : $cityId,
				"cityName" : $cityName
			};	
		
		$.ajax({
			type : 'POST',
			url : "/ASDEWeather/api/weather/currentWeatherByCity",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(dataToSend),
			success : function(response, status) {

				if (response.status == "OK") {
                     
					$scope.searchStatus=1;
					var current = response.response.listForecastWeather[0];
					$rootScope.currentWeather= new ForecastWeatherDecoder(current);
					
				 				 	
					console.log("current");
					console.log($rootScope.currentWeather)
					
					$rootScope.searchStatus=1;
					$scope.$apply();
				console.log(current);
					
				} else {
					console.log("Search Response for selected city Error");
					console.log(response);
				}
			},
			error : function(e) {
				console.log(e);
			}
		});	
	}
	
	$scope.forecastByCityCall = function($cityId, $cityName) {
		var dataToSend = {
			"cityId" : $cityId,
			"cityName" : $cityName
		};
		$.ajax({
			type : 'POST',
			url : "/ASDEWeather/api/weather/forecastWeatherByCity",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(dataToSend),
			success : function(response, status) {

				if (response.status == "OK") {

					$scope.forecasts = response.response.listForecastWeather;

					var forecasts = new Forecasts(response.response.listForecastWeather); //
				
				
					console.log("forcast");
					
				

					$rootScope.forcastByDay = groupBy(forecasts.forecastList,
							function(item) {
								return [item.dateData.day ];
							});
					console.log("forcast by day");
					console.log($scope.forcastByDay);
	               $scope.currentDayForcast=$scope.forcastByDay[0];
	               $scope.$apply();
	               
	               console.log( $scope.currentDayForcast[0].mainTemp);   
	               $scope.startDraw();
				} else {
					console.log("Search Response for selected city Error");
					console.log(response);
				}
			},
			error : function(e) {
				console.log(e);
			}
		});

	};	
	
	$scope.clearSearch = function(){
		$scope.searchStatus=0;
		$scope.$apply();
	}

	$scope.startDraw =function () {
		console.log("draw");
		var time_stamp=[];
		var temp=[];
		var humid=[];
		var pressure=[];
			for (var i=0;i<$scope.currentDayForcast.length;i++){
				 time_stamp[i]=$scope.currentDayForcast[i].dateData.time;
				 temp[i]=$scope.currentDayForcast[i].mainTemp.temp;
				 humid[i]=$scope.currentDayForcast[i].mainTemp.humidity;
				 pressure[i]=$scope.currentDayForcast[i].mainTemp.pressure;
		}
		
		
		var hc = document.getElementById("humidty_doughnutChart").getContext('2d');
		hc.fillStyle='blue';
		var humidtyChart_config =  {
		    type: 'doughnut',
		    data: {
		        labels: ["Humidity"],
		        fontColor: 'white',
		        datasets: [
		            {   label: 'of Votes',
		                data:[humid[0],100-humid[0]],
		                backgroundColor: ["#f44171", "#88918d"],
		                borderWidth: 0
		               
		            }
		        ]
		    },
		    options: {
		          responsive: true,
		    	  cutoutPercentage: 90,
		    	  
		    	   elements: {
						center: {
							text: humid[0]+' '+'%',
		          color: 'white', // Default is #000000
		          fontStyle: 'Arial', // Default is Arial
		          sidePadding: 20 // Defualt is 20 (as a percentage)
						}
					}
		    
		    
		    
		    }  
		};
	
	
		
		var pc = document.getElementById("pressure__doughnutChart").getContext('2d');
		var pressureChart_config={
			    type: 'doughnut',
			    data: {
			        labels: ["Pressure"],
			        datasets: [
			            {
			                data:[humid[0],100-humid[0]],
			                backgroundColor: ["#35e099", "#88918d"], //rgba(244, 65, 113,0)
		
			                borderWidth: 0
			               
			               
			            }
			        ]
			    },
			    options: {
			        responsive: true,
			        segmentShowStroke: false,
			        cutoutPercentage: 90,
			        elements: {
						center: {
							text: pressure[0]+' '+'hPa',
		          color: 'white', // Default is #000000
		          fontStyle: 'Arial', // Default is Arial
		          sidePadding: 20 // Defualt is 20 (as a percentage)
						}
					}
			    
			    }    
			};

		


	
			 chartPluginInit();

			//var ctx = document.getElementById("humidty_doughnutChart").getContext("2d");
			var humidty_chart = new Chart(hc, humidtyChart_config);
		//	var pressure_chart=new Chart(pc, pressureChart_config);
		
		
		
		  
		
	/*	var time_stamp=[];
		var temp=[];
		var humid=[];
			for (var i=0;i<$scope.currentDayForcast.length;i++){
				 time_stamp[i]=$scope.currentDayForcast[i].date.time;
				 temp[i]=$scope.currentDayForcast[i].mainTemp.temp;
				 humid[i]=$scope.currentDayForcast[i].mainTemp.humidity;
		}
			console.log(  time_stamp);
		var ctxL = document.getElementById("lineChart").getContext('2d');
		var myLineChart = new Chart(ctxL, {
		    type: 'line',
		 
		    data: {
		        labels: time_stamp,
		        datasets: [
		            {
		                label: "Temprature",
		       
		                backgroundColor: "green",
		                
		                fillColor: "rgba(220,220,220,0.2)",
		                strokeColor: "rgba(220,220,220,1)",
		                pointColor: "rgba(220,220,220,1)",
		                pointStrokeColor: "#fff",
		                pointHighlightFill: "#fff",
		                pointHighlightStroke: "rgba(220,220,220,1)",
		                data: temp
		            },
		            {
		                label: "Humidity",
		                backgroundColor: "#FFFFFF",
		                fillColor: "rgba(151,187,205,0.2)",
		                strokeColor: "rgba(151,187,205,1)",
		                pointColor: "rgba(151,187,205,1)",
		                pointStrokeColor: "#fff",
		                pointHighlightFill: "#fff",
		                pointHighlightStroke: "rgba(151,187,205,1)",
		                data: humid
		            }
		        ]
		    },
		    options: {
		        responsive: true
		    }    
		});*/
	};

	
	
});
