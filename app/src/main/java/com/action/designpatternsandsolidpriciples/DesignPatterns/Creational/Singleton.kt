package com.action.designpatternsandsolidpriciples.DesignPatterns.Creational

/*

object automatically ensures single instance.
Thread-safe by default in Kotlin.
No need for manual instance creation.

 */

// Singleton object
object Database {
    init {
        println("Database Initialized")
    }

    fun query(sql: String) {
        println("Executing Query: $sql")
    }
}

fun main() {
    // Using Singleton instance
    Database.query("SELECT * FROM users")
    Database.query("SELECT * FROM orders")
}


/*
Singleton with Lazy Initialization (Traditional Approach)
If you need a lazy-loaded Singleton, use companion object or lazy

class Logger private constructor() {
    init {
        println("Logger Initialized")
    }

    fun log(message: String) {
        println("Log: $message")
    }

    companion object {
        @Volatile
        private var instance: Logger? = null

        fun getInstance(): Logger {
            return instance ?: synchronized(this) {
                instance ?: Logger().also { instance = it }
            }
        }
    }
}

fun main() {
    val logger1 = Logger.getInstance()
    val logger2 = Logger.getInstance()

    logger1.log("Application started")
    logger2.log("User logged in")

    println(logger1 === logger2) // true (Same instance)
}


Uses @Volatile and synchronized to ensure thread safety.
Initializes only when first accessed.
Uses double-checked locking for performance.

Method 3:

   Step 1)      Add Hilt Dependencies in build.gradle

dependencies {
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-compiler:2.51")
    }

    Step 2) Create a Singleton Dependency

    // Singleton instance provided by Hilt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(): Database {
        return Database()
    }
}

    Step 3) Inject Singleton into a Class


@Singleton
class Database @Inject constructor() {
    fun query(sql: String) {
        println("Executing Query: $sql")
    }
}
   Step 4) Inject into Activity (Android)

   @AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var database: Database // Singleton instance injected

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database.query("SELECT * FROM users")
    }
}

1_Hilt manages Singleton lifecycle.
2_No need to manually instantiate the object.
3_Works well in multi-threaded environments.



 */