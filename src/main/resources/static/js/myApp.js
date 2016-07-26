var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope) {
	$scope.firstName = "John";
	$scope.lastName = "DoeCtrl";
	$scope.names = ['Jani', 'Hege', 'Kai'];
});

app.directive("w3TestDirective", function () {
	return {
		restrict: "EACM",
		template: "<h3>Made by a directive!</h3>"
	};
});
