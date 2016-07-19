angular.module('app').service('UserDetailService', ['$http', function($http) {
	
	var url = 'user/findUser/';
	
	this.getUserDetails = function(username) { return $http.get(url + username) };
	// this also returns a promise, like an asshole
}])