package com.poojasingh.tutorialkotlin.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.poojasingh.tutorialkotlin.databinding.ActivityExtensionFunctionBinding
import com.poojasingh.tutorialkotlin.util.dummyText
import com.poojasingh.tutorialkotlin.util.underline

class ExtensionFunctionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExtensionFunctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtensionFunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Put some dummy text to the text view using extension function
        binding.textView.dummyText()
        // Set a click listener for text view widget
        binding.textView.setOnClickListener{
            // Display toast message using extension function
            toast("Toast using extension function")
            //toast("TextView Width : ${it.width} pixels and Height: ${it.height} pixels")
        }
        // Underline text view text using extension function
        // This extension function exist in a separate file
        binding.textView.underline()
        // Add shadow effect to text view text
        //text_view.shadow()
    }

    // Extension function which written in calling file
    fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT){
        // Extend the Context object to show a Toast easily
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}