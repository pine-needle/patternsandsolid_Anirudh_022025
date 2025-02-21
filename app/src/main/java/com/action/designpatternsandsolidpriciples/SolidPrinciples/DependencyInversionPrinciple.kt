package com.action.designpatternsandsolidpriciples.SolidPrinciples

//Breaking DIP

class MySQLDatabase {
    fun saveOrder() {
        println("Order saved to MySQL")
    }
}

class OrderProcessor {
    private val database = MySQLDatabase()

    fun processOrder() {
        database.saveOrder()
    }
}
//Here,OrderProcessor directly depends on MySQLDatabase, making it tightly coupled.
//If we change the database (e.g., to Firebase), we need to modify OrderProcessor

//Fixing DIP
interface Database {
    fun saveOrder()
}

class MySQLDatabase1 : Database {
    override fun saveOrder() {
        println("Order saved to MySQL")
    }
}

class FirebaseDatabase : Database {
    override fun saveOrder() {
        println("Order saved to Firebase")
    }
}

class OrderProcessor1(private val database: Database) {
    fun processOrder() {
        database.saveOrder()
    }
}

//OrderProcessor depends on an abstraction (Database), not a concrete class.
//Easily switch databases (MySQL, Firebase, etc.) without modifying OrderProcessor.
