'use strict';

var cart = angular.module('cartDetail', ['ngRoute']);

cart.component('cartDetail', {
    templateUrl: "src/cart-detail/cart-detail.template.html",
    controller: function cartController($http, $scope, $rootScope) {
        this.cartCount = 0;
        var self = this;
        $http.get('http://localhost:3000/shopping-cart').then(function (response) {
            self.cartItems = response.data;
            var item;
            self.totalPrice = 0;
            for (item in self.cartItems) {
                self.totalPrice = +self.totalPrice + +self.cartItems[item].price;
                console.log(self.totalPrice);
                self.cartCount += self.cartItems[item].count;
            }
        });


        $scope.deleteAll = function () {

            var item = 1;
            for (item in self.cartItems) {
                console.log(item.id);
                $http.delete('http://localhost:3000/shopping-cart/' + self.cartItems[item].id, item).then(function (response) {
                    console.log("successfull");
                })
            }
            //  $scope.cartCount = 0;
            window.location.reload();
        }

    }
});
