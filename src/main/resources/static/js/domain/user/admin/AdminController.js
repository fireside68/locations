angular.module('app').controller('AdminController', ['AdminService', 'admin', function(AdminService, admin){

	var ctrl = this;
	
	ctrl.admin = admin.data;
	
	console.dir(ctrl.admin);
}])