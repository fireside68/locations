angular.module('app')
.controller('AdminController',
		['AdminService', '$location',
		 function(AdminService, $location){

	var ctrl = this;

	ctrl.url = $location.path();
	
	/*ctrl.newLocation = function(){
		let newLocation = {
			"title":ctrl.title,
			"description":ctrl.description
		}
		return newLocation
	}*/
	

	
	ctrl.addLocation = function() {
		console.dir(ctrl.newLocation)
		AdminService.addLocation(ctrl.newLocation).then(function(result){
			ctrl.location = result.data
		})
	}
}])
