var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope) {
	$scope.firstName = "John";
	$scope.lastName = "DoeCtrl";
	$scope.fullName = function () {
		return $scope.firstName + " " + $scope.lastName;
	};
	$scope.names = ['Jani', 'Hege', 'Kai'];
});

app.directive("w3TestDirective", function () {
	return {
		restrict: "EACM",
		template: "<h3>Made by a directive!</h3>"
	};
});

app.filter('myFormat', function () {
	return function (x) {
		var i, c, txt = "";
		for (i = 0; i < x.length; i++) {
			c = x[i];
			if (i % 2 == 0) {
				c = c.toUpperCase();
			}
			txt += c;
		}
		return txt;
	};
});