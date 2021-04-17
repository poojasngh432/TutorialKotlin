package com.poojasingh.tutorialkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.transition.TransitionManager
import com.poojasingh.tutorialkotlin.R
import kotlinx.android.synthetic.main.activity_text_view.*

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        // Button click listener
        btnSignin.setOnClickListener {
            if (isValidForm()){
                Toast.makeText(this,"Login success", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Custom method to validate form inputted data
    private fun isValidForm() : Boolean {
        var isValid = true
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        TransitionManager.beginDelayedTransition(rootLayout)
        if (!email.isValidEmail()) {
            layoutEmail.isErrorEnabled = true
            layoutEmail.error = "input your email"
            isValid = false
        } else {
            layoutEmail.isErrorEnabled = false
        }

        if(password.isNullOrEmpty()) {
            layoutPassword.isErrorEnabled = true
            layoutPassword.error = "Input password"
            isValid = false
        } else {
            layoutPassword.isErrorEnabled = false
        }

        return isValid
    }
}

// Extension function to validate email address
fun String.isValidEmail(): Boolean = !this.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()