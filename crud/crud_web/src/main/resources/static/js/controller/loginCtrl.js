(function(){
	'use strict'
	
	var app = angular.module("crudApp");
	app.controller("loginCtrl" , ["$scope","$window","$location","loginService","$sessionStorage",function($scope,$window,$location,loginService,$sessionStorage){
		
		
		
		$scope.loginUser = function(){
			console.log("loginUser method");
			console.log($scope.email);
			console.log($scope.password);
			loginService.loginUser($scope.email,$scope.password).then(function(data){
				console.log("user is valid")
				console.log(data);
				
				
				console.log($scope.userDetails.password);
				if(data.status == '200'){
					console.log("user login successfull");
					$sessionStorage.userSessionData  = {
					email : $scope.email,
					password :$scope.password
					}
					
					$location.path('/welcome');
					
				}else{
					console.log("user login Unsuccessfull");
				}
			});	
		} 
		
		$scope.logout= function(){
			console.log("inside logout method");
			
			console.log($sessionStorage.userSessionData.email);
			console.log($sessionStorage.userSessionData.password);
			
			delete $sessionStorage.userSessionData ;
			$location.path('/login');
		}
		
	}]);
})();