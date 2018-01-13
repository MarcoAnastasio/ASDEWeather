/**
 * This is the main 
 */
var App = angular.module('myApp',['ngStorage']);

angular.module('cookieStoreExample', ['ngCookies'])
.controller('UserController', ['$cookieStore', function($rootScope,$cookieStore) {
//	Put cookie
	$cookieStore.put('myFavorite','oatmeal');
//	Get cookie
	var favoriteCookie = $cookieStore.get('myFavorite');
//	Removing a cookie
	$cookieStore.remove('myFavorite');
}])

App.directive('emitLastRepeaterElement', function() {
	return function(scope,element) {
		getPhotoFromAPI(scope.w.name, 400, 300);
	};
});