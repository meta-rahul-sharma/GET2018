var myApp = angular.module("app", ["ngRoute"]);
myApp.config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider
        .when("/", {
            templateUrl : "src/pages/home.html",
            controller: "itemController"
        })
        .when("/shopping-cart", {
            templateUrl : "src/pages/cart.html"
        })
        .when("/check-out", {
            templateUrl : "src/pages/checkout.html"
        })
        .when("/category/:categoryName", {
            templateUrl : "src/pages/home.html",
            controller: "itemController"
        })
        .otherwise({
            redirectTo: '/'   
        });
}]);
    
myApp.controller("itemController", function ($scope, $http, $rootScope, $routeParams) {

    $scope.categoryName = $routeParams.categoryName;
    console.log($scope.categoryName);
    /**
     * Updates the userlist in the view
     */
    $http.get("http://localhost:3000/data").then(function (response) {
        $scope.items = response.data;
    }
)});

