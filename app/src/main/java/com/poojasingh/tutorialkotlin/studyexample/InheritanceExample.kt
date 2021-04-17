package com.poojasingh.tutorialkotlin.studyexample

class InheritanceExample {

}

open class Animal {  // Parent class
    var name: String? = null  // Nullable variable
    var legs: Int = 0         // Non-nullable variable
    lateinit var map: HashMap<Integer, String>  // Variable inited later in the code

    constructor(legs: Int) {
        this.legs = legs
    }

    constructor(legs: Int, name: String) {
        this.legs = legs
        this.name = name
    }

    // open keyword allows the function to be overridden
    open fun speak() : String? {

        return null
    }
}

class Dog : Animal { // Child class
    var numOfLegs: Int = 0
    constructor(legs: Int) : super(legs) {
        // Optional code block
    }

    // Just a super call, without additional code block
    constructor(legs: Int, name: String) : super(legs, name)

    // Function over-ridding
    override fun speak(): String? {
        var dog: Dog = Dog(0)
// Setters
        dog.numOfLegs = 4
        dog.name = "Labrador"
// Getter
        println(dog.name)
        return "Bark! Bark!"
    }

}