package com.poojasingh.tutorialkotlin.data.remote

import android.app.Activity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutineExample : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            task1()
        }
        task2()
    }

    fun task2() {
    }

    suspend fun task1() {
        //suspend func can only be called from a coroutine or another suspenf func
    }
}