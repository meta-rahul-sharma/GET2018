require("./app.module.js");
require("./user/userData.service.js");

(function () {
    "use strict";
    var myApp = angular.module("app", ["ngRoute"]);
        myApp.config(function($routeProvider) {
            $routeProvider
            .when("/", {
                templateUrl : "index.html",
                controller: "mainController"
            })
            .when("/red", {
                templateUrl : "red.htm"
            })
            .when("/green", {
                templateUrl : "green.htm"
            })
            .when("/blue", {
                templateUrl : "blue.htm"
            })
            .otherwise({
                redirectTo: '/'   
            });
        });
    
    myApp.controller("itemController", ["$scope", "User", function ($scope, User) {

        /**
         * Updates the userlist in the view
         */
        $scope.refresh = function () {
            User.getAll().then(function (data) {
                $scope.items = [];
                for (var property in data)
                    $scope.items.push(data[property]);
            });
        };

        /**
         * Updates the user details and refreshes
         * the userlist
         * @Param User to be updated
         */
        $scope.update = function (user) {
            User.update(user).then(function (data) {
                $scope.refresh();
                $("#edit-" + user.id).modal('hide');
            });
        };


        /**
         * Saves the user details and refreshes
         * the userlist
         * @Param User to be saved
         */
        $scope.save = function (user) {
            User.save(user).then(function (data) {
                $scope.refresh();
                $("#addUser").modal('hide');
                $scope.userToAdd = null;
            });
        };

        $scope.refresh();
    }]);

})();
