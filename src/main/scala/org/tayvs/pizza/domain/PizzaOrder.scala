package org.tayvs.pizza.domain

import org.tayvs.pizza.domain.Component.PizzaBase

case class PizzaOrder(componentsRepository: ComponentsRepository, id: String, products: List[Pizza] = Nil) {
  
  def price: Int = products.foldLeft(0)(_ + _.price)
  
  def addPizza(pizza: Pizza): PizzaOrder = this.copy(products = products :+ pizza)
  def createPizza(pizzaBase: PizzaBase): PizzaOrder = this.copy(products = products :+ Pizza(pizzaBase))
  def updatePizza(pizzaIndx: Int, pizza: Pizza): PizzaOrder = this.copy(products = products.updated(pizzaIndx, pizza))
  def updatePizza(pizzaIndx: Int, updateFunc: Pizza => Pizza): PizzaOrder =
    this.copy(products = products.updated(pizzaIndx, updateFunc(products(pizzaIndx))))
  
  def addPizzaComponent(pizzaIndx: Int, component: Component): PizzaOrder =
    updatePizza(pizzaIndx, _.addIngredient(component))
  def removePizzaComponent(pizzaIndx: Int, component: Component): PizzaOrder =
    updatePizza(pizzaIndx, _.removeIngredient(component))
  
}
