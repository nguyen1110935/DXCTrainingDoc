angular.module("cart", []) 
    .factory("cart", function () { 
        var cartData = []; 
        return { 
            addBook: function (id, name, price) {
                var addedToExistingItem = false; 
                for (var i = 0; i < cartData.length; i++) {
                    if (cartData[i].id == id) {
                        cartData[i].count++; 
                        addedToExistingItem = true; 
                        break;
                    }
                } 
                    if (!addedToExistingItem) {
                        cartData.push({ 
                            id: id, 
                            count: 1, 
                            name: name,
                            price: price 
                        });
                    }
                },

                getBooks: function () {
                    return cartData; 
                }
            }
        });
    
