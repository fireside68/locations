angular.module('app').controller('LocationController', ['LocationService', '$routeParams', '$location', '$http', function(LocationService, $routeParams, $location, $http){
	
	var ctrl = this
	
	LocationService.
	
	ctrl.location = function() {
		var location = {
			"area": ctrl.area,
			"title": ctrl.title,
			"description": ctrl.description,
			"dateCreated": ctrl.dateCreated,
			"dateUpdated": ctrl.dateUpdated
		}
		
		LocationService.getUrlModel(ctrl.area)
		.then(function(result) {
			ctrl.response = result.data
		})
	}
}])