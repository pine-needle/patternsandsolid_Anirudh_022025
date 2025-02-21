package com.action.designpatternsandsolidpriciples.SolidPrinciples

//Breaking LSP
open class Car {
    open fun refuel() {
        println("Car is refueling")
    }
}

class ElectricCar : Car() {
    override fun refuel() {
        throw UnsupportedOperationException("Electric cars don’t use fuel")
    }
}

//Fixing LSP
abstract class Vehicle {
    abstract fun start()
}

abstract class FuelVehicle : Vehicle() {
    abstract fun refuel()
}

abstract class ElectricVehicle : Vehicle() {
    abstract fun chargeBattery()
}

class PetrolCar : FuelVehicle() {
    override fun start() {
        println("Petrol Car started")
    }

    override fun refuel() {
        println("Petrol Car refueled")
    }
}

class ElectricCar1 : ElectricVehicle() {
    override fun start() {
        println("Electric Car started")
    }

    override fun chargeBattery() {
        println("Electric Car battery charged")
    }
}

