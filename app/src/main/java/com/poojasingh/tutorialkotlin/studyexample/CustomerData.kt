package com.poojasingh.tutorialkotlin.studyexample

import android.app.Activity
import android.os.Bundle

class CustomerData {
    var count:Int = -1

    fun typeOfCustomers(): String {
        return "Indian"
    }
}

object Customer {
    var count:Int = -1

    fun typeOfCustomers(): String {
        return "Indian"
    }
}

class SingletonExample: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var customerData = CustomerData()
        customerData.count = 98
        customerData.typeOfCustomers()

        //cannot create the instance of singleton class. it's done automatically
        Customer.count
        Customer.typeOfCustomers()
    }
}

//Inheritance
open class SuperCustomerData {

    open fun myMethod(): String {
        return "Indian"
    }
}

object ChildCustomerData : SuperCustomerData() {
    var count:Int = -1

    fun typeOfCustomers(): String {
        return "Indian"
    }

    override fun myMethod(): String {
        return super.myMethod()
    }
}