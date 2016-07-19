angular.module('app').controller(
	'LoginController',
	['LoginService', '$location', '$routeParams', function(LoginService, $routeParams){

	var ctrl = this;
	ctrl.availableRoles = ['admin', 'user', 'other']
	
	ctrl.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password,
	  "role" : ctrl.role,
	  }
	  ctrl.roleSelected = function(role)
		{
			ctrl.role = role;
		}
	LoginService.getLogin(login)
		.then(function(result) {
		ctrl.login = result.data;
		console.dir(ctrl.login)
		if(ctrl.login === true){
			console.dir(ctrl.login);
		} else {
			console.dir(result.data);
			$location.path('#/user/login/loginTemplate.html')
		}
	});

	console.dir(ctrl.login);}
}])
