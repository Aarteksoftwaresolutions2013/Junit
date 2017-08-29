(function(){
	'use strict'
	angular.module('crudApp').controller("orderFormCtrl" ,["$scope" , function($scope){
	   
		$scope.services =  [
		        {
		        	name : 'Web Development',
		        	price: 300,
		        	active: 'true'
		        },
		        {
		        	name:'Design',
		        	price:400,
		        	active:'false'
		        },
		        {
		        	name : 'Integration',
		        	price : 250,
		        	active : 'false'
		        },
		        {
		        	name : 'Training',
		        	price : 220,
		        	active : 'false'
		        }
		];
		
		$scope.toggleActive = function(s){
			s.active = !s.active;
			console.log(s.active);
		};
		
	    $scope.total = function(){

	        var total = 0;

	        // Use the angular forEach helper method to
	        // loop through the services array:

	        angular.forEach($scope.services, function(s){
	            if (!s.active){
	                total = total + s.price;
	            }
	        });
	        return total;
	    };
		
	}]);
	
})();