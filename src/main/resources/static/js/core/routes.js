angular.module('app')
.config(['$routeProvider', 'baseRoute', 'homePage',
      function config($routeProvider, baseRoute, homePage) {

	$routeProvider.
	when('/home', {

		templateUrl: homePage,
		controller: 'HomeController',
		controllerAs: 'homeController'

	}).
	when('/user', {

		templateUrl: baseRoute + 'user/userTemplate.html',
		controller: 'UserController',
		controllerAs: 'userController',
		resolve: {
			factory: checkRouting
		}
	}).
	when('/user/findUser/:username', {

		templateUrl: baseRoute + 'user/userDetailTemplate.html',
		controller: 'UserDetailController',
		controllerAs: 'userDetailController',
		resolve: {
			factory: checkRouting
		}
	}).
  when('/login', {
    templateUrl: baseRoute + '/login/loginTemplate.html',
    controller: 'LoginController',
    controllerAs: 'loginController'
  }).
  when('/login/loginUnsuccessfulTemplate.html', {
	templateUrl: baseRoute + '/login/loginUnsuccessfulTemplate.html',
	controller: 'LoginController',
	controllerAs: 'loginController'
  }).
  when('/login/userNotFoundTemplate.html', {
	  templateUrl: baseRoute + '/login/userNotFoundTemplate.html',
	  controller: 'LoginController',
	  controllerAs: 'loginController'
  }).
  when('/admin', {
	  templateUrl: baseRoute + '/admin/adminTemplate.html',
	  controller: 'AdminController',
	  controllerAs: 'adminController',
	  resolve: {
		  factory: function($q, $http, $rootScope, $location, AdminService, LoginService) {
			  getLocations($rootScope, $http, AdminService)
			  getAllAreas($rootScope, $http, AdminService)
			  checkRouting($q, $rootScope, $location, LoginService)
			  
		  }
	  }
  }).
  when('/location/getUrlModel/:title', {
	  templateUrl: baseRoute + '/admin/locations/locationTemplate.html',
	  controller: 'LocationController',
	  controllerAs: 'locationController',
	  resolve: {
		  factory: checkRouting
	  }
  }).
  when('/signup', {
	  templateUrl: baseRoute + '/signup/signupTemplate.html',
	  controller: 'SignupController',
	  controllerAs: 'signupController'
  }).
	otherwise('/home');
}])

var getLocations = function($rootScope, $http, AdminService) {
	AdminService.getUrlModels().then(function(result) {	
		$rootScope.locationsList =  result.data
	})
}

var getAllAreas = function($rootScope, $http, AdminService) {
	AdminService.getAllAreas().then(function(result) {
		console.dir(result.data)
		$rootScope.areasList = result.data
	})
}

var checkRouting = function($q, $rootScope, $location, LoginService){
	if(LoginService.checkLogin() === false){
		alert("You must be logged in to access this page")
		$location.path('/home')
	}
}
