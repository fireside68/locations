angular.module('app').service('LocationService', ['$http', '$routeParams', function($http, $routeParams){
	
	var url = '/location/'
		
	this.allLocations = function() { return $http.get(url + 'allLocations') };
	this.findByArea = function(area) { return $http.get(url + area) }
	this.getUrlModel = function(title) { return $http.get('/location/getUrlModel/' + title)}
	this.addLocation = function(add) {
		return $http.post(url + 'addLocation', add)
	};
	
	this.updateLocation = function(update) { return $http.post(url + 'updateLocation', update) }


}]);