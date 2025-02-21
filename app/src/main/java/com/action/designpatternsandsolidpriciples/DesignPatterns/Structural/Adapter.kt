package com.action.designpatternsandsolidpriciples.DesignPatterns.Structural

// Existing interface expecting MicroUSB
interface MicroUSB {
    fun chargeWithMicroUSB()
}

// New interface that we need to adapt
interface TypeC {
    fun chargeWithTypeC()
}

// Concrete class implementing TypeC
class TypeCCharger : TypeC {
    override fun chargeWithTypeC() {
        println("Charging using Type-C charger")
    }
}

// Adapter that allows TypeC to be used as MicroUSB
class TypeCToMicroUSBAdapter(private val typeCCharger: TypeC) : MicroUSB {
    override fun chargeWithMicroUSB() {
        println("Adapter converts Type-C to MicroUSB")
        typeCCharger.chargeWithTypeC()
    }
}

fun main() {
    val typeCCharger = TypeCCharger() // Creating TypeC charger
    val adapter = TypeCToMicroUSBAdapter(typeCCharger) // Using adapter

    println("Using adapter to charge a MicroUSB device with Type-C charger:")
    adapter.chargeWithMicroUSB() // Converts Type-C to MicroUSB and charges
}

/*
The MicroUSB interface is our target interface.
The TypeC interface and TypeCCharger class represent an incompatible system.
The TypeCToMicroUSBAdapter implements MicroUSB and internally calls TypeC functions.
This allows a TypeC charger to be used where MicroUSB is expected.

 */