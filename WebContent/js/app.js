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
			controller: 'InstrumentListCtrl'
		}).
		otherwise({
			templateUrl: 'partials/home.html'
//			redirectTo: ''
		});
}]);
