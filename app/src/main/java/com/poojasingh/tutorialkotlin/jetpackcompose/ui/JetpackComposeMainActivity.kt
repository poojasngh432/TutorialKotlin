package com.poojasingh.tutorialkotlin.jetpackcompose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.poojasingh.tutorialkotlin.R

class JetpackComposeMainActivity : AppCompatActivity() {
    //1
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_compose_main)

        //2
        navigationController = findNavController(R.id.navigationHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navigationController)
    }

    //3
    override fun onSupportNavigateUp() = navigationController.navigateUp()
}