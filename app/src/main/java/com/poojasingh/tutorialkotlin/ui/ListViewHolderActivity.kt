package com.poojasingh.tutorialkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poojasingh.tutorialkotlin.databinding.ActivityListViewHolderBinding
import com.poojasingh.tutorialkotlin.ui.adapter.ColorBaseAdapter

class ListViewHolderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get an instance of base adapter
        val adapter = ColorBaseAdapter()

        // Set the list view adapter
        binding.listView.adapter = adapter
    }
}