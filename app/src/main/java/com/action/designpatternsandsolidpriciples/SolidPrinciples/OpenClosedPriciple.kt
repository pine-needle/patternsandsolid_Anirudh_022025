package com.action.designpatternsandsolidpriciples.SolidPrinciples

//Breaking OCP
class DiscountCalculator {
    fun calculateDiscount(type: String, price: Double): Double {
        return when (type) {
            "Standard" -> price * 0.9
            "Premium" -> price * 0.8
            else -> price
        }
    }
}

//Fixing OCP
interface DiscountStrategy {
    fun applyDiscount(price: Double): Double
}

class StandardDiscount : DiscountStrategy {
    override fun applyDiscount(price: Double) = price * 0.9
}

class PremiumDiscount : DiscountStrategy {
    override fun applyDiscount(price: Double) = price * 0.8
}

class DiscountCalculator1 {
    fun calculate(price: Double, discountStrategy: DiscountStrategy): Double {
        return discountStrategy.applyDiscount(price)
    }
}


