App.controller("UserController", ['$scope', function($scope){
	$scope.status = 0;
	
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
		
		dataToSend = {'email':$scope.data.email, 'password':$scope.data.password}
		
	    $.ajax({
	    	type:'GET',
	    	url:"/ASDEWeatherApp/login", 
	    	data:{data:JSON.stringify(dataToSend)},
	    	success:function(response,status){
	    		
	    		if(response.status=="done"){
	    			console.log(response.data);
	    			
	    			$scope.setData(response.data);
	    			
	    			
	    			$('#myModal').modal('hide').on('hide.bs.modal',function(e){
	    				
	    			});
	    		}
	    		else{
	    			console.log(response.data);
	    		}
	    	}	    	
	    });
		
	}
	//-------------------------------------------------------------
	$scope.logout = function logout(){
		
		var data = {
				id:"", name:"", email:"",
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
	    		'name':$scope.reg_data.name,
	    		'lastname':$scope.reg_data.lastname,
	    		'email':$scope.reg_data.email,
	    		'country':$scope.reg_data.country,
	    		'city':$scope.reg_data.city,
	    		'password':$scope.data.password};
		
		$.ajax({
	    	type:'GET',
	    	url:"/ASDEWeatherApp/register", 
	    	data:{data:JSON.stringify(dataToSend)},
	    	success:function(response,status){
	    		
	    		if(response.status=="done"){
	    			console.log(response.data);
	    			
	    			$scope.setData(response.data);
	    			
	    			
	    			$('#registerModal').modal('hide')
	    			//.on('hide.bs.modal',function(e){
	    				
	    			//});
	    		}
	    		else{
	    			console.log(response.data);
	    		}
	    	}	    	
	    });
		
		
	}
//--------------------------------------------------------------------------	
	$scope.setData = function (input, type){
		
		
		var selected = $scope.data;		
		if(type === 'register')
			selected=$scope.reg_data;

		console.log(input.name +'='+selected.name );
		$scope.status=1
		//$scope.data.id = input.id;
		$scope.data.name = input.name;
		scope.data.lastname = input.lastname;
		$scope.data.email = input.email;
		$scope.data.password = input.password;
		$scope.data.city = input.city;
		$scope.data.country = input.country;
		if(type != 'logout'){
			$scope.$apply();
		}else{

			$scope.status = 0;
		}
		console.log(input.name +'='+selected.name );
	}
	
}]);