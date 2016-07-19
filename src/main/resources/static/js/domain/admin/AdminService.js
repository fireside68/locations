angular.module('app').service('AdminService', ['$http', function($http){

	var url = 'user/admin/';
	
	$(function () {
	    $('#tabs').w2tabs({
	        name: 'tabs',
	        active: 'tab1',
	        tabs: [
	            { id: 'tab1', caption: 'Tab 1' },
	            { id: 'tab2', caption: 'Tab 2' },
	            { id: 'tab3', caption: 'Tab 3' },
	            { id: 'tab4', caption: 'Tab 4' }
	        ],
	        onClick: function (event) {
	            $('#selected-tab').html(event.target);
	        }
	    });
	});

	
	this.getAllUsers = function() { return $http.get(url + 'allUsers') };
	// this fucking thing returns a fucking promise like an asshole
	// the promise, the asshole in question, contains the List<User>
	
}]);

