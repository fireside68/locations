angular.module('app').controller(
	'LoginController',
	['LoginService', '$location', '$window', '$timeout',  function(LoginService, $location, $window, $timeout){

	var ctrl = this;

	ctrl.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  LoginService.getLogin(login)
		.then(function(result) {
			 ctrl.response = result.data;
			 if(ctrl.response.username === 'unregistered'){
				 $location.path('/login/userNotFoundTemplate.html');
			 } else if(ctrl.response.username === 'invalid'){
				 $location.path('/login/loginUnsuccessfulTemplate.html');
			 }else {
				 LoginService.setLoggedIn(true)
				 if(ctrl.response.admin === true){
					 $timeout(function() { $location.path('/admin') }, 1000)
				} else {
					$location.path('/user')
				}
			 }
	});

	}
}])
