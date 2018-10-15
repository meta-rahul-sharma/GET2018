require("./app.module.js");
require("./user/userData.service.js");

(function () {
    "use strict";
    var myApp = angular.module("app");
    myApp.controller("UserController", ["$scope", "User", function ($scope, User) {

        /**
         * Updates the userlist in the view
         */
        $scope.refresh = function () {
            User.getAll().then(function (data) {
                $scope.users = [];
                for (var property in data)
                    $scope.users.push(data[property]);
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
