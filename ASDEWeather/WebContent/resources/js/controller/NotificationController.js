App.controller("NotificationController", ["$scope","$rootScope","$localStorage","$sessionStorage", 
	function($rootScope, $scope, $window, $localStorage, $sessionStorage ){	
	
	$scope.getNotifications = function(){
		
		$scope.notificationsStatus = 0;
		$.ajax({
			type:'GET',
			url:"/ASDEWeather/api/auth/user/getNotifications", 
			contentType:"application/json",
			dataType:"json",
			beforeSend: function (xhr) {
				xhr.setRequestHeader ("Authorization", "Basic " + btoa("ciccio"+ ":" + "ciccio"))
			},
			success:function(response,status){

				if(response.status=="OK"){
					console.log("notifications OK")
					console.log(response.response)
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