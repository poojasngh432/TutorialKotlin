package com.poojasingh.tutorialkotlin.service

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder
import android.util.Log
import java.lang.Exception

class ServiceAsyncExample : Service() {
    private val TAG = "ServiceAsyncExample"
    // In order to bind an application component with a service bindService() method is used.

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service onStartCommand " + startId)
        val task = SrvTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, startId)
        return Service.START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "Service onBind")
        return null
    }

    override fun onDestroy() {
        Log.d(TAG, "Service onDestroy")
    }

    private inner class SrvTask : AsyncTask<Int, Int, String>() {

        override fun onPreExecute() {

        }

        override fun doInBackground(vararg params: Int?): String {
            Log.d(TAG, "Service AsyncTask doInBackground()")
            val startId = params[0]
            var i = 0
            while (i <= 5) {
                try {
                    Thread.sleep(1000)
                    publishProgress(startId)
                    i++
                }
                catch (e: Exception) {
                    return(e.localizedMessage)
                }
            }
            return "Service complete $startId"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val counter = values.get(0)
            Log.d(TAG, "Service Running onProgressUpdate() $counter")
        }

        override fun onPostExecute(result: String) {
            Log.d(TAG, "Service AsyncTask onPostExecute() " + result)
        }
    }

}