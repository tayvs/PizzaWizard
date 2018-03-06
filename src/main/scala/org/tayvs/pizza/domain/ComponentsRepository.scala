package org.tayvs.pizza.domain

trait ComponentsRepository {
  
  def isAvailable(component: Component): Boolean
  def registerComponent(component: Component): Boolean
  def releaseComponent(component: Component): Boolean
  
}
