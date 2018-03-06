package org.tayvs.pizza.domain

import org.tayvs.pizza.domain.Component.PizzaBase

case class Pizza(size: Int, ingredients: List[Component] = Nil) {
  
  def addIngredient(ingredient: Component): Pizza = this.copy(ingredients = ingredients :+ ingredient)
  def removeIngredient(ingredient: Component): Pizza = this.copy(ingredients = ingredients.filterNot(ingredient == _))
  def price: Int = ingredients.foldLeft(0)((acc, component) => acc + component.price)
}

object Pizza {
  def apply(base: PizzaBase, ingredients: List[Component]): Pizza = new Pizza(base.size, ingredients :+ base)
  def apply(base: PizzaBase): Pizza = new Pizza(base.size, base :: Nil)
}
