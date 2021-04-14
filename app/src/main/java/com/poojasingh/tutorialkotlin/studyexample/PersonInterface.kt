package com.poojasingh.tutorialkotlin.studyexample

interface PersonInterface {  //cannot create instance of interface
   var name: String //abstract and open by default

   // abstract fun onTouch() {} //abstract methods don't have a body

    abstract fun onTouch()  //should be compulsorily overridden by the class that implements this interface

    open fun onClick() { //public and open by default NOT final

    }
}

class Button: PersonInterface{
    override var name: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun onTouch() {
        TODO("Not yet implemented")
    }

}