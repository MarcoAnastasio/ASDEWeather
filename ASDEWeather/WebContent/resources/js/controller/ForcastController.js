App.controller("ForcastController", function($rootScope, $scope){
	$scope.fiveDaysForcastData = [];
	$rootScope.WeatherForcast = function(city){
		$("#portfolioModal1").modal()
		console.log(city);
		$scope.city = city;
		dataToSend ={cityName:$scope.city};
		$.ajax({
	    	type:'POST',
	    	url:"/ASDEWeather/api/weather/forecastWeatherByCity", 
	    	contentType:"application/json",
	    	dataType:"json",
	    	data:JSON.stringify(dataToSend),
	    	success:function(response,status){
	    		//console.log(res.status);
	    		if(response.status=="OK"){

	    			console.log("Weather Forcast Response");
	    			$scope.setFiveDaysForcastData(response);
	    			
	    		}
	    		else{
	    			console.log("Weather Responce Error");
	    			console.log(response);
	    		}
	    	}	    	
	    });
	}// end of WeatherForcast
	
	$scope.setFiveDaysForcastData = function(input){
		
	}
})