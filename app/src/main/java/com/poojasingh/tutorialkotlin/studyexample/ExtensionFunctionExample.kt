package com.poojasingh.tutorialkotlin.studyexample

import android.app.Activity
import android.os.Bundle

class ExtensionFunctionExample : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val str1: String = "Hello "
        val str2: String = "World"

        var str3: String = "Hey "

        str3.add(str1,str2)

    }
}

//add fun will now work as the part of String class
fun String.add(s1: String, s2: String): String {
    return this + s1 + s2
}