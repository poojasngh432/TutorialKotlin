package com.poojasingh.tutorialkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.poojasingh.tutorialkotlin.ui.ConstraintLayoutExampleActivity
import com.poojasingh.tutorialkotlin.databinding.ActivityTutorialsMainBinding
import com.poojasingh.tutorialkotlin.ui.*

class TutorialsMainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityTutorialsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialsMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

       setOnClickListeners()

    }

    private fun setOnClickListeners() {

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
                binding.listviewViewholderBtn.id -> {
                    val intent = Intent(this, ListViewHolderActivity::class.java)
                    startActivity(intent)
                }
                binding.extensionFunctionBtn.id -> {
                    val intent = Intent(this, ExtensionFunctionActivity::class.java)
                    startActivity(intent)
                }
                binding.permissionsBtn.id -> {
                    val intent = Intent(this, PermissionsActivity::class.java)
                    startActivity(intent)
                }
                binding.webviewBtn.id -> {
                    val intent = Intent(this, WebViewActivity::class.java)
                    startActivity(intent)
                }
                binding.newsBtn.id -> {
                    val intent = Intent(this, NewsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }


}