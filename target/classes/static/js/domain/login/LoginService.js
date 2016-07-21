angular.module('app').service('LoginService', ['$http', function($http){

	var url = 'user/';
	
	var srv = this;
	

	srv.getLogin = function(login) { 
		
		return $http.post(url + 'login', login) 
		
	};	
	

}]);
