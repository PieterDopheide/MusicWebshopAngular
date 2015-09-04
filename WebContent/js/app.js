'use strict';

/* App Module */

var myApp = angular.module('myApp', [
  'ngRoute',
  'myAppControllers'
]);

myApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/products', {
			templateUrl: 'partials/products.html',
			controller: 'ProductListCtrl'
		}).
		when('/products/:productId', {
	        templateUrl: 'partials/product-detail.html',
	        controller: 'ProductDetailCtrl'
	    }).
		otherwise({
			templateUrl: 'partials/home.html'
//			redirectTo: ''
		});
}]);
