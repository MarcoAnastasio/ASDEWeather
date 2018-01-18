App.controller("NotificationController", ["$scope","$rootScope","$localStorage","$sessionStorage", 
	function($rootScope, $scope, $window, $localStorage, $sessionStorage ){	
	
	$rootScope.getNotifications = function(){
		
		$scope.notificationsStatus = 0;
		$.ajax({
			type:'GET',
			url:"/ASDEWeather/api/auth/user/getNotifications", 
			contentType:"application/json",
			dataType:"json",
			data:JSON.stringify(dataToSend),
			success:function(response,status){

				if(response.status=="OK"){
					if (response.response.length > 0)
						$scope.notificationsStatus = response.response.length;
						$scope.notificationList = response.response;
				}
				else{
					console.log(response)
				}
			}	    	
		});

	}
	
}]);