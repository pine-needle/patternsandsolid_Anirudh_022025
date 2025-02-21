package com.action.designpatternsandsolidpriciples.DesignPatterns.Structural

//Define the Component Interface
interface FileSystemComponent {
    fun showDetails(indent: String = "")  // Display structure with indentation
}


//Create Leaf Class (File)
class File(private val name: String) : FileSystemComponent {
    override fun showDetails(indent: String) {
        println("$indent File: $name")
    }
}


//Create Composite Class (Folder)
class Folder(private val name: String) : FileSystemComponent {
    private val components = mutableListOf<FileSystemComponent>()

    fun add(component: FileSystemComponent) {
        components.add(component)
    }

    fun remove(component: FileSystemComponent) {
        components.remove(component)
    }

    override fun showDetails(indent: String) {
        println("$indent Folder: $name")
        for (component in components) {
            component.showDetails(indent+ "   ")  // Increase indentation for hierarchy
        }
    }
}


//Use the Composite Structure
fun main() {
    val file1 = File("Document.pdf")
    val file2 = File("Image.png")
    val file3 = File("Music.mp3")

    val folder1 = Folder("Downloads")
    folder1.add(file1)
    folder1.add(file2)

    val folder2 = Folder("Music")
    folder2.add(file3)

    val rootFolder = Folder("Root")
    rootFolder.add(folder1)
    rootFolder.add(folder2)

    println(" File System Structure:")
    rootFolder.showDetails()
}

/*
Component Interface (FileSystemComponent): Defines common behavior for both File and Folder.
Leaf (File): Represents individual elements that do not contain children.
Composite (Folder): Contains child components (both File and other Folder objects).
Client (main()): Builds and interacts with the hierarchical structure.


Hierarchy Representation: Easily models tree structures like UI components, file systems, etc.
Uniformity: Treats individual and composite objects the same way.
Extensibility: Easily extend with more components (e.g., shortcuts, archives).


 */
