angular.module('app')
.controller('AdminController',
		['AdminService', '$location',
		 function(AdminService, $location){

	var ctrl = this;
	
	ctrl.url = $location.path();
	
	ctrl.addLocation = function() {
		var newLocation = {
			"area":ctrl.area,
			"title":ctrl.title,
			"description":ctrl.description
		}
	
		AdminService.addLocation(newLocation).then(function(result){
			ctrl.location = result.data
			alert(ctrl.location.toString())
			console.dir(ctrl.location)
		})
	}
}])
