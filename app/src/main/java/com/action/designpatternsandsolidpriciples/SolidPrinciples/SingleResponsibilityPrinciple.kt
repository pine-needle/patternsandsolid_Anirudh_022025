package com.action.designpatternsandsolidpriciples.SolidPrinciples

//Breaking SRP
class User(val name: String, val email: String) {

    fun saveUserToDatabase() {
        println("User saved to database")
    }

    fun sendWelcomeEmail() {
        println("Welcome email sent to $email")
    }
}

//Fixing SRP

class User1(val name: String, val email: String)

class UserRepository {
    fun saveUser(user: User1) {
        println("User saved to database ${user}")
    }
}

class EmailService {
    fun sendWelcomeEmail(user: User1) {
        println("Welcome email sent to ${user.email}")
    }
}
