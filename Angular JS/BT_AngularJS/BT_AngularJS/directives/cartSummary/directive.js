app.directive("cartSummary", function (cart) {
    return {
        restrict: "E", 
        templateUrl: "directives/cartSummary/template.html", 
        controller: function ($scope) {
            var cartData = cart.getBooks(); 
            $scope.total = function () {
                var total = 0; 
                for(var i=0; i<cartData.length; i++){ 
                    total += cartData[i].price * cartData[i].count; 
                } 
                return total; 
            }
            $scope.itemCount = function () { 
                var total = 0; 
                for (var i = 0; i < cartData.length; i++) {
                    total += cartData[i].count; 
                } 
                return total; 
            }
        }
    }
});
