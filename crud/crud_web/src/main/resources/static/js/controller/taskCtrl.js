(function(){
	'use strict'
	angular.module('crudApp').controller("taskCtrl",["$scope",function($scope){
		
		$scope.tasks =[
			{'title' : 'A default item',
			  'done' : false
			},
			{
				'title' : 'A complete default item',
				'done' : true
			}
		];
		
		$scope.addTask = function(){
			console.log("Add task method in task Ctrl");
			$scope.tasks.push({'title':$scope.newTask , 'done' : false})
			$scope.newTask = ''
				console.log($scope.tasks);
		}
	
		
	}])
})();