package com.action.designpatternsandsolidpriciples.DesignPatterns.Structural


//Define the Interface
interface Coffee {
    fun cost(): Double
    fun description(): String
}

//Create a Concrete Component (Base Coffee Class)
class SimpleCoffee : Coffee {
    override fun cost() = 5.0
    override fun description() = "Simple Coffee"
}

//Create an Abstract Decorator Class
abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun cost() = coffee.cost()  // Delegating cost calculation
    override fun description() = coffee.description()  // Delegating description
}

//Create Concrete Decorators
class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 2.0
    override fun description() = super.description() + ", Milk"
}

class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 1.0
    override fun description() = super.description() + ", Sugar"
}

class CaramelDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 3.0
    override fun description() = super.description() + ", Caramel"
}

//Use the Decorators
fun main() {
    val coffee: Coffee = SimpleCoffee()
    println("${coffee.description()} -> Cost: \$${coffee.cost()}")

    val milkCoffee = MilkDecorator(coffee)
    println("${milkCoffee.description()} -> Cost: \$${milkCoffee.cost()}")

    val sugarMilkCoffee = SugarDecorator(milkCoffee)
    println("${sugarMilkCoffee.description()} -> Cost: \$${sugarMilkCoffee.cost()}")

    val caramelSugarMilkCoffee = CaramelDecorator(sugarMilkCoffee)
    println("${caramelSugarMilkCoffee.description()} -> Cost: \$${caramelSugarMilkCoffee.cost()}")
}

/*
Component Interface (Coffee): Defines the common structure.
Concrete Component (SimpleCoffee): Provides the base implementation.
Abstract Decorator (CoffeeDecorator): Delegates methods to the base component.
Concrete Decorators (MilkDecorator, SugarDecorator, CaramelDecorator): Extend behavior dynamically.

Flexible: New features can be added without modifying existing classes.
Reusable: You can mix and match decorators dynamically.
Extensible: Easily extend the system by adding new decorators.
 */