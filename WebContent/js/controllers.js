'use strict'

/* Controllers */

var myAppControllers = angular.module('myAppControllers', []);

myAppControllers.controller('HeaderController', function ($scope, $location) {
	$scope.isActive = function (viewLocation) {
		if ($location.path().substr(1, 8) === 'products'){
			return viewLocation === '/products';
		}
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
	$http.get('/MusicWebshopAngular/rest/shopping-cart/count').success(function(data) {
		$scope.cartCount = data;
		console.log('Found ' + data + ' product(s) in cart');
	});
	$http.get('/MusicWebshopAngular/rest/shopping-cart/total').success(function(data) {
		$scope.cartTotal = data;
		console.log('Total: $' + data);
	});
});

myAppControllers.controller('CartCtrl', function ($http, $scope, $route) {
	$scope.add = function (product) {
		$http.post('/MusicWebshopAngular/rest/shopping-cart/', product).success(function(data) {
			alert('Added to cart!');
			console.log('Added product to cart:');
			console.log(product);
			$route.reload(); // reload page
		});
	}
	$scope.remove = function (product) {
		$http.delete('/MusicWebshopAngular/rest/shopping-cart/' + product.id).success(function(data) {
			alert('Removed from cart!');
			console.log('Removed product from cart:');
			console.log(product);
			$route.reload(); // reload page
		});
	}
});
