angular.module('app').controller('SignupController', ['SignupService', function(SignupService)
{

	var ctrl = this;
	
	ctrl.here = "SignupController reporting for duty"
	
	
	ctrl.newUser = function() {
		var newUser = {
			"username": ctrl.username,
			"password": ctrl.password
		}

	SignupService.addUser(newUser).then(function(result){
		ctrl.user = result.data;
	})
	
	};

	}]);