package com.poojasingh.tutorialkotlin.studyexample

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutineEx : Activity() {
    /**
     * Kotlin comes up with coroutines that help us writing asynchronous code in a synchronous manner. Android is a single thread platform. By default, everything runs on Main Thread (UI Thread) so when its time to run non-UI related operations (E.g. Network call, DB operation, File I/O operations or any time taking task), We dedicate these tasks to different threads and on completion if needed, pass back the result to UI Thread.
     */

    val TAG = this@CoroutineEx.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // For example, something like this in Main Thread.
        /**
         * Next line will get executed once the response comes.
         * You would think that calling it from main thread will block it by the time response comes.
         * Well, If you use coroutine, that would not be the case. It won’t block Main thread or any thread as a matter of fact and can still execute code in sync manner.
         */
        val response = async_operation()  //async operation
        //  if (response.isSuccessful()) doThis() else doThat()

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

    //create 10k Threads.
    fun creating_10k_Thread() {
        /**
         * Here, each thread is sleeping for 1 ms. Running this function took around 12.6 seconds.
         * If you look at the creating_10k_Thread() method, you see there is a delay of 1ms. Well, during this delay thread is blocked. In other words, it can not do anything else in that 1ms and will continue after that 1ms. Also, you can create only a certain number of threads depending upon system cores.
         */
        val time = measureTimeMillis {
            for(i in 1..10000) {
                Thread(Runnable {
                    Thread.sleep(1)
                }).run()
            }
        }
    }

    fun creatingCoroutines(){
        /**
         * Now let’s Create 100k Coroutines (10 times more), and increase the delay to 10 seconds (10000 times higher). Don’t worry about ‘runBlocking’ or ‘launch’ (Coroutine Builders) for now.
         * The thing about coroutine is that it does not block, it suspends. So while it is waiting for 10 seconds delay to be completed it can pick up any other task and resume once the delay is over. Also, coroutines are user-managed, OS does not have a say in it. which makes it even faster.
         * To put it in numbers, each thread has its own stack, typically 1MB in size. 64k is the least amount of stack space allowed per thread in the JVM while a simple coroutine in Kotlin occupies only a few dozen bytes of heap memory.
         */
        val time = measureTimeMillis {
            runBlocking {
                for(i in 1..100000) {
                    launch {
                        delay(10000L)
                    }
                }
            }
        }
    }

    fun async_operation() {

    }
}