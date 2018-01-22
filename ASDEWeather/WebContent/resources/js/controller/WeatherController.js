/**
 * 
 */
App.controller("WeatherController", function($rootScope, $scope, responseHandler){	

	$scope.query = {city:""};
	
	$scope.weatherData = [];
	$scope.weatherForcastData =[];
	$scope.currentLoation = {};
	$scope.cuttentLocationFound = 0;
	
	$scope.search = function search(){}
	
	
	
	$rootScope.loadSelectedCity = function (){
		var dataToSend = {
			    		'latitude':"",
			    		'longtidue':""
			    		 		};
		var url = "/ASDEWeather/api/weather/indexRequest";
		var method="POST";
		var caller="index";
		responseHandler.serverCall(url,method, dataToSend,null, null,caller);
		

		$scope.getUserLocation();
	}// end of loadSelctedcity

	
	$rootScope.response=function(response,caller){
		console.log("finished");
		switch(caller){
		case 'index':
			//index(response);
			 var forecasts = new Forecasts(response.randomCitiesWeather); 
			 $scope.currentWeathers=forecasts.forecastList;
			 $scope.$apply();
			break;
		case 'login':
			break;
		case 'search':
			break;
		case 'location':
			var locationWeather = new Forecasts(response.listForecastWeather);
			$rootScope.locationWeatherData = locationWeather.forecastList;
			console.log($scope.locationWeatherData);
			$rootScope.$apply();
			break;
		}
		
	}
	
	// setWeatherData
	
	
	$scope.displayWeatherDetail = function(cityName){
		console.log("----"+$scope.weatherData[0])
		$scope.cityName = cityName;
		
		
		///alert("Dispay Weather detail")
		$("#portfolioModal1").modal()
		
	}
	
	//*****************************/
	// Get Curent locatio --------*/
	//							  */
	//****************************/
	$scope.getUserLocation = function(){
		console.log("In get location weather")
		var locationData = [];
			if(navigator.geolocation){
				console.log("Location enabled")
				navigator.geolocation.getCurrentPosition(function(position){
					$rootScope.userLocationEnbled = true;
					$scope.getCurrentLocationName(position.coords.latitude, position.coords.longitude);					
				});
			}
			else {
				$rootScope.userLocationEnbled = false; 
				$scope.$apply();
				console.log("Location disabled")
			}
			console.log("geolocation response")
			console.log(locationData)
	}
	
	$scope.getCurrentLocationName = function(lat, long){
	
		var dataToSend =  {"latitude":lat,"longitude":long}
		var url = "/ASDEWeather/api/weather/currentWeatherByCoords";
		var caller = "location";
		var method = "POST"
		responseHandler.serverCall(url,method, dataToSend,null, null,caller);
	
	}
	
	//-------------------------------------------------------------------------------------
	$scope.currentWeatherByCityCall = function(location) {	
		var dataToSend = location;	
		
	
	}
	//------------------------------------------------------------------------------------
	
	
	// end of getCcurrent location
	
	//
	$scope.weatherDetail = function(city){
		
	}
	
	$rootScope.getPreferedCities = function(data){
		console.log("Call from user controller")
		console.log(data);
		$scope.setWeatherData(data);
		//$scope.$apply();
	}
	

});