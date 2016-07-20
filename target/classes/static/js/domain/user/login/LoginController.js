angular.module('app').controller(
	'LoginController',
	['LoginService', '$location', function(LoginService, $location){

	var ctrl = this;

	ctrl.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  
	 
	LoginService.getLogin(login)
		.then(function(result) {
			 var response = result.data
		console.log("result: ")
		console.dir(result)
		if(response.username === "invalid"){
			$location.path('/user')
		}else
			if(response.admin === true){
				$location.path('/admin')
				} else {
				console.dir(response.admin);
				$location.path('/user')
		}
	});

	console.dir(login);}
}])
