package com.action.designpatternsandsolidpriciples.DesignPatterns.Structural


//Create Subsystem Classes
class DVDPlayer {
    fun on() = println("DVD Player turned ON")
    fun play(movie: String) = println("Playing movie: $movie")
    fun off() = println("DVD Player turned OFF")
}

class Projector {
    fun on() = println("Projector turned ON")
    fun setInput(source: String) = println("Projector input set to $source")
    fun off() = println("Projector turned OFF")
}

class SoundSystem {
    fun on() = println("Sound System turned ON")
    fun setVolume(level: Int) = println("Volume set to $level")
    fun off() = println("Sound System turned OFF")
}

class Screen {
    fun down() = println("Screen lowered")
    fun up() = println("Screen raised")
}


//Create the Facade
class HomeTheaterFacade(
    private val dvdPlayer: DVDPlayer,
    private val projector: Projector,
    private val soundSystem: SoundSystem,
    private val screen: Screen
) {
    fun watchMovie(movie: String) {
        println("\n🎬 Starting Movie Night...\n")
        screen.down()
        projector.on()
        projector.setInput("DVD Player")
        soundSystem.on()
        soundSystem.setVolume(10)
        dvdPlayer.on()
        dvdPlayer.play(movie)
    }

    fun endMovie() {
        println("\n📽️ Shutting Down Home Theater...\n")
        dvdPlayer.off()
        soundSystem.off()
        projector.off()
        screen.up()
    }
}
  //Using Facade
fun main() {
    val dvdPlayer = DVDPlayer()
    val projector = Projector()
    val soundSystem = SoundSystem()
    val screen = Screen()

    val homeTheater = HomeTheaterFacade(dvdPlayer, projector, soundSystem, screen)

    homeTheater.watchMovie("Inception")
    homeTheater.endMovie()
}

//Instead of handling multiple objects manually, the facade simplifies the process with a single watchMovie() and endMovie() call.
/*
The subsystem classes (DVDPlayer, Projector, SoundSystem, Screen) contain individual functionalities.
The Facade (HomeTheaterFacade) provides a simplified interface by wrapping multiple subsystems.
The main() interacts with HomeTheaterFacade instead of calling each component separately.

 */