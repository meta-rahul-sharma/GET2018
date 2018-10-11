require("../app.module.js");

/**
 * USER SERVICE TO FETCH, SAVE AND UPDATE OPERATIONS
 */
(function () {
    angular.module("app").factory('User', ["$http", function ($http) {

        var userListPromise = null;
        var userList = {};
        var lastId = 0;

        /**
         * Populates the userlist and caches
         * @return list of users
         */
        var init = function () {
            return $http.get("src/user/userData.json").then(function (response) {
                response.data.forEach(function (user) {
                    userList[user.id] = user;
                    lastId = Math.max(lastId, user.id);
                });
                return userList;
            });
        }

        /**
         * Fetches all users from the server
         * @returns object having properties as id of users
         */
        var getAll = function () {
            if (!userListPromise)
                userListPromise = init();
            return userListPromise;
        }

        /**
         * Updates given user
         * @param  user to be updated
         */
        var update = async function (user) {
            console.log(user);
            userList[user.id] = user;
            return;
        }

        /**
         * Saves given user
         * @param  user to be saved
         */
        var save = async function (user) {
            user.id = ++lastId;
            userList[user.id] = user;
            return;
        }

        return {             
            "getAll": getAll,
            "save": save,
            "update": update
        }
    }]);
}());
