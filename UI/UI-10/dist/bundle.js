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

eval("__webpack_require__(/*! ./app.module.js */ \"./src/app.module.js\");\r\n__webpack_require__(/*! ./user/userData.service.js */ \"./src/user/userData.service.js\");\r\n\r\n(function () {\r\n    \"use strict\";\r\n    var myApp = angular.module(\"app\");\r\n    myApp.controller(\"UserController\", [\"$scope\", \"User\", function ($scope, User) {\r\n\r\n        /**\r\n         * Updates the userlist in the view\r\n         */\r\n        $scope.refresh = function () {\r\n            User.getAll().then(function (data) {\r\n                $scope.users = [];\r\n                for (var property in data)\r\n                    $scope.users.push(data[property]);\r\n            });\r\n        };\r\n\r\n        /**\r\n         * Updates the user details and refreshes\r\n         * the userlist\r\n         * @Param User to be updated\r\n         */\r\n        $scope.update = function (user) {\r\n            User.update(user).then(function (data) {\r\n                $scope.refresh();\r\n                $(\"#edit-\" + user.id).modal('hide');\r\n            });\r\n        };\r\n\r\n\r\n        /**\r\n         * Saves the user details and refreshes\r\n         * the userlist\r\n         * @Param User to be saved\r\n         */\r\n        $scope.save = function (user) {\r\n            User.save(user).then(function (data) {\r\n                $scope.refresh();\r\n                $(\"#addUser\").modal('hide');\r\n                $scope.userToAdd = null;\r\n            });\r\n        };\r\n\r\n        $scope.refresh();\r\n    }]);\r\n\r\n})();\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9zcmMvYXBwLmpzLmpzIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vLy4vc3JjL2FwcC5qcz8xMTEyIl0sInNvdXJjZXNDb250ZW50IjpbInJlcXVpcmUoXCIuL2FwcC5tb2R1bGUuanNcIik7XHJcbnJlcXVpcmUoXCIuL3VzZXIvdXNlckRhdGEuc2VydmljZS5qc1wiKTtcclxuXHJcbihmdW5jdGlvbiAoKSB7XHJcbiAgICBcInVzZSBzdHJpY3RcIjtcclxuICAgIHZhciBteUFwcCA9IGFuZ3VsYXIubW9kdWxlKFwiYXBwXCIpO1xyXG4gICAgbXlBcHAuY29udHJvbGxlcihcIlVzZXJDb250cm9sbGVyXCIsIFtcIiRzY29wZVwiLCBcIlVzZXJcIiwgZnVuY3Rpb24gKCRzY29wZSwgVXNlcikge1xyXG5cclxuICAgICAgICAvKipcclxuICAgICAgICAgKiBVcGRhdGVzIHRoZSB1c2VybGlzdCBpbiB0aGUgdmlld1xyXG4gICAgICAgICAqL1xyXG4gICAgICAgICRzY29wZS5yZWZyZXNoID0gZnVuY3Rpb24gKCkge1xyXG4gICAgICAgICAgICBVc2VyLmdldEFsbCgpLnRoZW4oZnVuY3Rpb24gKGRhdGEpIHtcclxuICAgICAgICAgICAgICAgICRzY29wZS51c2VycyA9IFtdO1xyXG4gICAgICAgICAgICAgICAgZm9yICh2YXIgcHJvcGVydHkgaW4gZGF0YSlcclxuICAgICAgICAgICAgICAgICAgICAkc2NvcGUudXNlcnMucHVzaChkYXRhW3Byb3BlcnR5XSk7XHJcbiAgICAgICAgICAgIH0pO1xyXG4gICAgICAgIH07XHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIFVwZGF0ZXMgdGhlIHVzZXIgZGV0YWlscyBhbmQgcmVmcmVzaGVzXHJcbiAgICAgICAgICogdGhlIHVzZXJsaXN0XHJcbiAgICAgICAgICogQFBhcmFtIFVzZXIgdG8gYmUgdXBkYXRlZFxyXG4gICAgICAgICAqL1xyXG4gICAgICAgICRzY29wZS51cGRhdGUgPSBmdW5jdGlvbiAodXNlcikge1xyXG4gICAgICAgICAgICBVc2VyLnVwZGF0ZSh1c2VyKS50aGVuKGZ1bmN0aW9uIChkYXRhKSB7XHJcbiAgICAgICAgICAgICAgICAkc2NvcGUucmVmcmVzaCgpO1xyXG4gICAgICAgICAgICAgICAgJChcIiNlZGl0LVwiICsgdXNlci5pZCkubW9kYWwoJ2hpZGUnKTtcclxuICAgICAgICAgICAgfSk7XHJcbiAgICAgICAgfTtcclxuXHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIFNhdmVzIHRoZSB1c2VyIGRldGFpbHMgYW5kIHJlZnJlc2hlc1xyXG4gICAgICAgICAqIHRoZSB1c2VybGlzdFxyXG4gICAgICAgICAqIEBQYXJhbSBVc2VyIHRvIGJlIHNhdmVkXHJcbiAgICAgICAgICovXHJcbiAgICAgICAgJHNjb3BlLnNhdmUgPSBmdW5jdGlvbiAodXNlcikge1xyXG4gICAgICAgICAgICBVc2VyLnNhdmUodXNlcikudGhlbihmdW5jdGlvbiAoZGF0YSkge1xyXG4gICAgICAgICAgICAgICAgJHNjb3BlLnJlZnJlc2goKTtcclxuICAgICAgICAgICAgICAgICQoXCIjYWRkVXNlclwiKS5tb2RhbCgnaGlkZScpO1xyXG4gICAgICAgICAgICAgICAgJHNjb3BlLnVzZXJUb0FkZCA9IG51bGw7XHJcbiAgICAgICAgICAgIH0pO1xyXG4gICAgICAgIH07XHJcblxyXG4gICAgICAgICRzY29wZS5yZWZyZXNoKCk7XHJcbiAgICB9XSk7XHJcblxyXG59KSgpO1xyXG4iXSwibWFwcGluZ3MiOiJBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOyIsInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///./src/app.js\n");

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

