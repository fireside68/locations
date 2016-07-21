angular.module('app').controller(
	'LoginController',
	['LoginService', '$location', '$window', '$timeout',  function(LoginService, $location, $window, $timeout){

	var ctrl = this;
	
	ctrl.here = "LoginController reporting for duty";
		
	ctrl.isRegistered = function(flag){
		return flag;
	};
	
	ctrl.isValid = function(flag) {
		return flag;
	};
	
	ctrl.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  LoginService.getLogin(login)
		.then(function(result) {
			 var response = result.data;
			 console.dir(response);
			 if(response.username === 'unregistered'){
				 $location.path('/login/userNotFoundTemplate.html');
			 } else if(response.username === 'invalid'){
				 $location.path('/login/loginUnsuccessfulTemplate.html');
			 }else {
				 if(response.admin === true){
					 $timeout(function() { $location.path('/admin') }, 1000)
				} else {
					$location.path('/user')
				}
			 }
	});
	  
	}
}])
