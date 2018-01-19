App.controller("NotificationController", ["$scope","$rootScope","$localStorage","$sessionStorage", 
	function($rootScope, $scope, $window, $localStorage, $sessionStorage ){	
		
	
	$scope.setNotification = function(username, password){		
			$scope.notificationsStatus =  0;
			
			if(username != null && password != null)
				$rootScope.getNotifications();
	}
	$rootScope.getNotifications = function(){
		
		console.log("IN GET NOtificatios")
		var notificationList = [];
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
					if (response.response.length > 0){
						//$scope.$storage = $localStorage.setItem({
							$scope.notificationsStatus= response.response.length,
							$scope.notificationList =  response.response
						//});
						$scope.$apply();
						
				
					}// end of length of response > 0
					
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
	
	
}]);