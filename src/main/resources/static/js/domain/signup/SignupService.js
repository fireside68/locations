angular.module('app').service('SignupService', ['$http', function(SignupService, $http){

	var url = 'user/';
	
	this.addUser = function() { return $http.post(url + 'addUser') };
	
}]);