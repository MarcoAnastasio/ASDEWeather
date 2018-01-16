App.controller("UserController", ["$scope","$rootScope","$localStorage","$sessionStorage", 
	function($rootScope, $scope, $window, $localStorage, $sessionStorage ){	

	$scope.$storage = $localStorage;

	$scope.$storage = $localStorage.$default({
		status: 0,
		userData:{
			id:"", name:"test_data", email:"",
			city:"", country:""
		}
	});

	$scope.status = $localStorage.status;
	//$scope.status = UserService.loggedUser();
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




/***
 ****************************login*******************************
 */
	$scope.login = function(userInfo){
		console.log("test");

		
		  $scope.master = angular.copy(userInfo); 
		  $scope.login_data = userInfo;
		  console.log(userInfo)
		dataToSend = {'username':$scope.login_data.username, 'password':$scope.login_data.password}
		console.log(dataToSend);
		
	 $.ajax({
	    	type:'POST',
	    	url:"/ASDEWeather/api/auth/user/login", 
	    	contentType:"application/json",
	    	dataType:"json",
	    	//data:JSON.stringify(dataToSend),
	    	beforeSend: function (xhr) {
	    	    xhr.setRequestHeader ("Authorization", "Basic " + btoa($scope.login_data.username + ":" + $scope.login_data.password));
	    	},
	    	success:function(response,status){
	    		
	    		if(response.status=="OK"){
	    			$scope.status = 1;
	    			$('#myModal').modal('hide').on('hide.bs.modal',function(e){	    				
	    			});
	    			$localStorage.$reset({
	    			    status: 1
	    			});
	    			console.log(response.response);
	    			//responseHandler(response.response);
	    			$scope.setData(response.response,"login"); 
	    			//UserService.setLoggedUser(response.response);
	    		}
	    		else{
	    			alert("Either the Username or Password Incorrect")
	    			$('#notifyUser').tooltip('show')
	    			console.log(response.status);
	    		}
	    	},
	    	error:function(e){
	    		console.log(e)
	    	}
	    });
		
/*
**********************************************************giuseppe 
		$scope.status = 1;
		$scope.master = angular.copy(userInfo); 
		$scope.login_data = userInfo;
		console.log(userInfo)
		dataToSend = {'username':$scope.login_data.username, 'password':$scope.login_data.password}
		console.log(dataToSend);

		$.ajax({
			type:'POST',
			url:"/ASDEWeather/api/auth/user/login", 
			contentType:"application/json",
			dataType:"json",
			//data:JSON.stringify(dataToSend),
			beforeSend: function (xhr) {
				xhr.setRequestHeader ("Authorization", "Basic " + btoa($scope.login_data.username + ":" + $scope.login_data.password));
			},
			success:function(response,status){

				if(response.status=="OK"){

					$('#myModal').modal('hide').on('hide.bs.modal',function(e){	    				
					});
					$localStorage.$reset({
						status: 1
					});
					console.log("Login avvenuto con successo!"+ response.response);
					//responseHandler(response.response);
					$scope.setData(response.response,"login"); 
					//UserService.setLoggedUser(response.response);
				}
			},
			error:function(xhr,status){
				if(xhr.status == "401"){
					$localStorage.$reset({
						status: 0
					});
					$scope.status = 0;
					console.error("Login not authorized");

				    $.alert({
				        title: 'Login not successed!',
				        content: 'Username or password wrong!',
				        type: 'red',
				        typeAnimated: true,
				        buttons: {
				            tryAgain: {
				                text: 'Try again',
				                btnClass: 'btn-red',
				                action: function(){
				                	//$("#username").focus();??????????
				                }
				            },
				            close: function () {
				            }
				        }
				    });
					
				}
				else{
					$localStorage.$reset({
						status: 0
					});
					$scope.status = 0;
					
					  $.alert({
					        title: 'Error!',
					        content: 'Impossible execute request!',
					        type: 'red',
					        typeAnimated: true,
					        buttons: {
					            tryAgain: {
					                text: 'Try again',
					                btnClass: 'btn-red',
					                action: function(){
					                	//$("#username").focus();??????????
					                }
					            },
					            close: function () {
					            }
					        }
					    });
					
					}
			}
		});

*/
	}
	
	/***
	 ****************************logout*******************************
	 */
	$scope.logout = function logout(){
		$localStorage.$reset({
			status: 0
		});

		var data = {
				id:"", name:"", email:"",
				password:"", city:"", country:""
		};
		$scope.setData(data, 'logout');
	}

	/***
	 ****************************register*******************************
	 */
	$scope.register = function(user) {
		$scope.master = angular.copy(user); 
		console.log('User clicked register', user.lastname);

		$scope.reg_data = user;


		console.log($scope.reg_data)
		dataToSend = {
			'username':$scope.reg_data.username,
			'password':$scope.reg_data.password,
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
					$scope.regError = false;
					console.log(response.response);	    			
					$scope.setData(response.response,"register");    			
				//	$scope.setUser(response.response,"register");
					
					
					$('#registerModal').modal('toggle');					
					//.on('hide.bs.modal',function(e){s
					//});
				}
				else{
					$scope.regError = true;
					$("#error-form").html(response.messageForUser);
					//console.log(response.data);
				}
			},
			error:function(){
				$scope.regError = true;
				$("#error-form").html("Generic error, try again!");				
			}    	
		});


	}
	
	
	
//	--------------------------------------------------------------------------	
	$scope.setData = function (input, type){


		var selected = $scope.data;		
		if(type == 'register')
			selected=$scope.reg_data;
		else if(type == 'logout'){
			$scope.data = input;
			$scope.status = 0;
			$scope.$digest();
			//$scope.loadSelectedCity();
		}
		else if(type =="login"){
			//console.log(input.name +'='+selected.name );

			$scope.$storage = $localStorage.$reset({
				status: 1,
				userData:{
					id:input.user.id, name:input.user.firstname, email:input.user.email,
					city:"", preferedCities:input.currentWeatherForPreferedCities
				}
			});
			$scope.status=1
			//$scope.data.id = input.id;
			$localStorage.userData.id = input.user.id;
			$localStorage.userData.name = input.user.name;
			$localStorage.userData.username = input.user.username;
			$localStorage.userData.lastname = input.user.lastname;
			$localStorage.userData.email = input.user.email;
			$localStorage.userData.preferedCities = input.currentWeatherForPreferedCities;
			/*$scope.data.name = input.user.username;
		$scope.data.lastname = input.user.lastname;
		$scope.data.email = input.user.email;
		$scope.data.password = input.user.password;
		$scope.preferedCities = input.currentWeatherForPreferedCities; */
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


}]);