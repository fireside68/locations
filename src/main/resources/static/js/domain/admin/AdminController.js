angular.module('app')
.controller('AdminController',
		['AdminService', '$location',
		 function(AdminService, $location){

	var ctrl = this;

	ctrl.url = $location.url();
	
}])
