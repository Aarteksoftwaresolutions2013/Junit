(function(){
	'use strict'
	var app = angular.module("crudApp");
	app.config(function($routeProvider, $locationProvider){
		$routeProvider
		
		.when('/login' , {
			templateUrl : 'view/login.html',
			controller : 'loginCtrl'
		})
		.when('/welcome', {
			templateUrl : 'view/welcome.html'
		})
		.when('/register',{
			templateUrl : 'view/registration.html',
			controller : 'registerationCtrl'
		})
		.when('/addtask',{
			templateUrl : 'view/task.html',
			controller : 'taskCtrl'
		})
		.when('/orderForm',{
			templateUrl : 'view/orderForm.html',
			controller : 'orderFormCtrl'	
		})
		.otherwise({
			templateUrl : 'home.html'
		});
		$locationProvider.html5Mode(true);
		//$locationProvider.hashPrefix("");
	})
})();