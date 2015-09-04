'use strict'

/* Controllers */

var myAppControllers = angular.module('myAppControllers', []);

myAppControllers.controller('InstrumentListCtrl', function ($scope, $http) {
	$http.get('instruments/instruments.json').success(function(data) {
		$scope.instruments = data;
	});
	
//	$scope.orderProp = 'age';
});

// Doesn't work yet!
myAppControllers.controller('HeaderController', function ($scope, $location) {
//	alert($location.path());
	$scope.isActive = function (viewLocation) {
		return viewLocation === $location.path();
	};
});
