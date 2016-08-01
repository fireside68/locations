angular.module('app').service('SignupService', ['$http', function($http){

	var url = 'user/addUser';
	
	this.addUser = function(user) { return $http.post(url, user) };
	
}]);