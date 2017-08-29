(function(){
	
	'use strict'
	angular.module("crudApp").factory('registerationService', function($http,$q){
		
		var obj= {};
		
		obj.saveUser = function(userDetails){
			console.log("saveUser() inside registerationService");
			console.log(userDetails);
			var deferred = $q.defer();
			
			$http({
				   method :'POST',
				   url :'registerUser',
				   data : JSON.stringify({
					   "firstName" : userDetails.firstName,
					   "lastName" : userDetails.lastName,
					   "contactNumber" : userDetails.contactNumber,
					   "email" :userDetails.email,
					   "password" : userDetails.password
				   })
			})
		   .then(function successCallback(response){
				console.log("success");
				console.log(response);
				deferred.resolve(response);
		    },function errorCallback(response){
		    	console.log("error");
		    	console.log(response);
		    	deferred.reject(response);
		    });
			return deferred.promise;
		}
		
		return obj;
	});
})();