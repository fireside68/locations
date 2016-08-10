angular.module('app').controller('SignupController', ['SignupService', '$scope', '$http', '$location', function(SignupService, $scope, $http, $location)
{

	var ctrl = this;
	
	ctrl.here = "SignupController reporting for duty"
	
	
		$scope.newUser = function() {
		var newUser = {
			"username": ctrl.username,
			"password": ctrl.password
		}

	SignupService.addUser(newUser).then(function(result){
		ctrl.user = result.data;
		console.dir(ctrl.user)
	})
	
	};

	}]);