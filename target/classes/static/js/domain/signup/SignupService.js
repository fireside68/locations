angular.module('app').service('SignupService', ['$http', function(SignupService, $http){

	var url = 'user/';
	
	this.addUser = function(user) { return $http.post(url + 'addUser'), user };
	
}]);