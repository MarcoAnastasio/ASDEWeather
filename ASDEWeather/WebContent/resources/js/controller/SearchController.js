/**
 * 
 */
App.controller("SearchController", function($rootScope, $scope) {
	
	 // console.log("Search Status");
	 // console.log($rootScope.searchStatus);
	  
	  $scope.clear=function(){
		  $rootScope.searchStatus=0;
		  //console.log("am called");
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
					
					    $rootScope.searchStatus=1;
					    $scope.myMap($rootScope.currentWeather.city.latitude,
								$rootScope.currentWeather.city.longitude);
					    $rootScope.$apply();
			         	//console.log($rootScope.currentWeather);
					
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
				
					$rootScope.forecastByDay = groupBy(forecasts.forecastList,
							function(item) {
								return [item.dateData.day ];
							});
		
					 //console.log($rootScope.forecastByDay);
					 $rootScope.currentDayForecast=$rootScope.forecastByDay[0];
	      
					 $rootScope.$apply();	               
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
			for (var i=0;i<$rootScope.currentDayForecast.length;i++){
				 time_stamp[i]=$rootScope.currentDayForecast[i].dateData.time;
				 temp[i]=$rootScope.currentDayForecast[i].mainTemp.temp;
				 humid[i]=$rootScope.currentDayForecast[i].mainTemp.humidity;
				 pressure[i]=$rootScope.currentDayForecast[i].mainTemp.pressure;
		}
		
		
		var hc = document.getElementById("humidty_doughnutChart").getContext('2d');
		hc.fillStyle='blue';
		var humidtyChart_config =  {
		    type: 'doughnut',
		    data: {
		        labels: ["Humidity"],
		        fontColor: 'white',
		        datasets: [
		            {  
		                data:[$rootScope.currentWeather.mainTemp.humidity,100-$rootScope.currentWeather.mainTemp.humidity],
		                backgroundColor: ["#fed136", "#88918d"],
		                borderWidth: 0
		               
		            }
		        ]
		    },
		    options: {
		          responsive: true,
		    	  cutoutPercentage: 90,
		    	  
		    	   elements: {
						center: {
							text: $rootScope.currentWeather.mainTemp.humidity+' '+'%',
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
		
		
		
		  
		
		var time_stamp=[];
		var tempMin=[];
		var tempMax=[];
			for (var i=0;i<$rootScope.currentDayForecast.length;i++){
				 time_stamp[i]=$rootScope.currentDayForecast[i].dateData.times;
				 tempMax[i]=$rootScope.currentDayForecast[i].mainTemp.tempMax;
				 tempMin[i]=$rootScope.currentDayForecast[i].mainTemp.tempMin;
		}
			console.log(  time_stamp);
		var ctxL = document.getElementById("lineChart").getContext('2d');
		 Chart.defaults.global.defaultFontColor = '#FFFFFF';
		var myLineChart = new Chart(ctxL, {
		    type: 'line',
		 
		    data: {
		        labels: time_stamp,
		        datasets: [
		            {
		                label: "Minimum Temprature",
		       
		             
		                backgroundColor: "rgba(151,187,205,0.6)",
		                fillColor: "rgba(220,220,220,0.2)",
		                strokeColor: "rgba(220,220,220,1)",
		                pointColor: "rgba(220,220,220,1)",
		                pointStrokeColor: "#fff",
		                pointHighlightFill: "#fff",
		                pointHighlightStroke: "rgba(220,220,220,1)",
		                data: tempMin
		            },
		            {
		                label: "Maximum Temprature",
		                backgroundColor: "#fed136",
		                fillColor: "rgba(151,187,205,0.2)",
		                strokeColor: "rgba(151,187,205,1)",
		                pointColor: "rgba(151,187,205,1)",
		                pointStrokeColor: "#fff",
		                pointHighlightFill: "#fff",
		                pointHighlightStroke: "rgba(151,187,205,1)",
		                data: tempMax
		            }
		        ]
		    },
		    options: {
		        responsive: true
		    }    
		});
	};

	
	
	$scope.myMap=function($lat,$lng) {
		  //
		  var mapCanvas = document.getElementById("map");
		  var myLatLng =new google.maps.LatLng($lat,$lng);
		  var mapOptions = {
		    center: myLatLng, 
		    zoom: 10
		  };
		  
		 var map = new google.maps.Map(mapCanvas, mapOptions);
	     var marker = new google.maps.Marker({
	          position: myLatLng,
	          map: map
	       
	        });
		
		}	
	
	
});
