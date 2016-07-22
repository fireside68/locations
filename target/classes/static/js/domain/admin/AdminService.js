	angular.module('app').service('AdminService', ['$location', '$http', function($http){

	var url = $location.url();


	this.getAllUsers = function() { return $http.get(url + 'allUsers') };
	// this fucking thing returns a fucking promise like an asshole
	// the promise, the asshole in question, contains the List<User>

}]);
