package com.action.designpatternsandsolidpriciples.DesignPatterns.Creational

// Step 1: Define an Interface (Product)
interface Vehicle {
    fun drive()
}

// Step 2: Create Concrete Classes (Implementations)
class Car1 : Vehicle {
    override fun drive() {
        println("Driving a Car")
    }
}

class Bike : Vehicle {
    override fun drive() {
        println("Riding a Bike")
    }
}

// Step 3: Create a Factory Class
class VehicleFactory {
    fun createVehicle(type: String): Vehicle {
        return when (type) {
            "Car" -> Car1()
            "Bike" -> Bike()
            else -> throw IllegalArgumentException("Unknown vehicle type")
        }
    }
}

// Step 4: Usage
fun main() {
    val factory = VehicleFactory()

    val myCar: Vehicle = factory.createVehicle("Car")
    myCar.drive() // Output: Driving a Car

    val myBike: Vehicle = factory.createVehicle("Bike")
    myBike.drive() // Output: Riding a Bike ️
}

/*
Factory Pattern with Dependency Injection

Step 1:Define the Factory and Products


// Vehicle Interface
interface Vehicle {
    fun drive(): String
}

// Concrete Classes
class Car @Inject constructor() : Vehicle {
    override fun drive() = "Driving a Car "
}

class Bike @Inject constructor() : Vehicle {
    override fun drive() = "Riding a Bike "
}

// Factory Interface
interface VehicleFactory {
    fun createVehicle(type: String): Vehicle
}

// Factory Implementation
class VehicleFactoryImpl @Inject constructor(
    private val car: Car,
    private val bike: Bike
) : VehicleFactory {
    override fun createVehicle(type: String): Vehicle {
        return when (type) {
            "Car" -> car
            "Bike" -> bike
            else -> throw IllegalArgumentException("Unknown vehicle type")
        }
    }
}

// Hilt Module to Provide Dependencies
@Module
@InstallIn(SingletonComponent::class)
object VehicleModule {
    @Provides
    @Singleton
    fun provideVehicleFactory(car: Car, bike: Bike): VehicleFactory {
        return VehicleFactoryImpl(car, bike)
    }
}



 Step 2: Inject Factory into an Activity

 @AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vehicleFactory: VehicleFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val car = vehicleFactory.createVehicle("Car")
        val bike = vehicleFactory.createVehicle("Bike")

        println(car.drive())  // Output: Driving a Car
        println(bike.drive()) // Output: Riding a Bike
    }
}


 */
