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

myAppControllers.controller('ShoppingCartCtrl', function ($scope, $http) {
	$http.get('/MusicWebshopAngular/rest/shopping-cart/').success(function(data) {
		$scope.products = data;
		console.log('succes list');
		console.log(data);
	});
});

myAppControllers.controller('CartCtrl', function ($http, $scope) {
	$scope.add = function () {
//		alert('Added to cart: ' + $scope.product.name);
		$http.post('/MusicWebshopAngular/rest/shopping-cart/', $scope.product).success(function(data) {
			alert('Added to cart!');
			console.log('Added product to cart:');
			console.log($scope.product);
		});
	}
	$scope.remove = function () {
//		alert('Trying to remove: ' + $scope.product.name);
//		$http.delete('/MusicWebshopAngular/rest/shopping-cart/').success(function(data) {
		$http.delete('/MusicWebshopAngular/rest/shopping-cart/' + $scope.product.id).success(function(data) {
			alert('Removed from cart!');
			console.log('Removed product from cart:');
			console.log($scope.product);
		});
	}
});
