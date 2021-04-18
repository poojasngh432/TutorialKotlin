package com.poojasingh.tutorialkotlin.ui

import android.graphics.Color
import android.os.*
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.poojasingh.tutorialkotlin.R
import java.util.*


class HandlerActivity : AppCompatActivity() {
    //to run a code on background thread using Handler
    /**
     * Remember to call handlerThread.quit() when you are done with the background thread or on your activities onDestroy() method.
     */
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

    fun startHandlerThread() {
        val handlerThread = HandlerThread("MyHandlerThread")
        handlerThread.start()
        val looper = handlerThread.looper
        val handler = Handler(looper)
//        in order to use it, you simply have to post Runnable to the Handler thread.
        handler.post {

        }
    }

    /**
     * If you have a few different tasks you would like to perform on the background thread, it may be a better idea to extend handler
     * and adding handling for different messages. Note, there is still one background thread here.
     * If you want more threads, you’ll have to create more Handlers and HandlerThreads.
     */

    fun manyHandlers() {
        val handlerThread = HandlerThread("MyHandlerThread")
        handlerThread.start()
        val looper = handlerThread.looper
        if (mHandler == null) {
            mHandler = object : Handler(looper) {
                override fun handleMessage(msg: Message) {
                    when (msg.what) {
                        1 -> {
//                            doSomething()
                        Log.d(TAG, "action one")
                        }
//                        SOMETHING_ELSE_ACTION -> doMoreThings()
                        else -> {
                            Log.d(TAG, "action two")
                        }
                    }
                }
            }
        }
        val msg: Message? = null
        mHandler.obtainMessage(1, "")
        mHandler.sendMessage(msg!!)
    }

}