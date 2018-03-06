package org.tayvs.pizza.domain

trait Component {
  val name: String
  val price: Int
}
object Component {
  case class PizzaBase(size: Int, name: String, price: Int) extends Component
  case class Ingredient(amount: Int, unit: String, name: String, price: Int) extends Component
}


