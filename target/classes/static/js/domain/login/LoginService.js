angular.module('app').service('LoginService', ['$http', function($http){

	var url = 'user/';

	var srv = this;

	var isLoggedIn = false;

	srv.getLogin = function(login) {

		return $http.post(url + 'login', login)

	};
	
	srv.checkLogin = function() {
		return isLoggedIn
	}

	srv.setLoggedIn = function(flag){
		isLoggedIn = flag
	}
}]);
