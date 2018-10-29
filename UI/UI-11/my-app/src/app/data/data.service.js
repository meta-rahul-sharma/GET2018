/**
 * DATA SERVICE TO FETCH, SAVE AND UPDATE OPERATIONS
 */

angular.module("app").factory('User', ["$http", function ($http) {

    var itemListPromise = null;
    var itemList = {};
    var lastId = 0;

    /**
     * Populates the itemlist and caches
     * @return list of items
     */
    var init = function () {
        return $http.get("http://localhost:3000/data").then(function (response) {
            response.data.forEach(function (item) {
                dataList[item.id] = item;
                lastId = Math.max(lastId, item.id);
            });
            return itemList;
        });
    }

    /**
     * Fetches all items from the server
     * @returns object having properties as id of items
     */
    var getAll = function () {
        if (!itemListPromise)
            itemListPromise = init();
        return itemListPromise;
    }

    /**
     * Updates given item
     * @param  item to be updated
     */
    var update = async function (item) {
        return $http({
        method:'PUT',
        url:'http://localhost:3000/item/'+item.id,
        data:item,
        headers: { 'Content-Type': 'application/json' }
        }).then(function successCallback(response){
            itemList[item.id] = item;
            return;
        });
    }

    /**
     * Saves given item
     * @param  item to be saved
     */
    var save = async function (item) {
        return $http({
        method:'POST',
        url:'http://localhost:3000/item/',
        data:item,
        headers: { 'Content-Type': 'application/json' }
        }).then(function successCallback(response){
            itemList[item.id] = item;
            return;
        });
    }

    return {             
        "getAll": getAll,
        "save": save,
        "update": update
    }
}]);

