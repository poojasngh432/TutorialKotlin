package com.poojasingh.tutorialkotlin.util

import android.graphics.Color
import android.graphics.Paint
import android.widget.TextView

// Extension function to extend TextView functionality
// Function make text view text to underlined
fun TextView.underline(){
    /*
        Keyword 'this' represent the object/widget which functionality
        we want to extend. In this function 'this' represent the 'TextView'
     */
    this.paintFlags = this.paintFlags or Paint.UNDERLINE_TEXT_FLAG;
}

// Get the text view width in pixels
fun TextView.width():Int{
    this.measure(0,0)
    return this.measuredWidth
}

// Get the text view height in pixels
fun TextView.height():Int{
    this.measure(0,0)
    return this.measuredHeight
}

// Add shadow to text view text
fun TextView.shadow(){
    this.setShadowLayer(
        1.3f, // radius
        4.0f, // dx
        4.0f, // dy
        Color.parseColor("#FF2B2B2B") // shadow color
    )
}

// Put some dummy text to text view
fun TextView.dummyText(){
    this.text = "Lorem Ipsum is simply dummy text of the printing and" +
            " typesetting industry. Lorem Ipsum has been the industry's" +
            " standard dummy text ever since the 1500s, when an unknown" +
            " printer took a galley of type and scrambled" +
            " it to make a type specimen book."
}