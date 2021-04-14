package com.poojasingh.tutorialkotlin.studyexample

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

class CoroutineEx : Activity() {

    val TAG = this@CoroutineEx.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)
            Log.d(TAG,"User is in the Global Scope ")
            Toast.makeText(applicationContext,"User is in the Global Scope ",Toast.LENGTH_SHORT).show()
        }
        Log.d(TAG,"User is not in the Global Scope ")
        Toast.makeText(applicationContext,"User is not in the Global Scope ",Toast.LENGTH_SHORT).show()

        Log.d(TAG,"Before run-blocking")
        runBlocking {
            Log.d(TAG,"just entered into the runBlocking ")
            delay(5000)

            Log.d(TAG,"start of the run-blocking")
            Log.d(TAG,"End of the runBlocking")
        }
        Log.d(TAG,"after the run blocking")

        /**
         * It can be seen in the above log-output that both GlobalScope and launch will execute after the delay of runBlocking. As both the coroutine which are launched within runBlocking with
         * launch function will be executed within the same thread, it seems like both the coroutine are running in parallel, but it is not possible since both are running in the same thread,
         * but they are running in an asynchronous manner. So it can be said that users should use coroutine runBlocking only when the user wants to do a JUnit test or want to call only the suspend functions.
         */
        Log.d(TAG,"Before run-blocking")
        runBlocking {
            Log.d(TAG,"just entered into the runBlocking ")
            delay(5000)
            launch(Dispatchers.IO)
            {
                delay(3000L)
                Log.d(TAG,"Finished to coroutine 1")
            }

            launch(Dispatchers.IO)
            {
                delay(3000L)
                Log.d(TAG,"Finished to coroutine 2")
            }
            Log.d(TAG,"start of the run-blocking")
            Log.d(TAG,"End of the runBlocking")
        }
        Log.d(TAG,"after the run blocking")
        GlobalScope.launch {
            Log.d(TAG,"Logging in the globalScope")
        }

        runBlocking {
             // creates a BlockingCoroutine
            // this : gives CoroutineScope instance
            //coroutineContext - gives CoroutineContext instance
        }

        GlobalScope.launch {
            // creates a StandaloneCoroutine

        }

        GlobalScope.async {
            // creates a DeferredCoroutine

        }

    }
}