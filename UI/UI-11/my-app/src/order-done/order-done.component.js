'use strict';

var orderSuccess = angular.module('orderDone', ['ngRoute']);

orderSuccess.component('orderDone',{
        templateUrl:"src/order-done/order-done.template.html",
        controller:function OrderSuccessController($http){
            this.cartCount = 0;

            $http.get('http://localhost:3000/shopping-cart').then(function(response){
                self.items = response.data;
                var item;
                for(item in self.items){
                    self.cartCount += self.items[item].count;
                }
            });
        }
    });