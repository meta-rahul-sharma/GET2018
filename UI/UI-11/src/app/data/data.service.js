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
            return $http.get("http://localhost:3000/data").then(function (response) {
                response.data.forEach(function (item) {
                    dataList[item.id] = item;
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
            return $http({
            method:'PUT',
            url:'http://localhost:3000/user/'+user.id,
            data:user,
            headers: { 'Content-Type': 'application/json' }
            }).then(function successCallback(response){
                userList[user.id] = user;
                return;
            });
        }

        /**
         * Saves given user
         * @param  user to be saved
         */
        var save = async function (user) {
            return $http({
            method:'POST',
            url:'http://localhost:3000/user/',
            data:user,
            headers: { 'Content-Type': 'application/json' }
            }).then(function successCallback(response){
                userList[user.id] = user;
                return;
            });
        }

        return {             
            "getAll": getAll,
            "save": save,
            "update": update
        }
    }]);
}());
