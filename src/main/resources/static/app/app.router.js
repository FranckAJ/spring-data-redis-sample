(function() {
	angular.module('app').config(function($routeProvider) {

		$routeProvider.when("/upload", {
			templateUrl : 'app/components/upload/upload.html',
			controller : 'UploadController as vm'

		}).otherwise({
			redirectTo : '/'
		});
	});
})();