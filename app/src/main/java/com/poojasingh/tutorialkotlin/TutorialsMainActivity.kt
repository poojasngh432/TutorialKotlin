package com.poojasingh.tutorialkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.poojasingh.tutorialkotlin.databinding.ActivityTutorialsMainBinding
import com.poojasingh.tutorialkotlin.jetpackcompose.ui.JetpackComposeMainActivity
import com.poojasingh.tutorialkotlin.rxExample.RxJavaExamplesActivity
import com.poojasingh.tutorialkotlin.ui.*

class TutorialsMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

       setOnClickListeners()

    }

    private fun setOnClickListeners() {
        binding.dataBindingBtn.setOnClickListener {
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        }
        binding.viewmodelBtn.setOnClickListener {
            val intent = Intent(this, ViewModelActivity::class.java)
            startActivity(intent)
        }
        binding.jetpackComposeBtn.setOnClickListener {
            val intent = Intent(this, JetpackComposeMainActivity::class.java)
            startActivity(intent)
        }
        binding.serviceBtn.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
        binding.handlerBtn.setOnClickListener {
            val intent = Intent(this, HandlerActivity::class.java)
            startActivity(intent)
        }
        binding.asynctaskBtn.setOnClickListener {
            val intent = Intent(this, AsyncTaskActivity::class.java)
            startActivity(intent)
        }
        binding.broadcastBtn.setOnClickListener {
            val intent = Intent(this, ReceiverActivity::class.java)
            startActivity(intent)
        }
        binding.listviewViewholderBtn.setOnClickListener {
            val intent = Intent(this, ListViewHolderActivity::class.java)
            startActivity(intent)
        }
        binding.extensionFunctionBtn.setOnClickListener {
            val intent = Intent(this, ExtensionFunctionActivity::class.java)
            startActivity(intent)
        }
        binding.permissionsBtn.setOnClickListener {
            val intent = Intent(this, PermissionsActivity::class.java)
            startActivity(intent)
        }
        binding.webviewBtn.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
        binding.newsBtn.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
        binding.rxJavaExamples.setOnClickListener {
            val intent = Intent(this, RxJavaExamplesActivity::class.java)
            startActivity(intent)
        }
        binding.newsBtn.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
    }

}