angular.module('app', []).controller('userController', function userController($scope) {
    $scope.users = [
        {name:'rahul sharma', phone:'9214013876', city: 'jaipur'},
        {name:'hello', phone:'9214013876', city: 'jaipur'},
        {name:'ballu', phone:'9214013876', city: 'jaipur'}
    ];
});