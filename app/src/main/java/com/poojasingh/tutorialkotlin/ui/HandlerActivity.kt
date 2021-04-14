package com.poojasingh.tutorialkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.service.IntentServiceExample

class HandlerActivity : AppCompatActivity() {
    //to run a code on background thread using Handler
    var backgroundHandler: Handler? = null
    private val TAG = "HandlerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        //Creating a background Thread
        val backgroundThread = Thread {
            // Creating a Looper for this thread
            Looper.prepare()
            //Looper.myLooper() gives you Looper for current thread
            val myLooper = Looper.myLooper()!!
            //Creating a Handler for given Looper object
            backgroundHandler = Handler(myLooper, object : Handler.Callback {
                override fun handleMessage(msg: Message): Boolean {
                    //Receiving extras from Message
                    val bundle: Bundle? = msg!!.data
                    Log.d(TAG, "Handler:: Extras: ${bundle}")
                    Log.d(TAG, "Handler:: Background Thread ID ${Thread.currentThread().id}")
                    //myLooper.quit()
                    return true
                }
            })
            Looper.loop()
        }
        backgroundThread.start()

    }

    fun onButtonClick(view: View) {
        Log.d(TAG, "Handler:: UI Thread ID ${Thread.currentThread().id}")
        //Executing code on backgroundThread using Handler.
        backgroundHandler!!.post {
            //Here, you'll note that Thread's ID is of backgroundThread.
            Log.d(TAG, "Handler:: Background Thread ID ${Thread.currentThread().id}")
        }

        //Now, sending data on backgroundThread using Message object. Handler's handleMessage(msg: Message?) method will receive this Message and perform appropriate action.
        val extras = Bundle()
        extras.putInt("PRICE", 100)
        extras.putString("PRODUCT_NAME", "Table Lamp")

        val message = Message.obtain(backgroundHandler)
        message.data = extras

        backgroundHandler?.sendMessage(message)
    }
}