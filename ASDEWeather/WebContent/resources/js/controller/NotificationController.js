App.controller("NotificationController", ["$scope","$rootScope","$window","$localStorage","$sessionStorage","$interval", 
	function($rootScope, $scope, $window, $localStorage, $sessionStorage,$interval ){	


	$scope.setNotification = function(username, password){		
		$scope.notificationsStatus =  0;

		if(username != null && password != null)
			$rootScope.getNotifications();
	}
	
	
	$interval(function(){$rootScope.getNotifications();},3600000);
	
	$rootScope.getNotifications = function(){
		$scope.notificationsReadStatus = 0
		var pd = atob($scope.$storage.pd);
		var plainPd = sjcl.decrypt("secret",pd);
		
		console.log("IN GET NOtificatios")
		var notificationList = [];
		$.ajax({
			type:'GET',
			url:"/ASDEWeather/api/auth/user/getNotifications", 
			contentType:"application/json",
			dataType:"json",
			beforeSend: function (xhr) {
				xhr.setRequestHeader ("Authorization", "Basic " + btoa($scope.$storage.userData.username+ ":" + plainPd))
			},
			success:function(response,status){

				if(response.status=="OK"){
					console.log("notifications OK")
					console.log(response.response)
					if (response.response.length > 0){
						//$scope.$storage = $localStorage.setItem({
						$scope.notificationsStatus= response.response.length,
						$scope.notificationList =  new Notifications(response.response);
						$scope.notificationList = $scope.notificationList.notification_list;
						$scope.notificationsReadStatus = 0;	
						//$scope.notificationViewd()
						//});
						$scope.$apply();


					}// end of length of response > 0
					else 
						$scope.notificationsStatus = 0

				}// end of if response is OK
				else{
					console.log(response)
				}//end of else
			}	   // end of success  	

		}) // end of ajax call

		return notificationList;
	} // END OF GET NOTIFICATIONS 
	
	
	

	$scope.clearNotification = function(){
		$localStorage.$reset({
			notificationsStatus: 0,
			notificationList : []
		});
	}
	$scope.notificationViewd = function(){		
			$rootScope.notificationsReadStatus = 1;	
			$('#notifcation').addClass('notification-none');
			$scope.$apply();
			
		
	}

}]);