package com.poojasingh.tutorialkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity(), View.OnClickListener {
    //Example of data binding 1. one way  2. two way

    private lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        binding.lifecycleOwner = this

    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                binding.btnOneWay.id -> {
                    val intent = Intent(this, DataBindingActivity::class.java)
                    startActivity(intent)
                }

                binding.btnTwoWay.id -> {
                    val intent = Intent(this, ViewModelActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

}