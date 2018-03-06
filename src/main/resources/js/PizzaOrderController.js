angular
    .module('pizzaOrder', [])
    .controller('pizzaOrderController', function () {
        var controller = this;
        controller.name = "name";

        //new pizza
        controller.newPizza = {
            size: 12,
            ingredients: []
        };
        controller.newPizza = function (pizzaBase) {
            return {
                size: pizzaBase.size,
                ingredients: [pizzaBase]
            }
        };

        controller.pizzaBases = [
            {size: 12, name: "12inc pizza base", price: 12},
            {size: 15, name: "12inc pizza base", price: 15},
            {size: 18, name: "12inc pizza base", price: 18}
        ];
        //new pizza

        controller.ingredients = [controller.newPizza(), controller.newPizza()];
        controller.order = [controller.newPizza(), controller.newPizza()];

        controller.addPizza = function () {
            controller.ingredients.concat(controller.newPizza());
        };
    });