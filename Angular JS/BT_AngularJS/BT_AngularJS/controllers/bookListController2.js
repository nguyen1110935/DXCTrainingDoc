app
    .constant("categoryActiveClass","btn-primary")
    .controller('bookCtrl', function($scope, $filter, categoryActiveClass, cart){ 
    var selectedCategory = null; 
    $scope.selectCategory = function(newCategory){
        selectedCategory = newCategory;
    } 
    $scope.categoryFilterFn = function(book){
        return selectedCategory == null || book.category == selectedCategory; 
    }
    $scope.getCategoryCLass = function(category){
        return selectedCategory == category ? categoryActiveClass : ""; 
    }
    $scope.addBookToCart = function(book){
        cart.addBook(book.id, book.name, book.price);
    }
}); 
