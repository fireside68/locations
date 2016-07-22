angular.module('app').service('LocationService', ['$http', '$requestParams', function($http, $requestParams){
	
	var url = '/location'
		
	this.allLocations = function() { return $http.get(url + 'allLocations') };
	this.findByArea = function(area) { return $http.get(url + area) }
	this.getUrlModel = function(title) { return $http.get('/location/getUrlModel/' + title)}


}]);