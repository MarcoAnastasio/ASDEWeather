/**
 * This is the main 
 */

'use strict';

var App = angular.module('myApp',['ngStorage']);



App.directive('emitLastRepeaterElement', function() {
	return function(scope,element) {
		getPhotoFromAPI(scope.currentWeather.city.name, 400, 300,false);
	};
});

App.directive('emitLastRepeaterElementCity', function() {
	return function(scope,element) {
		getPhotoFromAPI(scope.w.city.name, 400, 300,true);
	};
});