eval("__webpack_require__(/*! ../app.module.js */ \"./src/app.module.js\");\r\n\r\n/**\r\n * USER SERVICE TO FETCH, SAVE AND UPDATE OPERATIONS\r\n */\r\n(function () {\r\n    angular.module(\"app\").factory('User', [\"$http\", function ($http) {\r\n\r\n        var userListPromise = null;\r\n        var userList = {};\r\n        var lastId = 0;\r\n\r\n        /**\r\n         * Populates the userlist and caches\r\n         * @return list of users\r\n         */\r\n        var init = function () {\r\n            return $http.get(\"http://localhost:3000/user\").then(function (response) {\r\n                response.data.forEach(function (user) {\r\n                    userList[user.id] = user;\r\n                    lastId = Math.max(lastId, user.id);\r\n                });\r\n                return userList;\r\n            });\r\n        }\r\n\r\n        /**\r\n         * Fetches all users from the server\r\n         * @returns object having properties as id of users\r\n         */\r\n        var getAll = function () {\r\n            if (!userListPromise)\r\n                userListPromise = init();\r\n            return userListPromise;\r\n        }\r\n\r\n        /**\r\n         * Updates given user\r\n         * @param  user to be updated\r\n         */\r\n        var update = async function (user) {\r\n            return $http({\r\n            method:'PUT',\r\n            url:'http://localhost:3000/user/'+user.id,\r\n            data:user,\r\n            headers: { 'Content-Type': 'application/json' }\r\n            }).then(function successCallback(response){\r\n                userList[user.id] = user;\r\n                return;\r\n            });\r\n        }\r\n\r\n        /**\r\n         * Saves given user\r\n         * @param  user to be saved\r\n         */\r\n        var save = async function (user) {\r\n            return $http({\r\n            method:'POST',\r\n            url:'http://localhost:3000/user/',\r\n            data:user,\r\n            headers: { 'Content-Type': 'application/json' }\r\n            }).then(function successCallback(response){\r\n                userList[user.id] = user;\r\n                return;\r\n            });\r\n        }\r\n\r\n        return {             \r\n            \"getAll\": getAll,\r\n            \"save\": save,\r\n            \"update\": update\r\n        }\r\n    }]);\r\n}());\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9zcmMvdXNlci91c2VyRGF0YS5zZXJ2aWNlLmpzLmpzIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vLy4vc3JjL3VzZXIvdXNlckRhdGEuc2VydmljZS5qcz9iZGJmIl0sInNvdXJjZXNDb250ZW50IjpbInJlcXVpcmUoXCIuLi9hcHAubW9kdWxlLmpzXCIpO1xyXG5cclxuLyoqXHJcbiAqIFVTRVIgU0VSVklDRSBUTyBGRVRDSCwgU0FWRSBBTkQgVVBEQVRFIE9QRVJBVElPTlNcclxuICovXHJcbihmdW5jdGlvbiAoKSB7XHJcbiAgICBhbmd1bGFyLm1vZHVsZShcImFwcFwiKS5mYWN0b3J5KCdVc2VyJywgW1wiJGh0dHBcIiwgZnVuY3Rpb24gKCRodHRwKSB7XHJcblxyXG4gICAgICAgIHZhciB1c2VyTGlzdFByb21pc2UgPSBudWxsO1xyXG4gICAgICAgIHZhciB1c2VyTGlzdCA9IHt9O1xyXG4gICAgICAgIHZhciBsYXN0SWQgPSAwO1xyXG5cclxuICAgICAgICAvKipcclxuICAgICAgICAgKiBQb3B1bGF0ZXMgdGhlIHVzZXJsaXN0IGFuZCBjYWNoZXNcclxuICAgICAgICAgKiBAcmV0dXJuIGxpc3Qgb2YgdXNlcnNcclxuICAgICAgICAgKi9cclxuICAgICAgICB2YXIgaW5pdCA9IGZ1bmN0aW9uICgpIHtcclxuICAgICAgICAgICAgcmV0dXJuICRodHRwLmdldChcImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMC91c2VyXCIpLnRoZW4oZnVuY3Rpb24gKHJlc3BvbnNlKSB7XHJcbiAgICAgICAgICAgICAgICByZXNwb25zZS5kYXRhLmZvckVhY2goZnVuY3Rpb24gKHVzZXIpIHtcclxuICAgICAgICAgICAgICAgICAgICB1c2VyTGlzdFt1c2VyLmlkXSA9IHVzZXI7XHJcbiAgICAgICAgICAgICAgICAgICAgbGFzdElkID0gTWF0aC5tYXgobGFzdElkLCB1c2VyLmlkKTtcclxuICAgICAgICAgICAgICAgIH0pO1xyXG4gICAgICAgICAgICAgICAgcmV0dXJuIHVzZXJMaXN0O1xyXG4gICAgICAgICAgICB9KTtcclxuICAgICAgICB9XHJcblxyXG4gICAgICAgIC8qKlxyXG4gICAgICAgICAqIEZldGNoZXMgYWxsIHVzZXJzIGZyb20gdGhlIHNlcnZlclxyXG4gICAgICAgICAqIEByZXR1cm5zIG9iamVjdCBoYXZpbmcgcHJvcGVydGllcyBhcyBpZCBvZiB1c2Vyc1xyXG4gICAgICAgICAqL1xyXG4gICAgICAgIHZhciBnZXRBbGwgPSBmdW5jdGlvbiAoKSB7XHJcbiAgICAgICAgICAgIGlmICghdXNlckxpc3RQcm9taXNlKVxyXG4gICAgICAgICAgICAgICAgdXNlckxpc3RQcm9taXNlID0gaW5pdCgpO1xyXG4gICAgICAgICAgICByZXR1cm4gdXNlckxpc3RQcm9taXNlO1xyXG4gICAgICAgIH1cclxuXHJcbiAgICAgICAgLyoqXHJcbiAgICAgICAgICogVXBkYXRlcyBnaXZlbiB1c2VyXHJcbiAgICAgICAgICogQHBhcmFtICB1c2VyIHRvIGJlIHVwZGF0ZWRcclxuICAgICAgICAgKi9cclxuICAgICAgICB2YXIgdXBkYXRlID0gYXN5bmMgZnVuY3Rpb24gKHVzZXIpIHtcclxuICAgICAgICAgICAgcmV0dXJuICRodHRwKHtcclxuICAgICAgICAgICAgbWV0aG9kOidQVVQnLFxyXG4gICAgICAgICAgICB1cmw6J2h0dHA6Ly9sb2NhbGhvc3Q6MzAwMC91c2VyLycrdXNlci5pZCxcclxuICAgICAgICAgICAgZGF0YTp1c2VyLFxyXG4gICAgICAgICAgICBoZWFkZXJzOiB7ICdDb250ZW50LVR5cGUnOiAnYXBwbGljYXRpb24vanNvbicgfVxyXG4gICAgICAgICAgICB9KS50aGVuKGZ1bmN0aW9uIHN1Y2Nlc3NDYWxsYmFjayhyZXNwb25zZSl7XHJcbiAgICAgICAgICAgICAgICB1c2VyTGlzdFt1c2VyLmlkXSA9IHVzZXI7XHJcbiAgICAgICAgICAgICAgICByZXR1cm47XHJcbiAgICAgICAgICAgIH0pO1xyXG4gICAgICAgIH1cclxuXHJcbiAgICAgICAgLyoqXHJcbiAgICAgICAgICogU2F2ZXMgZ2l2ZW4gdXNlclxyXG4gICAgICAgICAqIEBwYXJhbSAgdXNlciB0byBiZSBzYXZlZFxyXG4gICAgICAgICAqL1xyXG4gICAgICAgIHZhciBzYXZlID0gYXN5bmMgZnVuY3Rpb24gKHVzZXIpIHtcclxuICAgICAgICAgICAgcmV0dXJuICRodHRwKHtcclxuICAgICAgICAgICAgbWV0aG9kOidQT1NUJyxcclxuICAgICAgICAgICAgdXJsOidodHRwOi8vbG9jYWxob3N0OjMwMDAvdXNlci8nLFxyXG4gICAgICAgICAgICBkYXRhOnVzZXIsXHJcbiAgICAgICAgICAgIGhlYWRlcnM6IHsgJ0NvbnRlbnQtVHlwZSc6ICdhcHBsaWNhdGlvbi9qc29uJyB9XHJcbiAgICAgICAgICAgIH0pLnRoZW4oZnVuY3Rpb24gc3VjY2Vzc0NhbGxiYWNrKHJlc3BvbnNlKXtcclxuICAgICAgICAgICAgICAgIHVzZXJMaXN0W3VzZXIuaWRdID0gdXNlcjtcclxuICAgICAgICAgICAgICAgIHJldHVybjtcclxuICAgICAgICAgICAgfSk7XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICByZXR1cm4geyAgICAgICAgICAgICBcclxuICAgICAgICAgICAgXCJnZXRBbGxcIjogZ2V0QWxsLFxyXG4gICAgICAgICAgICBcInNhdmVcIjogc2F2ZSxcclxuICAgICAgICAgICAgXCJ1cGRhdGVcIjogdXBkYXRlXHJcbiAgICAgICAgfVxyXG4gICAgfV0pO1xyXG59KCkpO1xyXG4iXSwibWFwcGluZ3MiOiJBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./src/user/userData.service.js\n");

/***/ })

/******/ });