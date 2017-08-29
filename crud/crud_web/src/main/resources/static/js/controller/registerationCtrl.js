(function(){
	'use strict'
	
	angular.module("crudApp").controller("registerationCtrl" ,["$scope","registerationService", "$location" , function($scope,registerationService, $location){
		
		var copy=null;
		 $scope.userDetails = {
				   firstName :"",
				   lastName : "",
				   contactNumber :"" ,
				   email : "",
				   password : ""
				 }
		 copy=angular.copy($scope.userDetails);
		
		 $scope.clearRegisterDetails = function(){
				$scope.userDetails=copy;
			
			} 
		 
		$scope.saveUser =  function(){
		 console.log("inside saveUser() of registeration ctrl");
		registerationService.saveUser($scope.userDetails).then(function(data){
			 console.log(data);
			 console.log(data.data)
			 if(data.status =='200'){
				 console.log("Register data saved successfully");
				 $scope.clearRegisterDetails();
				 $location.path('/home');
			 }
		 });
	}
	}]);
})();