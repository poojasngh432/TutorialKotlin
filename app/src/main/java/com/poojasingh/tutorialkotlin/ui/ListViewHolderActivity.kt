package com.poojasingh.tutorialkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.ui.adapter.ColorBaseAdapter
import kotlinx.android.synthetic.main.activity_list_view_holder.*

class ListViewHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_holder)

        // Get an instance of base adapter
        val adapter = ColorBaseAdapter()

        // Set the list view adapter
        list_view.adapter = adapter
    }
}