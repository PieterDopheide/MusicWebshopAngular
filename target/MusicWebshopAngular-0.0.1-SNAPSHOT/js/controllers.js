'use strict'

/* Controllers */

var myAppControllers = angular.module('myAppControllers', []);

myAppControllers.controller('HeaderController', function ($scope, $location) {
	$scope.isActive = function (viewLocation) {
		return viewLocation === $location.path();
	};
});

myAppControllers.controller('ProductListCtrl', function ($scope, $http) {
//	$http.get('instruments/instruments.json').success(function(data) {
	$http.get('/MusicWebshopAngular/rest/products/').success(function(data) {
		$scope.products = data;
		console.log('succes');
		console.log(data);
	});
	
//	$scope.orderProp = 'age';
});

myAppControllers.controller('ProductDetailCtrl', function ($scope, $routeParams) {
	$scope.productId = $routeParams.productId;
});
