angular.module('app').service('LoginService', ['$http', function($http){

	var url = 'user/login';

	this.getLogin = function(login) { return $http.post(url + 'login') };
	// this fucking thing returns a fucking promise like an asshole
	// the promise, the asshole in question, contains the List<User>

}]);
