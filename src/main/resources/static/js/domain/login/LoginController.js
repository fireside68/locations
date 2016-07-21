angular.module('app').controller(
	'LoginController',
	['LoginService', '$location', function(LoginService, $location){

	var ctrl = this;
	
	ctrl.here = "LoginController reporting for duty"
		
	ctrl.isRegistered = function(flag){
		return flag;
	}
	
	ctrl.isValid = function(flag) {
		return flag;
	}
	
	ctrl.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	 
	  
	 
	LoginService.getLogin(login)
		.then(function(result) {
			 var response = result.data
			 console.dir(response)
		if(response.username === "unregistered"){
			$location.path('/login/userNotFound.html')
		} else if(response.username === "invalid"){
			$location.path('/login/Unsuccessful.html')
		}else
			if(response.admin === true){
				$location.path('/admin')
				} else {
				$location.path('/user')
		}
	});
	  
	}
}])
