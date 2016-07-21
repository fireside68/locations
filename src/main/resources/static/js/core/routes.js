angular.module('app')
.config(['$routeProvider', 'baseRoute', 'homePage', 'LoginService', 'AdminService',
      function config($routeProvider, baseRoute, homePage, LoginService, AdminService) {

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
		controllerAs: 'userDetailController',
    loginRequired: true
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
	  loginRequired: true,
    adminRequired: true,
  }).
  when('/signup', {
	  templateUrl: baseRoute + '/signup/signupTemplate.html',
	  controller: 'SignupController',
	  controllerAs: 'signupController'
  }).
	otherwise('/home');
}])
