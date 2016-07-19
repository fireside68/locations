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
  when('/user/login', {
    templateUrl: baseRoute + 'user/login/loginTemplate.html',
    controller: 'LoginController',
    controllerAs: 'loginController'
  }).
	otherwise('/home');
}])
