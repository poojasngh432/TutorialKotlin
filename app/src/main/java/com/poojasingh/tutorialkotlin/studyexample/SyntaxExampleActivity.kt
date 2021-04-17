package com.poojasingh.tutorialkotlin.studyexample

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poojasingh.tutorialkotlin.data.model.Data
import com.poojasingh.tutorialkotlin.data.model.Items
import com.poojasingh.tutorialkotlin.data.model.Repo
import java.util.*
import kotlin.collections.ArrayList

class SyntaxExampleActivity : AppCompatActivity() {
    //Define a static variable using companion object
    companion object {
        const val DEFAULT_NUM_OF_EYES = 2

        //A static function
        fun getOddLengthString(str: String): String? {
            if (str.length % 2 == 0) return null

            return str
        }
    }

    var myString: String? = null
    lateinit var item: Items //Initialise later
    lateinit var items: List<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Static
        var numOfEyes = SyntaxExampleActivity.DEFAULT_NUM_OF_EYES
        var str: String? = SyntaxExampleActivity.getOddLengthString("heyy")

        //Loops
        var list: List<String> = ArrayList<String>()
        for (item in list) {
            //do something
        }
        for (index in items.indices) {
            // access items using index
            // items.get(index)
        }
//      A while loop in Kotlin is same as a while in Java. Nothing new there :)
        var i: Int = 0
        do {
            i++
        } while (i < 5)
//      Another while loop
        while (i < 10) {
            i++
        }

        Singleton.name
        Singleton.printName()

        var obj: String? = null
        // Type Casts
//    To check if a an object is an instance of a particular class we use the “is” and “!is” operator.
        if (obj is String) {
            print(obj.length)
        }

        if (obj !is String) {
            print("Not a String")
        }

//        To avoid an exception being thrown, one can use a safe cast operator “as?” that returns null on failure. This is what is called safe typecast in Kotlin.
        val y = ""
        val x: String? = y as? String
        //In this case, if there is a failure in type casting, null is returned and throwing an exception is avoided.

        //Exception Handling
        throw Exception("Hi There!")
        try {
            // some code
        }
        catch (e: java.lang.Exception) {
            // handler
        }
        finally {
            // optional finally block
        }
    }

    fun nullPointerHandling() {
        /**
         * “?.” is known as the safe call operator and the above example show it can be used in chains.
         * This helps us write clean, simple code and avoid NPE at the same time.
         */
        var repo: Data? = null
        // If either `repo` or `repo?.advisory` is null, the function is not called:
        repo?.advisory?.title = SyntaxExampleActivity.getOddLengthString("heyy").toString()
        /**
         * In case, you want to handle a scenario where the object is null,
         * you can use the “?:” a.k.a the Elvis operator.
         */
        var name = repo?.advisory?.title ?: throw Exception("Person cannot be null.")

    }

    //    Kotlin uses when keyword to switch between multiple conditions and its so much more powerful and concise.
    fun describe(obj: Any): String? {
        var res: String? = null

        when (obj) {
            1 -> {
                res = "One"
            }         // if obj == 1
            "Hello" -> res = "Greeting"  // if obj == "Hello"
            is Long -> "Long"            // if obj is of type Long
            !is String -> "Not string"   // if obj is not of type String
            else -> {
                // execute this block of code
            }
        }

        return res
    }

    fun getNumber(): Int {  // Visibility is by default public
        return 1
    }

    //a private function with multiple parameters.
    private fun getStringLength(str1: String, str2: String): Int {
        return str1.length + str2.length
    }

    //Classes
    /**
     * The “open” keyword specifies that the class can be inherited.
     * A class that is not “open”, is as good as a final class in Java.
     */
    open class Animal {
        // This class is open and
        // can be inherited
    }

    class Dog : Animal() {  // Notice the paranthesis
        // Class dog is final and
        // can't be inherited
    }
    // Compiler throws error
//    class Labrador : Dog {
//
//    }

    //Singleton
    /**
     * The Singleton pattern in Kotlin is implemented using the “object” keyword.
     */
    object Singleton {
        var name: String = "singleton object"

        fun printName() {
            println(name)
        }
    }

    //Interfaces
    interface Named {
        fun bar()
    }

    interface Person : Named { // Person inherits Named
        fun foo()
    }

    class Employee() : Person {
        override fun bar() {
            // do something
        }

        override fun foo() {
            // do something
        }
    }

    //Inheriting an interface is pretty straightforward.
    // But passing an interface to function is a bit different.
    // A function that accepts and interface as a parameter
    private fun setEventListener(listener: EventListener) {
        // do something
    }
// Passing an interface to the function
   /* setEventListener(object : EventListener{
        override fun call() {
            // do something
        }
    })*/

}