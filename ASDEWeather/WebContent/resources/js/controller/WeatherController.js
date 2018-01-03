/**
 * 
 */
App.controller("WeatherController", function WeatherController($scope){
		
	$scope.query = {city:""};
	
	$scope.weatherData = [];
	$scope.weatherForcastData =[];
	
	$scope.search = function search(){}
	
	$scope.loadSelectedCity = function loadSelectedCity(){
		$.ajax({
	    	type:'POST',
	    	url:"/ASDEWeather/weather", 
	    	dataType:"json",
	    	success:function(response,status){
	    		//console.log(res.status);
	    		var res = JSON.parse(response);
	    		if(res.status=="done"){

	    			console.log("Weather Response");
	    			console.log(res.data);

	    			$scope.setData(res.data);
	    			
	    		}
	    		else{
	    			console.log("Weather Responce Error");
	    			console.log(res);
	    		}
	    	}	    	
	    });
		
	}// end of loadSelctedcity
	
	$scope.setData = function(input){
		for(var i=0; i< input.length; i++ ){
						$scope.weatherData.push({id:input[i]["city"]["id"],
							name:input[i]["city"]["name"],
							icon:'http://openweathermap.org/img/w/'+input[i]["list"][0]["weather"][0]["icon"]+'.png',
							description:input[i]["list"][0]["weather"][0]["description"],
							temp:input[i]["list"][0]["main"]["temp"],
							minTemp:input[i]["list"][0]["main"]["temp_min"],
							humidity:input[i]["list"][0]["main"]["humidity"]}
						);
			console.log(input[i]["list"][0]["main"]["temp_min"]);
			//console.log(input[i][3][0]["main"]["temp"]);
//			for(var j=0; j< input[i]["list"]["main"].length; j++ )
//				{
//				console.log(input[i]["list"][j]["main"])
//				}
		
		}
		console.log($scope.weatherData)
		$scope.$apply();
	
	}// end of setData function
	
	$scope.setWeatherForcastData= function(input){
		
		/*for(vari=0; i<input.length; i++){
			$scope.weatherForcastData.push ({
							id:input[i]["city"]["id"],
							name:input[i]["city"]["name"],
							icon:'http://openweathermap.org/img/w/'+input[i]["list"][0]["weather"][0]["icon"]+'.png',							
							for(var j = 0; j< input[i]["list"].length; j++){
							description:input[i]["list"][j]["weather"][0]["description"],
							temp:input[i]["list"][j]["main"]["temp"],
							minTemp:input[i]["list"][j]["main"]["temp_min"],
							humidity:input[i]["list"][j]["main"]["humidity"],
							}
							})
			
		}*/
	}
	
	$scope.displayWeatherDetail = function(cityName){
		console.log("----"+$scope.weatherData[0])
		$scope.cityName = cityName;
		
		///alert("Dispay Weather detail")
		$("#portfolioModal1").modal()
		
	}
});