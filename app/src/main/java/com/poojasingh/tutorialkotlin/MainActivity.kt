package com.poojasingh.tutorialkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.poojasingh.tutorialkotlin.databinding.ActivityMainBinding
import com.poojasingh.tutorialkotlin.ui.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        binding.dataBindingBtn.setOnClickListener(this)
        binding.viewmodelBtn.setOnClickListener(this)
        binding.clExampleBtn.setOnClickListener(this)
        binding.serviceBtn.setOnClickListener(this)
        binding.handlerBtn.setOnClickListener(this)
        binding.asynctaskBtn.setOnClickListener(this)
        binding.broadcastBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                binding.dataBindingBtn.id -> {
                    val intent = Intent(this, DataBindingActivity::class.java)
                    startActivity(intent)
                }
                binding.viewmodelBtn.id -> {
                    val intent = Intent(this, ViewModelActivity::class.java)
                    startActivity(intent)
                }
                binding.clExampleBtn.id -> {
                    val intent = Intent(this, ConstraintLayoutExampleActivity::class.java)
                    startActivity(intent)
                }
                binding.serviceBtn.id -> {
                    val intent = Intent(this, ServiceActivity::class.java)
                    startActivity(intent)
                }
                binding.handlerBtn.id -> {
                    val intent = Intent(this, HandlerActivity::class.java)
                    startActivity(intent)
                }
                binding.asynctaskBtn.id -> {
                    val intent = Intent(this, AsyncTaskActivity::class.java)
                    startActivity(intent)
                }
                binding.broadcastBtn.id -> {
                    val intent = Intent(this, ReceiverActivity::class.java)
                    startActivity(intent)
                }
                /*binding.dataBindingBtn.id -> {
                    val intent = Intent(this, DataBindingActivity::class.java)
                    startActivity(intent)
                }
                binding.viewmodelBtn.id -> {
                    val intent = Intent(this, ViewModelActivity::class.java)
                    startActivity(intent)
                }
                binding.clExampleBtn.id -> {
                    val intent = Intent(this, ConstraintLayoutExampleActivity::class.java)
                    startActivity(intent)
                }
                binding.serviceBtn.id -> {
                    val intent = Intent(this, ServiceActivity::class.java)
                    startActivity(intent)
                }
                binding.serviceBtn.id -> {
                    val intent = Intent(this, HandlerActivity::class.java)
                    startActivity(intent)
                }
                binding.asynctaskBtn.id -> {
                    val intent = Intent(this, AsyncTaskActivity::class.java)
                    startActivity(intent)
                }
                binding.broadcastBtn.id -> {
                    val intent = Intent(this, ReceiverActivity::class.java)
                    startActivity(intent)
                }*/
            }
        }
    }


}