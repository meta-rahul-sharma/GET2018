var myApp = angular.module("app", ["ngRoute", 'cartDetail', 'shoppingDetail', 'orderDone']);


myApp.config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider
        .when("/", {
            templateUrl : "src/pages/home.html",
            controller: "itemController"
        })
        .when("/shopping-cart", {
            template: '<cart-detail></cart-detail>'
        })
        .when("/shopping-address", {
            template: '<shopping-detail></shopping-detail>'
        })
        .when("/category/:categoryName", {
            templateUrl : "src/pages/home.html",
            controller: "itemController"
        })
        .when("/orders", {
            template: '<order-done></order-done>'
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
    });
    
    this.cartCount = 0;
    var self = this;
    $http.get('http://localhost:3000/shopping-cart').then(function (response) {
        self.cartItems = response.data;
        var item;
        for (item in self.cartItems) {
            self.cartCount += self.cartItems[item].count;
        }
        $rootScope.totalCartCount = self.cartCount;
    });
                                                 
    $scope.addCart = function(item) {
        $http.get('http://localhost:3000/shopping-cart/' + item.id).then(function successCallback(response){
            response.data.count += 1;
            console.log(response.data.count);
            response.data.price = response.data.count * item.price;
            console.log(response.data.price);
            $http({
                method: 'PUT',
                url:'http://localhost:3000/shopping-cart/' + item.id,
                data: response.data,
                dataType:'json'
            });
            window.location.reload();
        },function errorCallback(response){

            var cartData = {
                "id":item.id,
                "item":item.item,
                "price":item.price,
                "imagePath":item.imagePath,
                "count":1
            }

            $http({
                method: 'POST',
                url:'http://localhost:3000/shopping-cart/',
                data: cartData,
                dataType:'json'
            })
            window.location.reload();
        });
    }
});