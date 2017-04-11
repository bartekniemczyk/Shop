/**
 * Created by Bartek on 10.04.2017.
 */
var cartApp = angular.module('cartApp', []);
cartApp.controller('cartCtrl', function ($scope, $http) {
    $scope.refreshCart = function (cartId) {
        $http.get('/dao/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };
    $scope.clearCart = function () {
        $http.delete('/dao/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));
    };
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };
    $scope.addToCart = function (productId) {
        $http.put('/dao/cart/add/' + productId).success(function (data) {
            $scope.refreshCart($http.get('/dao/cart/get/cartId'));
            alert("Produkt dodany do koszyka!");
        });
    };
    $scope.removeFromCart = function (productId) {
        $http.put('/dao/cart/remove/' + productId).success(function (data) {
            $scope.refreshCart($http.get('/dao/cart/get/cartId'));
        });
    };
});
