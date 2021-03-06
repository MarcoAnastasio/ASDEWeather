/*
 * 
 */
App.controller("UserController", ["$scope","$rootScope","$localStorage","$sessionStorage", 
	function($rootScope, $scope, $window, $localStorage, $sessionStorage,responseHandler ){	

	$scope.$storage = $localStorage;
	$scope.secret = "secret";
	$scope.$storage = $localStorage.$default({
		status: 0,
		userData:{
			id:"", name:"test_data", email:"",
			city:"", country:"", pd:""
		}
	});
	//getNotifications();
	$scope.status = $localStorage.status;
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


	/**
	 * ************************login************************
	 */
	$scope.login = function(userInfo,type){
		console.log("test");
		//$scope.status = 1; ???????

		$scope.master = angular.copy(userInfo); 
		$scope.login_data = userInfo;
		// where type use?????????
		if(type!= 'system')
			$scope.master = angular.copy(userInfo); 

	
		dataToSend = {'username':$scope.login_data.username, 'password':$scope.login_data.password}
		
		var notification = []
		$.ajax({
			type:'POST',
			url:"/ASDEWeather/api/auth/user/login", 
			contentType:"application/json",
			dataType:"json",
			beforeSend: function (xhr) {
				xhr.setRequestHeader ("Authorization", "Basic " + btoa($scope.login_data.username + ":" + $scope.login_data.password));
			},    	
			success:function(response,status){

				if(response.status=="OK"){
					$scope.status = 1;
					$scope.passkey = btoa(sjcl.encrypt("secret",$scope.login_data.password));
					$localStorage.$reset({
						status: 1,
						pd:$scope.passkey
					});
					console.log(response.response);
					//responseHandler(response.response);
					$scope.setData(response.response,"login"); 
					//$scope.getNotifications();
					//UserService.setLoggedUser(response.response);
					$("#loginForm")[0].reset();
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
	}

	/**
	 * *************************logout************************
	 */
	$scope.logout = function logout(){
		$localStorage.$reset({
			status: 0
		});
		var data = {
				id:"", name:"test_data", email:"",
				password:"", city:"", country:""
		};
		$scope.setData(data, 'logout');
	}

	/**
	 * ************************Register************************
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
					$scope.regError = true;
					console.log(response.response);	    			
					$scope.setData(response.response);    			
					//$scope.setUser(response.response); ?????????????????
					$('#registerModal').modal('hide'); //??????????

					$.alert({
						title: 'Success!',
						content: 'Your account have been registered successfully',
						type: 'green',
						typeAnimated: true,
					});

				}
				else{
					$scope.regError = true;
					
					$.alert({
						title: 'Error!',
						content: response.messageForUser,
						type: 'red',
						typeAnimated: true,
						buttons: {
							tryAgain: {
								text: 'Try again',
								btnClass: 'btn-red',
								action: function(){
									//$("#username").focus();??????????
								}
							}
						}
					});
				}
			},
			error:function(xhr,status){

				$.alert({
					title: 'Error!',
					content: 'Impossible execute request!',
					type: 'red',
					typeAnimated: true,
				});			
			}	    	
		});
	}

	/**
	 * *************************set data??????????????????????************************
	 */	
	$scope.setData = function (input, type){

		console.log(input)
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

			$scope.$storage = $localStorage.$reset({
				status: 1,
				userData:{
					id:input.user.id, name:input.user.firstname, email:input.user.email, 
					city:"", preferedCities:input.currentWeatherForPreferedCities
				},
				pd: $scope.passkey
			});
			$scope.status=1
			//$scope.data.id = input.id;
			$localStorage.userData.id = input.user.id;
			$localStorage.userData.firstname = input.user.firstName;
			$localStorage.userData.username = input.user.username;
			$localStorage.userData.lastname = input.user.lastName;
			$localStorage.userData.email = input.user.email;
			//$localStorage.userData.password = sjcl.encrypt(input.user.password, "data");
			$localStorage.userData.preferedCities = input.currentWeatherForPreferedCities;
			$localStorage.userData.notifications = input.notifications;

			if(type != 'logout'){
				$scope.$apply();
			}
			console.log($scope.preferedCities);
			$scope.getPreferedCities($scope.preferedCities);

		}
		else {
			console.log("Wrong Input")
		}
	}// end of setData function

	$rootScope.addUserCity = function(cityId,cityName){

		var prefedCities = [];
		var prefedCitiesToSplit = []
		var user = [];

		if($scope.$storage.userData.preferedCities!=null){
			console.log($scope.$storage.userData.preferedCities)
			prefedCitiesToSplit =  splitPreferredCities($scope.$storage.userData.preferedCities);
			prefedCities = prefedCitiesToSplit;
			console.log($scope.$storage.userData.preferedCities)
			
		}

		prefedCities.push({id:cityId,name:cityName});
		console.log(prefedCities)
		dataToSend = {
			'id':$scope.$storage.userData.id,
			'username':$scope.$storage.userData.username,
			'firstName':$scope.$storage.userData.firstname,
			'lastName':$scope.$storage.userData.lastname,
			'email':$scope.$storage.userData.email,
			'preferedCities':prefedCities
			
		};
		sendUpdate(dataToSend);
		//console.log(dataToSend)

	}// END OF ADD UER CITY

	// REMOVE USER CITY
	$scope.removeUserCity = function(cityId,cityName){
		console.log("remove city")
		var prefedCities = [];
		var newCitiesList = [];
		var dataToSend = [];
		var user = [];

		prefedCities =  splitPreferredCities($scope.$storage.userData.preferedCities);
		//var index = prefedCities.indexOf(cityId);
		for(var i =0; i<prefedCities.length; i++){
			if(cityId == prefedCities[i].id)
				var index = i;
		}

		prefedCities.splice(index,1);
		console.log(prefedCities)

		dataToSend = {
			'id':$scope.$storage.userData.id,
			'username':$scope.$storage.userData.username,
			'firstName':$scope.$storage.userData.firstname,
			'lastName':$scope.$storage.userData.lastname,
			'email':$scope.$storage.userData.email,
			'preferedCities':prefedCities
		}

		sendUpdate(dataToSend);

		
		console.log("model shoudl disapear")
	}// END OF REMVOE USER CITY

	function splitPreferredCities (citiesList){

		var citieslist = [];
		console.log("in split")

		for (var i=0; i<citiesList.length; i++){
			citieslist.push({id:citiesList[i].city.id,name:citiesList[i].city.name})
		}
		console.log(citieslist);
		return citieslist;
	} // end of Split Prefferred Cities

	$scope.profileUpdate = function(userInfo){
		var prefedCities = [];
		var prefedCitiesToSplit = [];
		console.log(userInfo)
		if(userInfo.preferedCities!=null){
			console.log(userInfo.preferedCities)
			prefedCitiesToSplit =  splitPreferredCities(userInfo.preferedCities);
			prefedCities = prefedCitiesToSplit;
		}
		dataToSend = {
				'id':userInfo.id,
				'username':userInfo.username,
				'firstName':userInfo.firstname,
				'lastName':userInfo.lastname,
				'email':userInfo.email,
				'preferedCities':prefedCities
			}
		
		sendUpdate(dataToSend);
	
	}
	/**
	 * update user
	 */
	function sendUpdate(dataToSend){
		var user = [];
		var pd = atob($scope.$storage.pd);
		var plainPd = sjcl.decrypt("secret",pd);
		
		$.ajax({
			type:'POST',
			url:"/ASDEWeather/api/auth/user/updateUser", 
			contentType:"application/json",
			dataType:"json",
			beforeSend: function (xhr) {
				xhr.setRequestHeader ("Authorization", "Basic " + btoa(dataToSend.username + ":" + plainPd))//sjcl.decrypt("secret", $scope.$storage.pd)));
			},
			data:JSON.stringify(dataToSend),
			success:function(response,status){

				if(response.status=="OK"){	 

					user.push({username:dataToSend.username,password:plainPd});
					$scope.login({username:dataToSend.username,password:plainPd},'system');
					$('#settingsModal').modal('hide');
					$.alert({
						title: 'Success!',
						content: 'Your changes have been Updated',
						type: 'green',
						typeAnimated: true,
					});
				}
				else{
					console.log(response.messageForUser);
					$.alert({
						title: 'Error!',
						content: 'Sorry, We could not excute your request!',
						type: 'red',
						typeAnimated: true,
					});		
				}
			},
			error:function(e){
				console.log(e)
			}
		});
	}

}]);