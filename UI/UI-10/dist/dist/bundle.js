/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./src/app.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./src/app.js":
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("__webpack_require__(/*! ./app.module.js */ \"./src/app.module.js\");\r\n__webpack_require__(/*! ./user/userData.service.js */ \"./src/user/userData.service.js\");\r\n\r\n(function () {\r\n    \"use strict\";\r\n    var app = angular.module(\"app\");\r\n    app.controller(\"UserController\", [\"$scope\", \"User\", function ($scope, User) {\r\n\r\n        /**\r\n         * Updates the userlist in the view\r\n         */\r\n        $scope.refresh = function () {\r\n            User.getAll().then(function (data) {\r\n                $scope.users = [];\r\n                for (var property in data)\r\n                    $scope.users.push(data[property]);\r\n            });\r\n        };\r\n\r\n        /**\r\n         * Updates the user details and refreshes\r\n         * the userlist\r\n         * @Param User to be updated\r\n         */\r\n        $scope.update = function (user) {\r\n            User.update(user).then(function (data) {\r\n                $scope.refresh();\r\n                $(\"#edit-\" + user.id).modal('hide');\r\n            });\r\n        };\r\n\r\n\r\n        /**\r\n         * Saves the user details and refreshes\r\n         * the userlist\r\n         * @Param User to be saved\r\n         */\r\n        $scope.save = function (user) {\r\n            User.save(user).then(function (data) {\r\n                $scope.refresh();\r\n                $(\"#addUser\").modal('hide');\r\n                $scope.userToAdd = null;\r\n            });\r\n        };\r\n\r\n        $scope.refresh();\r\n    }]);\r\n\r\n})();\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9zcmMvYXBwLmpzLmpzIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vLy4vc3JjL2FwcC5qcz8xMTEyIl0sInNvdXJjZXNDb250ZW50IjpbInJlcXVpcmUoXCIuL2FwcC5tb2R1bGUuanNcIik7XHJcbnJlcXVpcmUoXCIuL3VzZXIvdXNlckRhdGEuc2VydmljZS5qc1wiKTtcclxuXHJcbihmdW5jdGlvbiAoKSB7XHJcbiAgICBcInVzZSBzdHJpY3RcIjtcclxuICAgIHZhciBhcHAgPSBhbmd1bGFyLm1vZHVsZShcImFwcFwiKTtcclxuICAgIGFwcC5jb250cm9sbGVyKFwiVXNlckNvbnRyb2xsZXJcIiwgW1wiJHNjb3BlXCIsIFwiVXNlclwiLCBmdW5jdGlvbiAoJHNjb3BlLCBVc2VyKSB7XHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIFVwZGF0ZXMgdGhlIHVzZXJsaXN0IGluIHRoZSB2aWV3XHJcbiAgICAgICAgICovXHJcbiAgICAgICAgJHNjb3BlLnJlZnJlc2ggPSBmdW5jdGlvbiAoKSB7XHJcbiAgICAgICAgICAgIFVzZXIuZ2V0QWxsKCkudGhlbihmdW5jdGlvbiAoZGF0YSkge1xyXG4gICAgICAgICAgICAgICAgJHNjb3BlLnVzZXJzID0gW107XHJcbiAgICAgICAgICAgICAgICBmb3IgKHZhciBwcm9wZXJ0eSBpbiBkYXRhKVxyXG4gICAgICAgICAgICAgICAgICAgICRzY29wZS51c2Vycy5wdXNoKGRhdGFbcHJvcGVydHldKTtcclxuICAgICAgICAgICAgfSk7XHJcbiAgICAgICAgfTtcclxuXHJcbiAgICAgICAgLyoqXHJcbiAgICAgICAgICogVXBkYXRlcyB0aGUgdXNlciBkZXRhaWxzIGFuZCByZWZyZXNoZXNcclxuICAgICAgICAgKiB0aGUgdXNlcmxpc3RcclxuICAgICAgICAgKiBAUGFyYW0gVXNlciB0byBiZSB1cGRhdGVkXHJcbiAgICAgICAgICovXHJcbiAgICAgICAgJHNjb3BlLnVwZGF0ZSA9IGZ1bmN0aW9uICh1c2VyKSB7XHJcbiAgICAgICAgICAgIFVzZXIudXBkYXRlKHVzZXIpLnRoZW4oZnVuY3Rpb24gKGRhdGEpIHtcclxuICAgICAgICAgICAgICAgICRzY29wZS5yZWZyZXNoKCk7XHJcbiAgICAgICAgICAgICAgICAkKFwiI2VkaXQtXCIgKyB1c2VyLmlkKS5tb2RhbCgnaGlkZScpO1xyXG4gICAgICAgICAgICB9KTtcclxuICAgICAgICB9O1xyXG5cclxuXHJcbiAgICAgICAgLyoqXHJcbiAgICAgICAgICogU2F2ZXMgdGhlIHVzZXIgZGV0YWlscyBhbmQgcmVmcmVzaGVzXHJcbiAgICAgICAgICogdGhlIHVzZXJsaXN0XHJcbiAgICAgICAgICogQFBhcmFtIFVzZXIgdG8gYmUgc2F2ZWRcclxuICAgICAgICAgKi9cclxuICAgICAgICAkc2NvcGUuc2F2ZSA9IGZ1bmN0aW9uICh1c2VyKSB7XHJcbiAgICAgICAgICAgIFVzZXIuc2F2ZSh1c2VyKS50aGVuKGZ1bmN0aW9uIChkYXRhKSB7XHJcbiAgICAgICAgICAgICAgICAkc2NvcGUucmVmcmVzaCgpO1xyXG4gICAgICAgICAgICAgICAgJChcIiNhZGRVc2VyXCIpLm1vZGFsKCdoaWRlJyk7XHJcbiAgICAgICAgICAgICAgICAkc2NvcGUudXNlclRvQWRkID0gbnVsbDtcclxuICAgICAgICAgICAgfSk7XHJcbiAgICAgICAgfTtcclxuXHJcbiAgICAgICAgJHNjb3BlLnJlZnJlc2goKTtcclxuICAgIH1dKTtcclxuXHJcbn0pKCk7XHJcbiJdLCJtYXBwaW5ncyI6IkFBQUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7Iiwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./src/app.js\n");

