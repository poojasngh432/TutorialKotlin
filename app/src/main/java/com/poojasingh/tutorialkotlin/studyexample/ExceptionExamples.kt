package com.poojasingh.tutorialkotlin.studyexample

import android.app.Activity
import android.os.Bundle

class ExceptionExamples : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val age = 26
        if(age < 30){
            throw Exception("Age is less than 30")  //Throwing a n exception
        }
        //throwing custom exception
        if(age < 30){
            throw MyAgeException(age)  //Throwing a n exception
        }
    }

}

class MyAgeException(val age: Int) : Exception("$age is not valid")