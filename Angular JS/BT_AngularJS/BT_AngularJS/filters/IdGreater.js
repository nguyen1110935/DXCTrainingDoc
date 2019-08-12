myApp.filter("IdGreater", function () {
    return function(input, value) {
        let filteredData = [];
        if (input != null && input.length > 0) {
            //for (let i = 0; i < input.length; i++) {
            //    if (input[i].id > value) {
            //        filteredData.push(input[i]);
            //    }
            //}
            angular.forEach(input, function(item) {
                if (item.id > value) {
                    filteredData.push(item);    
                }
            });
        }
        
        return filteredData;
    };
});
