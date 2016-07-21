angular.module('app').service('LoginService', ['$http', function($http){

	var url = 'user/';

	var srv = this;

	srv.user = function() {
		var user = {
			"username":srv.username,
			"admin":srv.admin
		}
	};


	srv.getLogin = function(login) {

		return $http.post(url + 'login', login)

	};


}]);