/***/ }),

/***/ "./src/app.module.js":
/*!***************************!*\
  !*** ./src/app.module.js ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("angular.module(\"app\", []);//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9zcmMvYXBwLm1vZHVsZS5qcy5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9hcHAubW9kdWxlLmpzP2ExNzQiXSwic291cmNlc0NvbnRlbnQiOlsiYW5ndWxhci5tb2R1bGUoXCJhcHBcIiwgW10pOyJdLCJtYXBwaW5ncyI6IkFBQUEiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./src/app.module.js\n");

/***/ }),

/***/ "./src/user/userData.service.js":
/*!**************************************!*\
  !*** ./src/user/userData.service.js ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("__webpack_require__(/*! ../app.module.js */ \"./src/app.module.js\");\r\n\r\n/**\r\n * USER SERVICE TO FETCH, SAVE AND UPDATE OPERATIONS\r\n */\r\n(function () {\r\n    angular.module(\"UserManagement\").factory('User', [\"$http\", function ($http) {\r\n\r\n        var userListPromise = null;\r\n        var userList = {};\r\n        var lastId = 0;\r\n\r\n        /**\r\n         * Populates the userlist and caches\r\n         * @return list of users\r\n         */\r\n        var init = function () {\r\n            return $http.get(\"src/user/userData.json\").then(function (response) {\r\n                response.data.forEach(function (user) {\r\n                    userList[user.id] = user;\r\n                    lastId = Math.max(lastId, user.id);\r\n                });\r\n                return userList;\r\n            });\r\n        }\r\n\r\n        /**\r\n         * Fetches all users from the server\r\n         * @returns object having properties as id of users\r\n         */\r\n        var getAll = function () {\r\n            if (!userListPromise)\r\n                userListPromise = init();\r\n            return userListPromise;\r\n        }\r\n\r\n        /**\r\n         * Updates given user\r\n         * @param  user to be updated\r\n         */\r\n        var update = async function (user) {\r\n            console.log(user);\r\n            userList[user.id] = user;\r\n            return;\r\n        }\r\n\r\n        /**\r\n         * Saves given user\r\n         * @param  user to be saved\r\n         */\r\n        var save = async function (user) {\r\n            user.id = ++lastId;\r\n            userList[user.id] = user;\r\n            return;\r\n        }\r\n\r\n        return {             \r\n            \"getAll\": getAll,\r\n            \"save\": save,\r\n            \"update\": update\r\n        }\r\n    }]);\r\n}());\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9zcmMvdXNlci91c2VyRGF0YS5zZXJ2aWNlLmpzLmpzIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vLy4vc3JjL3VzZXIvdXNlckRhdGEuc2VydmljZS5qcz9iZGJmIl0sInNvdXJjZXNDb250ZW50IjpbInJlcXVpcmUoXCIuLi9hcHAubW9kdWxlLmpzXCIpO1xyXG5cclxuLyoqXHJcbiAqIFVTRVIgU0VSVklDRSBUTyBGRVRDSCwgU0FWRSBBTkQgVVBEQVRFIE9QRVJBVElPTlNcclxuICovXHJcbihmdW5jdGlvbiAoKSB7XHJcbiAgICBhbmd1bGFyLm1vZHVsZShcIlVzZXJNYW5hZ2VtZW50XCIpLmZhY3RvcnkoJ1VzZXInLCBbXCIkaHR0cFwiLCBmdW5jdGlvbiAoJGh0dHApIHtcclxuXHJcbiAgICAgICAgdmFyIHVzZXJMaXN0UHJvbWlzZSA9IG51bGw7XHJcbiAgICAgICAgdmFyIHVzZXJMaXN0ID0ge307XHJcbiAgICAgICAgdmFyIGxhc3RJZCA9IDA7XHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIFBvcHVsYXRlcyB0aGUgdXNlcmxpc3QgYW5kIGNhY2hlc1xyXG4gICAgICAgICAqIEByZXR1cm4gbGlzdCBvZiB1c2Vyc1xyXG4gICAgICAgICAqL1xyXG4gICAgICAgIHZhciBpbml0ID0gZnVuY3Rpb24gKCkge1xyXG4gICAgICAgICAgICByZXR1cm4gJGh0dHAuZ2V0KFwic3JjL3VzZXIvdXNlckRhdGEuanNvblwiKS50aGVuKGZ1bmN0aW9uIChyZXNwb25zZSkge1xyXG4gICAgICAgICAgICAgICAgcmVzcG9uc2UuZGF0YS5mb3JFYWNoKGZ1bmN0aW9uICh1c2VyKSB7XHJcbiAgICAgICAgICAgICAgICAgICAgdXNlckxpc3RbdXNlci5pZF0gPSB1c2VyO1xyXG4gICAgICAgICAgICAgICAgICAgIGxhc3RJZCA9IE1hdGgubWF4KGxhc3RJZCwgdXNlci5pZCk7XHJcbiAgICAgICAgICAgICAgICB9KTtcclxuICAgICAgICAgICAgICAgIHJldHVybiB1c2VyTGlzdDtcclxuICAgICAgICAgICAgfSk7XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICAvKipcclxuICAgICAgICAgKiBGZXRjaGVzIGFsbCB1c2VycyBmcm9tIHRoZSBzZXJ2ZXJcclxuICAgICAgICAgKiBAcmV0dXJucyBvYmplY3QgaGF2aW5nIHByb3BlcnRpZXMgYXMgaWQgb2YgdXNlcnNcclxuICAgICAgICAgKi9cclxuICAgICAgICB2YXIgZ2V0QWxsID0gZnVuY3Rpb24gKCkge1xyXG4gICAgICAgICAgICBpZiAoIXVzZXJMaXN0UHJvbWlzZSlcclxuICAgICAgICAgICAgICAgIHVzZXJMaXN0UHJvbWlzZSA9IGluaXQoKTtcclxuICAgICAgICAgICAgcmV0dXJuIHVzZXJMaXN0UHJvbWlzZTtcclxuICAgICAgICB9XHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIFVwZGF0ZXMgZ2l2ZW4gdXNlclxyXG4gICAgICAgICAqIEBwYXJhbSAgdXNlciB0byBiZSB1cGRhdGVkXHJcbiAgICAgICAgICovXHJcbiAgICAgICAgdmFyIHVwZGF0ZSA9IGFzeW5jIGZ1bmN0aW9uICh1c2VyKSB7XHJcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKHVzZXIpO1xyXG4gICAgICAgICAgICB1c2VyTGlzdFt1c2VyLmlkXSA9IHVzZXI7XHJcbiAgICAgICAgICAgIHJldHVybjtcclxuICAgICAgICB9XHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIFNhdmVzIGdpdmVuIHVzZXJcclxuICAgICAgICAgKiBAcGFyYW0gIHVzZXIgdG8gYmUgc2F2ZWRcclxuICAgICAgICAgKi9cclxuICAgICAgICB2YXIgc2F2ZSA9IGFzeW5jIGZ1bmN0aW9uICh1c2VyKSB7XHJcbiAgICAgICAgICAgIHVzZXIuaWQgPSArK2xhc3RJZDtcclxuICAgICAgICAgICAgdXNlckxpc3RbdXNlci5pZF0gPSB1c2VyO1xyXG4gICAgICAgICAgICByZXR1cm47XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICByZXR1cm4geyAgICAgICAgICAgICBcclxuICAgICAgICAgICAgXCJnZXRBbGxcIjogZ2V0QWxsLFxyXG4gICAgICAgICAgICBcInNhdmVcIjogc2F2ZSxcclxuICAgICAgICAgICAgXCJ1cGRhdGVcIjogdXBkYXRlXHJcbiAgICAgICAgfVxyXG4gICAgfV0pO1xyXG59KCkpO1xyXG4iXSwibWFwcGluZ3MiOiJBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./src/user/userData.service.js\n");

/***/ })

/******/ });