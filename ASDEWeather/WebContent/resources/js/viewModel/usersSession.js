App.service("UserService",["$http","$window","$document","ngStorage", function($http,$window,$document){
	this.TestFunction = function(){
		console.log("Arrived here");
		return "In here";
	}
	
	/*this.setLoggedUser = function(userInfo){
		console.log(userInfo)
		json = {
				id:userInfo.user.id,
				username:userInfo.user.firstName,
				username:userInfo.user.username,
				email:userInfo.user.email,
				preferredCities : userInfo.user.preferredCities,
		}
		$window.sessionStoreage.setItem('UserLogged',1);
		$window.sessionStorage.setItem(userInfo.user.id, JSON.stringify(json));
	}
	this.loggedUser= function(){
		if($window.sessionStoreage.getItem('UserLogged') == null){
			$window.sessionStoreage.setItem('UserLogged',0);
		}
		return $window.sessionStoreage.getItem('UserLogged');
	}
	this.logOff= function(id){
		$window.sessionStoreage.setItem('UserLogged',0);
		 $window.sessionStorage.removeItem(id);
	}
	var removeItem = function(){
	      $window.sessionStorage.clear();
	 }*/
	
}])