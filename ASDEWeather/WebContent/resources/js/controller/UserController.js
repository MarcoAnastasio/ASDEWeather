App.controller("UserController", function($rootScope, $scope){	
	$scope.status = 0;
	$scope.regError = false;
	$scope.preferedCities =[];
	$scope.reg_data = {
			id:"", name:"test", lastname:"", email:"",
			password:"", city:"", country:""
		};
	$scope.data = {
			id:"", name:"test_data", email:"",
			password:"", city:"", country:""
		};
	

	 
    
	//------------------------------------------
	$scope.login = function(){
		console.log("test");
		$scope.status = 1;
		
		dataToSend = {'username':$scope.data.email, 'password':$scope.data.password}
		console.log(dataToSend);
		
	 $.ajax({
	    	type:'GET',
	    	url:"/ASDEWeather/api/auth/user/login", 
	    	contentType:"application/json",
	    	dataType:"json",
	    	//data:JSON.stringify(dataToSend),
	    	beforeSend: function (xhr) {
	    	    xhr.setRequestHeader ("Authorization", "Basic " + btoa($scope.data.email + ":" + $scope.data.password));
	    	},
	    	success:function(response,status){
	    		
	    		if(response.status=="OK"){
	    			$('#myModal').modal('hide').on('hide.bs.modal',function(e){	    				
	    			});
	    			console.log(response.response);
	    			//responseHandler(response.response);
	    			$scope.setData(response.response,"login");   			
	    			
	    			
	    		}
	    		else{
	    			console.log(response.status);
	    		}
	    	},
	    	error:function(e){
	    		console.log(e)
	    	}
	    });
		
	}
	//-------------------------------------------------------------
	$scope.logout = function logout(){
		
		var data = {
				id:"", name:"test_data", email:"",
				password:"", city:"", country:""
			};
		$scope.setData(data, 'logout');
	}
	
	//------------------------register
	   $scope.register = function(user) {
	         $scope.master = angular.copy(user); 
	         console.log('User clicked register', user.lastname);
	         
	         $scope.reg_data = user;
	         
	         
	    console.log($scope.reg_data)
		dataToSend = {
	    		'username':$scope.reg_data.username,
	    		'password':$scope.data.password,
	    		'firstName':$scope.reg_data.firstname,
	    		'lastName':$scope.reg_data.lastname,	    		
	    		'email':$scope.reg_data.email
	    		/*'country':$scope.reg_data.country,
	    		'city':$scope.reg_data.city,*/
	    		};
		
		$.ajax({
	    	type:'POST',
	    	url:"/ASDEWeather/api/user/registration", 
	    	contentType:"application/json",
	    	dataType:"json",
	    	data:JSON.stringify(dataToSend),
	    	success:function(response,status){
	    		
	    		if(response.status=="OK"){
	    			$scope.regError = true;
	    			console.log(response.response);	    			
	    			$scope.setData(response.response);    			
	    			
	    			$('#registerModal').modal('hide')
	    			//.on('hide.bs.modal',function(e){
	    				
	    			//});
	    		}
	    		else{
	    			$scope.regError = true;
	    			$("#error-form").html(response.messageForUser);
	    			console.log(response.data);
	    		}
	    	}	    	
	    });
		
		
	}
//--------------------------------------------------------------------------	
	$scope.setData = function (input, type){
		
		
		var selected = $scope.data;		
		if(type == 'register')
			selected=$scope.reg_data;
		else if(type == 'logout'){
			$scope.data = input;
			$scope.status = 0;
			$scope.$digest();
			$scope.loadSelectedCity();
		}
		else if(type =="login"){
		//console.log(input.name +'='+selected.name );
		$scope.status=1
		//$scope.data.id = input.id;
		$scope.data.name = input.user.username;
		$scope.data.lastname = input.user.lastname;
		$scope.data.email = input.user.email;
		$scope.data.password = input.user.password;
		$scope.preferedCities = input.currentWeatherForPreferedCities;
		if(type != 'logout'){
			$scope.$apply();
		}
		console.log($scope.preferedCities);
		$scope.getPreferedCities($scope.preferedCities);
		
		}
		else {
			console.log("Wrong Input")
		}
	}
	
	
});