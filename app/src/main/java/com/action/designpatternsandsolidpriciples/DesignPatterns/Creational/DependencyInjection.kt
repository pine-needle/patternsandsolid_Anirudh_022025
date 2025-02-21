package com.action.designpatternsandsolidpriciples.DesignPatterns.Creational

// Step 1: Define a Dependency
class Engine(private val type: String) {
    fun start() = "Engine of type $type started"
}

// Step 2: Inject Dependency into the Car class
class Car(private val engine: Engine) {
    fun drive(): String {
        return engine.start() + " - Car is moving!"
    }
}

// Step 3: Manual Dependency Injection
fun main() {
    val engine = Engine("V8") // Dependency created first
    val car = Car(engine)      // Injecting dependency into Car
    println(car.drive())       // Output: Engine of type V8 started - Car is moving!
}

/*


Step 1: Add Hilt Dependencies in build.gradle

dependencies {
    implementation "com.google.dagger:hilt-android:2.50"
    kapt "com.google.dagger:hilt-compiler:2.50"
}

Step 2: Create a Dependency Module


// Hilt Module to provide Engine dependency
@Module
@InstallIn(SingletonComponent::class)
object EngineModule {
    @Provides
    @Singleton
    fun provideEngine(): Engine {
        return Engine("V8")
    }
}

Step 3: Inject Dependency into a Class

import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine) {
    fun drive(): String {
        return engine.start() + " - Car is moving!"
    }
}

Step 4:Inject into Activity

  @AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car // Hilt automatically injects the dependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(car.drive()) // Output: Engine of type V8 started - Car is moving!
    }
}


1) Removes tight coupling between objects.
 2)Improves testability (e.g., you can mock dependencies).
 3)Provides better scalability in larger applications.
 4)Follows SOLID principles (especially Dependency Inversion).

 */
