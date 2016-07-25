angular.module('app').controller('LocationController', ['LocationService', '$routeParams', '$location', '$http', function(LocationService, $routeParams, $location, $http){
	
	var ctrl = this
	
	LocationService.getUrlModel($routeParams.title)
	.then(function(result) {
		console.dir(result.data)
		ctrl.location = result.data
	})

	
	ctrl.updateLocation = function() {
		var location = {
			"area": ctrl.area,
			"title": ctrl.title,
			"description": ctrl.description,
		}
		
		LocationService.updateLocation(location).then(function(result){
			ctrl.respone = result.data
			alert(result.data)
		})	
		}

}])