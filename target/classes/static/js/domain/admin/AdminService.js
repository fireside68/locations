	angular.module('app').service('AdminService', ['$http', function($http){

	this.getAllUsers = function() { return $http.get(url + 'allUsers') };


}]);
