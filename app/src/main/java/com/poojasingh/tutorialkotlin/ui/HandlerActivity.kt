package com.poojasingh.tutorialkotlin.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.service.IntentServiceExample
import java.util.*

class HandlerActivity : AppCompatActivity() {
    //to run a code on background thread using Handler
    var backgroundHandler: Handler? = null
    private val TAG = "HandlerActivity"
    private lateinit var mRandom: Random
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private lateinit var root_layout: ConstraintLayout
    private lateinit var text_view: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        root_layout = findViewById(R.id.root_layout)
        text_view = findViewById(R.id.text_view)

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

    fun startQueueTaskHandler(view: View) {
        // Initialize a new Random instance
        mRandom = Random()
        // Initialize the handler instance
        mHandler = Handler()

            mRunnable = Runnable {
                // Do something here
                root_layout.setBackgroundColor(randomHSVColor())
                text_view.text = "Handler Example\n" + "Random Number : ${mRandom.nextInt(100)}"

                // Schedule the task to repeat after 1 second
                mHandler.postDelayed(
                    mRunnable, // Runnable
                    1000 // Delay in milliseconds
                )
            }

            // Schedule the task to repeat after 1 second
            mHandler.postDelayed(
                mRunnable, // Runnable
                1000 // Delay in milliseconds
            )

        // Set a click listener for stop button
//        button_stop.setOnClickListener{
//            // Stop the periodic task
//            mHandler.removeCallbacks(mRunnable)
//
//            // Change the text view text
//            text_view.text = "Handler call backs removed."
//        }

        // Set a click listener for handler short code form button
       /* button_short.setOnClickListener{
            mHandler.postDelayed({
                // Change text view text
                text_view.text = "Handler Short Code\n" + "Random Number : ${mRandom.nextInt(100)}"

                // Change the text view text color
                text_view.setTextColor(randomHSVColor())

                // Change layout background color
                root_layout.setBackgroundColor(Color.WHITE)
            }, 3000) // 3 seconds delay task execution

        }*/
    }

    // Custom method to generate random HSV color
    fun randomHSVColor(): Int {
        // Generate a random hue value between 0 to 360
        val hue = mRandom.nextInt(361)
        // We make the color depth full
        val saturation = 1.0f
        // We make a full bright color
        val value = 1.0f
        // We avoid color transparency
        val alpha = 255
        // Finally, generate the color
        // Return the color
        return Color.HSVToColor(alpha, floatArrayOf(hue.toFloat(), saturation, value))
    }

}