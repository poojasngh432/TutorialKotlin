package com.poojasingh.tutorialkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.poojasingh.tutorialkotlin.R

class ViewExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_example)
    }

    fun onButtonClick(view: View) {
        if(view.id == R.id.textinputlayout_btn) {
            val intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)
        }
    }

}