// call rest service from CartResource

var skillsApp = angular.module("skillsApp", []);

skillsApp.controller('skillsCtrl', function($scope, $http) {
	$scope.refreshSkillsGroup = function() {
		$http.get('/rest/skills/' + $scope.skillsGroupId).success(
				function _successGet(data) {
					$scope.skillsGroup = data;
				});
	};

	$scope.initSkillsGroupId = function(skillsGroupId) {
		$scope.skillsGroupId = skillsGroupId;
		$http.get('/rest/skills/' + $scope.skillsGroupId).success(
				function _successInit(data) {
					$scope.skillsGroup = data;
				});
	};

	$scope.addToSkillsGroup = function(skillsGroupId) {
		$http.put('/rest/skillsGroup/add/' + skillsGroupId).success(
				function _successPut() {
					alert("Skills Successfully added to the SkillsGroup!");
				}).error(function _errorPut() {
		});
	};

});