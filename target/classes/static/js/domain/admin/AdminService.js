angular.module('app').service('AdminService', ['$http', function($http){
	
	var url = '/location'
	var areaUrl = '/area'
	
	this.getAllUsers = function() { return $http.get(url + '/allUsers') };
	this.getUrlModels = function() { return $http.get('/location/allUrlModels/') }
	this.getByArea = function() { return $http.get(url + '/findByArea/' + $requestParams)};
	this.addHits = function() { return $http.post(url + '/addHits')};
	this.decrementHits = function() { return $http.post(url + '/decrementHits')};
	this.getAllAreas = function() { return $http.get(areaUrl + '/allAreas')}
	this.addLocation = function(newLocation) { return $http.post(url + '/addLocation', newLocation)}

}]);
