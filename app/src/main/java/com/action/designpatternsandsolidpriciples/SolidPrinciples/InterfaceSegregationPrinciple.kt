package com.action.designpatternsandsolidpriciples.SolidPrinciples

//Breaking ISP
interface Worker {
    fun work()
    fun eat()
}

class Developer : Worker {
    override fun work() {
        println("Developer is coding")
    }

    override fun eat() {
        println("Developer is eating")
    }
}

class Robot : Worker {
    override fun work() {
        println("Robot is working")
    }

    override fun eat() {
        throw UnsupportedOperationException("Robots don’t eat")
    }
}

//Fixing ISP

interface Workable {
    fun work()
}

interface Eatable {
    fun eat()
}

class Developer1 : Workable, Eatable {
    override fun work() {
        println("Developer is coding")
    }

    override fun eat() {
        println("Developer is eating")
    }
}

class Robot1 : Workable {
    override fun work() {
        println("Robot is working")
    }
}
