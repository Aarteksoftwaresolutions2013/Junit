(function(){
	'use strict'
	 
	angular.module("crudApp").factory('loginService' , function($http,$q,$window, $location){
		
		var obj={};
		obj.loginUser = function(email,password){
			console.log(" loginUser method in service ");
			var deferred = $q.defer();
			
			$http({
				method : 'POST',
				url : 'user',
				data : JSON.stringify({
					"email" : email,
					"password" : password
				})
					
			}).then(function successCallback(response){
				console.log("success");
				console.log(response);
				deferred.resolve(response);
				
			},function errorCallback(response){
				console.log(response);
				deferred.reject(response)
			});
			return deferred.promise;
		}
		
		return obj;
	});
})();