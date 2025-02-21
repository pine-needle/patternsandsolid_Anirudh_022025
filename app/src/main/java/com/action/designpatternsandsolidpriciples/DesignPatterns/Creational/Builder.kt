package com.action.designpatternsandsolidpriciples.DesignPatterns.Creational

// Step 1: Define a data class with a private constructor
data class Product private constructor(
    val name: String,
    val description: String?,
    val price: Double,
    val rating: Double?,
    val category: String?
) {
    // Step 2: Define a Builder class inside the Product class
    class Builder {
        private var name: String = ""
        private var description: String? = null
        private var price: Double = 0.0
        private var rating: Double? = null
        private var category: String? = null

        // Builder methods for setting values
        fun setName(name: String) = apply { this.name = name }
        fun setDescription(description: String?) = apply { this.description = description }
        fun setPrice(price: Double) = apply { this.price = price }
        fun setRating(rating: Double?) = apply { this.rating = rating }
        fun setCategory(category: String?) = apply { this.category = category }

        // Build method to create an instance of Product
        fun build(): Product {
            return Product(name, description, price, rating, category)
        }
    }
}

// Usage
fun main() {
    val product = Product.Builder()
        .setName("Smartphone")
        .setDescription("Latest model with AI features")
        .setPrice(999.99)
        .setRating(4.8)
        .setCategory("Electronics")
        .build()

    println(product)
}
//The Product class has a private constructor to prevent direct instantiation.
//The Builder class inside Product provides methods (setName(), setPrice(), etc.) to set properties.
//Each method returns apply { ... }, enabling method chaining.
//The build() method constructs and returns a Product object.
//In main(), we use the Builder to create a Product in a structured way.

//Usecase
// Improves code readability for complex object creation.
// Provides flexibility by allowing optional parameters.
// Avoids multiple constructors with different argument combinations.