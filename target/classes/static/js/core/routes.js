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
		loginRequired: true,
		resolve: {
			allUsers: function(UserService){
				return UserService.getAllUsers();
			}
		}
	}).
	when('/user/findUser/:username', {

		templateUrl: baseRoute + 'user/userDetailTemplate.html',
		controller: 'UserDetailController',
		controllerAs: 'userDetailController'
	}).
  when('/login', {
    templateUrl: baseRoute + '/login/loginTemplate.html',
    controller: 'LoginController',
    controllerAs: 'loginController'
  }).
  when('/login/unsuccessful', {
	  templateUrl: baseRoute + '/login/loginUnsuccessful.html'
  }).
  when('/login/nouser', {
	  templateUrl: baseRoute + '/login/userNotFound.html'
  }).
  when('/admin', {
	  templateUrl: baseRoute + '/admin/adminTemplate.html',
	  controller: 'AdminController',
	  controllerAs: 'adminController',
	  loginRequired: true
  }).
  when('/signup', {
	  templateUrl: baseRoute + '/signup/signupTemplate.html',
	  controller: 'SignupController',
	  controllerAs: 'signupController'
  }).
	otherwise('/home');
}])
