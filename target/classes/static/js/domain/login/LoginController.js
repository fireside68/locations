angular.module('app').controller(
	'LoginController',
	['LoginService', '$location', '$window', '$timeout', 'AdminService',  function(LoginService, $location, $window, $timeout, AdminService){

	var ctrl = this;

	ctrl.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  LoginService.getLogin(login)
		.then(function(result) {
			 ctrl.response = result.data;
			 if(ctrl.response === 'unregistered'){
				 $location.path('/login/userNotFoundTemplate.html');
			 } else if(ctrl.response === 'invalid'){
				 $location.path('/login/loginUnsuccessfulTemplate.html');
			 }else {
				 LoginService.setLoggedIn(true)
				 if(ctrl.response.role === 1){	
					 AdminService.user = ctrl.response.username
					 $timeout(function() { $location.path('/admin') }, 1000)
				} else {
					$location.path('/user')
				}
			 }
	});

	}
}])
