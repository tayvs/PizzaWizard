angular
    .module('pizzaOrder', [])
    .controller('pizzaOrderController', function () {
        var controller = this;
        controller.name = "name";

        //new pizza
        controller.pizzaBases = [
            {size: 12, name: "12inc pizza base", price: 12},
            {size: 15, name: "15inc pizza base", price: 15},
            {size: 18, name: "18inc pizza base", price: 18}
        ];

        controller.add12IncPizza = controller.pizzaBases[0];
        controller.add15IncPizza = controller.pizzaBases[1];
        controller.add18IncPizza = controller.pizzaBases[2];
        //new pizza end

        controller.ingredients = [{name: "f", price: 11}, {name: "s", price: 11}, {name: "t", price: 2}];
        controller.order = [];

        controller.addIngredient = function (pizzaIndx, ingrIndx) {
            var newIngr = {
                name: controller.ingredients[ingrIndx].name,
                price: controller.ingredients[ingrIndx].price
            };
            controller.order[pizzaIndx].ingredients.push(newIngr);
        };

        controller.removeIngredient = function (pizzaIndx, ingrIndx) {
            controller.order[pizzaIndx].ingredients.splice(ingrIndx, 1);
        };

        controller.addPizza = function (pizza) {
            var newPizza = {
                size: pizza.size,
                name: pizza.name,
                ingredients: pizza.ingredients || []
            };
            controller.order.push(newPizza);
        };


        //todo
        controller.addPizza(controller.pizzaBases[1]);
    });