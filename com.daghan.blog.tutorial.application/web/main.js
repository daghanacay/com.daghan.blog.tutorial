'use strict';

(function() {

	var MODULE = angular.module('com.daghan.blog.tutorial',
			[ 'ngRoute', 'ngResource' ]);

	MODULE.config( function($routeProvider) {
		$routeProvider.when('/', { controller: mainProvider, templateUrl: '/com.daghan.blog.tutorial/main/htm/home.htm'});
		$routeProvider.when('/about', { templateUrl: '/com.daghan.blog.tutorial/main/htm/about.htm'});
		$routeProvider.otherwise('/');
	});
	
	MODULE.run( function($rootScope, $location) {
		$rootScope.alerts = [];
		$rootScope.closeAlert = function(index) {
			$rootScope.alerts.splice(index, 1);
		};
		$rootScope.page = function() {
			return $location.path();
		}
	});
	
	
	
	var mainProvider = function($scope, $http) {
		
		$scope.upper = function() {
			var name = prompt("Under what name?");
			if ( name ) {
				$http.get('/rest/upper/'+name).then(
						function(d) {
							$scope.alerts.push( { type: 'success', msg: d.data });
						}, function(d) {
							$scope.alerts.push( { type: 'danger', msg: 'Failed with ['+ d.status + '] '+ d.statusText });
						}
				);
			}
		};
	
	}
	
})();
