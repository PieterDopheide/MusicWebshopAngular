'use strict'

/* Controllers */

var myAppControllers = angular.module('myAppControllers', []);

myAppControllers.controller('HeaderController', function ($scope, $location) {
	$scope.isActive = function (viewLocation) {
		return viewLocation === $location.path();
	};
});

myAppControllers.controller('ProductListCtrl', function ($scope, $http) {
	$http.get('/MusicWebshopAngular/rest/products/').success(function(data) {
		$scope.products = data;
		console.log('succes list');
		console.log(data);
	});
});

myAppControllers.controller('ProductDetailCtrl', function ($scope, $routeParams, $http) {
	$http.get('/MusicWebshopAngular/rest/products/' + $routeParams.productId).success(function(data) {
		$scope.product = data;
		console.log('succes detail');
		console.log(data);
	});
});
